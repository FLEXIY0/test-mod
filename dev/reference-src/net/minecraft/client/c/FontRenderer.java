/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Lang;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.ChatAllowedCharacters;
import net.minecraft.client.c.Gui;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public final class FontRenderer {
    public static final char COLOR_CODE = '\u00a7';
    private int[] a = new int[256];
    private int b = 0;
    private IntBuffer d = BufferUtils.createIntBuffer((int)1024);
    private int[] colorCode = new int[32];

    public FontRenderer(GameSettings gameSettings, String string, RenderEngine renderEngine) {
        int n;
        boolean bl;
        int n2;
        int n3;
        int n4;
        int n5;
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(RenderEngine.class.getResourceAsStream(string));
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        int n6 = bufferedImage.getWidth();
        int n7 = bufferedImage.getHeight();
        int[] nArray = new int[n6 * n7];
        bufferedImage.getRGB(0, 0, n6, n7, nArray, 0, n6);
        for (n5 = 0; n5 < 256; ++n5) {
            n4 = n5 % 16;
            n3 = n5 / 16;
            for (n2 = 7; n2 >= 0; --n2) {
                int n8 = n4 * 8 + n2;
                bl = true;
                for (int i = 0; i < 8 && bl; ++i) {
                    n = (n3 * 8 + i) * n6;
                    int n9 = nArray[n8 + n] & 0xFF;
                    if (n9 <= 0) continue;
                    bl = false;
                }
                if (!bl) break;
            }
            if (n5 == 32) {
                n2 = 2;
            }
            this.a[n5] = n2 + 2;
        }
        this.b = renderEngine.a(string);
        for (n4 = 0; n4 < 32; ++n4) {
            n3 = (n4 & 8) << 3;
            n2 = (n4 & 1) * 191 + n3;
            n5 = ((n4 & 2) >> 1) * 191 + n3;
            n = ((n4 & 4) >> 2) * 191 + n3;
            boolean bl2 = bl = n4 >= 16;
            if (bl) {
                n /= 4;
                n5 /= 4;
                n2 /= 4;
            }
            this.colorCode[n4] = (n & 0xFF) << 16 | (n5 & 0xFF) << 8 | n2 & 0xFF;
        }
    }

    public final void a(String string, int n, int n2, int n3) {
        string = Lang.tr(string);
        this.a(string, n + 1, n2 + 1, n3, true);
        this.b(string, n, n2, n3);
    }

    public void drawStringWithBackground(String string, int n, int n2, int n3) {
        string = Lang.tr(string);
        Gui.a(n - 1, n2 - 1, n + this.a(string) + 1, n2 + 9, Integer.MIN_VALUE);
        this.a(string, n + 1, n2 + 1, n3, false);
    }

    public final void b(String string, int n, int n2, int n3) {
        string = Lang.tr(string);
        this.a(string, n, n2, n3, false);
    }

    private void a(String string, int n, int n2, int n3, boolean bl) {
        if (string != null) {
            if ((n3 & 0xFC000000) == 0) {
                n3 |= 0xFF000000;
            }
            if (bl) {
                n3 = (n3 & 0xFCFCFC) >> 2 | n3 & 0xFF000000;
            }
            GL11.glBindTexture((int)3553, (int)this.b);
            float f = (float)(n3 >> 16 & 0xFF) / 255.0f;
            float f2 = (float)(n3 >> 8 & 0xFF) / 255.0f;
            float f3 = (float)(n3 & 0xFF) / 255.0f;
            float f4 = (float)(n3 >> 24 & 0xFF) / 255.0f;
            GL11.glColor4f((float)f, (float)f2, (float)f3, (float)f4);
            this.d.clear();
            GL11.glPushMatrix();
            GL11.glTranslatef((float)n, (float)n2, (float)0.0f);
            for (int i = 0; i < string.length(); ++i) {
                int n4;
                int n5;
                if (string.charAt(i) == '\u00a7' && string.length() > i + 1) {
                    n5 = "0123456789abcdef".indexOf(string.toLowerCase().charAt(i + 1));
                    if (n5 < 0 || n5 > 15) {
                        n5 = 15;
                    }
                    n4 = this.colorCode[n5 + (bl ? 16 : 0)];
                    GL11.glColor4f((float)((float)(n4 >> 16) / 255.0f), (float)((float)(n4 >> 8 & 0xFF) / 255.0f), (float)((float)(n4 & 0xFF) / 255.0f), (float)f4);
                    ++i;
                    continue;
                }
                n5 = ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(string.charAt(i));
                if (n5 < 0) continue;
                n4 = (n5 + 32) % 16 << 3;
                int n6 = (n5 + 32) / 16 << 3;
                GL11.glBegin((int)5);
                GL11.glTexCoord2f((float)((float)n4 / 128.0f), (float)((float)n6 / 128.0f));
                GL11.glVertex3f((float)0.0f, (float)0.0f, (float)0.0f);
                GL11.glTexCoord2f((float)((float)n4 / 128.0f), (float)(((float)n6 + 7.99f) / 128.0f));
                GL11.glVertex3f((float)0.0f, (float)7.99f, (float)0.0f);
                GL11.glTexCoord2f((float)(((float)n4 + 7.99f) / 128.0f), (float)((float)n6 / 128.0f));
                GL11.glVertex3f((float)7.99f, (float)0.0f, (float)0.0f);
                GL11.glTexCoord2f((float)(((float)n4 + 7.99f) / 128.0f), (float)(((float)n6 + 7.99f) / 128.0f));
                GL11.glVertex3f((float)7.99f, (float)7.99f, (float)0.0f);
                GL11.glEnd();
                GL11.glTranslatef((float)this.a[n5 + 32], (float)0.0f, (float)0.0f);
            }
            this.d.flip();
            GL11.glCallLists((IntBuffer)this.d);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
    }

    public final int a(String string) {
        if ((string = Lang.tr(string)) == null) {
            return 0;
        }
        char[] cArray = string.toCharArray();
        int n = 0;
        for (int i = 0; i < cArray.length; ++i) {
            if (cArray[i] == '\u00a7') {
                ++i;
                continue;
            }
            int n2 = ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(string.charAt(i));
            if (n2 < 0) continue;
            n += this.a[n2 + 32];
        }
        return n;
    }

    public void drawSplitString(String string, int n, int n2, int n3, int n4) {
        string = Lang.tr(string);
        string = this.trimStringNewline(string);
        this.renderSplitString(string, n, n2, n3, n4, false);
    }

    private void renderSplitString(String string, int n, int n2, int n3, int n4, boolean bl) {
        List<String> list = this.listFormattedStringToWidth(string, n3);
        for (String string2 : list) {
            this.a(string2, n, n2, n4, bl);
            n2 += 9;
        }
    }

    public int splitStringWidth(String string, int n) {
        string = Lang.tr(string);
        return 9 * this.listFormattedStringToWidth(string, n).size();
    }

    private String trimStringNewline(String string) {
        while (string != null && string.endsWith("\n")) {
            string = string.substring(0, string.length() - 1);
        }
        return string;
    }

    public List<String> listFormattedStringToWidth(String string, int n) {
        return Arrays.asList(this.wrapFormattedStringToWidth(string, n).split("\n"));
    }

    String wrapFormattedStringToWidth(String string, int n) {
        int n2 = this.sizeStringToWidth(string, n);
        if (string.length() <= n2) {
            return string;
        }
        String string2 = string.substring(0, n2);
        char c = string.charAt(n2);
        boolean bl = c == ' ' || c == '\n';
        String string3 = FontRenderer.getFormatFromString(string2) + string.substring(n2 + (bl ? 1 : 0));
        return string2 + "\n" + this.wrapFormattedStringToWidth(string3, n);
    }

    private static String getFormatFromString(String string) {
        String string2 = "";
        int n = -1;
        int n2 = string.length();
        while ((n = string.indexOf(167, n + 1)) != -1) {
            char c;
            if (n >= n2 - 1 || !FontRenderer.isFormatColor(c = string.charAt(n + 1))) continue;
            string2 = "\u00a7" + c;
        }
        return string2;
    }

    private int sizeStringToWidth(String string, int n) {
        int n2;
        int n3 = string.length();
        int n4 = 0;
        int n5 = -1;
        boolean bl = false;
        for (n2 = 0; n2 < n3; ++n2) {
            char c = string.charAt(n2);
            switch (c) {
                case '\n': {
                    --n2;
                    break;
                }
                case '\u00a7': {
                    char c2;
                    if (n2 >= n3 - 1) break;
                    if ((c2 = string.charAt(++n2)) != 'l' && c2 != 'L') {
                        if (c2 != 'r' && c2 != 'R' && !FontRenderer.isFormatColor(c2)) break;
                        bl = false;
                        break;
                    }
                    bl = true;
                    break;
                }
                case ' ': {
                    n5 = n2;
                }
                default: {
                    n4 += this.getCharWidth(c);
                    if (!bl) break;
                    ++n4;
                }
            }
            if (c == '\n') {
                n5 = ++n2;
                break;
            }
            if (n4 > n) break;
        }
        return n2 != n3 && n5 != -1 && n5 < n2 ? n5 : n2;
    }

    public int getCharWidth(char c) {
        if (c == '\u00a7') {
            return -1;
        }
        if (c == ' ') {
            return 4;
        }
        int n = ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(c);
        if (n >= 0) {
            return this.a[n + 32];
        }
        return 0;
    }

    private static boolean isFormatColor(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F';
    }

    public String trimStringToWidth(String string, int n) {
        return this.trimStringToWidth(string, n, false);
    }

    public String trimStringToWidth(String string, int n, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        int n3 = bl ? string.length() - 1 : 0;
        int n4 = bl ? -1 : 1;
        boolean bl2 = false;
        boolean bl3 = false;
        for (int i = n3; i >= 0 && i < string.length() && n2 < n; i += n4) {
            char c = string.charAt(i);
            int n5 = this.getCharWidth(c);
            if (bl2) {
                bl2 = false;
                if (c != 'l' && c != 'L') {
                    if (c == 'r' || c == 'R') {
                        bl3 = false;
                    }
                } else {
                    bl3 = true;
                }
            } else if (n5 < 0) {
                bl2 = true;
            } else {
                n2 += n5;
                if (bl3) {
                    ++n2;
                }
            }
            if (n2 > n) break;
            if (bl) {
                stringBuilder.insert(0, c);
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}

