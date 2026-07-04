/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet252LevelMetadata
extends Packet {
    public byte[] metadata;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        int n = dataInputStream.readInt();
        this.metadata = new byte[n];
        dataInputStream.readFully(this.metadata);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.metadata.length);
        dataOutputStream.write(this.metadata);
        dataOutputStream.flush();
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleLevelMetaData(this);
    }

    @Override
    public int getPacketSize() {
        return this.metadata.length + 4;
    }
}

