/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet30Entity
extends Packet {
    public int entityId;
    public byte xPosition;
    public byte yPosition;
    public byte zPosition;
    public byte yaw;
    public byte pitch;
    public boolean rotating = false;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleEntity(this);
    }

    @Override
    public int getPacketSize() {
        return 4;
    }
}

