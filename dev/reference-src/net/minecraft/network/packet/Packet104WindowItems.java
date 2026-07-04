/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.minecraft.a.b.ItemStack;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet104WindowItems
extends Packet {
    public int windowId;
    public ItemStack[] itemStack;

    public Packet104WindowItems() {
    }

    public Packet104WindowItems(int n, List<ItemStack> list) {
        this.windowId = n;
        this.itemStack = new ItemStack[list.size()];
        for (int i = 0; i < this.itemStack.length; ++i) {
            ItemStack itemStack = list.get(i);
            this.itemStack[i] = itemStack == null ? null : itemStack.copy();
        }
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.windowId = dataInputStream.readByte();
        int n = dataInputStream.readShort();
        this.itemStack = new ItemStack[n];
        for (int i = 0; i < n; ++i) {
            this.itemStack[i] = Packet104WindowItems.readItemStack(dataInputStream);
        }
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.windowId);
        dataOutputStream.writeShort(this.itemStack.length);
        for (int i = 0; i < this.itemStack.length; ++i) {
            Packet104WindowItems.writeItemStack(this.itemStack[i], dataOutputStream);
        }
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleWindowItems(this);
    }

    @Override
    public int getPacketSize() {
        return 3 + this.itemStack.length * 5;
    }
}

