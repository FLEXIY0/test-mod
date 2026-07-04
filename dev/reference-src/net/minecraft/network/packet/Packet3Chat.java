/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet3Chat
extends Packet {
    public String message;

    public Packet3Chat() {
    }

    public Packet3Chat(String string) {
        if (string.length() > 119) {
            string = string.substring(0, 119);
        }
        this.message = string;
    }

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        this.message = Packet3Chat.readString(dataInputStream, 119);
    }

    @Override
    public void writePacketData(DataOutputStream dataOutputStream) throws IOException {
        Packet3Chat.writeString(this.message, dataOutputStream);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleChat(this);
    }

    @Override
    public int getPacketSize() {
        return this.message.length();
    }
}

