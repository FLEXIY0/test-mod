/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet192Ping
extends Packet {
    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handlePing(this);
    }

    @Override
    public int getPacketSize() {
        return 0;
    }
}

