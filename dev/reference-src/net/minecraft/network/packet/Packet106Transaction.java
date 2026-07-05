/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet106Transaction
extends Packet {
    public int windowId;
    public short transactionID;
    public boolean activate;

    public Packet106Transaction() {
    }

    public Packet106Transaction(int n, short s, boolean bl) {
        this.windowId = n;
        this.transactionID = s;
        this.activate = bl;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleTransaction(this);
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.windowId = dataInputStream.readByte();
        this.transactionID = dataInputStream.readShort();
        this.activate = dataInputStream.readByte() != 0;
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.windowId);
        dataOutputStream.writeShort(this.transactionID);
        dataOutputStream.writeByte(this.activate ? 1 : 0);
    }

    @Override
    public int getPacketSize() {
        return 4;
    }
}

