/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.c;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.imageio.ImageIO;
import net.minecraft.client.a.c.C_i;
import net.minecraft.client.d;
import org.lwjgl.opengl.GL11;

public class C_j
extends C_i {
    private ZipFile texturePackZipFile;
    private int texturePackId = -1;
    private BufferedImage texturePackThumbnail;
    private File texturePackFile;

    public C_j(File file) {
        this.texturePackFileName = file.getName();
        this.texturePackFile = file;
    }

    private String truncateString(String string) {
        if (string != null && string.length() > 34) {
            string = string.substring(0, 34);
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void getPackDescription(d d2) throws IOException {
        ZipFile zipFile = null;
        InputStream inputStream = null;
        try {
            zipFile = new ZipFile(this.texturePackFile);
            try {
                inputStream = zipFile.getInputStream(zipFile.getEntry("pack.txt"));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                this.firstDescriptionLine = this.truncateString(bufferedReader.readLine());
                this.secondDescriptionLine = this.truncateString(bufferedReader.readLine());
                bufferedReader.close();
                inputStream.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
            try {
                inputStream = zipFile.getInputStream(zipFile.getEntry("gui/pack.png"));
                this.texturePackThumbnail = ImageIO.read(inputStream);
                inputStream.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
            zipFile.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            }
            catch (Exception exception) {}
            try {
                zipFile.close();
            }
            catch (Exception exception) {}
        }
    }

    @Override
    public void deleteThumbnailTexture(d d2) {
        if (this.texturePackThumbnail != null) {
            d2.m.delete(this.texturePackId);
        }
        this.closeTexturePackFile();
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

    @Override
    public void load() {
        try {
            this.texturePackZipFile = new ZipFile(this.texturePackFile);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void closeTexturePackFile() {
        try {
            this.texturePackZipFile.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.texturePackZipFile = null;
    }

    @Override
    public InputStream getResourceAsStream(String string) {
        try {
            ZipEntry zipEntry = this.texturePackZipFile.getEntry(string.substring(1));
            if (zipEntry != null) {
                return this.texturePackZipFile.getInputStream(zipEntry);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return C_i.class.getResourceAsStream(string);
    }
}

