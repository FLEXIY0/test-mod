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

public class Packet202CreativeInventory
extends Packet {
    public int currentItem;
    public ItemStack itemSlot;

    public Packet202CreativeInventory() {
    }

    public Packet202CreativeInventory(int n, ItemStack itemStack) {
        this.currentItem = n;
        this.itemSlot = itemStack == null ? null : itemStack.copy();
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.currentItem = dataInputStream.readInt();
        this.itemSlot = Packet202CreativeInventory.readItemStack(dataInputStream);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.currentItem);
        Packet202CreativeInventory.writeItemStack(this.itemSlot, dataOutputStream);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleCreativeInventory(this);
    }

    @Override
    public int getPacketSize() {
        return 16;
    }
}

