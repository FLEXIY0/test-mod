/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c;

import com.a.a.NBTTagCompound;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.a.c.C_a;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.EntityLiving;
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

public class EntityList {
    private static Map<String, Class<? extends Entity>> stringToClassMapping = new HashMap<String, Class<? extends Entity>>();
    private static Map<Class<? extends Entity>, String> classToStringMapping = new HashMap<Class<? extends Entity>, String>();
    private static Map<Integer, Class<? extends Entity>> IDtoClassMapping = new HashMap<Integer, Class<? extends Entity>>();
    private static Map<Class<? extends Entity>, Integer> classToIDMapping = new HashMap<Class<? extends Entity>, Integer>();

    private static void addMapping(Class<? extends Entity> clazz, String string, int n) {
        stringToClassMapping.put(string, clazz);
        classToStringMapping.put(clazz, string);
        IDtoClassMapping.put(n, clazz);
        classToIDMapping.put(clazz, n);
    }

    public static Entity createEntityInWorld(String string, net.minecraft.a.a.World c_g) {
        Entity c_b = null;
        try {
            Class<? extends Entity> clazz = stringToClassMapping.get(string);
            if (clazz != null) {
                c_b = clazz.getConstructor(net.minecraft.a.a.World.class).newInstance(c_g);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return c_b;
    }

    public static Entity createEntityFromNBT(NBTTagCompound nBTTagCompound, net.minecraft.a.a.World c_g) {
        Entity c_b = null;
        try {
            Class<? extends Entity> clazz = stringToClassMapping.get(nBTTagCompound.g("id"));
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

    public static Entity createEntity(int n, net.minecraft.a.a.World c_g) {
        Entity c_b = null;
        try {
            Class<? extends Entity> clazz = IDtoClassMapping.get(n);
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

    public static int getEntityID(Entity c_b) {
        return classToIDMapping.get(c_b.getClass());
    }

    public static String getEntityString(Entity c_b) {
        return classToStringMapping.get(c_b.getClass());
    }

    static {
        EntityList.addMapping(net.minecraft.a.c.a.C_e.class, "Human", 49);
        EntityList.addMapping(EntityLiving.class, "Mob", 48);
        EntityList.addMapping(net.minecraft.a.c.b.C_c.class, "Pig", 90);
        EntityList.addMapping(net.minecraft.a.c.b.C_b.class, "Sheep", 91);
        EntityList.addMapping(net.minecraft.a.c.a.C_d.class, "Creeper", 52);
        EntityList.addMapping(net.minecraft.a.c.a.C_c.class, "Skeleton", 50);
        EntityList.addMapping(C_j.class, "Imp", 56);
        EntityList.addMapping(C_h.class, "Harpy", 57);
        EntityList.addMapping(net.minecraft.a.c.a.C_b.class, "Spider", 53);
        EntityList.addMapping(C_m.class, "Slime", 58);
        EntityList.addMapping(net.minecraft.a.c.b.C_d.class, "Bat", 59);
        EntityList.addMapping(net.minecraft.a.c.b.C_i.class, "Jellyfish", 69);
        EntityList.addMapping(net.minecraft.a.c.b.C_g.class, "Fish", 60);
        EntityList.addMapping(net.minecraft.a.c.a.C_g.class, "Antlion", 55);
        EntityList.addMapping(C_l.class, "Slug", 78);
        EntityList.addMapping(C_i.class, "Husk", 79);
        EntityList.addMapping(net.minecraft.a.c.a.C_f.class, "Zombie", 51);
        EntityList.addMapping(net.minecraft.a.c.a.EntityPigZombie.class, "PigZombie", 94);
        EntityList.addMapping(C_k.class, "Mummy", 64);
        EntityList.addMapping(net.minecraft.a.c.a.C_a.class, "Giant", 54);
        EntityList.addMapping(net.minecraft.a.c.c.EntityItem.class, "Item", 1);
        EntityList.addMapping(net.minecraft.a.c.d.C_a.class, "Arrow", 10);
        EntityList.addMapping(net.minecraft.a.c.d.C_b.class, "Dart", 11);
        EntityList.addMapping(C_g.class, "Spear", 71);
        EntityList.addMapping(C_a.class, "Painting", 9);
        EntityList.addMapping(net.minecraft.a.c.c.C_e.class, "Frame", 8);
        EntityList.addMapping(net.minecraft.a.c.c.C_a.class, "PrimedTnt", 20);
        EntityList.addMapping(net.minecraft.a.c.c.C_c.class, "Sand", 72);
        EntityList.addMapping(net.minecraft.a.c.c.C_g.class, "Minecart", 73);
        EntityList.addMapping(net.minecraft.a.c.b.C_e.class, "Cow", 92);
        EntityList.addMapping(net.minecraft.a.c.b.C_k.class, "Mooshroom", 62);
        EntityList.addMapping(net.minecraft.a.c.b.C_j.class, "Moobloom", 63);
        EntityList.addMapping(net.minecraft.a.c.b.C_f.class, "Duck", 93);
        EntityList.addMapping(net.minecraft.a.c.b.C_h.class, "Fox", 61);
        EntityList.addMapping(EntitySteve.class, "Steve", 66);
        EntityList.addMapping(EntityBlackSteve.class, "Black Steve", 67);
        EntityList.addMapping(EntityBeastBoy.class, "Beast Boy", 68);
        EntityList.addMapping(EntityRana.class, "Rana", 65);
        EntityList.addMapping(C_n.class, "Snowman", 74);
        EntityList.addMapping(net.minecraft.a.c.d.C_f.class, "Snowball", 75);
        EntityList.addMapping(C_d.class, "Fireball", 76);
        EntityList.addMapping(C_c.class, "Feather", 77);
    }
}

