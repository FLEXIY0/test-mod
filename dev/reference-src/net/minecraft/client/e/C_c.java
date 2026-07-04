/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.e;

import java.io.File;
import java.util.Random;
import net.minecraft.a.c.C_e;
import net.minecraft.client.GameSettings;
import net.minecraft.client.e.C_a;
import net.minecraft.client.e.C_b;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;
import util.MathHelper;

public final class C_c {
    public SoundSystem a;
    private C_b b = new C_b();
    private C_b c = new C_b();
    private C_b soundPoolStreaming = new C_b();
    private C_b creativeMusicPool = new C_b();
    private C_b nightMusicPool = new C_b();
    private int d = 0;
    private GameSettings e;
    public boolean f = false;
    public int ticksBeforeMusic;
    public Random rand = new Random();

    public C_c() {
        this.ticksBeforeMusic = this.rand.nextInt(1000);
    }

    public void a(GameSettings gameSettings) {
        this.e = gameSettings;
        if (!this.f && (gameSettings.musicVol >= 0.0f || gameSettings.soundVol >= 0.0f || gameSettings.mobVol >= 0.0f || gameSettings.masterVol >= 0.0f || gameSettings.streamingVol >= 0.0f || gameSettings.ambienceVol >= 0.0f || gameSettings.blocksVol >= 0.0f)) {
            this.c();
        }
    }

    private void c() {
        try {
            float f = this.e.soundVol;
            float f2 = this.e.musicVol;
            float f3 = this.e.masterVol;
            float f4 = this.e.ambienceVol;
            float f5 = this.e.mobVol;
            float f6 = this.e.blocksVol;
            float f7 = this.e.streamingVol;
            this.e.soundVol = 0.0f;
            this.e.musicVol = 0.0f;
            this.e.masterVol = 0.0f;
            this.e.ambienceVol = 0.0f;
            this.e.mobVol = 0.0f;
            this.e.blocksVol = 0.0f;
            this.e.streamingVol = 0.0f;
            this.e.a();
            SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
            SoundSystemConfig.setCodec("wav", CodecWav.class);
            this.a = new SoundSystem();
            this.e.soundVol = f;
            this.e.musicVol = f2;
            this.e.masterVol = f3;
            this.e.ambienceVol = f4;
            this.e.mobVol = f5;
            this.e.blocksVol = f6;
            this.e.streamingVol = f7;
            this.e.a();
        }
        catch (Throwable throwable) {
            System.err.println("error linking with the LibraryJavaSound plug-in");
        }
        this.f = true;
    }

    public final void a() {
        if (!this.f && this.e.masterVol >= 0.0f && (this.e.blocksVol > 0.0f || this.e.musicVol > 0.0f || this.e.soundVol > 0.0f || this.e.ambienceVol > 0.0f || this.e.mobVol > 0.0f)) {
            this.c();
        }
        if (this.e.musicVol == 0.0f || this.e.masterVol == 0.0f) {
            this.a.stop("BgMusic");
        } else {
            this.a.setVolume("BgMusic", this.e.musicVol * this.e.masterVol);
        }
    }

    public final void b() {
        if (this.f) {
            this.a.cleanup();
        }
    }

    public final void a(String string, File file) {
        this.b.a(string, file);
    }

    public void addMusic(String string, String string2, File file) {
        switch (string) {
            default: {
                this.c.a(string2, file);
                break;
            }
            case "creativemusic": {
                this.creativeMusicPool.a(string2, file);
                break;
            }
            case "nightmusic": {
                this.nightMusicPool.a(string2, file);
            }
        }
    }

    public void addStreaming(String string, File file) {
        this.soundPoolStreaming.a(string, file);
    }

