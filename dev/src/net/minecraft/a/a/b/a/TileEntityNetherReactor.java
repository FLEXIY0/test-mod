/*
 * Native port of the classic MCPE "Nether Reactor" for Indev++.
 *
 * Drives the reactor once its core is activated (see BlockNetherReactorCore):
 * builds a netherrack spire/dome, then over ~46 game-seconds transforms the
 * gold/cobblestone pattern into glowing obsidian, showers loot and spawns
 * pigman waves at set milestones, and finally collapses the dome back into
 * obsidian. Ported to the Infdev-era API (C_g world, C_a tile entity,
 * C_x block registry) — the original mod's classes are binary-incompatible.
 *
 * Base C_a exposes: a = world (C_g), b/c/d = x/y/z of this tile entity.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.game.level.block.machines.BlockNetherReactorCore;

public class TileEntityNetherReactor extends C_a {
    private static final int TPS = 20;                 // ticks per reactor "second"
    private static final int NUM_ENEMY_SLOTS = 3;

    private boolean isInitialized = false;
    private boolean hasFinished = false;
    private int curLevel = 0;
    private short progress = 0;
    private int collapseTicks = -1; // >=0 while the dome slowly crumbles, -1 when done

    // ---- pattern (gold / cobblestone / core), layer 0 = bottom (y-1) ----
    private static int patternAt(int layer, int r, int c) {
        int gold = C_x.W.at, cobble = C_x.l.at, core = C_x.netherReactorCore.at;
        switch (layer) {
            case 0: { // all filled: gold corners, cobble edges + centre
                boolean corner = (r != 1) && (c != 1);
                return corner ? gold : cobble;
            }
            case 1: { // cobble corners, air edges, core centre
                if (r == 1 && c == 1) return core;
                boolean corner = (r != 1) && (c != 1);
                return corner ? cobble : 0;
            }
            default: { // top: air corners, cobble edges + centre
                boolean corner = (r != 1) && (c != 1);
                return corner ? 0 : cobble;
            }
        }
    }

    public void lightItUp() {
        if (this.isInitialized || this.hasFinished) return;
        this.curLevel = 0;
        BlockNetherReactorCore.setPhase(this.a, this.b, this.c, this.d, 1); // ACTIVATED
        this.isInitialized = true;
        this.buildDome(this.b, this.c, this.d);
    }

    @Override
    public void d() {
        if (!this.isInitialized) return;
        if (this.hasFinished) { this.tickCollapse(); return; }
        if (this.progress % TPS == 0) {
            int sec = this.progress / TPS;
            if (sec < 10) {
                this.tickGlowingRedstoneTransformation(sec);
            }
            if (sec > 42 && sec <= 45) {
                this.turnGlowingObsidianLayerToObsidian(45 - sec);
            }
            if (this.checkLevelChange(sec)) {
                ++this.curLevel;
                this.spawnItems(this.getNumItemsPerLevel(this.curLevel));
                this.trySpawnEnemies(this.getNumEnemiesPerLevel(this.curLevel));
            }
        }
        this.progress = (short) (this.progress + 1);
        if (this.progress > TPS * 46) {
            this.beginCollapse();
        }
    }

    /** Natural end: mark the core spent, drop the obsidian ring, then let the
     *  dome crumble slowly (tickCollapse), instead of vanishing all at once. */
    private void beginCollapse() {
        if (this.hasFinished || !this.isInitialized) return;
        if (this.a.a(this.b, this.c, this.d) == C_x.netherReactorCore.at) {
            BlockNetherReactorCore.setPhase(this.a, this.b, this.c, this.d, 2); // DEACTIVATED
        }
        this.hasFinished = true;
        this.collapseTicks = 0;
        for (int i = this.b - 1; i <= this.b + 1; ++i) {
            for (int j = this.c - 1; j <= this.c + 1; ++j) {
                for (int k = this.d - 1; k <= this.d + 1; ++k) {
                    if (i == this.b && j == this.c && k == this.d) continue;
                    this.a.a(i, j, k, C_x.ae.at); // ring of obsidian around the spent core
                }
            }
        }
    }

    /** Crumble a few dome blocks per tick over ~25s so the collapse is gradual. */
    private void tickCollapse() {
        if (this.collapseTicks < 0) return;
        ++this.collapseTicks;
        if (this.collapseTicks % 4 == 0) {
            for (int n = 0; n < 4; ++n) {
                int rx = this.b + this.a.q.nextInt(19) - 9;
                int ry = this.c - 3 + this.a.q.nextInt(18);
                int rz = this.d + this.a.q.nextInt(19) - 9;
                int id = this.a.a(rx, ry, rz);
                if (id == C_x.netherrack.at || id == C_x.glowingObsidian.at) {
                    this.a.a(rx, ry, rz, 0);
                }
            }
        }
        if (this.collapseTicks > TPS * 25) this.collapseTicks = -1; // done
    }

    /** Instant teardown when the core is broken mid-run (rare). */
    public void finishReactorRun() {
        if (this.hasFinished || !this.isInitialized) return;
        this.hasFinished = true;
        this.collapseTicks = -1;
        this.deteriorateDome(this.b, this.c, this.d);
    }

    // ---- milestones / loot (sparse + random, not a firehose) ----

    public boolean checkLevelChange(int sec) {
        int[] marks = {10, 18, 26, 34, 42}; // fewer waves
        for (int m : marks) if (m == sec) return true;
        return false;
    }

    /** A handful of items per wave, mostly small, with an occasional bonus. */
    public int getNumItemsPerLevel(int lvl) {
        int n = this.a.q.nextInt(3);                              // 0-2 usually
        if (this.a.q.nextInt(4) == 0) n += this.a.q.nextInt(4);   // ~25%: +0-3 bonus
        if (lvl <= 1) n += 2;                                     // first wave a touch more
        return n;
    }

    public int getNumEnemiesPerLevel(int lvl) {
        if (lvl <= 1) return this.a.q.nextInt(2) + 1; // 1-2
        return this.a.q.nextInt(2);                    // 0-1
    }

    private void spawnItems(int n) {
        for (int i = 0; i < n; ++i) this.spawnItem();
    }

    private void spawnItem() {
        float dist = 3.0f + this.a.q.nextFloat() * 4.0f;
        float ang = this.a.q.nextFloat() * ((float) Math.PI * 2f);
        float x = (float) (Math.sin(ang) * dist) + this.b;
        float y = this.c - 1f;
        float z = (float) (Math.cos(ang) * dist) + this.d;
        net.minecraft.a.c.c.C_b item = new net.minecraft.a.c.c.C_b(this.a, x, y, z, this.getSpawnItem());
        item.O = 10;
        this.a.spawnEntityInWorld(item);
    }

    /** Loot table adapted to blocks/items that exist in Indev++. */
    private ItemStack getSpawnItem() {
        switch (this.a.q.nextInt(10)) {
            case 0: return new ItemStack(C_x.glowStone, this.a.q.nextInt(2) + 1);
            case 1: return new ItemStack(C_x.soulSand, this.a.q.nextInt(2) + 3);
            case 2: return new ItemStack(C_x.netherrack, this.a.q.nextInt(3) + 2);
            case 3: return new ItemStack(Item.i, this.a.q.nextInt(2) + 1); // coal
            case 4: return new ItemStack(Item.l); // gold ingot
            case 5: return new ItemStack(Item.k, this.a.q.nextInt(2) + 1); // iron ingot
            case 6: return new ItemStack(Item.al); // flint
            case 7: return new ItemStack(C_x.ae); // obsidian
            case 8: return new ItemStack(Item.bone); // bone
            default: return this.getLowOddsSpawnItem();
        }
    }

    private ItemStack getLowOddsSpawnItem() {
        if (this.a.q.nextInt(10) <= 8) {
            ItemStack[] rare = {
                new ItemStack(Item.j),                 // diamond
                new ItemStack(C_x.glowingObsidian),    // glowing obsidian
                new ItemStack(Item.slimeBall),
                new ItemStack(Item.H), // feather
            };
            return rare[this.a.q.nextInt(rare.length)];
        }
        return new ItemStack(Item.j); // jackpot diamond
    }

    private void trySpawnEnemies(int n) {
        for (int i = 0; i < n && i < NUM_ENEMY_SLOTS; ++i) {
            float dist = 3.0f + this.a.q.nextFloat() * 4.0f;
            float ang = this.a.q.nextFloat() * ((float) Math.PI * 2f);
            float x = (float) (Math.sin(ang) * dist) + this.b;
            float y = this.c;
            float z = (float) (Math.cos(ang) * dist) + this.d;
            net.minecraft.a.c.a.EntityPigZombie mob = new net.minecraft.a.c.a.EntityPigZombie(this.a, x, y, z);
            this.a.spawnEntityInWorld(mob);
        }
    }

    // ---- transformation of the pattern into glowing obsidian ----

    public void tickGlowingRedstoneTransformation(int sec) {
        switch (sec) {
            case 2: this.turnLayerToGlowingObsidian(0, C_x.l.at); break;
            case 3: this.turnLayerToGlowingObsidian(1, C_x.l.at); break;
            case 4: this.turnLayerToGlowingObsidian(2, C_x.l.at); break;
            case 7: this.turnLayerToGlowingObsidian(0, C_x.W.at); break;
            case 8: this.turnLayerToGlowingObsidian(1, C_x.W.at); break;
            case 9: this.turnLayerToGlowingObsidian(2, C_x.W.at); break;
        }
    }

    private void turnLayerToGlowingObsidian(int layer, int matchId) {
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (patternAt(layer, i + 1, j + 1) != matchId) continue;
                this.a.a(this.b + i, this.c - 1 + layer, this.d + j, C_x.glowingObsidian.at);
            }
        }
    }

    private void turnGlowingObsidianLayerToObsidian(int layer) {
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (this.a.a(this.b + i, this.c - 1 + layer, this.d + j) == C_x.netherReactorCore.at) continue;
                this.a.a(this.b + i, this.c - 1 + layer, this.d + j, C_x.ae.at);
            }
        }
    }

    // ---- dome construction ----

    public void buildDome(int x, int y, int z) {
        int nr = C_x.netherrack.at;
        this.buildFloorVolume(x, y - 3, z, 8, 2, nr);
        this.buildHollowedVolume(x, y - 1, z, 8, 4, nr, 0);
        this.buildFloorVolume(x, y - 1 + 4, z, 8, 1, nr);
        this.buildCrockedRoofVolume(false, x, y - 1 + 5, z, 8, 1, nr);
        this.buildCrockedRoofVolume(true, x, y - 1 + 6, z, 5, 8, nr);
        this.buildCrockedRoofVolume(false, x, y - 1 + 12, z, 3, 14, nr);
    }

    private void buildFloorVolume(int x, int y, int z, int rad, int height, int id) {
        for (int i = 0; i < height; ++i)
            for (int j = -rad; j <= rad; ++j)
                for (int k = -rad; k <= rad; ++k)
                    this.a.a(j + x, i + y, k + z, id);
    }

    private void buildHollowedVolume(int x, int y, int z, int rad, int height, int wallId, int fillId) {
        for (int i = 0; i < height; ++i)
            for (int j = -rad; j <= rad; ++j)
                for (int k = -rad; k <= rad; ++k) {
                    if (j == -rad || j == rad || k == -rad || k == rad) {
                        this.a.a(j + x, i + y, k + z, wallId);
                        continue;
                    }
                    if (i <= 2 && j >= -1 && j <= 1 && k >= -1 && k <= 1) continue; // keep the core cavity
                    this.a.a(j + x, i + y, k + z, fillId);
                }
    }

    private void buildCrockedRoofVolume(boolean inv, int x, int y, int z, int rad, int slope, int id) {
        int base = slope + rad;
        for (int i = -rad; i <= rad; ++i)
            for (int j = -rad; j <= rad; ++j) {
                int off = inv ? (-i - j) / 2 : (i + j) / 2;
                int top = base + off;
                for (int k = 0; k < base + rad; ++k) {
                    if (top < k || (!isEdge(i, rad, j) && top != k)) continue;
                    this.a.a(i + x, k + y, j + z, id);
                }
            }
    }

    private static boolean isEdge(int a, int rad, int b) {
        return a == -rad || a == rad || b == -rad || b == rad;
    }

    // ---- dome deterioration on finish ----

    private void deteriorateDome(int x, int y, int z) {
        this.deteriorateHollowedVolume(x, y - 1, z, 8, 5);
        this.deteriorateCrockedRoofVolume(false, x, y - 1 + 5, z, 8, 1);
        this.deteriorateCrockedRoofVolume(true, x, y - 1 + 6, z, 5, 8);
        this.deteriorateCrockedRoofVolume(false, x, y - 1 + 12, z, 3, 14);
    }

    private void deteriorateHollowedVolume(int x, int y, int z, int rad, int height) {
        for (int i = 0; i < height; ++i)
            for (int j = -rad; j <= rad; ++j)
                for (int k = -rad; k <= rad; ++k) {
                    if ((j != -rad && j != rad && k != -rad && k != rad) || this.a.q.nextInt(3) != 0) continue;
                    this.a.a(j + x, i + y, k + z, 0);
                }
    }

    private void deteriorateCrockedRoofVolume(boolean inv, int x, int y, int z, int rad, int slope) {
        int base = slope + rad;
        for (int i = -rad; i <= rad; ++i)
            for (int j = -rad; j <= rad; ++j) {
                int off = inv ? (-i - j) / 2 : (i + j) / 2;
                int top = base + off;
                for (int k = 0; k < base + rad; ++k) {
                    if (top < k || !isEdge(i, rad, j) || this.a.q.nextInt(4) != 0) continue;
                    this.a.a(i + x, k + y, j + z, 0);
                }
            }
    }

    // ---- persistence ----

    @Override
    public void a(NBTTagCompound nbt) {
        super.a(nbt);
        this.isInitialized = nbt.k("IsInitialized");
        if (this.isInitialized) {
            this.progress = nbt.c("Progress");
            this.hasFinished = nbt.k("HasFinished");
            this.curLevel = nbt.d("Level");
            this.collapseTicks = nbt.d("Collapse");
        }
    }

    @Override
    public void b(NBTTagCompound nbt) {
        super.b(nbt);
        nbt.a("id", "NetherReactor");
        nbt.a("IsInitialized", this.isInitialized);
        nbt.a("Progress", this.progress);
        nbt.a("HasFinished", this.hasFinished);
        nbt.a("Level", this.curLevel);
        nbt.a("Collapse", this.collapseTicks);
    }
}
