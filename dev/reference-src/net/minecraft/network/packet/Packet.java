/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import com.a.a.C_m;
import com.a.a.NBTTagCompound;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.a.b.ItemStack;
import net.minecraft.network.NetHandler;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet100OpenWindow;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet102WindowClick;
import net.minecraft.network.packet.Packet103SetSlot;
import net.minecraft.network.packet.Packet104WindowItems;
import net.minecraft.network.packet.Packet105UpdateProgressbar;
import net.minecraft.network.packet.Packet106Transaction;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet11PlayerPosition;
import net.minecraft.network.packet.Packet12PlayerLook;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.network.packet.Packet13PlayerLookMove;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet17Gamemode;
import net.minecraft.network.packet.Packet18SpawnPos;
import net.minecraft.network.packet.Packet192Ping;
import net.minecraft.network.packet.Packet19Animation;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.network.packet.Packet201PlayerInfo;
import net.minecraft.network.packet.Packet202CreativeInventory;
import net.minecraft.network.packet.Packet20NamedEntitySpawn;
import net.minecraft.network.packet.Packet21PickupSpawn;
import net.minecraft.network.packet.Packet22Collect;
import net.minecraft.network.packet.Packet23VehicleSpawn;
import net.minecraft.network.packet.Packet24MobSpawn;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet251LevelThemes;
import net.minecraft.network.packet.Packet252LevelMetadata;
import net.minecraft.network.packet.Packet253ServerName;
import net.minecraft.network.packet.Packet254Reload;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.network.packet.Packet25EntityPainting;
import net.minecraft.network.packet.Packet26PlayerState;
import net.minecraft.network.packet.Packet27UseCharm;
import net.minecraft.network.packet.Packet28EntityVelocity;
import net.minecraft.network.packet.Packet29DestroyEntity;
import net.minecraft.network.packet.Packet2Handshake;
import net.minecraft.network.packet.Packet30Entity;
import net.minecraft.network.packet.Packet31RelEntityMove;
import net.minecraft.network.packet.Packet32EntityLook;
import net.minecraft.network.packet.Packet33RelEntityMoveLook;
import net.minecraft.network.packet.Packet34EntityTeleport;
import net.minecraft.network.packet.Packet38EntityStatus;
import net.minecraft.network.packet.Packet39AttachEntity;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet40EntityMetadata;
import net.minecraft.network.packet.Packet41UpdateSeason;
import net.minecraft.network.packet.Packet49LevelInit;
import net.minecraft.network.packet.Packet4UpdateTime;
import net.minecraft.network.packet.Packet50LevelData;
import net.minecraft.network.packet.Packet51LevelFinalized;
import net.minecraft.network.packet.Packet52MultiBlockChange;
import net.minecraft.network.packet.Packet53BlockChange;
import net.minecraft.network.packet.Packet54PlayNoteBlock;
import net.minecraft.network.packet.Packet55PlayRecord;
import net.minecraft.network.packet.Packet5PlayerInventory;
import net.minecraft.network.packet.Packet60Explosion;
import net.minecraft.network.packet.Packet61DoorChange;
import net.minecraft.network.packet.Packet6SpawnPosition;
import net.minecraft.network.packet.Packet71Weather;
import net.minecraft.network.packet.Packet7UseEntity;
import net.minecraft.network.packet.Packet8UpdateHealth;
import net.minecraft.network.packet.Packet91ActivateGenerator;
import net.minecraft.network.packet.Packet9Respawn;

public abstract class Packet {
    public static final byte BOOL = 1;
    public static final byte BYTE = 1;
    public static final byte SHORT = 2;
    public static final byte CHAR = 2;
    public static final byte INT = 4;
    public static final byte FLOAT = 4;
    public static final byte LONG = 8;
    public static final byte DOUBLE = 8;
    public static final short LEVEL_DATA = 1024;
    private static Map<Integer, Class<? extends Packet>> packetIdToClassMap = new HashMap<Integer, Class<? extends Packet>>();
    private static Map<Class<? extends Packet>, Integer> packetClassToIdMap = new HashMap<Class<? extends Packet>, Integer>();
    private static Set<Integer> clientPacketIdList = new HashSet<Integer>();
    private static Set<Integer> serverPacketIdList = new HashSet<Integer>();
    public final long creationTimeMillis = System.currentTimeMillis();
    public boolean isChunkDataPacket = false;
    private static int totalPacketsCount;

    private static void addIdClassMapping(int n, boolean bl, boolean bl2, Class<? extends Packet> clazz) {
        if (packetIdToClassMap.containsKey(n)) {
            throw new IllegalArgumentException("Duplicate packet id:" + n);
        }
        if (packetClassToIdMap.containsKey(clazz)) {
            throw new IllegalArgumentException("Duplicate packet class:" + clazz);
        }
        packetIdToClassMap.put(n, clazz);
        packetClassToIdMap.put(clazz, n);
        if (bl) {
            clientPacketIdList.add(n);
        }
        if (bl2) {
            serverPacketIdList.add(n);
        }
    }

