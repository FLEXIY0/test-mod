/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.C_f;
import net.minecraft.network.DataWatcher;
import net.minecraft.network.NetHandler;
import net.minecraft.network.WatchableObject;
import net.minecraft.network.packet.Packet;
import util.MathHelper;

public class Packet24MobSpawn
extends Packet {
    public int entityId;
    public byte type;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte yaw;
    public byte pitch;
    private DataWatcher metaData;
    private List<WatchableObject> receivedMetadata;

    public Packet24MobSpawn() {
    }

    public Packet24MobSpawn(C_e c_e) {
        this.entityId = c_e.entityId;
        this.type = (byte)C_f.getEntityID(c_e);
        this.xPosition = MathHelper.a((double)c_e.h * 32.0);
        this.yPosition = MathHelper.a((double)c_e.i * 32.0);
        this.zPosition = MathHelper.a((double)c_e.j * 32.0);
        this.yaw = (byte)(c_e.n * 256.0f / 360.0f);
        this.pitch = (byte)(c_e.o * 256.0f / 360.0f);
        this.metaData = c_e.getDataWatcher();
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.type = dataInputStream.readByte();
        this.xPosition = dataInputStream.readInt();
        this.yPosition = dataInputStream.readInt();
        this.zPosition = dataInputStream.readInt();
        this.yaw = dataInputStream.readByte();
        this.pitch = dataInputStream.readByte();
        this.receivedMetadata = DataWatcher.readWatchableObjects(dataInputStream);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeByte(this.type);
        dataOutputStream.writeInt(this.xPosition);
        dataOutputStream.writeInt(this.yPosition);
        dataOutputStream.writeInt(this.zPosition);
        dataOutputStream.writeByte(this.yaw);
        dataOutputStream.writeByte(this.pitch);
        this.metaData.writeWatchableObjects(dataOutputStream);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleMobSpawn(this);
    }

    @Override
    public int getPacketSize() {
        return 20;
    }

    public List<WatchableObject> getMetadata() {
        return this.receivedMetadata;
    }
}

