/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.b.a.C_d;
import net.minecraft.a.d.C_b;

public class C_j
extends C_a {
    private int storedBlockID;
    private int storedMetadata;
    private int storedOrientation;
    private boolean extending;
    private boolean shouldHeadBeRendered;
    private float progress;
    private float lastProgress;
    private static List<net.minecraft.a.c.C_b> pushedObjects = new ArrayList<net.minecraft.a.c.C_b>();

    public C_j() {
    }

    public C_j(int n, int n2, int n3, boolean bl, boolean bl2) {
        this.storedBlockID = n;
        this.storedMetadata = n2;
        this.storedOrientation = n3;
        this.extending = bl;
        this.shouldHeadBeRendered = bl2;
    }

    public int getStoredBlockID() {
        return this.storedBlockID;
    }

    @Override
    public int getBlockMetadata() {
        return this.storedMetadata;
    }

    public boolean isExtending() {
        return this.extending;
    }

    public int getPistonOrientation() {
        return this.storedOrientation;
    }

    public boolean shouldRenderHead() {
        return this.shouldHeadBeRendered;
    }

    public float getProgress(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        }
        return this.lastProgress + (this.progress - this.lastProgress) * f;
    }

    public float getOffsetX(float f) {
        return this.extending ? (this.getProgress(f) - 1.0f) * (float)C_d.offsetsXForSide[this.storedOrientation] : (1.0f - this.getProgress(f)) * (float)C_d.offsetsXForSide[this.storedOrientation];
    }

    public float getOffsetY(float f) {
        return this.extending ? (this.getProgress(f) - 1.0f) * (float)C_d.offsetsYForSide[this.storedOrientation] : (1.0f - this.getProgress(f)) * (float)C_d.offsetsYForSide[this.storedOrientation];
    }

    public float getOffsetZ(float f) {
        return this.extending ? (this.getProgress(f) - 1.0f) * (float)C_d.offsetsZForSide[this.storedOrientation] : (1.0f - this.getProgress(f)) * (float)C_d.offsetsZForSide[this.storedOrientation];
    }

    private void updatePushedObjects(float f, float f2) {
        List<net.minecraft.a.c.C_b> list;
        f = !this.extending ? (f -= 1.0f) : 1.0f - f;
        C_b c_b = C_x.pulleyMoving.getAxisAlignedBB(this.a, this.b, this.c, this.d, this.storedBlockID, f, this.storedOrientation);
        if (c_b != null && !(list = this.a.a((net.minecraft.a.c.C_b)null, c_b)).isEmpty()) {
            pushedObjects.addAll(list);
            for (net.minecraft.a.c.C_b c_b2 : pushedObjects) {
                c_b2.d(f2 * (float)C_d.offsetsXForSide[this.storedOrientation], f2 * (float)C_d.offsetsYForSide[this.storedOrientation], f2 * (float)C_d.offsetsZForSide[this.storedOrientation]);
            }
            pushedObjects.clear();
        }
    }

    public void clearPistonTileEntity() {
        if (this.lastProgress < 1.0f && this.a != null) {
            this.progress = 1.0f;
            this.lastProgress = 1.0f;
            this.a.i(this.b, this.c, this.d);
            this.markForRemoval();
            if (this.a.a(this.b, this.c, this.d) == C_x.pulleyMoving.at) {
                this.a.setBlockAndMetadataWithNotify(this.b, this.c, this.d, this.storedBlockID, this.storedMetadata);
            }
        }
    }

    @Override
    public void d() {
        this.lastProgress = this.progress;
        if (this.lastProgress >= 1.0f) {
            C_x c_x;
            this.updatePushedObjects(1.0f, 0.25f);
            this.a.i(this.b, this.c, this.d);
            this.markForRemoval();
            int n = this.a.a(this.b, this.c, this.d);
            if (n == C_x.pulleyMoving.at) {
                this.a.setBlockAndMetadataWithNotify(this.b, this.c, this.d, this.storedBlockID, this.storedMetadata);
            }
            if (n > 0 && (c_x = C_x.c[this.a.a(this.b, this.c, this.d)]) != null) {
                c_x.b(this.a, this.b, this.c, this.d, n);
            }
        } else {
            this.progress += 0.5f;
            if (this.progress >= 1.0f) {
                this.progress = 1.0f;
            }
            if (this.extending) {
                this.updatePushedObjects(this.progress, this.progress - this.lastProgress + 0.0625f);
            }
        }
    }

    @Override
    public void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
        this.storedBlockID = nBTTagCompound.d("blockId");
        this.storedMetadata = nBTTagCompound.d("blockData");
        this.storedOrientation = nBTTagCompound.d("facing");
        this.lastProgress = this.progress = nBTTagCompound.f("progress");
        this.extending = nBTTagCompound.k("extending");
    }

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        nBTTagCompound.a("blockId", this.storedBlockID);
        nBTTagCompound.a("blockData", this.storedMetadata);
        nBTTagCompound.a("facing", this.storedOrientation);
        nBTTagCompound.a("progress", this.lastProgress);
        nBTTagCompound.a("extending", this.extending);
    }
}

