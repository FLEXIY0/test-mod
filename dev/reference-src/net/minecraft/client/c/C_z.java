/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import java.util.HashMap;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.a.C_a;
import net.minecraft.a.c.a.C_b;
import net.minecraft.a.c.a.C_c;
import net.minecraft.a.c.a.C_d;
import net.minecraft.a.c.a.C_f;
import net.minecraft.a.c.a.C_g;
import net.minecraft.a.c.a.C_h;
import net.minecraft.a.c.a.C_j;
import net.minecraft.a.c.a.C_k;
import net.minecraft.a.c.a.C_m;
import net.minecraft.a.c.b.C_i;
import net.minecraft.client.C_l;
import net.minecraft.client.c.C_t;
import net.minecraft.client.c.C_u;
import net.minecraft.client.c.C_v;
import net.minecraft.client.c.C_w;
import net.minecraft.client.c.C_x;
import net.minecraft.client.c.C_y;
import net.minecraft.client.d;
import net.minecraft.game.entity.md3.EntityBeastBoy;
import net.minecraft.game.entity.md3.EntityBlackSteve;
import net.minecraft.game.entity.md3.EntityRana;
import net.minecraft.game.entity.md3.EntitySteve;

public class C_z {
    private static HashMap<String, Integer> gametype = new C_t();
    private static HashMap<String, Integer> difficulty = new C_u();
    private static HashMap<String, Integer> season = new C_v();
    private static HashMap<String, Integer> time = new C_w();
    private static HashMap<String, net.minecraft.a.a.b.Block> blocksList = new C_x();
    private static HashMap<String, Integer> blocksData = new C_y();

