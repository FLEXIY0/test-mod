/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet253ServerName
extends Packet {
    public String name;
    public String motd;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.name = Packet253ServerName.readString(dataInputStream, 64);
        this.motd = Packet253ServerName.readString(dataInputStream, 64);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        Packet253ServerName.writeString(this.name, dataOutputStream);
        Packet253ServerName.writeString(this.motd, dataOutputStream);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleServerName(this);
    }

    @Override
    public int getPacketSize() {
        return this.name.length() + this.motd.length();
    }
}

