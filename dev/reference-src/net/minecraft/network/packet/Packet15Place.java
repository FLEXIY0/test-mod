/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.a.b.ItemStack;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet15Place
extends Packet {
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int direction;
    public ItemStack itemStack;

    public Packet15Place() {
    }

    public Packet15Place(int n, int n2, int n3, int n4, ItemStack itemStack) {
        this.xPosition = n;
        this.yPosition = n2;
        this.zPosition = n3;
        this.direction = n4;
        this.itemStack = itemStack;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.xPosition = dataInputStream.readInt();
        this.yPosition = dataInputStream.read();
        this.zPosition = dataInputStream.readInt();
        this.direction = dataInputStream.read();
        this.itemStack = Packet15Place.readItemStack(dataInputStream);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.xPosition);
        dataOutputStream.write(this.yPosition);
        dataOutputStream.writeInt(this.zPosition);
        dataOutputStream.write(this.direction);
        Packet15Place.writeItemStack(this.itemStack, dataOutputStream);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handlePlace(this);
    }

    @Override
    public int getPacketSize() {
        return 15;
    }
}

