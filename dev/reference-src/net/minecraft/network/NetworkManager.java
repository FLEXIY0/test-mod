/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet;

public class NetworkManager {
    public static final Object threadSyncObject = new Object();
    public static int numReadThreads;
    public static int numWriteThreads;
    private Object sendQueueLock = new Object();
    private Socket networkSocket;
    private DataInputStream socketInputStream;
    private DataOutputStream socketOutputStream;
    private boolean isRunning = true;
    private List<Packet> readPackets = Collections.synchronizedList(new ArrayList());
    private List<Packet> dataPackets = Collections.synchronizedList(new ArrayList());
    private List<Packet> chunkDataPackets = Collections.synchronizedList(new ArrayList());
    private NetHandler netHandler;
    private boolean isServerTerminating = false;
    private Thread writeThread;
    private Thread readThread;
    private boolean isTerminating = false;
    private String terminationReason = "";
    private int timeSinceLastRead = 0;
    private int sendQueueByteLength = 0;
    public static long bytesRead;
    public static long bytesWritten;
    public int chunkDataSendCounter = 0;
    private int chunkRefreshTime = 50;

    public NetworkManager(Socket socket, String string, NetHandler netHandler) throws IOException {
        this.networkSocket = socket;
        this.netHandler = netHandler;
        try {
            socket.setSoTimeout(30000);
            socket.setTrafficClass(24);
            socket.setTcpNoDelay(true);
        }
        catch (SocketException socketException) {
            System.err.println(socketException.getMessage());
        }
        this.socketInputStream = new DataInputStream(socket.getInputStream());
        this.socketOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream(), 5120));
        this.readThread = new Thread(string + " read thread"){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void run() {
                Object object = threadSyncObject;
                synchronized (object) {
                    ++numReadThreads;
                }
                while (true) {
                    boolean bl = false;
                    try {
                        bl = true;
                        if (!NetworkManager.this.isRunning) {
                            bl = false;
                            break;
                        }
                        if (NetworkManager.this.isServerTerminating) {
                            bl = false;
                            break;
                        }
                        while (NetworkManager.this.readPacket()) {
                        }
                        try {
                            Thread.sleep(2L);
                        }
                        catch (InterruptedException interruptedException) {
                            // empty catch block
                        }
                        continue;
                    }
                    finally {
                        if (!bl) continue;
                        Object object2 = threadSyncObject;
                        synchronized (object2) {
                            --numReadThreads;
                        }
                        continue;
                    }
                    break;
                }
                Object object3 = threadSyncObject;
                synchronized (object3) {
                    --numReadThreads;
                }
            }
        };
        this.writeThread = new Thread(string + " write thread"){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void run() {
                Object object = threadSyncObject;
                synchronized (object) {
                    ++numWriteThreads;
                }
                while (true) {
                    boolean bl = false;
                    try {
                        bl = true;
                        if (!NetworkManager.this.isRunning) {
                            bl = false;
                            break;
                        }
                        while (NetworkManager.this.sendPacket()) {
                        }
                        try {
                            if (NetworkManager.this.socketOutputStream != null) {
                                NetworkManager.this.socketOutputStream.flush();
                            }
                        }
                        catch (IOException iOException) {
                            if (!NetworkManager.this.isTerminating) {
                                NetworkManager.this.handleException(iOException);
                            }
                            iOException.printStackTrace();
                        }
                        try {
                            Thread.sleep(2L);
                        }
                        catch (InterruptedException interruptedException) {
                            // empty catch block
                        }
                        continue;
                    }
                    finally {
                        if (!bl) continue;
                        Object object2 = threadSyncObject;
                        synchronized (object2) {
                            --numWriteThreads;
                        }
                        continue;
                    }
                    break;
                }
                Object object3 = threadSyncObject;
                synchronized (object3) {
                    --numWriteThreads;
                }
            }
        };
        this.readThread.start();
        this.writeThread.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addToSendQueue(Packet packet) {
        if (!this.isServerTerminating) {
            Object object = this.sendQueueLock;
            synchronized (object) {
                this.sendQueueByteLength += packet.getPacketSize() + 1;
                if (packet.isChunkDataPacket) {
                    this.chunkDataPackets.add(packet);
                } else {
                    this.dataPackets.add(packet);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean sendPacket() {
        boolean bl = false;
        try {
            Packet packet;
            Object object;
            if (!(this.dataPackets.isEmpty() || this.chunkDataSendCounter != 0 && System.currentTimeMillis() - this.dataPackets.get((int)0).creationTimeMillis < (long)this.chunkDataSendCounter)) {
                object = this.sendQueueLock;
                synchronized (object) {
                    packet = this.dataPackets.remove(0);
                    this.sendQueueByteLength -= packet.getPacketSize() + 1;
                }
                Packet.writePacket(packet, this.socketOutputStream);
                bytesWritten += (long)(packet.getPacketSize() + 1);
                bl = true;
            }
            if (!(this.chunkRefreshTime-- > 0 || this.chunkDataPackets.isEmpty() || this.chunkDataSendCounter != 0 && System.currentTimeMillis() - this.chunkDataPackets.get((int)0).creationTimeMillis < (long)this.chunkDataSendCounter)) {
                object = this.sendQueueLock;
                synchronized (object) {
                    packet = this.chunkDataPackets.remove(0);
                    this.sendQueueByteLength -= packet.getPacketSize() + 1;
                }
                bytesWritten += (long)(packet.getPacketSize() + 1);
                this.chunkRefreshTime = 0;
                bl = true;
            }
            return bl;
        }
        catch (Exception exception) {
            if (!this.isTerminating) {
                this.handleException(exception);
            }
            return false;
        }
    }

    public void interruptThreads() {
        if (this.readThread != null) {
            this.readThread.interrupt();
        }
        if (this.writeThread != null) {
            this.writeThread.interrupt();
        }
    }

    private boolean readPacket() {
        boolean bl = false;
        try {
            Packet packet = Packet.readPacket(this.socketInputStream, this.netHandler.isServerHandler());
            if (packet != null) {
                bytesRead += (long)(packet.getPacketSize() + 1);
                this.readPackets.add(packet);
                bl = true;
            } else {
                this.networkShutdown("End of stream");
            }
            return bl;
        }
        catch (Exception exception) {
            if (!this.isTerminating) {
                this.handleException(exception);
            }
            return false;
        }
    }

    private void handleException(Exception exception) {
        exception.printStackTrace();
        this.networkShutdown("Internal exception: " + exception.toString());
    }

    public void networkShutdown(String string) {
        if (this.isRunning) {
            this.isTerminating = true;
            this.terminationReason = string;
            new Thread(){

                @Override
                public void run() {
                    try {
                        Thread.sleep(5000L);
                        if (NetworkManager.this.readThread.isAlive()) {
                            try {
                                NetworkManager.this.readThread.stop();
                            }
                            catch (Throwable throwable) {
                                // empty catch block
                            }
                        }
                        if (NetworkManager.this.writeThread.isAlive()) {
                            try {
                                NetworkManager.this.writeThread.stop();
                            }
                            catch (Throwable throwable) {}
                        }
                    }
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            }.start();
            this.isRunning = false;
            try {
                this.socketInputStream.close();
                this.socketInputStream = null;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                this.socketOutputStream.close();
                this.socketOutputStream = null;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                this.networkSocket.close();
                this.networkSocket = null;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        bytesRead = 0L;
        bytesWritten = 0L;
    }

    public void processReadPackets() {
        if (this.sendQueueByteLength > 0x200000) {
            this.networkShutdown("Buffer Overflow");
        }
        if (this.readPackets.isEmpty()) {
            if (this.timeSinceLastRead++ == 1200) {
                this.networkShutdown("Timed out");
            }
        } else {
            this.timeSinceLastRead = 0;
        }
        int n = 1000;
        while (!this.readPackets.isEmpty() && n-- >= 0) {
            Packet packet = this.readPackets.remove(0);
            packet.processPacket(this.netHandler);
        }
        this.interruptThreads();
        if (this.isTerminating && this.readPackets.isEmpty()) {
            this.netHandler.handleErrorMessage(this.terminationReason);
        }
    }

    public void closeConnection() {
        this.interruptThreads();
        this.isServerTerminating = true;
        this.readThread.interrupt();
        new Thread(){

            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                    if (NetworkManager.this.isRunning) {
                        NetworkManager.this.writeThread.interrupt();
                        NetworkManager.this.networkShutdown("Connection closed");
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }.start();
    }
}