    public static Packet getNewPacket(int n) {
        try {
            Class<? extends Packet> clazz = packetIdToClassMap.get(n);
            return clazz == null ? null : clazz.newInstance();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Skipping packet with id " + n);
            return null;
        }
    }

    public final int getPacketId() {
        return packetClassToIdMap.get(this.getClass());
    }

    public static Packet readPacket(DataInputStream dataInputStream, boolean bl) throws IOException {
        Packet packet = null;
        try {
            int n = dataInputStream.read();
            if (n == -1) {
                return null;
            }
            if (bl && !serverPacketIdList.contains(n) || !bl && !clientPacketIdList.contains(n)) {
                throw new IOException("Bad packet id " + n);
            }
            packet = Packet.getNewPacket(n);
            if (packet == null) {
                throw new IOException("Bad packet id " + n);
            }
            packet.readPacketData(dataInputStream);
        }
        catch (EOFException eOFException) {
            System.out.println("Reached end of stream");
            return null;
        }
        if (++totalPacketsCount % 1000 == 0) {
            // empty if block
        }
        return packet;
    }

    public static void writePacket(Packet packet, DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(packet.getPacketId());
        packet.writePacketData(dataOutputStream);
    }

    public static void writeString(String string, DataOutputStream dataOutputStream) throws IOException {
        if (string.length() > Short.MAX_VALUE) {
            throw new IOException("String too big");
        }
        dataOutputStream.writeShort(string.length());
        dataOutputStream.writeChars(string);
    }

