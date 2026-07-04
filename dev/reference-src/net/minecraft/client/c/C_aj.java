/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.c.C_ai;
import net.minecraft.client.c.C_ak;
import net.minecraft.client.d;
import net.minecraft.network.NetClientHandler;
import net.minecraft.network.packet.Packet2Handshake;

class C_aj
extends Thread {
    final /* synthetic */ d val$client;
    final /* synthetic */ String val$server;
    final /* synthetic */ int val$port;
    final /* synthetic */ C_ak this$0;

    C_aj(C_ak c_ak, d d2, String string, int n) {
        this.this$0 = c_ak;
        this.val$client = d2;
        this.val$server = string;
        this.val$port = n;
    }

    @Override
    public void run() {
        try {
            C_ak.access$002(this.this$0, new NetClientHandler(this.val$client, this.val$server, this.val$port));
            if (C_ak.access$100(this.this$0)) {
                return;
            }
            C_ak.access$000(this.this$0).addToSendQueue(new Packet2Handshake(this.val$client.h.b));
        }
        catch (UnknownHostException unknownHostException) {
            if (C_ak.access$100(this.this$0)) {
                return;
            }
            this.val$client.a(new C_ai("Failed to connect to the server", "Unknown host '" + this.val$server + "'"));
        }
        catch (ConnectException connectException) {
            if (C_ak.access$100(this.this$0)) {
                return;
            }
            this.val$client.a(new C_ai("Failed to connect to the server", connectException.getMessage()));
        }
        catch (Exception exception) {
            if (C_ak.access$100(this.this$0)) {
                return;
            }
            exception.printStackTrace();
            this.val$client.a(new C_ai("Failed to connect to the server", exception.toString()));
        }
    }
}

