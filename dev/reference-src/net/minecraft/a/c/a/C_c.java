/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.a;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import net.minecraft.a.a.C_g;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.a.C_e;
import net.minecraft.a.c.d.C_a;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.AchievementList;
import util.MathHelper;

public class C_c
extends C_e {
    private boolean helmet;
    private boolean armor;
    private boolean legs;
    private boolean boots;
    private Object[][] type = new Object[][]{{new ItemStack(Item.U), new ItemStack(Item.bootsStudded), new ItemStack(Item.Y), new ItemStack(Item.ac), new ItemStack(Item.ak), new ItemStack(Item.bootsEmerald), new ItemStack(Item.ag)}, {new ItemStack(Item.T), new ItemStack(Item.legsStudded), new ItemStack(Item.X), new ItemStack(Item.ab), new ItemStack(Item.aj), new ItemStack(Item.legsEmerald), new ItemStack(Item.af)}, {new ItemStack(Item.S), new ItemStack(Item.plateStudded), new ItemStack(Item.W), new ItemStack(Item.aa), new ItemStack(Item.ai), new ItemStack(Item.plateEmerald), new ItemStack(Item.ae)}, {new ItemStack(Item.R), new ItemStack(Item.helmetStudded), new ItemStack(Item.V), new ItemStack(Item.Z), new ItemStack(Item.ah), new ItemStack(Item.helmetEmerald), new ItemStack(Item.ad)}};

    public C_c(C_g c_g) {
        super(c_g);
        this.V = "/mob/skeleton.png";
        if (!c_g.multiplayerWorld) {
            double d2 = 0.10000000298023223;
            d2 = c_g.isBloodMoon() ? 0.5000000029802323 : 0.10000000298023223;
            this.helmet = Math.random() < d2;
            this.armor = Math.random() < d2;
            this.legs = Math.random() < d2;
            boolean bl = this.boots = Math.random() < d2;
            if (this.boots) {
                this.armorInventory[0] = (ItemStack)this.type[0][this.G.nextInt(7)];
            }
            if (this.legs) {
                this.armorInventory[1] = (ItemStack)this.type[1][this.G.nextInt(7)];
            }
            if (this.armor) {
                this.armorInventory[2] = (ItemStack)this.type[2][this.G.nextInt(7)];
            }
            if (this.helmet) {
                this.armorInventory[3] = (ItemStack)this.type[3][this.G.nextInt(7)];
            }
        }
    }

    public C_c(C_g c_g, float f, float f2, float f3) {
        this(c_g);
        this.b(f, f2, f3);
    }

    @Override
    public final void f() {
        if (this.d.B > 7) {
            float f;
            float f2 = this.a(1.0f);
            if (f > 0.5f && this.d.l((int)this.h, (int)this.i, (int)this.j) && this.G.nextFloat() * 30.0f < (f2 - 0.4f) * 2.0f) {
                this.J = 300;
            }
        }
        super.f();
    }

    @Override
    protected final void a(C_b c_b, float f) {
        if (f < 10.0f) {
            f = c_b.h - this.h;
            float f2 = c_b.j - this.j;
            if (this.ac == 0) {
                C_a c_a = new C_a(this.d, this, 2, 1.0f);
                c_a.i += 1.0f;
                float f3 = c_b.i - 0.2f - c_a.i;
                float f4 = MathHelper.c(f * f + f2 * f2) * 0.2f;
                this.d.a(this, "random.bow", 1.0f, 1.0f / (this.G.nextFloat() * 0.4f + 0.8f));
                this.d.spawnEntityInWorld(c_a);
                c_a.a(f, f3 + f4, f2, 0.6f, 12.0f);
                this.ac = 30;
            }
            this.n = (float)(Math.atan2(f2, f) * 180.0 / 3.1415927410125732) - 90.0f;
            this.O = true;
        }
    }

    @Override
    public void d(C_b c_b) {
        super.d(c_b);
        if (c_b instanceof C_a) {
            C_a c_a = (C_a)c_b;
            if (c_a.S instanceof EntityPlayer) {
                EntityPlayer entityPlayer = (EntityPlayer)c_a.S;
                double d2 = entityPlayer.h - this.h;
                double d3 = entityPlayer.j - this.j;
                if (d2 * d2 + d3 * d3 >= 1000.0) {
                    entityPlayer.triggerAchievement(AchievementList.snipeSkeleton);
                }
            }
        }
    }

    @Override
    protected void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.armorInventory.length; ++i) {
            if (this.armorInventory[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)i);
            this.armorInventory[i].a(nBTTagCompound2);
            nBTTagList.a(nBTTagCompound2);
        }
        nBTTagCompound.a("Inventory", nBTTagList);
    }

    @Override
    protected void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        NBTTagList nBTTagList = nBTTagCompound.j("Inventory");
        this.armorInventory = new ItemStack[4];
        for (int i = 0; i < nBTTagList.b(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList.a(i);
            int n = nBTTagCompound2.b("Slot") & 0xFF;
            if (n < 0 || n >= this.armorInventory.length) continue;
            this.armorInventory[n] = new ItemStack(nBTTagCompound2);
        }
    }

    @Override
    protected final String g() {
        return "mob.skeleton";
    }

    @Override
    protected final String h() {
        return "mob.skeletonhurt";
    }

    @Override
    protected final String i() {
        return "mob.skeletondeath";
    }

    @Override
    public final String a() {
        return "Skeleton";
    }

    @Override
    protected final int itemDropped() {
        return Item.h.ap;
    }

    @Override
    public int c() {
        return 120;
    }

    @Override
    public int statId() {
        return 5;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public void attackEntityDuringBloodRain() {
    }

    @Override
    protected void dropFewItems(C_b c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            ItemStack itemStack;
            ItemStack itemStack2;
            ItemStack itemStack3;
            int n2;
            ItemStack itemStack4;
            int n3 = this.G.nextInt(3);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack4 = ((EntityPlayer)c_b).b.d()) != null && (itemStack4.a() == Item.C || itemStack4.a() == Item.battleAxeGold || itemStack4.a() == Item.spearGold)) {
                ++n3;
            }
            for (n2 = 0; n2 < n3; ++n2) {
                this.a(n, 1);
            }
            n2 = this.G.nextInt(3);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack3 = ((EntityPlayer)c_b).b.d()) != null && (itemStack3.a() == Item.C || itemStack3.a() == Item.battleAxeGold || itemStack3.a() == Item.spearGold)) {
                ++n2;
            }
            for (n3 = 0; n3 < n2; ++n3) {
                this.a(Item.bone.ap, 1);
            }
            int n4 = this.G.nextInt(25);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack2 = ((EntityPlayer)c_b).b.d()) != null && (itemStack2.a() == Item.C || itemStack2.a() == Item.battleAxeGold || itemStack2.a() == Item.spearGold)) {
                n4 = this.G.nextInt(10);
            }
            if (n4 == 0) {
                for (int i = 0; i < this.armorInventory.length; ++i) {
                    if (this.armorInventory[i] == null) continue;
                    this.entityDropItemAndMetadata(this.armorInventory[i].c, 1, this.G.nextInt(this.armorInventory[i].getMaxDamage()), 0.0f);
                }
            }
            int n5 = this.G.nextInt(40);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                n5 = this.G.nextInt(10);
            }
            if (n5 == 0) {
                this.entityDropItemAndMetadata(Item.g.ap, 1, this.G.nextInt(Item.g.d()), 0.0f);
            }
        }
    }
}

