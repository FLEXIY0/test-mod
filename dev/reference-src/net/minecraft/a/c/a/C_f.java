/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.a;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.a.C_e;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.furniture.BlockDoor;

public class C_f
extends C_e {
    private boolean helmet;
    private boolean armor;
    private boolean legs;
    private boolean boots;
    private boolean item;
    private Object[][] type = new Object[][]{{new ItemStack(Item.U), new ItemStack(Item.bootsStudded), new ItemStack(Item.Y), new ItemStack(Item.ac), new ItemStack(Item.ak), new ItemStack(Item.bootsEmerald), new ItemStack(Item.ag)}, {new ItemStack(Item.T), new ItemStack(Item.legsStudded), new ItemStack(Item.X), new ItemStack(Item.ab), new ItemStack(Item.aj), new ItemStack(Item.legsEmerald), new ItemStack(Item.af)}, {new ItemStack(Item.S), new ItemStack(Item.plateStudded), new ItemStack(Item.W), new ItemStack(Item.aa), new ItemStack(Item.ai), new ItemStack(Item.plateEmerald), new ItemStack(Item.ae)}, {new ItemStack(Item.R), new ItemStack(Item.helmetStudded), new ItemStack(Item.V), new ItemStack(Item.Z), new ItemStack(Item.ah), new ItemStack(Item.helmetEmerald), new ItemStack(Item.ad)}};
    private Item[] items = new Item[]{Item.t, Item.u, Item.s, Item.K, Item.r, Item.spearStone, Item.battleAxeStone, Item.d, Item.e, Item.c, Item.L, Item.m, Item.spearSteel, Item.battleAxeIron, Item.E, Item.F, Item.D, Item.N, Item.C, Item.spearGold, Item.battleAxeGold, Item.pickaxeEmerald, Item.axeEmerald, Item.shovelEmerald, Item.hoeEmerald, Item.swordEmerald, Item.spearEmerald, Item.battleAxeEmerald, Item.x, Item.y, Item.w, Item.M, Item.v, Item.spearDiamond, Item.battleAxeDiamond, Item.p, Item.q, Item.o, Item.J, Item.n, Item.spearWood, Item.battleAxeWood};
    protected int doorPosX;
    protected int doorPosY;
    protected int doorPosZ;
    protected float distanceX;
    protected float distanceZ;
    protected boolean chasingDoor = false;
    protected int doorBreakTime;
    public ItemStack heldItem;

    public C_f(C_g c_g) {
        super(c_g);
        this.V = "/mob/zombie.png";
        this.am = 0.5f;
        this.a = 5;
        if (!c_g.multiplayerWorld) {
            double d2 = 0.10000000298023223;
            if (c_g.isBloodMoon()) {
                d2 = 0.5000000029802323;
            }
            this.helmet = Math.random() < d2;
            this.armor = Math.random() < d2;
            this.legs = Math.random() < d2;
            this.boots = Math.random() < d2;
            boolean bl = this.item = Math.random() < d2;
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
            if (this.item) {
                this.heldItem = new ItemStack(this.items[this.G.nextInt(this.items.length)]);
            }
        }
    }

    public C_f(C_g c_g, float f, float f2, float f3) {
        this(c_g);
        this.b(f, f2, f3);
    }

    @Override
    public final void f() {
        if (this.d.B > 7 && this.armorInventory[3] == null) {
            float f;
            float f2 = this.a(1.0f);
            if (f > 0.5f && this.d.l((int)this.h, (int)this.i, (int)this.j) && this.G.nextFloat() * 30.0f < (f2 - 0.4f) * 2.0f) {
                this.J = 300;
            }
        }
        if (this.d.isBloodMoon() && this.b != null) {
            if (!this.chasingDoor) {
                this.am = 0.5f;
                for (int i = -1; i < 2; ++i) {
                    for (int j = -1; j < 2; ++j) {
                        C_x c_x = C_x.c[this.d.a((int)this.h + i, (int)this.i, (int)this.j)];
                        C_x c_x2 = C_x.c[this.d.a((int)this.h, (int)this.i, (int)this.j + j)];
                        if (c_x instanceof BlockDoor && c_x != C_x.doorSteel) {
                            this.chasingDoor = true;
                            this.doorBreakTime = 240;
                            this.doorPosX = (int)this.h + i;
                            this.doorPosY = (int)this.i;
                            this.doorPosZ = (int)this.j;
                            this.distanceX = (float)this.doorPosX + 0.5f - this.h;
                            this.distanceZ = (float)this.doorPosZ + 0.5f - this.j;
                        }
                        if (!(c_x2 instanceof BlockDoor) || c_x2 == C_x.doorSteel) continue;
                        this.chasingDoor = true;
                        this.doorBreakTime = 240;
                        this.doorPosX = (int)this.h;
                        this.doorPosY = (int)this.i;
                        this.doorPosZ = (int)this.j + j;
                        this.distanceX = (float)this.doorPosX + 0.5f - this.h;
                        this.distanceZ = (float)this.doorPosZ + 0.5f - this.j;
                    }
                }
            } else {
                C_x c_x;
                float f = (float)this.doorPosX + 0.5f - this.h;
                float f3 = (float)this.doorPosZ + 0.5f - this.j;
                float f4 = this.distanceX * f + this.distanceZ * f3;
                if (f4 < 0.0f || f4 > 1.5f) {
                    this.chasingDoor = false;
                }
                this.am = 0.0f;
                this.isJumping = false;
                if (this.G.nextInt(20) == 0) {
                    this.d.a(this, "random.wood", 1.0f, (this.G.nextFloat() - this.G.nextFloat()) * 0.2f + 1.0f);
                }
                if (!((c_x = C_x.c[this.d.a(this.doorPosX, this.doorPosY, this.doorPosZ)]) instanceof BlockDoor)) {
                    this.chasingDoor = false;
                }
                if (--this.doorBreakTime == 0) {
                    this.d.b(this.doorPosX, this.doorPosY, this.doorPosZ, 0);
                    this.d.a(this, "random.woodbreak", 1.0f, (this.G.nextFloat() - this.G.nextFloat()) * 0.2f + 1.0f);
                    this.chasingDoor = false;
                }
            }
        }
        super.f();
    }

    @Override
    public final boolean attackEntityFrom(C_b c_b, int n, float f) {
        if (this.chasingDoor) {
            this.chasingDoor = false;
        }
        return super.attackEntityFrom(c_b, n, f);
    }

    @Override
    protected void a(C_b c_b, float f) {
        if (this.ac <= 0 && (double)f < 2.0 && c_b.r.e > this.r.b && c_b.r.b < this.r.e) {
            this.ac = 20;
            if (this.heldItem != null) {
                c_b.attackEntityFrom(this, this.a + this.heldItem.getDamageVsEntity(c_b), 0.4f);
            } else {
                c_b.attackEntityFrom(this, this.a, 0.4f);
            }
        }
    }

    @Override
    protected final String g() {
        return "mob.zombie";
    }

    @Override
    protected final String h() {
        return "mob.zombiehurt";
    }

    @Override
    protected final String i() {
        return "mob.zombiedeath";
    }

    @Override
    public final String a() {
        return "Zombie";
    }

    @Override
    protected final int itemDropped() {
        return Item.rottenFlesh.ap;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public void attackEntityDuringBloodRain() {
    }

    @Override
    protected void a(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2;
        super.a(nBTTagCompound);
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.armorInventory.length; ++i) {
            if (this.armorInventory[i] == null) continue;
            nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)i);
            this.armorInventory[i].a(nBTTagCompound2);
            nBTTagList.a(nBTTagCompound2);
        }
        if (this.heldItem != null) {
            nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)this.armorInventory.length);
            this.heldItem.a(nBTTagCompound2);
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
            if (n >= 0 && n < this.armorInventory.length) {
                this.armorInventory[n] = new ItemStack(nBTTagCompound2);
            }
            if (n != this.armorInventory.length) continue;
            this.heldItem = new ItemStack(nBTTagCompound2);
        }
    }

    @Override
    protected void dropFewItems(C_b c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            ItemStack itemStack;
            int n2;
            ItemStack itemStack2;
            ItemStack itemStack3;
            int n3 = this.G.nextInt(3);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack3 = ((EntityPlayer)c_b).b.d()) != null && (itemStack3.a() == Item.C || itemStack3.a() == Item.battleAxeGold || itemStack3.a() == Item.spearGold)) {
                ++n3;
            }
            for (int i = 0; i < n3; ++i) {
                this.a(n, 1);
            }
            n3 = this.G.nextInt(3);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack2 = ((EntityPlayer)c_b).b.d()) != null && (itemStack2.a() == Item.C || itemStack2.a() == Item.battleAxeGold || itemStack2.a() == Item.spearGold)) {
                ++n3;
            }
            for (n2 = 0; n2 < n3; ++n2) {
                this.a(Item.chainmail.ap, 1);
            }
            n2 = this.G.nextInt(25);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                n2 = this.G.nextInt(10);
            }
            if (n2 == 0) {
                for (int i = 0; i < this.armorInventory.length; ++i) {
                    if (this.armorInventory[i] == null) continue;
                    this.entityDropItemAndMetadata(this.armorInventory[i].c, 1, this.G.nextInt(this.armorInventory[i].getMaxDamage()), 0.0f);
                }
            }
            n2 = this.G.nextInt(25);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                n2 = this.G.nextInt(10);
            }
            if (n2 == 0 && this.heldItem != null) {
                this.entityDropItemAndMetadata(this.heldItem.c, 1, this.G.nextInt(this.heldItem.getMaxDamage()), 0.0f);
            }
        }
    }

    @Override
    public int c() {
        return 80;
    }

    @Override
    public int statId() {
        return 4;
    }
}

