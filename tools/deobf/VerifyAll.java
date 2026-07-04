import java.io.*;
import java.net.*;
import java.util.*;
import java.util.jar.*;

/**
 * Runs every class in a jar through the JVM bytecode verifier (define+link,
 * no static initialization). Used to prove the remapped jar is as sound as
 * the original: both runs must produce the same failure set (ideally empty).
 *
 * Usage: VerifyAll <target.jar> <dep.jar> [dep.jar...]
 */
public class VerifyAll {
    static class Loader extends URLClassLoader {
        Loader(URL[] u, ClassLoader p) { super(u, p); }
        Class<?> force(String name, byte[] b) {
            Class<?> c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        }
    }

    public static void main(String[] a) throws Exception {
        URL[] deps = new URL[a.length];
        for (int i = 0; i < a.length; i++) deps[i] = new File(a[i]).toURI().toURL();
        JarFile jar = new JarFile(a[0]);
        int ok = 0, fail = 0;
        List<String> failures = new ArrayList<String>();
        for (Enumeration<JarEntry> e = jar.entries(); e.hasMoreElements();) {
            JarEntry je = e.nextElement();
            if (!je.getName().endsWith(".class")) continue;
            String name = je.getName().replace('/', '.').substring(0, je.getName().length() - 6);
            byte[] b = readAll(jar.getInputStream(je));
            // fresh loader per class: the target class is force-defined, its
            // dependencies resolve through the URL path (jar + deps)
            Loader l = new Loader(deps, ClassLoader.getSystemClassLoader());
            try { l.force(name, b); ok++; }
            catch (Throwable t) { fail++; failures.add(name + " -> " + t); }
        }
        jar.close();
        System.out.println("VerifyAll " + a[0] + ": " + ok + " OK, " + fail + " failed");
        for (String f : failures) System.out.println("  FAIL " + f);
    }

    static byte[] readAll(InputStream is) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int r;
        while ((r = is.read(buf)) != -1) b.write(buf, 0, r);
        return b.toByteArray();
    }
}
