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

public class Packet39AttachEntity
extends Packet {
    public int entityId;
    public int vehicleEntityId;

    public Packet39AttachEntity() {
    }

    public Packet39AttachEntity(C_b c_b, C_b c_b2) {
        this.entityId = c_b.entityId;
        this.vehicleEntityId = c_b2 != null ? c_b2.entityId : -1;
    }

    @Override
    public int getPacketSize() {
        return 8;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.vehicleEntityId = dataInputStream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeInt(this.vehicleEntityId);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleRide(this);
    }
}

