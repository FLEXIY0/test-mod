/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.c;

import com.a.a.NBTTagCompound;
import java.util.HashSet;
import java.util.LinkedList;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.b.a.C_m;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public class EntityItem
extends net.minecraft.a.c.Entity {
    public ItemStack a;
    public int b = 0;
    public int O;
    private int R = 5;
    public float P = (float)(Math.random() * Math.PI * 2.0);

    public EntityItem(World c_g, float f, float f2, float f3, ItemStack itemStack) {
        super(c_g);
        this.a(0.25f, 0.25f);
        this.v = this.x / 2.0f;
        this.b(f, f2, f3);
        this.a = itemStack;
        this.n = (float)(Math.random() * 360.0);
        this.k = (float)(Math.random() * (double)0.2f - (double)0.1f);
        this.l = 0.2f;
        this.m = (float)(Math.random() * (double)0.2f - (double)0.1f);
        this.A = false;
    }

    public EntityItem(World c_g) {
        super(c_g);
        this.a(0.25f, 0.25f);
        this.v = this.x / 2.0f;
    }

    @Override
    protected void entityInit() {
    }

    @Override
    public final void b_() {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        super.b_();
        if (this.O > 0) {
            --this.O;
        }
        if (this.o()) {
            this.a(10);
            this.J = 600;
        }
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        this.l = this.m() && this.d.e((int)this.h, (int)(this.i + this.n()), (int)this.j) <= 1 ? (this.l += 0.004f) : (this.l -= 0.04f);
        if (this.d.l((int)this.h, (int)this.i, (int)this.j) && this.d.season.currentSeason == 2 && this.d.getWindForce() > 0.0f && this.s) {
            switch (this.d.getWindDirection()) {
                case 0: {
                    this.k = (float)(((double)this.k + (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 1: {
                    this.m = (float)(((double)this.m + (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 2: {
                    this.k = (float)(((double)this.k - (double)this.d.getWindForce()) * 0.01);
                    this.m = (float)(((double)this.m + (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 3: {
                    this.k = (float)(((double)this.k + (double)this.d.getWindForce()) * 0.01);
                    this.m = (float)(((double)this.m - (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 4: {
                    this.k = (float)(((double)this.k + (double)this.d.getWindForce()) * 0.01);
                    this.m = (float)(((double)this.m + (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 5: {
                    this.k = (float)(((double)this.k - (double)this.d.getWindForce()) * 0.01);
                    this.m = (float)(((double)this.m - (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 6: {
                    this.k = (float)(((double)this.k - (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 7: {
                    this.m = (float)(((double)this.m - (double)this.d.getWindForce()) * 0.01);
                }
            }
        }
        if (this.d.f((int)this.h, (int)this.i, (int)this.j) == Material.g) {
            this.l = 0.2f;
            this.k = (this.G.nextFloat() - this.G.nextFloat()) * 0.2f;
            this.m = (this.G.nextFloat() - this.G.nextFloat()) * 0.2f;
            this.d.a(this, "random.fizz", 0.4f, 2.0f + this.G.nextFloat() * 0.4f);
        }
        for (int i = -5; i < 6; ++i) {
            block19: for (int j = -5; j < 6; ++j) {
                int n7 = this.d.a((int)this.h, (int)this.i, (int)this.j + j);
                n6 = this.d.a((int)this.h + i, (int)this.i, (int)this.j);
                n5 = 1;
                if (n7 == Block.vacuum.at || n6 == Block.vacuum.at) {
                    n5 = -1;
                }
                if (n7 == Block.fan.at || n7 == Block.vacuum.at) {
                    switch (this.d.e((int)this.h, (int)this.i, (int)this.j + j)) {
                        case 6: {
                            if (j <= 0) break;
                            this.m = (float)((double)this.m - (double)n5 * 0.001);
                            break;
                        }
                        case 7: {
                            if (j >= 0) break;
                            this.m = (float)((double)this.m + (double)n5 * 0.001);
                        }
                    }
                }
                if (n6 != Block.fan.at && n6 != Block.vacuum.at) continue;
                switch (this.d.e((int)this.h + i, (int)this.i, (int)this.j)) {
                    case 8: {
                        if (i <= 0) continue block19;
                        this.k = (float)((double)this.k - (double)n5 * 0.001);
                        continue block19;
                    }
                    case 9: {
                        if (i >= 0) continue block19;
                        this.k = (float)((double)this.k + (double)n5 * 0.001);
                    }
                }
            }
        }
        float f = this.j;
        float f2 = this.i;
        float f3 = this.h;
        n6 = (int)f3;
        n5 = (int)f2;
        int n8 = (int)f;
        f3 -= (float)n6;
        f2 -= (float)n5;
        f -= (float)n8;
        if (Block.e[this.d.a(n6, n5, n8)] && this.d.a(n6, n5, n8) != Block.quickSand.at) {
            n4 = !Block.e[this.d.a(n6 - 1, n5, n8)] ? 1 : 0;
            n3 = !Block.e[this.d.a(n6 + 1, n5, n8)] ? 1 : 0;
            n2 = !Block.e[this.d.a(n6, n5 - 1, n8)] ? 1 : 0;
            n = !Block.e[this.d.a(n6, n5 + 1, n8)] ? 1 : 0;
            boolean bl = !Block.e[this.d.a(n6, n5, n8 - 1)];
            boolean bl2 = !Block.e[this.d.a(n6, n5, n8 + 1)];
            int n9 = -1;
            float f4 = 9999.0f;
            if (n4 != 0 && f3 < 9999.0f) {
                f4 = f3;
                n9 = 0;
            }
            if (n3 != 0 && 1.0f - f3 < f4) {
                f4 = 1.0f - f3;
                n9 = 1;
            }
            if (n2 != 0 && f2 < f4) {
                f4 = f2;
                n9 = 2;
            }
            if (n != 0 && 1.0f - f2 < f4) {
                f4 = 1.0f - f2;
                n9 = 3;
            }
            if (bl && f < f4) {
                f4 = f;
                n9 = 4;
            }
            if (bl2 && 1.0f - f < f4) {
                n9 = 5;
            }
            f3 = this.G.nextFloat() * 0.2f + 0.1f;
            if (n9 == 0) {
                this.k = -f3;
            }
            if (n9 == 1) {
                this.k = f3;
            }
            if (n9 == 2) {
                this.l = -f3;
            }
            if (n9 == 3) {
                this.l = f3;
            }
            if (n9 == 4) {
                this.m = -f3;
            }
            if (n9 == 5) {
                this.m = f3;
            }
        }
        this.d(this.k, this.l, this.m);
        this.k *= 0.98f;
        this.l *= 0.98f;
        this.m *= 0.98f;
        if (this.s) {
            this.k *= 0.7f;
            this.m *= 0.7f;
            this.l *= -0.5f;
        }
        ++this.b;
        if (this.b >= 6000 || this.isInCactus() || this.isInMagma()) {
            this.k();
        }
        if (this.isInVacuum() && !this.d.multiplayerWorld) {
            TileEntity c_a = this.d.j(MathHelper.a((double)this.h), MathHelper.a((double)(this.i - 1.0f)), MathHelper.a((double)this.j));
            n3 = this.d.a(MathHelper.a((double)this.h), MathHelper.a((double)(this.i - 1.0f)), MathHelper.a((double)this.j));
            if (n3 == Block.vacuum.at && c_a != null && c_a instanceof C_m && ((C_m)c_a).storePartialItemStack(this.a)) {
                this.k();
            }
        }
        if (this.isInsideOfMaterial(Material.portal) && !this.d.multiplayerWorld && this.a.c == Item.dyePowder.ap) {
            n4 = (int)this.h;
            n3 = (int)this.i;
            n2 = (int)this.j;
            n = this.a.d;
            this.floodFillPortal(this.d, n4, n3, n2, n);
            this.d.mc.f.triggerAchievement(AchievementList.colorPortal);
            this.k();
        }
        this.tryObsidianCraft();
    }

    /**
     * Obsidian Book crafting: a thrown Book and Quill that comes to rest on an
     * obsidian block detonates (dynamite-style FX) and becomes an Obsidian Book
     * and Quill, carrying over its written pages.
     */
    private void tryObsidianCraft() {
        if (this.d.multiplayerWorld || this.a == null || this.a.a() != Item.bookAndQuill || !this.s) {
            return;
        }
        int bx = MathHelper.a((double)this.h);
        int by = MathHelper.a((double)(this.i - 0.2f));
        int bz = MathHelper.a((double)this.j);
        if (this.d.a(bx, by, bz) != Block.ae.at) {
            return;
        }
        this.d.a(this, "random.explode", 2.0f, 0.9f + this.G.nextFloat() * 0.2f);
        for (int p = 0; p < 24; ++p) {
            float mx = (this.G.nextFloat() - 0.5f) * 0.5f;
            float my = this.G.nextFloat() * 0.5f;
            float mz = (this.G.nextFloat() - 0.5f) * 0.5f;
            this.d.a("explode", this.h, this.i + 0.2f, this.j, mx, my, mz);
            this.d.a("smoke", this.h, this.i + 0.2f, this.j, mx * 0.5f, my * 0.5f, mz * 0.5f);
        }
        ItemStack out = new ItemStack(Item.obsidianBookAndQuill);
        if (this.a.hasTagCompound()) {
            out.setTagCompound((NBTTagCompound)this.a.getTagCompound().copy());
        }
        EntityItem drop = new EntityItem(this.d, this.h, this.i + 0.2f, this.j, out);
        drop.O = 10;
        this.d.spawnEntityInWorld(drop);
        this.k();
    }

    private void floodFillPortal(World c_g, int n, int n2, int n3, int n4) {
        HashSet<Long> hashSet = new HashSet<Long>();
        LinkedList<int[]> linkedList = new LinkedList<int[]>();
        linkedList.add(new int[]{n, n2, n3});
        while (!linkedList.isEmpty()) {
            int n5;
            int n6;
            int[] nArray = (int[])linkedList.poll();
            int n7 = nArray[0];
            long l = ((long)n7 & 0x3FFFFFFL) << 38 | ((long)(n6 = nArray[1]) & 0xFFFL) << 26 | (long)(n5 = nArray[2]) & 0x3FFFFFFL;
            if (hashSet.contains(l)) continue;
            hashSet.add(l);
            if (c_g.a(n7, n6, n5) != Block.portal.at) continue;
            if (c_g.e(n7, n6, n5) != n4) {
                c_g.setBlockMetadataWithNotify(n7, n6, n5, n4);
            }
            linkedList.add(new int[]{n7 + 1, n6, n5});
            linkedList.add(new int[]{n7 - 1, n6, n5});
            linkedList.add(new int[]{n7, n6, n5 + 1});
            linkedList.add(new int[]{n7, n6, n5 - 1});
            linkedList.add(new int[]{n7, n6 + 1, n5});
            linkedList.add(new int[]{n7, n6 - 1, n5});
        }
    }

    @Override
    protected final void a(int n) {
        this.attackEntityFrom(null, 1);
    }

    @Override
    protected final void convertHellfireItem() {
        if (!this.d.multiplayerWorld) {
            float f = this.j;
            float f2 = this.i;
            float f3 = this.h;
            World c_g = this.d;
            ItemStack itemStack = this.a;
            if (this.a.a().throwInFire(c_g, f3, f2, f)) {
                --itemStack.a;
            }
            if (this.a.a == 0) {
                this.k();
            }
        }
    }

    @Override
    public boolean isBurning() {
        return this.d.isBoundingBoxLava(this.r);
    }

    public final boolean attackEntityFrom(net.minecraft.a.c.Entity c_b, int n) {
        this.R -= n;
        if (this.R <= 0) {
            this.k();
        }
        return false;
    }

    @Override
    protected final void a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("Health", (short)((byte)this.R));
        nBTTagCompound.a("Age", (short)this.b);
        nBTTagCompound.a("Item", this.a.a(new NBTTagCompound()));
    }

    @Override
    protected final void b(NBTTagCompound nBTTagCompound) {
        this.R = nBTTagCompound.c("Health") & 0xFF;
        this.b = nBTTagCompound.c("Age");
        nBTTagCompound = nBTTagCompound.i("Item");
        this.a = new ItemStack(nBTTagCompound);
    }

    @Override
    public final String a() {
        return "Item";
    }

    @Override
    public final void a(EntityPlayer entityPlayer) {
        if (this.d.multiplayerWorld) {
            return;
        }
        if (this.O == 0 && this.a.a >= 1) {
            if (entityPlayer.b.charmSlot[0] != null && entityPlayer.b.charmSlot[0].a() == Item.quiver && (this.a.c == Item.h.ap || this.a.c == Item.arrowAdminium.ap) && entityPlayer.b.storeArrowInQuiver(this.a)) {
                this.d.a(this, "random.pop", 0.2f, ((this.G.nextFloat() - this.G.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                entityPlayer.a(this);
                this.k();
            } else if (entityPlayer.b.a(this.a)) {
                this.d.a(this, "random.pop", 0.2f, ((this.G.nextFloat() - this.G.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                entityPlayer.a(this);
                entityPlayer.addStat(StatList.collectStat, 1);
                entityPlayer.addStat(StatList.objectObtainStats[this.a.c], 1);
                this.k();
                if (this.a.c == Block.y.at || this.a.c == Block.mushroomStem.at || this.a.c == Block.flowerStem.at) {
                    entityPlayer.triggerAchievement(AchievementList.getWood);
                }
                if (this.a.c == Item.j.ap) {
                    entityPlayer.triggerAchievement(AchievementList.diamonds);
                }
                if (this.a.c == Item.emerald.ap) {
                    entityPlayer.triggerAchievement(AchievementList.emeralds);
                }
                if (this.a.c == Item.O.ap || this.a.c == Item.seedsMelon.ap || this.a.c == Item.seedsPumpkin.ap) {
                    entityPlayer.triggerAchievement(AchievementList.seeds);
                }
            }
        }
    }
}

