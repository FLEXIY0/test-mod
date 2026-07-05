/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.c;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.c.C_b;

public class C_d
extends C_b {
    private final int treeMetadata = 3;
    private final int leavesMetadata = 5;

    @Override
    public boolean generate(C_g c_g, Random random, int n, int n2, int n3) {
        int n4 = random.nextInt(5) + 7;
        int n5 = n4 - random.nextInt(2) - 3;
        int n6 = n4 - n5;
        int n7 = 1 + random.nextInt(n6 + 1);
        boolean bl = true;
        if (n2 >= 1 && n2 + n4 + 1 <= c_g.c) {
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            for (n12 = n2; n12 <= n2 + 1 + n4 && bl; ++n12) {
                n11 = n12 - n2 < n5 ? 0 : n7;
                for (n10 = n - n11; n10 <= n + n11 && bl; ++n10) {
                    for (n9 = n3 - n11; n9 <= n3 + n11 && bl; ++n9) {
                        if (n12 >= 0 && n12 < c_g.c && n10 >= 0 && n10 < c_g.a && n9 >= 0 && n9 < c_g.b) {
                            n8 = c_g.a(n10, n12, n9);
                            if (n8 == 0 || n8 == C_x.z.at) continue;
                            bl = false;
                            continue;
                        }
                        bl = false;
                    }
                }
            }
            if (!bl) {
                c_g.cantGrow = true;
                return false;
            }
            n12 = c_g.a(n, n2 - 1, n3);
            if ((n12 == C_x.j.at || n12 == C_x.k.at) && n2 < c_g.c - n4 - 1) {
                c_g.a(n, n2 - 1, n3, C_x.k.at);
                n11 = 0;
                for (n10 = n2 + n4; n10 >= n2 + n5; --n10) {
                    for (n9 = n - n11; n9 <= n + n11; ++n9) {
                        n8 = n9 - n;
                        for (int i = n3 - n11; i <= n3 + n11; ++i) {
                            int n13 = i - n3;
                            if (Math.abs(n8) == n11 && Math.abs(n13) == n11 && n11 > 0 || C_x.e[c_g.a(n9, n10, i)]) continue;
                            c_g.setBlockAndMetadata(n9, n10, i, C_x.z.at, this.leavesMetadata);
                        }
                    }
                    if (n11 >= 1 && n10 == n2 + n5 + 1) {
                        --n11;
                        continue;
                    }
                    if (n11 >= n7) continue;
                    ++n11;
                }
                for (n10 = 0; n10 < n4 - 1; ++n10) {
                    n9 = c_g.a(n, n2 + n10, n3);
                    if (n9 != 0 && n9 != C_x.z.at) continue;
                    c_g.setBlockAndMetadata(n, n2 + n10, n3, C_x.y.at, this.treeMetadata);
                }
                c_g.cantGrow = false;
                return true;
            }
            c_g.cantGrow = true;
            return false;
        }
        c_g.cantGrow = true;
        return false;
    }
}

