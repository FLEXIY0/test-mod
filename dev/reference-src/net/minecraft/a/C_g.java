/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.C_b;
import net.minecraft.a.C_c;
import net.minecraft.a.a.b.C_o;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.C_l;
import net.minecraft.client.c.a.C_m;

public class C_g
extends C_c {
    private List<ItemStack> mainInventory = new ArrayList<ItemStack>();
    private List<ItemStack> blocks = new ArrayList<ItemStack>();
    private List<ItemStack> plants = new ArrayList<ItemStack>();
    private List<ItemStack> items = new ArrayList<ItemStack>();
    private List<ItemStack> tools = new ArrayList<ItemStack>();

    public C_g(EntityPlayer entityPlayer) {
        int n;
        Object object;
        int n2;
        int n3;
        int n4 = 0;
        if (C_m.page == 6) {
            for (n3 = 0; n3 < C_l.a.size(); ++n3) {
                n2 = 0;
                object = C_l.a.get(n3);
                for (n = 0; n <= ((Block)object).getMaxDamage(); ++n) {
                    if (object instanceof C_o && n == 2) continue;
                    this.mainInventory.add(new ItemStack((Block)object, 1, n));
                }
            }
            for (n3 = 0; n3 < C_l.registeredItemList.size(); ++n3) {
                object = C_l.registeredItemList.get(n3);
                if (object == Item.i) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        this.mainInventory.add(new ItemStack((Item)object, 1, n4));
                    }
                    continue;
                }
                if (object == Item.dyePowder) {
                    for (n4 = 0; n4 < 16; ++n4) {
                        this.mainInventory.add(new ItemStack((Item)object, 1, n4));
                    }
                    continue;
                }
                if (object == Item.spawnEgg) {
                    for (n4 = 0; n4 < ((Item)object).getSubtypes() + 1; ++n4) {
                        this.mainInventory.add(new ItemStack((Item)object, 1, n4));
                    }
                    continue;
                }
                if (object == Item.ao) {
                    for (n4 = 0; n4 < ((Item)object).getSubtypes() + 1; ++n4) {
                        this.mainInventory.add(new ItemStack((Item)object, 1, n4));
                    }
                    continue;
                }
                this.mainInventory.add(new ItemStack((Item)object));
            }
        } else {
            if (C_m.page < 3) {
                for (n3 = 0; n3 < C_l.a.size(); ++n3) {
                    n2 = 0;
                    object = C_l.a.get(n3);
                    if (C_m.page == 1) {
                        if (((Block)object).isDecoration) continue;
                        for (n = 0; n <= ((Block)object).getMaxDamage(); ++n) {
                            if (object instanceof C_o && n == 2) continue;
                            this.blocks.add(new ItemStack((Block)object, 1, n));
                        }
                        continue;
                    }
                    if (C_m.page != 2 || !((Block)object).isDecoration) continue;
                    for (n = 0; n <= ((Block)object).getMaxDamage(); ++n) {
                        this.plants.add(new ItemStack((Block)object, 1, n));
                    }
                }
            }
            if (C_m.page == 2) {
                for (n3 = 0; n3 < C_l.registeredItemList.size(); ++n3) {
                    object = C_l.registeredItemList.get(n3);
                    if (object == Item.ao) {
                        for (n4 = 0; n4 < ((Item)object).getSubtypes() + 1; ++n4) {
                            this.plants.add(new ItemStack((Item)object, 1, n4));
                        }
                        continue;
                    }
                    if (!((Item)object).getDecor()) continue;
                    this.plants.add(new ItemStack((Item)object));
                }
            }
            if (C_m.page >= 3 && C_m.page != 6) {
                for (n3 = 0; n3 < C_l.registeredItemList.size(); ++n3) {
                    object = C_l.registeredItemList.get(n3);
                    if (C_m.page == 3) {
                        if (((Item)object).getTool() || ((Item)object).getDecor()) continue;
                        for (n = 0; n <= ((Item)object).getSubtypes(); ++n) {
                            this.items.add(new ItemStack((Item)object, 1, n));
                        }
                        continue;
                    }
                    if (C_m.page != 4 || !((Item)object).getTool()) continue;
                    this.tools.add(new ItemStack((Item)object));
                }
            }
        }
        object = entityPlayer.b;
        for (n2 = 0; n2 < 9; ++n2) {
            for (n = 0; n < 8; ++n) {
                this.addSlot(new net.minecraft.client.c.a.C_g(C_m.creativeContainer(), n + n2 * 8, 8 + n * 18, 18 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlot(new net.minecraft.client.c.a.C_g((C_b)object, n2, 8 + n2 * 18, 184));
        }
        this.addSlotContents(0.0f);
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
        return true;
    }

    public void addSlotContents(float f) {
        int n = this.mainInventory.size();
        switch (C_m.page) {
            case 1: {
                n = this.blocks.size();
                break;
            }
            case 2: {
                n = this.plants.size();
                break;
            }
            case 3: {
                n = this.items.size();
                break;
            }
            case 4: {
                n = this.tools.size();
                break;
            }
            default: {
                n = this.mainInventory.size();
            }
        }
        int n2 = n / 8 - 8 + 1;
        int n3 = (int)((double)(f * (float)n2) + 0.5);
        if (n3 < 0) {
            n3 = 0;
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 8; ++j) {
                int n4 = j + (i + n3) * 8;
                if (n4 >= 0) {
                    switch (C_m.page) {
                        case 1: {
                            if (n4 < this.blocks.size()) {
                                C_m.creativeContainer().a(j + i * 8, this.blocks.get(n4));
                                break;
                            }
                            C_m.creativeContainer().a(j + i * 8, null);
                            break;
                        }
                        case 2: {
                            if (n4 < this.plants.size()) {
                                C_m.creativeContainer().a(j + i * 8, this.plants.get(n4));
                                break;
                            }
                            C_m.creativeContainer().a(j + i * 8, null);
                            break;
                        }
                        case 3: {
                            if (n4 < this.items.size()) {
                                C_m.creativeContainer().a(j + i * 8, this.items.get(n4));
                                break;
                            }
                            C_m.creativeContainer().a(j + i * 8, null);
                            break;
                        }
                        case 4: {
                            if (n4 < this.tools.size()) {
                                C_m.creativeContainer().a(j + i * 8, this.tools.get(n4));
                                break;
                            }
                            C_m.creativeContainer().a(j + i * 8, null);
                            break;
                        }
                        default: {
                            if (n4 < this.mainInventory.size()) {
                                C_m.creativeContainer().a(j + i * 8, this.mainInventory.get(n4));
                                break;
                            }
                            C_m.creativeContainer().a(j + i * 8, null);
                            break;
                        }
                    }
                    continue;
                }
                C_m.creativeContainer().a(j + i * 8, null);
            }
        }
    }

    @Override
    protected void retryClickSlot(int n, int n2, boolean bl, EntityPlayer entityPlayer) {
    }

    public void addItems(String string) {
        Object object;
        int n;
        if (C_m.page < 3 || C_m.page == 6) {
            for (n = 0; n < C_l.a.size(); ++n) {
                object = C_l.a.get(n);
                for (int i = 0; i <= ((Block)object).getMaxDamage(); ++i) {
                    if (object instanceof C_o && i == 2) continue;
                    ItemStack itemStack = new ItemStack((Block)object, 1, i);
                    String string2 = itemStack.getItemName().toLowerCase();
                    if (C_m.page == 1 && !((Block)object).isDecoration) {
                        if (!string2.contains(string.toLowerCase())) continue;
                        this.blocks.add(itemStack);
                        continue;
                    }
                    if (C_m.page == 2 && ((Block)object).isDecoration) {
                        if (!string2.contains(string.toLowerCase())) continue;
                        this.plants.add(itemStack);
                        continue;
                    }
                    if (!string2.contains(string.toLowerCase())) continue;
                    this.mainInventory.add(itemStack);
                }
            }
        }
        if (C_m.page == 2) {
            for (n = 0; n < C_l.registeredItemList.size(); ++n) {
                object = C_l.registeredItemList.get(n);
                if (!((Item)object).getDecor()) continue;
                ItemStack itemStack = new ItemStack((Item)object, 1);
                if (object == Item.ao) {
                    for (int i = 0; i < ((Item)object).getSubtypes() + 1; ++i) {
                        if (!itemStack.getItemName().toLowerCase().contains(string.toLowerCase())) continue;
                        this.plants.add(new ItemStack((Item)object, 1, i));
                    }
                    continue;
                }
                if (!itemStack.getItemName().toLowerCase().contains(string.toLowerCase())) continue;
                this.plants.add(itemStack);
            }
        }
        if (C_m.page == 3 || C_m.page == 4 || C_m.page == 6) {
            for (n = 0; n < C_l.registeredItemList.size(); ++n) {
                ItemStack itemStack;
                object = C_l.registeredItemList.get(n);
                if (C_m.page == 3) {
                    if (((Item)object).getTool() || ((Item)object).getDecor()) continue;
                    for (int i = 0; i <= ((Item)object).getSubtypes(); ++i) {
                        itemStack = new ItemStack((Item)object, 1, i);
                        if (!itemStack.getItemName().toLowerCase().contains(string.toLowerCase())) continue;
                        this.items.add(itemStack);
                    }
                    continue;
                }
                if (C_m.page == 4) {
                    ItemStack itemStack2 = new ItemStack((Item)object, 1);
                    if (!((Item)object).getTool() || !itemStack2.getItemName().toLowerCase().contains(string.toLowerCase())) continue;
                    this.tools.add(itemStack2);
                    continue;
                }
                for (int i = 0; i <= ((Item)object).getSubtypes(); ++i) {
                    itemStack = new ItemStack((Item)object, 1, i);
                    if (!itemStack.getItemName().toLowerCase().contains(string.toLowerCase())) continue;
                    this.mainInventory.add(itemStack);
                }
            }
        }
    }

    public static String removeAccents(String string) {
        if (string == null) {
            return "";
        }
        string = Normalizer.normalize(string, Normalizer.Form.NFD);
        string = string.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return string;
    }

    public void updateSlots(String string) {
        List<ItemStack> list;
        switch (C_m.page) {
            case 1: {
                list = this.blocks;
                break;
            }
            case 2: {
                list = this.plants;
                break;
            }
            case 3: {
                list = this.items;
                break;
            }
            case 4: {
                list = this.tools;
                break;
            }
            default: {
                list = this.mainInventory;
            }
        }
        list.clear();
        C_m.search = C_g.removeAccents(string);
        this.addItems(string);
    }

    public List<ItemStack> getInventory() {
        return this.mainInventory;
    }

    public List<ItemStack> getBlocks() {
        return this.blocks;
    }

    public List<ItemStack> getDecor() {
        return this.plants;
    }

    public List<ItemStack> getItems() {
        return this.items;
    }

    public List<ItemStack> getTools() {
        return this.tools;
    }
}

