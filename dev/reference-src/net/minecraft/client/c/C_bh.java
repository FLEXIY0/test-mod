/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import com.a.a.C_m;
import com.a.a.NBTTagCompound;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.C_bi;
import net.minecraft.client.c.C_bj;
import net.minecraft.client.c.C_bm;
import net.minecraft.client.c.Gui;
import net.minecraft.client.c.ScaledResolution;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

class C_bh
extends C_bm {
    C_bj theSelectLevel;
    private boolean selectedSlot;
    final /* synthetic */ C_bj this$0;

    public C_bh(C_bj c_bj, C_bj c_bj2) {
        this.this$0 = c_bj;
        super(c_bj2.b, c_bj2.c, c_bj2.d, 32, c_bj2.d - 64, 36);
        this.selectedSlot = false;
        this.theSelectLevel = c_bj2;
    }

    @Override
    protected int getSize() {
        return C_bj.access$500(this.this$0).size();
    }

    @Override
    protected void elementClicked(int n, boolean bl) {
        C_bj.access$602(this.this$0, n);
        boolean bl2 = C_bj.access$600(this.this$0) >= 0 && C_bj.access$600(this.this$0) < this.getSize();
        File file = new File(this.this$0.b.z, "saves/" + this.this$0.getFileName(C_bj.access$600(this.this$0)));
        short s = this.this$0.b.characters.currentCharacter.c("Gamemode");
        boolean bl3 = this.this$0.b.characters.currentCharacter.k("Cheats");
        boolean bl4 = this.this$0.b.characters.currentCharacter.k("Hardcore");
        try {
            NBTTagCompound nBTTagCompound = C_m.readTags(new FileInputStream(file)).i("Environment");
            if (nBTTagCompound.c("Gamemode") == s && nBTTagCompound.k("Cheats") == bl3 && nBTTagCompound.k("Hardcore") == bl4 || s == 2 && nBTTagCompound.c("Gamemode") == 1 && bl3) {
                C_bj.access$700((C_bj)this.this$0).c = true;
                C_bj.access$700((C_bj)this.this$0).a = "Select level";
                if ((bl || this.selectedSlot) && bl2) {
                    this.this$0.selectWorld(n);
                }
            } else {
                C_bj.access$700((C_bj)this.this$0).c = false;
                C_bj.access$700((C_bj)this.this$0).a = "Incompatible with character!";
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        C_bj.access$800((C_bj)this.this$0).c = bl2;
        C_bj.access$900((C_bj)this.this$0).c = bl2;
        C_bj.access$1000((C_bj)this.this$0).c = bl2;
    }

    @Override
    protected boolean isSelected(int n) {
        return n == C_bj.access$600(this.this$0);
    }

    @Override
    protected int getContentHeight() {
        return C_bj.access$500(this.this$0).size() * 36;
    }

    @Override
    protected void drawBackground() {
        this.this$0.h();
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, C_d c_d) {
        C_bi c_bi = (C_bi)C_bj.access$500(this.this$0).get(n);
        String string = C_bi.access$100(c_bi);
        String string2 = C_bi.access$200(c_bi);
        String string3 = C_bi.access$300(c_bi);
        String string4 = C_bi.access$400(c_bi);
        String string5 = C_bi.access$1100(c_bi);
        String string6 = C_bi.access$1200(c_bi);
        String string7 = C_bi.access$1300(c_bi);
        Gui.b(this.this$0.g, string, n2 + 34, n3 + 1, 0xFFFFFF);
        Gui.b(this.this$0.g, this.this$0.getFileName(n), n2 + 34, n3 + 12, 0x808080);
        Gui.b(this.this$0.g, string2 + ", " + string3 + ", " + string5, n2 + 34, n3 + 12 + 10, 0x808080);
        Gui.b(this.this$0.g, string4, n2 + 214 - this.this$0.g.a(string4), n3 + 22, 0x808080);
        Gui.b(this.this$0.g, string6, n2 + 214 - this.this$0.g.a(string6), n3 + 1, 0xFFFFFF);
        Gui.b(this.this$0.g, string7, n2 + 214 - this.this$0.g.a(string7), n3 + 12, 0x808080);
        boolean bl = false;
        String string8 = "unknown_";
        short s = this.this$0.b.characters.currentCharacter.c("Gamemode");
        boolean bl2 = this.this$0.b.characters.currentCharacter.k("Cheats");
        boolean bl3 = this.this$0.b.characters.currentCharacter.k("Hardcore");
        if (C_bi.access$1400(c_bi) == bl2 && C_bi.access$1500(c_bi) == s && C_bi.access$1600(c_bi) == bl3) {
            bl = true;
            string8 = "";
        }
        if (!(string2.equalsIgnoreCase("Caves") || string2.equalsIgnoreCase("Moon") || string2.equalsIgnoreCase("Ocean"))) {
            string8 = string3.toLowerCase() + "/" + string8;
        }
        try {
            RenderEngine.a(this.theSelectLevel.b.m.a("/gui/worlds/" + string8 + string2.toLowerCase() + ".png"));
        }
        catch (Exception exception) {
            RenderEngine.a(this.theSelectLevel.b.m.a(bl ? "/gui/worlds/world.png" : "/gui/unknown_pack.png"));
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        c_d.b();
        c_d.b(0xFFFFFF);
        c_d.a(n2, n3 + n4, 0.0f, 0.0f, 1.0f);
        c_d.a(n2 + 32, n3 + n4, 0.0f, 1.0f, 1.0f);
        c_d.a(n2 + 32, n3, 0.0f, 1.0f, 0.0f);
        c_d.a(n2, n3, 0.0f, 0.0f, 0.0f);
        c_d.a();
        RenderEngine.a(this.this$0.b.m.a("/gui/gui.png"));
        ScaledResolution scaledResolution = new ScaledResolution(this.this$0.b.w, this.this$0.b.b, this.this$0.b.c);
        int n5 = scaledResolution.a();
        int n6 = scaledResolution.b();
        int n7 = Mouse.getX() * n5 / this.this$0.b.b;
        int n8 = n6 - Mouse.getY() * n6 / this.this$0.b.c - 1;
        int n9 = this.width / 2 - 110;
        int n10 = this.width / 2 + 110;
        int n11 = 0;
        if (n8 >= n3 - 3 && n8 <= n3 + this.slotHeight - 3) {
            if (n7 <= n2 + n4) {
                n11 = 32;
                this.selectedSlot = true;
            } else {
                this.selectedSlot = false;
            }
            if (n7 >= n9 && n7 <= n10) {
                Gui.drawGradientRect(n2, n3, n2 + n4, n3 + n4, -2130706433, -2130706433, 1.0f);
                if (string8.contains("unknown_")) {
                    this.this$0.b(n2 + 6, n3 + 5, 73, 146 + n11, 22, 22);
                } else {
                    this.this$0.b(n2 + 6, n3 + 5, 54, 146 + n11, 22, 22);
                }
            }
        }
    }
}