    public static void executeCommand(d d2, String string) {
        boolean bl = false;
        while (string.startsWith("/")) {
            string = string.substring(1);
        }
        String[] stringArray = string.split(" ");
        try {
            int n;
            if (stringArray[0].equalsIgnoreCase("help") || stringArray[0].equalsIgnoreCase("?")) {
                d2.t.addChatMessage("\u00a7e/gamemode \u00a7f<gamemode>");
                d2.t.addChatMessage("\u00a7e/difficulty \u00a7f<difficulty>");
                d2.t.addChatMessage("\u00a7e/spawn \u00a7f<mob>");
                d2.t.addChatMessage("\u00a7e/teleport \u00a7f<x> <y> <z>");
                d2.t.addChatMessage("\u00a7e/give \u00a7f<item_name> <count>");
                d2.t.addChatMessage("\u00a7e/time \u00a7f<add/set/query/freeze>");
                d2.t.addChatMessage("\u00a7e/season \u00a7f<season/time/state>");
                d2.t.addChatMessage("\u00a7e/weather \u00a7f<state>");
                d2.t.addChatMessage("\u00a7e/bloodmoon \u00a7f<state>");
                d2.t.addChatMessage("\u00a7e/physics \u00a7f<state>");
                d2.t.addChatMessage("\u00a7e/ai \u00a7f<state>");
                d2.t.addChatMessage("\u00a7e/fill \u00a7f<from> <to> <block_name> <hollow/destroy/replace/keep>");
                d2.t.addChatMessage("\u00a7e/score \u00a7f<amount>");
                d2.t.addChatMessage("\u00a7e/heal \u00a7f<amount>");
                d2.t.addChatMessage("\u00a7e/kill \u00a7f<specify>");
                d2.t.addChatMessage("\u00a7e/keepinventory \u00a7f<state>");
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("gamemode")) {
                if (gametype.get(stringArray[1].toLowerCase()) != null) {
                    n = gametype.get(stringArray[1].toLowerCase());
                    if (n < 3) {
                        d2.f.gamemode = n;
                        d2.d.gamemode = n;
                        d2.a = net.minecraft.client.dx.C_a.get(d2, d2.f.gamemode);
                        d2.a.a(d2.d);
                        d2.a.a(d2.f);
                        if (n < 2) {
                            d2.f.isFlying = false;
                            d2.f.F = false;
                        }
                        d2.t.addChatMessage("Changed gamemode to \u00a7e" + stringArray[1].toLowerCase());
                    }
                } else {
                    d2.t.addChatMessage("\u00a7cInvalid gamemode!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("difficulty")) {
                if (difficulty.get(stringArray[1].toLowerCase()) != null) {
                    n = difficulty.get(stringArray[1].toLowerCase());
                    if (n < 4) {
                        d2.f.difficulty = n;
                        d2.t.addChatMessage("Changed difficulty to \u00a7e" + stringArray[1].toLowerCase());
                    }
                } else {
                    d2.t.addChatMessage("\u00a7cInvalid difficulty!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("spawn")) {
                float f = d2.f.h;
                float f2 = d2.f.i;
                float f3 = d2.f.j;
                switch (stringArray[1].toLowerCase()) {
                    case "pig": {
                        d2.d.spawnEntityInWorld(new net.minecraft.a.c.b.C_c(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Derpy piggu. Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "sheep": {
                        d2.d.spawnEntityInWorld(new net.minecraft.a.c.b.C_b(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Stop eating so muich grass! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "cow": {
                        d2.d.spawnEntityInWorld(new net.minecraft.a.c.b.C_e(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Kazooo! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "mooshroom": {
                        d2.d.spawnEntityInWorld(new net.minecraft.a.c.b.C_k(d2.d, f, f2, f3));
                        d2.t.addChatMessage("A cow with a nasty infection! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "moobloom": {
                        d2.d.spawnEntityInWorld(new net.minecraft.a.c.b.C_j(d2.d, f, f2, f3));
                        d2.t.addChatMessage("A mob forgotten by Mojang! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "duck": {
                        d2.d.spawnEntityInWorld(new net.minecraft.a.c.b.C_f(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Duck fact: Ducks are cool! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "fox": {
                        d2.d.spawnEntityInWorld(new net.minecraft.a.c.b.C_h(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Because foxes are based. Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "bat": {
                        d2.d.spawnEntityInWorld(new net.minecraft.a.c.b.C_d(d2.d, f, f2, f3));
                        d2.t.addChatMessage("More than just ambience! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "zombie": {
                        d2.d.spawnEntityInWorld(new C_f(d2.d, f, f2, f3));
                        d2.t.addChatMessage("The zombies ate your brains! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "mummy": {
                        d2.d.spawnEntityInWorld(new C_k(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Return the slab! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "skeleton": {
                        d2.d.spawnEntityInWorld(new C_c(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Also known as aimbot spam. Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "spider": {
                        d2.d.spawnEntityInWorld(new C_b(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Spider bit me! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "slime": {
                        d2.d.spawnEntityInWorld(new C_m(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Plop, plop, plop! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "jellyfish": {
                        d2.d.spawnEntityInWorld(new C_i(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Better than squids! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "fish": {
                        d2.d.spawnEntityInWorld(new net.minecraft.a.c.b.C_g(d2.d, f, f2, f3));
                        d2.t.addChatMessage("You'll be swimming with the fishes! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "antlion": {
                        d2.d.spawnEntityInWorld(new C_g(d2.d, f, f2, f3));
                        d2.t.addChatMessage("They came from the sands! Spawned an \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "fire_imp": {
                        d2.d.spawnEntityInWorld(new C_j(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Prepare for a fiery demise! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "harpy": {
                        d2.d.spawnEntityInWorld(new C_h(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Death from above! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "creeper": {
                        d2.d.spawnEntityInWorld(new C_d(d2.d, f, f2, f3));
                        d2.t.addChatMessage("SssSSsSspawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "human": {
                        d2.d.spawnEntityInWorld(new C_e(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Often mistaken for Herobrine. Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "monster": {
                        d2.d.spawnEntityInWorld(new net.minecraft.a.c.a.C_e(d2.d, f, f2, f3));
                        d2.t.addChatMessage("Often mistaken for Herobrine. Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "steve": {
                        d2.d.spawnEntityInWorld(new EntitySteve(d2.d, f, f2, f3));
                        d2.t.addChatMessage("A relic from the past! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "black_steve": {
                        d2.d.spawnEntityInWorld(new EntityBlackSteve(d2.d, f, f2, f3));
                        d2.t.addChatMessage("A relic from the past! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "beast_boy": {
                        d2.d.spawnEntityInWorld(new EntityBeastBoy(d2.d, f, f2, f3));
                        d2.t.addChatMessage("A relic from the past! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "rana": {
                        d2.d.spawnEntityInWorld(new EntityRana(d2.d, f, f2, f3));
                        d2.t.addChatMessage("It's everyone's favorite frog girl! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    case "giant": {
                        d2.d.spawnEntityInWorld(new C_a(d2.d, f, f2, f3));
                        d2.t.addChatMessage("It's a giant zombie! RUN!!! Spawned a \u00a7e" + stringArray[1]);
                        break;
                    }
                    default: {
                        d2.t.addChatMessage("\u00a7cInvalid mob!");
                    }
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("teleport") || stringArray[0].equalsIgnoreCase("tp")) {
                try {
                    int n2 = Integer.parseInt(stringArray[1]);
                    int n3 = Integer.parseInt(stringArray[2]);
                    int n4 = Integer.parseInt(stringArray[3]);
                    if (n2 <= d2.d.a && n4 <= d2.d.b && n3 <= d2.d.c && n2 >= 0 && n4 >= 0 && n3 >= 0 && !d2.d.isSolidTile(n2, n3 + 1, n4)) {
                        d2.f.b(n2, n3, n4);
                        d2.t.addChatMessage("Wooosh! Teleported player to \u00a7e" + n2 + "x, " + n3 + " y, " + n4 + " z.");
                    } else {
                        d2.t.addChatMessage("\u00a7cSpace is occupied by a solid tile!");
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    d2.t.addChatMessage("\u00a7cCoordinates must be in numbers!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("give")) {
                try {
                    int n5 = Integer.parseInt(stringArray[2]);
                    boolean bl2 = true;
                    block80: for (int i = 0; i < 1024; ++i) {
                        Object object = Item.b[i];
                        if (i < 256) {
                            net.minecraft.a.a.b.Block c_x = net.minecraft.a.a.b.Block.c[i];
                            bl2 = c_x == null || C_l.a.contains(c_x);
                        }
                        if (object == null || !bl2) continue;
                        for (int j = 0; j < ((Item)object).getSubtypes() + 1; ++j) {
                            String string2 = ((Item)object).getItemName(j).toLowerCase().replace(" ", "_");
                            if (string2.startsWith(String.valueOf('\u00a7'))) {
                                string2 = string2.substring(2);
                            }
                            if (!stringArray[1].toLowerCase().equals(string2)) continue;
                            if (n5 > ((Item)object).c()) {
                                n5 = ((Item)object).c();
                            }
                            ItemStack itemStack = new ItemStack((Item)object, n5, j);
                            d2.f.b.a(itemStack);
                            d2.t.addChatMessage("Here's some \u00a7e" + ((Item)object).getItemName(j) + " " + '\u00a7' + "fyou wankah!");
                            continue block80;
                        }
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    d2.t.addChatMessage("\u00a7cCount must be in numbers!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("time")) {
                block191: {
                    if (stringArray[1].equalsIgnoreCase("set")) {
                        if (time.get(stringArray[2].toLowerCase()) != null) {
                            d2.d.D = time.get(stringArray[2].toLowerCase());
                            d2.t.addChatMessage("Time set to \u00a7e" + stringArray[2]);
                        } else {
                            try {
                                int n6 = Integer.parseInt(stringArray[2]);
                                if (n6 > 24000 || n6 < 0) {
                                    d2.t.addChatMessage("\u00a7cTime cannot exceed 24000 or subceed 0!");
                                    break block191;
                                }
                                d2.d.D = n6;
                                d2.t.addChatMessage("Time set to \u00a7e" + stringArray[2]);
                            }
                            catch (NumberFormatException numberFormatException) {
                                d2.t.addChatMessage("\u00a7cTime must be in numbers!");
                            }
                        }
                    } else if (stringArray[1].equalsIgnoreCase("add")) {
                        try {
                            int n7 = Integer.parseInt(stringArray[2]);
                            d2.d.D += n7;
                            d2.t.addChatMessage("Added \u00a7e" + stringArray[2] + " to world time");
                        }
                        catch (NumberFormatException numberFormatException) {
                            d2.t.addChatMessage("\u00a7cTime must be in numbers!");
                        }
                    } else if (stringArray[1].equalsIgnoreCase("query")) {
                        d2.t.addChatMessage("Current time is \u00a7e" + d2.d.D);
                    } else if (stringArray[1].equalsIgnoreCase("freeze")) {
                        if (d2.d.type == 8) {
                            d2.d.A = 0;
                            d2.d.B = 0;
                            d2.d.A = -1;
                        } else {
                            d2.d.A = 15;
                            d2.d.B = 15;
                            d2.d.A = 16;
                        }
                        d2.t.addChatMessage("Welcome to paradise! Eternal daylight \u00a7eenabled. ");
                    } else if (stringArray[1].equalsIgnoreCase("unfreeze")) {
                        if (d2.d.type == 8) {
                            d2.d.A = 0;
                            d2.d.B = 0;
                        } else {
                            d2.d.A = 15;
                            d2.d.B = 15;
                        }
                        d2.t.addChatMessage("Eternal daylight \u00a7cdisabled. ");
                    } else {
                        d2.t.addChatMessage("\u00a7cInvalid time command!");
                    }
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("season")) {
                if (season.get(stringArray[1].toLowerCase()) != null) {
                    int n8 = season.get(stringArray[1].toLowerCase());
                    if (n8 < 4 && !d2.d.season.seasonsDisabled) {
                        d2.d.season.seasonTime = 720000 * n8;
                        d2.t.addChatMessage("Changed season to \u00a7e" + stringArray[1].toLowerCase());
                    } else {
                        d2.t.addChatMessage("\u00a7cCannot change season! Please enable them using /season on");
                    }
                } else if (stringArray[1].equalsIgnoreCase("time")) {
                    block192: {
                        if (stringArray[2].equalsIgnoreCase("add")) {
                            try {
                                int n9 = Integer.parseInt(stringArray[3]);
                                if (n9 > 2880000 || n9 < 0) {
                                    d2.t.addChatMessage("\u00a7cSeason time cannot exceed 2880000 or subceed 0!");
                                    break block192;
                                }
                                d2.d.season.seasonTime += n9;
                                d2.t.addChatMessage("Added \u00a7e" + n9 + '\u00a7' + "f to season time");
                            }
                            catch (NumberFormatException numberFormatException) {
                                d2.t.addChatMessage("\u00a7cTime must be in numbers!");
                            }
                        } else {
                            try {
                                int n10 = Integer.parseInt(stringArray[2]);
                                if (n10 > 2880000 || n10 < 0) {
                                    d2.t.addChatMessage("\u00a7cSeason time cannot exceed 2880000 or subceed 0!");
                                } else {
                                    d2.d.season.seasonTime = n10;
                                    d2.t.addChatMessage("Season time set to \u00a7e" + stringArray[2]);
                                }
                            }
                            catch (NumberFormatException numberFormatException) {
                                d2.t.addChatMessage("\u00a7cTime must be in numbers!");
                            }
                        }
                    }
                    bl = true;
                } else if (stringArray[1].equalsIgnoreCase("off")) {
                    d2.d.season.seasonsDisabled = true;
                    d2.t.addChatMessage("Seasons set to \u00a7cOFF");
                } else if (stringArray[1].equalsIgnoreCase("on")) {
                    d2.d.season.seasonsDisabled = false;
                    d2.t.addChatMessage("Seasons set to \u00a7eON");
                } else {
                    d2.t.addChatMessage("\u00a7cInvalid season command!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("weather")) {
                if (stringArray[1].equalsIgnoreCase("rain")) {
                    d2.d.setRainTime(1);
                    d2.t.addChatMessage("\u00a7eYou did a little rain dance!");
                } else if (stringArray[1].equalsIgnoreCase("thunder")) {
                    d2.d.setRaining(true);
                    d2.d.setThundering(true);
                    d2.t.addChatMessage("\u00a7eThe Gods are angry with you!");
                } else if (stringArray[1].equalsIgnoreCase("clear")) {
                    d2.d.setRaining(false);
                    d2.d.setThundering(false);
                    d2.t.addChatMessage("\u00a7eThe skies have cleared!");
                } else if (stringArray[1].equalsIgnoreCase("fog")) {
                    d2.d.setFogTime(0);
                    d2.t.addChatMessage("\u00a7eToggled fog!");
                } else if (stringArray[1].equalsIgnoreCase("wind")) {
                    d2.d.setWindTime(0);
                    d2.t.addChatMessage("\u00a7eToggled wind!");
                } else if (stringArray[1].equalsIgnoreCase("freeze")) {
                    d2.d.freezeWeatherUpdates = true;
                    d2.t.addChatMessage("\u00a7eWeather has been \u00a7cdisabled!");
                } else if (stringArray[1].equalsIgnoreCase("unfreeze")) {
                    d2.d.freezeWeatherUpdates = false;
                    d2.t.addChatMessage("\u00a7eWeather has been \u00a7aenabled!");
                } else {
                    d2.t.addChatMessage("\u00a7cInvalid weather!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("bloodmoon")) {
                if (stringArray[1].equalsIgnoreCase("1") || stringArray[1].equalsIgnoreCase("on")) {
                    d2.d.setBloodMoon(true);
                    d2.t.addChatMessage("\u00a7cThe blood moon is rising..");
                } else if (stringArray[1].equalsIgnoreCase("0") || stringArray[1].equalsIgnoreCase("off")) {
                    d2.d.setBloodMoon(false);
                    d2.t.addChatMessage("\u00a7eThe blood moon has subceeded!");
                } else {
                    d2.t.addChatMessage("\u00a7cInvalid state!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("physics")) {
                if (stringArray[1].equalsIgnoreCase("1") || stringArray[1].equalsIgnoreCase("on")) {
                    d2.d.physicsDisabled = false;
                    d2.t.addChatMessage("Level physics set to \u00a7eON");
                } else if (stringArray[1].equalsIgnoreCase("0") || stringArray[1].equalsIgnoreCase("off")) {
                    d2.d.physicsDisabled = true;
                    d2.t.addChatMessage("Level physics set to \u00a7cOFF");
                } else {
                    d2.t.addChatMessage("\u00a7cInvalid state!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("ai")) {
                if (stringArray[1].equalsIgnoreCase("1") || stringArray[1].equalsIgnoreCase("on")) {
                    d2.d.AIDisabled = false;
                    d2.t.addChatMessage("Mob AI set to \u00a7eON");
                } else if (stringArray[1].equalsIgnoreCase("0") || stringArray[1].equalsIgnoreCase("off")) {
                    d2.d.AIDisabled = true;
                    d2.t.addChatMessage("Mob AI set to \u00a7cOFF");
                } else {
                    d2.t.addChatMessage("\u00a7cInvalid state!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("keepinventory")) {
                if (stringArray[1].equalsIgnoreCase("1") || stringArray[1].equalsIgnoreCase("on")) {
                    d2.f.keepInventory = true;
                    d2.t.addChatMessage("Keep inventory turned \u00a7eON");
                } else if (stringArray[1].equalsIgnoreCase("0") || stringArray[1].equalsIgnoreCase("off")) {
                    d2.f.keepInventory = false;
                    d2.t.addChatMessage("Keep inventory turned \u00a7cOFF");
                } else {
                    d2.t.addChatMessage("\u00a7cInvalid state!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("score")) {
                try {
                    int n11 = Integer.parseInt(stringArray[1]);
                    if (n11 <= 0) {
                        d2.t.addChatMessage("\u00a7cScore cannot be negative!");
                    } else {
                        d2.f.P += n11;
                        d2.t.addChatMessage("Level up! Score increased by \u00a7e" + n11);
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    d2.t.addChatMessage("\u00a7cScore must be in numbers!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("heal")) {
                try {
                    int n12 = Integer.parseInt(stringArray[1]);
                    if (n12 <= 0) {
                        d2.t.addChatMessage("\u00a7cHealth cannot be negative!");
                    } else {
                        d2.f.b(n12);
                        d2.t.addChatMessage("I need a medic! Healed player for \u00a7e" + n12);
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    d2.t.addChatMessage("\u00a7cHealth must be in numbers!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("kill")) {
                try {
                    if (stringArray[1].equalsIgnoreCase("all")) {
                        d2.d.r.removeAll();
                        d2.t.addChatMessage("\u00a7eDestroyer of worlds! Killed all living entities.");
                    } else {
                        d2.t.addChatMessage("\u00a7cInvalid command!");
                    }
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    d2.f.attackEntityFrom(null, 1000, 0.0f);
                    d2.t.addChatMessage("\u00a7cOOF!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("fill")) {
                try {
                    int n13 = Integer.parseInt(stringArray[1]);
                    int n14 = Integer.parseInt(stringArray[2]);
                    int n15 = Integer.parseInt(stringArray[3]);
                    int n16 = Integer.parseInt(stringArray[4]);
                    int n17 = Integer.parseInt(stringArray[5]);
                    int n18 = Integer.parseInt(stringArray[6]);
                    for (int i = Math.min(n13, n16); i <= Math.max(n13, n16); ++i) {
                        for (int j = Math.min(n14, n17); j <= Math.max(n14, n17); ++j) {
                            for (int k = Math.min(n15, n18); k <= Math.max(n15, n18); ++k) {
                                int n19 = d2.d.a(i, j, k);
                                byte by = d2.d.e(i, j, k);
                                if (blocksList.get(stringArray[7].toLowerCase()) != null) {
                                    net.minecraft.a.a.b.Block c_x = blocksList.get(stringArray[7].toLowerCase());
                                    int n20 = blocksData.get(stringArray[7].toLowerCase());
                                    if (stringArray.length > 8) {
                                        if (stringArray.length > 9) {
                                            net.minecraft.a.a.b.Block c_x2 = blocksList.get(stringArray[9].toLowerCase());
                                            int n21 = blocksData.get(stringArray[9].toLowerCase());
                                            if (stringArray[8].equalsIgnoreCase("replace") && n19 == c_x.at && n20 == by) {
                                                d2.d.setBlockAndMetadata(i, j, k, c_x2.at, n21);
                                            }
                                            if (stringArray[8].equalsIgnoreCase("keep") && n19 != c_x2.at && n21 != by) {
                                                d2.d.setBlockAndMetadata(i, j, k, c_x.at, n20);
                                            }
                                        }
                                        if (!stringArray[8].equalsIgnoreCase("destroy") || n19 != c_x.at || n20 != by) continue;
                                        d2.d.a(i, j, k, 0);
                                        continue;
                                    }
                                    d2.d.setBlockAndMetadata(i, j, k, c_x.at, n20);
                                    continue;
                                }
                                if (!stringArray[7].equalsIgnoreCase("hollow")) continue;
                                d2.d.a(i, j, k, 0);
                            }
                        }
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    d2.t.addChatMessage("\u00a7cCoordinates must be in numbers!");
                }
                catch (NullPointerException nullPointerException) {
                    d2.t.addChatMessage("\u00a7cBlock does not exist!");
                }
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("clear")) {
                for (int i = 0; i < d2.f.b.a(); ++i) {
                    if (d2.f.b.a(i) == null) continue;
                    d2.f.b.a(i, null);
                }
                d2.t.addChatMessage("\u00a7ePlayer inventory has been cleared.");
                bl = true;
            }
            if (stringArray[0].equalsIgnoreCase("imagine")) {
                d2.d.spawnEntityInWorld(new net.minecraft.a.c.c.C_a(d2.d, d2.f.h, d2.f.i + 5.0f, d2.f.j, 30));
                d2.t.addChatMessage("\u00a75Imagine \u00a7fis a cool dude!");
                bl = true;
            }
            if (stringArray[0] != null && !bl) {
                d2.t.addChatMessage("\u00a7cUnknown command!");
            }
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            d2.t.addChatMessage("\u00a7cMissing one or more parameters!");
            arrayIndexOutOfBoundsException.printStackTrace();
        }
    }
}

