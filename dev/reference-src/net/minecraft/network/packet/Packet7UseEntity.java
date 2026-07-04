/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet7UseEntity
extends Packet {
    public int playerEntityId;
    public int targetEntity;
    public int isLeftClick;

    public Packet7UseEntity() {
    }

    public Packet7UseEntity(int n, int n2, int n3) {
        this.playerEntityId = n;
        this.targetEntity = n2;
        this.isLeftClick = n3;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.playerEntityId = dataInputStream.readInt();
        this.targetEntity = dataInputStream.readInt();
        this.isLeftClick = dataInputStream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.playerEntityId);
        dataOutputStream.writeInt(this.targetEntity);
        dataOutputStream.writeByte(this.isLeftClick);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleUseEntity(this);
    }

    @Override
    public int getPacketSize() {
        return 9;
    }
}

