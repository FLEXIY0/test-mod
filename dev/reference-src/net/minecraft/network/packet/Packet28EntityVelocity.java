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

public class Packet28EntityVelocity
extends Packet {
    public int entityId;
    public int motionX;
    public int motionY;
    public int motionZ;

    public Packet28EntityVelocity() {
    }

    public Packet28EntityVelocity(C_b c_b) {
        this(c_b.entityId, c_b.k, c_b.l, c_b.m);
    }

    public Packet28EntityVelocity(int n, double d2, double d3, double d4) {
        this.entityId = n;
        double d5 = 3.9;
        if (d2 < -d5) {
            d2 = -d5;
        }
        if (d3 < -d5) {
            d3 = -d5;
        }
        if (d4 < -d5) {
            d4 = -d5;
        }
        if (d2 > d5) {
            d2 = d5;
        }
        if (d3 > d5) {
            d3 = d5;
        }
        if (d4 > d5) {
            d4 = d5;
        }
        this.motionX = (int)(d2 * 8000.0);
        this.motionY = (int)(d3 * 8000.0);
        this.motionZ = (int)(d4 * 8000.0);
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.motionX = dataInputStream.readShort();
        this.motionY = dataInputStream.readShort();
        this.motionZ = dataInputStream.readShort();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeShort(this.motionX);
        dataOutputStream.writeShort(this.motionY);
        dataOutputStream.writeShort(this.motionZ);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleVelocity(this);
    }

    @Override
    public int getPacketSize() {
        return 10;
    }
}

