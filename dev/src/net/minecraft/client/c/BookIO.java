/*
 * File I/O for the Obsidian Book: "Save as" / "Load" via a native AWT file
 * dialog. The dialog runs on its own daemon thread so the game keeps rendering
 * and never shows "not responding"; the GUI polls the returned Result each
 * tick and applies it on the game thread.
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

    /** Async result, polled by the GUI each tick. */
    public static final class Result {
        public volatile boolean done;
        public volatile boolean cancelled;
        public volatile File file;      // save: written file; load: chosen file
        public volatile String content; // load: file text
        public volatile String error;
    }

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

    /** Open a Save-As dialog and write the markdown, off the game thread. */
    public static Result saveAsAsync(final String markdown, final String suggestedName) {
        final Result r = new Result();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File target = chooseSave(suggestedName);
                    if (target == null) {
                        r.cancelled = true;
                    } else {
                        Writer w = new OutputStreamWriter(new FileOutputStream(target), "UTF-8");
                        w.write(markdown);
                        w.close();
                        r.file = target;
                    }
                } catch (Throwable e) {
                    r.error = String.valueOf(e);
                } finally {
                    r.done = true;
                }
            }
        }, "obsidianbook-save");
        t.setDaemon(true);
        t.start();
        return r;
    }

    /** Open a Load dialog and read the chosen .md, off the game thread. */
    public static Result loadAsync() {
        final Result r = new Result();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File src = chooseOpen();
                    if (src == null) {
                        r.cancelled = true;
                    } else {
                        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(src), "UTF-8"));
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line).append('\n');
                        }
                        br.close();
                        r.file = src;
                        r.content = sb.toString();
                    }
                } catch (Throwable e) {
                    r.error = String.valueOf(e);
                } finally {
                    r.done = true;
                }
            }
        }, "obsidianbook-load");
        t.setDaemon(true);
        t.start();
        return r;
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
            String name = suggestedName == null ? "book.md" : suggestedName;
            if (!name.toLowerCase().endsWith(".md")) {
                name = name + ".md";
            }
            return new File(exportsDir(), name); // fallback: fixed folder
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
