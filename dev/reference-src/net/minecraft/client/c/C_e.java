/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import net.minecraft.a.a.World;
import net.minecraft.client.LevelIO;
import net.minecraft.client.c.C_f;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;

public class C_e
extends GuiScreen
implements Runnable {
    private GuiScreen i;
    private boolean j = false;
    private boolean k = false;
    private String[] l = null;
    private String m = "";
    protected String a = "Load level";
    private boolean n = false;
    private File o;

    public C_e(GuiScreen guiScreen) {
        this.i = guiScreen;
    }

    public final void f_() {
        if (this.o != null) {
            if (!this.o.getName().endsWith(".mclevel")) {
                this.o = new File(this.o.getAbsolutePath() + ".mclevel");
            }
            this.a(this.o);
            this.o = null;
            this.b.a((GuiScreen)null);
        }
    }

    public void run() {
        try {
            this.m = "Getting level list..";
            Object object = new URL("http://" + this.b.i + "/listmaps.jsp?user=" + this.b.h.b);
            object = new BufferedReader(new InputStreamReader(((URL)object).openConnection().getInputStream()));
            this.l = ((BufferedReader)object).readLine().split(";");
            if (this.l.length >= 5) {
                this.a(this.l);
                this.k = true;
                return;
            }
            this.m = this.l[0];
            this.j = true;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            this.m = "Failed to load levels";
            this.j = true;
        }
    }

    protected void a(String[] stringArray) {
        for (int i = 0; i < 5; ++i) {
            ((GuiButton)this.e.get((int)i)).c = !stringArray[i].equals("-");
            ((GuiButton)this.e.get((int)i)).a = stringArray[i];
            ((GuiButton)this.e.get((int)i)).d = true;
        }
        ((GuiButton)this.e.get((int)5)).d = true;
    }

    public void b() {
        new Thread(this).start();
        for (int i = 0; i < 5; ++i) {
            this.e.add(new GuiButton(i, this.c / 2 - 100, this.d / 6 + i * 24, "---"));
            ((GuiButton)this.e.get((int)i)).d = false;
        }
        this.e.add(new GuiButton(5, this.c / 2 - 100, this.d / 6 + 120 + 12, "Load file..."));
        this.e.add(new GuiButton(6, this.c / 2 - 100, this.d / 6 + 168, "Cancel"));
        ((GuiButton)this.e.get((int)5)).d = false;
    }

    protected final void a(GuiButton guiButton) {
        if (this.n) {
            return;
        }
        if (!guiButton.c) {
            return;
        }
        if (this.k && guiButton.b < 5) {
            this.a(guiButton.b);
        }
        if (this.j || this.k && guiButton.b == 5) {
            this.n = true;
            C_f c_f = new C_f(this);
            c_f.setDaemon(true);
            c_f.start();
        }
        if (this.j || this.k && guiButton.b == 6) {
            this.b.a(this.i);
        }
    }

    protected FileDialog e() {
        return new FileDialog(null, "Load level", 0);
    }

    protected void a(int n) {
        this.b.a((GuiScreen)null);
        this.b.b();
    }

    public final void a(int n, int n2, float f) {
        this.h();
        C_e.a(this.g, this.a, this.c / 2, 20, 0xFFFFFF);
        if (!this.k) {
            C_e.a(this.g, this.m, this.c / 2, this.d / 2 - 4, 0xFFFFFF);
        }
        super.a(n, n2, f);
    }

    protected void a(File object) {
        try {
            object = new FileInputStream((File)object);
            World c_g = new LevelIO(this.b, this.b.p).a((InputStream)object);
            ((FileInputStream)object).close();
            this.b.a(c_g);
            return;
        }
        catch (IOException iOException) {
            object = iOException;
            iOException.printStackTrace();
            return;
        }
    }

    static /* synthetic */ File a(C_e c_e, File file) {
        c_e.o = file;
        return c_e.o;
    }

    static /* synthetic */ boolean a(C_e c_e, boolean bl) {
        c_e.n = false;
        return false;
    }
}