    public void playRandomMusicIfReady(int n) {
        if (!this.f || this.e.musicVol == 0.0f || this.e.masterVol == 0.0f) {
            return;
        }
        if (!this.a.playing("BgMusic") && !this.a.playing("streaming")) {
            if (this.ticksBeforeMusic > 0) {
                --this.ticksBeforeMusic;
                return;
            }
            C_a c_a = this.c.getRandomSound();
            switch (n) {
                case 4: {
                    c_a = this.creativeMusicPool.getRandomSound();
                    break;
                }
                case 10: {
                    c_a = this.nightMusicPool.getRandomSound();
                    break;
                }
                default: {
                    c_a = this.c.getRandomSound();
                }
            }
            if (c_a != null) {
                this.ticksBeforeMusic = this.rand.nextInt(12000) + 12000;
                this.a.backgroundMusic("BgMusic", c_a.b, c_a.a, false);
                this.a.setVolume("BgMusic", this.e.musicVol * this.e.masterVol);
                this.a.play("BgMusic");
            }
        }
    }

    public final void a(C_e c_e, float f) {
        if (this.f && this.e.soundVol > 0.0f && this.e.masterVol > 0.0f && c_e != null) {
            float f2 = c_e.q + (c_e.o - c_e.q) * f;
            float f3 = c_e.p + (c_e.n - c_e.p) * f;
            float f4 = c_e.e + (c_e.h - c_e.e) * f;
            float f5 = c_e.f + (c_e.i - c_e.f) * f;
            float f6 = c_e.g + (c_e.j - c_e.g) * f;
            f = MathHelper.b(-f3 * ((float)Math.PI / 180) - (float)Math.PI);
            f3 = MathHelper.a(-f3 * ((float)Math.PI / 180) - (float)Math.PI);
            float f7 = MathHelper.b(-f2 * ((float)Math.PI / 180));
            f2 = MathHelper.a(-f2 * ((float)Math.PI / 180));
            float f8 = -f3 * f7;
            float f9 = -f * f7;
            f3 = -f3 * f2;
            f = -f * f2;
            this.a.setListenerPosition(f4, f5, f6);
            this.a.setListenerOrientation(f8, f2, f9, f3, f7, f);
        }
    }

    public final void a(String string, float f, float f2, float f3, float f4, float f5) {
        C_a c_a;
        if (this.f && this.e.soundVol > 0.0f && this.e.masterVol > 0.0f && (c_a = this.b.a(string)) != null && f4 > 0.0f) {
            this.d = (this.d + 1) % 256;
            String string2 = "sound_" + this.d;
            float f6 = 16.0f;
            if (f4 > 1.0f) {
                f6 = 16.0f * f4;
            }
            this.a.newSource(f4 > 1.0f, string2, c_a.b, c_a.a, false, f, f2, f3, 2, f6);
            this.a.setPitch(string2, f5);
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            this.a.setVolume(string2, f4 * (this.e.soundVol * this.e.masterVol));
            this.a.play(string2);
        }
    }

    public final void playMobSound(String string, float f, float f2, float f3, float f4, float f5) {
        C_a c_a;
        if (this.f && this.e.mobVol > 0.0f && this.e.masterVol > 0.0f && (c_a = this.b.a(string)) != null && f4 > 0.0f) {
            this.d = (this.d + 1) % 256;
            String string2 = "sound_" + this.d;
            float f6 = 16.0f;
            if (f4 > 1.0f) {
                f6 = 16.0f * f4;
            }
            this.a.newSource(f4 > 1.0f, string2, c_a.b, c_a.a, false, f, f2, f3, 2, f6);
            this.a.setPitch(string2, f5);
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            this.a.setVolume(string2, f4 * (this.e.mobVol * this.e.masterVol));
            this.a.play(string2);
        }
    }

