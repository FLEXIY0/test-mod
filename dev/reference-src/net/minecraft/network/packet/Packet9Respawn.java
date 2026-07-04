/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet9Respawn
extends Packet {
    public byte dimension;

    public Packet9Respawn() {
    }

    public Packet9Respawn(byte by) {
        this.dimension = by;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleRespawn(this);
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.dimension = dataInputStream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.dimension);
    }

    @Override
    public int getPacketSize() {
        return 1;
    }
}

