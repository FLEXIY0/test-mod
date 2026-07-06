/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import com.a.a.NBTTagCompound;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.SwingUtilities;
import net.minecraft.a.b.a.CraftingManager;
import net.minecraft.client.C_c;
import net.minecraft.client.CharacterLoader;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.a.a.C_i;
import net.minecraft.client.c.C_bb;
import net.minecraft.client.c.C_bk;
import net.minecraft.client.c.ChatAllowedCharacters;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiMainMenu;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.c.ScaledResolution;
import net.minecraft.client.g.EntityPlayerSP;
import net.minecraft.client.statistics.StatFileWriter;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class C_bd
extends GuiScreen {
    private String name = "";
    public String skinID = "";
    private int gamemode = 0;
    private int difficulty = 0;
    private int id = 0;
    private boolean keepInventory = false;
    private boolean cheats = false;
    private boolean hardcoreEnabled = false;
    private boolean canLoadImageFile = true;
    private int counter = 0;
    private static final String[] GAMEMODE = new String[]{"Survival", "Creative", "Hardcore"};
    private static final String[] DIFFICULTIES = new String[]{"Peaceful", "Easy", "Normal", "Hard"};
    private CharacterLoader character;
    EntityPlayerSP player;

    public C_bd(CharacterLoader characterLoader, int n) {
        this.character = characterLoader;
        this.id = n;
        NBTTagCompound nBTTagCompound = characterLoader.currentCharacter;
        if (nBTTagCompound != null) {
            this.name = nBTTagCompound.g("Name");
            this.skinID = nBTTagCompound.g("Skin");
            this.cheats = nBTTagCompound.k("Cheats");
            this.keepInventory = nBTTagCompound.k("KeepInventory");
            this.gamemode = nBTTagCompound.c("Gamemode");
            this.difficulty = nBTTagCompound.c("Difficulty");
        }
    }

    @Override
    public final void b() {
        this.e.clear();
        Keyboard.enableRepeatEvents((boolean)true);
        this.e.add(new GuiButton(1, this.c / 2 + 5, this.d / 4 + 72 + 24, 150, 20, this.getSetting(1)));
        this.e.add(new GuiButton(2, this.c / 2 - 150, this.d / 4 + 72 + 24, 150, 20, this.getSetting(2)));
        this.e.add(new GuiButton(3, this.c / 2 - 150, this.d / 4 + 96 + 24, 150, 20, this.getSetting(3)));
        this.e.add(new GuiButton(4, this.c / 2 + 5, this.d / 4 + 96 + 24, 150, 20, this.getSetting(4)));
        this.e.add(new C_bk(5, this.c / 2 + 34, this.d / 4 + 5));
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 144 + 12, "Create character"));
        this.player = new EntityPlayerSP(this.b, null, this.b.h);
        if (this.character.currentCharacter != null) {
            this.player.d(this.character.currentCharacter);
        }
    }

    @Override
    public final void a() {
        super.a();
        Keyboard.enableRepeatEvents((boolean)false);
    }

    @Override
    public final void f_() {
        ++this.counter;
        ((GuiButton)this.e.get((int)5)).c = this.name.length() >= 2;
    }

    @Override
    protected final void a(GuiButton guiButton) {
        if (guiButton.c) {
            Object object;
            if (guiButton.b == 0) {
                object = this.character.currentCharacter;
                if (this.gamemode == 2) {
                    this.gamemode = 0;
                }
                if (object != null) {
                    ((NBTTagCompound)object).a("Name", this.name);
                    ((NBTTagCompound)object).a("Skin", this.skinID);
                    ((NBTTagCompound)object).a("Cheats", this.cheats);
                    ((NBTTagCompound)object).a("KeepInventory", this.keepInventory);
                    ((NBTTagCompound)object).a("Hardcore", this.hardcoreEnabled);
                    ((NBTTagCompound)object).a("Gamemode", (short)this.gamemode);
                    ((NBTTagCompound)object).a("Difficulty", (short)this.difficulty);
                }
                try {
                    this.character.saveCharacter(this.id, (NBTTagCompound)object);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                this.b.characters = this.character;
                this.b.w.character = this.id;
                this.b.w.a();
                this.b.statFileWriter = new StatFileWriter(this.b.characters, this.b.z, this.b.h);
                this.b.a(new GuiMainMenu());
                CraftingManager.clearRecipes();
                CraftingManager.addUnlockedRecipes();
            }
            if (guiButton.b == 1) {
                this.keepInventory = !this.keepInventory;
                guiButton.a = this.getSetting(guiButton.b);
            }
            if (guiButton.b == 2) {
                this.cheats = !this.cheats;
                guiButton.a = this.getSetting(guiButton.b);
            }
            if (guiButton.b == 3) {
                this.gamemode = (this.gamemode + 1) % GAMEMODE.length;
                guiButton.a = this.getSetting(guiButton.b);
                if (this.gamemode == 1) {
                    this.cheats = true;
                    ((GuiButton)this.e.get((int)1)).a = this.getSetting(2);
                } else if (this.gamemode == 2) {
                    ((GuiButton)this.e.get((int)0)).c = false;
                    ((GuiButton)this.e.get((int)1)).c = false;
                    ((GuiButton)this.e.get((int)3)).c = false;
                    this.difficulty = 3;
                    this.cheats = false;
                    this.keepInventory = false;
                    this.hardcoreEnabled = true;
                    ((GuiButton)this.e.get((int)0)).a = this.getSetting(1);
                    ((GuiButton)this.e.get((int)1)).a = this.getSetting(2);
                    ((GuiButton)this.e.get((int)3)).a = this.getSetting(4);
                } else {
                    ((GuiButton)this.e.get((int)0)).c = true;
                    ((GuiButton)this.e.get((int)1)).c = true;
                    ((GuiButton)this.e.get((int)3)).c = true;
                    this.hardcoreEnabled = false;
                }
            }
            if (guiButton.b == 4) {
                this.difficulty = (this.difficulty + 1) % DIFFICULTIES.length;
                guiButton.a = this.getSetting(guiButton.b);
            }
            if (guiButton.b == 5) {
                object = new C_bb(this, this);
                ((Thread)object).setDaemon(true);
                SwingUtilities.invokeLater((Runnable)object);
            }
        }
    }

    public final String getSetting(int n) {
        return n == 1 ? "Keep Inventory: " + (this.keepInventory ? "On" : "Off") : (n == 2 ? "Cheats: " + (this.cheats ? "On" : "Off") : (n == 3 ? "Gamemode: " + GAMEMODE[this.gamemode] : (n == 4 ? "Difficulty: " + DIFFICULTIES[this.difficulty] : "")));
    }

    @Override
    protected final void a(char c, int n) {
        if (n == 14 && this.name.length() > 0) {
            this.name = this.name.substring(0, this.name.length() - 1);
        }
        if (n == 1) {
            // empty if block
        }
        if (n == 28) {
            // empty if block
        }
        if (c == '\u0016') {
            int n2;
            String string = GuiScreen.getClipboardString();
            if (string == null) {
                string = "";
            }
            if ((n2 = 32 - this.name.length()) > string.length()) {
                n2 = string.length();
            }
            if (n2 > 0) {
                this.name = this.name + string.substring(0, n2);
            }
        }
        if (ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(c) >= 0 && this.name.length() < 16 && this.g.a(this.name) < 192) {
            this.name = this.name + c;
        }
    }

    @Override
    public final void a(int n, int n2, float f) {
        this.h();
        int n3 = this.c / 2 - 100;
        int n4 = this.d / 4 + 35;
        C_bd.a(n3 - 1, n4 - 1, n3 + 200 + 1, n4 + 20 + 1, -6250336);
        C_bd.a(n3, n4, n3 + 200, n4 + 20, -16777216);
        C_bd.b(this.g, this.name + (this.counter / 6 % 2 == 0 ? "_" : ""), n3 + 4, n4 + 6, 0xE0E0E0);
        C_bd.a(this.g, "\u00a7eWarning: \u00a7fThese options can only be set once!", this.c / 2, this.d / 4 + 82, 0xFFFFFF);
        if (!this.canLoadImageFile) {
            C_bd.a(this.g, "\u00a7cIncorrect file format or size. Please use a 64x32 PNG image.", this.c / 2, this.d - 10, 0xFFFFFF);
        }
        this.drawHealth();
        this.drawPlayerBox(n, n2);
        super.a(n, n2, f);
    }

    private void drawHealth() {
        if (this.gamemode != 1) {
            int n;
            int n2;
            int n3;
            int n4;
            boolean bl;
            boolean bl2;
            ScaledResolution scaledResolution = new ScaledResolution(this.b.w, this.b.b, this.b.c);
            int n5 = scaledResolution.a();
            int n6 = scaledResolution.b() / 4;
            int n7 = this.player.W;
            int n8 = 0;
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glBindTexture((int)3553, (int)this.b.m.a("/gui/icons.png"));
            boolean bl3 = bl2 = this.player.L / 3 % 2 == 1;
            if (this.player.L < 10) {
                bl2 = false;
            }
            boolean bl4 = bl = this.player.L / 3 % 2 == 1;
            if (this.player.L < 2) {
                bl = false;
            }
            n8 = this.hardcoreEnabled ? 9 : 0;
            int n9 = this.player.b.e();
            for (n4 = 0; n4 < 10; ++n4) {
                n3 = n6 + 64;
                n2 = n5 / 2 - 41 + (n4 << 3);
                if (n9 > 0) {
                    int n10 = n5 / 2 + 91 - (n4 << 3) - 9;
                    n2 = n5 / 2 - 91 + (n4 << 3);
                    if ((n4 << 1) + 1 < n9) {
                        this.b(n10, n3, 34, 9, 9, 9);
                    }
                    if ((n4 << 1) + 1 == n9) {
                        this.b(n10, n3, 25, 9, 9, 9);
                    }
                    if ((n4 << 1) + 1 > n9) {
                        this.b(n10, n3, 16, 9, 9, 9);
                    }
                }
                n = 0;
                if (bl2) {
                    n = 1;
                }
                this.b(n2, n3, 16 + n * 9, 0, 9, 9);
                if ((n4 << 1) + 1 < n7) {
                    this.b(n2, n3, 52, 0 + n8, 9, 9);
                }
                if ((n4 << 1) + 1 != n7) continue;
                this.b(n2, n3, 61, 0 + n8, 9, 9);
            }
            if (n7 > 20) {
                for (n4 = 0; n4 < 10; ++n4) {
                    n3 = n6 - 32;
                    n2 = 0;
                    if (bl) {
                        n2 = 1;
                    }
                    n = n5 / 2 - 91 + (n4 << 3);
                    if ((n4 << 1) + 1 < n7 - 20) {
                        this.b(n, n3 - 10, 16 + n2 * 9, 0, 9, 9);
                        this.b(n - 1, n3 - 10, 87, 0, 9, 9);
                    }
                    if ((n4 << 1) + 1 != n7 - 20) continue;
                    this.b(n, n3 - 10, 16 + n2 * 9, 0, 9, 9);
                    this.b(n - 1, n3 - 10, 96, 0, 9, 9);
                }
            }
        }
    }

    private void drawPlayerBox(int n, int n2) {
        RenderEngine.a(this.b.m.a("/gui/inventory.png"));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int n3 = this.c / 2 - 35;
        int n4 = this.d / 4 - 60;
        this.b(n3 + 7, n4 + 7, 25, 7, 54, 72);
        this.b(n3 + 0, n4 + 0, 0, 0, 7, 79);
        this.b(n3 + 7, n4 + 0, 25, 0, 54, 7);
        this.b(n3 + 0, n4 + 79, 0, 159, 61, 7);
        this.b(n3 + 61, n4 + 0, 169, 0, 7, 79);
        this.b(n3 + 61, n4 + 79, 169, 159, 7, 7);
        EntityPlayerSP c_a = this.player;
        int n5 = 33;
        int n6 = 75;
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)2977);
        GL11.glEnable((int)2903);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(n5 + n3), (float)(n6 + n4), (float)50.0f);
        GL11.glScalef((float)-30.0f, (float)30.0f, (float)30.0f);
        GL11.glRotatef((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        float f = (float)(n5 + n3) - (float)n;
        float f2 = (float)(n6 + n4 - 50) - (float)n2;
        GL11.glRotatef((float)135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        C_c.b();
        GL11.glRotatef((float)-135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-((float)Math.atan(f2 / 40.0f)) * 20.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        c_a.T = (float)Math.atan(f / 40.0f) * 20.0f;
        c_a.n = (float)Math.atan(f / 40.0f) * 40.0f;
        c_a.o = -((float)Math.atan(f2 / 40.0f)) * 20.0f;
        GL11.glTranslatef((float)0.0f, (float)c_a.v, (float)0.0f);
        C_i.a.a(c_a, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glPopMatrix();
        C_c.a();
        GL11.glDisable((int)2977);
    }

    public void copyDirectory(File file, File file2) throws IOException {
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            String[] stringArray = file.list();
            for (int i = 0; i < stringArray.length; ++i) {
                this.copyDirectory(new File(file, stringArray[i]), new File(file2, stringArray[i]));
            }
        } else {
            int n;
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] byArray = new byte[1024];
            while ((n = ((InputStream)fileInputStream).read(byArray)) > 0) {
                ((OutputStream)fileOutputStream).write(byArray, 0, n);
            }
            ((InputStream)fileInputStream).close();
            ((OutputStream)fileOutputStream).close();
        }
    }

    static /* synthetic */ int access$000(C_bd c_bd) {
        return c_bd.id;
    }

    static /* synthetic */ boolean access$102(C_bd c_bd, boolean bl) {
        c_bd.canLoadImageFile = bl;
        return c_bd.canLoadImageFile;
    }

    static /* synthetic */ CharacterLoader access$200(C_bd c_bd) {
        return c_bd.character;
    }
}

