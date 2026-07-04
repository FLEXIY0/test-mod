/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet54PlayNoteBlock
extends Packet {
    public int xLocation;
    public int yLocation;
    public int zLocation;
    public int instrumentType;
    public int pitch;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.xLocation = dataInputStream.readInt();
        this.yLocation = dataInputStream.readShort();
        this.zLocation = dataInputStream.readInt();
        this.instrumentType = dataInputStream.read();
        this.pitch = dataInputStream.read();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.xLocation);
        dataOutputStream.writeShort(this.yLocation);
        dataOutputStream.writeInt(this.zLocation);
        dataOutputStream.write(this.instrumentType);
        dataOutputStream.write(this.pitch);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleNotePlay(this);
    }

    @Override
    public int getPacketSize() {
        return 12;
    }
}

