/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet2Handshake
extends Packet {
    public String username;

    public Packet2Handshake() {
    }

    public Packet2Handshake(String string) {
        this.username = string;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.username = Packet2Handshake.readString(dataInputStream, 32);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        Packet2Handshake.writeString(this.username, dataOutputStream);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleHandshake(this);
    }

    @Override
    public int getPacketSize() {
        return this.username.length();
    }
}

