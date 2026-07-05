/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import java.awt.FileDialog;
import java.io.File;
import java.io.FilenameFilter;
import net.minecraft.client.c.C_e;
import net.minecraft.client.c.C_q;

final class C_f
extends Thread {
    private /* synthetic */ C_e a;

    C_f(C_e c_e) {
        this.a = c_e;
    }

    public final void run() {
        try {
            FileDialog fileDialog = this.a.e();
            Object object = new File(this.a.b.z, "saves");
            ((File)object).mkdir();
            object = ((File)object).toString();
            if (!((String)object).endsWith(File.separator)) {
                object = (String)object + File.separator;
            }
            fileDialog.setDirectory((String)object);
            object = new C_q(this);
            fileDialog.setFilenameFilter((FilenameFilter)object);
            fileDialog.setLocationRelativeTo(this.a.b.j);
            fileDialog.setVisible(true);
            if (fileDialog.getFile() != null) {
                object = fileDialog.getDirectory();
                if (!((String)object).endsWith(File.separator)) {
                    object = (String)object + File.separator;
                }
                C_e.a(this.a, new File((String)object + fileDialog.getFile()));
            }
            return;
        }
        finally {
            C_e.a(this.a, false);
        }
    }
}

