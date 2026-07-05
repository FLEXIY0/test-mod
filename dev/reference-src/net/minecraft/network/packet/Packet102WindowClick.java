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

public class Packet102WindowClick
extends Packet {
    public int window_Id;
    public int inventorySlot;
    public int mouseClick;
    public short action;
    public ItemStack itemStack;
    public boolean clicked;

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleClick(this);
    }

    public Packet102WindowClick(int n, int n2, int n3, boolean bl, ItemStack itemStack, short s) {
        this.window_Id = n;
        this.inventorySlot = n2;
        this.mouseClick = n3;
        this.itemStack = itemStack;
        this.action = s;
        this.clicked = bl;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.window_Id = dataInputStream.readByte();
        this.inventorySlot = dataInputStream.readShort();
        this.mouseClick = dataInputStream.readByte();
        this.action = dataInputStream.readShort();
        this.clicked = dataInputStream.readBoolean();
        this.itemStack = Packet102WindowClick.readItemStack(dataInputStream);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.window_Id);
        dataOutputStream.writeShort(this.inventorySlot);
        dataOutputStream.writeByte(this.mouseClick);
        dataOutputStream.writeShort(this.action);
        dataOutputStream.writeBoolean(this.clicked);
        Packet102WindowClick.writeItemStack(this.itemStack, dataOutputStream);
    }

    @Override
    public int getPacketSize() {
        return 12;
    }
}

