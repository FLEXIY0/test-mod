/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;
import net.minecraft.client.d;

public final class GameWindowListener
extends WindowAdapter {
    final d mc;
    final Thread thread;

    public GameWindowListener(d d2, Thread thread) {
        this.mc = d2;
        this.thread = thread;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        try {
            Field field = this.mc.getClass().getDeclaredField("running");
            field.setAccessible(true);
            field.set(this.mc, false);
            this.thread.join();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        System.exit(0);
    }
}

