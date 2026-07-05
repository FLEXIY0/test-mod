/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

public interface ClientConstants {
    public static final String VERSION_STRING = "20251230";
    public static final char COLOR_FORMAT_CHAR = '\u00a7';
    public static final int PROTOCOL_VERSION = 20251026;
    public static final boolean MP_TEST = "20251230".contains("MP_TEST");
    public static final boolean MP_JOIN_LOCAL_OVERRIDE = Boolean.parseBoolean(System.getProperty("net.minecraft.client.ClientConstants.mpLocalOverride"));
}

