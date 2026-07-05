/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.Packet10Flying;

public class Packet12PlayerLook
extends Packet10Flying {
    public Packet12PlayerLook() {
        this.rotating = true;
    }

    public Packet12PlayerLook(float f, float f2, boolean bl) {
        this.yaw = f;
        this.pitch = f2;
        this.onGround = bl;
        this.rotating = true;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.yaw = dataInputStream.readFloat();
        this.pitch = dataInputStream.readFloat();
        super.readPacketData(dataInputStream);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.yaw);
        dataOutputStream.writeFloat(this.pitch);
        super.writePacketData(dataOutputStream);
    }

    @Override
    public int getPacketSize() {
        return 9;
    }
}

