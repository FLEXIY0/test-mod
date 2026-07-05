/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet61DoorChange
extends Packet {
    public int xCoord;
    public int yCoord;
    public int zCoord;
    public int doorState;
    public int doorOrientation;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.xCoord = dataInputStream.readInt();
        this.zCoord = dataInputStream.readInt();
        this.doorState = dataInputStream.readByte();
        this.doorOrientation = dataInputStream.readInt();
        this.yCoord = dataInputStream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.xCoord);
        dataOutputStream.writeInt(this.zCoord);
        dataOutputStream.writeByte(this.doorState);
        dataOutputStream.writeInt(this.doorOrientation);
        dataOutputStream.writeInt(this.yCoord);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleDoorChange(this);
    }

    @Override
    public int getPacketSize() {
        return 20;
    }
}

