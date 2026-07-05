import net.minecraft.client.c.BookLayout;
import java.util.*;

public class BLTest {
    static int pass=0, fail=0;
    static BookLayout.Metrics M = new BookLayout.Metrics(){ public int width(String s){ return s.length()*6; } };
    static void ok(String n, boolean c){ if(c)pass++; else{fail++; System.out.println("FAIL "+n);} }

    static BookLayout build(String t, int cur, boolean reading){ return BookLayout.build(t, cur, 116, M, reading); }

    static boolean hasText(BookLayout b, String t){ for(BookLayout.Span s:b.spans) if(t.equals(s.text)) return true; return false; }
    static BookLayout.Span textSpan(BookLayout b, String t){ for(BookLayout.Span s:b.spans) if(t.equals(s.text)) return s; return null; }

    public static void main(String[] a){
        // reading mode: heading scaled, no caret
        BookLayout b = build("# Title", -1, true);
        BookLayout.Span h = textSpan(b,"Title");
        ok("heading text present", h!=null);
        ok("heading scaled", h!=null && h.scale>1f);
        ok("reading: no caret", b.caretX==-1);

        // hybrid: caret line shown raw
        b = build("# Title\nsecond", 2, false); // cursor on line 0 (# Title)
        ok("hybrid caret set", b.caretX>=0);
        ok("caret line raw (contains #)", hasText(b,"# Title"));
        ok("other line formatted (second)", hasText(b,"second"));

        // caret at end of a line
        b = build("abcd", 4, false);
        ok("caret end x = 4*6", b.caretX==24);

        // inline styles on a formatted line (cursor elsewhere)
        b = build("x\nplain **bold** _it_ `code` ~~st~~ ==hl== #tag", 0, false);
        BookLayout.Span bs=textSpan(b,"bold");
        ok("bold flag", bs!=null && bs.bold);
        BookLayout.Span it=textSpan(b,"it");
        ok("italic flag", it!=null && it.italic);
        ok("code text present", hasText(b,"code"));
        ok("strike foreground rect", anyRectLayer(b,1));
        ok("highlight bg rect", anyRectColor(b, 0x66E9D93A));
        BookLayout.Span tag=textSpan(b,"#tag");
        ok("tag colored", tag!=null && tag.color==0x116644);

        // links: [text](url) + autolink
        b = build("x\n[click](http://a.com) and http://bare.io/x", 0, false);
        ok("link label present", hasText(b,"click"));
        ok("link hitbox url1", anyLink(b,"http://a.com"));
        ok("autolink hitbox url2", anyLink(b,"http://bare.io/x"));

        // checkbox
        b = build("x\n- [ ] todo\n- [x] done", 0, false);
        ok("2 checkboxes", b.checks.size()==2);
        ok("first unchecked", b.checks.size()==2 && !b.checks.get(0).checked);
        ok("second checked", b.checks.size()==2 && b.checks.get(1).checked);
        // markIndex points to '[' in the raw text
        String txt="x\n- [ ] todo\n- [x] done";
        ok("checkbox markIndex is '['", b.checks.size()==2 && txt.charAt(b.checks.get(0).markIndex)=='[');

        // hr
        b = build("x\n---", 0, false);
        ok("hr rule rect", anyRectColor(b,0x9A9A9A));

        // fenced code block hides fences, shows code line
        b = build("x\n```\ncode line\n```", 0, false);
        ok("code block content", hasText(b,"code line"));
        ok("fence markers hidden", !hasText(b,"```"));

        // long word / url does not overflow width (116)
        StringBuilder sb=new StringBuilder("x\nhttp://"); for(int i=0;i<80;i++) sb.append("A");
        b = build(sb.toString(), 0, false);
        int maxRight=0; for(BookLayout.Span s:b.spans) if(s.text!=null) maxRight=Math.max(maxRight, s.x + s.text.length()*6);
        ok("no overflow past width", maxRight<=116);

        // empty + whitespace
        ok("empty no crash", build("", 0, false)!=null);
        ok("whitespace no crash", build("   \n  ", 0, false)!=null);

        // cyrillic
        b = build("y\nПривет **мир**", 0, false);
        ok("cyrillic bold", textSpan(b,"мир")!=null && textSpan(b,"мир").bold);

        // malformed markdown does not throw (unbalanced markers, stray brackets)
        ok("malformed no crash", build("y\n**bold [x]( ~~ == #", 0, false)!=null);

        // lineBoxes map full text
        b = build("aa\nbb\ncc", 8, false);
        ok("3 line boxes", b.lines.size()==3);
        ok("line0 range", b.lines.get(0).start==0 && b.lines.get(0).end==2);
        ok("line2 range", b.lines.get(2).start==6 && b.lines.get(2).end==8);

        System.out.println(fail==0 ? ("ALL PASS ("+pass+")") : (fail+" FAILED, "+pass+" passed"));
    }
    static boolean anyRectLayer(BookLayout b,int layer){ for(BookLayout.Span s:b.spans) if(s.text==null && s.layer==layer) return true; return false; }
    static boolean anyRectColor(BookLayout b,int color){ for(BookLayout.Span s:b.spans) if(s.text==null && s.color==color) return true; return false; }
    static boolean anyLink(BookLayout b,String url){ for(BookLayout.Link l:b.links) if(url.equals(l.url)) return true; return false; }
}
