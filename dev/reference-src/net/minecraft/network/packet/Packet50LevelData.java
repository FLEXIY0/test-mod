/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet50LevelData
extends Packet {
    public byte[] blocks;

    public Packet50LevelData() {
    }

    public Packet50LevelData(byte[] byArray) {
        this.blocks = byArray;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        int n = dataInputStream.readInt();
        this.blocks = new byte[n];
        dataInputStream.readFully(this.blocks);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.blocks.length);
        dataOutputStream.write(this.blocks);
        dataOutputStream.flush();
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleLevelData(this);
    }

    @Override
    public int getPacketSize() {
        return this.blocks.length + 4;
    }
}

