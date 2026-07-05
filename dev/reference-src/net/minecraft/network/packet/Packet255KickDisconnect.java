/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet255KickDisconnect
extends Packet {
    public String reason;

    public Packet255KickDisconnect() {
    }

    public Packet255KickDisconnect(String string) {
        this.reason = string;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.reason = Packet255KickDisconnect.readString(dataInputStream, 100);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        Packet255KickDisconnect.writeString(this.reason, dataOutputStream);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleKickDisconnect(this);
    }

    @Override
    public int getPacketSize() {
        return this.reason.length();
    }
}

