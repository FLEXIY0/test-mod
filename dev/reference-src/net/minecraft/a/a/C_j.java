/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.d.C_b;
import util.MathHelper;

public class C_j {
    public List<net.minecraft.a.c.C_b>[] entities = new List[128];

    public C_j() {
        for (int i = 0; i < this.entities.length; ++i) {
            this.entities[i] = new ArrayList<net.minecraft.a.c.C_b>();
        }
    }

    public void addEntity(net.minecraft.a.c.C_b c_b) {
        int n = MathHelper.a((double)c_b.h / 16.0);
        int n2 = MathHelper.a((double)c_b.j / 16.0);
        int n3 = MathHelper.a((double)c_b.i / 16.0);
        if (n3 < 0) {
            n3 = 0;
        }
        if (n3 >= this.entities.length) {
            n3 = this.entities.length - 1;
        }
        c_b.chunkCoordX = n;
        c_b.chunkCoordY = n3;
        c_b.chunkCoordZ = n2;
        this.entities[n3].add(c_b);
    }

    public void removeEntity(net.minecraft.a.c.C_b c_b) {
        this.removeEntityAtIndex(c_b, c_b.chunkCoordY);
    }

    public void removeEntityAtIndex(net.minecraft.a.c.C_b c_b, int n) {
        if (n < 0) {
            n = 0;
        }
        if (n >= this.entities.length) {
            n = this.entities.length - 1;
        }
        this.entities[n].remove(c_b);
    }

    public void getEntitiesWithinAABBForEntity(net.minecraft.a.c.C_b c_b, C_b c_b2, List<net.minecraft.a.c.C_b> list) {
        int n = MathHelper.a(((double)c_b2.b - 2.0) / 16.0);
        int n2 = MathHelper.a(((double)c_b2.e + 2.0) / 16.0);
        if (n < 0) {
            n = 0;
        }
        if (n2 >= this.entities.length) {
            n2 = this.entities.length - 1;
        }
        for (int i = n; i <= n2; ++i) {
            List<net.minecraft.a.c.C_b> list2 = this.entities[i];
            for (int j = 0; j < list2.size(); ++j) {
                net.minecraft.a.c.C_b c_b3 = list2.get(j);
                if (c_b3 == c_b || !c_b3.r.a(c_b2)) continue;
                list.add(c_b3);
            }
        }
    }

    public void getEntitiesOfTypeWithinAAAB(Class<? extends net.minecraft.a.c.C_b> clazz, C_b c_b, List<net.minecraft.a.c.C_b> list) {
        int n = MathHelper.a(((double)c_b.b - 2.0) / 16.0);
        int n2 = MathHelper.a(((double)c_b.e + 2.0) / 16.0);
        if (n < 0) {
            n = 0;
        }
        if (n2 >= this.entities.length) {
            n2 = this.entities.length - 1;
        }
        for (int i = n; i <= n2; ++i) {
            List<net.minecraft.a.c.C_b> list2 = this.entities[i];
            for (int j = 0; j < list2.size(); ++j) {
                net.minecraft.a.c.C_b c_b2 = list2.get(j);
                if (!clazz.isAssignableFrom(c_b2.getClass()) || !c_b2.r.a(c_b)) continue;
                list.add(c_b2);
            }
        }
    }
}

