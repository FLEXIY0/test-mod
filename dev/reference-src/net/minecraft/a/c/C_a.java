/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c;

import com.a.a.NBTTagCompound;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.a.World;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_d;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.c.C_f;
import net.minecraft.a.c.e.EntityPlayer;

public class C_a
extends net.minecraft.a.c.C_b {
    protected int O = 0;
    public int a = 0;
    public int P;
    public int Q;
    public int R;
    public C_d b;

    public C_a(World c_g) {
        super(c_g);
        this.v = 0.0f;
        this.a(0.5f, 0.5f);
    }

    public C_a(World c_g, int n, int n2, int n3, int n4, int n5) {
        this(c_g);
        this.P = n;
        this.Q = n2;
        this.R = n3;
        ArrayList<C_d> arrayList = new ArrayList<C_d>();
        C_d[] c_dArray = C_d.values();
        int n6 = c_dArray.length;
        for (int i = 0; i < n6; ++i) {
            C_d c_d;
            this.b = c_d = c_dArray[i];
            this.b(n4);
            if (!this.c() && !c_g.multiplayerWorld) continue;
            arrayList.add(c_d);
        }
        if (arrayList.size() > 0) {
            try {
                this.b = n5 > 0 ? (C_d)((Object)arrayList.get(n5 - 1)) : (C_d)((Object)arrayList.get(this.G.nextInt(arrayList.size())));
            }
            catch (Exception exception) {
                ((net.minecraft.client.g.C_a)c_g.y).chatMessage("\u00a7cNot enough room!");
            }
        }
        this.b(n4);
    }

    public C_a(World c_g, int n, int n2, int n3, int n4, String string, int n5) {
        this(c_g, n, n2, n3, n4, n5);
    }

    @Override
    protected void entityInit() {
    }

    @Override
    public void onStruckByLightning(C_f c_f) {
    }

    protected void b(int n) {
        this.a = n;
        this.p = this.n = (float)(n * 90);
        float f = this.b.c;
        float f2 = this.b.d;
        float f3 = this.b.c;
        if (n != 0 && n != 2) {
            f = 0.5f;
        } else {
            f3 = 0.5f;
        }
        f /= 32.0f;
        f2 /= 32.0f;
        f3 /= 32.0f;
        float f4 = (float)this.P + 0.5f;
        float f5 = (float)this.Q + 0.5f;
        float f6 = (float)this.R + 0.5f;
        if (n == 0) {
            f6 -= 0.5625f;
        }
        if (n == 1) {
            f4 -= 0.5625f;
        }
        if (n == 2) {
            f6 += 0.5625f;
        }
        if (n == 3) {
            f4 += 0.5625f;
        }
        if (n == 0) {
            f4 -= C_a.c(this.b.c);
        }
        if (n == 1) {
            f6 += C_a.c(this.b.c);
        }
        if (n == 2) {
            f4 += C_a.c(this.b.c);
        }
        if (n == 3) {
            f6 -= C_a.c(this.b.c);
        }
        this.b(f4, f5 += C_a.c(this.b.d), f6);
        float f7 = -0.00625f;
        this.r = new net.minecraft.a.d.C_b(f4 - f - f7, f5 - f2 - f7, f6 - f3 - f7, f4 + f + f7, f5 + f2 + f7, f6 + f3 + f7);
    }

    protected static float c(int n) {
        return n == 32 ? 0.5f : (n == 64 ? 0.5f : 0.0f);
    }

    @Override
    public void b_() {
        if (!this.c()) {
            if (this.O++ >= 1 && !this.d.multiplayerWorld) {
                this.k();
                this.d.spawnEntityInWorld(new C_b(this.d, this.h, this.i, this.j, new ItemStack(Item.ao)));
            }
        } else {
            this.O = 0;
        }
    }

    public boolean c() {
        int n;
        if (this.d.getCollidingBoundingBoxes(this, this.r).size() > 0) {
            return false;
        }
        int n2 = this.b.c / 16;
        int n3 = this.b.d / 16;
        int n4 = this.P;
        int n5 = this.R;
        if (this.a == 0) {
            n4 = (int)(this.h - (float)this.b.c / 32.0f);
        }
        if (this.a == 1) {
            n5 = (int)(this.j - (float)this.b.c / 32.0f);
        }
        if (this.a == 2) {
            n4 = (int)(this.h - (float)this.b.c / 32.0f);
        }
        if (this.a == 3) {
            n5 = (int)(this.j - (float)this.b.c / 32.0f);
        }
        int n6 = (int)(this.i - (float)this.b.d / 32.0f);
        for (int i = 0; i < n2; ++i) {
            for (n = 0; n < n3; ++n) {
                C_c c_c = this.a != 0 && this.a != 2 ? this.d.f(this.P, n6 + n, n5 + i) : this.d.f(n4 + i, n6 + n, this.R);
                if (c_c.a()) continue;
                return false;
            }
        }
        List<net.minecraft.a.c.C_b> list = this.d.r.a(this, this.r);
        for (n = 0; n < list.size(); ++n) {
            if (!(list.get(n) instanceof C_a)) continue;
            return false;
        }
        return true;
    }

    @Override
    public final boolean d() {
        return false;
    }

    @Override
    public boolean attackEntityFrom(net.minecraft.a.c.C_b c_b, int n, float f) {
        if (c_b instanceof net.minecraft.a.c.d.C_a || c_b instanceof net.minecraft.a.c.d.C_b) {
            return false;
        }
        if (!this.u && !this.d.multiplayerWorld) {
            boolean bl;
            this.k();
            boolean bl2 = bl = !(c_b instanceof EntityPlayer) || c_b instanceof EntityPlayer && ((EntityPlayer)c_b).gamemode != 1;
            if (bl) {
                this.d.spawnEntityInWorld(new C_b(this.d, this.h, this.i, this.j, new ItemStack(Item.ao)));
            }
        }
        return true;
    }

    @Override
    protected void a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("Dir", (byte)this.a);
        nBTTagCompound.a("Motive", this.b.b);
        nBTTagCompound.a("TileX", this.P);
        nBTTagCompound.a("TileY", this.Q);
        nBTTagCompound.a("TileZ", this.R);
    }

    @Override
    public String a() {
        return "Painting";
    }

    @Override
    protected void b(NBTTagCompound nBTTagCompound) {
        this.a = nBTTagCompound.b("Dir");
        this.P = nBTTagCompound.d("TileX");
        this.Q = nBTTagCompound.d("TileY");
        this.R = nBTTagCompound.d("TileZ");
        String string = nBTTagCompound.g("Motive");
        for (C_d c_d : C_d.values()) {
            if (!c_d.b.equals(string)) continue;
            this.b = c_d;
        }
        if (this.b == null) {
            this.b = C_d.a;
        }
        this.b(this.a);
    }

    @Override
    public void d(float f, float f2, float f3) {
        if (!this.d.multiplayerWorld && (double)(f * f + f2 * f2 + f3 * f3) > 0.0) {
            this.k();
            this.d.spawnEntityInWorld(new C_b(this.d, this.h, this.i, this.j, new ItemStack(Item.ao)));
        }
    }

    @Override
    public void a(float f, float f2, float f3) {
        if (!this.d.multiplayerWorld && (double)(f * f + f2 * f2 + f3 * f3) > 0.0) {
            this.k();
            this.d.spawnEntityInWorld(new C_b(this.d, this.h, this.i, this.j, new ItemStack(Item.ao)));
        }
    }
}

