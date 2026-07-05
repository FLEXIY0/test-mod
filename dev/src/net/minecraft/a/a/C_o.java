/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a;

import com.a.a.NBTTagCompound;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.b.a.C_b;
import net.minecraft.a.a.b.a.C_c;
import net.minecraft.a.a.b.a.C_e;
import net.minecraft.a.a.b.a.C_f;
import net.minecraft.a.a.b.a.C_g;
import net.minecraft.a.a.b.a.C_h;
import net.minecraft.a.a.b.a.C_i;
import net.minecraft.a.a.b.a.C_k;
import net.minecraft.a.a.b.a.C_l;
import net.minecraft.a.a.b.a.C_m;

public class C_o {
    private static Map<String, Class<? extends TileEntity>> nameToClassMap = new HashMap<String, Class<? extends TileEntity>>();
    private static Map<Class<? extends TileEntity>, String> classToNameMap = new HashMap<Class<? extends TileEntity>, String>();

    private static void addMapping(Class<? extends TileEntity> clazz, String string) {
        if (nameToClassMap.containsKey(string)) {
            throw new IllegalArgumentException("Duplicate id: " + string);
        }
        nameToClassMap.put(string, clazz);
        classToNameMap.put(clazz, string);
    }

    public static TileEntity loadFromCompound(NBTTagCompound nBTTagCompound) {
        TileEntity c_a = null;
        try {
            Class<? extends TileEntity> clazz = nameToClassMap.get(nBTTagCompound.g("id"));
            if (clazz != null) {
                c_a = clazz.newInstance();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (c_a != null) {
            c_a.a(nBTTagCompound);
        } else {
            System.out.println("Skipping TileEntity with id " + nBTTagCompound.g("id"));
        }
        return c_a;
    }

    static {
        C_o.addMapping(C_c.class, "Chest");
        C_o.addMapping(C_b.class, "Furnace");
        C_o.addMapping(C_h.class, "Generator");
        C_o.addMapping(C_f.class, "Bookshelf");
        C_o.addMapping(C_e.class, "Barrel");
        C_o.addMapping(C_m.class, "Vacuum");
        C_o.addMapping(C_l.class, "Sign");
        C_o.addMapping(C_k.class, "Jukebox");
        C_o.addMapping(C_i.class, "Noteblock");
        C_o.addMapping(C_g.class, "Dispenser");
        C_o.addMapping(net.minecraft.a.a.b.a.TileEntityNetherReactor.class, "NetherReactor");
        C_o.addMapping(net.minecraft.a.a.b.a.TileEntityCauldron.class, "Cauldron");
    }
}