    public static String readString(DataInputStream dataInputStream, int n) throws IOException {
        int n2 = dataInputStream.readShort();
        if (n2 > n) {
            throw new IOException("Received string length longer than maximum allowed (" + n2 + " > " + n + ")");
        }
        if (n2 < 0) {
            throw new IOException("Received string length is less than zero! Weird string!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n2; ++i) {
            stringBuilder.append(dataInputStream.readChar());
        }
        return stringBuilder.toString();
    }

    public static ItemStack readItemStack(DataInputStream dataInputStream) throws IOException {
        ItemStack itemStack = null;
        short s = dataInputStream.readShort();
        if (s >= 0) {
            byte by = dataInputStream.readByte();
            short s2 = dataInputStream.readShort();
            itemStack = new ItemStack(s, (int)by, (int)s2);
            itemStack.stackTagCompound = Packet.readNBTTagCompound(dataInputStream);
        }
        return itemStack;
    }

    public static void writeItemStack(ItemStack itemStack, DataOutputStream dataOutputStream) throws IOException {
        if (itemStack == null) {
            dataOutputStream.writeShort(-1);
        } else {
            dataOutputStream.writeShort(itemStack.c);
            dataOutputStream.writeByte(itemStack.a);
            dataOutputStream.writeShort(itemStack.getItemDamage());
            if (itemStack.hasTagCompound()) {
                Packet.writeNBTTagCompound(itemStack.stackTagCompound, dataOutputStream);
            } else {
                dataOutputStream.writeShort(-1);
            }
        }
    }

    public static NBTTagCompound readNBTTagCompound(DataInputStream dataInputStream) throws IOException {
        short s = dataInputStream.readShort();
        if (s < 0) {
            return null;
        }
        byte[] byArray = new byte[s];
        dataInputStream.readFully(byArray);
        return C_m.decompress(byArray);
    }

    public static void writeNBTTagCompound(NBTTagCompound nBTTagCompound, DataOutputStream dataOutputStream) throws IOException {
        if (nBTTagCompound == null) {
            dataOutputStream.writeShort(-1);
        } else {
            byte[] byArray = C_m.compress(nBTTagCompound);
            dataOutputStream.writeShort((short)byArray.length);
            dataOutputStream.write(byArray);
        }
    }

    public abstract void readPacketData(DataInputStream var1) throws IOException;

    public abstract void writePacketData(DataOutputStream var1) throws IOException;

    public abstract void processPacket(NetHandler var1);

    public abstract int getPacketSize();

    static {
        Packet.addIdClassMapping(0, true, true, Packet0KeepAlive.class);
        Packet.addIdClassMapping(1, true, true, Packet1Login.class);
        Packet.addIdClassMapping(2, true, true, Packet2Handshake.class);
        Packet.addIdClassMapping(3, true, true, Packet3Chat.class);
        Packet.addIdClassMapping(4, true, false, Packet4UpdateTime.class);
        Packet.addIdClassMapping(5, true, false, Packet5PlayerInventory.class);
        Packet.addIdClassMapping(6, true, false, Packet6SpawnPosition.class);
        Packet.addIdClassMapping(7, false, true, Packet7UseEntity.class);
        Packet.addIdClassMapping(8, true, false, Packet8UpdateHealth.class);
        Packet.addIdClassMapping(9, true, true, Packet9Respawn.class);
        Packet.addIdClassMapping(10, true, true, Packet10Flying.class);
        Packet.addIdClassMapping(11, true, true, Packet11PlayerPosition.class);
        Packet.addIdClassMapping(12, true, true, Packet12PlayerLook.class);
        Packet.addIdClassMapping(13, true, true, Packet13PlayerLookMove.class);
        Packet.addIdClassMapping(14, true, true, Packet14BlockDig.class);
        Packet.addIdClassMapping(15, false, true, Packet15Place.class);
        Packet.addIdClassMapping(16, false, true, Packet16BlockItemSwitch.class);
        Packet.addIdClassMapping(17, true, false, Packet17Gamemode.class);
        Packet.addIdClassMapping(18, true, true, Packet18SpawnPos.class);
        Packet.addIdClassMapping(19, true, true, Packet19Animation.class);
        Packet.addIdClassMapping(20, true, false, Packet20NamedEntitySpawn.class);
        Packet.addIdClassMapping(21, true, false, Packet21PickupSpawn.class);
        Packet.addIdClassMapping(22, true, false, Packet22Collect.class);
        Packet.addIdClassMapping(23, true, false, Packet23VehicleSpawn.class);
        Packet.addIdClassMapping(24, true, false, Packet24MobSpawn.class);
        Packet.addIdClassMapping(25, true, false, Packet25EntityPainting.class);
        Packet.addIdClassMapping(26, true, true, Packet26PlayerState.class);
        Packet.addIdClassMapping(27, true, true, Packet27UseCharm.class);
        Packet.addIdClassMapping(28, true, false, Packet28EntityVelocity.class);
        Packet.addIdClassMapping(29, true, false, Packet29DestroyEntity.class);
        Packet.addIdClassMapping(30, true, false, Packet30Entity.class);
        Packet.addIdClassMapping(31, true, false, Packet31RelEntityMove.class);
        Packet.addIdClassMapping(32, true, false, Packet32EntityLook.class);
        Packet.addIdClassMapping(33, true, false, Packet33RelEntityMoveLook.class);
        Packet.addIdClassMapping(34, true, false, Packet34EntityTeleport.class);
        Packet.addIdClassMapping(38, true, false, Packet38EntityStatus.class);
        Packet.addIdClassMapping(39, true, false, Packet39AttachEntity.class);
        Packet.addIdClassMapping(40, true, false, Packet40EntityMetadata.class);
        Packet.addIdClassMapping(41, true, false, Packet41UpdateSeason.class);
        Packet.addIdClassMapping(49, true, false, Packet49LevelInit.class);
        Packet.addIdClassMapping(50, true, false, Packet50LevelData.class);
        Packet.addIdClassMapping(51, true, false, Packet51LevelFinalized.class);
        Packet.addIdClassMapping(52, true, false, Packet52MultiBlockChange.class);
        Packet.addIdClassMapping(53, true, false, Packet53BlockChange.class);
        Packet.addIdClassMapping(54, true, false, Packet54PlayNoteBlock.class);
        Packet.addIdClassMapping(55, true, false, Packet55PlayRecord.class);
        Packet.addIdClassMapping(60, true, false, Packet60Explosion.class);
        Packet.addIdClassMapping(61, true, true, Packet61DoorChange.class);
        Packet.addIdClassMapping(71, true, false, Packet71Weather.class);
        Packet.addIdClassMapping(91, true, true, Packet91ActivateGenerator.class);
        Packet.addIdClassMapping(100, true, false, Packet100OpenWindow.class);
        Packet.addIdClassMapping(101, true, true, Packet101CloseWindow.class);
        Packet.addIdClassMapping(102, false, true, Packet102WindowClick.class);
        Packet.addIdClassMapping(103, true, false, Packet103SetSlot.class);
        Packet.addIdClassMapping(104, true, false, Packet104WindowItems.class);
        Packet.addIdClassMapping(105, true, false, Packet105UpdateProgressbar.class);
        Packet.addIdClassMapping(106, true, true, Packet106Transaction.class);
        Packet.addIdClassMapping(130, true, true, Packet130UpdateSign.class);
        Packet.addIdClassMapping(192, false, true, Packet192Ping.class);
        Packet.addIdClassMapping(201, true, false, Packet201PlayerInfo.class);
        Packet.addIdClassMapping(202, false, true, Packet202CreativeInventory.class);
        Packet.addIdClassMapping(250, true, true, Packet250CustomPayload.class);
        Packet.addIdClassMapping(251, true, false, Packet251LevelThemes.class);
        Packet.addIdClassMapping(252, true, false, Packet252LevelMetadata.class);
        Packet.addIdClassMapping(253, true, false, Packet253ServerName.class);
        Packet.addIdClassMapping(254, true, false, Packet254Reload.class);
        Packet.addIdClassMapping(255, true, true, Packet255KickDisconnect.class);
        totalPacketsCount = 0;
    }
}

