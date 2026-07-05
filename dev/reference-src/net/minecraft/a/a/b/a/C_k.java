/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.b.a.C_a;

public class C_k
extends C_a {
    public int record;

    @Override
    public void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
        this.record = nBTTagCompound.d("Record");
    }

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        nBTTagCompound.a("id", "Jukebox");
        if (this.record > 0) {
            nBTTagCompound.a("Record", this.record);
        }
    }
}

