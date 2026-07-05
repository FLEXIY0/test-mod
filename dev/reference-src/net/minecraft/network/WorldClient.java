/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.a.a.World;
import net.minecraft.a.c.C_b;
import net.minecraft.client.d;
import net.minecraft.network.NetClientHandler;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet255KickDisconnect;
import util.C_d;

public class WorldClient
extends World {
    private NetClientHandler sendQueue;
    private C_d entityHashSet = new C_d();
    private Set<C_b> entityList = new HashSet<C_b>();
    private Set<C_b> entitySpawnQueue = new HashSet<C_b>();
    private d mc;

    public WorldClient(d d2, NetClientHandler netClientHandler) {
        this.mc = d2;
        this.sendQueue = netClientHandler;
    }

    @Override
    public void f() {
        ++this.D;
        if (this.D == 24000) {
            this.D = 0;
        }
        this.season.tick();
        if (this.type != 5 && this.type != 8 && this.theme != 2 && !this.freezeWeatherUpdates) {
            this.updateWeather();
        }
        if (this.mc != null && this.a(this.mc.G.c) > 0.0f && this.bloodMoonChance == 9 && !this.bloodMoon) {
            this.bloodMoon = true;
            this.mc.t.addChatMessage("\u00a7cThe blood moon is rising...");
        } else if (this.bloodMoonChance != 9) {
            this.bloodMoon = false;
        }
        int n = this.e();
        if (this.B != n) {
            this.a(n);
        }
        if (this.type == 5) {
            if (this.soundCounter > 0) {
                --this.soundCounter;
            }
            if (this.soundCounter == 0 && !this.mc.l) {
                this.mc.x.playAllocatedAmbience("loops.cave chimes", 0.1f, 1.0f, false);
                this.soundCounter = this.I.nextInt(12000) + 6000;
            }
        }
        this.reloadNearEntities();
        if (this.D % 20 == 0) {
            this.sendQueue.addToSendQueue(new Packet0KeepAlive());
        }
        this.sendQueue.processReadPackets();
    }

    public void reloadNearEntities() {
        for (int i = 0; i < 10 && !this.entitySpawnQueue.isEmpty(); ++i) {
            C_b c_b = this.entitySpawnQueue.iterator().next();
            if (this.loadedEntityList.contains(c_b)) continue;
            this.spawnEntityInWorld(c_b);
            this.entitySpawnQueue.remove(c_b);
        }
    }

    @Override
    public boolean spawnEntityInWorld(C_b c_b) {
        boolean bl = super.spawnEntityInWorld(c_b);
        this.entityList.add(c_b);
        if (!bl) {
            this.entitySpawnQueue.add(c_b);
        }
        return bl;
    }

    @Override
    public void setEntityDead(C_b c_b) {
        super.setEntityDead(c_b);
        this.entityList.remove(c_b);
    }

    @Override
    public void obtainEntitySkin(C_b c_b) {
        super.obtainEntitySkin(c_b);
        if (this.entitySpawnQueue.contains(c_b)) {
            this.entitySpawnQueue.remove(c_b);
        }
    }

    @Override
    public void b(C_b c_b) {
        super.b(c_b);
        if (this.entityList.contains(c_b)) {
            if (c_b.r()) {
                this.entitySpawnQueue.add(c_b);
            } else {
                this.entityList.remove(c_b);
            }
        }
    }

    public void addEntityToWorld(int n, C_b c_b) {
        C_b c_b2 = this.getEntityByID(n);
        if (c_b2 != null) {
            this.setEntityDead(c_b2);
            this.removeEntityFromWorld(n);
        }
        this.entityList.add(c_b);
        c_b.entityId = n;
        if (!this.spawnEntityInWorld(c_b)) {
            this.entitySpawnQueue.add(c_b);
        }
        this.entityHashSet.addKey(n, c_b);
    }

    public C_b getEntityByID(int n) {
        return n == this.mc.f.entityId ? this.mc.f : (C_b)this.entityHashSet.lookup(n);
    }

    public C_b removeEntityFromWorld(int n) {
        C_b c_b = (C_b)this.entityHashSet.removeObject(n);
        if (c_b != null) {
            this.entityList.remove(c_b);
            this.setEntityDead(c_b);
        }
        return c_b;
    }

    public boolean markBlocksAsDirty(int n, int n2, int n3, int n4, int n5) {
        if (super.a(n, n2, n3, n4) && super.setBlockMetadata(n, n2, n3, n5)) {
            this.markBlocksDirty(n, n2, n3, n, n2, n3);
            return true;
        }
        return false;
    }

    @Override
    public void sendQuittingDisconnectingPacket() {
        this.sendQueue.sendPacketAndDie(new Packet255KickDisconnect("Quitting"));
    }

    @Override
    public void clearAllEntities() {
        super.clearAllEntities();
        this.entityList.clear();
        this.entitySpawnQueue.clear();
    }

    @Override
    protected void updateWeather() {
        if (this.weatherUpdates > 0) {
            --this.weatherUpdates;
        }
        if ((double)this.fogDistance > (double)(512 >> (this.fogDensity << 1))) {
            this.fogDistance = (float)((double)this.fogDistance - 0.1);
            if (this.fogDensity == 1 && this.fogDistance < 128.0f) {
                this.fogDistance = 128.0f;
            }
            if (this.fogDensity == 2 && this.fogDistance < 64.0f) {
                this.fogDistance = 64.0f;
            }
        } else if ((double)this.fogDistance < (double)(512 >> (this.fogDensity << 1))) {
            this.fogDistance = (float)((double)this.fogDistance + 0.1);
            if (this.fogDensity == 1 && this.fogDistance > 128.0f) {
                this.fogDistance = 128.0f;
            }
            if (this.fogDensity == 2 && this.fogDistance > 64.0f) {
                this.fogDistance = 64.0f;
            }
        }
        if (this.fogDistance > 512.0f) {
            this.fogDistance = 512.0f;
        }
        if (this.fogDistance < 16.0f) {
            this.fogDistance = 16.0f;
        }
        this.prevRainingStrength = this.rainingStrength;
        this.rainingStrength = this.getRaining() ? (float)((double)this.rainingStrength + 0.01) : (float)((double)this.rainingStrength - 0.01);
        if (this.rainingStrength < 0.0f) {
            this.rainingStrength = 0.0f;
        }
        if (this.rainingStrength > 1.0f) {
            this.rainingStrength = 1.0f;
        }
        this.prevThunderingStrength = this.thunderingStrength;
        this.thunderingStrength = this.getThundering() ? (float)((double)this.thunderingStrength + 0.01) : (float)((double)this.thunderingStrength - 0.01);
        if (this.thunderingStrength < 0.0f) {
            this.thunderingStrength = 0.0f;
        }
        if (this.thunderingStrength > 1.0f) {
            this.thunderingStrength = 1.0f;
        }
    }

    class WorldBlockPositionType {
        int xPosition;
        int yPosition;
        int zPosition;
        int unknownVar;
        int blockFace;
        int blockMetadata;
        final WorldClient world;

        public WorldBlockPositionType(WorldClient worldClient2, int n, int n2, int n3, int n4, int n5) {
            this.world = worldClient2;
            this.xPosition = n;
            this.yPosition = n2;
            this.zPosition = n3;
            this.unknownVar = 80;
            this.blockFace = n4;
            this.blockMetadata = n5;
        }
    }
}

