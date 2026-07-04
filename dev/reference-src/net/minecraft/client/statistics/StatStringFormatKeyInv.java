/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package net.minecraft.client.statistics;

import net.minecraft.client.d;
import net.minecraft.client.statistics.IStatStringFormat;
import org.lwjgl.input.Keyboard;

public class StatStringFormatKeyInv
implements IStatStringFormat {
    final d mc;

    public StatStringFormatKeyInv(d d2) {
        this.mc = d2;
    }

    @Override
    public String formatString(String string) {
        try {
            return String.format(string, Keyboard.getKeyName((int)this.mc.w.n.b));
        }
        catch (Exception exception) {
            return "Error: " + exception.getLocalizedMessage();
        }
    }
}

