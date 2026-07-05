/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.GLU
 */
package net.minecraft.client.c;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;
import net.minecraft.a.a.LevelOptions;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.c.C_b;
import net.minecraft.client.C_c;
import net.minecraft.client.Lang;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.C_f;
import net.minecraft.client.a.C_m;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.a.a.C_i;
import net.minecraft.client.c.C_am;
import net.minecraft.client.c.C_ba;
import net.minecraft.client.c.C_bg;
import net.minecraft.client.c.C_bj;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiCredits;
import net.minecraft.client.c.GuiOptions;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.c.ScaledResolution;
import net.minecraft.client.g.C_a;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import util.MathHelper;

public final class GuiMainMenu
extends GuiScreen {
    private String[] splashes = new String[]{"Pre-beta!", "As seen on TV!", "Awesome!", "100% pure!", "May contain nuts!", "Better than Prey!", "More polygons!", "Sexy!", "Limited edition!", "Flashing letters!", "Made by Notch!", "Coming soon!", "Best in class!", "When it's finished!", "Absolutely dragon free!", "Excitement!", "More than 5000 sold!", "One of a kind!", "700+ hits on YouTube!", "Indev!", "Spiders everywhere!", "Check it out!", "Holy cow, man!", "It's a game!", "Made in Sweden!", "Uses LWJGL!", "Reticulating splines!", "Minecraft!", "Yaaay!", "Alpha version!", "Singleplayer!", "Keyboard compatible!", "Undocumented!", "Ingots!", "Exploding creepers!", "That's not a moon!", "l33t!", "Create!", "Survive!", "Dungeon!", "Exclusive!", "The bee's knees!", "Down with O.P.P.!", "Closed source!", "Classy!", "Wow!", "Not on steam!", "9.95 euro!", "Half price!", "Oh man!", "Check it out!", "Awesome community!", "Pixels!", "Teetsuuuuoooo!", "Kaaneeeedaaaa!", "Now with difficulty!", "Enhanced!", "90% bug free!", "Pretty!", "12 herbs and spices!", "Fat free!", "Absolutely no memes!", "Free dental!", "Ask your doctor!", "Minors welcome!", "Cloud computing!", "Legal in Finland!", "Hard to label!", "Technically good!", "Bringing home the bacon!", "Indie!", "GOTY!", "Ceci n'est pas une title screen!", "Euclidian!", "Now in 3D!", "Inspirational!", "Herregud!", "Complex cellular automata!", "Yes, sir!", "Played by cowboys!", "OpenGL 1.1!", "Thousands of colors!", "Try it!", "Age of Wonders is better!", "Try the mushroom stew!", "Sensational!", "Hot tamale, hot hot tamale!", "Play him off, keyboard cat!", "Guaranteed!", "Macroscopic!", "Bring it on!", "Random splash!", "Call your mother!", "Monster infighting!", "Loved by millions!", "Ultimate edition!", "Freaky!", "You've got a brand new key!", "Water proof!", "Uninflammable!", "Whoa, dude!", "All inclusive!", "Tell your friends!", "NP is not in P!", "Notch <3 Ez!", "Music by C418!", "Music by Soybean_56!", "Made by method!", "Also try Classic+!", "Also try Infdev+!", "Woo, Omniarchive!", "Real!", "Shoots and Ladders!", "Worship Felutia!", "Made by method!", "Woo, slabs!", "Multiplying ducks!", "Beware of the light...", "Also try ReIndev!", "Also try NSSS!", "Also try NFC!", "Also try BTA!", "Also try Super Meat Boy!", "Also try Binding of Isaac!", "Also try Spelunky!", "Also try Plants VS Zombies!", "Also try VVVVVV!", "Also try Terraria!", "Also try Project Zomboid!", "Also try Limbo!", "Also try World of Goo!", "Also try Lost in Vivo!", "Also try Iron Lung!", "Blood Moons!", "Follow that train, CJ!", "Finite water!", "Snake? Snake!? SNAAAAAKEEEEE!!", "It's super effective!", "It's very easy!", "Praise the Builder!", "L is real 2401!", "Thy Flesh Consumed!", "Also try Through the Fragmentation!", "Also try The Long Drive!", "Slick!", "Awesomesauce!", "Also try World of Padman!", "It's not a lake, it's an ocean!", "May contain giants!", "Gotta go fast!", "...", "Minceraft!", "FUS-ROH-DAAAAH!", "Inside at last!", "Totally Tubular!", "Radical!", "Stay in school!", "Batteries not included!", "Wash your hands!", "Don't forget to take a bathroom break!", "MISSINGNO", "An offer you can't refuse!", "Pills here!", "The cake is a lie!", "Fatality!", "Up Up Down Down Left Right Left Right B A START!", "What a terrible night to have a curse!", "As seen on Modification Station!", "Now with commands!", "Also try Axiom Verge!", "Wooo, black metal!", "Wooo, death metal!", "In your face!", "Oooh, science-fictiony!", "Finger lickin' good!", "I'm lovin' it!", "Banaaaang!", "Better than vanilla!", "LEEEEROYYYY JENKIIIIINS!", "You shall not pass!", "Luke, I am your father!", "Tell your friends!", "Nanomachines, son!", "\u00a7cHardcore!", "Forget me not!", "Real!", "One block at a time!", "Never gonna give you up!", "We must go back, Marty!", "D: Hard", "Cesky vyrobek!", "Blackwater Park!", "Reformed orthodox rabbi Bill Clinton!", "Has antlions!", "Has foxes!", "This isn't even my final form!", "Sterile Nails and Thunderbowels!", "Fly me to the moon!", "Press F to pay respects!", "Press X to doubt!", "Now with more world types!", "Thy Light!", "Now with characters!", "Wooo, world hopping!", "java.lang.OutOfMemoryException", "What's up, doc?", "Also try McDiverge!", "Also try InfHell!", "Iconic arms!", "Le dernier adieu!", "I am the storm that is approaching!", "El Diablo de la Muerte!", "Check the bathroom, Joel!", "Dejavu!", "Powered by Enshine!", "NOT sponsored by Raid: Shadow Legends!", "I'm blue, da ba dee da ba da!", "Also try Slome!", "Also try Celeste!", "Hello, Mr. Wind-Up Bird!", "Zoinks!", "La Mort du Prince Noir!", "I'M A LEMON!!!", "Ey b0ss!", "7", "Do you like my car?", "Hmm, nice bike!", "Ah, ye good ole' days!", "The Deb of Night!", "Spider Pig, Spider Pig!", "Maxwell activated. Find Maxwell!", "Magic missile!", "Protective shield!", "No alien!", "No Marsianito!", "No Duende!", "Torch lighting simulator!", "Object event", "Bing chillin'!", "Also play Enderal!", "Also play Black Mesa!", "I wonder who put that there!", "Welcome to the Jank Zone!", "Woo, wheelchair music!", "Not on Android!", "Fridge compatible!", "You have mere seconds!", "MILLIONS TO ONE!!!", "People love blocks!", "You sir, are a fish!", "Why did I move here? I think it was the weather!", "Also try Voices of the Void!", "Also try Pizza Tower!", "Also try Cave Story!"};
    private String currentSplash = this.splashes[(int)(Math.random() * (double)this.splashes.length)];
    private static Random random = new Random();
    String[] minecraftLogo = new String[]{" *   * * *   * *** *** *** *** *** ***", " ** ** * **  * *   *   * * * * *    * ", " * * * * * * * **  *   **  *** **   * ", " *   * * *  ** *   *   * * * * *    * ", " *   * * *   * *** *** * * * * *    * "};
    String[] subtitle = new String[]{" * *   * **  *** * *    *  ", " * **  * * * *   * *    *  ", " * * * * * * *** * *  *****", " * *  ** * * *   * *    *  ", " * *   * **  ***  *     *  "};
    private C_m[][] logoEffects;
    private C_a player;
    private LevelOptions worldOptions;
    private int panoramaTimer = 0;

    @Override
    public final void f_() {
        if (this.logoEffects != null) {
            for (int i = 0; i < this.logoEffects.length; ++i) {
                for (int j = 0; j < this.logoEffects[i].length; ++j) {
                    this.logoEffects[i][j].updateLogoEffects();
                }
            }
        }
        ++this.player.H;
        ++this.panoramaTimer;
    }

    @Override
    protected final void a(char c, int n) {
    }

    @Override
    public final void b() {
        this.e.clear();
        this.e.add(new GuiButton(1, this.c / 2 - 100, this.d / 4 + 48, "Singleplayer"));
        this.e.add(new GuiButton(2, this.c / 2 - 100, this.d / 4 + 72, "Multiplayer"));
        this.e.add(new GuiButton(3, this.c / 2 - 100, this.d / 4 + 96, "I'm feeling lucky"));
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 120 + 12, 100, 20, "Options..."));
        this.e.add(new GuiButton(4, this.c / 2 + 4, this.d / 4 + 120 + 12, 97, 20, "Quit Game"));
        this.e.add(new GuiButton(7, this.c - 73, this.d / 3 + 83, 54, 20, "Switch..."));
        this.e.add(new C_am(5, this.c / 2 - 125, this.d / 4 + 120 + 12));
        this.worldOptions = new LevelOptions();
        this.player = new C_a(this.b, null, this.b.h);
        try {
            if (this.b.characters.currentCharacter != null) {
                this.player.d(this.b.characters.currentCharacter);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.player.name = "ERROR!";
        }
        this.b.e.a((C_b)this.player);
        C_i.a.cacheActiveRenderInfo(null, this.b.m, this.b.n, this.player, 0.0f);
        File file = new File(this.b.z, this.player.skinId);
        if (!file.exists()) {
            this.player.skinId = "";
            this.b.characters.currentCharacter.a("Skin", "");
            try {
                this.b.characters.saveCharacter(this.b.w.character, this.b.characters.currentCharacter);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        Object var4_4 = null;
        this.e.add(new GuiButton(100, 4, this.d - 24, 120, 20, Lang.label()));
    }

    @Override
    protected final void a(GuiButton guiButton) {
        if (guiButton.b == 100) {
            Lang.cycle();
            this.b.a(this);
            return;
        }
        if (guiButton.b == 0) {
            this.b.a(new GuiOptions(this.b.w));
        }
        if (guiButton.b == 1) {
            this.b.a(new C_bj(this));
        }
        if (guiButton.b == 2) {
            this.b.a(new C_ba(this));
        }
        if (guiButton.b == 3) {
            this.worldOptions.type = random.nextInt(10);
            this.worldOptions.theme = random.nextInt(5);
            this.worldOptions.seasons = random.nextInt(4);
            this.b.generateLevel(this.worldOptions, "Random Level");
            this.b.a((GuiScreen)null);
        }
        if (guiButton.b == 4) {
            this.b.a();
            System.exit(0);
        }
        if (guiButton.b == 5) {
            this.b.a(new GuiCredits(this));
        }
        if (guiButton.b == 7) {
            this.b.a(new C_bg(this));
        }
    }

    private void drawPanorama(int n, int n2, float f) {
        C_d c_d = C_d.a;
        GL11.glMatrixMode((int)5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GLU.gluPerspective((float)85.0f, (float)((float)this.c / (float)this.d), (float)0.05f, (float)10.0f);
        GL11.glMatrixMode((int)5888);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glDisable((int)2884);
        GL11.glRotatef((float)(MathHelper.a(((float)this.panoramaTimer + f) / 400.0f) * 25.0f + 20.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)(-((float)this.panoramaTimer + f) * 0.1f), (float)0.0f, (float)1.0f, (float)0.0f);
        for (int i = 0; i < 6; ++i) {
            GL11.glPushMatrix();
            if (i == 1) {
                GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            }
            if (i == 2) {
                GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            }
            if (i == 3) {
                GL11.glRotatef((float)-90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            }
            if (i == 4) {
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            }
            if (i == 5) {
                GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            }
            GL11.glBindTexture((int)3553, (int)this.b.m.a("/title/bg/panorama" + i + ".png"));
            c_d.b();
            c_d.a(-1.0f, -1.0f, 1.0f, 0.0f, 0.0f);
            c_d.a(1.0f, -1.0f, 1.0f, 1.0f, 0.0f);
            c_d.a(1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
            c_d.a(-1.0f, 1.0f, 1.0f, 0.0f, 1.0f);
            c_d.a();
            GL11.glPopMatrix();
        }
        c_d.setTranslation(0.0f, 0.0f, 0.0f);
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
        GL11.glMatrixMode((int)5889);
        GL11.glPopMatrix();
        GL11.glMatrixMode((int)5888);
        GL11.glPopMatrix();
        GL11.glEnable((int)2884);
    }

    private void drawLogo(float f) {
        int n;
        if (this.logoEffects == null) {
            this.logoEffects = new C_m[this.minecraftLogo[0].length()][this.minecraftLogo.length];
            for (int i = 0; i < this.logoEffects.length; ++i) {
                for (n = 0; n < this.logoEffects[i].length; ++n) {
                    this.logoEffects[i][n] = new C_m(this, i, n);
                }
            }
        }
        GL11.glMatrixMode((int)5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        ScaledResolution scaledResolution = new ScaledResolution(this.b.w, this.b.b, this.b.c);
        n = 120 * scaledResolution.scaleFactor;
        GLU.gluPerspective((float)70.0f, (float)((float)this.b.b / (float)n), (float)0.05f, (float)100.0f);
        GL11.glViewport((int)0, (int)(this.b.c - n), (int)this.b.b, (int)n);
        GL11.glMatrixMode((int)5888);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glDisable((int)2884);
        GL11.glCullFace((int)1029);
        GL11.glDepthMask((boolean)true);
        for (int i = 0; i < 3; ++i) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)0.4f, (float)0.6f, (float)-13.0f);
            if (i == 0) {
                GL11.glClear((int)256);
                GL11.glTranslatef((float)0.0f, (float)-0.4f, (float)0.0f);
                GL11.glScalef((float)0.98f, (float)1.0f, (float)1.0f);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
            }
            if (i == 1) {
                GL11.glDisable((int)3042);
                GL11.glClear((int)256);
            }
            if (i == 2) {
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)768, (int)1);
            }
            GL11.glScalef((float)1.0f, (float)-1.0f, (float)1.0f);
            GL11.glRotatef((float)15.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glScalef((float)0.89f, (float)1.0f, (float)0.4f);
            GL11.glTranslatef((float)((float)(-this.minecraftLogo[0].length()) * 0.5f), (float)((float)(-this.minecraftLogo.length) * 0.5f), (float)0.0f);
            GL11.glBindTexture((int)3553, (int)this.b.m.a("/terrain.png"));
            if (i == 0) {
                GL11.glBindTexture((int)3553, (int)this.b.m.a("/black.png"));
            }
            C_f c_f = new C_f();
            for (int j = 0; j < this.minecraftLogo.length; ++j) {
                for (int k = 0; k < this.minecraftLogo[j].length(); ++k) {
                    char c = this.minecraftLogo[j].charAt(k);
                    if (c == ' ') continue;
                    GL11.glPushMatrix();
                    C_m c_m = this.logoEffects[k][j];
                    float f2 = (float)(c_m.prevHeight + (c_m.height - c_m.prevHeight) * (double)f);
                    float f3 = 1.0f;
                    float f4 = 1.0f;
                    float f5 = 0.0f;
                    if (i == 0) {
                        f3 = f2 * 0.04f + 1.0f;
                        f4 = 1.0f / f3;
                        f2 = 0.0f;
                    }
                    GL11.glTranslatef((float)k, (float)j, (float)f2);
                    GL11.glScalef((float)f3, (float)f3, (float)f3);
                    GL11.glRotatef((float)f5, (float)0.0f, (float)1.0f, (float)0.0f);
                    if (i == 0) {
                        c_f.renderShadow(Block.i, f4);
                    } else {
                        c_f.renderBlocksForLogo(Block.i, f4);
                    }
                    GL11.glPopMatrix();
                }
            }
            GL11.glPopMatrix();
        }
        GL11.glDisable((int)3042);
        GL11.glMatrixMode((int)5889);
        GL11.glPopMatrix();
        GL11.glMatrixMode((int)5888);
        GL11.glPopMatrix();
        GL11.glViewport((int)0, (int)0, (int)this.b.b, (int)this.b.c);
        GL11.glEnable((int)2884);
    }

    private void drawSubtitle(float f) {
        int n;
        if (this.logoEffects == null) {
            this.logoEffects = new C_m[this.subtitle[0].length()][this.subtitle.length];
            for (int i = 0; i < this.logoEffects.length; ++i) {
                for (n = 0; n < this.logoEffects[i].length; ++n) {
                    this.logoEffects[i][n] = new C_m(this, i, n);
                }
            }
        }
        GL11.glMatrixMode((int)5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        ScaledResolution scaledResolution = new ScaledResolution(this.b.w, this.b.b, this.b.c);
        n = 120 * scaledResolution.scaleFactor;
        GLU.gluPerspective((float)70.0f, (float)((float)this.b.b / (float)n), (float)0.05f, (float)100.0f);
        GL11.glViewport((int)0, (int)(this.b.c - n), (int)this.b.b, (int)n);
        GL11.glMatrixMode((int)5888);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glDisable((int)2884);
        GL11.glCullFace((int)1029);
        GL11.glDepthMask((boolean)true);
        for (int i = 0; i < 3; ++i) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)0.4f, (float)0.6f, (float)-13.0f);
            if (i == 0) {
                GL11.glClear((int)256);
                GL11.glTranslatef((float)0.0f, (float)-0.4f, (float)0.0f);
                GL11.glScalef((float)0.98f, (float)1.0f, (float)1.0f);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
            }
            if (i == 1) {
                GL11.glDisable((int)3042);
                GL11.glClear((int)256);
            }
            if (i == 2) {
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)768, (int)1);
            }
            GL11.glScalef((float)0.5f, (float)-0.5f, (float)0.5f);
            GL11.glRotatef((float)15.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glScalef((float)0.89f, (float)1.0f, (float)0.4f);
            GL11.glTranslatef((float)((float)(-this.subtitle[0].length()) * 0.5f), (float)((float)(-this.subtitle.length) * 0.5f + 9.0f), (float)0.0f);
            GL11.glBindTexture((int)3553, (int)this.b.m.a("/terrain.png"));
            if (i == 0) {
                GL11.glBindTexture((int)3553, (int)this.b.m.a("/black.png"));
            }
            C_f c_f = new C_f();
            for (int j = 0; j < this.subtitle.length; ++j) {
                for (int k = 0; k < this.subtitle[j].length(); ++k) {
                    char c = this.subtitle[j].charAt(k);
                    if (c == ' ') continue;
                    GL11.glPushMatrix();
                    C_m c_m = this.logoEffects[k][j];
                    float f2 = (float)(c_m.prevHeight + (c_m.height - c_m.prevHeight) * (double)f);
                    float f3 = 1.0f;
                    float f4 = 1.0f;
                    float f5 = 0.0f;
                    if (i == 0) {
                        f3 = f2 * 0.04f + 1.0f;
                        f4 = 1.0f / f3;
                        f2 = 0.0f;
                    }
                    GL11.glTranslatef((float)k, (float)j, (float)f2);
                    GL11.glScalef((float)f3, (float)f3, (float)f3);
                    GL11.glRotatef((float)f5, (float)0.0f, (float)1.0f, (float)0.0f);
                    if (i == 0) {
                        c_f.renderShadow(Block.m, f4);
                    } else {
                        c_f.renderBlocksForLogo(Block.m, f4);
                    }
                    GL11.glPopMatrix();
                }
            }
            GL11.glPopMatrix();
        }
        GL11.glDisable((int)3042);
        GL11.glMatrixMode((int)5889);
        GL11.glPopMatrix();
        GL11.glMatrixMode((int)5888);
        GL11.glPopMatrix();
        GL11.glViewport((int)0, (int)0, (int)this.b.b, (int)this.b.c);
        GL11.glEnable((int)2884);
    }

    @Override
    public final void a(int n, int n2, float f) {
        int n3 = 0x808080;
        this.drawPanorama(n, n2, f);
        n3 = 0xFFFFFF;
        GuiMainMenu.drawGradientRect(0, 0, this.c, this.d, 0x60050500, -1607454656, 0.3f);
        this.drawLogo(f);
        this.drawSubtitle(f);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(this.c / 2 + 90), (float)70.0f, (float)0.0f);
        GL11.glRotatef((float)-20.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        float f2 = (1.8f - MathHelper.e(MathHelper.a((float)(System.currentTimeMillis() % 1000L) / 1000.0f * (float)Math.PI * 2.0f) * 0.1f)) * 100.0f / (float)(this.g.a(this.currentSplash) + 32);
        GL11.glScalef((float)f2, (float)f2, (float)f2);
        int n4 = Calendar.getInstance().get(1);
        LocalDate localDate = LocalDate.parse(n4 + "-12-25");
        LocalDate localDate2 = LocalDate.parse(n4 + "-12-24");
        LocalDate localDate3 = LocalDate.parse(n4 + "-01-01");
        LocalDate localDate4 = LocalDate.parse(n4 + "-10-31");
        LocalDate localDate5 = LocalDate.parse(n4 + "-07-04");
        LocalDate localDate6 = LocalDate.parse(n4 + "-09-07");
        LocalDate localDate7 = LocalDate.parse(n4 + "-05-04");
        LocalDate localDate8 = LocalDate.now();
        if (localDate.compareTo(localDate8) == 0 || localDate2.compareTo(localDate8) == 0) {
            this.currentSplash = "Merry Christmas!";
        } else if (localDate3.compareTo(localDate8) == 0) {
            this.currentSplash = "New year, new me!";
        } else if (localDate4.compareTo(localDate8) == 0) {
            this.currentSplash = "OooOOOoOO! Spooky!";
        } else if (localDate5.compareTo(localDate8) == 0) {
            this.currentSplash = "Wooo, freedom!";
        } else if (localDate6.compareTo(localDate8) == 0) {
            this.currentSplash = "Happy Birthday, Indev++!";
        } else if (localDate7.compareTo(localDate8) == 0) {
            this.currentSplash = "May the Fourth be with you!";
        }
        GuiMainMenu.a(this.g, this.currentSplash, 0, -8, 0xFFFF00);
        GL11.glPopMatrix();
        GuiMainMenu.b(this.g, "", this.c - this.g.a("") - 1, this.d - 10, n3);
        GuiMainMenu.b(this.g, "Sunset Edition", 2, this.d - 10, 0xFFFF55);
        this.drawHealth();
        this.drawPlayerBox(n, n2);
        super.a(n, n2, f);
    }

    public void drawHealth() {
        if (this.player.gamemode == 0) {
            boolean bl;
            ScaledResolution scaledResolution = new ScaledResolution(this.b.w, this.b.b, this.b.c);
            int n = scaledResolution.a();
            int n2 = scaledResolution.b();
            int n3 = this.player.W;
            int n4 = 0;
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glBindTexture((int)3553, (int)this.b.m.a("/gui/icons.png"));
            boolean bl2 = bl = this.player.L / 3 % 2 == 1;
            if (this.player.L < 10) {
                bl = false;
            }
            n4 = this.player.isHardcoreEnabled ? 9 : 0;
            int n5 = this.player.b.e();
            for (int i = 0; i < 10; ++i) {
                int n6;
                int n7 = n2 / 3 + 124;
                int n8 = n - 86 + (i << 3);
                if (n5 > 0) {
                    n6 = n2 / 3 + 134;
                    if ((i << 1) + 1 < n5) {
                        this.b(n8, n6, 34, 9, 9, 9);
                    }
                    if ((i << 1) + 1 == n5) {
                        this.b(n8, n6, 43, 9, 9, 9);
                    }
                    if ((i << 1) + 1 > n5) {
                        this.b(n8, n6, 16, 9, 9, 9);
                    }
                }
                n6 = 0;
                if (bl) {
                    n6 = 1;
                }
                this.b(n8, n7, 16 + n6 * 9, 0, 9, 9);
                if ((i << 1) + 1 < n3) {
                    this.b(n8, n7, 52, 0 + n4, 9, 9);
                }
                if ((i << 1) + 1 != n3) continue;
                this.b(n8, n7, 61, 0 + n4, 9, 9);
            }
        }
    }

    private void drawPlayerBox(int n, int n2) {
        RenderEngine.a(this.b.m.a("/gui/charcard.png"));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int n3 = this.c - 80;
        int n4 = this.d / 3;
        this.b(n3, n4, 0, 0, 68, 110);
        GuiMainMenu.a(this.g, this.player.name, n3 + 34, n4 - 10, 0xFFFFFF);
        GuiMainMenu.a(this.g, "\u00a7eScore: \u00a7f" + this.player.P, n3 + 34, n4 + 113, 0xFFFFFF);
        C_a c_a = this.player;
        int n5 = 33;
        int n6 = 75;
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
}

