/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import net.minecraft.client.c.GuiButton;
import net.minecraft.client.d;
import org.lwjgl.opengl.GL11;

public class C_bl
extends GuiButton {
    public float sliderValue = 1.0f;
    public boolean dragging = false;
    public int type = 0;

    public C_bl(int n, int n2, int n3, String string, int n4) {
        super(n, n2, n3, string);
        this.e = 150;
        this.f = 20;
        this.slider = true;
        this.type = n4;
    }

    public C_bl(int n, int n2, int n3, String string, int n4, int n5, int n6) {
        super(n, n2, n3, string);
        this.e = n5;
        this.f = n6;
        this.slider = true;
        this.type = n4;
    }

    @Override
    protected void mouseDragged(d d2, int n, int n2) {
        boolean bl = n >= this.g && n2 >= this.i && n < this.g + this.e && n2 < this.i + this.f;
        int n3 = 0;
        n3 = bl ? 2 : 1;
        GL11.glBindTexture((int)3553, (int)d2.m.a("/gui/gui.png"));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        if (this.type == 0) {
            this.sliderValue = d2.w.sensitivity;
            this.a = this.sliderValue <= 0.0f ? "Sensitivity: Snail's pace" : (this.sliderValue >= 2.0f ? "Sensitivity: HYPERSPEED!!!" : "Sensitivity: " + (int)(this.sliderValue * 100.0f) + "%");
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e / 2 - 4);
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 2.0f) {
                    this.sliderValue = 2.0f;
                }
                d2.w.sensitivity = this.sliderValue;
                this.a = this.sliderValue <= 0.0f ? "Sensitivity: Snail's pace" : (this.sliderValue >= 2.0f ? "Sensitivity: HYPERSPEED!!!" : "Sensitivity: " + (int)(this.sliderValue * 100.0f) + "%");
            }
            d2.w.a();
            this.b(this.g + (int)(this.sliderValue * (float)(this.e / 2 - 4)), this.i, 0, 46 + n3 * 20, 4, 20);
            this.b(this.g + (int)(this.sliderValue * (float)(this.e / 2 - 4)) + 4, this.i, 196, 46 + n3 * 20, 4, 20);
        } else if (this.type == 1) {
            this.sliderValue = (int)d2.w.fov;
            this.a = this.sliderValue == 70.0f ? "FOV: Normal" : (this.sliderValue == 120.0f ? "FOV: Quake Pro" : "FOV: " + (int)this.sliderValue);
            this.sliderValue = d2.w.fov / 50.0f - 1.4f;
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8);
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 1.0f) {
                    this.sliderValue = 1.0f;
                }
                d2.w.fov = (int)(70.0f + this.sliderValue * 50.0f);
                this.a = this.sliderValue == 0.0f ? "FOV: Normal" : (this.sliderValue == 1.0f ? "FOV: Quake Pro" : "FOV: " + (int)(70.0f + this.sliderValue * 50.0f));
            }
            d2.w.a();
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)), this.i, 0, 46 + n3 * 20, 4, 20);
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)) + 4, this.i, 196, 46 + n3 * 20, 4, 20);
        } else if (this.type == 2) {
            this.sliderValue = d2.w.musicVol;
            this.a = this.sliderValue == 0.0f ? "Music: Off" : "Music: " + (int)(this.sliderValue * 100.0f) + "%";
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8);
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 1.0f) {
                    this.sliderValue = 1.0f;
                }
                d2.w.musicVol = this.sliderValue;
                this.a = this.sliderValue == 0.0f ? "Music: Off" : "Music: " + (int)(this.sliderValue * 100.0f) + "%";
            }
            d2.w.a();
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)), this.i, 0, 46 + n3 * 20, 4, 20);
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)) + 4, this.i, 196, 46 + n3 * 20, 4, 20);
        } else if (this.type == 3) {
            this.sliderValue = d2.w.soundVol;
            this.a = this.sliderValue == 0.0f ? "Sound: Off" : "Sound: " + (int)(this.sliderValue * 100.0f) + "%";
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8);
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 1.0f) {
                    this.sliderValue = 1.0f;
                }
                d2.w.soundVol = this.sliderValue;
                this.a = this.sliderValue == 0.0f ? "Sound: Off" : "Sound: " + (int)(this.sliderValue * 100.0f) + "%";
            }
            d2.w.a();
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)), this.i, 0, 46 + n3 * 20, 4, 20);
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)) + 4, this.i, 196, 46 + n3 * 20, 4, 20);
        } else if (this.type == 4) {
            this.sliderValue = d2.worldOptions.width >> 64;
            this.a = "Width: " + (int)this.sliderValue;
            this.sliderValue = d2.worldOptions.width == 512 ? 3.0f : (d2.worldOptions.width == 1024 ? 4.0f : (float)(d2.worldOptions.width / 128));
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8) * 4.0f;
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 4.0f) {
                    this.sliderValue = 4.0f;
                }
                d2.worldOptions.width = 64 << (int)this.sliderValue;
            }
            this.b(this.g + (int)(this.sliderValue / 4.0f * (float)(this.e - 8)), this.i, 0, 46 + n3 * 20, 4, 20);
            this.b(this.g + (int)(this.sliderValue / 4.0f * (float)(this.e - 8)) + 4, this.i, 196, 46 + n3 * 20, 4, 20);
        } else if (this.type == 5) {
            this.sliderValue = d2.worldOptions.height >> 64;
            this.a = "Height: " + (int)this.sliderValue;
            this.sliderValue = d2.worldOptions.height == 512 ? 3.0f : (d2.worldOptions.height == 1024 ? 4.0f : (float)(d2.worldOptions.height / 128));
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8) * 4.0f;
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 4.0f) {
                    this.sliderValue = 4.0f;
                }
                d2.worldOptions.height = 64 << (int)this.sliderValue;
            }
            this.b(this.g + (int)(this.sliderValue / 4.0f * (float)(this.e - 8)), this.i, 0, 46 + n3 * 20, 4, 20);
            this.b(this.g + (int)(this.sliderValue / 4.0f * (float)(this.e - 8)) + 4, this.i, 196, 46 + n3 * 20, 4, 20);
        } else if (this.type == 6) {
            this.sliderValue = d2.worldOptions.length >> 64;
            this.a = "Length: " + (int)this.sliderValue;
            this.sliderValue = d2.worldOptions.length == 512 ? 3.0f : (d2.worldOptions.length == 1024 ? 4.0f : (float)(d2.worldOptions.length / 128));
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8) * 4.0f;
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 4.0f) {
                    this.sliderValue = 4.0f;
                }
                d2.worldOptions.length = 64 << (int)this.sliderValue;
            }
            this.b(this.g + (int)(this.sliderValue / 4.0f * (float)(this.e - 8)), this.i, 0, 46 + n3 * 20, 4, 20);
            this.b(this.g + (int)(this.sliderValue / 4.0f * (float)(this.e - 8)) + 4, this.i, 196, 46 + n3 * 20, 4, 20);
        } else if (this.type == 7) {
            this.sliderValue = d2.w.masterVol;
            this.a = this.sliderValue == 0.0f ? "Master: Off" : "Master: " + (int)(this.sliderValue * 100.0f) + "%";
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8);
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 1.0f) {
                    this.sliderValue = 1.0f;
                }
                d2.w.masterVol = this.sliderValue;
                this.a = this.sliderValue == 0.0f ? "Master: Off" : "Master: " + (int)(this.sliderValue * 100.0f) + "%";
            }
            d2.w.a();
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)), this.i, 0, 46 + n3 * 20, 4, 20);
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)) + 4, this.i, 196, 46 + n3 * 20, 4, 20);
        } else if (this.type == 8) {
            this.sliderValue = d2.w.ambienceVol;
            this.a = this.sliderValue == 0.0f ? "Ambience: Off" : "Ambience: " + (int)(this.sliderValue * 100.0f) + "%";
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8);
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 1.0f) {
                    this.sliderValue = 1.0f;
                }
                d2.w.ambienceVol = this.sliderValue;
                this.a = this.sliderValue == 0.0f ? "Ambience: Off" : "Ambience: " + (int)(this.sliderValue * 100.0f) + "%";
            }
            d2.w.a();
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)), this.i, 0, 46 + n3 * 20, 4, 20);
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)) + 4, this.i, 196, 46 + n3 * 20, 4, 20);
        } else if (this.type == 9) {
            this.sliderValue = d2.w.mobVol;
            this.a = this.sliderValue == 0.0f ? "Mobs: Off" : "Mobs: " + (int)(this.sliderValue * 100.0f) + "%";
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8);
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 1.0f) {
                    this.sliderValue = 1.0f;
                }
                d2.w.mobVol = this.sliderValue;
                this.a = this.sliderValue == 0.0f ? "Mobs: Off" : "Mobs: " + (int)(this.sliderValue * 100.0f) + "%";
            }
            d2.w.a();
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)), this.i, 0, 46 + n3 * 20, 4, 20);
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)) + 4, this.i, 196, 46 + n3 * 20, 4, 20);
        } else if (this.type == 10) {
            this.sliderValue = d2.w.streamingVol;
            this.a = this.sliderValue == 0.0f ? "Jukebox: Off" : "Jukebox: " + (int)(this.sliderValue * 100.0f) + "%";
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8);
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 1.0f) {
                    this.sliderValue = 1.0f;
                }
                d2.w.streamingVol = this.sliderValue;
                this.a = this.sliderValue == 0.0f ? "Jukebox: Off" : "Jukebox: " + (int)(this.sliderValue * 100.0f) + "%";
            }
            d2.w.a();
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)), this.i, 0, 46 + n3 * 20, 4, 20);
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)) + 4, this.i, 196, 46 + n3 * 20, 4, 20);
        } else if (this.type == 11) {
            this.sliderValue = d2.w.blocksVol;
            this.a = this.sliderValue == 0.0f ? "Blocks: Off" : "Blocks: " + (int)(this.sliderValue * 100.0f) + "%";
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8);
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 1.0f) {
                    this.sliderValue = 1.0f;
                }
                d2.w.blocksVol = this.sliderValue;
                this.a = this.sliderValue == 0.0f ? "Blocks: Off" : "Blocks: " + (int)(this.sliderValue * 100.0f) + "%";
            }
            d2.w.a();
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)), this.i, 0, 46 + n3 * 20, 4, 20);
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)) + 4, this.i, 196, 46 + n3 * 20, 4, 20);
        } else if (this.type == 12) {
            this.sliderValue = d2.w.blur;
            this.a = this.sliderValue == 0.0f ? "Blur: Off" : "Blur: " + (int)(this.sliderValue * 100.0f) + "%";
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8);
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 1.0f) {
                    this.sliderValue = 1.0f;
                }
                d2.w.blur = this.sliderValue;
                this.a = this.sliderValue == 0.0f ? "Blur: Off" : "Blur: " + (int)(this.sliderValue * 100.0f) + "%";
            }
            d2.w.a();
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)), this.i, 0, 46 + n3 * 20, 4, 20);
            this.b(this.g + (int)(this.sliderValue * (float)(this.e - 8)) + 4, this.i, 196, 46 + n3 * 20, 4, 20);
        }
        if (bl) {
            C_bl.a(d2.n, this.a, this.g + this.e / 2, this.i + (this.f - 8) / 2, 0xFFFFA0);
        } else {
            C_bl.a(d2.n, this.a, this.g + this.e / 2, this.i + (this.f - 8) / 2, 0xE0E0E0);
        }
    }

    @Override
    public boolean mousePressed(d d2, int n, int n2) {
        if (super.mousePressed(d2, n, n2)) {
            if (this.type == 0) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e / 2 - 4);
                if (this.sliderValue < 0.01f) {
                    this.sliderValue = 0.01f;
                }
                if (this.sliderValue > 2.0f) {
                    this.sliderValue = 2.0f;
                }
                d2.w.sensitivity = this.sliderValue;
            } else if (this.type >= 4 && this.type <= 6) {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8) * 4.0f;
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 4.0f) {
                    this.sliderValue = 4.0f;
                }
                switch (this.type) {
                    case 4: {
                        d2.worldOptions.width = 64 << (int)this.sliderValue;
                        break;
                    }
                    case 5: {
                        d2.worldOptions.height = 64 << (int)this.sliderValue;
                        break;
                    }
                    case 6: {
                        d2.worldOptions.length = 64 << (int)this.sliderValue;
                    }
                }
            } else {
                this.sliderValue = (float)(n - (this.g + 4)) / (float)(this.e - 8);
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 1.0f) {
                    this.sliderValue = 1.0f;
                }
                switch (this.type) {
                    case 1: {
                        d2.w.fov = (int)(70.0f + this.sliderValue * 50.0f);
                        break;
                    }
                    case 2: {
                        d2.w.musicVol = this.sliderValue;
                        break;
                    }
                    case 3: {
                        d2.w.soundVol = this.sliderValue;
                        break;
                    }
                    case 7: {
                        d2.w.masterVol = this.sliderValue;
                        break;
                    }
                    case 8: {
                        d2.w.ambienceVol = this.sliderValue;
                        break;
                    }
                    case 9: {
                        d2.w.mobVol = this.sliderValue;
                        break;
                    }
                    case 10: {
                        d2.w.streamingVol = this.sliderValue;
                        break;
                    }
                    case 11: {
                        d2.w.blocksVol = this.sliderValue;
                        break;
                    }
                    case 12: {
                        d2.w.blur = this.sliderValue;
                    }
                }
            }
            this.dragging = true;
            return true;
        }
        return false;
    }

    @Override
    public final void a(d d2, int n, int n2) {
        if (this.d) {
            GL11.glBindTexture((int)3553, (int)d2.m.a("/gui/gui.png"));
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            int n3 = 1;
            n3 = 0;
            this.b(this.g, this.i, 0, 46 + n3 * 20, this.e / 2, this.f);
            this.b(this.g + this.e / 2, this.i, 200 - this.e / 2, 46 + n3 * 20, this.e / 2, this.f);
        }
    }

    @Override
    public void mouseReleased(int n, int n2) {
        this.dragging = false;
    }
}

