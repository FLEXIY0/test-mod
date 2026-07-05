/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import net.minecraft.client.a.C_c;
import net.minecraft.client.a.C_i;

final class C_j
extends Thread {
    private String a;
    private C_c b;
    private C_i c;

    C_j(C_i c_i, String string, C_c c_c) {
        this.c = c_i;
        this.a = string;
        this.b = c_c;
    }

    @Override
    public final void run() {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection)new URL(this.a).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 404) {
                this.c.a = this.b == null ? ImageIO.read(httpURLConnection.getInputStream()) : this.b.a(ImageIO.read(httpURLConnection.getInputStream()));
                return;
            }
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            httpURLConnection.disconnect();
        }
    }
}

