/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class ScreenShotHelper {
    private static DateFormat screenshotDate = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
    private static ByteBuffer screenshotSize;
    private static byte[] width;
    private static int[] height;

    public static String attemptScreenCapture(File file, int n, int n2) {
        try {
            File file2;
            File file3 = new File(file, "screenshots");
            file3.mkdir();
            if (screenshotSize == null || screenshotSize.capacity() < n * n2 * 3) {
                screenshotSize = BufferUtils.createByteBuffer((int)(n * n2 * 3));
                width = new byte[n * n2 * 3];
                height = new int[n * n2];
            }
            GL11.glPixelStorei((int)3333, (int)1);
            GL11.glPixelStorei((int)3317, (int)1);
            screenshotSize.clear();
            GL11.glReadPixels((int)0, (int)0, (int)n, (int)n2, (int)6407, (int)5121, (ByteBuffer)screenshotSize);
            screenshotSize.clear();
            String string = "" + screenshotDate.format(new Date());
            int n3 = 1;
            while ((file2 = new File(file3, string + (n3 == 1 ? "" : "_" + n3) + ".png")).exists()) {
                ++n3;
            }
            screenshotSize.get(width);
            for (n3 = 0; n3 < n; ++n3) {
                for (int i = 0; i < n2; ++i) {
                    int n4;
                    int n5 = n3 + (n2 - i - 1) * n;
                    int n6 = width[n5 * 3 + 0] & 0xFF;
                    int n7 = width[n5 * 3 + 1] & 0xFF;
                    int n8 = width[n5 * 3 + 2] & 0xFF;
                    ScreenShotHelper.height[n3 + i * n] = n4 = 0xFF000000 | n6 << 16 | n7 << 8 | n8;
                }
            }
            BufferedImage bufferedImage = new BufferedImage(n, n2, 1);
            bufferedImage.setRGB(0, 0, n, n2, height, 0, n);
            ImageIO.write((RenderedImage)bufferedImage, "png", file2);
            return "Saved screenshot as " + file2.getName();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "Failed to save: " + exception;
        }
    }
}

