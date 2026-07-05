/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import com.a.a.NBTTagCompound;

public class C_ax
implements Comparable<C_ax> {
    public String name;
    public String ip;
    public String playerCount;
    public String motd;
    public String serversideName;
    public int gamemode = -1;
    public long ping;
    public boolean pinged = false;

    public C_ax(String string, String string2) {
        this.name = string;
        this.ip = string2;
    }

    public NBTTagCompound getCompoundTag() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound.a("name", this.name);
        nBTTagCompound.a("ip", this.ip);
        return nBTTagCompound;
    }

    public static C_ax createFromCompound(NBTTagCompound nBTTagCompound) {
        return new C_ax(nBTTagCompound.g("name"), nBTTagCompound.g("ip"));
    }

    @Override
    public int compareTo(C_ax c_ax) {
        return this.name.compareToIgnoreCase(c_ax.name);
    }
}

