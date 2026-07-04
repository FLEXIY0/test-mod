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

public class Packet27UseCharm
extends Packet {
    public ItemStack itemStack;

    public Packet27UseCharm() {
    }

    public Packet27UseCharm(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.itemStack = Packet27UseCharm.readItemStack(dataInputStream);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        Packet27UseCharm.writeItemStack(this.itemStack, dataOutputStream);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleUseItem(this);
    }

    @Override
    public int getPacketSize() {
        return 4;
    }
}

