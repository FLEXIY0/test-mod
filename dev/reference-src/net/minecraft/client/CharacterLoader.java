/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import com.a.a.C_m;
import com.a.a.NBTTagCompound;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import net.minecraft.client.d;
import net.minecraft.client.g.EntityPlayerSP;

public class CharacterLoader {
    public NBTTagCompound currentCharacter;
    protected d mc;

    public CharacterLoader(d d2, int n) {
        this.mc = d2;
        try {
            if (new File(d2.z, "characters/char" + n + ".dat").exists()) {
                this.currentCharacter = this.readCharacter(n);
            } else {
                NBTTagCompound nBTTagCompound = new NBTTagCompound();
                EntityPlayerSP c_a = new EntityPlayerSP(this.mc, null, this.mc.h);
                c_a.c(nBTTagCompound);
                this.currentCharacter = nBTTagCompound;
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void saveCharacter(int n, NBTTagCompound nBTTagCompound) throws IOException {
        new File(this.mc.z, "characters").mkdirs();
        C_m.writeTags(nBTTagCompound, new FileOutputStream(new File(this.mc.z, "characters/char" + n + ".dat")));
    }

    public NBTTagCompound readCharacter(int n) throws IOException {
        return C_m.readTags(new FileInputStream(new File(this.mc.z, "characters/char" + n + ".dat")));
    }
}

