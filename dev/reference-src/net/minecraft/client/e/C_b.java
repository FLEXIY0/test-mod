/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.e;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.e.C_a;

public final class C_b {
    private Random a = new Random();
    private Map<String, ArrayList<C_a>> b = new HashMap<String, ArrayList<C_a>>();
    private List<C_a> allSoundPoolEntries = new ArrayList<C_a>();

    public final C_a a(String string, File file) {
        try {
            String string2 = string;
            string = string.substring(0, string.indexOf("."));
            while (Character.isDigit(string.charAt(string.length() - 1))) {
                string = string.substring(0, string.length() - 1);
            }
            if (!this.b.containsKey(string = string.replaceAll("/", "."))) {
                this.b.put(string, new ArrayList());
            }
            C_a c_a = new C_a(string2, file.toURI().toURL());
            ((List)this.b.get(string)).add(c_a);
            this.allSoundPoolEntries.add(c_a);
            return c_a;
        }
        catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
            throw new RuntimeException(malformedURLException);
        }
    }

    public final C_a a(String string) {
        List list = this.b.get(string);
        return list == null ? null : (C_a)list.get(this.a.nextInt(list.size()));
    }

    public C_a getRandomSound() {
        if (this.allSoundPoolEntries.size() == 0) {
            return null;
        }
        return this.allSoundPoolEntries.get(this.a.nextInt(this.allSoundPoolEntries.size()));
    }
}

