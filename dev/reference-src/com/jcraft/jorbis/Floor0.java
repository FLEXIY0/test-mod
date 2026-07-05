/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;
import com.jcraft.jorbis.Block;
import com.jcraft.jorbis.CodeBook;
import com.jcraft.jorbis.DspState;
import com.jcraft.jorbis.Floor0$EchstateFloor0;
import com.jcraft.jorbis.Floor0$InfoFloor0;
import com.jcraft.jorbis.Floor0$LookFloor0;
import com.jcraft.jorbis.FuncFloor;
import com.jcraft.jorbis.Info;
import com.jcraft.jorbis.InfoMode;
import com.jcraft.jorbis.Lsp;
import com.jcraft.jorbis.Util;
import util.MathHelper;

class Floor0
extends FuncFloor {
    float[] lsp = null;

    Floor0() {
    }

    void pack(Object object, Buffer buffer) {
        object = (Floor0$InfoFloor0)object;
        buffer.write(((Floor0$InfoFloor0)object).order, 8);
        buffer.write(((Floor0$InfoFloor0)object).rate, 16);
        buffer.write(((Floor0$InfoFloor0)object).barkmap, 16);
        buffer.write(((Floor0$InfoFloor0)object).ampbits, 6);
        buffer.write(((Floor0$InfoFloor0)object).ampdB, 8);
        buffer.write(((Floor0$InfoFloor0)object).numbooks - 1, 4);
        for (int i = 0; i < ((Floor0$InfoFloor0)object).numbooks; ++i) {
            buffer.write(((Floor0$InfoFloor0)object).books[i], 8);
        }
    }

    Object unpack(Info info, Buffer buffer) {
        Floor0$InfoFloor0 floor0$InfoFloor0 = new Floor0$InfoFloor0(this);
        new Floor0$InfoFloor0(this).order = buffer.read(8);
        floor0$InfoFloor0.rate = buffer.read(16);
        floor0$InfoFloor0.barkmap = buffer.read(16);
        floor0$InfoFloor0.ampbits = buffer.read(6);
        floor0$InfoFloor0.ampdB = buffer.read(8);
        floor0$InfoFloor0.numbooks = buffer.read(4) + 1;
        if (floor0$InfoFloor0.order <= 0 || floor0$InfoFloor0.rate <= 0 || floor0$InfoFloor0.barkmap <= 0 || floor0$InfoFloor0.numbooks <= 0) {
            return null;
        }
        for (int i = 0; i < floor0$InfoFloor0.numbooks; ++i) {
            floor0$InfoFloor0.books[i] = buffer.read(8);
            if (floor0$InfoFloor0.books[i] >= 0 && floor0$InfoFloor0.books[i] < info.books) continue;
            return null;
        }
        return floor0$InfoFloor0;
    }

    Object look(DspState object, InfoMode infoMode, Object object2) {
        object = ((DspState)object).vi;
        object2 = (Floor0$InfoFloor0)object2;
        Floor0$LookFloor0 floor0$LookFloor0 = new Floor0$LookFloor0(this);
        new Floor0$LookFloor0(this).m = ((Floor0$InfoFloor0)object2).order;
        floor0$LookFloor0.n = ((Info)object).blocksizes[infoMode.blockflag] / 2;
        floor0$LookFloor0.ln = ((Floor0$InfoFloor0)object2).barkmap;
        floor0$LookFloor0.vi = object2;
        floor0$LookFloor0.lpclook.init(floor0$LookFloor0.ln, floor0$LookFloor0.m);
        float f = (float)floor0$LookFloor0.ln / Floor0.toBARK((float)((double)((Floor0$InfoFloor0)object2).rate / 2.0));
        floor0$LookFloor0.linearmap = new int[floor0$LookFloor0.n];
        for (int i = 0; i < floor0$LookFloor0.n; ++i) {
            int n = MathHelper.d(Floor0.toBARK((float)((double)((Floor0$InfoFloor0)object2).rate / 2.0 / (double)floor0$LookFloor0.n * (double)i)) * f);
            if (n >= floor0$LookFloor0.ln) {
                n = floor0$LookFloor0.ln;
            }
            floor0$LookFloor0.linearmap[i] = n;
        }
        return floor0$LookFloor0;
    }

    static float toBARK(float f) {
        return (float)(13.1 * Math.atan(7.4E-4 * (double)f) + 2.24 * Math.atan((double)(f * f) * 1.85E-8) + 1.0E-4 * (double)f);
    }

    Object state(Object object) {
        Floor0$EchstateFloor0 floor0$EchstateFloor0 = new Floor0$EchstateFloor0(this);
        object = (Floor0$InfoFloor0)object;
        floor0$EchstateFloor0.codewords = new int[((Floor0$InfoFloor0)object).order];
        floor0$EchstateFloor0.curve = new float[((Floor0$InfoFloor0)object).barkmap];
        floor0$EchstateFloor0.frameno = -1L;
        return floor0$EchstateFloor0;
    }

    void free_info(Object object) {
    }

    void free_look(Object object) {
    }

    void free_state(Object object) {
    }

    int forward(Block block, Object object, float[] fArray, float[] fArray2, Object object2) {
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    int inverse(Block block, Object object, float[] fArray) {
        object = (Floor0$LookFloor0)object;
        Floor0$InfoFloor0 floor0$InfoFloor0 = ((Floor0$LookFloor0)object).vi;
        int n = block.opb.read(floor0$InfoFloor0.ampbits);
        if (n > 0) {
            int n2 = (1 << floor0$InfoFloor0.ampbits) - 1;
            float f = (float)n / (float)n2 * (float)floor0$InfoFloor0.ampdB;
            n2 = block.opb.read(Util.ilog(floor0$InfoFloor0.numbooks));
            if (n2 != -1 && n2 < floor0$InfoFloor0.numbooks) {
                Floor0 floor0 = this;
                synchronized (floor0) {
                    int n3;
                    if (this.lsp == null || this.lsp.length < ((Floor0$LookFloor0)object).m) {
                        this.lsp = new float[((Floor0$LookFloor0)object).m];
                    } else {
                        for (int i = 0; i < ((Floor0$LookFloor0)object).m; ++i) {
                            this.lsp[i] = 0.0f;
                        }
                    }
                    CodeBook codeBook = block.vd.fullbooks[floor0$InfoFloor0.books[n2]];
                    float f2 = 0.0f;
                    for (n3 = 0; n3 < ((Floor0$LookFloor0)object).m; ++n3) {
                        fArray[n3] = 0.0f;
                    }
                    for (n3 = 0; n3 < ((Floor0$LookFloor0)object).m; n3 += codeBook.dim) {
                        if (codeBook.decodevs(this.lsp, n3, block.opb, 1, -1) != -1) continue;
                        for (int i = 0; i < ((Floor0$LookFloor0)object).n; ++i) {
                            fArray[i] = 0.0f;
                        }
                        return 0;
                    }
                    n3 = 0;
                    while (n3 < ((Floor0$LookFloor0)object).m) {
                        for (int i = 0; i < codeBook.dim; ++i) {
                            int n4 = n3++;
                            this.lsp[n4] = this.lsp[n4] + f2;
                        }
                        f2 = this.lsp[n3 - 1];
                    }
                    Lsp.lsp_to_curve(fArray, ((Floor0$LookFloor0)object).linearmap, ((Floor0$LookFloor0)object).n, ((Floor0$LookFloor0)object).ln, this.lsp, ((Floor0$LookFloor0)object).m, f, floor0$InfoFloor0.ampdB);
                    return 1;
                }
            }
        }
        return 0;
    }

    Object inverse1(Block block, Object object, Object object2) {
        int n;
        object = (Floor0$LookFloor0)object;
        Object object3 = ((Floor0$LookFloor0)object).vi;
        float[] fArray = null;
        if (object2 instanceof float[]) {
            fArray = (float[])object2;
        }
        if ((n = block.opb.read(((Floor0$InfoFloor0)object3).ampbits)) > 0) {
            int n2 = (1 << ((Floor0$InfoFloor0)object3).ampbits) - 1;
            float f = (float)n / (float)n2 * (float)((Floor0$InfoFloor0)object3).ampdB;
            n2 = block.opb.read(Util.ilog(((Floor0$InfoFloor0)object3).numbooks));
            if (n2 != -1 && n2 < ((Floor0$InfoFloor0)object3).numbooks) {
                int n3;
                object3 = block.vd.fullbooks[((Floor0$InfoFloor0)object3).books[n2]];
                float f2 = 0.0f;
                if (fArray == null || fArray.length < ((Floor0$LookFloor0)object).m + 1) {
                    fArray = new float[((Floor0$LookFloor0)object).m + 1];
                } else {
                    for (n3 = 0; n3 < fArray.length; ++n3) {
                        fArray[n3] = 0.0f;
                    }
                }
                for (n3 = 0; n3 < ((Floor0$LookFloor0)object).m; n3 += ((CodeBook)object3).dim) {
                    if (((CodeBook)object3).decodev_set(fArray, n3, block.opb, ((CodeBook)object3).dim) != -1) continue;
                    return null;
                }
                n3 = 0;
                while (n3 < ((Floor0$LookFloor0)object).m) {
                    for (int i = 0; i < ((CodeBook)object3).dim; ++i) {
                        int n4 = n3++;
                        fArray[n4] = fArray[n4] + f2;
                    }
                    f2 = fArray[n3 - 1];
                }
                fArray[((Floor0$LookFloor0)object).m] = f;
                return fArray;
            }
        }
        return null;
    }

    int inverse2(Block object, Object object2, Object object3, float[] fArray) {
        object = (Floor0$LookFloor0)object2;
        object2 = ((Floor0$LookFloor0)object).vi;
        if (object3 != null) {
            float[] fArray2 = (float[])object3;
            object3 = fArray2;
            float f = fArray2[((Floor0$LookFloor0)object).m];
            Lsp.lsp_to_curve(fArray, ((Floor0$LookFloor0)object).linearmap, ((Floor0$LookFloor0)object).n, ((Floor0$LookFloor0)object).ln, (float[])object3, ((Floor0$LookFloor0)object).m, f, ((Floor0$InfoFloor0)object2).ampdB);
            return 1;
        }
        for (int i = 0; i < ((Floor0$LookFloor0)object).n; ++i) {
            fArray[i] = 0.0f;
        }
        return 0;
    }

    static float fromdB(float f) {
        return (float)Math.exp((double)f * 0.11512925);
    }

    static void lsp_to_lpc(float[] fArray, float[] fArray2, int n) {
        int n2;
        int n3;
        int n4 = n / 2;
        float[] fArray3 = new float[n4];
        float[] fArray4 = new float[n4];
        float[] fArray5 = new float[n4 + 1];
        float[] fArray6 = new float[n4 + 1];
        float[] fArray7 = new float[n4];
        float[] fArray8 = new float[n4];
        for (n3 = 0; n3 < n4; ++n3) {
            fArray3[n3] = (float)(-2.0 * Math.cos(fArray[n3 << 1]));
            fArray4[n3] = (float)(-2.0 * Math.cos(fArray[(n3 << 1) + 1]));
        }
        for (n2 = 0; n2 < n4; ++n2) {
            fArray5[n2] = 0.0f;
            fArray6[n2] = 1.0f;
            fArray7[n2] = 0.0f;
            fArray8[n2] = 1.0f;
        }
        fArray6[n2] = 1.0f;
        fArray5[n2] = 1.0f;
        for (n3 = 1; n3 < n + 1; ++n3) {
            float f = 0.0f;
            float f2 = 0.0f;
            for (n2 = 0; n2 < n4; ++n2) {
                float f3 = fArray3[n2] * fArray6[n2] + fArray5[n2];
                fArray5[n2] = fArray6[n2];
                fArray6[n2] = f2;
                f2 += f3;
                f3 = fArray4[n2] * fArray8[n2] + fArray7[n2];
                fArray7[n2] = fArray8[n2];
                fArray8[n2] = f;
                f += f3;
            }
            fArray2[n3 - 1] = (f2 + fArray6[n2] + f - fArray5[n2]) / 2.0f;
            fArray6[n2] = f2;
            fArray5[n2] = f;
        }
    }

    static void lpc_to_curve(float[] fArray, float[] fArray2, float f, Floor0$LookFloor0 floor0$LookFloor0, String object, int n) {
        object = new float[Math.max(floor0$LookFloor0.ln << 1, (floor0$LookFloor0.m << 1) + 2)];
        if (f == 0.0f) {
            for (int i = 0; i < floor0$LookFloor0.n; ++i) {
                fArray[i] = 0.0f;
            }
            return;
        }
        floor0$LookFloor0.lpclook.lpc_to_curve((float[])object, fArray2, f);
        for (int i = 0; i < floor0$LookFloor0.n; ++i) {
            fArray[i] = (float)object[floor0$LookFloor0.linearmap[i]];
        }
    }
}

