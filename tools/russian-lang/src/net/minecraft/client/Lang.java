package net.minecraft.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * Runtime localization layer for Indev+.
 *
 * The whole UI is translated at a single choke point: the font renderer passes
 * every string through {@link #tr(String)} before drawing/measuring it. A
 * language is a UTF-8 ".lang" file of "English text=translated text" lines.
 * Built-in languages ship inside the jar under /lang/; users can add their own
 * by dropping <code>&lt;code&gt;.lang</code> files into a "lang" folder next to
 * the game (the working directory or the game directory).
 */
public final class Lang {
    private static final Map<String, String> map = new HashMap<String, String>();
    private static final Map<String, String> always = new HashMap<String, String>();
    private static final List<String> codes = new ArrayList<String>();
    private static int index = 0;
    public static String current = "en_US";

    static {
        // Overrides applied in every language (used to strip old branding).
        always.put("Mod by The Legacy+ Team", "");
        try {
            init();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static List<File> langDirs() {
        List<File> dirs = new ArrayList<File>();
        try { dirs.add(new File("lang")); } catch (Throwable t) {}
        try { dirs.add(new File(System.getProperty("user.dir"), "lang")); } catch (Throwable t) {}
        try { dirs.add(new File(net.minecraft.client.d.getMinecraftDir(), "lang")); } catch (Throwable t) {}
        return dirs;
    }

    private static void init() {
        LinkedHashSet<String> found = new LinkedHashSet<String>();
        found.add("en_US");
        found.add("ru_RU");
        for (File dir : langDirs()) {
            File[] files = dir.listFiles();
            if (files == null) continue;
            for (File f : files) {
                String n = f.getName();
                if (n.length() > 5 && n.toLowerCase().endsWith(".lang")) {
                    found.add(n.substring(0, n.length() - 5));
                }
            }
        }
        codes.clear();
        codes.addAll(found);
        String saved = readSelection();
        if (saved != null && codes.contains(saved)) {
            current = saved;
        }
        index = Math.max(0, codes.indexOf(current));
        load(current);
    }

    public static synchronized void load(String code) {
        map.clear();
        current = code;
        readResource(code);
        for (File dir : langDirs()) {
            readFile(new File(dir, code + ".lang"));
        }
        map.putAll(always);
    }

    private static void readResource(String code) {
        String path = "lang/" + code + ".lang";
        InputStream in = null;
        try {
            ClassLoader cl = Lang.class.getClassLoader();
            if (cl != null) in = cl.getResourceAsStream(path);        // no leading slash
            if (in == null) in = Lang.class.getResourceAsStream("/" + path);
            if (in == null) in = ClassLoader.getSystemResourceAsStream(path);
            if (in != null) parse(new InputStreamReader(in, "UTF-8"));
        } catch (Throwable t) {}
    }

    private static void readFile(File f) {
        try {
            if (f != null && f.isFile()) {
                parse(new InputStreamReader(new FileInputStream(f), "UTF-8"));
            }
        } catch (Throwable t) {}
    }

    private static void parse(Reader r) {
        try {
            BufferedReader br = new BufferedReader(r);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() == 0 || line.charAt(0) == '#') continue;
                int eq = line.indexOf('=');
                if (eq <= 0) continue;
                String k = unescape(line.substring(0, eq));
                String v = unescape(line.substring(eq + 1));
                map.put(k, v);
            }
            br.close();
        } catch (Throwable t) {}
    }

    private static String unescape(String s) {
        return s.replace("\\n", "\n");
    }

    /** Translate a UI string; returns the original if there is no mapping. */
    public static String tr(String s) {
        if (s == null) return null;
        String t = map.get(s);
        return t != null ? t : s;
    }

    /** Advance to the next available language and persist the choice. */
    public static synchronized void cycle() {
        if (codes.isEmpty()) return;
        index = (index + 1) % codes.size();
        load(codes.get(index));
        writeSelection(current);
    }

    /** Label shown on the main-menu language button. */
    public static String label() {
        String name = map.get("language.name");
        if (name == null) name = current;
        return "Language: " + name;
    }

    private static File selectionFile() {
        return new File(new File("lang"), "selected.txt");
    }

    private static String readSelection() {
        for (File dir : langDirs()) {
            File f = new File(dir, "selected.txt");
            try {
                if (f.isFile()) {
                    BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
                    String s = b.readLine();
                    b.close();
                    if (s != null && s.trim().length() > 0) return s.trim();
                }
            } catch (Throwable t) {}
        }
        return null;
    }

    private static void writeSelection(String code) {
        try {
            File dir = new File("lang");
            if (!dir.exists()) dir.mkdirs();
            Writer w = new OutputStreamWriter(new FileOutputStream(new File(dir, "selected.txt")), "UTF-8");
            w.write(code);
            w.close();
        } catch (Throwable t) {}
    }
}
