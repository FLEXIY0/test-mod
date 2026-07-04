/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.Display
 */
package net.minecraft.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import net.minecraft.client.KeyBinding;
import net.minecraft.client.d;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public final class GameSettings {
    private static final String[] w = new String[]{"Far", "Normal", "Short", "Tiny"};
    private static final String[] guiScaleString = new String[]{"Auto", "Tiny", "Small", "Normal", "Large"};
    private static final String[] PARTICLES = new String[]{"All", "Minimal", "None"};
    private static final String[] CLOUDS = new String[]{"Fancy", "Fast", "None"};
    public boolean c = false;
    public boolean scrollInvert = false;
    public boolean d = false;
    public int e = 0;
    public boolean viewBobbing = true;
    public boolean h = false;
    public static boolean f = true;
    public boolean showHUD = true;
    public boolean sneakMode = true;
    public boolean stars = true;
    public boolean fancyParticles = true;
    public static boolean fancyItems = true;
    public static boolean fancyTextures = true;
    public static boolean armFlailing = false;
    public boolean showArm = true;
    public int particleCount = 0;
    public int cloudStyle = 0;
    public int character;
    public KeyBinding i = new KeyBinding("Forward", 17);
    public KeyBinding j = new KeyBinding("Left", 30);
    public KeyBinding k = new KeyBinding("Back", 31);
    public KeyBinding l = new KeyBinding("Right", 32);
    public KeyBinding m = new KeyBinding("Jump", 57);
    public KeyBinding n = new KeyBinding("Inventory", 18);
    public KeyBinding o = new KeyBinding("Drop", 16);
    public KeyBinding keyBindCrawl = new KeyBinding("Crawl", 29);
    public KeyBinding q = new KeyBinding("Save location", 28);
    public KeyBinding r = new KeyBinding("Load location", 19);
    public KeyBinding keyBindSneak = new KeyBinding("Sneak", 42);
    public KeyBinding keyBindZoom = new KeyBinding("Zoom", 44);
    public KeyBinding keyBindFlight = new KeyBinding("Flight", 46);
    public KeyBinding y = new KeyBinding("Chat", 20);
    public KeyBinding keyBindPause = new KeyBinding("Pause", 1);
    public KeyBinding keyBindHUD = new KeyBinding("Toggle HUD", 59);
    public KeyBinding keyBindScreenshot = new KeyBinding("Screenshot", 60);
    public KeyBinding keyBindDebug = new KeyBinding("Debug Mode", 61);
    public KeyBinding keyBindThirdPerson = new KeyBinding("Third Person", 63);
    public KeyBinding keyBindIso = new KeyBinding("Isometric Screenshot", 65);
    public KeyBinding keyBindFullScr = new KeyBinding("Toggle Fullscreen", 87);
    public KeyBinding keyBindPlayerList = new KeyBinding("Show Players", 15);
    public KeyBinding[] s = new KeyBinding[]{this.i, this.j, this.k, this.l, this.m, this.keyBindSneak, this.keyBindCrawl, this.keyBindFlight, this.n, this.o, this.q, this.r, this.keyBindZoom, this.y, this.keyBindPlayerList, this.keyBindPause, this.keyBindHUD, this.keyBindScreenshot, this.keyBindDebug, this.keyBindThirdPerson, this.keyBindIso, this.keyBindFullScr};
    private d z;
    private File A;
    public int t = 18;
    public int thirdPersonView = 0;
    public float fov = 70.0f;
    public float musicVol = 1.0f;
    public float soundVol = 1.0f;
    public float masterVol = 1.0f;
    public float mobVol = 1.0f;
    public float ambienceVol = 1.0f;
    public float blocksVol = 1.0f;
    public float streamingVol = 1.0f;
    public float sensitivity = 1.0f;
    public int guiScale = 0;
    public int titleStyle = 0;
    public String texturePack;
    public String lastServer = "";
    public float blur = 1.0f;

    public GameSettings(d d2, File file) {
        this.z = d2;
        this.A = new File(file, "options_indev+.txt");
        this.b();
    }

    public final String a(int n) {
        return Keyboard.getKeyName((int)this.s[n].b);
    }

    public final String setKeyBindingName(int n) {
        return this.s[n].a + ": ";
    }

    public final void a(int n, int n2) {
        this.s[n].b = n2;
        this.a();
    }

    public final void b(int n, int n2) {
        if (n == 0) {
            boolean bl = this.sneakMode = !this.sneakMode;
        }
        if (n == 1) {
            boolean bl = this.scrollInvert = !this.scrollInvert;
        }
        if (n == 2) {
            boolean bl = this.c = !this.c;
        }
        if (n == 4) {
            this.z.d();
        }
        if (n == 5) {
            this.e = this.e + n2 & 3;
            if (this.z.d != null) {
                this.z.e.a();
            }
        }
        if (n == 6) {
            boolean bl = this.viewBobbing = !this.viewBobbing;
        }
        if (n == 7) {
            ++this.guiScale;
            if (this.guiScale > 4) {
                this.guiScale = 0;
            }
        }
        if (n == 8) {
            boolean bl = this.h = !this.h;
            if (this.h) {
                Display.setVSyncEnabled((boolean)true);
            } else {
                Display.setVSyncEnabled((boolean)false);
            }
        }
        if (n == 9) {
            boolean bl = f = !f;
        }
        if (n == 10) {
            this.particleCount = this.particleCount + n2 & 3;
            if (this.particleCount == 3) {
                this.particleCount = 0;
            }
        }
        if (n == 11) {
            boolean bl = this.stars = !this.stars;
        }
        if (n == 12) {
            boolean bl = this.fancyParticles = !this.fancyParticles;
        }
        if (n == 13) {
            this.cloudStyle = this.cloudStyle + n2 & 3;
            if (this.cloudStyle == 3) {
                this.cloudStyle = 0;
            }
        }
        if (n == 14) {
            boolean bl = fancyItems = !fancyItems;
        }
        if (n == 15) {
            boolean bl = fancyTextures = !fancyTextures;
            if (this.z.d != null) {
                this.z.e.a();
            }
        }
        if (n == 16) {
            boolean bl = armFlailing = !armFlailing;
        }
        if (n == 17) {
            boolean bl = this.showArm = !this.showArm;
        }
        if (n == 21) {
            this.titleStyle += n2;
            if (this.titleStyle > 1) {
                this.titleStyle = 0;
            }
        }
        this.a();
    }

    public final String b(int n) {
        switch (n) {
            case 0: {
                return this.sneakMode ? "Hold" : "Toggle";
            }
            case 1: {
                return this.scrollInvert ? "On" : "Off";
            }
            case 2: {
                return this.c ? "On" : "Off";
            }
            case 4: {
                return this.z.E ? "On" : "Off";
            }
            case 5: {
                return w[this.e];
            }
            case 6: {
                return this.viewBobbing ? "On" : "Off";
            }
            case 7: {
                return guiScaleString[this.guiScale];
            }
            case 8: {
                return this.h ? "On" : "Off";
            }
            case 9: {
                return f ? "Fancy" : "Fast";
            }
            case 10: {
                return PARTICLES[this.particleCount];
            }
            case 11: {
                return this.stars ? "On" : "Off";
            }
            case 12: {
                return this.fancyParticles ? "Fancy" : "Fast";
            }
            case 13: {
                return CLOUDS[this.cloudStyle];
            }
            case 14: {
                return fancyItems ? "Fancy" : "Fast";
            }
            case 15: {
                return fancyTextures ? "Fancy" : "Fast";
            }
            case 16: {
                return armFlailing ? "Classic" : "Alpha";
            }
            case 17: {
                return this.showArm ? "Classic" : "Fancy";
            }
        }
        return "";
    }

    public final String setOptionDesc(int n) {
        switch (n) {
            case 0: {
                return "Sneak Mode: ";
            }
            case 1: {
                return "Scroll Invert: ";
            }
            case 2: {
                return "Invert Mouse: ";
            }
            case 4: {
                return "Fullscreen: ";
            }
            case 5: {
                return "Render Distance: ";
            }
            case 6: {
                return "View Bobbing: ";
            }
            case 7: {
                return "Gui Scale: ";
            }
            case 8: {
                return "VSync: ";
            }
            case 9: {
                return "Effects: ";
            }
            case 10: {
                return "Particles: ";
            }
            case 11: {
                return "Stars: ";
            }
            case 12: {
                return "Particle Style: ";
            }
            case 13: {
                return "Clouds: ";
            }
            case 14: {
                return "Items: ";
            }
            case 15: {
                return "Leaves: ";
            }
            case 16: {
                return "Arm Animation: ";
            }
            case 17: {
                return "First Person: ";
            }
        }
        return "";
    }

    public void b() {
        try {
            if (this.A.exists()) {
                String string;
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.A));
                while ((string = bufferedReader.readLine()) != null) {
                    try {
                        String[] stringArray = string.split(":");
                        if (stringArray[0].equals("invertYMouse")) {
                            this.c = stringArray[1].equals("true");
                        }
                        if (stringArray[0].equals("scrollInvert")) {
                            this.scrollInvert = stringArray[1].equals("true");
                        }
                        if (stringArray[0].equals("sneakMode")) {
                            this.sneakMode = stringArray[1].equals("true");
                        }
                        if (stringArray[0].equals("armAnim")) {
                            armFlailing = stringArray[1].equals("true");
                        }
                        if (stringArray[0].equals("showArm")) {
                            this.showArm = stringArray[1].equals("true");
                        }
                        if (stringArray[0].equals("showFrameRate")) {
                            this.d = stringArray[1].equals("true");
                        }
                        if (stringArray[0].equals("viewDistance")) {
                            this.e = Integer.parseInt(stringArray[1]);
                        }
                        if (stringArray[0].equals("bobView")) {
                            this.viewBobbing = stringArray[1].equals("true");
                        }
                        if (stringArray[0].equals("guiScale")) {
                            this.guiScale = Integer.parseInt(stringArray[1]);
                        }
                        if (stringArray[0].equals("particles")) {
                            this.particleCount = Integer.parseInt(stringArray[1]);
                        }
                        if (stringArray[0].equals("limitFramerate")) {
                            this.h = stringArray[1].equals("true");
                        }
                        if (stringArray[0].equals("titleStyle")) {
                            this.titleStyle = Integer.parseInt(stringArray[1]);
                        }
                        if (stringArray[0].equals("cloudStyle")) {
                            this.cloudStyle = Integer.parseInt(stringArray[1]);
                        }
                        if (stringArray[0].equals("stars")) {
                            this.stars = stringArray[1].equals("true");
                        }
                        if (stringArray[0].equals("fancyParticles")) {
                            this.fancyParticles = stringArray[1].equals("true");
                        }
                        if (stringArray[0].equals("fancyItems")) {
                            fancyItems = stringArray[1].equals("true");
                        }
                        if (stringArray[0].equals("fancyTextures")) {
                            fancyTextures = stringArray[1].equals("true");
                        }
                        if (stringArray[0].equals("graphics")) {
                            f = stringArray[1].equals("true");
                        }
                        if (stringArray[0].equals("musicVol")) {
                            this.musicVol = Float.parseFloat(stringArray[1]);
                        }
                        if (stringArray[0].equals("soundVol")) {
                            this.soundVol = Float.parseFloat(stringArray[1]);
                        }
                        if (stringArray[0].equals("masterVol")) {
                            this.masterVol = Float.parseFloat(stringArray[1]);
                        }
                        if (stringArray[0].equals("ambienceVol")) {
                            this.ambienceVol = Float.parseFloat(stringArray[1]);
                        }
                        if (stringArray[0].equals("mobVol")) {
                            this.mobVol = Float.parseFloat(stringArray[1]);
                        }
                        if (stringArray[0].equals("blocksVol")) {
                            this.blocksVol = Float.parseFloat(stringArray[1]);
                        }
                        if (stringArray[0].equals("streamingVol")) {
                            this.streamingVol = Float.parseFloat(stringArray[1]);
                        }
                        if (stringArray[0].equals("sensitivity")) {
                            this.sensitivity = Float.parseFloat(stringArray[1]);
                        }
                        if (stringArray[0].equals("FOV")) {
                            this.fov = Float.parseFloat(stringArray[1]);
                        }
                        if (stringArray[0].equals("blur")) {
                            this.blur = Float.parseFloat(stringArray[1]);
                        }
                        if (stringArray[0].equals("skin")) {
                            this.texturePack = stringArray[1];
                        }
                        if (stringArray[0].equals("char")) {
                            this.character = Integer.parseInt(stringArray[1]);
                        }
                        if (stringArray[0].equals("lastServer") && stringArray.length >= 2) {
                            this.lastServer = stringArray[1];
                        }
                        for (int i = 0; i < this.s.length; ++i) {
                            if (!stringArray[0].equals("key_" + this.s[i].a)) continue;
                            this.s[i].b = Integer.parseInt(stringArray[1]);
                        }
                    }
                    catch (Exception exception) {
                        System.out.println("Skipping bad option: " + string);
                    }
                }
                bufferedReader.close();
            }
        }
        catch (Exception exception) {
            System.out.println("Failed to load options");
            exception.printStackTrace();
        }
    }

    public final void a() {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(this.A));
            printWriter.println("armAnim:" + armFlailing);
            printWriter.println("showArm:" + this.showArm);
            printWriter.println("invertYMouse:" + this.c);
            printWriter.println("scrollInvert:" + this.scrollInvert);
            printWriter.println("sneakMode:" + this.sneakMode);
            printWriter.println("stars:" + this.stars);
            printWriter.println("fancyParticles:" + this.fancyParticles);
            printWriter.println("fancyItems:" + fancyItems);
            printWriter.println("fancyTextures:" + fancyTextures);
            printWriter.println("showFrameRate:" + this.d);
            printWriter.println("viewDistance:" + this.e);
            printWriter.println("cloudStyle:" + this.cloudStyle);
            printWriter.println("bobView:" + this.viewBobbing);
            printWriter.println("limitFramerate:" + this.h);
            printWriter.println("graphics:" + f);
            printWriter.println("musicVol:" + this.musicVol);
            printWriter.println("soundVol:" + this.soundVol);
            printWriter.println("masterVol:" + this.masterVol);
            printWriter.println("ambienceVol:" + this.ambienceVol);
            printWriter.println("mobVol:" + this.mobVol);
            printWriter.println("streamingVol:" + this.streamingVol);
            printWriter.println("blocksVol:" + this.blocksVol);
            printWriter.println("sensitivity:" + this.sensitivity);
            printWriter.println("FOV:" + this.fov);
            printWriter.println("blur:" + this.blur);
            printWriter.println("guiScale:" + this.guiScale);
            printWriter.println("particles:" + this.particleCount);
            printWriter.println("titleStyle:" + this.titleStyle);
            printWriter.println("skin:" + this.texturePack);
            printWriter.println("char:" + this.character);
            printWriter.println("lastServer:" + this.lastServer);
            for (int i = 0; i < this.s.length; ++i) {
                printWriter.println("key_" + this.s[i].a + ":" + this.s[i].b);
            }
            printWriter.close();
        }
        catch (Exception exception) {
            System.out.println("Failed to save options");
            exception.printStackTrace();
        }
    }
}

