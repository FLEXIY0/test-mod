/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jorbis;

import com.jcraft.jorbis.Block;
import com.jcraft.jorbis.Residue0;

class Residue2
extends Residue0 {
    Residue2() {
    }

    int inverse(Block block, Object object, float[][] fArray, int[] nArray, int n) {
        int n2;
        for (n2 = 0; n2 < n && nArray[n2] == 0; ++n2) {
        }
        if (n2 == n) {
            return 0;
        }
        return Residue2._2inverse(block, object, fArray, n);
    }
}

