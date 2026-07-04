/*
 * Markdown layout engine for the Obsidian Book reading view. Parses a page's
 * Markdown with commonmark-java and lays it out into positioned spans (styled
 * text runs + rectangles) within a fixed pixel width. Pure and side-effect
 * free (no OpenGL) so it can be unit-tested headless; MarkdownRenderer turns
 * the spans into draw calls.
 *
 * The 8px bitmap font has no bold/italic/size, so those are emulated at draw
 * time: bold = double-draw, italic = shear, headings = scale. This class only
 * records the intended style + geometry.
 */
package net.minecraft.client.c;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.Parser;

public final class MarkdownLayout {

    /** Measures the pixel width of a string at scale 1 (e.g. FontRenderer::a). */
    public interface Metrics {
        int width(String s);
    }

    /** A positioned draw instruction: styled text, or (text==null) a filled rect. */
    public static final class Span {
        public final String text;   // null => rectangle
        public final int x, y;      // top-left, relative to the layout origin
        public final float scale;
        public final boolean bold, italic, underline;
        public final int color;
        public final int w, h;      // rectangle size (text==null)

        Span(String text, int x, int y, float scale, boolean bold, boolean italic, boolean underline, int color) {
            this.text = text; this.x = x; this.y = y; this.scale = scale;
            this.bold = bold; this.italic = italic; this.underline = underline; this.color = color;
            this.w = 0; this.h = 0;
        }
        Span(int x, int y, int w, int h, int color) {
            this.text = null; this.x = x; this.y = y; this.w = w; this.h = h; this.color = color;
            this.scale = 1f; this.bold = this.italic = this.underline = false;
        }
    }

    // Colours tuned for the light parchment page.
    static final int COL_TEXT    = 0x000000;
    static final int COL_HEADING = 0x552200;
    static final int COL_LINK    = 0x1515AA;
    static final int COL_CODE    = 0x555555;
    static final int COL_QUOTE   = 0x5A5A5A;
    static final int COL_RULE    = 0x9A9A9A;
    static final int COL_CODEBG  = 0x18000000; // faint dark wash (ARGB)

    static final float[] HEADING_SCALE = {1.7f, 1.5f, 1.3f, 1.2f, 1.1f, 1.05f};
    static final int INDENT = 10;

    private static final Parser PARSER = Parser.builder().build();

    private final int width;
    private final Metrics metrics;
    private final List<Span> spans = new ArrayList<Span>();
    private int y = 0;

    private MarkdownLayout(int width, Metrics metrics) {
        this.width = width;
        this.metrics = metrics;
    }

    public static List<Span> layout(String markdown, int width, Metrics metrics) {
        MarkdownLayout ml = new MarkdownLayout(width, metrics);
        try {
            Node doc = PARSER.parse(markdown == null ? "" : markdown);
            ml.blocks(doc, 0);
        } catch (Throwable t) {
            ml.spans.clear();
            ml.spans.add(new Span(markdown == null ? "" : markdown, 0, 0, 1f, false, false, false, COL_TEXT));
        }
        return ml.spans;
    }

    /** Total laid-out height in pixels (for callers that want it). */
    public static int height(List<Span> spans) {
        int max = 0;
        for (Span s : spans) {
            int bottom = s.text == null ? s.y + s.h : s.y + (int) (10 * s.scale);
            if (bottom > max) max = bottom;
        }
        return max;
    }

    // ---- block level ----

    private void blocks(Node parent, int indent) {
        for (Node n = parent.getFirstChild(); n != null; n = n.getNext()) {
            block(n, indent);
        }
    }

    private void block(Node n, int indent) {
        if (n instanceof Heading) {
            Heading h = (Heading) n;
            float scale = HEADING_SCALE[Math.max(0, Math.min(5, h.getLevel() - 1))];
            flow(collectInline(h), indent, scale, true, COL_HEADING, false);
            if (h.getLevel() <= 2) { // underline rule for H1/H2
                spans.add(new Span(indent, y - 2, width - indent, 1, COL_RULE));
            }
            y += 3;
        } else if (n instanceof Paragraph) {
            flow(collectInline(n), indent, 1f, false, COL_TEXT, false);
            y += 4;
        } else if (n instanceof BulletList) {
            for (Node it = n.getFirstChild(); it != null; it = it.getNext()) {
                listItem(it, indent, "-");
            }
            y += 2;
        } else if (n instanceof OrderedList) {
            int num = ((OrderedList) n).getStartNumber();
            for (Node it = n.getFirstChild(); it != null; it = it.getNext()) {
                listItem(it, indent, (num++) + ".");
            }
            y += 2;
        } else if (n instanceof BlockQuote) {
            int top = y;
            blocksQuoted(n, indent + INDENT);
            spans.add(new Span(indent + 2, top, 2, Math.max(2, y - top - 2), COL_QUOTE)); // left bar
        } else if (n instanceof FencedCodeBlock) {
            codeBlock(((FencedCodeBlock) n).getLiteral(), indent);
        } else if (n instanceof IndentedCodeBlock) {
            codeBlock(((IndentedCodeBlock) n).getLiteral(), indent);
        } else if (n instanceof ThematicBreak) {
            y += 3;
            spans.add(new Span(indent, y, width - indent, 1, COL_RULE));
            y += 6;
        } else {
            blocks(n, indent); // unknown container: descend
        }
    }

