/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import net.minecraft.client.a.C_c;
import net.minecraft.client.a.c.C_b;
import net.minecraft.client.a.c.C_i;
import net.minecraft.client.a.c.C_l;
import net.minecraft.client.d;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class RenderEngine {
    private HashMap<Object, Integer> a = new HashMap();
    private HashMap<Object, BufferedImage> b = new HashMap();
    private IntBuffer c = BufferUtils.createIntBuffer((int)1);
    private ByteBuffer d = BufferUtils.createByteBuffer((int)0x1000000);
    private List<C_b> e = new ArrayList<C_b>();
    private Map<String, Object> f = new HashMap<String, Object>();
    private boolean h = false;
    private C_l texturePackList;

    public RenderEngine(C_l c_l) {
        this.texturePackList = c_l;
    }

    public final int a(String string) {
        C_i c_i = this.texturePackList.selectedTexturePack;
        Integer n = this.a.get(string);
        if (n != null) {
            return n;
        }
        try {
            this.c.clear();
            GL11.glGenTextures((IntBuffer)this.c);
            int n2 = this.c.get(0);
            if (string.startsWith("##")) {
                this.a(RenderEngine.a(ImageIO.read(c_i.getResourceAsStream(string.substring(2)))), n2);
            } else if (string.startsWith("%%")) {
                this.h = true;
                this.a(ImageIO.read(c_i.getResourceAsStream(string.substring(2))), n2);
                this.h = false;
            } else {
                this.a(ImageIO.read(c_i.getResourceAsStream(string)), n2);
            }
            this.a.put(string, n2);
            return n2;
        }
        catch (IOException iOException) {
            throw new RuntimeException("!!");
        }
    }

    public final int getExternalTexture(String string) {
        Integer n = this.a.get(string);
        if (n != null) {
            return n;
        }
        try {
            this.c.clear();
            GL11.glGenTextures((IntBuffer)this.c);
            int n2 = this.c.get(0);
            if (string.startsWith("##")) {
                this.a(RenderEngine.a(ImageIO.read(new File(net.minecraft.client.d.getMinecraftDir(), string))), n2);
            } else if (string.startsWith("%%")) {
                this.h = true;
                this.a(ImageIO.read(new File(net.minecraft.client.d.getMinecraftDir(), string)), n2);
                this.h = false;
            } else {
                this.a(ImageIO.read(new File(net.minecraft.client.d.getMinecraftDir(), string)), n2);
            }
            this.a.put(string, n2);
            return n2;
        }
        catch (IOException iOException) {
            System.out.println(string);
            throw new RuntimeException("!!");
        }
    }

    public void delete(int n) {
        this.b.remove(n);
        this.c.clear();
        this.c.put(n);
        this.c.flip();
        GL11.glDeleteTextures((IntBuffer)this.c);
    }

    public final int getTexture(BufferedImage bufferedImage) {
        this.c.clear();
        GL11.glGenTextures((IntBuffer)this.c);
        int n = this.c.get(0);
        this.a(bufferedImage, n);
        this.b.put(n, bufferedImage);
        return n;
    }

    private static BufferedImage a(BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth() / 16;
        BufferedImage bufferedImage2 = new BufferedImage(16, bufferedImage.getHeight() * n, 2);
        Graphics graphics = bufferedImage2.getGraphics();
        for (int i = 0; i < n; ++i) {
            graphics.drawImage(bufferedImage, -i << 4, i * bufferedImage.getHeight(), null);
        }
        graphics.dispose();
        return bufferedImage2;
    }

    private void a(BufferedImage bufferedImage, int n) {
        GL11.glBindTexture((int)3553, (int)n);
        GL11.glTexParameteri((int)3553, (int)10241, (int)9728);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9728);
        if (this.h) {
            GL11.glTexParameteri((int)3553, (int)10242, (int)10496);
            GL11.glTexParameteri((int)3553, (int)10243, (int)10496);
        } else {
            GL11.glTexParameteri((int)3553, (int)10242, (int)10497);
            GL11.glTexParameteri((int)3553, (int)10243, (int)10497);
        }
        n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int[] nArray = new int[n * n2];
        byte[] byArray = new byte[n * n2 << 2];
        bufferedImage.getRGB(0, 0, n, n2, nArray, 0, n);
        for (int i = 0; i < nArray.length; ++i) {
            int n3 = nArray[i] >>> 24;
            int n4 = nArray[i] >> 16 & 0xFF;
            int n5 = nArray[i] >> 8 & 0xFF;
            int n6 = nArray[i] & 0xFF;
            byArray[i << 2] = (byte)n4;
            byArray[(i << 2) + 1] = (byte)n5;
            byArray[(i << 2) + 2] = (byte)n6;
            byArray[(i << 2) + 3] = (byte)n3;
        }
        this.d.clear();
        this.d.put(byArray);
        this.d.position(0).limit(byArray.length);
        GL11.glTexImage2D((int)3553, (int)0, (int)6408, (int)n, (int)n2, (int)0, (int)6408, (int)5121, (ByteBuffer)this.d);
    }

    public final int a(String string, String string2) {
        net.minecraft.client.a.C_i c_i = (net.minecraft.client.a.C_i)this.f.get(string);
        if (c_i != null && c_i.a != null && !c_i.d) {
            if (c_i.c < 0) {
                BufferedImage bufferedImage = c_i.a;
                this.c.clear();
                GL11.glGenTextures((IntBuffer)this.c);
                int n = this.c.get(0);
                this.a(bufferedImage, n);
                this.b.put(n, bufferedImage);
                c_i.c = n;
            } else {
                this.a(c_i.a, c_i.c);
            }
            c_i.d = true;
        }
        return c_i != null && c_i.c >= 0 ? c_i.c : this.a(string2);
    }

    public final net.minecraft.client.a.C_i a(String string, C_c c_c) {
        net.minecraft.client.a.C_i c_i = (net.minecraft.client.a.C_i)this.f.get(string);
        if (c_i == null) {
            this.f.put(string, new net.minecraft.client.a.C_i(string, c_c));
        } else {
            ++c_i.b;
        }
        return c_i;
    }

    public final void b(String string) {
        net.minecraft.client.a.C_i c_i = (net.minecraft.client.a.C_i)this.f.get(string);
        if (c_i != null) {
            --c_i.b;
            if (c_i.b == 0) {
                if (c_i.c >= 0) {
                    int n = c_i.c;
                    this.b.remove(n);
                    this.c.clear();
                    this.c.put(n);
                    this.c.flip();
                    GL11.glDeleteTextures((IntBuffer)this.c);
                }
                this.f.remove(string);
            }
        }
    }

    public final void a(C_b c_b) {
        this.e.add(c_b);
        c_b.a();
    }

    public final void a() {
        C_b c_b;
        int n;
        for (n = 0; n < this.e.size(); ++n) {
            c_b = this.e.get(n);
            c_b.a();
            this.d.clear();
            this.d.put(c_b.a);
            this.d.position(0).limit(c_b.a.length);
            GL11.glTexSubImage2D((int)3553, (int)0, (int)(c_b.b % 32 << 4), (int)(c_b.b / 32 << 4), (int)16, (int)16, (int)6408, (int)5121, (ByteBuffer)this.d);
        }
        for (n = 0; n < this.e.size(); ++n) {
            c_b = this.e.get(n);
            if (c_b.d <= 0) continue;
            this.d.clear();
            this.d.put(c_b.a);
            this.d.position(0).limit(c_b.a.length);
            GL11.glBindTexture((int)3553, (int)c_b.d);
            GL11.glTexSubImage2D((int)3553, (int)0, (int)0, (int)0, (int)16, (int)16, (int)6408, (int)5121, (ByteBuffer)this.d);
        }
    }

    public final void b() {
        BufferedImage bufferedImage;
        int n;
        C_i c_i = this.texturePackList.selectedTexturePack;
        Iterator<Object> iterator = this.b.keySet().iterator();
        while (iterator.hasNext()) {
            n = (Integer)iterator.next();
            bufferedImage = this.b.get(n);
            this.a(bufferedImage, n);
        }
        iterator = this.f.values().iterator();
        while (iterator.hasNext()) {
            ((net.minecraft.client.a.C_i)iterator.next()).d = false;
        }
        for (String string : this.a.keySet()) {
            try {
                if (string.startsWith("##")) {
                    bufferedImage = RenderEngine.a(ImageIO.read(c_i.getResourceAsStream(string.substring(2))));
                } else if (string.startsWith("%%")) {
                    this.h = true;
                    bufferedImage = ImageIO.read(c_i.getResourceAsStream(string.substring(2)));
                } else {
                    bufferedImage = ImageIO.read(c_i.getResourceAsStream(string));
                }
                n = this.a.get(string);
                this.a(bufferedImage, n);
                this.h = false;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static void a(int n) {
        if (n >= 0) {
            GL11.glBindTexture((int)3553, (int)n);
        }
    }
}

