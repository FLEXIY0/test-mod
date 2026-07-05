/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet51LevelFinalized
extends Packet {
    public int width;
    public int height;
    public int depth;
    public int cloudHeight;
    public int waterLevel;
    public int groundLevel;
    public int skylightSubtracted;
    public int skyBrightness;

    public Packet51LevelFinalized() {
    }

    public Packet51LevelFinalized(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.width = n;
        this.height = n2;
        this.depth = n3;
        this.cloudHeight = n4;
        this.waterLevel = n5;
        this.groundLevel = n6;
        this.skylightSubtracted = n7;
        this.skyBrightness = n8;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.width = dataInputStream.readInt();
        this.height = dataInputStream.readInt();
        this.depth = dataInputStream.readInt();
        this.cloudHeight = dataInputStream.readInt();
        this.waterLevel = dataInputStream.readInt();
        this.groundLevel = dataInputStream.readInt();
        this.skylightSubtracted = dataInputStream.readInt();
        this.skyBrightness = dataInputStream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.width);
        dataOutputStream.writeInt(this.height);
        dataOutputStream.writeInt(this.depth);
        dataOutputStream.writeInt(this.cloudHeight);
        dataOutputStream.writeInt(this.waterLevel);
        dataOutputStream.writeInt(this.groundLevel);
        dataOutputStream.writeInt(this.skylightSubtracted);
        dataOutputStream.writeInt(this.skyBrightness);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleLevelFinalized(this);
    }

    @Override
    public int getPacketSize() {
        return 32;
    }
}

