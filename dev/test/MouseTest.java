import java.lang.reflect.*; import java.net.*; import java.io.*;
import net.minecraft.client.c.BookLayout;
public class MouseTest {
  static int pass=0, fail=0;
  static void ok(String n, boolean c){ if(c)pass++; else{fail++; System.out.println("FAIL "+n);} }
  public static void main(String[] a) throws Exception {
    URLClassLoader cl = new URLClassLoader(new URL[]{ new File(a[0]).toURI().toURL(), new File(a[1]).toURI().toURL() }, ClassLoader.getSystemClassLoader());
    Class<?> G = Class.forName("net.minecraft.client.c.GuiScreenObsidianBook", true, cl);
    Method toggle = G.getDeclaredMethod("toggleState", String.class, int.class); toggle.setAccessible(true);
    Class<?> Metrics = Class.forName("net.minecraft.client.c.BookLayout$Metrics", true, cl);
    Method col = G.getDeclaredMethod("columnFromX", String.class, int.class, Metrics); col.setAccessible(true);
    Object m6 = java.lang.reflect.Proxy.newProxyInstance(cl, new Class[]{Metrics}, (p,mm,ar)-> ((String)ar[0]).length()*6);

    ok("toggle uncheck->check", toggle.invoke(null,"- [ ] a",2).equals("- [x] a"));
    ok("toggle check->uncheck", toggle.invoke(null,"- [x] a",2).equals("- [ ] a"));
    ok("toggle X->uncheck", toggle.invoke(null,"- [X] a",2).equals("- [ ] a"));
    ok("toggle oob safe", toggle.invoke(null,"- ",50).equals("- "));

    ok("col lx0=0", (int)col.invoke(null,"abcde",0,m6)==0);
    ok("col lx3=0", (int)col.invoke(null,"abcde",3,m6)==0);
    ok("col lx4=1", (int)col.invoke(null,"abcde",4,m6)==1);
    ok("col lx9=1", (int)col.invoke(null,"abcde",9,m6)==1);
    ok("col beyond=len", (int)col.invoke(null,"abcde",999,m6)==5);
    System.out.println(fail==0?("ALL PASS ("+pass+")"):(fail+" FAILED"));
  }
}