    public final void playBlockSound(String string, float f, float f2, float f3, float f4, float f5) {
        C_a c_a;
        if (this.f && this.e.blocksVol > 0.0f && this.e.masterVol > 0.0f && (c_a = this.b.a(string)) != null && f4 > 0.0f) {
            this.d = (this.d + 1) % 256;
            String string2 = "sound_" + this.d;
            float f6 = 16.0f;
            if (f4 > 1.0f) {
                f6 = 16.0f * f4;
            }
            this.a.newSource(f4 > 1.0f, string2, c_a.b, c_a.a, false, f, f2, f3, 2, f6);
            this.a.setPitch(string2, f5);
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            this.a.setVolume(string2, f4 * (this.e.blocksVol * this.e.masterVol));
            this.a.play(string2);
        }
    }

    public final void a(String string, float f, float f2) {
        C_a c_a;
        if (this.f && this.e.soundVol > 0.0f && this.e.masterVol > 0.0f && (c_a = this.b.a(string)) != null) {
            this.d = (this.d + 1) % 256;
            String string2 = "sound_" + this.d;
            this.a.newSource(false, string2, c_a.b, c_a.a, false, 0.0f, 0.0f, 0.0f, 0, 0.0f);
            this.a.setPitch(string2, 1.0f);
            this.a.setVolume(string2, 0.25f * (this.e.soundVol * this.e.masterVol));
            this.a.play(string2);
        }
    }

    public final void playAmbience(String string, float f, float f2) {
        C_a c_a;
        if (this.f && this.e.ambienceVol > 0.0f && this.e.masterVol > 0.0f && (c_a = this.b.a(string)) != null) {
            this.d = (this.d + 1) % 256;
            String string2 = "sound_" + this.d;
            this.a.newSource(true, string2, c_a.b, c_a.a, false, 0.0f, 0.0f, 0.0f, 0, 0.0f);
            this.a.setPitch(string2, f2);
            this.a.setVolume(string2, f * (this.e.ambienceVol * this.e.masterVol));
            this.a.play(string2);
        }
    }

    public final void playAllocatedAmbience(String string, float f, float f2, boolean bl) {
        C_a c_a;
        if (this.f && this.e.ambienceVol > 0.0f && this.e.masterVol > 0.0f && (c_a = this.b.a(string)) != null) {
            this.d = (this.d + 1) % 256;
            String string2 = "ambience";
            if (this.a.playing("ambience")) {
                this.a.stop("ambience");
            }
            this.a.newSource(true, string2, c_a.b, c_a.a, bl, 0.0f, 0.0f, 0.0f, 0, 0.0f);
            this.a.setPitch(string2, f2);
            this.a.setVolume(string2, f * (this.e.ambienceVol * this.e.masterVol));
            this.a.play(string2);
        }
    }

    public final void playAmbience(String string) {
        if (!this.f || this.e.ambienceVol == 0.0f || this.e.masterVol == 0.0f) {
            return;
        }
        C_a c_a = this.b.a(string);
        if (c_a != null && !this.a.playing("ambienceTrack")) {
            this.a.backgroundMusic("ambienceTrack", c_a.b, c_a.a, true);
            this.a.setPitch("ambienceTrack", 1.0f);
            this.a.setVolume("ambienceTrack", 0.1f * (this.e.ambienceVol * this.e.masterVol));
            this.a.play("ambienceTrack");
        }
    }

    public void playStreaming(String string, float f, float f2, float f3, float f4, float f5) {
        if (this.f && this.e.streamingVol != 0.0f && this.e.masterVol != 0.0f) {
            C_a c_a;
            String string2 = "streaming";
            if (this.a.playing("streaming")) {
                this.a.stop("streaming");
            }
            if (string != null && (c_a = this.soundPoolStreaming.a(string)) != null && f4 > 0.0f) {
                if (this.a.playing("BgMusic")) {
                    this.a.stop("BgMusic");
                }
                float f6 = 16.0f;
                this.a.newStreamingSource(true, string2, c_a.b, c_a.a, false, f, f2, f3, 2, f6 * 4.0f);
                this.a.setVolume(string2, 0.5f * (this.e.streamingVol * this.e.masterVol));
                this.a.play(string2);
            }
        }
    }
}

