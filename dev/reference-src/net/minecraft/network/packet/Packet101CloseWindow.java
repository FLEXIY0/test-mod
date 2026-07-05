/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet101CloseWindow
extends Packet {
    public int windowId;

    public Packet101CloseWindow() {
    }

    public Packet101CloseWindow(int n) {
        this.windowId = n;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleCloseWindow(this);
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.windowId = dataInputStream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.windowId);
    }

    @Override
    public int getPacketSize() {
        return 4;
    }
}

