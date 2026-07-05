/*
 * Line-oriented Markdown layout for the Obsidian Book, supporting an Obsidian
 * "Live Preview" hybrid: every source line is rendered formatted; the line the
 * caret is on is also formatted but reveals its markdown syntax (dim markers,
 * headings stay big) with an exact caret. Pure and side-effect free (no OpenGL)
 * so it can be unit-tested headless.
 *
 * Supported per line: # headings (1-6), - / * / + bullets, 1. ordered,
 * - [ ] / - [x] checkboxes, > quotes, --- rules, ``` fenced code, and inline
 * **bold**, *italic*, `code`, ~~strike~~, ==highlight==, #tags, [text](url),
 * bare http(s) links. Long words/links are hard-wrapped so nothing overflows.
 */
package net.minecraft.client.c;

import java.util.ArrayList;
import java.util.List;

public final class BookLayout {

    public interface Metrics {
        int width(String s); // pixel width at scale 1 (e.g. FontRenderer::a)
    }

    /** A draw op: styled text (text != null) or a filled rectangle. */
    public static final class Span {
        public final String text;
        public final int x, y, w, h;
        public final float scale;
        public final boolean bold, italic;
        public final int color;
        public final int layer; // rect layer: 0 = below text, 1 = above text
        Span(String text, int x, int y, float scale, boolean bold, boolean italic, int color) {
            this.text = text; this.x = x; this.y = y; this.scale = scale;
            this.bold = bold; this.italic = italic; this.color = color; this.w = 0; this.h = 0; this.layer = 0;
        }
        Span(int x, int y, int w, int h, int color) { this(x, y, w, h, color, 0); }
        Span(int x, int y, int w, int h, int color, int layer) {
            this.text = null; this.x = x; this.y = y; this.w = w; this.h = h; this.color = color;
            this.scale = 1f; this.bold = false; this.italic = false; this.layer = layer;
        }
    }

    public static final class Link {
        public final int x, y, w, h;
        public final String url;
        Link(int x, int y, int w, int h, String url) { this.x = x; this.y = y; this.w = w; this.h = h; this.url = url; }
    }

    /** A checkbox glyph; lineStart is the char index of the "[" so a click can toggle it. */
    public static final class Check {
        public final int x, y, size, markIndex;
        public final boolean checked;
        Check(int x, int y, int size, boolean checked, int markIndex) {
            this.x = x; this.y = y; this.size = size; this.checked = checked; this.markIndex = markIndex;
        }
    }

    /** Maps a source line's char range [start,end) to its vertical [top,bottom). */
    public static final class LineBox {
        public final int start, end, top, bottom;
        LineBox(int start, int end, int top, int bottom) { this.start = start; this.end = end; this.top = top; this.bottom = bottom; }
    }

    public final List<Span> spans = new ArrayList<Span>();
    public final List<Link> links = new ArrayList<Link>();
    public final List<Check> checks = new ArrayList<Check>();
    public final List<LineBox> lines = new ArrayList<LineBox>();
    public int caretX = -1, caretY = -1, caretH = 8;
    public int totalHeight;

    // Colours for the light parchment page.
    static final int TEXT      = 0x000000;
    static final int HEADING   = 0x552200;
    static final int LINK      = 0x1515AA;
    static final int CODE      = 0x555555;
    static final int CODEBG    = 0x22000000;
    static final int QUOTE     = 0x5A5A5A;
    static final int RULE      = 0x9A9A9A;
    static final int TAG       = 0x116644;
    static final int HL_BG     = 0x66E9D93A; // translucent yellow
    static final int CHECK_ON  = 0x117711;

    static final float[] H_SCALE = {1.7f, 1.5f, 1.3f, 1.2f, 1.1f, 1.05f};

    static final int SEL_BG = 0x663A6EA5; // translucent blue selection

    private final int width;
    private final Metrics m;
    private int y = 0;
    private int selStart = -1, selEnd = -1;

