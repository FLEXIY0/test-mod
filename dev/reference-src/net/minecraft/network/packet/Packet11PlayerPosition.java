/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.Packet10Flying;

public class Packet11PlayerPosition
extends Packet10Flying {
    public Packet11PlayerPosition() {
        this.moving = true;
    }

    public Packet11PlayerPosition(float f, float f2, float f3, float f4, boolean bl) {
        this.xPosition = f;
        this.yPosition = f2;
        this.stance = f3;
        this.zPosition = f4;
        this.onGround = bl;
        this.moving = true;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.xPosition = dataInputStream.readFloat();
        this.yPosition = dataInputStream.readFloat();
        this.stance = dataInputStream.readFloat();
        this.zPosition = dataInputStream.readFloat();
        super.readPacketData(dataInputStream);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.xPosition);
        dataOutputStream.writeFloat(this.yPosition);
        dataOutputStream.writeFloat(this.stance);
        dataOutputStream.writeFloat(this.zPosition);
        super.writePacketData(dataOutputStream);
    }

    @Override
    public int getPacketSize() {
        return 17;
    }
}

