/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c.a;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.b.a.C_l;
import net.minecraft.client.c.ChatAllowedCharacters;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import net.minecraft.network.packet.Packet130UpdateSign;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class C_n
extends GuiScreen {
    protected String screenTitle = "Edit sign message:";
    private C_l sign;
    private int updateCounter;
    private int editLine = 0;

    public C_n(C_l c_l) {
        this.sign = c_l;
    }

    @Override
    public void b() {
        this.e.clear();
        Keyboard.enableRepeatEvents((boolean)true);
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 120, "Done"));
        this.sign.setEditable(false);
    }

    @Override
    public void a() {
        super.a();
        Keyboard.enableRepeatEvents((boolean)false);
        if (this.b.d.multiplayerWorld) {
            this.b.getSendQueue().addToSendQueue(new Packet130UpdateSign(this.sign.b, this.sign.c, this.sign.d, this.sign.signText));
        }
        this.sign.setEditable(true);
    }

    @Override
    public void f_() {
        ++this.updateCounter;
    }

    @Override
    protected void a(GuiButton guiButton) {
        if (guiButton.c && guiButton.b == 0) {
            this.sign.onInventoryChanged();
            this.b.a((GuiScreen)null);
        }
    }

    @Override
    protected void a(char c, int n) {
        if (n == 1) {
            this.sign.onInventoryChanged();
            this.b.a((GuiScreen)null);
        }
        if (n == 200) {
            this.editLine = this.editLine - 1 & 3;
        }
        if (n == 208 || n == 28) {
            this.editLine = this.editLine + 1 & 3;
        }
        if (n == 14 && this.sign.signText[this.editLine].length() > 0) {
            this.sign.signText[this.editLine] = this.sign.signText[this.editLine].substring(0, this.sign.signText[this.editLine].length() - 1);
        }
        if (ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(c) >= 0 && this.sign.signText[this.editLine].length() < 15) {
            this.sign.signText[this.editLine] = this.sign.signText[this.editLine] + c;
        }
    }

    @Override
    public void a(int n, int n2, float f) {
        this.h();
        C_n.a(this.g, this.screenTitle, this.c / 2, 40, 0xFFFFFF);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(this.c / 2), (float)(this.d / 4 + 60), (float)50.0f);
        float f2 = 93.75f;
        GL11.glScalef((float)(-f2), (float)(-f2), (float)(-f2));
        GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        C_x c_x = this.sign.getBlockType();
        if (c_x == C_x.signStanding || c_x == C_x.signHanging || c_x == C_x.signBirchStanding || c_x == C_x.signBirchHanging || c_x == C_x.signPalmStanding || c_x == C_x.signPalmHanging || c_x == C_x.signDarkStanding || c_x == C_x.signDarkHanging) {
            float f3 = (float)(this.sign.getBlockMetadata() * 360) / 16.0f;
            GL11.glRotatef((float)f3, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glTranslatef((float)0.0f, (float)0.3125f, (float)0.0f);
        } else {
            int n3 = this.sign.getBlockMetadata();
            float f4 = 0.0f;
            if (n3 == 2) {
                f4 = 180.0f;
            }
            if (n3 == 4) {
                f4 = 90.0f;
            }
            if (n3 == 5) {
                f4 = -90.0f;
            }
            GL11.glRotatef((float)f4, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glTranslatef((float)0.0f, (float)0.3125f, (float)0.0f);
        }
        if (this.updateCounter / 6 % 2 == 0) {
            this.sign.lineBeingEdited = this.editLine;
        }
        TileEntityRenderer.instance.renderTileEntityAt(this.sign, -0.5f, -0.75f, -0.5f, 0.0f);
        this.sign.lineBeingEdited = -1;
        GL11.glPopMatrix();
        super.a(n, n2, f);
    }
}

