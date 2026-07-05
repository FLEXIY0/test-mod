/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.a;

import com.a.a.NBTTagCompound;
import java.util.List;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.a.C_e;
import net.minecraft.a.c.a.C_o;
import net.minecraft.a.c.d.C_f;
import net.minecraft.a.c.e.EntityPlayer;
import util.MathHelper;

public class C_n
extends C_o {
    public C_n(World c_g) {
        super(c_g);
        this.V = "/mob/snowman.png";
        this.a(0.4f, 1.8f);
    }

    public C_n(World c_g, int n, int n2, int n3) {
        super(c_g);
        this.V = "/mob/snowman.png";
        this.a(0.4f, 1.8f);
        this.b(n, n2, n3);
    }

    @Override
    public void f() {
        C_b c_b;
        List<C_b> list;
        super.f();
        if (this.b == null && this.d.q.nextInt(100) == 0 && !(list = this.d.a(this, this.r.b(16.0f, 4.0f, 16.0f))).isEmpty() && (c_b = list.get(this.d.q.nextInt(list.size()))) instanceof C_e && !(c_b instanceof EntityPlayer)) {
            this.b = list.get(this.d.q.nextInt(list.size()));
        }
        int n = MathHelper.a((double)this.h);
        int n2 = MathHelper.a((double)this.i);
        int n3 = MathHelper.a((double)this.j);
        for (n = 0; n < 4; ++n) {
            int n4;
            n2 = MathHelper.a((double)this.h + (double)((float)(n % 2 * 2 - 1) * 0.25f));
            if (this.d.a(n2, n3 = MathHelper.a((double)this.i), n4 = MathHelper.a((double)this.j + (double)((float)(n / 2 % 2 * 2 - 1) * 0.25f))) != 0 || this.d.a(n2, n3 - 1, n4) == Block.snowLayer.at || !Block.snowLayer.a(this.d, n2, n3, n4)) continue;
            this.d.b(n2, n3, n4, Block.snowLayer.at);
        }
    }

    @Override
    protected void a(C_b c_b, float f) {
        if (f < 10.0f) {
            float f2 = c_b.h - this.h;
            float f3 = c_b.j - this.j;
            if (this.ac == 0) {
                C_f c_f = new C_f(this.d, this);
                float f4 = c_b.i + c_b.n() - 1.1f - c_f.i;
                float f5 = MathHelper.c(f2 * f2 + f3 * f3) * 0.2f;
                this.d.a(this, "random.bow", 1.0f, 1.0f / (this.G.nextFloat() * 0.4f + 0.8f));
                this.d.spawnEntityInWorld(c_f);
                c_f.setSnowballHeading(f2, f4 + f5, f3, 1.6f, 12.0f);
                this.ac = 10;
            }
            this.n = (float)(Math.atan2(f3, f2) * 180.0 / 3.1415927410125732) - 90.0f;
            this.O = true;
        }
    }

    @Override
    public void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
    }

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
    }

    protected int getDropItemId() {
        return Item.snowball.ap;
    }

    @Override
    public String a() {
        return "Snowman";
    }

    @Override
    public int statId() {
        return 24;
    }

    @Override
    protected void dropFewItems(C_b c_b) {
        int n = this.G.nextInt(16);
        for (int i = 0; i < n; ++i) {
            this.a(Item.snowball.ap, 1, 0.0f);
        }
    }
}

