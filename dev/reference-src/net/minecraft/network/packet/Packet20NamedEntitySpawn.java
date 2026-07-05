/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;
import util.MathHelper;

public class Packet20NamedEntitySpawn
extends Packet {
    public int entityId;
    public String name;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte rotation;
    public byte pitch;
    public int currentItem;

    public Packet20NamedEntitySpawn() {
    }

    public Packet20NamedEntitySpawn(EntityPlayer entityPlayer) {
        this.entityId = entityPlayer.entityId;
        this.name = entityPlayer.name;
        this.xPosition = MathHelper.a((double)entityPlayer.h * 32.0);
        this.yPosition = MathHelper.a((double)entityPlayer.i * 32.0);
        this.zPosition = MathHelper.a((double)entityPlayer.j * 32.0);
        this.rotation = (byte)(entityPlayer.n * 256.0f / 360.0f);
        this.pitch = (byte)(entityPlayer.o * 256.0f / 360.0f);
        ItemStack itemStack = entityPlayer.b.d();
        this.currentItem = itemStack == null ? 0 : itemStack.c;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.name = Packet20NamedEntitySpawn.readString(dataInputStream, 16);
        this.xPosition = dataInputStream.readInt();
        this.yPosition = dataInputStream.readInt();
        this.zPosition = dataInputStream.readInt();
        this.rotation = dataInputStream.readByte();
        this.pitch = dataInputStream.readByte();
        this.currentItem = dataInputStream.readShort();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        Packet20NamedEntitySpawn.writeString(this.name, dataOutputStream);
        dataOutputStream.writeInt(this.xPosition);
        dataOutputStream.writeInt(this.yPosition);
        dataOutputStream.writeInt(this.zPosition);
        dataOutputStream.writeByte(this.rotation);
        dataOutputStream.writeByte(this.pitch);
        dataOutputStream.writeShort(this.currentItem);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleNamedEntitySpawn(this);
    }

    @Override
    public int getPacketSize() {
        return 4 + this.name.length() + 4 + 4 + 4 + 1 + 1 + 2;
    }
}

