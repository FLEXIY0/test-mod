/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AchievementMap {
    public static AchievementMap instance = new AchievementMap();
    private Map<Integer, String> guidMap = new HashMap<Integer, String>();

    private AchievementMap() {
        try {
            String string;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(AchievementMap.class.getResourceAsStream("/achievement/map.txt")));
            while ((string = bufferedReader.readLine()) != null) {
                String[] stringArray = string.split(",");
                int n = Integer.parseInt(stringArray[0]);
                this.guidMap.put(n, stringArray[1]);
            }
            bufferedReader.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static String getGuid(int n) {
        return AchievementMap.instance.guidMap.get(n);
    }
}

