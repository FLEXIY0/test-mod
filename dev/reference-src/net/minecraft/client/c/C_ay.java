/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import net.minecraft.client.c.C_ax;
import net.minecraft.client.c.C_az;
import net.minecraft.client.c.C_ba;

class C_ay
extends Thread {
    final /* synthetic */ C_ax val$stor;
    final /* synthetic */ C_az this$1;

    C_ay(C_az c_az, C_ax c_ax) {
        this.this$1 = c_az;
        this.val$stor = c_ax;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        block53: {
            block54: {
                block58: {
                    block57: {
                        block56: {
                            boolean bl = false;
                            try {
                                bl = true;
                                this.val$stor.serversideName = "\u00a78Pinging..";
                                long l = System.nanoTime();
                                C_ba.access$800(this.this$1.this$0, this.val$stor);
                                long l2 = System.nanoTime();
                                this.val$stor.ping = (l2 - l) / 1000000L;
                                bl = false;
                                break block53;
                            }
                            catch (UnknownHostException unknownHostException) {
                                this.val$stor.ping = -1L;
                                this.val$stor.serversideName = "\u00a74Can't resolve hostname";
                                bl = false;
                                break block54;
                            }
                            catch (SocketTimeoutException socketTimeoutException) {
                                this.val$stor.ping = -1L;
                                this.val$stor.serversideName = "\u00a74Can't reach server";
                                bl = false;
                            }
                            catch (ConnectException connectException) {
                                this.val$stor.ping = -1L;
                                this.val$stor.serversideName = "\u00a74Can't reach server";
                                bl = false;
                                break block56;
                            }
                            catch (IOException iOException) {
                                this.val$stor.ping = -1L;
                                this.val$stor.serversideName = "\u00a74Communication error";
                                bl = false;
                                break block57;
                            }
                            catch (Exception exception) {
                                this.val$stor.ping = -1L;
                                this.val$stor.serversideName = "ERROR: " + exception.toString();
                                bl = false;
                                break block58;
                            }
                            finally {
                                if (bl) {
                                    Object object = C_ba.access$600();
                                    synchronized (object) {
                                        C_ba.access$710();
                                    }
                                }
                            }
                            Object object = C_ba.access$600();
                            synchronized (object) {
                                C_ba.access$710();
                                return;
                            }
                        }
                        Object object = C_ba.access$600();
                        synchronized (object) {
                            C_ba.access$710();
                            return;
                        }
                    }
                    Object object = C_ba.access$600();
                    synchronized (object) {
                        C_ba.access$710();
                        return;
                    }
                }
                Object object = C_ba.access$600();
                synchronized (object) {
                    C_ba.access$710();
                    return;
                }
            }
            Object object = C_ba.access$600();
            synchronized (object) {
                C_ba.access$710();
                return;
            }
        }
        Object object = C_ba.access$600();
        synchronized (object) {
            C_ba.access$710();
        }
    }
}

