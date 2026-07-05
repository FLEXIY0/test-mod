/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.dx;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.c.a.C_m;
import net.minecraft.client.d;
import net.minecraft.client.dx.C_a;
import net.minecraft.client.e.C_c;
import net.minecraft.network.NetClientHandler;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet102WindowClick;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet27UseCharm;
import net.minecraft.network.packet.Packet7UseEntity;

public class C_d
extends C_a {
    private int currentBlockX = -1;
    private int currentBlockY = -1;
    private int currentblockZ = -1;
    private float curBlockDamageMP = 0.0f;
    private float prevBlockDamageMP = 0.0f;
    private float soundTimer = 0.0f;
    private int blockHitDelay = 0;
    private boolean isHittingBlock = false;
    private NetClientHandler netClientHandler;
    private int currentPlayerItem = 0;

    public C_d(d d2, NetClientHandler netClientHandler) {
        super(d2);
        this.netClientHandler = netClientHandler;
    }

    public void flipPlayer(EntityPlayer entityPlayer) {
        entityPlayer.n = -180.0f;
    }

    @Override
    public final void a(EntityPlayer entityPlayer) {
    }

    @Override
    public final boolean sendBlockRemoved(int n, int n2, int n3, int n4) {
        int n5 = this.a.d.a(n, n2, n3);
        byte by = this.a.d.e(n, n2, n3);
        boolean bl = super.sendBlockRemoved(n, n2, n3, n4);
        ItemStack itemStack = this.a.f.b.d();
        if (itemStack != null) {
            if (!this.a.d.multiplayerWorld && this.a.d.z) {
                Item.b[itemStack.c].b(itemStack);
            }
            if (itemStack.a == 0) {
                this.a.f.h_();
            }
        }
        if (bl && this.a.f.canHarvestBlock(Block.c[n5])) {
            Block.c[n5].f(this.a.d, n, n2, n3, by);
        }
        return bl;
    }

    @Override
    public GuiScreen displayInventory() {
        if (this.b) {
            return new C_m(this.a.f);
        }
        return super.displayInventory();
    }

    @Override
    public void clickBlock(int n, int n2, int n3, int n4) {
        if (!this.isHittingBlock || n != this.currentBlockX || n2 != this.currentBlockY || n3 != this.currentblockZ) {
            this.netClientHandler.addToSendQueue(new Packet14BlockDig(0, n, n2, n3, n4));
            int n5 = this.a.d.a(n, n2, n3);
            if (n5 <= 0 || this.curBlockDamageMP == 0.0f) {
                // empty if block
            }
            if (n5 > 0 && Block.c[n5].a(this.a.f) >= 1.0f) {
                this.extinguishFire(n, n2, n3, n4);
                this.sendBlockRemoved(n, n2, n3, n4);
            } else {
                this.isHittingBlock = true;
                this.currentBlockX = n;
                this.currentBlockY = n2;
                this.currentblockZ = n3;
                this.curBlockDamageMP = 0.0f;
                this.prevBlockDamageMP = 0.0f;
                this.soundTimer = 0.0f;
            }
        }
    }

    public void extinguishFire(int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            --n2;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        if (this.a.d.a(n, n2, n3) == Block.ag.at || this.a.d.a(n, n2, n3) == Block.hellfire.at) {
            this.a.d.a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.fizz", 0.5f, 2.6f + (this.a.d.q.nextFloat() - this.a.d.q.nextFloat()) * 0.8f);
            this.netClientHandler.addToSendQueue(new Packet14BlockDig(0, n, n2, n3, n4));
        }
    }

    @Override
    public void a() {
        this.curBlockDamageMP = 0.0f;
        this.isHittingBlock = false;
    }

    @Override
    public void a(int n, int n2, int n3, int n4) {
        byte by = this.a.d.e(n, n2, n3);
        if (this.isHittingBlock) {
            this.syncCurrentPlayItem();
            if (this.b) {
                this.isHittingBlock = false;
                this.netClientHandler.addToSendQueue(new Packet14BlockDig(2, n, n2, n3, n4));
                this.sendBlockRemoved(n, n2, n3, n4);
            } else if (this.blockHitDelay > 0) {
                --this.blockHitDelay;
            } else if (n == this.currentBlockX && n2 == this.currentBlockY && n3 == this.currentblockZ) {
                n4 = this.a.d.a(n, n2, n3);
                if (n4 != 0) {
                    Block c_x = Block.c[n4];
                    float f = 1.0f;
                    if (this.a.f.b.charmSlot[0] != null && this.a.f.b.charmSlot[0].a() == Item.bracelet && !this.a.f.isInWater()) {
                        f = 4.0f;
                    }
                    this.curBlockDamageMP += c_x.a(this.a.f) * f;
                    if (this.soundTimer % 4.0f == 0.0f && c_x != null) {
                        C_c c_c = this.a.x;
                        String string = c_x.getStepSound(by).a();
                        float f2 = (float)n + 0.5f;
                        float f3 = (float)n2 + 0.5f;
                        float f4 = (float)n3 + 0.5f;
                        float f5 = (c_x.getStepSound((int)by).a + 1.0f) / 8.0f;
                        c_c.playBlockSound(string, f2, f3, f4, f5, c_x.getStepSound((int)by).b * 0.5f);
                    }
                    this.soundTimer += 1.0f;
                    if (this.curBlockDamageMP >= 1.0f) {
                        this.isHittingBlock = false;
                        this.netClientHandler.addToSendQueue(new Packet14BlockDig(2, n, n2, n3, n4));
                        this.sendBlockRemoved(n, n2, n3, n4);
                        this.curBlockDamageMP = 0.0f;
                        this.curBlockDamageMP = 0.0f;
                        this.soundTimer = 0.0f;
                        this.blockHitDelay = 5;
                    }
                }
            } else {
                this.curBlockDamageMP = 0.0f;
                this.curBlockDamageMP = 0.0f;
                this.soundTimer = 0.0f;
                this.currentBlockX = n;
                this.currentBlockY = n2;
                this.currentblockZ = n3;
            }
        }
    }

    @Override
    public boolean d() {
        return !this.b;
    }

    @Override
    public void a(float f) {
        float f2;
        this.a.e.a = this.curBlockDamageMP <= 0.0f ? 0.0f : (f2 = this.prevBlockDamageMP + (this.curBlockDamageMP - this.prevBlockDamageMP) * f);
    }

    @Override
    public float b() {
        return this.b ? 5.0f : 4.0f;
    }

    @Override
    public final void a(World c_g) {
        super.a(c_g);
    }

    @Override
    public void c() {
        this.syncCurrentPlayItem();
        this.prevBlockDamageMP = this.curBlockDamageMP;
    }

    private void syncCurrentPlayItem() {
        int n = this.a.f.b.c;
        if (n != this.currentPlayerItem) {
            this.currentPlayerItem = n;
            this.netClientHandler.addToSendQueue(new Packet16BlockItemSwitch(this.currentPlayerItem));
        }
    }

    @Override
    public boolean sendPlaceBlock(EntityPlayer entityPlayer, World c_g, ItemStack itemStack, int n, int n2, int n3, int n4) {
        this.syncCurrentPlayItem();
        boolean bl = super.sendPlaceBlock(entityPlayer, c_g, itemStack, n, n2, n3, n4);
        this.netClientHandler.addToSendQueue(new Packet15Place(n, n2, n3, n4, entityPlayer.b.d()));
        return bl;
    }

    @Override
    public boolean sendUseItem(EntityPlayer entityPlayer, World c_g, ItemStack itemStack) {
        this.syncCurrentPlayItem();
        this.netClientHandler.addToSendQueue(new Packet15Place(-1, -1, -1, 255, entityPlayer.b.d()));
        boolean bl = super.sendUseItem(entityPlayer, c_g, itemStack);
        return bl;
    }

    @Override
    public void useSpecial(EntityPlayer entityPlayer, World c_g, ItemStack itemStack) {
        this.netClientHandler.addToSendQueue(new Packet27UseCharm(itemStack));
    }

    @Override
    public net.minecraft.client.g.C_a createPlayer(World c_g) {
        return new net.minecraft.client.g.C_d(this.a, c_g, this.a.h, this.netClientHandler);
    }

    @Override
    public void attackEntity(EntityPlayer entityPlayer, C_b c_b, float f) {
        this.syncCurrentPlayItem();
        this.netClientHandler.addToSendQueue(new Packet7UseEntity(entityPlayer.entityId, c_b.entityId, 1));
        entityPlayer.attackTargetEntityWithCurrentItem(c_b, f);
    }

    public void attackEntityWithCharm(EntityPlayer entityPlayer, C_b c_b, float f) {
        this.syncCurrentPlayItem();
        this.netClientHandler.addToSendQueue(new Packet7UseEntity(entityPlayer.entityId, c_b.entityId, 2));
        entityPlayer.attackTargetEntityWithCharm(c_b, f);
    }

    @Override
    public void interactWithEntity(EntityPlayer entityPlayer, C_b c_b) {
        this.syncCurrentPlayItem();
        this.netClientHandler.addToSendQueue(new Packet7UseEntity(entityPlayer.entityId, c_b.entityId, 0));
        entityPlayer.useCurrentItemOnEntity(c_b);
    }

    @Override
    public ItemStack clickSlot(int n, int n2, int n3, boolean bl, EntityPlayer entityPlayer) {
        short s = entityPlayer.craftingInventory.updateTransaction(entityPlayer.b);
        ItemStack itemStack = super.clickSlot(n, n2, n3, bl, entityPlayer);
        this.netClientHandler.addToSendQueue(new Packet102WindowClick(n, n2, n3, bl, itemStack, s));
        return itemStack;
    }

    @Override
    public void closeInventory(int n, EntityPlayer entityPlayer) {
        this.netClientHandler.addToSendQueue(new Packet101CloseWindow(entityPlayer.craftingInventory.windowId));
        super.closeInventory(n, entityPlayer);
    }
}

