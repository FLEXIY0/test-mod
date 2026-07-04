/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import com.a.a.NBTTagCompound;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.minecraft.client.c.C_bc;
import net.minecraft.client.c.C_bd;
import net.minecraft.client.g.C_a;

final class C_bb
extends Thread {
    private C_bd screen;
    final /* synthetic */ C_bd this$0;

    C_bb(C_bd c_bd, C_bd c_bd2) {
        this.this$0 = c_bd;
        this.screen = c_bd2;
    }

    @Override
    public final void run() {
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Skin images", "png");
        C_bc c_bc = new C_bc(this.this$0);
        jFileChooser.setFileFilter(fileNameExtensionFilter);
        jFileChooser.addChoosableFileFilter(c_bc);
        jFileChooser.setMultiSelectionEnabled(false);
        int n = jFileChooser.showOpenDialog(this.screen.b.j);
        if (n == 0) {
            File file = jFileChooser.getSelectedFile();
            File file2 = new File(this.screen.b.z, "characters/char" + C_bd.access$000(this.screen) + ".png");
            if (c_bc.accept(file)) {
                C_bd.access$102(this.screen, true);
                try {
                    this.screen.copyDirectory(file, file2);
                    this.screen.skinID = "characters/char" + C_bd.access$000(this.screen) + ".png";
                    NBTTagCompound nBTTagCompound = C_bd.access$200((C_bd)this.screen).currentCharacter;
                    if (nBTTagCompound != null) {
                        nBTTagCompound.a("Skin", this.screen.skinID);
                    }
                    C_bd.access$200(this.screen).saveCharacter(C_bd.access$000(this.screen), nBTTagCompound);
                    this.screen.player = new C_a(this.screen.b, null, this.screen.b.h);
                    if (C_bd.access$200((C_bd)this.screen).currentCharacter != null) {
                        this.screen.player.d(C_bd.access$200((C_bd)this.screen).currentCharacter);
                    }
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            } else {
                C_bd.access$102(this.screen, false);
            }
        }
    }
}

