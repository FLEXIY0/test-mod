/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet1Login
extends Packet {
    public int protocolVersion;
    public String username;
    public long mapSeed;
    public byte dimension;

    public Packet1Login() {
    }

    public Packet1Login(String string, int n) {
        this.username = string;
        this.protocolVersion = n;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.protocolVersion = dataInputStream.readInt();
        this.username = Packet1Login.readString(dataInputStream, 16);
        this.mapSeed = dataInputStream.readLong();
        this.dimension = dataInputStream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.protocolVersion);
        Packet1Login.writeString(this.username, dataOutputStream);
        dataOutputStream.writeLong(this.mapSeed);
        dataOutputStream.writeByte(this.dimension);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleLogin(this);
    }

    @Override
    public int getPacketSize() {
        return 4 + this.username.length() + 8 + 1;
    }
}

