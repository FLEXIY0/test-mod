/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a.c;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.a.c.C_i;
import net.minecraft.client.a.c.C_j;
import net.minecraft.client.a.c.C_k;
import net.minecraft.client.d;

public class C_l {
    private List<C_i> availableTexturePacks = new ArrayList<C_i>();
    private C_i defaultTexturePack = new C_k();
    public C_i selectedTexturePack;
    private Map<String, C_j> textureMap = new HashMap<String, C_j>();
    private d mc;
    private File texturePackDir;
    private String currentTexturePack;

    public C_l(d d2, File file) {
        this.mc = d2;
        this.texturePackDir = new File("texturepacks");
        if (!this.texturePackDir.exists()) {
            this.texturePackDir.mkdirs();
        }
        this.currentTexturePack = d2.w.texturePack;
        this.updateAvaliableTexturePacks();
        this.selectedTexturePack.load();
    }

    public boolean setTexturePack(C_i c_i) {
        if (c_i == this.selectedTexturePack) {
            return false;
        }
        this.selectedTexturePack.closeTexturePackFile();
        this.currentTexturePack = c_i.texturePackFileName;
        this.selectedTexturePack = c_i;
        this.mc.w.texturePack = this.currentTexturePack;
        this.mc.w.a();
        this.selectedTexturePack.load();
        return true;
    }

    public void updateAvaliableTexturePacks() {
        ArrayList<C_i> arrayList = new ArrayList<C_i>();
        this.selectedTexturePack = null;
        arrayList.add(this.defaultTexturePack);
        if (this.texturePackDir.exists() && this.texturePackDir.isDirectory()) {
            File[] object = this.texturePackDir.listFiles();
            File[] object2 = object;
            int n = object.length;
            for (int i = 0; i < n; ++i) {
                File file = object2[i];
                if (!file.isFile() || !file.getName().toLowerCase().endsWith(".zip")) continue;
                String string = file.getName() + ":" + file.length() + ":" + file.lastModified();
                try {
                    C_i c_i;
                    if (!this.textureMap.containsKey(string)) {
                        c_i = new C_j(file);
                        ((C_j)c_i).unusedString = string;
                        this.textureMap.put(string, (C_j)c_i);
                        ((C_j)c_i).getPackDescription(this.mc);
                    }
                    c_i = this.textureMap.get(string);
                    if (c_i.texturePackFileName.equals(this.currentTexturePack)) {
                        this.selectedTexturePack = c_i;
                    }
                    arrayList.add(c_i);
                    continue;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
        if (this.selectedTexturePack == null) {
            this.selectedTexturePack = this.defaultTexturePack;
        }
        this.availableTexturePacks.removeAll(arrayList);
        for (C_i c_i : this.availableTexturePacks) {
            c_i.deleteThumbnailTexture(this.mc);
            this.textureMap.remove(c_i.unusedString);
        }
        this.availableTexturePacks = arrayList;
    }

    public List<C_i> availableTexturePacks() {
        return new ArrayList<C_i>(this.availableTexturePacks);
    }
}

