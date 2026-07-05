/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet105UpdateProgressbar
extends Packet {
    public int windowId;
    public int progressBar;
    public int progressBarValue;

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleProgressBar(this);
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.windowId = dataInputStream.readByte();
        this.progressBar = dataInputStream.readShort();
        this.progressBarValue = dataInputStream.readShort();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.windowId);
        dataOutputStream.writeShort(this.progressBar);
        dataOutputStream.writeShort(this.progressBarValue);
    }

    @Override
    public int getPacketSize() {
        return 5;
    }
}

