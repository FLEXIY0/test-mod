/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.client.d;

public final class Lang {
    private static final Map<String, String> map = new HashMap<String, String>();
    private static final Map<String, String> always = new HashMap<String, String>();
    private static final List<String> codes = new ArrayList<String>();
    private static int index = 0;
    public static String current = "en_US";

    private static List<File> langDirs() {
        ArrayList<File> arrayList = new ArrayList<File>();
        try {
            arrayList.add(new File("lang"));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            arrayList.add(new File(System.getProperty("user.dir"), "lang"));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            arrayList.add(new File(d.getMinecraftDir(), "lang"));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return arrayList;
    }

    private static void init() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("en_US");
        linkedHashSet.add("ru_RU");
        for (File file : Lang.langDirs()) {
            File[] fileArray = file.listFiles();
            if (fileArray == null) continue;
            for (File file2 : fileArray) {
                String string = file2.getName();
                if (string.length() <= 5 || !string.toLowerCase().endsWith(".lang")) continue;
                linkedHashSet.add(string.substring(0, string.length() - 5));
            }
        }
        codes.clear();
        codes.addAll(linkedHashSet);
        String string = Lang.readSelection();
        if (string != null && codes.contains(string)) {
            current = string;
        }
        index = Math.max(0, codes.indexOf(current));
        Lang.load(current);
    }

    public static synchronized void load(String string) {
        map.clear();
        current = string;
        Lang.readResource(string);
        for (File file : Lang.langDirs()) {
            Lang.readFile(new File(file, string + ".lang"));
        }
        map.putAll(always);
    }

    private static void readResource(String string) {
        String string2 = "lang/" + string + ".lang";
        InputStream inputStream = null;
        try {
            ClassLoader classLoader = Lang.class.getClassLoader();
            if (classLoader != null) {
                inputStream = classLoader.getResourceAsStream(string2);
            }
            if (inputStream == null) {
                inputStream = Lang.class.getResourceAsStream("/" + string2);
            }
            if (inputStream == null) {
                inputStream = ClassLoader.getSystemResourceAsStream(string2);
            }
            if (inputStream != null) {
                Lang.parse(new InputStreamReader(inputStream, "UTF-8"));
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static void readFile(File file) {
        try {
            if (file != null && file.isFile()) {
                Lang.parse(new InputStreamReader((InputStream)new FileInputStream(file), "UTF-8"));
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static void parse(Reader reader) {
        try {
            String string;
            BufferedReader bufferedReader = new BufferedReader(reader);
            while ((string = bufferedReader.readLine()) != null) {
                int n;
                if (string.length() == 0 || string.charAt(0) == '#' || (n = string.indexOf(61)) <= 0) continue;
                String string2 = Lang.unescape(string.substring(0, n));
                String string3 = Lang.unescape(string.substring(n + 1));
                map.put(string2, string3);
            }
            bufferedReader.close();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static String unescape(String string) {
        return string.replace("\\n", "\n");
    }

    public static String tr(String string) {
        if (string == null) {
            return null;
        }
        String string2 = map.get(string);
        return string2 != null ? string2 : string;
    }

    public static synchronized void cycle() {
        if (codes.isEmpty()) {
            return;
        }
        index = (index + 1) % codes.size();
        Lang.load(codes.get(index));
        Lang.writeSelection(current);
    }

    public static String label() {
        String string = map.get("language.name");
        if (string == null) {
            string = current;
        }
        return "Language: " + string;
    }

    private static File selectionFile() {
        return new File(new File("lang"), "selected.txt");
    }

    private static String readSelection() {
        for (File file : Lang.langDirs()) {
            File file2 = new File(file, "selected.txt");
            try {
                if (!file2.isFile()) continue;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream)new FileInputStream(file2), "UTF-8"));
                String string = bufferedReader.readLine();
                bufferedReader.close();
                if (string == null || string.trim().length() <= 0) continue;
                return string.trim();
            }
            catch (Throwable throwable) {
            }
        }
        return null;
    }

    private static void writeSelection(String string) {
        try {
            File file = new File("lang");
            if (!file.exists()) {
                file.mkdirs();
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)new FileOutputStream(new File(file, "selected.txt")), "UTF-8");
            outputStreamWriter.write(string);
            ((Writer)outputStreamWriter).close();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    static {
        always.put("Mod by The Legacy+ Team", "");
        try {
            Lang.init();
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

