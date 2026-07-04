/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a.c;

import java.io.IOException;
import java.io.InputStream;
import net.minecraft.client.d;

public abstract class C_i {
    public String texturePackFileName;
    public String firstDescriptionLine;
    public String secondDescriptionLine;
    public String unusedString;

    public void load() {
    }

    public void closeTexturePackFile() {
    }

    public void getPackDescription(d d2) throws IOException {
    }

    public void deleteThumbnailTexture(d d2) {
    }

    public void bindThumbnailTexture(d d2) {
    }

    public InputStream getResourceAsStream(String string) {
        return C_i.class.getResourceAsStream(string);
    }
}

