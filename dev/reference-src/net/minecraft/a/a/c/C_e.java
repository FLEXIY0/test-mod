/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.c;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.c.C_b;

public class C_e
extends C_b {
    private final int treeMetadata = 3;
    private final int leavesMetadata = 5;

    @Override
    public boolean generate(C_g c_g, Random random, int n, int n2, int n3) {
        int n4 = random.nextInt(4) + 6;
        int n5 = 1 + random.nextInt(2);
        int n6 = n4 - n5;
        int n7 = 2 + random.nextInt(2);
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
                int n13;
                int n14;
                c_g.a(n, n2 - 1, n3, C_x.k.at);
                n11 = random.nextInt(2);
                n10 = 1;
                n9 = 0;
                for (n8 = 0; n8 <= n6; ++n8) {
                    n14 = n2 + n4 - n8;
                    for (n13 = n - n11; n13 <= n + n11; ++n13) {
                        int n15 = n13 - n;
                        for (int i = n3 - n11; i <= n3 + n11; ++i) {
                            int n16 = i - n3;
                            if (Math.abs(n15) == n11 && Math.abs(n16) == n11 && n11 > 0 || C_x.e[c_g.a(n13, n14, i)]) continue;
                            c_g.setBlockAndMetadata(n13, n14, i, C_x.z.at, this.leavesMetadata);
                        }
                    }
                    if (n11 >= n10) {
                        n11 = n9;
                        n9 = 1;
                        if (++n10 <= n7) continue;
                        n10 = n7;
                        continue;
                    }
                    ++n11;
                }
                n8 = random.nextInt(3);
                for (n14 = 0; n14 < n4 - n8; ++n14) {
                    n13 = c_g.a(n, n2 + n14, n3);
                    if (n13 != 0 && n13 != C_x.z.at) continue;
                    c_g.setBlockAndMetadata(n, n2 + n14, n3, C_x.y.at, this.treeMetadata);
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

