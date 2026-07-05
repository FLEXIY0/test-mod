/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet10Flying
extends Packet {
    public float xPosition;
    public float yPosition;
    public float zPosition;
    public float stance;
    public float yaw;
    public float pitch;
    public boolean onGround;
    public boolean moving;
    public boolean rotating;

    public Packet10Flying() {
    }

    public Packet10Flying(boolean bl) {
        this.onGround = bl;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleFlying(this);
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.onGround = dataInputStream.read() != 0;
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.onGround ? 1 : 0);
    }

    @Override
    public int getPacketSize() {
        return 1;
    }
}

