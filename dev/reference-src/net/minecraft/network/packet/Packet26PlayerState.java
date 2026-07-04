/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet26PlayerState
extends Packet {
    public int entityId;
    public byte type;
    public boolean state;

    public Packet26PlayerState() {
    }

    public Packet26PlayerState(int n, byte by, boolean bl) {
        this.entityId = n;
        this.type = by;
        this.state = bl;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.type = dataInputStream.readByte();
        this.state = dataInputStream.readBoolean();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeByte(this.type);
        dataOutputStream.writeBoolean(this.state);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handlePlayerState(this);
    }

    @Override
    public int getPacketSize() {
        return 6;
    }
}