    private void blocksQuoted(Node parent, int indent) {
        for (Node n = parent.getFirstChild(); n != null; n = n.getNext()) {
            if (n instanceof Paragraph) {
                flow(collectInline(n), indent, 1f, false, COL_QUOTE, false);
                y += 3;
            } else {
                block(n, indent);
            }
        }
    }

    private void listItem(Node item, int indent, String marker) {
        String m = marker + " ";
        int markerW = metrics.width(m);
        spans.add(new Span(m, indent, y, 1f, false, false, false, COL_TEXT));
        int textIndent = indent + markerW;
        boolean first = true;
        for (Node child = item.getFirstChild(); child != null; child = child.getNext()) {
            if (first && child instanceof Paragraph) {
                flow(collectInline(child), textIndent, 1f, false, COL_TEXT, false);
                y += 2;
            } else {
                block(child, textIndent);
            }
            first = false;
        }
    }

    private void codeBlock(String literal, int indent) {
        String[] lines = literal.split("\n", -1);
        int start = y;
        int lineH = 10;
        int count = 0;
        for (String line : lines) {
            if (line.length() == 0 && count == lines.length - 1) break; // trailing newline
            count++;
        }
        int blockH = Math.max(lineH, count * lineH) + 4;
        spans.add(new Span(indent, start, width - indent, blockH, COL_CODEBG)); // background
        y += 2;
        for (int i = 0; i < count; i++) {
            spans.add(new Span(lines[i], indent + 3, y, 1f, false, false, false, COL_CODE));
            y += lineH;
        }
        y += 4;
    }

    // ---- inline level ----

    private static final class Run {
        final String text; final boolean bold, italic, underline, brk; final int color;
        Run(String text, boolean bold, boolean italic, boolean underline, int color) {
            this.text = text; this.bold = bold; this.italic = italic; this.underline = underline; this.color = color; this.brk = false;
        }
        Run() { this.text = ""; this.bold = this.italic = this.underline = false; this.color = 0; this.brk = true; }
    }

    private List<Run> collectInline(Node block) {
        List<Run> out = new ArrayList<Run>();
        inline(block, false, false, false, COL_TEXT, out);
        return out;
    }

    private void inline(Node parent, boolean bold, boolean italic, boolean underline, int color, List<Run> out) {
        for (Node n = parent.getFirstChild(); n != null; n = n.getNext()) {
            if (n instanceof Text) {
                out.add(new Run(((Text) n).getLiteral(), bold, italic, underline, color));
            } else if (n instanceof StrongEmphasis) {
                inline(n, true, italic, underline, color, out);
            } else if (n instanceof Emphasis) {
                inline(n, bold, true, underline, color, out);
            } else if (n instanceof Code) {
                out.add(new Run(((Code) n).getLiteral(), bold, italic, underline, COL_CODE));
            } else if (n instanceof Link) {
                inline(n, bold, italic, true, COL_LINK, out);
            } else if (n instanceof SoftLineBreak) {
                out.add(new Run(" ", bold, italic, underline, color));
            } else if (n instanceof HardLineBreak) {
                out.add(new Run());
            } else {
                inline(n, bold, italic, underline, color, out);
            }
        }
    }

    /** Word-wrap a run list into the box and emit positioned spans. Advances y. */
    private void flow(List<Run> runs, int left, float scale, boolean forceBold, int forceColor, boolean unused) {
        int lineH = (int) (10 * scale) + 1;
        int spaceW = Math.max(1, (int) (metrics.width(" ") * scale));
        int x = left;
        boolean anyOnLine = false;
        for (Run run : runs) {
            if (run.brk) {
                y += lineH; x = left; anyOnLine = false; continue;
            }
            boolean bold = forceBold || run.bold;
            int color = forceBold ? forceColor : run.color;
            String[] words = run.text.split(" ", -1);
            for (int wi = 0; wi < words.length; wi++) {
                String word = words[wi];
                if (word.length() == 0) {
                    if (anyOnLine) { x += spaceW; }
                    continue;
                }
                int wWidth = (int) (metrics.width(word) * scale) + (bold ? 1 : 0);
                if (anyOnLine && x + wWidth > width) {
                    y += lineH; x = left; anyOnLine = false;
                }
                spans.add(new Span(word, x, y, scale, bold, run.italic, run.underline, color));
                if (run.underline) {
                    spans.add(new Span(x, y + (int) (9 * scale), wWidth, 1, color));
                }
                x += wWidth;
                if (wi < words.length - 1) { x += spaceW; }
                anyOnLine = true;
            }
        }
        y += lineH;
    }
}
