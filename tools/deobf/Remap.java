import org.objectweb.asm.*;
import org.objectweb.asm.commons.*;
import java.io.*;
import java.util.*;
import java.util.jar.*;

/**
 * Deobfuscation remapper for the Indev+ custom jar.
 *
 * The obfuscator emitted classes whose names collide with sibling packages
 * (class net/minecraft/client/c next to package net/minecraft/client/c/),
 * which the JVM accepts but javac rejects — decompiled sources cannot be
 * recompiled. This tool renames every obfuscated class (simple name of 1-3
 * lowercase letters) to either a curated readable name (mappings.csv) or a
 * mechanical C_<name>, killing every class/package clash.
 *
 * Exceptions:
 *  - net/minecraft/client/d keeps its name (PrismLauncher mainClass);
 *    the clashing package net/minecraft/client/d/* moves to dx/* instead.
 *
 * Usage: Remap <in.jar> <out.jar> <mappings.csv>
 */
public class Remap {
    static final String KEEP = "net/minecraft/client/d";
    // Package moves. dx: the package clashing with the kept launcher class d.
    // util: the root package "a" — in source form it is shadowed by every
    // local/field named 'a', so qualified references a.X.y() do not compile.
    static final String[][] PKG_MOVES = {
        { "net/minecraft/client/d/", "net/minecraft/client/dx/" },
        { "a/", "util/" },
    };

    public static void main(String[] args) throws Exception {
        Map<String, String> curated = new LinkedHashMap<String, String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[2]), "UTF-8"));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) continue;
            String[] p = line.split(",");
            curated.put(p[0].trim(), p[1].trim());
        }
        br.close();

        // Collect all class names in the jar.
        JarFile in = new JarFile(args[0]);
        Set<String> classes = new TreeSet<String>();
        for (Enumeration<JarEntry> e = in.entries(); e.hasMoreElements();) {
            String n = e.nextElement().getName();
            if (n.endsWith(".class")) classes.add(n.substring(0, n.length() - 6));
        }

        // Build the rename map.
        Map<String, String> map = new LinkedHashMap<String, String>();
        for (String c : classes) {
            String target = c;
            for (String[] mv : PKG_MOVES) {
                if (target.startsWith(mv[0])) target = mv[1] + target.substring(mv[0].length());
            }
            if (!c.equals(KEEP)) {
                String simple = target.substring(target.lastIndexOf('/') + 1);
                if (curated.containsKey(c)) {
                    target = curated.get(c);
                } else if (simple.matches("[a-z]{1,3}")) {
                    target = target.substring(0, target.lastIndexOf('/') + 1) + "C_" + simple;
                }
            }
            if (!target.equals(c)) map.put(c, target);
        }

        // Safety: renames must be collision-free among themselves and with kept names.
        Set<String> taken = new HashSet<String>(classes);
        taken.removeAll(map.keySet());
        for (String t : map.values()) {
            if (!taken.add(t)) throw new IllegalStateException("rename collision: " + t);
        }

        Remapper remapper = new SimpleRemapper(map);
        JarOutputStream out = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(args[1])));
        int renamed = 0, kept = 0, res = 0;
        for (Enumeration<JarEntry> e = in.entries(); e.hasMoreElements();) {
            JarEntry je = e.nextElement();
            byte[] data = readAll(in.getInputStream(je));
            String name = je.getName();
            if (name.equals("META-INF/MANIFEST.MF")) {
                // Fresh manifest: keep main attributes, drop stale per-entry digests.
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
                // The obfuscator promoted anonymous classes to top level but left
                // stale EnclosingMethod/InnerClasses attributes behind. The JVM
                // ignores them; javac refuses to read such class files. Strip the
                // attributes for $-less names (real nested lib classes keep theirs).
                ClassVisitor stripper = new ClassVisitor(Opcodes.ASM9, cw) {
                    private String self;
                    @Override
                    public void visit(int v, int acc, String n, String sig, String sup, String[] itf) {
                        this.self = n;
                        super.visit(v, acc, n, sig, sup, itf);
                    }
                    @Override
                    public void visitOuterClass(String owner, String mName, String mDesc) {
                        if (self.indexOf('$') < 0) return; // stale: drop
                        super.visitOuterClass(owner, mName, mDesc);
                    }
                    @Override
                    public void visitInnerClass(String n, String outer, String inner, int acc) {
                        if (n.indexOf('$') < 0) return;    // stale entry: drop
                        super.visitInnerClass(n, outer, inner, acc);
                    }
                };
                cr.accept(new ClassRemapper(stripper, remapper), 0);
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
        System.out.println("Remap: " + renamed + " classes renamed, " + kept + " kept, " + res + " resources copied");
    }

    static byte[] readAll(InputStream is) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int r;
        while ((r = is.read(buf)) != -1) b.write(buf, 0, r);
        return b.toByteArray();
    }
}
