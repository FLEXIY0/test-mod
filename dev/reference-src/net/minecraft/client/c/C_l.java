/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.Sys
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.C_b;
import net.minecraft.client.C_c;
import net.minecraft.client.C_k;
import net.minecraft.client.GameSettings;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.a.a.C_e;
import net.minecraft.client.c.C_ag;
import net.minecraft.client.c.FontRenderer;
import net.minecraft.client.c.Gui;
import net.minecraft.client.c.ScaledResolution;
import net.minecraft.client.d;
import net.minecraft.client.g.C_d;
import net.minecraft.network.GuiPlayerInfo;
import net.minecraft.network.NetClientHandler;
import net.minecraft.network.NetworkManager;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public final class C_l
extends Gui {
    private static C_e a = new C_e();
    public List<C_k> b = new ArrayList<C_k>();
    private Random c = new Random();
    private d d;
    private int e = 0;
    float prevVignetteBrightness = 1.0f;
    private String[] seasons = new String[]{"Spring", "Summer", "Autumn", "Winter"};
    private String recordPlaying = "";
    private int recordPlayingUpFor = 0;
    private boolean colored = false;
    private byte meta = 0;

    public C_l(d d2) {
        this.d = d2;
    }

    public final void a(float f) {
        int n;
        float f2;
        ScaledResolution scaledResolution = new ScaledResolution(this.d.w, this.d.b, this.d.c);
        int n2 = scaledResolution.a();
        int n3 = scaledResolution.b();
        FontRenderer fontRenderer = this.d.n;
        this.d.q.c();
        if (this.d.f.gamemode != 2 && (this.d.d.a(this.d.f.h, this.d.f.i, this.d.f.j) || this.d.d.isQuicksand(this.d.f.h, this.d.f.i, this.d.f.j))) {
            this.renderBlockOverlay(n2, n3);
        }
        int n4 = this.d.f.W;
        int n5 = this.d.f.X;
        int n6 = 0;
        int n7 = 0;
        if (GameSettings.f) {
            if (this.d.d.isBloodMoon()) {
                this.renderTint(this.d.d.a(f), n2, n3, 0.8f, 0.0f, 0.0f);
            } else if (this.d.d.getRaining()) {
                this.renderTint((float)((double)this.d.d.getRainStatus(f) * ((double)this.d.d.getSavedLightValue(net.minecraft.a.a.C_l.Sky, MathHelper.a((double)this.d.f.h), MathHelper.a((double)this.d.f.i), MathHelper.a((double)this.d.f.j)) / 15.0)), n2, n3, 0.3f, 0.3f, 0.3f);
            }
        }
        if (this.d.w.showHUD && this.d.f.gamemode != 2) {
            boolean bl;
            int n8;
            int n9;
            int n10;
            int n11;
            boolean bl2;
            GL11.glEnable((int)3042);
            if (GameSettings.f) {
                this.renderVignette(this.d.f.a(f), n2, n3);
            }
            if ((f2 = this.d.f.prevTimeInPortal + (this.d.f.timeInPortal - this.d.f.prevTimeInPortal) * f) > 0.0f) {
                if (this.d.f.isInsideOfMaterial(net.minecraft.a.a.d.C_c.portal)) {
                    this.meta = this.d.d.e(MathHelper.d(this.d.f.h), MathHelper.d(this.d.f.i), MathHelper.d(this.d.f.j));
                }
                this.renderPortalOverlay(f2, n2, n3);
            }
            GL11.glBindTexture((int)3553, (int)this.d.m.a("/gui/gui.png"));
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            C_b c_b = this.d.f.b;
            this.h = -90.0f;
            this.b(n2 / 2 - 91, n3 - 24, 0, 0, 182, 22);
            this.b(n2 / 2 - 91 - 1 + c_b.c * 20, n3 - 24 - 1, 182, 0, 24, 24);
            if (this.d.f.b.charmSlot[0] != null) {
                this.b(n2 / 2 + 96, n3 - 25, 0, 22, 22, 23);
            }
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glBindTexture((int)3553, (int)this.d.m.a("/gui/icons.png"));
            if (this.d.w.thirdPersonView == 0) {
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)775, (int)769);
                this.b(n2 / 2 - 7, n3 / 2 - 7, 0, 0, 16, 16);
                GL11.glDisable((int)3042);
            }
            int n12 = n = this.d.f.L / 3 % 2 == 1 ? 1 : 0;
            if (this.d.f.L < 10) {
                n = 0;
            }
            boolean bl3 = bl2 = this.d.f.L / 3 % 2 == 1;
            if (this.d.f.L < 2) {
                bl2 = false;
            }
            n6 = this.d.f.isHardcoreEnabled ? 9 : 0;
            if (this.d.f.poison > 0) {
                n7 = 55;
            }
            this.c.setSeed(this.e * 312871);
            if (this.d.a.d()) {
                int n13;
                int n14;
                n11 = this.d.f.b.e();
                for (n10 = 0; n10 < 10; ++n10) {
                    n9 = n3 - 35;
                    if (n11 > 0) {
                        n8 = n2 / 2 + 91 - (n10 << 3) - 9;
                        if ((n10 << 1) + 1 < n11) {
                            this.b(n8, n9, 34, 9, 9, 9);
                        }
                        if ((n10 << 1) + 1 == n11) {
                            this.b(n8, n9, 25, 9, 9, 9);
                        }
                        if ((n10 << 1) + 1 > n11) {
                            this.b(n8, n9, 16, 9, 9, 9);
                        }
                    }
                    n14 = 0;
                    if (n != 0) {
                        n14 = 1;
                    }
                    n13 = n2 / 2 - 91 + (n10 << 3);
                    if (n4 <= 4) {
                        n9 += this.c.nextInt(2);
                    }
                    this.b(n13, n9, 16 + n14 * 9, 0, 9, 9);
                    if (n != 0) {
                        if ((n10 << 1) + 1 < n5) {
                            this.b(n13, n9, 70 + n7, 0 + n6, 9, 9);
                        }
                        if ((n10 << 1) + 1 == n5) {
                            this.b(n13, n9, 79 + n7, 0 + n6, 9, 9);
                        }
                    }
                    if ((n10 << 1) + 1 < n4) {
                        this.b(n13, n9, 52 + n7, 0 + n6, 9, 9);
                    }
                    if ((n10 << 1) + 1 != n4) continue;
                    this.b(n13, n9, 61 + n7, 0 + n6, 9, 9);
                }
                if (n4 > 20) {
                    for (n10 = 0; n10 < 10; ++n10) {
                        n9 = n3 - 35;
                        n14 = 0;
                        if (bl2) {
                            n14 = 1;
                        }
                        n13 = n2 / 2 - 91 + (n10 << 3);
                        if ((n10 << 1) + 1 < n4 - 20) {
                            this.b(n13, n9 - 10, 16 + n14 * 9, 0 + n6, 9, 9);
                            this.b(n13 - 1, n9 - 10, 87, 0 + n6, 9, 9);
                        }
                        if ((n10 << 1) + 1 != n4 - 20) continue;
                        this.b(n13, n9 - 10, 16 + n14 * 9, 0 + n6, 9, 9);
                        this.b(n13 - 1, n9 - 10, 96, 0 + n6, 9, 9);
                    }
                }
                if (this.d.f.m() || this.d.d.type == 8 || this.d.f.M < this.d.f.K) {
                    double d2 = 300.0;
                    d2 = this.d.f.b.b[3] != null && this.d.f.b.b[3].c == Item.ah.ap ? 600.0 : 300.0;
                    n10 = (int)Math.ceil((double)(this.d.f.M - 2) * 10.0 / d2);
                    n9 = (int)Math.ceil((double)this.d.f.M * 10.0 / d2) - n10;
                    int n15 = 10;
                    if (n4 > 20) {
                        n15 = n11 > 0 ? 10 : 0;
                    }
                    for (n8 = 0; n8 < n10 + n9; ++n8) {
                        if (n8 < n10) {
                            if (n4 > 20) {
                                this.b(n2 / 2 + 82 - (n8 << 3), n3 - 32 - n15 - 3, 16, 18, 9, 9);
                                continue;
                            }
                            this.b(n2 / 2 - 91 + (n8 << 3), n3 - 32 - n15 - 3, 16, 18, 9, 9);
                            continue;
                        }
                        if (n4 > 20) {
                            this.b(n2 / 2 + 82 - (n8 << 3), n3 - 32 - n15 - 3, 25, 18, 9, 9);
                            continue;
                        }
                        this.b(n2 / 2 - 91 + (n8 << 3), n3 - 32 - n15 - 3, 25, 18, 9, 9);
                    }
                }
            }
            GL11.glDisable((int)3042);
            GL11.glEnable((int)2977);
            GL11.glPushMatrix();
            GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            C_c.b();
            GL11.glPopMatrix();
            for (n11 = 0; n11 < 9; ++n11) {
                n10 = n2 / 2 - 90 + n11 * 20 + 2;
                n8 = n3 - 16 - 5;
                ItemStack itemStack = this.d.f.b.a[n11];
                if (itemStack == null) continue;
                float f3 = (float)itemStack.b - f;
                if (f3 > 0.0f) {
                    GL11.glPushMatrix();
                    float f5 = 1.0f + f3 / 5.0f;
                    GL11.glTranslatef((float)(n10 + 8), (float)(n8 + 12), (float)0.0f);
                    GL11.glScalef((float)(1.0f / f5), (float)((f5 + 1.0f) / 2.0f), (float)1.0f);
                    GL11.glTranslatef((float)(-(n10 + 8)), (float)(-(n8 + 12)), (float)0.0f);
                }
                a.a(this.d.m, itemStack, n10, n8);
                if (f3 > 0.0f) {
                    GL11.glPopMatrix();
                }
                a.a(this.d.n, itemStack, n10, n8);
            }
            if (this.d.f.b.charmSlot[0] != null) {
                n10 = n2 / 2 + 99;
                n8 = n3 - 21;
                a.a(this.d.m, this.d.f.b.charmSlot[0], n10, n8);
                a.a(this.d.n, this.d.f.b.charmSlot[0], n10, n8);
                if (this.d.f.b.charmSlot[0].a() == Item.quiver) {
                    C_c.a();
                    int n16 = 0;
                    if (this.d.f.b.quiverInventory[0] != null) {
                        n16 += this.d.f.b.quiverInventory[0].a;
                    }
                    if (this.d.f.b.quiverInventory[1] != null) {
                        n16 += this.d.f.b.quiverInventory[1].a;
                    }
                    if (this.d.f.b.quiverInventory[2] != null) {
                        n16 += this.d.f.b.quiverInventory[2].a;
                    }
                    String string = "" + n16;
                    C_l.a(this.d.n, string, n10 + 30, n8 + 5, 0xFFFFFF);
                    C_c.b();
                }
            }
            C_c.a();
            GL11.glDisable((int)2977);
            ItemStack itemStack = this.d.f.b.a[this.d.f.b.c];
            if (itemStack != null && (float)itemStack.textTime > 0.0f) {
                float f6 = (float)itemStack.textTime - f;
                int n17 = (int)(f6 * 256.0f / 10.0f);
                if (n17 > 255) {
                    n17 = 255;
                }
                if (n17 > 8) {
                    n10 = this.d.a instanceof net.minecraft.client.dx.C_c ? 32 : (this.d.f.m() ? 52 : 42);
                    GL11.glEnable((int)3042);
                    GL11.glBlendFunc((int)770, (int)771);
                    C_l.a(fontRenderer, itemStack.getItemName(), n2 / 2, n3 - (n10 += 3), 0xFFFFFF + (n17 << 24));
                    GL11.glDisable((int)3042);
                }
            }
            if (this.d.w.d) {
                fontRenderer.drawStringWithBackground("Minecraft Indev+ Sunset Edition", 2, 2, 0xFFFF55);
                fontRenderer.drawStringWithBackground("" + this.d.B, 2, 12, 0xFFFFFF);
                d d3 = this.d;
                String string = "empty";
                if (this.d.v != null) {
                    if (this.d.v.a == 0) {
                        Block c_x = Block.c[this.d.d.a(this.d.v.b, this.d.v.c, this.d.v.d)];
                        byte by = this.d.d.e(this.d.v.b, this.d.v.c, this.d.v.d);
                        string = c_x.getBlockName(by) + " (" + c_x.at + ":" + by + ") at " + this.d.v.b + "x " + this.d.v.c + "y " + this.d.v.d + "z ";
                    } else if (this.d.v.a == 1) {
                        string = this.d.v.g.a() + ", ID: " + this.d.v.g.entityId;
                    }
                }
                fontRenderer.drawStringWithBackground(this.d.e.b(), 2, 32, 0xFFFFFF);
                fontRenderer.drawStringWithBackground(this.d.e.c(), 2, 42, 0xFFFFFF);
                fontRenderer.drawStringWithBackground("P: " + d3.g.b() + ", T: " + d3.d.j() + ", " + d3.getTileEntityList(), 2, 52, 0xFFFFFF);
                fontRenderer.drawStringWithBackground("Position: " + (int)d3.f.h + "x, " + (int)d3.f.i + "y, " + (int)d3.f.j + "z", 2, 72, 0xFFFFFF);
                fontRenderer.drawStringWithBackground("Pitch: " + (int)this.d.f.o + ", Yaw: " + (long)(this.d.f.n % 360.0f), 2, 82, 0xFFFFFF);
                fontRenderer.drawStringWithBackground("Looking at: " + string, 2, 92, 0xFFFFFF);
                fontRenderer.drawStringWithBackground("Seed: " + d3.d.seed, 2, 112, 0xFFFFFF);
                fontRenderer.drawStringWithBackground("Day: " + d3.d.daysPassed, 2, 122, 0xFFFFFF);
                fontRenderer.drawStringWithBackground("Season: " + this.seasons[d3.d.season.currentSeason], 2, 132, 0xFFFFFF);
                fontRenderer.drawStringWithBackground("Wind Force: " + d3.d.getWindForce(), 2, 152, 0xFFFFFF);
                fontRenderer.drawStringWithBackground("Wind Direction: " + d3.d.getWindDirection(), 2, 162, 0xFFFFFF);
                fontRenderer.drawStringWithBackground("Fog Distance: " + d3.d.getFogDistance(), 2, 182, 0xFFFFFF);
                fontRenderer.drawStringWithBackground("Fog Density: " + d3.d.getFogDensity(), 2, 192, 0xFFFFFF);
                String string2 = "GPU: " + GL11.glGetString((int)7937);
                fontRenderer.drawStringWithBackground(string2, n2 - fontRenderer.a(string2) - 2, 32, 0xFFFFFF);
                string2 = "Driver: " + GL11.glGetString((int)7938) + ", " + this.d.b + "x" + this.d.c;
                fontRenderer.drawStringWithBackground(string2, n2 - fontRenderer.a(string2) - 2, 42, 0xFFFFFF);
                string2 = "LWJGL Version: " + Sys.getVersion();
                fontRenderer.drawStringWithBackground(string2, n2 - fontRenderer.a(string2) - 2, 62, 0xFFFFFF);
                string2 = "OS: " + System.getProperty("os.name") + " " + System.getProperty("os.arch");
                fontRenderer.drawStringWithBackground(string2, n2 - fontRenderer.a(string2) - 2, 72, 0xFFFFFF);
                string2 = "Java Version: " + System.getProperty("java.version");
                fontRenderer.drawStringWithBackground(string2, n2 - fontRenderer.a(string2) - 2, 82, 0xFFFFFF);
                string2 = "Mod Revision: 20251230";
                fontRenderer.drawStringWithBackground(string2, n2 - fontRenderer.a(string2) - 2, 92, 0xFFFFFF);
                long l = Runtime.getRuntime().maxMemory();
                long l2 = Runtime.getRuntime().totalMemory();
                long l3 = Runtime.getRuntime().freeMemory();
                long l4 = l - l3;
                string2 = "Free memory: " + l4 * 100L / l + "% of " + l / 1024L / 1024L + "MB";
                fontRenderer.drawStringWithBackground(string2, n2 - fontRenderer.a(string2) - 2, 2, 0xE0E0E0);
                string2 = "Allocated memory: " + l2 * 100L / l + "% (" + l2 / 1024L / 1024L + "MB)";
                fontRenderer.drawStringWithBackground(string2, n2 - fontRenderer.a(string2) - 2, 12, 0xE0E0E0);
                boolean bl4 = this.d.isMultiplayerWorld();
                if (bl4) {
                    string2 = "Bytes RX: " + NetworkManager.bytesRead;
                    fontRenderer.drawStringWithBackground(string2, n2 - fontRenderer.a(string2) - 2, 92, 0xE0E0E0);
                    string2 = "Bytes TX: " + NetworkManager.bytesWritten;
                    fontRenderer.drawStringWithBackground(string2, n2 - fontRenderer.a(string2) - 2, 102, 0xE0E0E0);
                }
            }
            byte by = (byte)((bl = this.d.o instanceof C_ag) ? 20 : 10);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glDisable((int)3008);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)0.0f, (float)(n3 - 48), (float)0.0f);
            for (n9 = 0; n9 < this.b.size() && n9 < by; ++n9) {
                if (this.b.get((int)n9).time >= 200 && !bl) continue;
                double d4 = (double)this.b.get((int)n9).time / 200.0;
                d4 = 1.0 - d4;
                if ((d4 *= 10.0) < 0.0) {
                    d4 = 0.0;
                }
                if (d4 > 1.0) {
                    d4 = 1.0;
                }
                d4 *= d4;
                int n18 = (int)(255.0 * d4);
                if (bl) {
                    n18 = 255;
                }
                if (n18 <= 8) continue;
                int n19 = 2;
                int n20 = -n9 * 9;
                String string = this.b.get((int)n9).message;
                C_l.a(n19, n20 - 1, n19 + 320, n20 + 8, n18 / 2 << 24);
                GL11.glEnable((int)3042);
                C_l.b(fontRenderer, string, n19, n20, 0xFFFFFF + (n18 << 24));
            }
            if (this.d.o == null) {
                this.renderTablist(fontRenderer, n2, n3, Keyboard.isKeyDown((int)this.d.w.keyBindPlayerList.b));
            }
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
            GL11.glEnable((int)3008);
            GL11.glDisable((int)3042);
        }
        if (this.recordPlayingUpFor > 0) {
            f2 = (float)this.recordPlayingUpFor - f;
            int n21 = (int)(f2 * 256.0f / 10.0f);
            if (n21 > 255) {
                n21 = 255;
            }
            if (n21 > 8) {
                GL11.glPushMatrix();
                GL11.glTranslatef((float)(n2 / 2), (float)(n3 - 48), (float)0.0f);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                n = 0xFFFFFF;
                if (this.colored) {
                    n = Color.HSBtoRGB(f2 / 50.0f, 0.7f, 0.6f) & 0xFFFFFF;
                }
                fontRenderer.a(this.recordPlaying, -fontRenderer.a(this.recordPlaying) / 2, -4, n + (n21 << 24));
                GL11.glDisable((int)3042);
                GL11.glPopMatrix();
            }
        }
    }

    private void renderPortalOverlay(float f, int n, int n2) {
        if (f < 1.0f) {
            f *= f;
            f *= f;
            f = f * 0.8f + 0.2f;
        }
        GL11.glDisable((int)3008);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)f);
        GL11.glBindTexture((int)3553, (int)this.d.m.a("/terrain.png"));
        float f2 = (float)((Block.portal.as + this.meta) % 32) / 32.0f;
        float f3 = (float)((Block.portal.as + this.meta) / 32) / 32.0f;
        float f4 = (float)((Block.portal.as + this.meta) % 32 + 1) / 32.0f;
        float f5 = (float)((Block.portal.as + this.meta) / 32 + 1) / 32.0f;
        net.minecraft.client.a.C_d c_d = net.minecraft.client.a.C_d.a;
        c_d.b();
        c_d.a(0.0f, n2, -90.0f, f2, f5);
        c_d.a(n, n2, -90.0f, f4, f5);
        c_d.a(n, 0.0f, -90.0f, f4, f3);
        c_d.a(0.0f, 0.0f, -90.0f, f2, f3);
        c_d.a();
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3008);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    private void renderTint(float f, int n, int n2, float f2, float f3, float f4) {
        GL11.glEnable((int)3042);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4f((float)f2, (float)f3, (float)f4, (float)f);
        GL11.glBindTexture((int)3553, (int)this.d.m.a("/misc/tint.png"));
        net.minecraft.client.a.C_d c_d = net.minecraft.client.a.C_d.a;
        c_d.b();
        c_d.a(0.0f, n2, -90.0f, 0.0f, 1.0f);
        c_d.a(n, n2, -90.0f, 1.0f, 1.0f);
        c_d.a(n, 0.0f, -90.0f, 1.0f, 0.0f);
        c_d.a(0.0f, 0.0f, -90.0f, 0.0f, 0.0f);
        c_d.a();
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2929);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)3042);
    }

    private void renderVignette(float f, int n, int n2) {
        if ((f = 1.0f - f) < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.prevVignetteBrightness = (float)((double)this.prevVignetteBrightness + (double)(f - this.prevVignetteBrightness) * 0.01);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glBlendFunc((int)0, (int)769);
        GL11.glColor4f((float)this.prevVignetteBrightness, (float)this.prevVignetteBrightness, (float)this.prevVignetteBrightness, (float)1.0f);
        GL11.glBindTexture((int)3553, (int)this.d.m.a("/misc/vignette.png"));
        net.minecraft.client.a.C_d c_d = net.minecraft.client.a.C_d.a;
        c_d.b();
        c_d.a(0.0f, n2, -90.0f, 0.0f, 1.0f);
        c_d.a(n, n2, -90.0f, 1.0f, 1.0f);
        c_d.a(n, 0.0f, -90.0f, 1.0f, 0.0f);
        c_d.a(0.0f, 0.0f, -90.0f, 0.0f, 0.0f);
        c_d.a();
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2929);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glBlendFunc((int)770, (int)771);
    }

    private void renderTablist(FontRenderer fontRenderer, int n, int n2, boolean bl) {
        if (this.d.f instanceof C_d && bl) {
            int n3;
            GL11.glTranslatef((float)0.0f, (float)(-n2 / 2 - 64), (float)0.0f);
            NetClientHandler netClientHandler = ((C_d)this.d.f).sendQueue;
            List<GuiPlayerInfo> list = netClientHandler.playerNames;
            String string = netClientHandler.serverName;
            int n4 = n3 = netClientHandler.currentServerMaxPlayers;
            int n5 = 1;
            while (n4 > 20) {
                n4 = (n3 + ++n5 - 1) / n5;
            }
            int n6 = 300 / n5;
            if (n6 > 150) {
                n6 = 150;
            }
            int n7 = (n - n5 * n6) / 2;
            int n8 = 10;
            C_l.a(n7 - 10, n8 - 1, n7 + n6 * n5 + 10, n8 + 9 * list.size() + 12, Integer.MIN_VALUE);
            for (int i = 0; i < list.size(); ++i) {
                int n9 = n7 + i % n5 * n6;
                int n10 = n8 + i / n5 * 9;
                C_l.a(n9, n10, n9 + n6 - 1, n10 + 8, Integer.MIN_VALUE);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glEnable((int)3008);
                if (i >= list.size()) continue;
                GuiPlayerInfo guiPlayerInfo = list.get(i);
                fontRenderer.a(guiPlayerInfo.name, n9 + 1, n10, 0xFFFFFF);
                String string2 = "\u00a7e" + guiPlayerInfo.score;
                C_l.b(fontRenderer, string2, n9 + n6 - fontRenderer.a(string2) - 1 - 12, n10, 0xFFFFFF);
                RenderEngine.a(this.d.m.a("/gui/icons.png"));
                int n11 = 0;
                int n12 = guiPlayerInfo.responseTime < 0 ? 5 : (guiPlayerInfo.responseTime < 150 ? 0 : (guiPlayerInfo.responseTime < 300 ? 1 : (guiPlayerInfo.responseTime < 600 ? 2 : (guiPlayerInfo.responseTime < 1000 ? 3 : 4))));
                this.h += 100.0f;
                this.b(n9 + n6 - 12, n10, 0 + n11 * 10, 31 + n12 * 8, 10, 8);
                this.h -= 100.0f;
                fontRenderer.a(string, n / 2 - fontRenderer.a(string) / 2, n8 + 9 * list.size() + 2, 0xBBBBBB);
            }
        }
    }

    private void renderBlockOverlay(int n, int n2) {
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glBlendFunc((int)0, (int)769);
        GL11.glColor4f((float)0.5f, (float)0.5f, (float)0.5f, (float)1.0f);
        GL11.glBindTexture((int)3553, (int)this.d.m.a("/sand.png"));
        net.minecraft.client.a.C_d c_d = net.minecraft.client.a.C_d.a;
        c_d.b();
        c_d.a(0.0f, n2, -90.0f, 0.0f, 1.0f);
        c_d.a(n, n2, -90.0f, 1.0f, 1.0f);
        c_d.a(n, 0.0f, -90.0f, 1.0f, 0.0f);
        c_d.a(0.0f, 0.0f, -90.0f, 0.0f, 0.0f);
        c_d.a();
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2929);
        GL11.glColor4f((float)0.5f, (float)0.5f, (float)0.5f, (float)1.0f);
        GL11.glBlendFunc((int)770, (int)771);
    }

    public final void addChatMessage(String string) {
        this.b.add(0, new C_k(string));
        for (int i = 0; i < this.b.size(); ++i) {
            ++this.b.get((int)i).time;
        }
    }

    public final void tick() {
        ++this.e;
        if (this.recordPlayingUpFor > 0) {
            --this.recordPlayingUpFor;
        }
    }

    public void setRecordPlayingMessage(String string) {
        this.recordPlaying = "Now playing: " + string;
        this.recordPlayingUpFor = 60;
        this.colored = true;
    }
}

