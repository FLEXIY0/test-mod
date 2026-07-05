/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;
import com.jcraft.jorbis.Block;
import com.jcraft.jorbis.CodeBook;
import com.jcraft.jorbis.DspState;
import com.jcraft.jorbis.FuncResidue;
import com.jcraft.jorbis.Info;
import com.jcraft.jorbis.InfoMode;
import com.jcraft.jorbis.Residue0$InfoResidue0;
import com.jcraft.jorbis.Residue0$LookResidue0;
import com.jcraft.jorbis.Util;

class Residue0
extends FuncResidue {
    private static int[][][] _01inverse_partword = new int[2][][];
    static int[][] _2inverse_partword = null;

    Residue0() {
    }

    void pack(Object object, Buffer buffer) {
        int n;
        object = (Residue0$InfoResidue0)object;
        int n2 = 0;
        buffer.write(((Residue0$InfoResidue0)object).begin, 24);
        buffer.write(((Residue0$InfoResidue0)object).end, 24);
        buffer.write(((Residue0$InfoResidue0)object).grouping - 1, 24);
        buffer.write(((Residue0$InfoResidue0)object).partitions - 1, 6);
        buffer.write(((Residue0$InfoResidue0)object).groupbook, 8);
        for (n = 0; n < ((Residue0$InfoResidue0)object).partitions; ++n) {
            int n3 = ((Residue0$InfoResidue0)object).secondstages[n];
            if (Util.ilog(n3) > 3) {
                buffer.write(n3, 3);
                buffer.write(1, 1);
                buffer.write(n3 >>> 3, 5);
            } else {
                buffer.write(n3, 4);
            }
            n2 += Util.icount(n3);
        }
        for (n = 0; n < n2; ++n) {
            buffer.write(((Residue0$InfoResidue0)object).booklist[n], 8);
        }
    }

    Object unpack(Info info, Buffer buffer) {
        int n;
        int n2 = 0;
        Residue0$InfoResidue0 residue0$InfoResidue0 = new Residue0$InfoResidue0(this);
        new Residue0$InfoResidue0(this).begin = buffer.read(24);
        residue0$InfoResidue0.end = buffer.read(24);
        residue0$InfoResidue0.grouping = buffer.read(24) + 1;
        residue0$InfoResidue0.partitions = buffer.read(6) + 1;
        residue0$InfoResidue0.groupbook = buffer.read(8);
        for (n = 0; n < residue0$InfoResidue0.partitions; ++n) {
            int n3 = buffer.read(3);
            if (buffer.read(1) != 0) {
                n3 |= buffer.read(5) << 3;
            }
            residue0$InfoResidue0.secondstages[n] = n3;
            n2 += Util.icount(n3);
        }
        for (n = 0; n < n2; ++n) {
            residue0$InfoResidue0.booklist[n] = buffer.read(8);
        }
        if (residue0$InfoResidue0.groupbook >= info.books) {
            this.free_info(residue0$InfoResidue0);
            return null;
        }
        for (n = 0; n < n2; ++n) {
            if (residue0$InfoResidue0.booklist[n] < info.books) continue;
            this.free_info(residue0$InfoResidue0);
            return null;
        }
        return residue0$InfoResidue0;
    }

    Object look(DspState dspState, InfoMode infoMode, Object object) {
        int n;
        int n2;
        int n3;
        int n4;
        object = (Residue0$InfoResidue0)object;
        Residue0$LookResidue0 residue0$LookResidue0 = new Residue0$LookResidue0(this);
        int n5 = 0;
        int n6 = 0;
        residue0$LookResidue0.info = object;
        residue0$LookResidue0.map = infoMode.mapping;
        residue0$LookResidue0.parts = ((Residue0$InfoResidue0)object).partitions;
        residue0$LookResidue0.fullbooks = dspState.fullbooks;
        residue0$LookResidue0.phrasebook = dspState.fullbooks[((Residue0$InfoResidue0)object).groupbook];
        int n7 = residue0$LookResidue0.phrasebook.dim;
        residue0$LookResidue0.partbooks = new int[residue0$LookResidue0.parts][];
        for (n4 = 0; n4 < residue0$LookResidue0.parts; ++n4) {
            n3 = ((Residue0$InfoResidue0)object).secondstages[n4];
            n2 = Util.ilog(n3);
            if (n2 == 0) continue;
            if (n2 > n6) {
                n6 = n2;
            }
            residue0$LookResidue0.partbooks[n4] = new int[n2];
            for (n = 0; n < n2; ++n) {
                if ((n3 & 1 << n) == 0) continue;
                residue0$LookResidue0.partbooks[n4][n] = ((Residue0$InfoResidue0)object).booklist[n5++];
            }
        }
        residue0$LookResidue0.partvals = (int)Math.rint(Math.pow(residue0$LookResidue0.parts, n7));
        residue0$LookResidue0.stages = n6;
        residue0$LookResidue0.decodemap = new int[residue0$LookResidue0.partvals][];
        for (n4 = 0; n4 < residue0$LookResidue0.partvals; ++n4) {
            n3 = n4;
            n2 = residue0$LookResidue0.partvals / residue0$LookResidue0.parts;
            residue0$LookResidue0.decodemap[n4] = new int[n7];
            for (n = 0; n < n7; ++n) {
                int n8 = n3 / n2;
                n3 -= n8 * n2;
                n2 /= residue0$LookResidue0.parts;
                residue0$LookResidue0.decodemap[n4][n] = n8;
            }
        }
        return residue0$LookResidue0;
    }

    void free_info(Object object) {
    }

    void free_look(Object object) {
    }

    static synchronized int _01inverse(Block block, Object object, float[][] fArray, int n, int n2) {
        int n3;
        Residue0$LookResidue0 residue0$LookResidue0 = (Residue0$LookResidue0)object;
        Residue0$InfoResidue0 residue0$InfoResidue0 = residue0$LookResidue0.info;
        int n4 = residue0$InfoResidue0.grouping;
        int n5 = residue0$LookResidue0.phrasebook.dim;
        int n6 = residue0$InfoResidue0.end - residue0$InfoResidue0.begin;
        int n7 = n6 / n4;
        n6 = (n7 + n5 - 1) / n5;
        if (_01inverse_partword.length < n) {
            _01inverse_partword = new int[n][][];
        }
        for (n3 = 0; n3 < n; ++n3) {
            if (_01inverse_partword[n3] != null && _01inverse_partword[n3].length >= n6) continue;
            Residue0._01inverse_partword[n3] = new int[n6][];
        }
        for (int i = 0; i < residue0$LookResidue0.stages; ++i) {
            n6 = 0;
            int n8 = 0;
            while (n6 < n7) {
                int n9;
                if (i == 0) {
                    for (n3 = 0; n3 < n; ++n3) {
                        n9 = residue0$LookResidue0.phrasebook.decode(block.opb);
                        if (n9 == -1) {
                            return 0;
                        }
                        Residue0._01inverse_partword[n3][n8] = residue0$LookResidue0.decodemap[n9];
                        if (_01inverse_partword[n3][n8] != null) continue;
                        return 0;
                    }
                }
                for (int j = 0; j < n5 && n6 < n7; ++j, ++n6) {
                    for (n3 = 0; n3 < n; ++n3) {
                        CodeBook codeBook;
                        n9 = residue0$InfoResidue0.begin + n6 * n4;
                        int n10 = _01inverse_partword[n3][n8][j];
                        if ((residue0$InfoResidue0.secondstages[n10] & 1 << i) == 0 || (codeBook = residue0$LookResidue0.fullbooks[residue0$LookResidue0.partbooks[n10][i]]) == null || !(n2 == 0 ? codeBook.decodevs_add(fArray[n3], n9, block.opb, n4) == -1 : n2 == 1 && codeBook.decodev_add(fArray[n3], n9, block.opb, n4) == -1)) continue;
                        return 0;
                    }
                }
                ++n8;
            }
        }
        return 0;
    }

    static synchronized int _2inverse(Block block, Object object, float[][] fArray, int n) {
        Residue0$LookResidue0 residue0$LookResidue0 = (Residue0$LookResidue0)object;
        Residue0$InfoResidue0 residue0$InfoResidue0 = residue0$LookResidue0.info;
        int n2 = residue0$InfoResidue0.grouping;
        int n3 = residue0$LookResidue0.phrasebook.dim;
        int n4 = residue0$InfoResidue0.end - residue0$InfoResidue0.begin;
        int n5 = n4 / n2;
        n4 = (n5 + n3 - 1) / n3;
        if (_2inverse_partword == null || _2inverse_partword.length < n4) {
            _2inverse_partword = new int[n4][];
        }
        for (int i = 0; i < residue0$LookResidue0.stages; ++i) {
            n4 = 0;
            int n6 = 0;
            while (n4 < n5) {
                int n7;
                if (i == 0) {
                    n7 = residue0$LookResidue0.phrasebook.decode(block.opb);
                    if (n7 == -1) {
                        return 0;
                    }
                    Residue0._2inverse_partword[n6] = residue0$LookResidue0.decodemap[n7];
                    if (_2inverse_partword[n6] == null) {
                        return 0;
                    }
                }
                for (int j = 0; j < n3 && n4 < n5; ++j, ++n4) {
                    CodeBook codeBook;
                    n7 = residue0$InfoResidue0.begin + n4 * n2;
                    int n8 = _2inverse_partword[n6][j];
                    if ((residue0$InfoResidue0.secondstages[n8] & 1 << i) == 0 || (codeBook = residue0$LookResidue0.fullbooks[residue0$LookResidue0.partbooks[n8][i]]) == null || codeBook.decodevv_add(fArray, n7, n, block.opb, n2) != -1) continue;
                    return 0;
                }
                ++n6;
            }
        }
        return 0;
    }

    int inverse(Block block, Object object, float[][] fArray, int[] nArray, int n) {
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            if (nArray[i] == 0) continue;
            fArray[n2++] = fArray[i];
        }
        if (n2 != 0) {
            return Residue0._01inverse(block, object, fArray, n2, 0);
        }
        return 0;
    }
}

