/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.c;

import com.a.a.NBTTagCompound;
import java.util.List;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.c.C_b;
import util.MathHelper;

public class C_f
extends C_b {
    private int thunderAge;
    public long thunderStrength = 0L;
    private int thunderFlash;

    public C_f(C_g c_g, float f, float f2, float f3) {
        super(c_g);
        this.b(f, f2, f3, 0.0f, 0.0f);
        this.thunderAge = 2;
        this.thunderStrength = this.G.nextLong();
        this.thunderFlash = this.G.nextInt(3) + 1;
        if (c_g.E >= 2) {
            int n;
            int n2;
            int n3 = MathHelper.a((double)f);
            if (c_g.a(n3, n2 = MathHelper.a((double)f2), n = MathHelper.a((double)f3)) == 0 && C_x.ag.a(c_g, n3, n2, n) && !c_g.multiplayerWorld) {
                c_g.b(n3, n2, n, C_x.ag.at);
            }
            if (c_g.a(n3, n2 - 1, n) != C_x.rod.at) {
                for (n3 = 0; n3 < 4; ++n3) {
                    int n4;
                    n2 = MathHelper.a((double)f) + this.G.nextInt(3) - 1;
                    if (c_g.a(n2, n = MathHelper.a((double)f2) + this.G.nextInt(3) - 1, n4 = MathHelper.a((double)f3) + this.G.nextInt(3) - 1) != 0 || !C_x.ag.a(c_g, n2, n, n4)) continue;
                    c_g.b(n2, n, n4, C_x.ag.at);
                }
            }
        }
    }

    @Override
    public void b_() {
        int n;
        super.b_();
        if (this.thunderAge == 2) {
            this.d.a(this.h, this.i, this.j, "random.thunder", 10000.0f, 0.8f + this.G.nextFloat() * 0.2f);
            this.d.a(this.h, this.i, this.j, "random.explode", 2.0f, 0.5f + this.G.nextFloat() * 0.2f);
        }
        --this.thunderAge;
        if (this.thunderAge < 0) {
            if (this.thunderFlash == 0) {
                this.k();
            } else if (this.thunderAge < -this.G.nextInt(10)) {
                int n2;
                --this.thunderFlash;
                this.thunderAge = 1;
                this.thunderStrength = this.G.nextLong();
                int n3 = MathHelper.a((double)this.h);
                if (this.d.a(n3, n = MathHelper.a((double)this.i), n2 = MathHelper.a((double)this.j)) == 0 && C_x.ag.a(this.d, n3, n, n2)) {
                    this.d.b(n3, n, n2, C_x.ag.at);
                }
            }
        }
        if (this.thunderAge >= 0) {
            List<C_b> list = this.d.a(this, this.r.a(this.h, this.i, this.j));
            for (n = 0; n < list.size(); ++n) {
                C_b c_b = list.get(n);
                c_b.onStruckByLightning(this);
            }
            this.d.lightStrike = 2;
        }
    }

    @Override
    protected void entityInit() {
    }

    @Override
    protected void b(NBTTagCompound nBTTagCompound) {
    }

    @Override
    protected void a(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public String a() {
        return null;
    }
}

