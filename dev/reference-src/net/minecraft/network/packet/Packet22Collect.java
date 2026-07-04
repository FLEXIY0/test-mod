/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet22Collect
extends Packet {
    public int collectedEntityId;
    public int collectorEntityId;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.collectedEntityId = dataInputStream.readInt();
        this.collectorEntityId = dataInputStream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.collectedEntityId);
        dataOutputStream.writeInt(this.collectorEntityId);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleCollect(this);
    }

    @Override
    public int getPacketSize() {
        return 8;
    }
}

