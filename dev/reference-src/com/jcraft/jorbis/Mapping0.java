/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;
import com.jcraft.jorbis.Block;
import com.jcraft.jorbis.DspState;
import com.jcraft.jorbis.FuncFloor;
import com.jcraft.jorbis.FuncMapping;
import com.jcraft.jorbis.FuncResidue;
import com.jcraft.jorbis.FuncTime;
import com.jcraft.jorbis.Info;
import com.jcraft.jorbis.InfoMode;
import com.jcraft.jorbis.Mapping0$InfoMapping0;
import com.jcraft.jorbis.Mapping0$LookMapping0;
import com.jcraft.jorbis.Mdct;
import com.jcraft.jorbis.Util;

class Mapping0
extends FuncMapping {
    static int seq = 0;
    float[][] pcmbundle = null;
    int[] zerobundle = null;
    int[] nonzero = null;
    Object[] floormemo = null;

    Mapping0() {
    }

    void free_info(Object object) {
    }

    void free_look(Object object) {
    }

    Object look(DspState dspState, InfoMode infoMode, Object object) {
        Info info = dspState.vi;
        Mapping0$LookMapping0 mapping0$LookMapping0 = new Mapping0$LookMapping0(this);
        new Mapping0$LookMapping0(this).map = (Mapping0$InfoMapping0)object;
        object = new Mapping0$LookMapping0(this).map;
        mapping0$LookMapping0.mode = infoMode;
        mapping0$LookMapping0.time_look = new Object[((Mapping0$InfoMapping0)object).submaps];
        mapping0$LookMapping0.floor_look = new Object[((Mapping0$InfoMapping0)object).submaps];
        mapping0$LookMapping0.residue_look = new Object[((Mapping0$InfoMapping0)object).submaps];
        mapping0$LookMapping0.time_func = new FuncTime[((Mapping0$InfoMapping0)object).submaps];
        mapping0$LookMapping0.floor_func = new FuncFloor[((Mapping0$InfoMapping0)object).submaps];
        mapping0$LookMapping0.residue_func = new FuncResidue[((Mapping0$InfoMapping0)object).submaps];
        for (int i = 0; i < ((Mapping0$InfoMapping0)object).submaps; ++i) {
            int n = ((Mapping0$InfoMapping0)object).timesubmap[i];
            int n2 = ((Mapping0$InfoMapping0)object).floorsubmap[i];
            int n3 = ((Mapping0$InfoMapping0)object).residuesubmap[i];
            mapping0$LookMapping0.time_func[i] = FuncTime.time_P[info.time_type[n]];
            mapping0$LookMapping0.time_look[i] = mapping0$LookMapping0.time_func[i].look(dspState, infoMode, info.time_param[n]);
            mapping0$LookMapping0.floor_func[i] = FuncFloor.floor_P[info.floor_type[n2]];
            mapping0$LookMapping0.floor_look[i] = mapping0$LookMapping0.floor_func[i].look(dspState, infoMode, info.floor_param[n2]);
            mapping0$LookMapping0.residue_func[i] = FuncResidue.residue_P[info.residue_type[n3]];
            mapping0$LookMapping0.residue_look[i] = mapping0$LookMapping0.residue_func[i].look(dspState, infoMode, info.residue_param[n3]);
        }
        mapping0$LookMapping0.ch = info.channels;
        return mapping0$LookMapping0;
    }

    void pack(Info info, Object object, Buffer buffer) {
        int n;
        object = (Mapping0$InfoMapping0)object;
        if (((Mapping0$InfoMapping0)object).submaps > 1) {
            buffer.write(1, 1);
            buffer.write(((Mapping0$InfoMapping0)object).submaps - 1, 4);
        } else {
            buffer.write(0, 1);
        }
        if (((Mapping0$InfoMapping0)object).coupling_steps > 0) {
            buffer.write(1, 1);
            buffer.write(((Mapping0$InfoMapping0)object).coupling_steps - 1, 8);
            for (n = 0; n < ((Mapping0$InfoMapping0)object).coupling_steps; ++n) {
                buffer.write(((Mapping0$InfoMapping0)object).coupling_mag[n], Util.ilog2(info.channels));
                buffer.write(((Mapping0$InfoMapping0)object).coupling_ang[n], Util.ilog2(info.channels));
            }
        } else {
            buffer.write(0, 1);
        }
        buffer.write(0, 2);
        if (((Mapping0$InfoMapping0)object).submaps > 1) {
            for (n = 0; n < info.channels; ++n) {
                buffer.write(((Mapping0$InfoMapping0)object).chmuxlist[n], 4);
            }
        }
        for (n = 0; n < ((Mapping0$InfoMapping0)object).submaps; ++n) {
            buffer.write(((Mapping0$InfoMapping0)object).timesubmap[n], 8);
            buffer.write(((Mapping0$InfoMapping0)object).floorsubmap[n], 8);
            buffer.write(((Mapping0$InfoMapping0)object).residuesubmap[n], 8);
        }
    }

    Object unpack(Info info, Buffer buffer) {
        int n;
        Mapping0$InfoMapping0 mapping0$InfoMapping0 = new Mapping0$InfoMapping0(this);
        mapping0$InfoMapping0.submaps = buffer.read(1) != 0 ? buffer.read(4) + 1 : 1;
        if (buffer.read(1) != 0) {
            mapping0$InfoMapping0.coupling_steps = buffer.read(8) + 1;
            for (n = 0; n < mapping0$InfoMapping0.coupling_steps; ++n) {
                int n2 = mapping0$InfoMapping0.coupling_mag[n] = buffer.read(Util.ilog2(info.channels));
                int n3 = mapping0$InfoMapping0.coupling_ang[n] = buffer.read(Util.ilog2(info.channels));
                if (n2 >= 0 && n3 >= 0 && n2 != n3 && n2 < info.channels && n3 < info.channels) continue;
                mapping0$InfoMapping0.free();
                return null;
            }
        }
        if (buffer.read(2) > 0) {
            mapping0$InfoMapping0.free();
            return null;
        }
        if (mapping0$InfoMapping0.submaps > 1) {
            for (n = 0; n < info.channels; ++n) {
                mapping0$InfoMapping0.chmuxlist[n] = buffer.read(4);
                if (mapping0$InfoMapping0.chmuxlist[n] < mapping0$InfoMapping0.submaps) continue;
                mapping0$InfoMapping0.free();
                return null;
            }
        }
        for (n = 0; n < mapping0$InfoMapping0.submaps; ++n) {
            mapping0$InfoMapping0.timesubmap[n] = buffer.read(8);
            if (mapping0$InfoMapping0.timesubmap[n] >= info.times) {
                mapping0$InfoMapping0.free();
                return null;
            }
            mapping0$InfoMapping0.floorsubmap[n] = buffer.read(8);
            if (mapping0$InfoMapping0.floorsubmap[n] >= info.floors) {
                mapping0$InfoMapping0.free();
                return null;
            }
            mapping0$InfoMapping0.residuesubmap[n] = buffer.read(8);
            if (mapping0$InfoMapping0.residuesubmap[n] < info.residues) continue;
            mapping0$InfoMapping0.free();
            return null;
        }
        return mapping0$InfoMapping0;
    }

    synchronized int inverse(Block block, Object object) {
        int n;
        int n2;
        int n3;
        DspState dspState = block.vd;
        Info info = dspState.vi;
        object = (Mapping0$LookMapping0)object;
        Mapping0$InfoMapping0 mapping0$InfoMapping0 = ((Mapping0$LookMapping0)object).map;
        Object object2 = ((Mapping0$LookMapping0)object).mode;
        int n4 = block.pcmend = info.blocksizes[block.W];
        object2 = dspState.window[block.W][block.lW][block.nW][((InfoMode)object2).windowtype];
        if (this.pcmbundle == null || this.pcmbundle.length < info.channels) {
            this.pcmbundle = new float[info.channels][];
            this.nonzero = new int[info.channels];
            this.zerobundle = new int[info.channels];
            this.floormemo = new Object[info.channels];
        }
        for (n3 = 0; n3 < info.channels; ++n3) {
            float[] fArray = block.pcm[n3];
            n2 = mapping0$InfoMapping0.chmuxlist[n3];
            this.floormemo[n3] = ((Mapping0$LookMapping0)object).floor_func[n2].inverse1(block, ((Mapping0$LookMapping0)object).floor_look[n2], this.floormemo[n3]);
            this.nonzero[n3] = this.floormemo[n3] != null ? 1 : 0;
            for (n = 0; n < n4 / 2; ++n) {
                fArray[n] = 0.0f;
            }
        }
        for (n3 = 0; n3 < mapping0$InfoMapping0.coupling_steps; ++n3) {
            if (this.nonzero[mapping0$InfoMapping0.coupling_mag[n3]] == 0 && this.nonzero[mapping0$InfoMapping0.coupling_ang[n3]] == 0) continue;
            this.nonzero[mapping0$InfoMapping0.coupling_mag[n3]] = 1;
            this.nonzero[mapping0$InfoMapping0.coupling_ang[n3]] = 1;
        }
        for (n3 = 0; n3 < mapping0$InfoMapping0.submaps; ++n3) {
            int n5 = 0;
            for (n2 = 0; n2 < info.channels; ++n2) {
                if (mapping0$InfoMapping0.chmuxlist[n2] != n3) continue;
                this.zerobundle[n5] = this.nonzero[n2] != 0 ? 1 : 0;
                this.pcmbundle[n5++] = block.pcm[n2];
            }
            ((Mapping0$LookMapping0)object).residue_func[n3].inverse(block, ((Mapping0$LookMapping0)object).residue_look[n3], this.pcmbundle, this.zerobundle, n5);
        }
        for (n3 = mapping0$InfoMapping0.coupling_steps - 1; n3 >= 0; --n3) {
            float[] fArray = block.pcm[mapping0$InfoMapping0.coupling_mag[n3]];
            float[] fArray2 = block.pcm[mapping0$InfoMapping0.coupling_ang[n3]];
            for (n = 0; n < n4 / 2; ++n) {
                float f = fArray[n];
                float f2 = fArray2[n];
                if (f > 0.0f) {
                    if (f2 > 0.0f) {
                        fArray[n] = f;
                        fArray2[n] = f - f2;
                        continue;
                    }
                    fArray2[n] = f;
                    fArray[n] = f + f2;
                    continue;
                }
                if (f2 > 0.0f) {
                    fArray[n] = f;
                    fArray2[n] = f + f2;
                    continue;
                }
                fArray2[n] = f;
                fArray[n] = f - f2;
            }
        }
        for (n3 = 0; n3 < info.channels; ++n3) {
            float[] fArray = block.pcm[n3];
            int n6 = mapping0$InfoMapping0.chmuxlist[n3];
            ((Mapping0$LookMapping0)object).floor_func[n6].inverse2(block, ((Mapping0$LookMapping0)object).floor_look[n6], this.floormemo[n3], fArray);
        }
        for (n3 = 0; n3 < info.channels; ++n3) {
            float[] fArray = block.pcm[n3];
            ((Mdct)dspState.transform[block.W][0]).backward(fArray, fArray);
        }
        for (n3 = 0; n3 < info.channels; ++n3) {
            int n7;
            float[] fArray = block.pcm[n3];
            if (this.nonzero[n3] != 0) {
                for (n7 = 0; n7 < n4; ++n7) {
                    int n8 = n7;
                    fArray[n8] = fArray[n8] * object2[n7];
                }
                continue;
            }
            for (n7 = 0; n7 < n4; ++n7) {
                fArray[n7] = 0.0f;
            }
        }
        return 0;
    }
}

