/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package net.minecraft.a.c.e;

import com.a.a.NBTTagCompound;
import java.util.List;
import net.minecraft.a.C_c;
import net.minecraft.a.C_j;
import net.minecraft.a.C_m;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.C_l;
import net.minecraft.a.b.C_aa;
import net.minecraft.a.b.C_q;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.EntityLiving;
import net.minecraft.a.c.a.C_g;
import net.minecraft.a.c.a.C_h;
import net.minecraft.a.c.c.C_f;
import net.minecraft.a.c.d.C_a;
import net.minecraft.a.c.e.InventoryPlayer;
import net.minecraft.client.c.C_d;
import net.minecraft.client.d;
import net.minecraft.client.statistics.Achievement;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatBase;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.furniture.BlockBed;
import org.lwjgl.input.Keyboard;
import util.MathHelper;

public class EntityPlayer
extends EntityLiving {
    public InventoryPlayer b = new InventoryPlayer(this);
    public C_m inventoryChest = new C_m(this);
    public C_c inventorySlots;
    public C_c craftingInventory;
    public byte operator = 0;
    public int P = 0;
    public float Q;
    public float R;
    private int a = 0;
    public boolean isSwinging = false;
    public int swingProgressInt = 0;
    public net.minecraft.a.c.c.C_d fishEntity = null;
    public boolean nightVision;
    public int nightVisionTimer = 0;
    public int gamemode;
    public boolean cheats;
    public boolean keepInventory = false;
    public String name = "Player";
    public int difficulty = 2;
    public boolean isHardcoreEnabled = false;
    private int counter = 0;
    public float spawnX;
    public float spawnY;
    public float spawnZ;
    public int itemInUseCount;
    public ItemStack itemInUse;

    public EntityPlayer(net.minecraft.a.a.World c_g) {
        super(c_g);
        if (c_g != null) {
            this.inventorySlots = new C_j(this.b, !c_g.multiplayerWorld);
            c_g.b(this);
            this.b(c_g.i, c_g.j, c_g.k, 0.0f, 0.0f);
        } else {
            this.inventorySlots = new C_j(this.b, true);
        }
        this.craftingInventory = this.inventorySlots;
        this.v = 1.62f;
        this.W = 20;
        this.I = 20;
        this.V = "/char.png";
    }

    @Override
    public void b_() {
        if (this.itemInUse != null) {
            ItemStack itemStack = this.b.d();
            if (itemStack != this.itemInUse) {
                this.clearItemInUse();
            } else if (--this.itemInUseCount == 0 && !this.d.multiplayerWorld) {
                this.useItemAndUpdateStack();
            }
        }
        super.b_();
        if (!this.d.multiplayerWorld && this.craftingInventory != null && !this.craftingInventory.isUsableByPlayer(this)) {
            this.closeScreen();
            this.craftingInventory = this.inventorySlots;
        }
        this.addStat(StatList.minutesPlayedStat, 1);
    }

    protected void closeScreen() {
        this.craftingInventory = this.inventorySlots;
    }

    public void resetPlayerKeyState() {
    }

    @Override
    public void j() {
        this.v = 1.62f;
        this.a(0.6f, 1.8f);
        super.j();
        if (this.d != null) {
            this.d.y = this;
        }
        this.W = 20;
        this.ab = 0;
        this.isSneaking = 0;
    }

    public void respawnPlayer() {
        this.v = 1.62f;
        this.a(0.6f, 1.8f);
        super.j();
        if (this.d != null) {
            this.d.y = this;
        }
        this.ab = 0;
        this.isSneaking = 0;
        // decompiler artifact: EntityPlayer.b (inventory) shadows Entity.b (float,
        // fall distance); the bytecode targets the float — reach it via super.
        super.b = 0.0f;
    }

    @Override
    public void f() {
        ItemStack itemStack;
        float f;
        float f2;
        int n;
        if (this.d.E == 0 && this.W < 20 && this.H % 20 << 2 == 0) {
            this.b(1);
        }
        if (this.isLaying && this.W < 20 && this.H % 40 << 2 == 0) {
            this.b(1);
        }
        if (this.gamemode != 0) {
            this.J = 0;
        }
        InventoryPlayer c_b = this.b;
        for (n = 0; n < c_b.a.length; ++n) {
            if (c_b.a[n] == null) continue;
            c_b.a[n].updateAnimations(this.d, this, n, c_b.c == n);
        }
        this.Q = this.R;
        if (super.b >= 50.0f && this.isInCloud()) { // super.b = Entity fall distance
            this.triggerAchievement(AchievementList.cloud);
        }
        if (this.k != 0.0f || this.m != 0.0f) {
            if (this.isSitting) {
                this.isSitting = false;
            }
            if (this.isLaying) {
                this.isLaying = false;
            }
        }
        super.f();
        if (!(c_b.b[0] == null || c_b.b[0].c != Item.bootsHermes.ap || this.isFlying || this.isInRope() || this.isOnLadder() || this.isOnVine() || this.isInCobweb() || this.m() || this.l() || this.o() || this.isInIce() || this.isInCloud() || this.isInQuicksand())) {
            if (this.s) {
                this.k *= 1.25f;
                this.m *= 1.25f;
            }
            if (!this.s && Keyboard.isKeyDown((int)this.d.mc.w.m.b)) {
                this.l = this.d.type != 8 ? (float)((double)this.l + 0.07) : (float)((double)this.l + 0.03);
                this.isGliding = true;
                for (n = 0; n < 20; ++n) {
                    f2 = this.G.nextFloat() * 0.02f;
                    f = this.G.nextFloat() * 0.02f;
                    float f3 = this.G.nextFloat() * 0.02f;
                    this.d.a("puff", this.h + this.G.nextFloat() * this.w * 2.0f - this.w, this.i - 2.0f, this.j + this.G.nextFloat() * this.w * 2.0f - this.w, f2, f, f3);
                }
                ++this.counter;
                if (this.counter >= 20) {
                    this.counter = 0;
                    this.addStat(StatList.objectUseStats[this.b.b[0].c], 1);
                    c_b.b[0].damageItem(1, this.d);
                    if (c_b.b[0].d <= 0 && this.gamemode != 1) {
                        c_b.b[0] = null;
                        this.isGliding = false;
                    }
                }
            } else {
                if (this.d.type != 8) {
                    this.l = (float)((double)this.l + 0.02);
                }
                this.isGliding = false;
            }
            if (this.isJumping) {
                this.l *= 0.9f;
            }
            super.b /= 2.0f; // halve fall distance (Entity.b), not the inventory
        }
        if ((itemStack = c_b.charmSlot[0]) != null) {
            this.deflectProjectile = itemStack.c == Item.shield.ap;
            if (itemStack.c == Item.spectacles.ap) {
                if (!this.nightVision) {
                    this.d.mc.e.a();
                }
                this.nightVision = true;
            } else {
                this.resetEffects();
            }
            if (itemStack.c == Item.ring.ap) {
                this.J = 0;
            }
        } else {
            this.deflectProjectile = false;
            this.resetEffects();
        }
        if (itemStack != null && itemStack.c == Item.aquaCharm.ap && !this.isInWater() && this.isSneaking == 2 && this.d.g((int)this.h, (int)this.i - 1, (int)this.j)) {
            this.d.a((int)this.h, (int)this.i - 1, (int)this.j, Block.ice.at);
            itemStack.damageItem2(1, this.d);
            this.addStat(StatList.objectUseStats[itemStack.c], 1);
        }
        this.K = this.b.b[3] != null && this.b.b[3].c == Item.ah.ap ? 600 : 300;
        if (itemStack != null && itemStack.a() == Item.vial) {
            this.poison = 0;
            if (this.l() && this.d.theme == 4) {
                this.triggerAchievement(AchievementList.reducePoison);
            }
        }
        if (this.nightVisionTimer > 0) {
            --this.nightVisionTimer;
            if (this.nightVisionTimer == 1) {
                this.nightVision = false;
                this.d.mc.e.a();
            }
        }
        if (!net.minecraft.client.d.getMinecraft().statFileWriter.hasAchievementUnlocked(AchievementList.armor) && c_b.b[0] != null && c_b.b[0].a() instanceof net.minecraft.a.b.C_j && c_b.b[1] != null && c_b.b[1].a() instanceof net.minecraft.a.b.C_j && c_b.b[2] != null && c_b.b[2].a() instanceof net.minecraft.a.b.C_j && c_b.b[3] != null && c_b.b[3].a() instanceof net.minecraft.a.b.C_j) {
            this.triggerAchievement(AchievementList.armor);
        }
        if (!net.minecraft.client.d.getMinecraft().statFileWriter.hasAchievementUnlocked(AchievementList.buildQuiver) && c_b.charmSlot[0] != null && c_b.charmSlot[0].a() == Item.quiver) {
            this.triggerAchievement(AchievementList.buildQuiver);
        }
        if (!net.minecraft.client.d.getMinecraft().statFileWriter.hasAchievementUnlocked(AchievementList.buildCharm) && c_b.charmSlot[0] != null && c_b.charmSlot[0].a() instanceof C_aa) {
            this.triggerAchievement(AchievementList.buildCharm);
        }
        if (this.isJumping && this.s) {
            this.addStat(StatList.jumpStat, 1);
        }
        f2 = MathHelper.c(this.k * this.k + this.m * this.m);
        f = (float)Math.atan(-this.l * 0.2f) * 15.0f;
        if (f2 > 0.1f) {
            f2 = 0.1f;
        }
        if (!this.s || this.W <= 0) {
            f2 = 0.0f;
        }
        if (this.s || this.W <= 0) {
            f = 0.0f;
        }
        if (this.s || this.l() || this.o()) {
            this.counter = 0;
        }
        if ((this.isOnLadder() || this.isInRope() || this.isOnVine()) && Keyboard.isKeyDown((int)42)) {
            this.l = 0.0f;
        }
        this.R += (f2 - this.R) * 0.4f;
        this.ae += (f - this.ae) * 0.8f;
        List<net.minecraft.a.c.Entity> list = this.d.a(this, this.r.b(1.0f, 0.0f, 1.0f));
        if (this.W > 0 && list != null) {
            for (int i = 0; i < list.size(); ++i) {
                net.minecraft.a.c.Entity c_b2 = list.get(i);
                c_b2.a(this);
            }
        }
    }

    private void resetEffects() {
        if (this.nightVision && this.nightVisionTimer == 0) {
            this.d.mc.e.a();
        }
        if (this.nightVisionTimer == 0) {
            this.nightVision = false;
        }
    }

    @Override
    protected void a(int n) {
        if (this.b.charmSlot[0] == null || this.b.charmSlot[0].c != Item.ring.ap) {
            this.attackEntityFrom(null, n, 0.0f);
        }
    }

    @Override
    public boolean canBreatheUnderwater() {
        return this.b.charmSlot[0] != null && this.b.charmSlot[0].c == Item.aquaCharm.ap;
    }

    @Override
    public void attackEntityDuringBloodRain() {
        if (this.b.charmSlot[0] == null || this.b.charmSlot[0].c != Item.ring.ap) {
            super.attackEntityDuringBloodRain();
        }
    }

    @Override
    public void attackEntityDuringPoisonRain() {
        if (this.b.charmSlot[0] == null || this.b.charmSlot[0].c != Item.vial.ap) {
            super.attackEntityDuringPoisonRain();
        }
    }

    @Override
    public final boolean isOnLadder() {
        if (this.b.charmSlot[0] != null && this.b.charmSlot[0].c == Item.gloves.ap) {
            return this.t;
        }
        return super.isOnLadder();
    }

    @Override
    public final void d(net.minecraft.a.c.Entity c_b) {
        this.a(0.2f, 0.2f);
        this.b(this.h, this.i, this.j);
        this.l = 0.1f;
        if (!this.keepInventory) {
            this.b.dropAllItems();
        }
        if (c_b != null) {
            this.k = -MathHelper.b((this.aa + this.n) * (float)Math.PI / 180.0f) * 0.1f;
            this.m = -MathHelper.a((this.aa + this.n) * (float)Math.PI / 180.0f) * 0.1f;
        } else {
            this.m = 0.0f;
            this.k = 0.0f;
        }
        this.isSneaking = 0;
        this.v = 0.1f;
        if (this.nightVision) {
            this.nightVision = false;
            this.d.mc.e.a();
        }
        if (this.W <= 0) {
            this.d.mc.a(new C_d());
        }
        this.addStat(StatList.deathsStat, 1);
        if (c_b != null && c_b instanceof EntityLiving && ((EntityLiving)c_b).statId() >= 0) {
            this.addStat(StatList.objectDeathStats[((EntityLiving)c_b).statId()], 1);
        }
    }

    @Override
    public void awardKillScore(net.minecraft.a.c.Entity c_b, int n) {
        Item item = null;
        boolean bl = false;
        if (this.b.a[this.b.c] != null) {
            item = this.b.a[this.b.c].a();
            boolean bl2 = bl = item == Item.C || item == Item.battleAxeGold || item == Item.spearGold;
        }
        if (!this.u) {
            if (bl) {
                n *= 2;
            }
            this.P += n;
            if (this.P >= 100000) {
                this.triggerAchievement(AchievementList.scoring);
            }
        }
        this.addStat(StatList.mobKillsStat, 1);
        if (c_b instanceof net.minecraft.a.c.a.C_e) {
            this.triggerAchievement(AchievementList.killEnemy);
        }
        if (c_b instanceof net.minecraft.a.c.a.C_a) {
            this.triggerAchievement(AchievementList.killGiant);
            if (bl) {
                this.triggerAchievement(AchievementList.killGiantSpecial);
            }
        }
        if (c_b instanceof C_h && !this.s && this.isGliding) {
            this.triggerAchievement(AchievementList.killHarpySpecial);
        }
        if (c_b instanceof C_g && c_b.isLaying) {
            this.triggerAchievement(AchievementList.killAntlionSpecial);
        }
    }

    public final void a(ItemStack itemStack) {
        if (!this.d.multiplayerWorld) {
            this.a(itemStack, false);
        }
    }

    @Override
    public int getItemIcon(ItemStack itemStack) {
        int n;
        int n2 = super.getItemIcon(itemStack);
        if (itemStack.c == Item.fishingRod.ap && this.fishEntity != null) {
            n2 = itemStack.getIconIndex() + 32;
        }
        if (this.itemInUse != null && itemStack.c == Item.g.ap) {
            n = itemStack.getMaxItemUseDuration() - this.itemInUseCount;
            if (n >= 18) {
                return 395;
            }
            if (n > 13) {
                return 394;
            }
            if (n > 0) {
                return 393;
            }
        }
        if (this.itemInUse != null && itemStack.c == Item.crossbow.ap) {
            n = itemStack.getMaxItemUseDuration() - this.itemInUseCount;
            if (n >= 24) {
                return 456;
            }
            if (n >= 12) {
                return 455;
            }
        }
        return n2;
    }

    public void dropCurrentItem() {
        this.a(this.b.a(this.b.c, 1), false);
    }

    public void a(ItemStack itemStack, boolean bl) {
        if (itemStack != null && !this.d.multiplayerWorld) {
            net.minecraft.a.c.c.EntityItem c_b = new net.minecraft.a.c.c.EntityItem(this.d, this.h, this.i - 0.3f, this.j, itemStack);
            c_b.O = 40;
            if (bl) {
                float f = this.G.nextFloat() * 0.5f;
                float f2 = this.G.nextFloat() * (float)Math.PI * 2.0f;
                c_b.k = -MathHelper.a(f2) * f;
                c_b.m = MathHelper.b(f2) * f;
                c_b.l = 0.2f;
            } else {
                c_b.k = -MathHelper.a(this.n / 180.0f * (float)Math.PI) * MathHelper.b(this.o / 180.0f * (float)Math.PI) * 0.3f;
                c_b.m = MathHelper.b(this.n / 180.0f * (float)Math.PI) * MathHelper.b(this.o / 180.0f * (float)Math.PI) * 0.3f;
                c_b.l = -MathHelper.a(this.o / 180.0f * (float)Math.PI) * 0.3f + 0.1f;
                float f = this.G.nextFloat() * (float)Math.PI * 2.0f;
                float f3 = 0.02f * this.G.nextFloat();
                c_b.k = (float)((double)c_b.k + Math.cos(f) * (double)f3);
                c_b.l += (this.G.nextFloat() - this.G.nextFloat()) * 0.1f;
                c_b.m = (float)((double)c_b.m + Math.sin(f) * (double)f3);
            }
            this.d.spawnEntityInWorld(c_b);
            this.addStat(StatList.dropStat, 1);
            this.addStat(StatList.objectDisposeStats[itemStack.c], 1);
        }
    }

    public final boolean canHarvestBlock(Block c_x, byte by) {
        ItemStack itemStack;
        Block c_x2 = c_x;
        InventoryPlayer c_b = this.b;
        return c_x2.getMaterial(by) != net.minecraft.a.a.d.Material.d && c_x2.getMaterial(by) != net.minecraft.a.a.d.Material.magma && c_x2.getMaterial(by) != net.minecraft.a.a.d.Material.e && c_x2.getMaterial(by) != net.minecraft.a.a.d.Material.vacuum && c_x2.getMaterial(by) != net.minecraft.a.a.d.Material.pulley ? true : ((itemStack = c_b.a(c_b.c)) != null ? Item.b[itemStack.c].canHarvestBlock(c_x2, by) : false);
    }

    @Override
    protected void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        this.gamemode = nBTTagCompound.c("Gamemode");
        this.difficulty = nBTTagCompound.c("Difficulty");
        this.isSneaking = nBTTagCompound.c("Sneaking");
        this.isFlying = nBTTagCompound.k("Flying");
        super.R = nBTTagCompound.k("IsInWater"); // Entity.R (boolean), shadowed by float R
        this.cheats = nBTTagCompound.k("Cheats");
        this.nightVision = nBTTagCompound.k("NightVision");
        this.nightVisionTimer = nBTTagCompound.d("NightVisionTime");
        this.keepInventory = nBTTagCompound.k("KeepInventory");
        this.isHardcoreEnabled = nBTTagCompound.k("Hardcore");
        this.name = nBTTagCompound.g("Name");
        this.setSneakState(this.isSneaking);
    }

    @Override
    protected void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
        nBTTagCompound.a("Gamemode", (short)this.gamemode);
        nBTTagCompound.a("Difficulty", (short)this.difficulty);
        nBTTagCompound.a("Sneaking", (short)this.isSneaking);
        nBTTagCompound.a("Flying", this.isFlying);
        nBTTagCompound.a("IsInWater", super.R); // Entity.R (boolean)
        nBTTagCompound.a("Cheats", this.cheats);
        nBTTagCompound.a("NightVision", this.nightVision);
        nBTTagCompound.a("NightVisionTime", this.nightVisionTimer);
        nBTTagCompound.a("KeepInventory", this.keepInventory);
        nBTTagCompound.a("Hardcore", this.isHardcoreEnabled);
        nBTTagCompound.a("Name", this.name);
    }

    @Override
    public String a() {
        return null;
    }

    public void a(net.minecraft.a.C_b c_b) {
    }

    public void displayGUIBarrel(net.minecraft.a.C_b c_b, boolean bl) {
    }

    public void displayWorkbenchGUI(int n, int n2, int n3) {
    }

    public void a(net.minecraft.a.c.Entity c_b) {
    }

    public void a(net.minecraft.a.a.b.a.C_b c_b) {
    }

    public void displayGUIBook(ItemStack itemStack) {
    }

    public void displayGUIBookshelf(net.minecraft.a.C_b c_b) {
    }

    public void displayGUIEnderChest(net.minecraft.a.C_b c_b) {
    }

    public void displayGUIGenerator(net.minecraft.a.a.b.a.C_h c_h) {
    }

    @Override
    public final float n() {
        return 0.12f;
    }

    @Override
    public boolean attackEntityFrom(net.minecraft.a.c.Entity c_b, int n, float f) {
        if (!this.d.z || this.d.multiplayerWorld) {
            return false;
        }
        this.ai = 0;
        if (this.W <= 0) {
            return false;
        }
        if ((float)this.L > (float)this.S / 2.0f) {
            return false;
        }
        if (c_b instanceof net.minecraft.a.c.a.C_e || c_b instanceof C_a || c_b instanceof net.minecraft.a.c.d.C_b) {
            if (this.d.E == 0) {
                n = 0;
            }
            if (this.d.E == 1) {
                n = n / 3 + 1;
            }
            if (this.d.E == 3) {
                n = n * 3 / 2;
            }
        }
        if (this.isBlocking()) {
            n = 1 + n >> 1;
        }
        int n2 = 25 - this.b.e();
        n2 = n * n2 + this.a;
        int n3 = n;
        InventoryPlayer c_b2 = this.b;
        for (int i = 0; i < c_b2.b.length; ++i) {
            if (c_b2.b[i] == null || !(c_b2.b[i].a() instanceof net.minecraft.a.b.C_j)) continue;
            c_b2.b[i].damageItem(n3, this.d);
            this.addStat(StatList.objectUseStats[c_b2.b[i].c], 1);
            if (c_b2.b[i].a != 0) continue;
            c_b2.b[i] = null;
        }
        n = n2 / 25;
        this.a = n2 % 25;
        if (n == 0) {
            return false;
        }
        ItemStack itemStack = c_b2.charmSlot[0];
        if (itemStack != null && itemStack.c == Item.spectacles.ap) {
            if (this.b.charmSlot[0] != null && this.b.charmSlot[0].d <= 0) {
                this.resetEffects();
            }
            itemStack.damageItem2(n3, this.d);
            this.addStat(StatList.objectUseStats[itemStack.c], 1);
        } else if (itemStack != null && itemStack.c == Item.vial.ap && c_b != null) {
            itemStack.damageItem2(1, this.d);
            c_b.poison = 300;
            this.addStat(StatList.objectUseStats[itemStack.c], 1);
        }
        this.addStat(StatList.damageTakenStat, n);
        return super.attackEntityFrom(c_b, n, f);
    }

    @Override
    protected void e() {
        if (this.isSwinging) {
            ++this.swingProgressInt;
            if (this.swingProgressInt >= 8) {
                this.swingProgressInt = 0;
                this.isSwinging = false;
            }
        } else {
            this.swingProgressInt = 0;
        }
        this.swingProgress = (float)this.swingProgressInt / 8.0f;
    }

    @Override
    public void onStruckByLightning(C_f c_f) {
        super.onStruckByLightning(c_f);
        this.addStat(StatList.lightningStrike, 1);
    }

    @Override
    public boolean isInSlime() {
        boolean bl = this.d.a(this.r.b(-0.1f, 0.1f, -0.1f), net.minecraft.a.a.d.Material.slime);
        if (bl) {
            this.triggerAchievement(AchievementList.bounce);
        }
        return bl;
    }

    public void addMovementStat(double d2, double d3, double d4) {
        if (this.ridingEntity == null) {
            if (this.m()) {
                int n = Math.round(MathHelper.sqrt_double(d2 * d2 + d4 * d4) / 100.0f);
                if (n > 0) {
                    this.addStat(StatList.distanceSwumStat, n);
                }
            } else if (this.isOnLadder()) {
                if (d3 > 0.0) {
                    this.addStat(StatList.distanceClimbedStat, (int)Math.round(d3 / 10.0));
                }
            } else if (this.s) {
                int n = Math.round(MathHelper.sqrt_double(d2 * d2 + d4 * d4) / 100.0f);
                if (n > 0) {
                    // empty if block
                }
                switch (this.isSneaking) {
                    case 1: {
                        this.addStat(StatList.distanceSneakedStat, n);
                        break;
                    }
                    case 2: {
                        this.addStat(StatList.distanceCrawledStat, n);
                        break;
                    }
                    case 0: {
                        this.addStat(StatList.distanceWalkedStat, n);
                    }
                }
                n = Math.round(MathHelper.sqrt_double(d2 * d2 + d4 * d4) / 100.0f);
                if (n > 0) {
                    this.addStat(StatList.distanceWalkedStat, n);
                }
            } else {
                int n = Math.round(MathHelper.sqrt_double(d2 * d2 + d4 * d4) / 100.0f);
                if (n > 0) {
                    this.addStat(StatList.distanceFlownStat, n);
                }
            }
        }
    }

    private void addMountedMovementStat(double d2, double d3, double d4) {
        int n;
        if (this.ridingEntity != null && (n = Math.round(MathHelper.sqrt_double(d2 * d2 + d3 * d3 + d4 * d4) * 100.0f)) > 0 && this.ridingEntity instanceof net.minecraft.a.c.c.C_g) {
            this.addStat(StatList.distanceByMinecartStat, n);
            if ((double)net.minecraft.client.d.getMinecraft().statFileWriter.getStatCount(StatList.distanceByMinecartStat) >= 100000.0) {
                this.triggerAchievement(AchievementList.onARail);
            }
        }
    }

    @Override
    public void updateRidden() {
        double d2 = this.h;
        double d3 = this.i;
        double d4 = this.j;
        super.updateRidden();
        this.Q = this.R;
        this.R = 0.0f;
        this.addMountedMovementStat((double)this.h - d2, (double)this.i - d3, (double)this.j - d4);
    }

    @Override
    protected void moveEntityWithHeading(float f, float f2) {
        super.moveEntityWithHeading(f, f2);
        this.addMovementStat(this.h, this.i, this.j);
    }

    @Override
    protected void b(float f) {
        if (!this.isFlying) {
            if (f >= 2.0f) {
                this.addStat(StatList.distanceFallenStat, (int)Math.round((double)f * 100.0));
            }
            super.b(f);
        }
    }

    public void chatMessage(String string) {
    }

    public void sendMessage(String string) {
    }

    public void swingItem() {
        this.swingProgressInt = -1;
        this.isSwinging = true;
    }

    public void triggerAchievement(StatBase statBase) {
        this.addStat(statBase, 1);
        if (!net.minecraft.client.d.getMinecraft().statFileWriter.hasAchievementUnlocked(AchievementList.trophy)) {
            int n;
            int n2 = 0;
            int n3 = 0;
            List<Achievement> list = AchievementList.achievementList;
            List<Achievement> list2 = AchievementList.challengeList;
            for (n = 0; n < list.size(); ++n) {
                if (!net.minecraft.client.d.getMinecraft().statFileWriter.hasAchievementUnlocked(list.get(n))) continue;
                ++n2;
            }
            for (n = 0; n < list2.size(); ++n) {
                if (!net.minecraft.client.d.getMinecraft().statFileWriter.hasAchievementUnlocked(list2.get(n))) continue;
                ++n3;
            }
            if (n2 >= list.size() && n3 >= list2.size() - 1) {
                this.addStat(AchievementList.trophy, 1);
            }
        }
    }

    public void addStat(StatBase statBase, int n) {
    }

    public void displayGUIEditSign(C_l c_l) {
    }

    public float getBedOrientationInDegrees() {
        byte by = this.d.e((int)this.h, (int)this.i - 1, (int)this.j);
        int n = BlockBed.getDirectionFromMetadata(by);
        switch (n) {
            case 0: {
                return 90.0f;
            }
            case 1: {
                return 0.0f;
            }
            case 2: {
                return 270.0f;
            }
            case 3: {
                return 180.0f;
            }
        }
        return 0.0f;
    }

    public void damageItem(int n, ItemStack itemStack, net.minecraft.a.a.World c_g) {
        if (this.gamemode == 1) {
            return;
        }
        itemStack.damageItem(n, c_g);
    }

    public void attackTargetEntityWithCurrentItem(net.minecraft.a.c.Entity c_b, float f) {
        int n = this.b.getDamageVsEntity(c_b);
        net.minecraft.platform.Hooks.fireAttack(this, c_b, n); // platform attack event
        if (n > 0) {
            if (this.getCurrentEquippedItem() != null && (this.getCurrentEquippedItem().a() == Item.n || this.getCurrentEquippedItem().a() == Item.spearWood || this.getCurrentEquippedItem().a() == Item.battleAxeWood) && this.G.nextInt(3) == 0) {
                n *= 2;
                this.spawnCritParticles(c_b);
            }
            c_b.attackEntityFrom(this, n, f);
            ItemStack itemStack = this.getCurrentEquippedItem();
            if (itemStack != null && c_b instanceof EntityLiving) {
                itemStack.hitEntity((EntityLiving)c_b, this);
                if (itemStack.a <= 0) {
                    this.h_();
                }
            }
            if (this.b.charmSlot[0] != null) {
                if (this.b.charmSlot[0].a() == Item.vial) {
                    c_b.poison = 150;
                    this.addStat(StatList.objectUseStats[this.b.charmSlot[0].c], 1);
                    this.b.charmSlot[0].damageItem2(1, this.d);
                } else if (this.b.charmSlot[0].a() == Item.ring) {
                    c_b.J = 150;
                    this.addStat(StatList.objectUseStats[this.b.charmSlot[0].c], 1);
                    this.b.charmSlot[0].damageItem2(1, this.d);
                }
            }
        }
    }

    public void spawnCritParticles(net.minecraft.a.c.Entity c_b) {
    }

    public void attackTargetEntityWithCharm(net.minecraft.a.c.Entity c_b, float f) {
        int n = this.b.getCharmDamageVsEntity(c_b);
        if (n > 0) {
            c_b.attackEntityFrom(this, n, f);
            ItemStack itemStack = this.b.charmSlot[0];
            if (itemStack != null && c_b instanceof EntityLiving) {
                itemStack.damageItem2(1, this.d);
                itemStack.hitEntity((EntityLiving)c_b, this);
                this.addStat(StatList.objectUseStats[itemStack.c], 1);
            }
        }
    }

    public void useCurrentItemOnEntity(net.minecraft.a.c.Entity c_b) {
        ItemStack itemStack;
        if (!c_b.interact(this) && (itemStack = this.getCurrentEquippedItem()) != null && c_b instanceof EntityLiving) {
            itemStack.useItemOnEntity((EntityLiving)c_b, this);
            if (itemStack.a <= 0) {
                this.h_();
            }
        }
    }

    public void doRespawn() {
    }

    public ItemStack getCurrentEquippedItem() {
        return this.b.d();
    }

    public void h_() {
        this.b.a(this.b.c, null);
    }

    public void setItemInUse(ItemStack itemStack, int n) {
        if (itemStack != this.itemInUse) {
            this.itemInUse = itemStack;
            this.itemInUseCount = n;
            if (!this.d.multiplayerWorld) {
                this.setEating(true);
            }
        }
    }

    public void setEating(boolean bl) {
        this.setEntityFlag(4, bl);
    }

    public ItemStack getItemInUse() {
        return this.itemInUse;
    }

    public void stopUsingItem() {
        if (this.itemInUse != null) {
            this.itemInUse.onPlayerStoppedUsing(this.d, this, this.itemInUseCount);
        }
        this.clearItemInUse();
    }

    public boolean isUsingItem() {
        return this.itemInUse != null;
    }

    public void clearItemInUse() {
        this.itemInUse = null;
        this.itemInUseCount = 0;
        if (!this.d.multiplayerWorld) {
            this.setEating(false);
        }
    }

    public void useItemAndUpdateStack() {
        if (this.itemInUse != null) {
            int n = this.itemInUse.a;
            ItemStack itemStack = this.itemInUse.onFoodEaten(this.d, this);
            if (itemStack != this.itemInUse || itemStack != null && itemStack.a != n) {
                this.b.a[this.b.c] = itemStack;
                if (itemStack.a <= 0) {
                    this.b.a[this.b.c] = null;
                }
            }
            this.stopUsingItem();
            this.clearItemInUse();
        }
    }

    public int getItemInUseDuration() {
        return this.isUsingItem() ? this.itemInUse.getMaxItemUseDuration() - this.itemInUseCount : 0;
    }

    public int getItemInUseCount() {
        return this.itemInUseCount;
    }

    public boolean isBlocking() {
        return this.isUsingItem() && Item.b[this.itemInUse.c].getItemUseAction(this.itemInUse) == C_q.block;
    }
}

