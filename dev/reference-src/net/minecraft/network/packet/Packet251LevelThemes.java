/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet251LevelThemes
extends Packet {
    public int fogColor;
    public int cloudColor;
    public int skyColor;
    public int defaultFluid;

    public Packet251LevelThemes() {
    }

    public Packet251LevelThemes(int n, int n2, int n3, int n4) {
        this.fogColor = n;
        this.cloudColor = n2;
        this.skyColor = n3;
        this.defaultFluid = n4;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.fogColor = dataInputStream.readInt();
        this.cloudColor = dataInputStream.readInt();
        this.skyColor = dataInputStream.readInt();
        this.defaultFluid = dataInputStream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.fogColor);
        dataOutputStream.writeInt(this.cloudColor);
        dataOutputStream.writeInt(this.skyColor);
        dataOutputStream.writeInt(this.defaultFluid);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleLevelThemes(this);
    }

    @Override
    public int getPacketSize() {
        return 16;
    }
}

