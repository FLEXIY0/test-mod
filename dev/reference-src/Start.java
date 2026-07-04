/*
 * Decompiled with CFR 0.152.
 */
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.io.File;
import java.lang.reflect.Field;
import net.minecraft.client.C_l;
import net.minecraft.client.d;

public class Start {
    public static void startMainThread1(String string, String string2) {
        Start.startMainThread(string, string2, null);
    }

    public static void startMainThread(String string, String string2, String string3) {
        try {
            Field field = d.class.getDeclaredField("minecraftDir");
            Field.setAccessible(new Field[]{field}, true);
            field.set(null, new File("."));
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        boolean bl = false;
        Frame frame = new Frame("Minecraft");
        Canvas canvas = new Canvas();
        frame.setLayout(new BorderLayout());
        frame.add((Component)canvas, "Center");
        canvas.setPreferredSize(new Dimension(854, 480));
        frame.pack();
        frame.setLocationRelativeTo(null);
        d d2 = new d(canvas, new MinecraftAppletImpl(), 854, 480, bl);
        Thread thread = new Thread((Runnable)d2, "Minecraft main thread");
        thread.setPriority(10);
        d2.k = false;
        d2.i = "www.minecraft.net";
        d2.h = string != null && string2 != null ? new C_l(string, string2) : new C_l("Player" + System.currentTimeMillis() % 1000L, "");
        if (string3 != null) {
            String[] stringArray = string3.split(":");
            d2.a(stringArray[0], Integer.parseInt(stringArray[1]));
        }
        frame.setVisible(true);
        frame.addWindowListener(new GameWindowListener(d2, thread));
        thread.start();
    }

    public static void main(String[] stringArray) {
        String string = "Player" + System.currentTimeMillis() % 1000L;
        if (stringArray.length > 0) {
            string = stringArray[0];
        }
        String string2 = "-";
        if (stringArray.length > 1) {
            string2 = stringArray[1];
        }
        Start.startMainThread1(string, string2);
    }
}

