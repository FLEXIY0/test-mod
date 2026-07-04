/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import net.minecraft.client.c.C_bd;

class C_bc
extends FileFilter {
    final /* synthetic */ C_bd this$0;

    C_bc(C_bd c_bd) {
        this.this$0 = c_bd;
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

