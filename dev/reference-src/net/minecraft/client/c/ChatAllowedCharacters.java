/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatAllowedCharacters {
    public static final String ALLOWED_CHARACTERS = ChatAllowedCharacters.getAllowedCharacters();
    public static final char[] ALLOWED_CHARACTERS_ARRAY = new char[]{'/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':'};

    private static String getAllowedCharacters() {
        String string = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ChatAllowedCharacters.class.getResourceAsStream("/font.txt"), "UTF-8"));
            String string2 = "";
            while ((string2 = bufferedReader.readLine()) != null) {
                if (string2.startsWith("#")) continue;
                string = string + string2;
            }
            bufferedReader.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
        return string;
    }

    public static boolean isAllowedCharacter(char c) {
        return c != '\u00a7' && (ALLOWED_CHARACTERS.indexOf(c) >= 0 || c > ' ');
    }

    public static String filter(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (!ChatAllowedCharacters.isAllowedCharacter(c)) continue;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}

