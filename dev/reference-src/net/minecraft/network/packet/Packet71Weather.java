/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet71Weather
extends Packet {
    public int playerEntity;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int lightningStrike;
    public boolean raining;
    public boolean thundering;
    public byte windDirection;
    public int fogDensity;
    public float windForce;
    public byte bloodMoon;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.playerEntity = dataInputStream.readInt();
        this.lightningStrike = dataInputStream.readByte();
        this.xPosition = dataInputStream.readInt();
        this.yPosition = dataInputStream.readInt();
        this.zPosition = dataInputStream.readInt();
        this.raining = dataInputStream.readBoolean();
        this.thundering = dataInputStream.readBoolean();
        this.windDirection = dataInputStream.readByte();
        this.fogDensity = dataInputStream.readInt();
        this.windForce = dataInputStream.readFloat();
        this.bloodMoon = dataInputStream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.playerEntity);
        dataOutputStream.writeByte(this.lightningStrike);
        dataOutputStream.writeInt(this.xPosition);
        dataOutputStream.writeInt(this.yPosition);
        dataOutputStream.writeInt(this.zPosition);
        dataOutputStream.writeBoolean(this.raining);
        dataOutputStream.writeBoolean(this.thundering);
        dataOutputStream.writeByte(this.windDirection);
        dataOutputStream.writeInt(this.fogDensity);
        dataOutputStream.writeFloat(this.windForce);
        dataOutputStream.writeByte(this.bloodMoon);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleWeather(this);
    }

    @Override
    public int getPacketSize() {
        return 9;
    }
}

