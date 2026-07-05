/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.a.c.C_d;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet25EntityPainting
extends Packet {
    public int entityId;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte direction;
    public String title;
    public int meta;
    public int itemId;
    public byte rotation;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.title = Packet25EntityPainting.readString(dataInputStream, C_d.maxArtTitleLength);
        this.xPosition = dataInputStream.readInt();
        this.yPosition = dataInputStream.readInt();
        this.zPosition = dataInputStream.readInt();
        this.direction = dataInputStream.readByte();
        this.rotation = dataInputStream.readByte();
        this.meta = dataInputStream.readInt();
        this.itemId = dataInputStream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        Packet25EntityPainting.writeString(this.title, dataOutputStream);
        dataOutputStream.writeInt(this.xPosition);
        dataOutputStream.writeInt(this.yPosition);
        dataOutputStream.writeInt(this.zPosition);
        dataOutputStream.writeByte(this.direction);
        dataOutputStream.writeByte(this.rotation);
        dataOutputStream.writeInt(this.meta);
        dataOutputStream.writeInt(this.itemId);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handlePlacePainting(this);
    }

    @Override
    public int getPacketSize() {
        return 4 + this.title.length() + 4 + 4 + 4 + 4 + 4 + 1 + 1;
    }
}

