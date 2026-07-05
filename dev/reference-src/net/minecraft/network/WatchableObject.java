/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

public class WatchableObject {
    private final int objectType;
    private final int dataValueId;
    private Object watchedObject;
    private boolean isWatching;

    public WatchableObject(int n, int n2, Object object) {
        this.dataValueId = n2;
        this.watchedObject = object;
        this.objectType = n;
    }

    public int getDataValueId() {
        return this.dataValueId;
    }

    public void setObject(Object object) {
        this.watchedObject = object;
    }

    public Object getObject() {
        return this.watchedObject;
    }

    public int getObjectType() {
        return this.objectType;
    }

    public boolean isWatching() {
        return this.isWatching;
    }

    public void setWatching(boolean bl) {
        this.isWatching = bl;
    }

    static boolean setWatchableObjectWatched(WatchableObject watchableObject, boolean bl) {
        watchableObject.isWatching = bl;
        return watchableObject.isWatching;
    }
}

