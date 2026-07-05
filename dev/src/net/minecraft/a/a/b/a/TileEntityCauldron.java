/*
 * Cauldron brewing for Indev++ (blueprint: ReIndev's TileEntityCauldron +
 * BrewingHandlerWater, rebuilt against the Infdev-era API). Water only:
 *   1. right-click an empty cauldron with a Water Bucket -> fills with water
 *   2. right-click the water with an ingredient -> starts brewing that potion
 *   3. after a short brew, right-click with a Glass Bottle -> the potion pops
 *      out and the cauldron empties.
 * Fluid state (0 empty / 1 water) is mirrored in the block metadata so the top
 * texture changes. Registered in C_o as "Cauldron".
 *
 * Base TileEntity: a = world, b/c/d = x/y/z.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.potion.PotionManager;

public class TileEntityCauldron extends TileEntity {
    private static final int BREW_TIME = 40; // ticks until the potion is ready

    public int fluid = 0;        // 0 = empty, 1 = water
    public int resultPotion = -1; // effect id being brewed, -1 = none
    public int brewProgress = 0;

    public boolean ready() {
        return this.resultPotion >= 0 && this.brewProgress >= BREW_TIME;
    }

    @Override
    public void d() {
        if (this.fluid == 1 && this.resultPotion >= 0 && this.brewProgress < BREW_TIME) {
            ++this.brewProgress;
        }
    }

    /** Handle a right-click with the player's held item. Returns true if consumed. */
    public boolean itemUsed(EntityPlayer player, ItemStack held) {
        if (held == null) return false;
        boolean creative = player.gamemode == 1;
        int itemId = held.c;

        if (this.fluid == 0) {
            if (itemId == Item.bucketWater.ap) {
                this.fluid = 1;
                this.resultPotion = -1;
                this.brewProgress = 0;
                if (!creative) held.c = Item.bucketEmpty.ap; // water bucket -> empty bucket
                this.sync();
                return true;
            }
            return false;
        }

        // has water
        if (this.resultPotion < 0) {
            int eff = ingredientToEffect(itemId);
            if (eff >= 0) {
                this.resultPotion = eff;
                this.brewProgress = 0;
                if (!creative && --held.a <= 0) player.b.a[player.b.c] = null;
                this.sync();
                return true;
            }
            return false;
        }

        // brewing done -> bottle it
        if (this.ready() && itemId == Item.potionBottle.ap) {
            this.dropPotion(this.resultPotion);
            if (!creative && --held.a <= 0) player.b.a[player.b.c] = null;
            this.empty();
            return true;
        }
        return false;
    }

    private void dropPotion(int effect) {
        ItemStack potion = new ItemStack(Item.potion.ap, 1, effect);
        net.minecraft.a.c.c.C_b drop = new net.minecraft.a.c.c.C_b(
                this.a, (float) this.b + 0.5f, (float) this.c + 1.1f, (float) this.d + 0.5f, potion);
        drop.O = 10;
        this.a.spawnEntityInWorld(drop);
    }

    private void empty() {
        this.fluid = 0;
        this.resultPotion = -1;
        this.brewProgress = 0;
        this.sync();
    }

    private void sync() {
        this.a.d(this.b, this.c, this.d, this.fluid); // block metadata drives the top texture
        this.a.markBlockNeedsUpdate(this.b, this.c, this.d);
    }

    /** Which potion an ingredient brews (water base). */
    static int ingredientToEffect(int itemId) {
        if (itemId == Item.gapple.ap) return PotionManager.HEAL;         // golden apple
        if (itemId == Item.apple.ap) return PotionManager.REGEN;         // apple
        if (itemId == Item.H.ap) return PotionManager.SPEED;            // feather
        if (itemId == Item.slimeBall.ap) return PotionManager.JUMP;     // slimeball
        if (itemId == Item.i.ap) return PotionManager.FIRE_RESIST;      // coal
        if (itemId == Block.glowStone.at) return PotionManager.NIGHT_VISION; // glowstone block
        return -1;
    }

    @Override
    public void a(NBTTagCompound nbt) {
        super.a(nbt);
        this.fluid = nbt.d("Fluid");
        this.resultPotion = nbt.a("Potion") ? nbt.d("Potion") : -1;
        this.brewProgress = nbt.d("Brew");
    }

    @Override
    public void b(NBTTagCompound nbt) {
        super.b(nbt);
        nbt.a("id", "Cauldron");
        nbt.a("Fluid", this.fluid);
        nbt.a("Potion", this.resultPotion);
        nbt.a("Brew", this.brewProgress);
    }
}
