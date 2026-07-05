/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package net.minecraft.client.g;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.World;
import net.minecraft.a.c.Entity;
import net.minecraft.client.C_l;
import net.minecraft.client.d;
import net.minecraft.client.g.C_a;
import net.minecraft.client.statistics.StatBase;
import net.minecraft.network.NetClientHandler;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet11PlayerPosition;
import net.minecraft.network.packet.Packet12PlayerLook;
import net.minecraft.network.packet.Packet13PlayerLookMove;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet18SpawnPos;
import net.minecraft.network.packet.Packet19Animation;
import net.minecraft.network.packet.Packet26PlayerState;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet9Respawn;
import org.lwjgl.input.Keyboard;

public class C_d
extends C_a {
    public NetClientHandler sendQueue;
    private int ticksExistedOnServer = 0;
    private boolean isPlayerDead = false;
    private double oldPosX;
    private double boundingBoxOffsetY;
    private double oldPosY;
    private double oldPosZ;
    private float oldRotationYaw;
    private float oldRotationPitch;
    private boolean isSuspendedInMidair = false;
    private int fallDistanceOnServer = 0;
    public boolean canUpdate = false;

    public C_d(d d2, World c_g, C_l c_l, NetClientHandler netClientHandler) {
        super(d2, c_g, c_l);
        this.sendQueue = netClientHandler;
    }

    @Override
    public boolean attackEntityFrom(Entity c_b, int n, float f) {
        return false;
    }

    @Override
    public void b(int n) {
    }

    @Override
    public void b_() {
        if (this.canUpdate) {
            super.b_();
            this.updatePlayerOnServer();
        }
    }

    @Override
    public void sendMessage(String string) {
        this.sendQueue.addToSendQueue(new Packet3Chat(string));
    }

    public void updatePlayerOnServer() {
        if (this.canUpdate) {
            boolean bl;
            if (this.ticksExistedOnServer++ == 20) {
                this.sendInventoryChanged();
                this.ticksExistedOnServer = 0;
            }
            double d2 = (double)this.h - this.oldPosX;
            double d3 = (double)this.r.b - this.boundingBoxOffsetY;
            double d4 = (double)this.i - this.oldPosY;
            double d5 = (double)this.j - this.oldPosZ;
            double d6 = this.n - this.oldRotationYaw;
            double d7 = this.o - this.oldRotationPitch;
            boolean bl2 = d3 != 0.0 || d4 != 0.0 || d2 != 0.0 || d5 != 0.0;
            boolean bl3 = bl = d6 != 0.0 || d7 != 0.0;
            if (bl2 && bl) {
                this.sendQueue.addToSendQueue(new Packet13PlayerLookMove(this.h, this.r.b, this.i, this.j, this.n, this.o, this.s));
                this.fallDistanceOnServer = 0;
            } else if (bl2) {
                this.sendQueue.addToSendQueue(new Packet11PlayerPosition(this.h, this.r.b, this.i, this.j, this.s));
                this.fallDistanceOnServer = 0;
            } else if (bl) {
                this.sendQueue.addToSendQueue(new Packet12PlayerLook(this.n, this.o, this.s));
                this.fallDistanceOnServer = 0;
            } else {
                this.sendQueue.addToSendQueue(new Packet10Flying(this.s));
                this.fallDistanceOnServer = this.isSuspendedInMidair == this.s && this.fallDistanceOnServer <= 200 ? ++this.fallDistanceOnServer : 0;
            }
            this.isSuspendedInMidair = this.s;
            if (bl2) {
                this.oldPosX = this.h;
                this.boundingBoxOffsetY = this.r.b;
                this.oldPosY = this.i;
                this.oldPosZ = this.j;
            }
            if (bl) {
                this.oldRotationYaw = this.n;
                this.oldRotationPitch = this.o;
            }
        }
    }

    @Override
    public void dropCurrentItem() {
        this.sendQueue.addToSendQueue(new Packet14BlockDig(4, 0, 0, 0, 0));
        if (this.an.a.b) {
            this.b.a(this.b.c, 1);
        }
    }

    private void sendInventoryChanged() {
    }

    protected void joinEntityItemWithWorld(net.minecraft.a.c.c.EntityItem c_b) {
    }

    public void sendChatMessage(String string) {
        this.sendQueue.addToSendQueue(new Packet3Chat(string));
    }

    @Override
    public void swingItem() {
        super.swingItem();
        this.sendQueue.addToSendQueue(new Packet19Animation(this, 1));
    }

    @Override
    public void respawnPlayer() {
        this.sendInventoryChanged();
        this.sendQueue.addToSendQueue(new Packet18SpawnPos(this.spawnX + 0.5f, this.spawnY, this.spawnZ + 0.5f));
    }

    protected void damageEntity(int n) {
        this.W -= n;
    }

    @Override
    public void closeScreen() {
        this.sendQueue.addToSendQueue(new Packet101CloseWindow(this.craftingInventory.windowId));
        this.b.setItemStack(null);
        super.closeScreen();
    }

    @Override
    public void setHealth(int n) {
        if (this.isPlayerDead) {
            super.setHealth(n);
        } else {
            this.W = n;
            this.isPlayerDead = true;
        }
    }

    @Override
    public final boolean setSneakState(int n) {
        if (this.isSneaking == n) {
            return false;
        }
        if (this.d.gamemode != 2 && (this.s || this.R) && this.canSneakHere() && this.isSneaking != 1 && !this.isSitting && !this.isLaying) {
            this.isSneaking = n;
            this.sendQueue.addToSendQueue(new Packet26PlayerState(this.entityId, (byte)this.isSneaking, this.canSneakHere()));
            switch (this.isSneaking) {
                case 1: {
                    this.v = 1.42f;
                    this.a(0.6f, 1.8f);
                    return true;
                }
                case 2: {
                    this.v = 0.56f;
                    this.a(0.6f, 0.9f);
                    this.b(this.h, this.i, this.j);
                    return true;
                }
            }
            this.v = 1.62f;
            this.a(0.6f, 1.8f);
            this.b(this.h, this.i + 1.6f, this.j);
            return true;
        }
        return false;
    }

    @Override
    public final boolean toggleSneak(int n) {
        if (this.isSneaking == n) {
            return false;
        }
        if (!(net.minecraft.client.d.getMinecraft().w.sneakMode || this.isSneaking == 2 || this.d.gamemode == 2 || !this.s || this.isInWater() || this.isSitting || this.isLaying || this.isFlying)) {
            this.isSneaking = n;
            this.sendQueue.addToSendQueue(new Packet26PlayerState(this.entityId, (byte)this.isSneaking, this.canSneakHere()));
            switch (this.isSneaking) {
                case 1: {
                    this.v = 1.42f;
                    return true;
                }
            }
            this.v = 1.62f;
            return true;
        }
        return false;
    }

    @Override
    protected void updateSneakState() {
        int n = this.isSneaking;
        if (Keyboard.isKeyDown((int)this.an.w.keyBindSneak.b) && this.isSneaking != 2 && this.s && !this.isInWater() && !this.isSitting && !this.isLaying && this.an.o == null) {
            this.isSneaking = 1;
            this.v = 1.42f;
        } else if (this.isSneaking != 2 && !this.isInWater() && !this.isSitting) {
            this.isSneaking = 0;
            this.v = 1.62f;
        }
        if (n != this.isSneaking) {
            n = this.isSneaking;
            this.sendQueue.addToSendQueue(new Packet26PlayerState(this.entityId, (byte)n, this.canSneakHere()));
        }
    }

    @Override
    protected void a(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void addStat(StatBase statBase, int n) {
    }

    @Override
    public String a() {
        return null;
    }

    @Override
    public void doRespawn() {
        this.sendInventoryChanged();
        this.sendQueue.addToSendQueue(new Packet9Respawn());
    }

    @Override
    public void displayGUIEditSign(net.minecraft.a.a.b.a.C_l c_l) {
        super.displayGUIEditSign(c_l);
    }
}

