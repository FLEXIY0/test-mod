/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet130UpdateSign
extends Packet {
    public int x;
    public int y;
    public int z;
    public String[] lines;

    public Packet130UpdateSign() {
        this.isChunkDataPacket = false;
    }

    public Packet130UpdateSign(int n, int n2, int n3, String[] stringArray) {
        this.isChunkDataPacket = false;
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.lines = stringArray;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.x = dataInputStream.readInt();
        this.y = dataInputStream.readShort();
        this.z = dataInputStream.readInt();
        this.lines = new String[4];
        for (int i = 0; i < 4; ++i) {
            this.lines[i] = Packet130UpdateSign.readString(dataInputStream, 15);
        }
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeShort(this.y);
        dataOutputStream.writeInt(this.z);
        for (int i = 0; i < 4; ++i) {
            Packet130UpdateSign.writeString(this.lines[i], dataOutputStream);
        }
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleUpdateSign(this);
    }

    @Override
    public int getPacketSize() {
        int n = 0;
        for (int i = 0; i < 4; ++i) {
            n += this.lines[i].length();
        }
        return n;
    }
}

