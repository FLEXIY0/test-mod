/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet0KeepAlive
extends Packet {
    public int randomValue;

    public Packet0KeepAlive() {
    }

    public Packet0KeepAlive(int n) {
        this.randomValue = n;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleKeepAlive(this);
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.randomValue = dataInputStream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.randomValue);
    }

    @Override
    public int getPacketSize() {
        return 4;
    }
}

