/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.a.a.C_k;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet60Explosion
extends Packet {
    public float explosionX;
    public float explosionY;
    public float explosionZ;
    public float explosionSize;
    public Set<C_k> destroyedBlockPositions;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.explosionX = dataInputStream.readFloat();
        this.explosionY = dataInputStream.readFloat();
        this.explosionZ = dataInputStream.readFloat();
        this.explosionSize = dataInputStream.readFloat();
        int n = dataInputStream.readInt();
        this.destroyedBlockPositions = new HashSet<C_k>();
        int n2 = (int)this.explosionX;
        int n3 = (int)this.explosionY;
        int n4 = (int)this.explosionZ;
        for (int i = 0; i < n; ++i) {
            int n5 = dataInputStream.readByte() + n2;
            int n6 = dataInputStream.readByte() + n3;
            int n7 = dataInputStream.readByte() + n4;
            this.destroyedBlockPositions.add(new C_k(n5, n6, n7));
        }
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.explosionX);
        dataOutputStream.writeFloat(this.explosionY);
        dataOutputStream.writeFloat(this.explosionZ);
        dataOutputStream.writeFloat(this.explosionSize);
        dataOutputStream.writeInt(this.destroyedBlockPositions.size());
        int n = (int)this.explosionX;
        int n2 = (int)this.explosionY;
        int n3 = (int)this.explosionZ;
        for (C_k c_k : this.destroyedBlockPositions) {
            int n4 = c_k.x - n;
            int n5 = c_k.y - n2;
            int n6 = c_k.z - n3;
            dataOutputStream.writeByte(n4);
            dataOutputStream.writeByte(n5);
            dataOutputStream.writeByte(n6);
        }
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleExplosion(this);
    }

    @Override
    public int getPacketSize() {
        return 20 + this.destroyedBlockPositions.size() * 3;
    }
}

