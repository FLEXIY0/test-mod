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
import net.minecraft.a.b.a.C_f;
import net.minecraft.client.C_c;
import net.minecraft.client.CharacterLoader;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.a.a.C_i;
import net.minecraft.client.c.C_an;
import net.minecraft.client.c.C_bg;
import net.minecraft.client.c.C_bk;
import net.minecraft.client.c.ChatAllowedCharacters;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.c.ScaledResolution;
import net.minecraft.client.g.C_a;
import net.minecraft.client.statistics.StatFileWriter;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class C_ap
extends GuiScreen {
    private String name = "";
    private String skinID = "";
    private int id = 0;
    private int gamemode = 0;
    private int score = 0;
    private int difficulty = 0;
    private int counter = 0;
    private boolean cheats;
    private boolean keepInventory;
    private boolean hardcoreEnabled;
    private boolean canLoadImageFile = true;
    private CharacterLoader character;
    private C_a player;
    private C_bg parent;
    private static final String[] DIFFICULTIES = new String[]{"Peaceful", "Easy", "Normal", "Hard"};

    public C_ap(C_bg c_bg, CharacterLoader characterLoader, int n) {
        this.character = characterLoader;
        this.id = n;
        this.parent = c_bg;
        try {
            NBTTagCompound nBTTagCompound;
            this.character.currentCharacter = nBTTagCompound = this.character.readCharacter(n);
            if (nBTTagCompound != null) {
                this.name = nBTTagCompound.g("Name");
                this.skinID = nBTTagCompound.g("Skin");
                this.gamemode = nBTTagCompound.c("Gamemode");
                this.score = nBTTagCompound.d("Score");
                this.difficulty = nBTTagCompound.c("Difficulty");
                this.cheats = nBTTagCompound.k("Cheats");
                this.keepInventory = nBTTagCompound.k("KeepInventory");
                this.hardcoreEnabled = nBTTagCompound.k("Hardcore");
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public final void b() {
        this.e.clear();
        Keyboard.enableRepeatEvents((boolean)true);
        this.e.add(new GuiButton(0, this.c / 2 - 103, this.d / 4 + 144, 100, 20, "Save"));
        this.e.add(new GuiButton(2, this.c / 2 + 2, this.d / 4 + 144, 100, 20, "Cancel"));
        this.e.add(new C_bk(1, this.c / 2 + 34, this.d / 4 + 5));
        this.player = new C_a(this.b, null, this.b.h);
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
        ((GuiButton)this.e.get((int)0)).c = this.name.length() >= 2;
    }

    @Override
    protected final void a(GuiButton guiButton) {
        if (guiButton.c) {
            Object object;
            if (guiButton.b == 0) {
                object = this.character.currentCharacter;
                if (object != null) {
                    ((NBTTagCompound)object).a("Name", this.name);
                    ((NBTTagCompound)object).a("Skin", this.skinID);
                }
                try {
                    this.b.w.character = this.id;
                    this.character.saveCharacter(this.id, (NBTTagCompound)object);
                    this.b.statFileWriter = new StatFileWriter(this.b.characters, this.b.z, this.b.h);
                    C_f.clearRecipes();
                    C_f.addUnlockedRecipes();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                this.b.a(this.parent);
            }
            if (guiButton.b == 1) {
                object = new C_an(this, this);
                ((Thread)object).setDaemon(true);
                SwingUtilities.invokeLater((Runnable)object);
            }
            if (guiButton.b == 2) {
                this.b.w.character = this.id;
                this.b.statFileWriter = new StatFileWriter(this.b.characters, this.b.z, this.b.h);
                C_f.clearRecipes();
                C_f.addUnlockedRecipes();
                this.b.a(this.parent);
            }
        }
    }

    @Override
    protected final void a(char c, int n) {
        if (n == 14 && this.name.length() > 0) {
            this.name = this.name.substring(0, this.name.length() - 1);
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
        int n4 = this.d / 4 + 55;
        C_ap.a(n3 - 1, n4 - 1, n3 + 200 + 1, n4 + 20 + 1, -6250336);
        C_ap.a(n3, n4, n3 + 200, n4 + 20, -16777216);
        C_ap.b(this.g, this.name + (this.counter / 6 % 2 == 0 ? "_" : ""), n3 + 4, n4 + 6, 0xE0E0E0);
        C_ap.a(this.g, "Name", this.c / 2, n4 - 20, 0xE0E0E0);
        C_ap.a(this.g, "Score: \u00a7e" + this.score, this.c / 2, n4 + 48, 0xE0E0E0);
        C_ap.a(this.g, "Difficulty: \u00a7e" + DIFFICULTIES[this.difficulty] + '\u00a7' + "f, Cheats: " + (this.cheats ? "\u00a7eOn" : "\u00a7cOff") + '\u00a7' + "f, Keep Inventory: " + '\u00a7' + "e" + (this.keepInventory ? "\u00a7eOn" : "\u00a7cOff"), this.c / 2, n4 + 68, 0xE0E0E0);
        if (!this.canLoadImageFile) {
            C_ap.a(this.g, "\u00a7cIncorrect file format or size. Please use a 64x32 PNG image.", this.c / 2, this.d - 20, 0xFFFFFF);
        }
        this.drawHealth();
        this.drawPlayerBox(n, n2);
        super.a(n, n2, f);
    }

    private void drawHealth() {
        if (this.gamemode == 0) {
            boolean bl;
            ScaledResolution scaledResolution = new ScaledResolution(this.b.w, this.b.b, this.b.c);
            int n = scaledResolution.a();
            int n2 = scaledResolution.b() / 4;
            int n3 = this.player.W;
            int n4 = 0;
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glBindTexture((int)3553, (int)this.b.m.a("/gui/icons.png"));
            boolean bl2 = bl = this.player.L / 3 % 2 == 1;
            if (this.player.L < 10) {
                bl = false;
            }
            n4 = this.hardcoreEnabled ? 9 : 0;
            int n5 = this.player.b.e();
            for (int i = 0; i < 10; ++i) {
                int n6 = n2 + 84;
                int n7 = n / 2 - 41 + (i << 3);
                if (n5 > 0) {
                    int n8 = n / 2 + 91 - (i << 3) - 9;
                    n7 = n / 2 - 91 + (i << 3);
                    if ((i << 1) + 1 < n5) {
                        this.b(n8, n6, 34, 9, 9, 9);
                    }
                    if ((i << 1) + 1 == n5) {
                        this.b(n8, n6, 25, 9, 9, 9);
                    }
                    if ((i << 1) + 1 > n5) {
                        this.b(n8, n6, 16, 9, 9, 9);
                    }
                }
                int n9 = 0;
                if (bl) {
                    n9 = 1;
                }
                this.b(n7, n6, 16 + n9 * 9, 0, 9, 9);
                if ((i << 1) + 1 < n3) {
                    this.b(n7, n6, 52, 0 + n4, 9, 9);
                }
                if ((i << 1) + 1 != n3) continue;
                this.b(n7, n6, 61, 0 + n4, 9, 9);
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
        C_a c_a = this.player;
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

    static /* synthetic */ int access$000(C_ap c_ap) {
        return c_ap.id;
    }

    static /* synthetic */ boolean access$102(C_ap c_ap, boolean bl) {
        c_ap.canLoadImageFile = bl;
        return c_ap.canLoadImageFile;
    }

    static /* synthetic */ String access$202(C_ap c_ap, String string) {
        c_ap.skinID = string;
        return c_ap.skinID;
    }

    static /* synthetic */ CharacterLoader access$300(C_ap c_ap) {
        return c_ap.character;
    }

    static /* synthetic */ String access$200(C_ap c_ap) {
        return c_ap.skinID;
    }

    static /* synthetic */ C_a access$402(C_ap c_ap, C_a c_a) {
        c_ap.player = c_a;
        return c_ap.player;
    }

    static /* synthetic */ C_a access$400(C_ap c_ap) {
        return c_ap.player;
    }
}

