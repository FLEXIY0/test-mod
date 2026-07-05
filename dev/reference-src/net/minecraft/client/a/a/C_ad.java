/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.EntityLiving;
import net.minecraft.a.c.a.C_c;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.b.C_l;
import net.minecraft.client.b.C_m;
import org.lwjgl.opengl.GL11;

public class C_ad
extends C_j {
    private C_m modelBipedMain;
    private C_m modelArmorChestplate;
    private C_m modelArmor;
    private static final String[] armorFilenamePrefix = new String[]{"cloth", "chain", "iron", "diamond", "gold", "emerald", "studded"};

    public C_ad(C_l c_l, float f) {
        super(c_l, f);
        this.modelBipedMain = (C_m)this.d;
        this.modelArmorChestplate = new C_m(1.0f);
        this.modelArmor = new C_m(0.5f);
    }

    @Override
    protected final boolean a(EntityLiving c_e, int n) {
        Item item;
        C_c c_c = (C_c)c_e;
        int n2 = 3 - n;
        ItemStack itemStack = c_c.armorInventory[n2];
        if (itemStack != null && (item = itemStack.a()) instanceof net.minecraft.a.b.C_j) {
            net.minecraft.a.b.C_j c_j = (net.minecraft.a.b.C_j)item;
            this.a("/armor/" + armorFilenamePrefix[c_j.au] + "_" + (n == 2 ? 2 : 1) + ".png");
            C_m c_m = n == 2 ? this.modelArmor : this.modelArmorChestplate;
            c_m.a.e = n == 0;
            c_m.b.e = n == 0;
            c_m.c.e = n == 1 || n == 2;
            c_m.d.e = n == 1;
            c_m.e.e = n == 1;
            c_m.f.e = n == 2 || n == 3;
            c_m.g.e = n == 2 || n == 3;
            this.a(c_m);
            return true;
        }
        return false;
    }

    @Override
    protected final void renderEquippedItems(EntityLiving c_e, float f) {
        this.renderSpecials(c_e, f);
    }

    protected void renderSpecials(EntityLiving c_e, float f) {
        GL11.glPushMatrix();
        this.modelBipedMain.d.renderWithRotation(1.0f);
        this.modelBipedMain.heldItemRight = true;
        GL11.glTranslatef((float)-0.0625f, (float)0.4375f, (float)0.0625f);
        float f2 = 7.5f;
        GL11.glTranslatef((float)0.0f, (float)9.0f, (float)5.0f);
        GL11.glScalef((float)f2, (float)(-f2), (float)f2);
        GL11.glRotatef((float)-100.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        this.a.itemRenderer.renderItem(new ItemStack(Item.g));
        GL11.glPopMatrix();
    }
}

