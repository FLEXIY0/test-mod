/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.C_af;
import net.minecraft.a.b.C_ag;
import net.minecraft.a.b.C_am;
import net.minecraft.a.b.C_ba;
import net.minecraft.a.b.C_bm;
import net.minecraft.a.b.C_bn;
import net.minecraft.a.b.C_c;
import net.minecraft.a.b.C_n;
import net.minecraft.a.b.C_q;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.a.C_f;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.b.C_aa;
import net.minecraft.client.c.FontRenderer;
import net.minecraft.client.d;
import org.lwjgl.opengl.GL11;

public final class C_g
extends C_j {
    private C_aa modelBipedMain;
    private C_aa modelArmorChestplate;
    private C_aa modelArmor;
    private C_aa modelAccessories;
    private static final String[] h = new String[]{"cloth", "chain", "iron", "diamond", "gold", "emerald", "studded"};

    public C_g() {
        super(new C_aa(0.0f), 0.5f);
        this.modelBipedMain = (C_aa)this.d;
        this.modelArmorChestplate = new C_aa(1.0f);
        this.modelArmor = new C_aa(0.5f);
        this.modelAccessories = new C_aa(0.5f);
    }

    private void a(EntityPlayer entityPlayer, float f, float f2, float f3, float f4, float f5) {
        if (entityPlayer.gamemode == 2) {
            return;
        }
        if (entityPlayer.b.d() != null && entityPlayer.getItemInUseCount() > 0) {
            C_q c_q = entityPlayer.b.d().getItemUseAction();
            if (c_q == C_q.block) {
                this.modelBipedMain.blocking = true;
                this.modelArmor.blocking = true;
                this.modelArmorChestplate.blocking = true;
            } else if (c_q == C_q.bow) {
                this.modelBipedMain.aimedBow = true;
                this.modelArmor.aimedBow = true;
                this.modelArmorChestplate.aimedBow = true;
            }
        }
        this.modelAccessories.sneaking = this.modelBipedMain.sneaking = entityPlayer.isSneaking;
        this.modelArmor.sneaking = this.modelBipedMain.sneaking;
        this.modelArmorChestplate.sneaking = this.modelBipedMain.sneaking;
        this.modelAccessories.inWater = this.modelBipedMain.inWater = entityPlayer.m();
        this.modelArmor.inWater = this.modelBipedMain.inWater;
        this.modelArmorChestplate.inWater = this.modelBipedMain.inWater;
        this.modelAccessories.swingProgress = this.modelBipedMain.swingProgress = this.getSwingProgess(entityPlayer, f5);
        this.modelArmor.swingProgress = this.modelBipedMain.swingProgress;
        this.modelArmorChestplate.swingProgress = this.modelBipedMain.swingProgress;
        this.modelAccessories.isRiding = this.modelBipedMain.isRiding = entityPlayer.isSitting;
        this.modelArmor.isRiding = this.modelBipedMain.isRiding;
        this.modelArmorChestplate.isRiding = this.modelBipedMain.isRiding;
        this.modelArmor.heldItemRight = this.modelAccessories.heldItemRight = this.modelBipedMain.heldItemRight;
        this.modelArmorChestplate.heldItemRight = this.modelAccessories.heldItemRight;
        this.modelArmor.heldItemLeft = this.modelAccessories.heldItemLeft = this.modelBipedMain.heldItemLeft;
        this.modelArmorChestplate.heldItemLeft = this.modelAccessories.heldItemLeft;
        super.renderEntity(entityPlayer, f, f2 - entityPlayer.v, f3, f4, f5);
        this.modelBipedMain.aimedBow = false;
        this.modelAccessories.aimedBow = false;
        this.modelArmor.aimedBow = false;
        this.modelArmorChestplate.aimedBow = false;
        this.modelBipedMain.blocking = false;
        this.modelAccessories.blocking = false;
        this.modelArmor.blocking = false;
        this.modelArmorChestplate.blocking = false;
    }

    public final void a() {
        this.modelBipedMain.d.j = -5.0f;
        this.modelBipedMain.d.k = 2.0f;
        this.modelBipedMain.d.l = 0.0f;
        this.modelBipedMain.d.renderFist(1.0f);
    }

    @Override
    protected void passSpecialRender(C_e c_e, float f, float f2, float f3) {
        EntityPlayer entityPlayer = (EntityPlayer)c_e;
        if (net.minecraft.client.d.isGuiEnabled() && this.a.livingPlayer != null && c_e != this.a.livingPlayer) {
            FontRenderer fontRenderer = this.getFontRendererFromRenderManager();
            GL11.glPushMatrix();
            GL11.glTranslated((double)f, (double)(f2 + 2.6f), (double)f3);
            GL11.glRotatef((float)(180.0f - this.a.d), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glScalef((float)0.05f, (float)-0.05f, (float)0.05f);
            GL11.glTranslatef((float)((float)(-fontRenderer.a(entityPlayer.name)) / 2.0f), (float)0.0f, (float)0.0f);
            GL11.glNormal3f((float)1.0f, (float)-1.0f, (float)1.0f);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)16384);
            if (entityPlayer.name.equalsIgnoreCase("Yoniko98")) {
                fontRenderer.b(entityPlayer.name, 0, 0, 0xFFFF00);
            } else {
                fontRenderer.b(entityPlayer.name, 0, 0, 0xFFFFFF);
            }
            GL11.glDepthFunc((int)516);
            GL11.glDepthMask((boolean)false);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)0.8f);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            if (entityPlayer.name.equalsIgnoreCase("Yoniko98")) {
                fontRenderer.b(entityPlayer.name, 0, 0, 0xFFFF00);
            } else {
                fontRenderer.b(entityPlayer.name, 0, 0, 0xFFFFFF);
            }
            GL11.glDisable((int)3042);
            GL11.glDepthMask((boolean)true);
            GL11.glDepthFunc((int)515);
            GL11.glTranslatef((float)1.0f, (float)1.0f, (float)-0.05f);
            fontRenderer.b(entityPlayer.name, 0, 0, 0x505050);
            GL11.glEnable((int)16384);
            GL11.glEnable((int)2896);
            GL11.glPopMatrix();
        }
    }

    @Override
    protected final boolean a(C_e c_e, int n) {
        Item item;
        EntityPlayer entityPlayer = (EntityPlayer)c_e;
        int n2 = n;
        EntityPlayer entityPlayer2 = entityPlayer;
        int n3 = 3 - n2;
        ItemStack itemStack = entityPlayer2.b.b[n3];
        if (itemStack != null && (item = itemStack.a()) instanceof net.minecraft.a.b.C_j) {
            net.minecraft.a.b.C_j c_j = (net.minecraft.a.b.C_j)item;
            this.a("/armor/" + h[c_j.au] + "_" + (n2 == 2 ? 2 : 1) + ".png");
            C_aa c_aa = n2 == 2 ? this.modelArmor : this.modelArmorChestplate;
            c_aa.a.e = n2 == 0;
            c_aa.b.e = n2 == 0;
            c_aa.c.e = n2 == 1 || n2 == 2;
            c_aa.d.e = n2 == 1;
            c_aa.e.e = n2 == 1;
            c_aa.f.e = n2 == 2 || n2 == 3;
            c_aa.g.e = n2 == 2 || n2 == 3;
            this.a(c_aa);
            return true;
        }
        return false;
    }

    @Override
    protected final boolean renderAccessories(C_e c_e, int n) {
        EntityPlayer entityPlayer;
        EntityPlayer entityPlayer2 = entityPlayer = (EntityPlayer)c_e;
        C_aa c_aa = this.modelAccessories;
        ItemStack itemStack = entityPlayer2.b.charmSlot[0];
        this.a("/armor/accessories.png");
        if (entityPlayer2.b.b[0] != null && entityPlayer2.b.b[0].a() == Item.bootsHermes) {
            c_aa.f.e = true;
            c_aa.g.e = true;
            c_aa.d.e = false;
            c_aa.e.e = false;
            c_aa.a.e = false;
            c_aa.b.e = false;
            c_aa.c.e = false;
            itemStack = entityPlayer2.b.charmSlot[0];
            if (itemStack != null) {
                if (itemStack.a() == Item.spectacles) {
                    c_aa.a.e = true;
                    c_aa.b.e = true;
                } else if (itemStack.a() == Item.gloves) {
                    c_aa.d.e = true;
                    c_aa.e.e = true;
                } else if (itemStack.a() == Item.aquaCharm) {
                    c_aa.c.e = true;
                }
            }
            this.setSecondModelLayer(c_aa);
            return true;
        }
        if (itemStack != null) {
            c_aa.f.e = false;
            c_aa.g.e = false;
            c_aa.d.e = false;
            c_aa.e.e = false;
            c_aa.a.e = false;
            c_aa.b.e = false;
            c_aa.c.e = false;
            if (itemStack.a() == Item.spectacles) {
                c_aa.a.e = true;
                c_aa.b.e = true;
            } else if (itemStack.a() == Item.gloves) {
                c_aa.d.e = true;
                c_aa.e.e = true;
            } else if (itemStack.a() == Item.aquaCharm) {
                c_aa.c.e = true;
            }
            this.setSecondModelLayer(c_aa);
            return true;
        }
        return false;
    }

    protected void renderSpecials(EntityPlayer entityPlayer, float f) {
        float f2;
        ItemStack itemStack = entityPlayer.b.d();
        ItemStack itemStack2 = entityPlayer.b.charmSlot[0];
        if (itemStack != null) {
            GL11.glPushMatrix();
            this.modelBipedMain.d.renderWithRotation(1.0f);
            this.modelBipedMain.heldItemRight = true;
            GL11.glTranslatef((float)-0.0625f, (float)0.4375f, (float)0.0625f);
            if (itemStack.c < 256 && C_f.renderItemIn3d(Block.c[itemStack.c].a())) {
                f2 = 6.5f;
                GL11.glTranslatef((float)-1.0f, (float)9.0f, (float)-3.0f);
                GL11.glRotatef((float)20.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glScalef((float)(f2 *= 0.75f), (float)(-f2), (float)f2);
            } else if (itemStack.c >= 256) {
                if (itemStack.a() instanceof net.minecraft.a.b.C_g || itemStack.a() instanceof C_c || itemStack.a() instanceof C_n) {
                    f2 = 7.5f;
                    GL11.glTranslatef((float)-1.0f, (float)9.0f, (float)0.0f);
                    GL11.glScalef((float)f2, (float)(-f2), (float)f2);
                    GL11.glRotatef((float)-100.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    if (entityPlayer.getItemInUseCount() > 0 && itemStack.getItemUseAction() == C_q.block) {
                        GL11.glTranslatef((float)0.05f, (float)0.0f, (float)-0.1f);
                        GL11.glRotatef((float)-50.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                        GL11.glRotatef((float)-60.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                    }
                } else if (itemStack.a() instanceof net.minecraft.a.b.C_e) {
                    f2 = 7.5f;
                    GL11.glTranslatef((float)-1.0f, (float)9.0f, (float)5.0f);
                    GL11.glScalef((float)f2, (float)(-f2), (float)f2);
                    GL11.glRotatef((float)-100.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                } else if (itemStack.a() instanceof C_ag) {
                    GL11.glTranslatef((float)-0.0625f, (float)0.0f, (float)0.0625f);
                    f2 = 7.5f;
                    GL11.glTranslatef((float)0.0f, (float)9.0f, (float)2.0f);
                    GL11.glScalef((float)f2, (float)(-f2), (float)f2);
                    GL11.glRotatef((float)-110.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                } else if (itemStack.a() instanceof C_bm) {
                    f2 = 7.5f;
                    GL11.glTranslatef((float)-1.0f, (float)13.0f, (float)-1.0f);
                    GL11.glScalef((float)f2, (float)(-f2), (float)f2);
                    GL11.glRotatef((float)-25.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                } else if (itemStack.a() instanceof C_am || itemStack.a() instanceof C_bn) {
                    f2 = 7.5f;
                    GL11.glTranslatef((float)-1.0f, (float)9.0f, (float)0.0f);
                    GL11.glScalef((float)f2, (float)(-f2), (float)f2);
                    GL11.glRotatef((float)-50.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)220.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glTranslatef((float)0.05f, (float)0.325f, (float)0.0f);
                } else if (itemStack.a() instanceof C_af) {
                    f2 = 7.5f;
                    GL11.glTranslatef((float)4.0f, (float)6.25f, (float)-2.5f);
                    GL11.glScalef((float)f2, (float)(-f2), (float)f2);
                    GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)-15.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                } else {
                    f2 = 4.5f;
                    GL11.glTranslatef((float)2.0f, (float)9.0f, (float)-3.0f);
                    GL11.glScalef((float)f2, (float)(-f2), (float)f2);
                    GL11.glRotatef((float)-75.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)-45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)35.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                }
            } else {
                f2 = 5.5f;
                GL11.glTranslatef((float)-0.5f, (float)5.0f, (float)-3.0f);
                GL11.glScalef((float)f2, (float)f2, (float)f2);
                GL11.glRotatef((float)-20.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)-70.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)20.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            }
            this.a.itemRenderer.renderItem(itemStack);
            GL11.glPopMatrix();
        } else {
            this.modelBipedMain.heldItemRight = false;
        }
        if (itemStack2 != null && itemStack2.a() instanceof C_ba) {
            f2 = 8.5f;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)-3.5f, (float)7.5f, (float)4.0f);
            GL11.glScalef((float)f2, (float)f2, (float)f2);
            GL11.glRotatef((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)-45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            if (entityPlayer.isSneaking == 1) {
                GL11.glRotatef((float)35.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glTranslatef((float)0.4f, (float)-0.2f, (float)0.0f);
            } else if (entityPlayer.isSneaking == 2) {
                GL11.glTranslatef((float)0.6f, (float)-1.2f, (float)0.4f);
                GL11.glRotatef((float)85.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)-35.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)35.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            }
            this.a.itemRenderer.renderItem(itemStack2);
            GL11.glPopMatrix();
        }
        if (itemStack2 != null && itemStack2.a() == Item.shield) {
            GL11.glPushMatrix();
            this.modelBipedMain.e.renderWithRotation(1.0f);
            GL11.glTranslatef((float)-0.0625f, (float)0.4375f, (float)0.0625f);
            f2 = 8.5f;
            GL11.glTranslatef((float)4.0f, (float)5.0f, (float)4.0f);
            GL11.glScalef((float)f2, (float)f2, (float)f2);
            GL11.glRotatef((float)-75.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            this.a.itemRenderer.renderItem(itemStack2);
            GL11.glPopMatrix();
        }
    }

    protected final void rotatePlayer(EntityPlayer entityPlayer, float f, float f2, float f3) {
        if (entityPlayer.r() && entityPlayer.isLaying) {
            GL11.glRotatef((float)entityPlayer.getBedOrientationInDegrees(), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)this.a(entityPlayer), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)270.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glTranslatef((float)0.0f, (float)-1.4f, (float)-0.7f);
        } else {
            super.rotateCorpse(entityPlayer, f, f2, f3);
        }
    }

    @Override
    protected void rotateCorpse(C_e c_e, float f, float f2, float f3) {
        this.rotatePlayer((EntityPlayer)c_e, f, f2, f3);
    }

    @Override
    protected final void renderEquippedItems(C_e c_e, float f) {
        this.renderSpecials((EntityPlayer)c_e, f);
    }

    @Override
    public final void renderEntity(C_e c_e, float f, float f2, float f3, float f4, float f5) {
        this.a((EntityPlayer)c_e, f, f2, f3, f4, f5);
    }

    @Override
    public final void a(C_b c_b, float f, float f2, float f3, float f4, float f5) {
        this.a((EntityPlayer)c_b, f, f2, f3, f4, f5);
    }
}

