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

public class Packet5PlayerInventory
extends Packet {
    public int entityID;
    public int slot;
    private ItemStack itemSlot;

    public Packet5PlayerInventory() {
    }

    public Packet5PlayerInventory(int n, int n2, ItemStack itemStack) {
        this.entityID = n;
        this.slot = n2;
        this.itemSlot = itemStack == null ? null : itemStack.copy();
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityID = dataInputStream.readInt();
        this.slot = dataInputStream.readShort();
        this.itemSlot = Packet5PlayerInventory.readItemStack(dataInputStream);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityID);
        dataOutputStream.writeShort(this.slot);
        Packet5PlayerInventory.writeItemStack(this.itemSlot, dataOutputStream);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handlePlayerInventory(this);
    }

    public ItemStack getItemSlot() {
        return this.itemSlot;
    }

    @Override
    public int getPacketSize() {
        return 10;
    }
}

