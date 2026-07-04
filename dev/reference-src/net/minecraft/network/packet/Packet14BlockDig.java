/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet14BlockDig
extends Packet {
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int face;
    public int status;

    public Packet14BlockDig() {
    }

    public Packet14BlockDig(int n, int n2, int n3, int n4, int n5) {
        this.status = n;
        this.xPosition = n2;
        this.yPosition = n3;
        this.zPosition = n4;
        this.face = n5;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.status = dataInputStream.read();
        this.xPosition = dataInputStream.readInt();
        this.yPosition = dataInputStream.read();
        this.zPosition = dataInputStream.readInt();
        this.face = dataInputStream.read();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.status);
        dataOutputStream.writeInt(this.xPosition);
        dataOutputStream.write(this.yPosition);
        dataOutputStream.writeInt(this.zPosition);
        dataOutputStream.write(this.face);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleBlockDig(this);
    }

    @Override
    public int getPacketSize() {
        return 11;
    }
}

