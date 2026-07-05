/*
 * Platform bootstrap: registers each feature's listeners once, the first time
 * the game loop fires a hook. New features add one line here instead of editing
 * the obfuscated game loop.
 */
package net.minecraft.platform;

import net.minecraft.potion.PotionManager;

public final class Platform {
    private Platform() {}

    public static void init() {
        // Potion effects: applied every tick to the local player.
        Hooks.onTick(new Hooks.TickListener() {
            @Override
            public void onTick(net.minecraft.a.c.e.EntityPlayer player) {
                PotionManager.tick(player);
            }
        });
    }
}
