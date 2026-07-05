/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet18SpawnPos
extends Packet {
    public float xPosition;
    public float yPosition;
    public float zPosition;

    public Packet18SpawnPos() {
    }

    public Packet18SpawnPos(float f, float f2, float f3) {
        this.xPosition = f;
        this.yPosition = f2;
        this.zPosition = f3;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.xPosition = dataInputStream.readFloat();
        this.yPosition = dataInputStream.readFloat();
        this.zPosition = dataInputStream.readFloat();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.xPosition);
        dataOutputStream.writeFloat(this.yPosition);
        dataOutputStream.writeFloat(this.zPosition);
    }

    @Override
    public int getPacketSize() {
        return 12;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleSpawnPositionLocal(this);
    }
}

