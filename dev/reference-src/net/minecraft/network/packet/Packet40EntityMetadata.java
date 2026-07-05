/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.minecraft.network.DataWatcher;
import net.minecraft.network.NetHandler;
import net.minecraft.network.WatchableObject;
import net.minecraft.network.packet.Packet;

public class Packet40EntityMetadata
extends Packet {
    public int entityId;
    private List<WatchableObject> entityData;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.entityData = DataWatcher.readWatchableObjects(dataInputStream);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        DataWatcher.writeObjectsInListToStream(this.entityData, dataOutputStream);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleMetadata(this);
    }

    @Override
    public int getPacketSize() {
        return 5;
    }

    public List<WatchableObject> getData() {
        return this.entityData;
    }
}

