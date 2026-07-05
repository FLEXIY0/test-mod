/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import net.minecraft.client.d;

public final class C_j
extends Thread {
    private File a;
    private d b;
    private boolean c = false;

    public C_j(File file, d d2) {
        this.b = d2;
        this.setName("Resource download thread");
        this.setDaemon(true);
        this.a = new File(file, "resources/");
        if (!this.a.exists() && !this.a.mkdirs()) {
            throw new RuntimeException("The working directory could not be created: " + this.a);
        }
    }

    @Override
    public final void run() {
        try {
            String string;
            ArrayList<String> arrayList = new ArrayList<String>();
            URL uRL = new URL("https://vesuviusvenox.github.io/Classic-Resources/");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRL.openStream()));
            while ((string = bufferedReader.readLine()) != null) {
                arrayList.add(string);
            }
            bufferedReader.close();
            for (int i = 0; i < arrayList.size(); ++i) {
                block21: {
                    URL uRL2 = uRL;
                    String string2 = (String)arrayList.get(i);
                    URL uRL3 = uRL2;
                    try {
                        String string3;
                        String[] stringArray = string2.split(",");
                        String string4 = stringArray[0];
                        int n = Integer.parseInt(stringArray[1]);
                        Long.parseLong(stringArray[2]);
                        File file = new File(this.a, string4);
                        if (!file.exists() || file.length() != (long)n) {
                            file.getParentFile().mkdirs();
                            this.a(new URL(uRL3, string4.replaceAll(" ", "%20")), file);
                            if (this.c) break block21;
                        }
                        d d2 = this.b;
                        String string5 = string3 = string4;
                        d d3 = d2;
                        int n2 = string5.indexOf("/");
                        String string6 = string5.substring(0, n2);
                        string5 = string5.substring(n2 + 1);
                        if (string6.equalsIgnoreCase("sound")) {
                            d3.x.a(string5, file);
                        } else if (string6.equalsIgnoreCase("newsound")) {
                            d3.x.a(string5, file);
                        } else if (string6.equalsIgnoreCase("music")) {
                            d3.x.addMusic("music", string5, file);
                        } else if (string6.equalsIgnoreCase("newmusic")) {
                            d3.x.addMusic("newmusic", string5, file);
                        } else if (string6.equalsIgnoreCase("nightmusic")) {
                            d3.x.addMusic("nightmusic", string5, file);
                        } else if (string6.equalsIgnoreCase("creativemusic")) {
                            d3.x.addMusic("creativemusic", string5, file);
                        } else if (string6.equalsIgnoreCase("streaming")) {
                            d3.x.addStreaming(string5, file);
                        }
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
                if (!this.c) continue;
                return;
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private void a(URL uRL, File file) throws IOException {
        byte[] byArray = new byte[4096];
        DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));){
            do {
                int n;
                if ((n = dataInputStream.read(byArray)) < 0) {
                    dataInputStream.close();
                    dataOutputStream.close();
                    return;
                }
                dataOutputStream.write(byArray, 0, n);
            } while (!this.c);
        }
    }

    public final void a() {
        this.c = true;
    }
}

