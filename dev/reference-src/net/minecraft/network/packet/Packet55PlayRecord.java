/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet55PlayRecord
extends Packet {
    public int xLocation;
    public int yLocation;
    public int zLocation;
    public String name;

    public Packet55PlayRecord() {
    }

    public Packet55PlayRecord(int n, int n2, int n3, int n4, String string) {
        this.xLocation = n;
        this.yLocation = n2;
        this.zLocation = n3;
        this.name = string;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.xLocation = dataInputStream.readInt();
        this.yLocation = dataInputStream.readShort();
        this.zLocation = dataInputStream.readInt();
        this.name = Packet55PlayRecord.readString(dataInputStream, 30);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.xLocation);
        dataOutputStream.writeShort(this.yLocation);
        dataOutputStream.writeInt(this.zLocation);
        Packet55PlayRecord.writeString(this.name, dataOutputStream);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handlePlayRecord(this);
    }

    @Override
    public int getPacketSize() {
        return 12;
    }
}

