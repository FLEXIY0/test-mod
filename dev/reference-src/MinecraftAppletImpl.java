/*
 * Decompiled with CFR 0.152.
 */
import java.net.URL;
import net.minecraft.client.MinecraftApplet;

public class MinecraftAppletImpl
extends MinecraftApplet {
    private static final long serialVersionUID = 1L;

    @Override
    public URL getDocumentBase() {
        URL uRL;
        try {
            uRL = new URL("http://www.minecraft.net/game/");
        }
        catch (Exception exception) {
            uRL = null;
            exception.printStackTrace();
        }
        return uRL;
    }
}

