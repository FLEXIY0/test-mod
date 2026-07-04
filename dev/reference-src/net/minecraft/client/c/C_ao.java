/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import net.minecraft.client.c.C_ap;

class C_ao
extends FileFilter {
    final /* synthetic */ C_ap this$0;

    C_ao(C_ap c_ap) {
        this.this$0 = c_ap;
    }

    @Override
    public boolean accept(File file) {
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            int n = bufferedImage.getWidth();
            int n2 = bufferedImage.getHeight();
            return n == 64 && n2 == 32;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }

    @Override
    public String getDescription() {
        return "Check image dimensions";
    }
}

