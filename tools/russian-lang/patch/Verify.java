import java.io.*;
import java.net.*;

/** Forces JVM linking (=bytecode verification) of patched classes without running them. */
public class Verify extends URLClassLoader {
    Verify(URL[] u) { super(u, ClassLoader.getSystemClassLoader()); }

    void verify(String n) throws Exception {
        byte[] b = readAll(getResourceAsStream(n.replace('.', '/') + ".class"));
        Class<?> c = defineClass(n, b, 0, b.length);
        resolveClass(c);                     // link -> verify (does NOT run <clinit>)
        System.out.println("  verified OK: " + n + "  (methods: " + c.getDeclaredMethods().length + ")");
    }

    static byte[] readAll(InputStream is) throws IOException {
        ByteArrayOutputStream o = new ByteArrayOutputStream();
        byte[] buf = new byte[8192]; int r;
        while ((r = is.read(buf)) != -1) o.write(buf, 0, r);
        return o.toByteArray();
    }

    public static void main(String[] a) throws Exception {
        URL[] urls = { new File(a[0]).toURI().toURL(),
                       new File(a[1]).toURI().toURL(),
                       new File(a[2]).toURI().toURL() };
        String[] targets = { "net.minecraft.client.Lang",
                             "net.minecraft.client.c.j",
                             "net.minecraft.client.c.at" };
        int ok = 0;
        for (String t : targets) {
            Verify v = new Verify(urls);     // fresh loader per class to avoid dup-define
            try { v.verify(t); ok++; }
            catch (Throwable e) { System.out.println("  FAILED: " + t + " -> " + e); }
        }
        System.out.println("Verify: " + ok + "/" + targets.length + " classes passed the JVM verifier");
    }
}
