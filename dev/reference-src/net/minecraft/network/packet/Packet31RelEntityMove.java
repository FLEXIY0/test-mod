/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.Packet30Entity;

public class Packet31RelEntityMove
extends Packet30Entity {
    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        super.readPacketData(dataInputStream);
        this.xPosition = dataInputStream.readByte();
        this.yPosition = dataInputStream.readByte();
        this.zPosition = dataInputStream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        super.writePacketData(dataOutputStream);
        dataOutputStream.writeByte(this.xPosition);
        dataOutputStream.writeByte(this.yPosition);
        dataOutputStream.writeByte(this.zPosition);
    }

    @Override
    public int getPacketSize() {
        return 7;
    }
}

