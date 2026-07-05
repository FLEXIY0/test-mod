/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet100OpenWindow
extends Packet {
    public int windowId;
    public int inventoryType;
    public String windowTitle;
    public int slotsCount;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public boolean state;

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleOpenWindow(this);
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.windowId = dataInputStream.readByte();
        this.inventoryType = dataInputStream.readByte();
        this.windowTitle = dataInputStream.readUTF();
        this.slotsCount = dataInputStream.readByte();
        this.xPosition = dataInputStream.readInt();
        this.yPosition = dataInputStream.readInt();
        this.zPosition = dataInputStream.readInt();
        this.state = dataInputStream.readBoolean();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.windowId);
        dataOutputStream.writeByte(this.inventoryType);
        dataOutputStream.writeUTF(this.windowTitle);
        dataOutputStream.writeByte(this.slotsCount);
        dataOutputStream.writeInt(this.xPosition);
        dataOutputStream.writeInt(this.yPosition);
        dataOutputStream.writeInt(this.zPosition);
        dataOutputStream.writeBoolean(this.state);
    }

    @Override
    public int getPacketSize() {
        return 3 + this.windowTitle.length();
    }
}

