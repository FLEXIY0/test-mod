import org.objectweb.asm.*;
import java.io.*;
import java.util.*;
import java.util.jar.*;
import java.util.zip.*;

/** Rewrites hard-coded "Legacy+" branding string constants across every class. */
public class StringPatch {
    static final Map<String, String> REPL = new LinkedHashMap<String, String>();
    static {
        REPL.put("Mod by The Legacy+ Team", "");
        REPL.put("§eNotice: §fThe Legacy+ project is not in any way associated with Mojang or Microsoft.",
                 "§eNotice: §fThis project is not associated with Mojang or Microsoft.");
        REPL.put("Indev+ was created by method as part of the Legacy+ project.", "Indev+");
        REPL.put("Copyright method & The Legacy+ Team, 2023. All rights reserved.", "");
    }
    static int hits = 0;

    public static void main(String[] a) throws Exception {
        JarFile in = new JarFile(a[0]);
        JarOutputStream out = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(a[1])));
        Enumeration<JarEntry> e = in.entries();
        while (e.hasMoreElements()) {
            JarEntry je = e.nextElement();
            byte[] data = readAll(in.getInputStream(je));
            if (je.getName().endsWith(".class")) {
                data = patch(data);
            }
            JarEntry ne = new JarEntry(je.getName());
            ne.setTime(je.getTime());
            out.putNextEntry(ne);
            out.write(data);
            out.closeEntry();
        }
        in.close();
        out.close();
        System.out.println("StringPatch: replaced " + hits + " string constant(s)");
    }

    static byte[] patch(byte[] classBytes) {
        ClassReader cr = new ClassReader(classBytes);
        ClassWriter cw = new ClassWriter(0);
        cr.accept(new ClassVisitor(Opcodes.ASM9, cw) {
            public MethodVisitor visitMethod(int acc, String n, String d, String s, String[] ex) {
                MethodVisitor mv = super.visitMethod(acc, n, d, s, ex);
                return new MethodVisitor(Opcodes.ASM9, mv) {
                    public void visitLdcInsn(Object cst) {
                        if (cst instanceof String && REPL.containsKey(cst)) {
                            hits++;
                            super.visitLdcInsn(REPL.get(cst));
                        } else {
                            super.visitLdcInsn(cst);
                        }
                    }
                };
            }
        }, 0);
        return cw.toByteArray();
    }

    static byte[] readAll(InputStream is) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int r;
        while ((r = is.read(buf)) != -1) b.write(buf, 0, r);
        return b.toByteArray();
    }
}
