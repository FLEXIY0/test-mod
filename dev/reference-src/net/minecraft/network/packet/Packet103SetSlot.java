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

public class Packet103SetSlot
extends Packet {
    public int windowId;
    public int itemSlot;
    public ItemStack myItemStack;

    public Packet103SetSlot() {
    }

    public Packet103SetSlot(int n, int n2, ItemStack itemStack) {
        this.windowId = n;
        this.itemSlot = n2;
        this.myItemStack = itemStack == null ? itemStack : itemStack.copy();
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleSetSlot(this);
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.windowId = dataInputStream.readByte();
        this.itemSlot = dataInputStream.readShort();
        this.myItemStack = Packet103SetSlot.readItemStack(dataInputStream);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.windowId);
        dataOutputStream.writeShort(this.itemSlot);
        Packet103SetSlot.writeItemStack(this.myItemStack, dataOutputStream);
    }

    @Override
    public int getPacketSize() {
        return 8;
    }
}

