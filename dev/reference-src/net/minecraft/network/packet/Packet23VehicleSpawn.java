/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet23VehicleSpawn
extends Packet {
    public int entityId;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int newX;
    public int newY;
    public int newZ;
    public EntityType type;
    public int updateCounter;
    public byte metadata;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.type = EntityType.fromID(dataInputStream.readByte());
        this.xPosition = dataInputStream.readInt();
        this.yPosition = dataInputStream.readInt();
        this.zPosition = dataInputStream.readInt();
        this.updateCounter = dataInputStream.readInt();
        if (this.updateCounter > 0) {
            this.newX = dataInputStream.readShort();
            this.newY = dataInputStream.readShort();
            this.newZ = dataInputStream.readShort();
        }
        this.metadata = dataInputStream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeByte(this.type.id);
        dataOutputStream.writeInt(this.xPosition);
        dataOutputStream.writeInt(this.yPosition);
        dataOutputStream.writeInt(this.zPosition);
        dataOutputStream.writeInt(this.updateCounter);
        if (this.updateCounter > 0) {
            dataOutputStream.writeShort(this.newX);
            dataOutputStream.writeShort(this.newY);
            dataOutputStream.writeShort(this.newZ);
        }
        dataOutputStream.writeByte(this.metadata);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleVehicleSpawn(this);
    }

    @Override
    public int getPacketSize() {
        return 21 + this.updateCounter > 0 ? 6 : 0;
    }

    public static enum EntityType {
        DART(100),
        MINECART(90),
        SAND(80),
        BOBBER(70),
        ARROW(60),
        TNT(50),
        SPEAR(40),
        SNOWBALL(30),
        SANDBALL(20),
        FIREBALL(10),
        FEATHER(0);

        public final int id;

        private EntityType(int n2) {
            this.id = n2;
        }

        public static EntityType fromID(int n) {
            for (EntityType entityType : EntityType.values()) {
                if (entityType.id != n) continue;
                return entityType;
            }
            throw new IllegalStateException("TYPE NOT MAPPED FOR ID " + n);
        }
    }
}

