/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.a.c.C_b;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;
import util.MathHelper;

public class Packet34EntityTeleport
extends Packet {
    public int entityId;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte yaw;
    public byte pitch;

    public Packet34EntityTeleport() {
    }

    public Packet34EntityTeleport(C_b c_b) {
        this.entityId = c_b.entityId;
        this.xPosition = MathHelper.a((double)c_b.h * 32.0);
        this.yPosition = MathHelper.a((double)c_b.i * 32.0);
        this.zPosition = MathHelper.a((double)c_b.j * 32.0);
        this.yaw = (byte)(c_b.n * 256.0f / 360.0f);
        this.pitch = (byte)(c_b.o * 256.0f / 360.0f);
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.xPosition = dataInputStream.readInt();
        this.yPosition = dataInputStream.readInt();
        this.zPosition = dataInputStream.readInt();
        this.yaw = (byte)dataInputStream.read();
        this.pitch = (byte)dataInputStream.read();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeInt(this.xPosition);
        dataOutputStream.writeInt(this.yPosition);
        dataOutputStream.writeInt(this.zPosition);
        dataOutputStream.write(this.yaw);
        dataOutputStream.write(this.pitch);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleEntityTeleport(this);
    }

    @Override
    public int getPacketSize() {
        return 18;
    }
}

