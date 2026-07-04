/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.a.C_f;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.b.C_g;
import net.minecraft.client.b.C_l;
import org.lwjgl.opengl.GL11;

public class C_ai
extends C_j {
    private C_g modelBipedMain;
    private C_g modelArmorChestplate;
    private C_g modelArmor;
    private static final String[] armorFilenamePrefix = new String[]{"cloth", "chain", "iron", "diamond", "gold", "emerald", "studded"};

    public C_ai(C_l c_l, float f) {
        super(c_l, f);
        this.modelBipedMain = (C_g)this.d;
        this.modelArmorChestplate = new C_g(1.0f);
        this.modelArmor = new C_g(0.5f);
    }

    @Override
    protected final boolean a(C_e c_e, int n) {
        Item item;
        C_f c_f = (C_f)c_e;
        int n2 = 3 - n;
        ItemStack itemStack = c_f.armorInventory[n2];
        if (itemStack != null && (item = itemStack.a()) instanceof net.minecraft.a.b.C_j) {
            net.minecraft.a.b.C_j c_j = (net.minecraft.a.b.C_j)item;
            this.a("/armor/" + armorFilenamePrefix[c_j.au] + "_" + (n == 2 ? 2 : 1) + ".png");
            C_g c_g = n == 2 ? this.modelArmor : this.modelArmorChestplate;
            c_g.a.e = n == 0;
            c_g.b.e = n == 0;
            c_g.c.e = n == 1 || n == 2;
            c_g.d.e = n == 1;
            c_g.e.e = n == 1;
            c_g.f.e = n == 2 || n == 3;
            c_g.g.e = n == 2 || n == 3;
            this.a(c_g);
            return true;
        }
        return false;
    }

    @Override
    protected final void renderEquippedItems(C_e c_e, float f) {
        this.renderSpecials(c_e, f);
    }

    protected void renderSpecials(C_e c_e, float f) {
        if (((C_f)c_e).heldItem != null) {
            GL11.glPushMatrix();
            this.modelBipedMain.d.renderWithRotation(1.0f);
            this.modelBipedMain.heldItemRight = true;
            GL11.glTranslatef((float)-0.0625f, (float)0.4375f, (float)0.0625f);
            float f2 = 7.5f;
            GL11.glTranslatef((float)-1.0f, (float)9.0f, (float)0.0f);
            GL11.glScalef((float)f2, (float)(-f2), (float)f2);
            GL11.glRotatef((float)-100.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            this.a.itemRenderer.renderItem(((C_f)c_e).heldItem);
            GL11.glPopMatrix();
        }
    }
}

