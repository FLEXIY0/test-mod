package net.minecraft.client.c;
import java.util.*;
public class PageTest {
  static int pass=0, fail=0;
  static BookLayout.Metrics M = s -> s.length()*6;
  static void ok(String n, boolean c){ if(c)pass++; else{fail++; System.out.println("FAIL "+n);} }
  static int countLines(String s){ int n=1; for(int i=0;i<s.length();i++) if(s.charAt(i)=='\n') n++; return n; }
  public static void main(String[] a){
    StringBuilder sb=new StringBuilder();
    for(int i=0;i<40;i++) sb.append("line ").append(i).append("\n");
    String content=sb.toString();
    BookLayout full=BookLayout.build(content,-1,116,M,true);
    int pageH=152;
    int[] starts=GuiScreenObsidianBook.computePageStarts(full.lines, content.length(), pageH);
    int pages=starts.length-1;
    ok("multiple pages", pages>=2);
    ok("bounds", starts[0]==0 && starts[starts.length-1]==content.length());
    boolean asc=true; for(int i=1;i<starts.length;i++) if(starts[i]<starts[i-1]) asc=false;
    ok("monotonic", asc);
    StringBuilder j=new StringBuilder();
    for(int k=0;k<pages;k++) j.append(content, starts[k], starts[k+1]);
    ok("slices cover content", j.toString().equals(content));
    ok("pos0->page0", GuiScreenObsidianBook.pageIndexOf(starts,0)==0);
    ok("end->last", GuiScreenObsidianBook.pageIndexOf(starts,content.length())==pages-1);
    ok("mid->page1", GuiScreenObsidianBook.pageIndexOf(starts, starts[1])==1);
    boolean fits=true;
    for(int k=0;k<pages;k++){
      String slice=content.substring(starts[k],starts[k+1]);
      BookLayout pl=BookLayout.build(slice,-1,116,M,true);
      if(pl.totalHeight>pageH && countLines(slice)>1) fits=false;
    }
    ok("each page fits", fits);
    ok("short=1page", GuiScreenObsidianBook.computePageStarts(BookLayout.build("hi",-1,116,M,true).lines,2,pageH).length-1==1);
    ok("empty=1page", GuiScreenObsidianBook.computePageStarts(BookLayout.build("",-1,116,M,true).lines,0,pageH).length-1==1);
    System.out.println(fail==0?("ALL PASS ("+pass+")"):(fail+" FAILED"));
  }
}
