/*
 * Zombie Pigman for the Nether Reactor's enemy waves (Indev++ port).
 *
 * Extends the vanilla zombie (EntityZombie) so it inherits AI, drops and the humanoid
 * model — the client's entity render manager falls back to the superclass
 * renderer for unknown classes, so this renders with the zombie/biped model
 * but its own "/mob/pigzombie.png" skin. Registered in EntityList (a.c.C_f)
 * as "PigZombie" (id 94) so it saves/loads with the world.
 */
package net.minecraft.a.c.a;

import net.minecraft.a.a.World;

public class EntityPigZombie extends EntityZombie {
    public EntityPigZombie(World world) {
        super(world);
        this.V = "/mob/pigzombie.png";
    }

    public EntityPigZombie(World world, float x, float y, float z) {
        super(world, x, y, z);
        this.V = "/mob/pigzombie.png";
    }

    /**
     * Nether pigman: never burns. The zombie's AI (final f()) sets the fire
     * counter J=300 in daylight, but it runs at the END of the update chain
     * (EntityLiving calls f() after the base fire-damage block), so clearing J
     * here after super.b_() means the fire block never sees J>0 next tick — no
     * damage, no flames. Also covers lava, which fits a nether mob.
     */
    @Override
    public void b_() {
        super.b_();
        this.J = 0;
    }
}
