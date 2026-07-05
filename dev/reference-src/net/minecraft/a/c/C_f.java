/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c;

import com.a.a.NBTTagCompound;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.a.c.C_a;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.a.C_h;
import net.minecraft.a.c.a.C_i;
import net.minecraft.a.c.a.C_j;
import net.minecraft.a.c.a.C_k;
import net.minecraft.a.c.a.C_l;
import net.minecraft.a.c.a.C_m;
import net.minecraft.a.c.a.C_n;
import net.minecraft.a.c.d.C_c;
import net.minecraft.a.c.d.C_d;
import net.minecraft.a.c.d.C_g;
import net.minecraft.game.entity.md3.EntityBeastBoy;
import net.minecraft.game.entity.md3.EntityBlackSteve;
import net.minecraft.game.entity.md3.EntityRana;
import net.minecraft.game.entity.md3.EntitySteve;

public class C_f {
    private static Map<String, Class<? extends C_b>> stringToClassMapping = new HashMap<String, Class<? extends C_b>>();
    private static Map<Class<? extends C_b>, String> classToStringMapping = new HashMap<Class<? extends C_b>, String>();
    private static Map<Integer, Class<? extends C_b>> IDtoClassMapping = new HashMap<Integer, Class<? extends C_b>>();
    private static Map<Class<? extends C_b>, Integer> classToIDMapping = new HashMap<Class<? extends C_b>, Integer>();

    private static void addMapping(Class<? extends C_b> clazz, String string, int n) {
        stringToClassMapping.put(string, clazz);
        classToStringMapping.put(clazz, string);
        IDtoClassMapping.put(n, clazz);
        classToIDMapping.put(clazz, n);
    }

    public static C_b createEntityInWorld(String string, net.minecraft.a.a.World c_g) {
        C_b c_b = null;
        try {
            Class<? extends C_b> clazz = stringToClassMapping.get(string);
            if (clazz != null) {
                c_b = clazz.getConstructor(net.minecraft.a.a.World.class).newInstance(c_g);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return c_b;
    }

    public static C_b createEntityFromNBT(NBTTagCompound nBTTagCompound, net.minecraft.a.a.World c_g) {
        C_b c_b = null;
        try {
            Class<? extends C_b> clazz = stringToClassMapping.get(nBTTagCompound.g("id"));
            if (clazz != null) {
                c_b = clazz.getConstructor(net.minecraft.a.a.World.class).newInstance(c_g);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (c_b != null) {
            c_b.d(nBTTagCompound);
        } else {
            System.out.println("Skipping Entity with id " + nBTTagCompound.g("id"));
        }
        return c_b;
    }

    public static C_b createEntity(int n, net.minecraft.a.a.World c_g) {
        C_b c_b = null;
        try {
            Class<? extends C_b> clazz = IDtoClassMapping.get(n);
            if (clazz != null) {
                c_b = clazz.getConstructor(net.minecraft.a.a.World.class).newInstance(c_g);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (c_b == null) {
            System.out.println("Skipping Entity with id " + n);
        }
        return c_b;
    }

    public static int getEntityID(C_b c_b) {
        return classToIDMapping.get(c_b.getClass());
    }

    public static String getEntityString(C_b c_b) {
        return classToStringMapping.get(c_b.getClass());
    }

    static {
        C_f.addMapping(net.minecraft.a.c.a.C_e.class, "Human", 49);
        C_f.addMapping(C_e.class, "Mob", 48);
        C_f.addMapping(net.minecraft.a.c.b.C_c.class, "Pig", 90);
        C_f.addMapping(net.minecraft.a.c.b.C_b.class, "Sheep", 91);
        C_f.addMapping(net.minecraft.a.c.a.C_d.class, "Creeper", 52);
        C_f.addMapping(net.minecraft.a.c.a.C_c.class, "Skeleton", 50);
        C_f.addMapping(C_j.class, "Imp", 56);
        C_f.addMapping(C_h.class, "Harpy", 57);
        C_f.addMapping(net.minecraft.a.c.a.C_b.class, "Spider", 53);
        C_f.addMapping(C_m.class, "Slime", 58);
        C_f.addMapping(net.minecraft.a.c.b.C_d.class, "Bat", 59);
        C_f.addMapping(net.minecraft.a.c.b.C_i.class, "Jellyfish", 69);
        C_f.addMapping(net.minecraft.a.c.b.C_g.class, "Fish", 60);
        C_f.addMapping(net.minecraft.a.c.a.C_g.class, "Antlion", 55);
        C_f.addMapping(C_l.class, "Slug", 78);
        C_f.addMapping(C_i.class, "Husk", 79);
        C_f.addMapping(net.minecraft.a.c.a.C_f.class, "Zombie", 51);
        C_f.addMapping(C_k.class, "Mummy", 64);
        C_f.addMapping(net.minecraft.a.c.a.C_a.class, "Giant", 54);
        C_f.addMapping(net.minecraft.a.c.c.C_b.class, "Item", 1);
        C_f.addMapping(net.minecraft.a.c.d.C_a.class, "Arrow", 10);
        C_f.addMapping(net.minecraft.a.c.d.C_b.class, "Dart", 11);
        C_f.addMapping(C_g.class, "Spear", 71);
        C_f.addMapping(C_a.class, "Painting", 9);
        C_f.addMapping(net.minecraft.a.c.c.C_e.class, "Frame", 8);
        C_f.addMapping(net.minecraft.a.c.c.C_a.class, "PrimedTnt", 20);
        C_f.addMapping(net.minecraft.a.c.c.C_c.class, "Sand", 72);
        C_f.addMapping(net.minecraft.a.c.c.C_g.class, "Minecart", 73);
        C_f.addMapping(net.minecraft.a.c.b.C_e.class, "Cow", 92);
        C_f.addMapping(net.minecraft.a.c.b.C_k.class, "Mooshroom", 62);
        C_f.addMapping(net.minecraft.a.c.b.C_j.class, "Moobloom", 63);
        C_f.addMapping(net.minecraft.a.c.b.C_f.class, "Duck", 93);
        C_f.addMapping(net.minecraft.a.c.b.C_h.class, "Fox", 61);
        C_f.addMapping(EntitySteve.class, "Steve", 66);
        C_f.addMapping(EntityBlackSteve.class, "Black Steve", 67);
        C_f.addMapping(EntityBeastBoy.class, "Beast Boy", 68);
        C_f.addMapping(EntityRana.class, "Rana", 65);
        C_f.addMapping(C_n.class, "Snowman", 74);
        C_f.addMapping(net.minecraft.a.c.d.C_f.class, "Snowball", 75);
        C_f.addMapping(C_d.class, "Fireball", 76);
        C_f.addMapping(C_c.class, "Feather", 77);
    }
}

