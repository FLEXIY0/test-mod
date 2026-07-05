/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.Packet10Flying;

public class Packet13PlayerLookMove
extends Packet10Flying {
    public Packet13PlayerLookMove() {
        this.rotating = true;
        this.moving = true;
    }

    public Packet13PlayerLookMove(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        this.xPosition = f;
        this.yPosition = f2;
        this.stance = f3;
        this.zPosition = f4;
        this.yaw = f5;
        this.pitch = f6;
        this.onGround = bl;
        this.rotating = true;
        this.moving = true;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.xPosition = dataInputStream.readFloat();
        this.yPosition = dataInputStream.readFloat();
        this.stance = dataInputStream.readFloat();
        this.zPosition = dataInputStream.readFloat();
        this.yaw = dataInputStream.readFloat();
        this.pitch = dataInputStream.readFloat();
        super.readPacketData(dataInputStream);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.xPosition);
        dataOutputStream.writeFloat(this.yPosition);
        dataOutputStream.writeFloat(this.stance);
        dataOutputStream.writeFloat(this.zPosition);
        dataOutputStream.writeFloat(this.yaw);
        dataOutputStream.writeFloat(this.pitch);
        super.writePacketData(dataOutputStream);
    }

    @Override
    public int getPacketSize() {
        return 25;
    }
}

