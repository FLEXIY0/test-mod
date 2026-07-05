/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet201PlayerInfo
extends Packet {
    public String playerName;
    public boolean isConnected;
    public int ping;
    public int score;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.playerName = Packet201PlayerInfo.readString(dataInputStream, 16);
        this.isConnected = dataInputStream.readByte() != 0;
        this.ping = dataInputStream.readShort();
        this.score = dataInputStream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        Packet201PlayerInfo.writeString(this.playerName, dataOutputStream);
        dataOutputStream.writeByte(this.isConnected ? 1 : 0);
        dataOutputStream.writeShort(this.ping);
        dataOutputStream.writeInt(this.score);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handlePlayerInfo(this);
    }

    @Override
    public int getPacketSize() {
        return this.playerName.length() + 1 + 2 + 4;
    }
}

