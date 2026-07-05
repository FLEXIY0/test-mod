/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet41UpdateSeason
extends Packet {
    public int seasonTime = 0;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.seasonTime = dataInputStream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.seasonTime);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleUpdateSeason(this);
    }

    @Override
    public int getPacketSize() {
        return 4;
    }
}

