/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import com.a.a.NBTTagCompound;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.minecraft.client.c.C_ao;
import net.minecraft.client.c.C_ap;
import net.minecraft.client.g.C_a;

final class C_an
extends Thread {
    private C_ap screen;
    final /* synthetic */ C_ap this$0;

    C_an(C_ap c_ap, C_ap c_ap2) {
        this.this$0 = c_ap;
        this.screen = c_ap2;
    }

    @Override
    public final void run() {
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Skin images", "png");
        C_ao c_ao = new C_ao(this.this$0);
        jFileChooser.setFileFilter(fileNameExtensionFilter);
        jFileChooser.addChoosableFileFilter(c_ao);
        jFileChooser.setMultiSelectionEnabled(false);
        int n = jFileChooser.showOpenDialog(this.screen.b.j);
        if (n == 0) {
            File file = jFileChooser.getSelectedFile();
            File file2 = new File(this.screen.b.z, "characters/char" + C_ap.access$000(this.screen) + ".png");
            if (c_ao.accept(file)) {
                C_ap.access$102(this.screen, true);
                try {
                    this.screen.copyDirectory(file, file2);
                    C_ap.access$202(this.screen, "characters/char" + C_ap.access$000(this.screen) + ".png");
                    NBTTagCompound nBTTagCompound = C_ap.access$300((C_ap)this.screen).currentCharacter;
                    if (nBTTagCompound != null) {
                        nBTTagCompound.a("Skin", C_ap.access$200(this.screen));
                    }
                    C_ap.access$300(this.screen).saveCharacter(C_ap.access$000(this.screen), nBTTagCompound);
                    C_ap.access$402(this.screen, new C_a(this.screen.b, null, this.screen.b.h));
                    if (C_ap.access$300((C_ap)this.screen).currentCharacter != null) {
                        C_ap.access$400(this.screen).d(C_ap.access$300((C_ap)this.screen).currentCharacter);
                    }
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            } else {
                C_ap.access$102(this.screen, false);
            }
        }
    }
}

