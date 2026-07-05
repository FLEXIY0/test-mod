import org.objectweb.asm.*;
import org.objectweb.asm.commons.*;
import java.io.*;
import java.util.*;
import java.util.jar.*;

/**
 * Second-pass remapper: renames already-deobfuscated classes in the CURRENT
 * customjar to readable Beta-style names, keyed on their fully-qualified
 * internal names (so it is safe despite simple-name collisions across packages).
 *
 * Unlike Remap.java this does NOT need the original obfuscated jar — it operates
 * on the current jar and applies only the exact renames listed in the CSV
 * (currentInternalName,newInternalName). Re-runnable: extend beta-names.csv and
 * run again. Method/field names are untouched (class-level only).
 *
 * Usage: RemapBeta <in.jar> <out.jar> <beta-names.csv>
 */
public class RemapBeta {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new LinkedHashMap<String, String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[2]), "UTF-8"));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) continue;
            String[] p = line.split(",");
            map.put(p[0].trim(), p[1].trim());
        }
        br.close();

        JarFile in = new JarFile(args[0]);
        Set<String> classes = new TreeSet<String>();
        for (Enumeration<JarEntry> e = in.entries(); e.hasMoreElements();) {
            String n = e.nextElement().getName();
            if (n.endsWith(".class")) classes.add(n.substring(0, n.length() - 6));
        }
        // Every source of a rename must exist; targets must not collide.
        for (String src : map.keySet()) {
            if (!classes.contains(src)) throw new IllegalStateException("no such class to rename: " + src);
        }
        Set<String> taken = new HashSet<String>(classes);
        taken.removeAll(map.keySet());
        for (String t : map.values()) {
            if (!taken.add(t)) throw new IllegalStateException("rename target already taken: " + t);
        }

        Remapper remapper = new SimpleRemapper(map);
        JarOutputStream out = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(args[1])));
        int renamed = 0, kept = 0, res = 0;
        for (Enumeration<JarEntry> e = in.entries(); e.hasMoreElements();) {
            JarEntry je = e.nextElement();
            byte[] data = readAll(in.getInputStream(je));
            String name = je.getName();
            if (name.equals("META-INF/MANIFEST.MF")) {
                Manifest m = new Manifest(new ByteArrayInputStream(data));
                Manifest fresh = new Manifest();
                fresh.getMainAttributes().putAll(m.getMainAttributes());
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                fresh.write(bo);
                data = bo.toByteArray();
            } else if (name.endsWith(".class")) {
                String cls = name.substring(0, name.length() - 6);
                String to = map.get(cls);
                ClassReader cr = new ClassReader(data);
                ClassWriter cw = new ClassWriter(0);
                cr.accept(new ClassRemapper(cw, remapper), 0);
                data = cw.toByteArray();
                if (to != null) { name = to + ".class"; renamed++; } else kept++;
            } else {
                res++;
            }
            JarEntry ne = new JarEntry(name);
            ne.setTime(je.getTime());
            out.putNextEntry(ne);
            out.write(data);
            out.closeEntry();
        }
        in.close();
        out.close();
        System.out.println("RemapBeta: " + renamed + " renamed, " + kept + " kept, " + res + " resources");
    }

    static byte[] readAll(InputStream is) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int r;
        while ((r = is.read(buf)) != -1) b.write(buf, 0, r);
        return b.toByteArray();
    }
}
