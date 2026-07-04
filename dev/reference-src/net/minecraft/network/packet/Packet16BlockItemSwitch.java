/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet16BlockItemSwitch
extends Packet {
    public int id;

    public Packet16BlockItemSwitch() {
    }

    public Packet16BlockItemSwitch(int n) {
        this.id = n;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.id = dataInputStream.readShort();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.id);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleBlockItemSwitch(this);
    }

    @Override
    public int getPacketSize() {
        return 2;
    }
}

