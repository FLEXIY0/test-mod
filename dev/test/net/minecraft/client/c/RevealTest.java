package net.minecraft.client.c;
import java.lang.reflect.*;
public class RevealTest {
  static int pass=0, fail=0;
  static BookLayout.Metrics M = s -> s.length()*6;
  static void ok(String n, boolean c){ if(c)pass++; else{fail++; System.out.println("FAIL "+n);} }
  static int[] style(String line) throws Exception {
    BookLayout bl = BookLayout.build("",-1,116,M,true);
    Method m = BookLayout.class.getDeclaredMethod("styleLine", String.class); m.setAccessible(true);
    return (int[]) m.invoke(bl, line);
  }
  static boolean has(int f,int bit){ return (f&bit)!=0; }
  public static void main(String[] a) throws Exception {
    int B=BookLayout.F_BOLD, I=BookLayout.F_ITALIC, S=BookLayout.F_STRIKE, H=BookLayout.F_HL, C=BookLayout.F_CODE, D=BookLayout.F_DIM;
    int[] f = style("**bold**");   // idx0,1 dim; 2..5 bold; 6,7 dim
    ok("bold markers dim", has(f[0],D)&&has(f[1],D)&&has(f[6],D)&&has(f[7],D));
    ok("bold body bold", has(f[2],B)&&has(f[5],B));
    ok("bold markers not bold", !has(f[0],B));

    f = style("**unclosed");       // no close -> literal, nothing dim/bold
    ok("unclosed: no dim", !has(f[0],D)&&!has(f[1],D));
    ok("unclosed: no bold", !has(f[2],B));

    f = style("a ~~s~~");          // strike on s (idx4), markers dim
    ok("strike body", has(f[4],S));
    ok("strike markers dim", has(f[2],D)&&has(f[3],D));

    f = style("==h==");            // highlight on h (idx2)
    ok("highlight body", has(f[2],H));

    f = style("`c`");              // code inner idx1, backticks dim
    ok("code inner", has(f[1],C));
    ok("code ticks dim", has(f[0],D)&&has(f[2],D));

    f = style("*i*");              // italic
    ok("italic body", has(f[1],I));

    // reveal line keeps markers visible: build with cursor on a heading line
    BookLayout bl = BookLayout.build("# Title\nx", 3, 116, M, false); // cursor in "# Title"
    boolean hashVisible=false; boolean big=false;
    for (BookLayout.Span sp: bl.spans) if (sp.text!=null && sp.text.contains("#")) { hashVisible=true; if (sp.scale>1f) big=true; }
    ok("cursor heading shows #", hashVisible);
    ok("cursor heading big", big);
    ok("caret set on reveal", bl.caretX>=0);

    // caret exact on a plain cursor line "abcd", cursor col 2
    bl = BookLayout.build("abcd", 2, 116, M, false);
    ok("caret x = 2*6", bl.caretX==12);

    System.out.println(fail==0?("ALL PASS ("+pass+")"):(fail+" FAILED"));
  }
}
