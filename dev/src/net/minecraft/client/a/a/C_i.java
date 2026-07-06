/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.a.a.C_a;
import net.minecraft.client.a.a.C_aa;
import net.minecraft.client.a.a.C_ab;
import net.minecraft.client.a.a.C_ac;
import net.minecraft.client.a.a.C_ad;
import net.minecraft.client.a.a.C_ae;
import net.minecraft.client.a.a.C_af;
import net.minecraft.client.a.a.C_ag;
import net.minecraft.client.a.a.C_ah;
import net.minecraft.client.a.a.C_ai;
import net.minecraft.client.a.a.C_b;
import net.minecraft.client.a.a.C_c;
import net.minecraft.client.a.a.C_d;
import net.minecraft.client.a.a.C_e;
import net.minecraft.client.a.a.C_f;
import net.minecraft.client.a.a.C_g;
import net.minecraft.client.a.a.C_h;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.a.a.C_k;
import net.minecraft.client.a.a.C_l;
import net.minecraft.client.a.a.C_m;
import net.minecraft.client.a.a.C_n;
import net.minecraft.client.a.a.C_o;
import net.minecraft.client.a.a.C_p;
import net.minecraft.client.a.a.C_q;
import net.minecraft.client.a.a.C_r;
import net.minecraft.client.a.a.C_s;
import net.minecraft.client.a.a.C_t;
import net.minecraft.client.a.a.C_u;
import net.minecraft.client.a.a.C_v;
import net.minecraft.client.a.a.C_w;
import net.minecraft.client.a.a.C_x;
import net.minecraft.client.a.a.C_y;
import net.minecraft.client.a.a.C_z;
import net.minecraft.client.c.FontRenderer;
import net.minecraft.game.entity.md3.EntityBeastBoy;
import net.minecraft.game.entity.md3.EntityBlackSteve;
import net.minecraft.game.entity.md3.EntityRana;
import net.minecraft.game.entity.md3.EntitySteve;
import org.lwjgl.opengl.GL11;

public final class C_i {
    private Map<Class<?>, C_f> e = new HashMap();
    public static C_i a = new C_i();
    private FontRenderer fontRenderer;
    public RenderEngine b;
    public net.minecraft.client.a.C_g itemRenderer;
    public net.minecraft.a.a.World c;
    public net.minecraft.a.c.EntityLiving livingPlayer;
    public float d;
    public float playerViewX;
    private float f;
    private float g;
    private float h;

