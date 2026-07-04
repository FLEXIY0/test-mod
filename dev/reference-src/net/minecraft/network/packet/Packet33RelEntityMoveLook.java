/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.Packet30Entity;

public class Packet33RelEntityMoveLook
extends Packet30Entity {
    public Packet33RelEntityMoveLook() {
        this.rotating = true;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        super.readPacketData(dataInputStream);
        this.xPosition = dataInputStream.readByte();
        this.yPosition = dataInputStream.readByte();
        this.zPosition = dataInputStream.readByte();
        this.yaw = dataInputStream.readByte();
        this.pitch = dataInputStream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        super.writePacketData(dataOutputStream);
        dataOutputStream.writeByte(this.xPosition);
        dataOutputStream.writeByte(this.yPosition);
        dataOutputStream.writeByte(this.zPosition);
        dataOutputStream.writeByte(this.yaw);
        dataOutputStream.writeByte(this.pitch);
    }

    @Override
    public int getPacketSize() {
        return 9;
    }
}

