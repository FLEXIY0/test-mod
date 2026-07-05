/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;
import util.MathHelper;

public class Packet21PickupSpawn
extends Packet {
    public int entityId;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte rotation;
    public byte pitch;
    public byte roll;
    public ItemStack itemStack;

    public Packet21PickupSpawn() {
    }

    public Packet21PickupSpawn(EntityItem c_b) {
        this.entityId = c_b.entityId;
        this.itemStack = c_b.a;
        this.xPosition = MathHelper.a((double)c_b.h * 32.0);
        this.yPosition = MathHelper.a((double)c_b.i * 32.0);
        this.zPosition = MathHelper.a((double)c_b.j * 32.0);
        this.rotation = (byte)((double)c_b.k * 128.0);
        this.pitch = (byte)((double)c_b.l * 128.0);
        this.roll = (byte)((double)c_b.m * 128.0);
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.itemStack = Packet21PickupSpawn.readItemStack(dataInputStream);
        this.xPosition = dataInputStream.readInt();
        this.yPosition = dataInputStream.readInt();
        this.zPosition = dataInputStream.readInt();
        this.rotation = dataInputStream.readByte();
        this.pitch = dataInputStream.readByte();
        this.roll = dataInputStream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        Packet21PickupSpawn.writeItemStack(this.itemStack, dataOutputStream);
        dataOutputStream.writeInt(this.xPosition);
        dataOutputStream.writeInt(this.yPosition);
        dataOutputStream.writeInt(this.zPosition);
        dataOutputStream.writeByte(this.rotation);
        dataOutputStream.writeByte(this.pitch);
        dataOutputStream.writeByte(this.roll);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handlePickupSpawn(this);
    }

    @Override
    public int getPacketSize() {
        return 24;
    }
}

