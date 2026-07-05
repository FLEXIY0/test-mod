/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.d.Material;

public class C_i
extends TileEntity {
    public byte note = 0;
    public boolean previousRedstoneState = false;

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        nBTTagCompound.a("note", this.note);
        nBTTagCompound.a("id", "Noteblock");
    }

    @Override
    public void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
        this.note = nBTTagCompound.b("note");
        if (this.note < 0) {
            this.note = 0;
        }
        if (this.note > 24) {
            this.note = (byte)24;
        }
    }

    public void changePitch() {
        this.note = (byte)((this.note + 1) % 25);
        this.onInventoryChanged();
    }

    public void triggerNote(World c_g, int n, int n2, int n3) {
        if (c_g.f(n, n2 + 1, n3) == Material.a) {
            Material c_c = c_g.f(n, n2 - 1, n3);
            int n4 = 0;
            if (c_c == Material.d) {
                n4 = 1;
            }
            if (c_c == Material.m) {
                n4 = 2;
            }
            if (c_c == Material.o) {
                n4 = 3;
            }
            if (c_c == Material.c) {
                n4 = 4;
            }
            if (c_c == Material.e) {
                n4 = 5;
            }
            if (c_c == Material.k) {
                n4 = 6;
            }
            if (c_c == Material.ice) {
                n4 = 7;
            }
            if (c_c == Material.pumpkin) {
                n4 = 8;
            }
            c_g.playNoteAt(n, n2, n3, n4, this.note);
        }
    }
}

