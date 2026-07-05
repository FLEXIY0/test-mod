/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet52MultiBlockChange
extends Packet {
    public int xPosition;
    public int zPosition;
    public short[] coordinateArray;
    public byte[] typeArray;
    public byte[] metadataArray;
    public int size;

    public Packet52MultiBlockChange() {
        this.isChunkDataPacket = true;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.xPosition = dataInputStream.readInt();
        this.zPosition = dataInputStream.readInt();
        this.size = dataInputStream.readShort() & 0xFFFF;
        this.coordinateArray = new short[this.size];
        this.typeArray = new byte[this.size];
        this.metadataArray = new byte[this.size];
        for (int i = 0; i < this.size; ++i) {
            this.coordinateArray[i] = dataInputStream.readShort();
        }
        dataInputStream.readFully(this.typeArray);
        dataInputStream.readFully(this.metadataArray);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.xPosition);
        dataOutputStream.writeInt(this.zPosition);
        dataOutputStream.writeShort((short)this.size);
        for (int i = 0; i < this.size; ++i) {
            dataOutputStream.writeShort(this.coordinateArray[i]);
        }
        dataOutputStream.write(this.typeArray);
        dataOutputStream.write(this.metadataArray);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleMultiBlockChange(this);
    }

    @Override
    public int getPacketSize() {
        return 10 + this.size * 4;
    }
}

