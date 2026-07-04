/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import net.minecraft.a.a.C_q;
import net.minecraft.a.b.ItemStack;
import net.minecraft.network.WatchableObject;
import net.minecraft.network.packet.Packet;

public class DataWatcher {
    private static final HashMap<Class<?>, Integer> dataTypes = new HashMap();
    private final Map<Integer, WatchableObject> watchedObjects = new HashMap<Integer, WatchableObject>();
    private boolean objectChanged;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addObject(int n, Object object) {
        Integer n2 = dataTypes.get(object.getClass());
        if (n2 == null) {
            throw new IllegalArgumentException("Unknown data type: " + object.getClass());
        }
        if (n > 31) {
            throw new IllegalArgumentException("Data value id is too big with " + n + "! (Max is " + 31 + ")");
        }
        if (this.watchedObjects.containsKey(n)) {
            throw new IllegalArgumentException("Duplicate id value for " + n + "!");
        }
        WatchableObject watchableObject = new WatchableObject(n2, n, object);
        this.watchedObjects.put(n, watchableObject);
    }

    public byte getWatchableObjectByte(int n) {
        if (this.watchedObjects.get(n) == null) {
            return 0;
        }
        return (Byte)this.watchedObjects.get(n).getObject();
    }

    public int getWatchableObjectInt(int n) {
        if (this.watchedObjects.get(n) == null) {
            return 0;
        }
        return (Integer)this.watchedObjects.get(n).getObject();
    }

    public String getWatchableObjectString(int n) {
        if (this.watchedObjects.get(n) == null) {
            return "";
        }
        return (String)this.watchedObjects.get(n).getObject();
    }

    public ItemStack getWatchableObjectItemStack(int n) {
        return (ItemStack)this.watchedObjects.get(n).getObject();
    }

    public void updateObject(int n, Object object) {
        WatchableObject watchableObject = this.watchedObjects.get(n);
        if (object == null) {
            if (watchableObject != null) {
                watchableObject.setObject(null);
                watchableObject.setWatching(true);
                this.objectChanged = true;
            }
            return;
        }
        if (watchableObject == null) {
            this.addObject(n, object);
        } else if (!object.equals(watchableObject.getObject())) {
            watchableObject.setObject(object);
            watchableObject.setWatching(true);
            this.objectChanged = true;
        }
    }

    public void setWatchableState(int n) {
        WatchableObject.setWatchableObjectWatched(this.watchedObjects.get(n), true);
        this.objectChanged = true;
    }

    public static void writeObjectsInListToStream(List<WatchableObject> list, DataOutputStream dataOutputStream) throws IOException {
        if (list != null) {
            for (WatchableObject watchableObject : list) {
                DataWatcher.writeWatchableObject(dataOutputStream, watchableObject);
            }
        }
        dataOutputStream.writeByte(127);
    }

    public void writeWatchableObjects(DataOutputStream dataOutputStream) throws IOException {
        for (WatchableObject watchableObject : this.watchedObjects.values()) {
            DataWatcher.writeWatchableObject(dataOutputStream, watchableObject);
        }
        dataOutputStream.writeByte(127);
    }

    private static void writeWatchableObject(DataOutputStream dataOutputStream, WatchableObject watchableObject) throws IOException {
        int n = (watchableObject.getObjectType() << 5 | watchableObject.getDataValueId() & 0x1F) & 0xFF;
        dataOutputStream.writeByte(n);
        switch (watchableObject.getObjectType()) {
            case 0: {
                dataOutputStream.writeByte(((Byte)watchableObject.getObject()).byteValue());
                break;
            }
            case 1: {
                dataOutputStream.writeShort(((Short)watchableObject.getObject()).shortValue());
                break;
            }
            case 2: {
                dataOutputStream.writeInt((Integer)watchableObject.getObject());
                break;
            }
            case 3: {
                dataOutputStream.writeFloat(((Float)watchableObject.getObject()).floatValue());
                break;
            }
            case 4: {
                Packet.writeString((String)watchableObject.getObject(), dataOutputStream);
                break;
            }
            case 5: {
                Packet.writeItemStack((ItemStack)watchableObject.getObject(), dataOutputStream);
                break;
            }
            case 6: {
                C_q c_q = (C_q)watchableObject.getObject();
                dataOutputStream.writeInt(c_q.x);
                dataOutputStream.writeInt(c_q.y);
                dataOutputStream.writeInt(c_q.z);
            }
        }
    }

    public static List<WatchableObject> readWatchableObjects(DataInputStream dataInputStream) throws IOException {
        ArrayList<WatchableObject> arrayList = null;
        byte by = dataInputStream.readByte();
        while (by != 127) {
            if (arrayList == null) {
                arrayList = new ArrayList<WatchableObject>();
            }
            int n = (by & 0xE0) >> 5;
            int n2 = by & 0x1F;
            WatchableObject watchableObject = null;
            switch (n) {
                case 0: {
                    watchableObject = new WatchableObject(n, n2, dataInputStream.readByte());
                    break;
                }
                case 1: {
                    watchableObject = new WatchableObject(n, n2, dataInputStream.readShort());
                    break;
                }
                case 2: {
                    watchableObject = new WatchableObject(n, n2, dataInputStream.readInt());
                    break;
                }
                case 3: {
                    watchableObject = new WatchableObject(n, n2, Float.valueOf(dataInputStream.readFloat()));
                    break;
                }
                case 4: {
                    watchableObject = new WatchableObject(n, n2, Packet.readString(dataInputStream, 64));
                    break;
                }
                case 5: {
                    ItemStack itemStack = Packet.readItemStack(dataInputStream);
                    watchableObject = new WatchableObject(n, n2, itemStack);
                    break;
                }
                case 6: {
                    int n3 = dataInputStream.readInt();
                    int n4 = dataInputStream.readInt();
                    int n5 = dataInputStream.readInt();
                    watchableObject = new WatchableObject(n, n2, new C_q(n3, n4, n5));
                }
            }
            arrayList.add(watchableObject);
            by = dataInputStream.readByte();
        }
        return arrayList;
    }

    public void updateWatchedObjectsFromList(List<WatchableObject> list) {
        for (WatchableObject watchableObject : list) {
            WatchableObject watchableObject2 = this.watchedObjects.get(watchableObject.getDataValueId());
            if (watchableObject2 == null) continue;
            watchableObject2.setObject(watchableObject.getObject());
        }
    }

    public boolean hasObjectChanged() {
        return this.objectChanged;
    }

    public void addObjectByDataType(int n, int n2) {
        WatchableObject watchableObject = new WatchableObject(n2, n, null);
        this.lock.writeLock().lock();
        this.watchedObjects.put(n, watchableObject);
        this.lock.writeLock().unlock();
    }

    static {
        dataTypes.put(Byte.class, 0);
        dataTypes.put(Short.class, 1);
        dataTypes.put(Integer.class, 2);
        dataTypes.put(Float.class, 3);
        dataTypes.put(String.class, 4);
        dataTypes.put(ItemStack.class, 5);
        dataTypes.put(C_q.class, 6);
    }
}

