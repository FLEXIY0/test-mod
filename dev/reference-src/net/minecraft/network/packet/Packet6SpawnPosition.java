/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet6SpawnPosition
extends Packet {
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public float yaw;
    public float pitch;
    public boolean teleport;

    public Packet6SpawnPosition() {
    }

    public Packet6SpawnPosition(int n, int n2, int n3, float f, float f2, boolean bl) {
        this.xPosition = n;
        this.yPosition = n2;
        this.zPosition = n3;
        this.yaw = f;
        this.pitch = f2;
        this.teleport = bl;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.xPosition = dataInputStream.readInt();
        this.yPosition = dataInputStream.readInt();
        this.zPosition = dataInputStream.readInt();
        this.yaw = dataInputStream.readFloat();
        this.pitch = dataInputStream.readFloat();
        this.teleport = dataInputStream.readBoolean();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.xPosition);
        dataOutputStream.writeInt(this.yPosition);
        dataOutputStream.writeInt(this.zPosition);
        dataOutputStream.writeFloat(this.yaw);
        dataOutputStream.writeFloat(this.pitch);
        dataOutputStream.writeBoolean(this.teleport);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleSpawnPosition(this);
    }

    @Override
    public int getPacketSize() {
        return 21;
    }
}

