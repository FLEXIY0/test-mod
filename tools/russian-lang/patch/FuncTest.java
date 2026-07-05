import java.io.*;
import java.lang.reflect.*;
import java.net.*;

public class FuncTest {
    public static void main(String[] a) throws Exception {
        URL[] urls = { new File(a[0]).toURI().toURL(),
                       new File(a[1]).toURI().toURL(),
                       new File(a[2]).toURI().toURL() };
        URLClassLoader cl = new URLClassLoader(urls, ClassLoader.getSystemClassLoader());
        Class<?> L = Class.forName("net.minecraft.client.Lang", true, cl);
        Method tr = L.getMethod("tr", String.class);
        Method load = L.getMethod("load", String.class);
        Method label = L.getMethod("label");

        check("en default: Singleplayer passthrough", "Singleplayer", (String) tr.invoke(null, "Singleplayer"));
        load.invoke(null, "ru_RU");
        check("ru: Singleplayer",  "Одиночная игра",   (String) tr.invoke(null, "Singleplayer"));
        check("ru: Quit Game",     "Выйти из игры",    (String) tr.invoke(null, "Quit Game"));
        check("ru: book Done",     "Готово",           (String) tr.invoke(null, "Done"));
        check("ru: Enter Title",   "Введите название книги:", (String) tr.invoke(null, "Enter Book Title:"));
        check("branding removed",  "",                 (String) tr.invoke(null, "Mod by The Legacy+ Team"));
        check("unknown passthrough (chat)", "Привет игрок!", (String) tr.invoke(null, "Привет игрок!"));
        check("label ru",          "Language: Русский", (String) label.invoke(null));
        load.invoke(null, "en_US");
        check("en label",          "Language: English", (String) label.invoke(null));
        check("en: Singleplayer passthrough", "Singleplayer", (String) tr.invoke(null, "Singleplayer"));
        System.out.println(fails == 0 ? "ALL PASS" : (fails + " FAILURES"));
    }
    static int fails = 0;
    static void check(String name, String want, String got) {
        boolean ok = want.equals(got);
        if (!ok) fails++;
        System.out.println((ok ? "  ok   " : "  FAIL ") + name + "  ->  [" + got + "]");
    }
}
