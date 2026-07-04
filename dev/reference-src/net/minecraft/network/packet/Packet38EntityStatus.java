/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet38EntityStatus
extends Packet {
    public int entityId;
    public byte entityStatus;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.entityStatus = dataInputStream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeByte(this.entityStatus);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleStatus(this);
    }

    @Override
    public int getPacketSize() {
        return 5;
    }
}

