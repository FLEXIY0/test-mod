/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.Packet30Entity;

public class Packet32EntityLook
extends Packet30Entity {
    public Packet32EntityLook() {
        this.rotating = true;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        super.readPacketData(dataInputStream);
        this.yaw = dataInputStream.readByte();
        this.pitch = dataInputStream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        super.writePacketData(dataOutputStream);
        dataOutputStream.writeByte(this.yaw);
        dataOutputStream.writeByte(this.pitch);
    }

    @Override
    public int getPacketSize() {
        return 6;
    }
}

