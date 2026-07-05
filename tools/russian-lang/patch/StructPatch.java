import javassist.*;
import javassist.bytecode.*;

/**
 * Structural bytecode edits:
 *  - Font renderer (class j): route every drawn/measured string through Lang.tr().
 *  - Main menu (class at): add a Language button that cycles languages.
 */
public class StructPatch {
    public static void main(String[] a) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(a[0]);          // the jar being patched (already contains Lang)
        pool.insertClassPath(a[2]);          // lwjgl
        pool.insertClassPath(a[3]);          // lwjgl_util

        // ---- Font renderer: translate at every public entry point ----
        CtClass j = pool.get("net.minecraft.client.c.j");
        String tr = "$1 = net.minecraft.client.Lang.tr($1);";
        String[][] fontMethods = {
            {"a", "(Ljava/lang/String;III)V"},
            {"b", "(Ljava/lang/String;III)V"},
            {"drawStringWithBackground", "(Ljava/lang/String;III)V"},
            {"a", "(Ljava/lang/String;)I"},
            {"drawSplitString", "(Ljava/lang/String;IIII)V"},
            {"splitStringWidth", "(Ljava/lang/String;I)I"},
        };
        for (String[] m : fontMethods) {
            CtMethod cm = j.getMethod(m[0], m[1]);
            cm.insertBefore(tr);
        }
        j.writeFile(a[1]);

        // ---- Main menu: add Language button + handler ----
        CtClass at = pool.get("net.minecraft.client.c.at");
        CtMethod init = at.getMethod("b", "()V");
        init.insertAfter(
            "this.e.add(new net.minecraft.client.c.r(100, 4, this.d - 24, 120, 20, net.minecraft.client.Lang.label()));");
        CtMethod action = at.getMethod("a", "(Lnet/minecraft/client/c/r;)V");
        action.insertBefore(
            "if ($1.b == 100) { net.minecraft.client.Lang.cycle(); this.b.a((net.minecraft.client.c.i)this); return; }");
        at.writeFile(a[1]);

        System.out.println("StructPatch: font renderer + main menu patched");
    }
}
