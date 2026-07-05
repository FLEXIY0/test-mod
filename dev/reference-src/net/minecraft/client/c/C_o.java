/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import net.minecraft.client.LevelIO;
import net.minecraft.client.c.C_e;
import net.minecraft.client.c.C_p;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;

public final class C_o
extends C_e {
    public C_o(GuiScreen guiScreen) {
        super(guiScreen);
        this.a = "Save level";
    }

    protected final FileDialog e() {
        return new FileDialog(null, "Save level", 1);
    }

    public final void b() {
        super.b();
        ((GuiButton)this.e.get((int)5)).a = "Save file...";
    }

    protected final void a(String[] stringArray) {
        for (int i = 0; i < 5; ++i) {
            ((GuiButton)this.e.get((int)i)).a = stringArray[i];
            ((GuiButton)this.e.get((int)i)).d = true;
        }
        ((GuiButton)this.e.get((int)5)).d = true;
    }

    protected final void a(File object) {
        try {
            object = new FileOutputStream((File)object);
            new LevelIO(this.b, this.b.p).a(this.b.d, (OutputStream)object);
            ((FileOutputStream)object).close();
            return;
        }
        catch (IOException iOException) {
            object = iOException;
            iOException.printStackTrace();
            return;
        }
    }

    protected final void a(int n) {
        this.b.a(new C_p(this, ((GuiButton)this.e.get((int)n)).a, n));
    }
}

