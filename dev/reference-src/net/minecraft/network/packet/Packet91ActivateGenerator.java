/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet91ActivateGenerator
extends Packet {
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public boolean state;

    public Packet91ActivateGenerator() {
    }

    public Packet91ActivateGenerator(int n, int n2, int n3, boolean bl) {
        this.xPosition = n;
        this.yPosition = n2;
        this.zPosition = n3;
        this.state = bl;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleGenerator(this);
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.xPosition = dataInputStream.readInt();
        this.yPosition = dataInputStream.readInt();
        this.zPosition = dataInputStream.readInt();
        this.state = dataInputStream.readBoolean();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.xPosition);
        dataOutputStream.writeInt(this.yPosition);
        dataOutputStream.writeInt(this.zPosition);
        dataOutputStream.writeBoolean(this.state);
    }

    @Override
    public int getPacketSize() {
        return 14;
    }
}

