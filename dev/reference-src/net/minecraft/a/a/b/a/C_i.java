/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.d.C_c;

public class C_i
extends C_a {
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

    public void triggerNote(C_g c_g, int n, int n2, int n3) {
        if (c_g.f(n, n2 + 1, n3) == C_c.a) {
            C_c c_c = c_g.f(n, n2 - 1, n3);
            int n4 = 0;
            if (c_c == C_c.d) {
                n4 = 1;
            }
            if (c_c == C_c.m) {
                n4 = 2;
            }
            if (c_c == C_c.o) {
                n4 = 3;
            }
            if (c_c == C_c.c) {
                n4 = 4;
            }
            if (c_c == C_c.e) {
                n4 = 5;
            }
            if (c_c == C_c.k) {
                n4 = 6;
            }
            if (c_c == C_c.ice) {
                n4 = 7;
            }
            if (c_c == C_c.pumpkin) {
                n4 = 8;
            }
            c_g.playNoteAt(n, n2, n3, n4, this.note);
        }
    }
}

