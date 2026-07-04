/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet17Gamemode
extends Packet {
    public int entityID;
    public byte gamemode;
    public byte op;
    public byte revive;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityID = dataInputStream.readInt();
        this.gamemode = dataInputStream.readByte();
        this.op = dataInputStream.readByte();
        this.revive = dataInputStream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityID);
        dataOutputStream.writeByte(this.gamemode);
        dataOutputStream.writeByte(this.op);
        dataOutputStream.writeByte(this.revive);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleGamemode(this);
    }

    @Override
    public int getPacketSize() {
        return 7;
    }
}

