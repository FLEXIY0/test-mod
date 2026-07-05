/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.a.c.Entity;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet19Animation
extends Packet {
    public int entityId;
    public int animate;

    public Packet19Animation() {
    }

    public Packet19Animation(Entity c_b, int n) {
        this.entityId = c_b.entityId;
        this.animate = n;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.animate = dataInputStream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeByte(this.animate);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleArmAnimation(this);
    }

    @Override
    public int getPacketSize() {
        return 5;
    }
}

