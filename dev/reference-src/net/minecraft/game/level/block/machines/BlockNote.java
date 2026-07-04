/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.b.a.C_i;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.container.BlockContainer;

public class BlockNote
extends BlockContainer {
    public BlockNote(int n) {
        super(n, C_c.c);
        this.as = 196;
    }

    @Override
    public int a(int n) {
        if (n == 0 || n == 1) {
            return 262;
        }
        return this.as;
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3, int n4) {
        if (n4 > 0 && C_x.c[n4].canProvidePower()) {
            boolean bl = c_g.isBlockGettingPowered(n, n2, n3);
            C_i c_i = (C_i)c_g.j(n, n2, n3);
            if (c_i.previousRedstoneState != bl) {
                if (bl) {
                    c_i.triggerNote(c_g, n, n2, n3);
                }
                c_i.previousRedstoneState = bl;
            }
        }
    }

    @Override
    public boolean a(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (c_g.multiplayerWorld) {
            return true;
        }
        C_i c_i = (C_i)c_g.j(n, n2, n3);
        c_i.changePitch();
        c_i.triggerNote(c_g, n, n2, n3);
        entityPlayer.addStat(StatList.noteUse, 1);
        return true;
    }

    @Override
    public void onBlockClicked(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (!c_g.multiplayerWorld) {
            C_i c_i = (C_i)c_g.j(n, n2, n3);
            c_i.triggerNote(c_g, n, n2, n3);
        }
    }

    @Override
    public C_a getBlockEntity() {
        return new C_i();
    }

    @Override
    public void playBlock(C_g c_g, int n, int n2, int n3, int n4, int n5) {
        float f = (float)Math.pow(2.0, (double)(n5 - 12) / 12.0);
        String string = "harp";
        if (n4 == 1) {
            string = "bd";
        }
        if (n4 == 2) {
            string = "snare";
        }
        if (n4 == 3) {
            string = "hat";
        }
        if (n4 == 4) {
            string = "bassattack";
        }
        if (n4 == 5) {
            string = "pling";
        }
        if (n4 == 6) {
            string = "guitar";
        }
        if (n4 == 7) {
            string = "bell";
        }
        if (n4 == 8) {
            string = "flute";
        }
        c_g.playSoundAtBlock((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "note." + string, 3.0f, f);
        c_g.a("note", (float)n + 0.5f, (float)n2 + 1.2f, (float)n3 + 0.5f, (float)n5 / 24.0f, 0.0f, 0.0f);
    }
}

