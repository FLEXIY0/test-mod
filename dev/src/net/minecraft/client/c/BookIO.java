/*
 * File I/O for the Obsidian Book: "Save as" (export Markdown) and "Load"
 * (import Markdown) using a native AWT file dialog. Works in windowed mode;
 * if the dialog is unavailable (e.g. fullscreen) it falls back to the game's
 * exports/ folder.
 */
package net.minecraft.client.c;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public final class BookIO {

    public static File exportsDir() {
        File dir;
        try {
            dir = new File(net.minecraft.client.d.getMinecraftDir(), "exports");
        } catch (Throwable t) {
            dir = new File("exports");
        }
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    /** Ask for a location and write the markdown. Returns the saved file, or null. */
    public static File saveAs(String markdown, String suggestedName) {
        File target = chooseSave(suggestedName);
        if (target == null) {
            return null;
        }
        try {
            Writer w = new OutputStreamWriter(new FileOutputStream(target), "UTF-8");
            w.write(markdown);
            w.close();
            return target;
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }

    /** Ask for a .md file and read it. Returns its text, or null if cancelled. */
    public static String load() {
        File src = chooseOpen();
        if (src == null) {
            return null;
        }
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(src), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                sb.append(line).append('\n');
            }
            r.close();
            return sb.toString();
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }

    private static File chooseSave(String suggestedName) {
        try {
            FileDialog fd = new FileDialog((Frame) null, "Save book as Markdown", FileDialog.SAVE);
            fd.setFile(suggestedName);
            fd.setVisible(true);
            String name = fd.getFile();
            String dir = fd.getDirectory();
            if (name == null) {
                return null; // cancelled
            }
            if (!name.toLowerCase().endsWith(".md")) {
                name = name + ".md";
            }
            return new File(dir, name);
        } catch (Throwable t) {
            // Fallback: exports/<suggested>
            String name = suggestedName == null ? "book.md" : suggestedName;
            if (!name.toLowerCase().endsWith(".md")) {
                name = name + ".md";
            }
            return new File(exportsDir(), name);
        }
    }

    private static File chooseOpen() {
        try {
            FileDialog fd = new FileDialog((Frame) null, "Load Markdown", FileDialog.LOAD);
            fd.setFile("*.md");
            fd.setVisible(true);
            String name = fd.getFile();
            String dir = fd.getDirectory();
            if (name == null) {
                return null;
            }
            return new File(dir, name);
        } catch (Throwable t) {
            return null;
        }
    }
}
