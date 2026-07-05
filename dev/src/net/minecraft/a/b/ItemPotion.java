/*
 * Drinkable potion item (Indev++ port of ReIndev's ItemPotion). The item
 * damage/metadata is the effect id (see PotionManager); the icon is a strip of
 * pre-tinted contents tiles starting at the base icon. Right-click drinks it:
 * the effect is applied and one potion is consumed.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.potion.PotionManager;

public class ItemPotion extends Item {
    public ItemPotion(int id) {
        super(id);
        this.setStackSize(8);
    }

    @Override
    public int getIconFromDamage(int meta) {
        if (meta < 0 || meta >= PotionManager.COUNT) meta = 0;
        return this.as + meta;
    }

    @Override
    public ItemStack a(ItemStack itemStack, World world, EntityPlayer player) {
        PotionManager.drink(player, itemStack.d);
        if (player.gamemode != 1) --itemStack.a;
        return itemStack;
    }
}