    private C_i() {
        this.e.put(net.minecraft.a.c.a.C_b.class, new C_m());
        this.e.put(net.minecraft.a.c.a.C_g.class, new C_n());
        this.e.put(net.minecraft.a.c.a.C_l.class, new C_ah());
        this.e.put(net.minecraft.a.c.b.C_c.class, new C_j(new net.minecraft.client.b.C_f(), 0.7f));
        this.e.put(net.minecraft.a.c.b.C_b.class, new C_k(new net.minecraft.client.b.C_a(), new net.minecraft.client.b.C_d(), 0.7f));
        this.e.put(net.minecraft.a.c.b.C_e.class, new C_j(new net.minecraft.client.b.C_r(), 0.7f));
        this.e.put(net.minecraft.a.c.b.C_k.class, new C_ac(new net.minecraft.client.b.C_r(), 0.7f));
        this.e.put(net.minecraft.a.c.b.C_j.class, new C_ab(new net.minecraft.client.b.C_r(), 0.7f));
        this.e.put(net.minecraft.a.c.b.C_f.class, new C_q(new net.minecraft.client.b.C_s(), 0.3f));
        this.e.put(net.minecraft.a.c.b.C_h.class, new C_t(new net.minecraft.client.b.C_u(), 0.5f));
        this.e.put(net.minecraft.a.c.a.C_m.class, new C_ae(new net.minecraft.client.b.C_ac(16), new net.minecraft.client.b.C_ac(0), 0.25f));
        this.e.put(net.minecraft.a.c.b.C_d.class, new C_o());
        this.e.put(net.minecraft.a.c.a.C_h.class, new C_u());
        this.e.put(net.minecraft.a.c.b.C_i.class, new C_x(new net.minecraft.client.b.C_x(), 0.7f));
        this.e.put(net.minecraft.a.c.b.C_g.class, new C_j(new net.minecraft.client.b.C_t(), 0.25f));
        this.e.put(net.minecraft.a.c.a.C_d.class, new C_c());
        this.e.put(net.minecraft.a.c.a.C_c.class, new C_ad(new net.minecraft.client.b.C_m(), 0.5f));
        this.e.put(net.minecraft.a.c.a.EntityZombie.class, new C_ai(new net.minecraft.client.b.C_g(), 0.5f));
        // Pigman: arms-down humanoid model (C_h) instead of the zombie's raised-arm
        // model (C_g); texture still comes from the entity's own V (/mob/pigzombie.png).
        this.e.put(net.minecraft.a.c.a.EntityPigZombie.class, new C_j(new net.minecraft.client.b.C_h(), 0.5f));
        this.e.put(net.minecraft.a.c.a.C_i.class, new C_v(new net.minecraft.client.b.C_g(), 0.5f));
        this.e.put(net.minecraft.a.c.a.C_k.class, new C_j(new net.minecraft.client.b.C_g(), 0.5f));
        this.e.put(net.minecraft.a.c.a.C_j.class, new C_j(new net.minecraft.client.b.C_w(), 0.5f));
        this.e.put(EntityPlayer.class, new C_g());
        this.e.put(net.minecraft.a.c.a.C_a.class, new C_l(new net.minecraft.client.b.C_g(), 0.5f, 6.0f));
        this.e.put(net.minecraft.a.c.EntityLiving.class, new C_j(new net.minecraft.client.b.C_h(), 0.5f));
        this.e.put(net.minecraft.a.c.a.C_e.class, new C_j(new net.minecraft.client.b.C_h(), 0.5f));
        this.e.put(net.minecraft.a.c.a.C_n.class, new C_j(new net.minecraft.client.b.C_ad(), 0.5f));
        this.e.put(EntitySteve.class, new C_z(0));
        this.e.put(EntityBlackSteve.class, new C_z(1));
        this.e.put(EntityBeastBoy.class, new C_z(2));
        this.e.put(EntityRana.class, new C_z(3));
        this.e.put(net.minecraft.a.c.Entity.class, new C_a());
        this.e.put(net.minecraft.a.c.C_a.class, new C_h());
        this.e.put(net.minecraft.a.c.c.C_e.class, new C_w());
        this.e.put(net.minecraft.a.c.d.C_a.class, new C_b());
        this.e.put(net.minecraft.a.c.d.C_b.class, new C_p());
        this.e.put(net.minecraft.a.c.d.C_g.class, new C_ag());
        this.e.put(net.minecraft.a.c.c.EntityItem.class, new C_e());
        this.e.put(net.minecraft.a.c.c.C_a.class, new C_d());
        this.e.put(net.minecraft.a.c.c.C_c.class, new C_r());
        this.e.put(net.minecraft.a.c.c.C_g.class, new C_aa());
        this.e.put(net.minecraft.a.c.c.C_d.class, new C_s());
        this.e.put(net.minecraft.a.c.d.C_f.class, new C_af(233));
        this.e.put(net.minecraft.a.c.d.C_e.class, new C_af(238));
        this.e.put(net.minecraft.a.c.d.C_d.class, new C_af(297));
        this.e.put(net.minecraft.a.c.d.C_c.class, new C_af(203));
        this.e.put(net.minecraft.a.c.c.C_f.class, new C_y());
        Iterator<C_f> iterator = this.e.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().a(this);
        }
    }

    public final C_f a(net.minecraft.a.c.Entity c_b) {
        Class<?> clazz = c_b.getClass();
        C_f c_f = this.e.get(clazz);
        if (c_f == null && clazz != net.minecraft.a.c.Entity.class) {
            c_f = this.e.get(clazz.getSuperclass());
            this.e.put(clazz, c_f);
        }
        return c_f;
    }

    public final void cacheActiveRenderInfo(net.minecraft.a.a.World c_g, RenderEngine renderEngine, FontRenderer fontRenderer, EntityPlayer entityPlayer, float f) {
        this.c = c_g;
        this.b = renderEngine;
        this.livingPlayer = entityPlayer;
        this.fontRenderer = fontRenderer;
        this.d = entityPlayer.p + (entityPlayer.n - entityPlayer.p) * f;
        this.playerViewX = entityPlayer.q + (entityPlayer.o - entityPlayer.q) * f;
        this.f = entityPlayer.B + (entityPlayer.h - entityPlayer.B) * f;
        this.g = entityPlayer.C + (entityPlayer.i - entityPlayer.C) * f;
        this.h = entityPlayer.D + (entityPlayer.j - entityPlayer.D) * f;
    }

    public final void a(net.minecraft.a.c.Entity c_b, float f) {
        float f2 = c_b.B + (c_b.h - c_b.B) * f;
        float f3 = c_b.C + (c_b.i - c_b.C) * f;
        float f4 = c_b.D + (c_b.j - c_b.D) * f;
        float f5 = c_b.p + (c_b.n - c_b.p) * f;
        float f6 = this.c.c((int)f2, (int)(f3 + c_b.c_()), (int)f4);
        if (this.c.mc.f.nightVision && (f6 += 0.7f) > 1.0f) {
            f6 = 1.0f;
        }
        if (c_b.canGlow) {
            f6 = 1.0f;
        }
        GL11.glColor3f((float)f6, (float)f6, (float)f6);
        if (!c_b.u) {
            this.a(c_b, f2, f3, f4, f5, f);
        }
    }

    public final void a(net.minecraft.a.c.Entity c_b, float f, float f2, float f3, float f4, float f5) {
        C_f c_f = this.a(c_b);
        if (c_f != null) {
            c_f.a(c_b, f, f2, f3, f4, f5);
            c_f.a(c_b, f, f2, f3, f5);
        }
    }

    public final void a(net.minecraft.a.a.World c_g) {
        this.c = c_g;
    }

    public final float a(float f, float f2, float f3) {
        return (f -= this.f) * f + (f2 -= this.g) * f2 + (f3 -= this.h) * f3;
    }

    public FontRenderer getFontRenderer() {
        return this.fontRenderer;
    }
}

