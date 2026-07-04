/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.c;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.client.a.c.C_i;
import net.minecraft.client.d;
import org.lwjgl.opengl.GL11;

public class C_k
extends C_i {
    private int texturePackId = -1;
    private BufferedImage texturePackThumbnail;

    public C_k() {
        this.texturePackFileName = "Default";
        this.firstDescriptionLine = "The default look of Minecraft";
        try {
            this.texturePackThumbnail = ImageIO.read(C_k.class.getResource("/gui/pack.png"));
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public void deleteThumbnailTexture(d d2) {
        if (this.texturePackThumbnail != null) {
            d2.m.delete(this.texturePackId);
        }
    }

    @Override
    public void bindThumbnailTexture(d d2) {
        if (this.texturePackThumbnail != null && this.texturePackId < 0) {
            this.texturePackId = d2.m.getTexture(this.texturePackThumbnail);
        }
        if (this.texturePackThumbnail != null) {
            if (this.texturePackId >= 0) {
                GL11.glBindTexture((int)3553, (int)this.texturePackId);
            }
        } else {
            GL11.glBindTexture((int)3553, (int)d2.m.a("/gui/unknown_pack.png"));
        }
    }
}