    private BookLayout(int width, Metrics m) { this.width = width; this.m = m; }

    public static BookLayout build(String text, int cursorPos, int width, Metrics m, boolean reading) {
        return build(text, cursorPos, -1, -1, width, m, reading);
    }

    public static BookLayout build(String text, int cursorPos, int selStart, int selEnd, int width, Metrics m, boolean reading) {
        BookLayout bl = new BookLayout(width, m);
        bl.selStart = selStart;
        bl.selEnd = selEnd;
        try {
            bl.run(text == null ? "" : text, reading ? -1 : cursorPos);
        } catch (Throwable t) {
            bl.spans.clear();
            bl.spans.add(new Span(text == null ? "" : text, 0, 0, 1f, false, false, TEXT));
        }
        bl.totalHeight = bl.y;
        return bl;
    }

    private void run(String text, int cursorPos) {
        // split into source lines, tracking char offsets
        List<int[]> ranges = new ArrayList<int[]>(); // {start, end}
        int start = 0;
        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || text.charAt(i) == '\n') {
                ranges.add(new int[]{start, i});
                start = i + 1;
            }
        }
        int cursorLine = -1;
        if (cursorPos >= 0) {
            for (int i = 0; i < ranges.size(); i++) {
                if (cursorPos >= ranges.get(i)[0] && cursorPos <= ranges.get(i)[1]) { cursorLine = i; break; }
            }
            if (cursorLine < 0) cursorLine = ranges.size() - 1;
        }
        boolean selActive = selStart >= 0 && selEnd > selStart;
        boolean inFence = false;
        for (int i = 0; i < ranges.size(); i++) {
            int ls = ranges.get(i)[0], le = ranges.get(i)[1];
            String line = text.substring(ls, le);
            int top = y;
            boolean fenceToggle = line.trim().startsWith("```");
            if (i == cursorLine) {
                revealLine(line, cursorPos - ls, ls);
                if (fenceToggle) inFence = !inFence;
            } else if (selActive) {
                // while selecting, show every line raw so the highlight aligns exactly
                revealLine(line, -1, ls);
                if (fenceToggle) inFence = !inFence;
            } else if (fenceToggle) {
                inFence = !inFence; // hide the ``` fence marker line in preview
            } else if (inFence) {
                codeLine(line);
            } else {
                formattedLine(line, ls);
            }
            lines.add(new LineBox(ls, le, top, y));
        }
    }

    // ---- caret line: Obsidian-style reveal (formatting kept, markers visible) ----

    static final int F_BOLD = 1, F_ITALIC = 2, F_STRIKE = 4, F_HL = 8, F_CODE = 16, F_DIM = 32;

    private void revealLine(String line, int caretCol, int lineAbsStart) {
        boolean drawCaret = caretCol >= 0;
        // block scale: a heading line stays big while its # markers are shown
        int ind = 0;
        while (ind < line.length() && line.charAt(ind) == ' ') ind++;
        String body = line.substring(ind);
        int h = 0;
        while (h < body.length() && body.charAt(h) == '#') h++;
        boolean heading = h >= 1 && h <= 6 && h < body.length() && body.charAt(h) == ' ';
        float scale = heading ? H_SCALE[h - 1] : 1f;
        int baseColor = heading ? HEADING : TEXT;

        int[] flags = styleLine(line);
        List<int[]> rows = wrapRows(line, scale);
        if (rows.isEmpty()) rows.add(new int[]{0, 0});
        if (caretCol < 0) caretCol = 0;
        int lineH = (int) (10 * scale) + 1;
        for (int[] row : rows) {
            int rs = row[0], re = row[1];
            // selection highlight for this row (exact — the row is raw text)
            if (selStart >= 0 && selEnd > selStart) {
                int rowA = lineAbsStart + rs, rowB = lineAbsStart + re;
                int a = Math.max(selStart, rowA), bsel = Math.min(selEnd, rowB);
                if (bsel >= a) {
                    int x0 = (int) (m.width(line.substring(rs, a - lineAbsStart)) * scale);
                    int x1 = (int) (m.width(line.substring(rs, bsel - lineAbsStart)) * scale);
                    if (selEnd > rowB) x1 += 3; // selection spans the newline
                    spans.add(new Span(x0, y - 1, Math.max(1, x1 - x0), lineH, SEL_BG));
                }
            }
            int x = 0;
            int i = rs;
            while (i < re) {
                int f = flags[i];
                int j = i;
                while (j < re && flags[j] == f) j++;
                String seg = line.substring(i, j);
                int segW = (int) (m.width(seg) * scale);
                int color = (f & F_DIM) != 0 ? RULE : (f & F_CODE) != 0 ? CODE : baseColor;
                if ((f & F_HL) != 0) spans.add(new Span(x - 1, y - 1, segW + 2, (int) (9 * scale) + 2, HL_BG));
                spans.add(new Span(seg, x, y, scale, (f & F_BOLD) != 0, (f & F_ITALIC) != 0, color));
                if ((f & F_STRIKE) != 0) spans.add(new Span(x, y + (int) (4 * scale), segW, 1, color, 1));
                x += segW;
                i = j;
            }
            if (drawCaret && caretY < 0 && caretCol >= rs && caretCol <= re) {
                caretX = (int) (m.width(line.substring(rs, Math.min(caretCol, re))) * scale);
                caretY = y;
                caretH = (int) (8 * scale);
            }
            y += lineH;
        }
        if (drawCaret && caretY < 0 && !rows.isEmpty()) {
            int[] last = rows.get(rows.size() - 1);
            caretX = (int) (m.width(line.substring(last[0], last[1])) * scale);
            caretY = y - lineH;
            caretH = (int) (8 * scale);
        }
    }

    /** Per-character style flags with paired markers: an opening marker only
     *  formats if a matching close exists, so unclosed markers stay literal. */
    private int[] styleLine(String s) {
        int n = s.length();
        int[] f = new int[n];
        boolean bold = false, it = false, st = false, hl = false;
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == '`') {
                int j = s.indexOf('`', i + 1);
                if (j > i) {
                    f[i] |= F_DIM;
                    for (int k = i + 1; k < j; k++) f[k] |= F_CODE;
                    f[j] |= F_DIM;
                    i = j + 1;
                    continue;
                }
            }
            if (twoAt(s, i, "**") || twoAt(s, i, "__")) {
                if (bold) { f[i] |= F_DIM; f[i + 1] |= F_DIM; bold = false; i += 2; continue; }
                if (s.indexOf(s.substring(i, i + 2), i + 2) >= 0) { f[i] |= F_DIM; f[i + 1] |= F_DIM; bold = true; i += 2; continue; }
            }
            if (twoAt(s, i, "~~")) {
                if (st) { f[i] |= F_DIM; f[i + 1] |= F_DIM; st = false; i += 2; continue; }
                if (s.indexOf("~~", i + 2) >= 0) { f[i] |= F_DIM; f[i + 1] |= F_DIM; st = true; i += 2; continue; }
            }
            if (twoAt(s, i, "==")) {
                if (hl) { f[i] |= F_DIM; f[i + 1] |= F_DIM; hl = false; i += 2; continue; }
                if (s.indexOf("==", i + 2) >= 0) { f[i] |= F_DIM; f[i + 1] |= F_DIM; hl = true; i += 2; continue; }
            }
            if ((c == '*' || c == '_') && !twoAt(s, i, "**") && !twoAt(s, i, "__")) {
                if (it) { f[i] |= F_DIM; it = false; i++; continue; }
                if (hasSingle(s, i + 1, c)) { f[i] |= F_DIM; it = true; i++; continue; }
            }
            int cur = 0;
            if (bold) cur |= F_BOLD;
            if (it) cur |= F_ITALIC;
            if (st) cur |= F_STRIKE;
            if (hl) cur |= F_HL;
            f[i] |= cur;
            i++;
        }
        return f;
    }

    private static boolean twoAt(String s, int i, String tok) {
        return i + 1 < s.length() && s.charAt(i) == tok.charAt(0) && s.charAt(i + 1) == tok.charAt(1);
    }
    private static boolean hasSingle(String s, int from, char ch) {
        for (int k = from; k < s.length(); k++) {
            if (s.charAt(k) == ch && (k + 1 >= s.length() || s.charAt(k + 1) != ch)) return true;
        }
        return false;
    }

    /** Wrap a line into char ranges [start,end) that each fit the box at `scale`. */
    private List<int[]> wrapRows(String line, float scale) {
        List<int[]> rows = new ArrayList<int[]>();
        int n = line.length(), i = 0;
        while (i < n) {
            int lastSpace = -1, j = i;
            while (j < n) {
                char c = line.charAt(j);
                if (c == ' ') lastSpace = j;
                if ((int) (m.width(line.substring(i, j + 1)) * scale) > width && j > i) {
                    int brk = lastSpace > i ? lastSpace + 1 : j;
                    rows.add(new int[]{i, brk});
                    i = brk;
                    j = -1;
                    break;
                }
                j++;
            }
            if (j >= n) { rows.add(new int[]{i, n}); break; }
        }
        if (rows.isEmpty()) rows.add(new int[]{0, 0});
        return rows;
    }

    private void codeLine(String line) {
        spans.add(new Span(0, y, width, 10, CODEBG));
        spans.add(new Span(line, 2, y + 1, 1f, false, false, CODE));
        y += 10;
    }

    // ---- formatted line ----

    private void formattedLine(String line, int lineStart) {
        String t = line;
        // horizontal rule
        String tr = t.trim();
        if (tr.equals("---") || tr.equals("***") || tr.equals("___")) {
            y += 3; spans.add(new Span(0, y, width, 1, RULE)); y += 6; return;
        }
        if (tr.length() == 0) { y += 6; return; } // blank line = paragraph gap

        int indent = 0;
        while (indent < t.length() && t.charAt(indent) == ' ') indent++;
        int left = Math.min(indent, 8);
        String body = t.substring(indent);

        // heading
        int hi = 0;
        while (hi < body.length() && body.charAt(hi) == '#') hi++;
        if (hi >= 1 && hi <= 6 && hi < body.length() && body.charAt(hi) == ' ') {
            float scale = H_SCALE[hi - 1];
            flow(parseInline(body.substring(hi + 1)), left, scale, HEADING, true);
            if (hi <= 2) { spans.add(new Span(left, y - 2, width - left, 1, RULE)); }
            y += 3; return;
        }
        // checkbox: - [ ] / - [x]
        int cbMark = matchCheckbox(body);
        if (cbMark >= 0) {
            boolean checked = Character.toLowerCase(body.charAt(cbMark)) == 'x';
            int boxX = left, boxY = y + 1, size = 7;
            checks.add(new Check(boxX, boxY, size, checked, lineStart + indent + cbMark - 1)); // index of '['
            int textLeft = left + size + 3;
            String rest = body.substring(cbMark + 2).replaceFirst("^\\s+", "");
            flow(parseInline(rest), textLeft, 1f, checked ? QUOTE : TEXT, false);
            y += 1; return;
        }
        // bullet
        if (body.length() >= 2 && (body.charAt(0) == '-' || body.charAt(0) == '*' || body.charAt(0) == '+') && body.charAt(1) == ' ') {
            int dotX = left + 1;
            spans.add(new Span(dotX, y + 2, 3, 3, TEXT)); // bullet dot
            flow(parseInline(body.substring(2)), left + 7, 1f, TEXT, false);
            y += 1; return;
        }
        // ordered
        int od = 0;
        while (od < body.length() && Character.isDigit(body.charAt(od))) od++;
        if (od >= 1 && od + 1 < body.length() && body.charAt(od) == '.' && body.charAt(od + 1) == ' ') {
            String num = body.substring(0, od + 1) + " ";
            spans.add(new Span(num, left, y, 1f, false, false, TEXT));
            int textLeft = left + m.width(num);
            flow(parseInline(body.substring(od + 2)), textLeft, 1f, TEXT, false);
            y += 1; return;
        }
        // quote
        if (body.startsWith(">")) {
            String q = body.substring(1).replaceFirst("^\\s", "");
            int top = y;
            flow(parseInline(q), left + 6, 1f, QUOTE, false);
            spans.add(new Span(left + 1, top, 2, Math.max(2, y - top - 1), QUOTE));
            y += 1; return;
        }
        // plain paragraph
        flow(parseInline(body), left, 1f, TEXT, false);
        y += 2;
    }

    private static int matchCheckbox(String body) {
        // "- [ ] ..." -> return index of the state char (between the brackets)
        if (body.length() >= 5 && (body.charAt(0) == '-' || body.charAt(0) == '*' || body.charAt(0) == '+')
                && body.charAt(1) == ' ' && body.charAt(2) == '[' && body.charAt(4) == ']') {
            char s = body.charAt(3);
            if (s == ' ' || s == 'x' || s == 'X') return 3;
        }
        return -1;
    }

    // ---- inline parsing ----

    private static final class Run {
        String text; boolean bold, italic, code, strike, highlight, tag; String url;
        Run(String text, boolean bold, boolean italic, boolean code, boolean strike, boolean highlight, boolean tag, String url) {
            this.text = text; this.bold = bold; this.italic = italic; this.code = code;
            this.strike = strike; this.highlight = highlight; this.tag = tag; this.url = url;
        }
    }

    private List<Run> parseInline(String s) {
        List<Run> out = new ArrayList<Run>();
        StringBuilder buf = new StringBuilder();
        boolean bold = false, italic = false, strike = false, hl = false;
        int i = 0, n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            // inline code
            if (c == '`') {
                int j = s.indexOf('`', i + 1);
                if (j > i) {
                    flush(out, buf, bold, italic, strike, hl);
                    out.add(new Run(s.substring(i + 1, j), false, false, true, false, false, false, null));
                    i = j + 1; continue;
                }
            }
            // link [text](url)
            if (c == '[') {
                int close = s.indexOf(']', i + 1);
                if (close > i && close + 1 < n && s.charAt(close + 1) == '(') {
                    int paren = s.indexOf(')', close + 2);
                    if (paren > close) {
                        flush(out, buf, bold, italic, strike, hl);
                        String label = s.substring(i + 1, close);
                        String url = s.substring(close + 2, paren);
                        out.add(new Run(label, bold, italic, false, strike, hl, false, url));
                        i = paren + 1; continue;
                    }
                }
            }
            // bare autolink
            if ((c == 'h') && (s.startsWith("http://", i) || s.startsWith("https://", i))) {
                int j = i;
                while (j < n && !Character.isWhitespace(s.charAt(j)) && ")]}>,".indexOf(s.charAt(j)) < 0) j++;
                flush(out, buf, bold, italic, strike, hl);
                String url = s.substring(i, j);
                out.add(new Run(url, false, false, false, false, false, false, url));
                i = j; continue;
            }
            // tag #word (not at start-of-line heading, which is handled earlier)
            if (c == '#' && (buf.length() == 0 || isBoundary(buf.charAt(buf.length() - 1)))
                    && i + 1 < n && isTagChar(s.charAt(i + 1))) {
                int j = i + 1;
                while (j < n && isTagChar(s.charAt(j))) j++;
                flush(out, buf, bold, italic, strike, hl);
                out.add(new Run(s.substring(i, j), false, false, false, false, false, true, null));
                i = j; continue;
            }
            // emphasis markers
            if (starts(s, i, "**") || starts(s, i, "__")) { flush(out, buf, bold, italic, strike, hl); bold = !bold; i += 2; continue; }
            if (starts(s, i, "~~")) { flush(out, buf, bold, italic, strike, hl); strike = !strike; i += 2; continue; }
            if (starts(s, i, "==")) { flush(out, buf, bold, italic, strike, hl); hl = !hl; i += 2; continue; }
            if (c == '*' || c == '_') { flush(out, buf, bold, italic, strike, hl); italic = !italic; i += 1; continue; }
            buf.append(c); i++;
        }
        flush(out, buf, bold, italic, strike, hl);
        return out;
    }

    private static void flush(List<Run> out, StringBuilder buf, boolean b, boolean it, boolean st, boolean hl) {
        if (buf.length() > 0) {
            out.add(new Run(buf.toString(), b, it, false, st, hl, false, null));
            buf.setLength(0);
        }
    }
    private static boolean starts(String s, int i, String tok) { return s.regionMatches(i, tok, 0, tok.length()); }
    private static boolean isBoundary(char c) { return !Character.isLetterOrDigit(c); }
    private static boolean isTagChar(char c) { return Character.isLetterOrDigit(c) || c == '-' || c == '_' || c == '/'; }

    // ---- flow / word wrap ----

    private void flow(List<Run> runs, int left, float scale, int baseColor, boolean forceBold) {
        int lineH = (int) (10 * scale) + 1;
        int spaceW = Math.max(1, (int) (m.width(" ") * scale));
        int x = left;
        boolean any = false;
        for (Run r : runs) {
            boolean bold = forceBold || r.bold;
            int color = r.code ? CODE : r.tag ? TAG : r.url != null ? LINK : forceBold ? baseColor : baseColor;
            String[] words = r.text.split(" ", -1);
            for (int wi = 0; wi < words.length; wi++) {
                String word = words[wi];
                if (word.length() == 0) { if (any) x += spaceW; continue; }
                for (String piece : hardWrap(word, scale, left)) {
                    if (piece == null) { // forced newline before an oversized piece
                        y += lineH; x = left; any = false; continue;
                    }
                    int wWidth = (int) (m.width(piece) * scale) + (bold ? 1 : 0);
                    if (any && x + wWidth > width) { y += lineH; x = left; any = false; }
                    if (r.highlight) spans.add(new Span(x - 1, y - 1, wWidth + 2, (int) (9 * scale) + 2, HL_BG));
                    spans.add(new Span(piece, x, y, scale, bold, r.italic, color));
                    if (r.url != null) {
                        spans.add(new Span(x, y + (int) (9 * scale), wWidth, 1, LINK)); // underline
                        links.add(new Link(x, y, wWidth, (int) (10 * scale), r.url));
                    }
                    if (r.strike) spans.add(new Span(x, y + (int) (4 * scale), wWidth, 1, color, 1)); // strike line, above text
                    x += wWidth;
                    any = true;
                }
                if (wi < words.length - 1) x += spaceW;
            }
        }
        y += lineH;
    }

    /** Split a word that is wider than the box into pieces that fit; a null entry means "break line first". */
    private List<String> hardWrap(String word, float scale, int left) {
        List<String> out = new ArrayList<String>();
        int avail = width - left;
        if ((int) (m.width(word) * scale) <= avail) { out.add(word); return out; }
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            cur.append(word.charAt(i));
            if ((int) (m.width(cur.toString()) * scale) > avail && cur.length() > 1) {
                cur.deleteCharAt(cur.length() - 1);
                out.add(cur.toString());
                out.add(null); // break line
                cur = new StringBuilder();
                cur.append(word.charAt(i));
            }
        }
        if (cur.length() > 0) out.add(cur.toString());
        return out;
    }

}
