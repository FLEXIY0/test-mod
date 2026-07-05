/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.C_e;
import net.minecraft.client.a.C_d;
import net.minecraft.client.c.FontRenderer;
import net.minecraft.client.c.Gui;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.d;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiScreen
extends Gui {
    protected d b;
    public int c;
    public int d;
    protected List<GuiButton> e = new ArrayList<GuiButton>();
    public boolean f = false;
    protected FontRenderer g;
    private GuiButton selectedButton = null;
    protected int viewportTexture;
    private static final boolean crapOS = net.minecraft.client.d.getOS() == C_e.d;

    public void a(int n, int n2, float f) {
        for (int i = 0; i < this.e.size(); ++i) {
            this.e.get(i).a(this.b, n, n2);
            this.e.get(i).mouseDragged(this.b, n, n2);
        }
    }

    protected void a(char c, int n) {
        if (n == this.b.w.keyBindPause.b && this.b.d != null) {
            this.b.a((GuiScreen)null);
            this.b.b();
        }
    }

    protected void mouseClick(int n, int n2, int n3) {
        GuiButton guiButton;
        if (n3 == 0) {
            for (n3 = 0; n3 < this.e.size(); ++n3) {
                guiButton = this.e.get(n3);
                if (!guiButton.mousePressed(this.b, n, n2)) continue;
                this.selectedButton = guiButton;
                this.b.x.a("random.click", 1.0f, 1.0f);
                this.a(guiButton);
            }
        }
        if (n3 == 1) {
            for (n3 = 0; n3 < this.e.size(); ++n3) {
                guiButton = this.e.get(n3);
                if (!guiButton.mousePressed(this.b, n, n2)) continue;
                this.selectedButton = guiButton;
                this.altClick(guiButton);
            }
        }
    }

    protected void mouseMoved(int n, int n2, int n3) {
        if (this.selectedButton != null && n3 == 0) {
            this.selectedButton.mouseReleased(n, n2);
            this.selectedButton = null;
        }
    }

    protected void a(GuiButton guiButton) {
    }

    protected void altClick(GuiButton guiButton) {
    }

    public final void a(d d2, int n, int n2) {
        this.b = d2;
        this.g = d2.n;
        this.c = n;
        this.d = n2;
        this.b();
        int n3 = this.b.b;
        int n4 = this.b.c;
        IntBuffer intBuffer = BufferUtils.createIntBuffer((int)1);
        GL11.glGenTextures((IntBuffer)intBuffer);
        this.viewportTexture = intBuffer.get(0);
        GL11.glBindTexture((int)3553, (int)this.viewportTexture);
        GL11.glTexImage2D((int)3553, (int)0, (int)6407, (int)n3, (int)n4, (int)0, (int)6407, (int)5121, (ByteBuffer)null);
        GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
    }

    public void b() {
    }

    public void f() {
        if (Mouse.getEventButtonState()) {
            int n = Mouse.getEventX() * this.c / this.b.b;
            int n2 = this.d - Mouse.getEventY() * this.d / this.b.c - 1;
            this.mouseClick(n, n2, Mouse.getEventButton());
        } else if (this.selectedButton != null && this.selectedButton.slider) {
            int n = Mouse.getEventX() * this.c / this.b.b;
            int n3 = this.d - Mouse.getEventY() * this.d / this.b.c - 1;
            this.mouseMoved(n, n3, Mouse.getEventButton());
        } else {
            Mouse.getEventX();
            Mouse.getEventY();
            Mouse.getEventButton();
        }
    }

    public final void g() {
        if (Keyboard.getEventKeyState()) {
            if (Keyboard.getEventKey() == 87) {
                this.b.d();
                return;
            }
            this.a(Keyboard.getEventCharacter(), Keyboard.getEventKey());
        }
    }

    public void f_() {
    }

    public void a() {
        GL11.glDeleteTextures((int)this.viewportTexture);
    }

    public final void h() {
        if (this.b.d != null) {
            if (this.b.w.blur > 0.0f) {
                this.applyBlur();
            }
            GuiScreen.a(0, 0, this.c, this.d, 0x60050500, -1607454624);
        } else {
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2912);
            C_d c_d = C_d.a;
            GL11.glBindTexture((int)3553, (int)this.b.m.a("/dirt.png"));
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            c_d.b();
            c_d.b(0x404040);
            c_d.a(0.0f, this.d, 0.0f, 0.0f, (float)this.d / 32.0f);
            c_d.a(this.c, this.d, 0.0f, (float)this.c / 32.0f, (float)this.d / 32.0f);
            c_d.a(this.c, 0.0f, 0.0f, (float)this.c / 32.0f, 0.0f);
            c_d.a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
            c_d.a();
            GL11.glEnable((int)2929);
        }
    }

    protected void applyBlur() {
        GL11.glBindTexture((int)3553, (int)this.viewportTexture);
        GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
        GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
        GL11.glCopyTexSubImage2D((int)3553, (int)0, (int)0, (int)0, (int)0, (int)0, (int)this.b.b, (int)this.b.c);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)false);
        C_d c_d = C_d.a;
        int n = 8;
        float f = this.b.w.blur * 4.0f;
        this.renderBlurPass(c_d, n, f / (float)this.b.b, true);
        GL11.glCopyTexSubImage2D((int)3553, (int)0, (int)0, (int)0, (int)0, (int)0, (int)this.b.b, (int)this.b.c);
        this.renderBlurPass(c_d, n, f / (float)this.b.c, false);
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
    }

    private void renderBlurPass(C_d c_d, int n, float f, boolean bl) {
        for (int i = 0; i < n; ++i) {
            float f2 = 1.0f / (float)(i + 1);
            float f3 = (float)(i - n / 2) * f;
            float f4 = bl ? f3 : 0.0f;
            float f5 = bl ? 0.0f : f3;
            c_d.b();
            c_d.a(1.0f, 1.0f, 1.0f, f2);
            c_d.a(this.c, this.d, this.h, 1.0f + f4, 0.0f + f5);
            c_d.a(this.c, 0.0f, this.h, 1.0f + f4, 1.0f + f5);
            c_d.a(0.0f, 0.0f, this.h, 0.0f + f4, 1.0f + f5);
            c_d.a(0.0f, this.d, this.h, 0.0f + f4, 0.0f + f5);
            c_d.a();
        }
    }

    public boolean c() {
        return true;
    }

    public void buttonAction(boolean bl, int n) {
    }

    public static String getClipboardString() {
        try {
            Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String string = (String)transferable.getTransferData(DataFlavor.stringFlavor);
                return string;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }

    public void selectNextField() {
    }

    public void refreshScreen() {
    }

    public void confirmClicked(boolean bl, int n) {
    }

    public static boolean shift() {
        return Keyboard.isKeyDown((int)42) || Keyboard.isKeyDown((int)54);
    }

    public static boolean ctrl() {
        boolean bl = Keyboard.isKeyDown((int)28) && Keyboard.getEventCharacter() == '\u0000';
        return Keyboard.isKeyDown((int)29) || Keyboard.isKeyDown((int)157) || crapOS && (bl || Keyboard.isKeyDown((int)219) || Keyboard.isKeyDown((int)220));
    }

    public static void setClipboardString(String string) {
        try {
            StringSelection stringSelection = new StringSelection(string);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

