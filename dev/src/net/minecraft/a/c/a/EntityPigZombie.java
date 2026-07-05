/*
 * Zombie Pigman for the Nether Reactor's enemy waves (Indev++ port).
 *
 * Extends the vanilla zombie (C_f) so it inherits AI, drops and the humanoid
 * model — the client's entity render manager falls back to the superclass
 * renderer for unknown classes, so this renders with the zombie/biped model
 * but its own "/mob/pigzombie.png" skin. Registered in EntityList (a.c.C_f)
 * as "PigZombie" (id 94) so it saves/loads with the world.
 */
package net.minecraft.a.c.a;

import net.minecraft.a.a.C_g;

public class EntityPigZombie extends C_f {
    public EntityPigZombie(C_g world) {
        super(world);
        this.V = "/mob/pigzombie.png";
    }

    public EntityPigZombie(C_g world, float x, float y, float z) {
        super(world, x, y, z);
        this.V = "/mob/pigzombie.png";
    }
}
