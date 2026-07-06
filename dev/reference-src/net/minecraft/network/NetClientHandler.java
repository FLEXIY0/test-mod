/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.a.C_j;
import net.minecraft.a.a.World;
import net.minecraft.a.a.C_l;
import net.minecraft.a.a.C_m;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.C_h;
import net.minecraft.a.a.b.a.C_i;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_a;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.EntityLiving;
import net.minecraft.a.c.EntityList;
import net.minecraft.a.c.e.C_c;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.C_ai;
import net.minecraft.client.c.C_ar;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.c.a.C_q;
import net.minecraft.client.d;
import net.minecraft.client.g.C_d;
import net.minecraft.network.GuiPlayerInfo;
import net.minecraft.network.NetHandler;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.WatchableObject;
import net.minecraft.network.WorldClient;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet100OpenWindow;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet103SetSlot;
import net.minecraft.network.packet.Packet104WindowItems;
import net.minecraft.network.packet.Packet105UpdateProgressbar;
import net.minecraft.network.packet.Packet106Transaction;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet17Gamemode;
import net.minecraft.network.packet.Packet18SpawnPos;
import net.minecraft.network.packet.Packet19Animation;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.network.packet.Packet201PlayerInfo;
import net.minecraft.network.packet.Packet20NamedEntitySpawn;
import net.minecraft.network.packet.Packet21PickupSpawn;
import net.minecraft.network.packet.Packet22Collect;
import net.minecraft.network.packet.Packet23VehicleSpawn;
import net.minecraft.network.packet.Packet24MobSpawn;
import net.minecraft.network.packet.Packet251LevelThemes;
import net.minecraft.network.packet.Packet252LevelMetadata;
import net.minecraft.network.packet.Packet253ServerName;
import net.minecraft.network.packet.Packet254Reload;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.network.packet.Packet25EntityPainting;
import net.minecraft.network.packet.Packet26PlayerState;
import net.minecraft.network.packet.Packet28EntityVelocity;
import net.minecraft.network.packet.Packet29DestroyEntity;
import net.minecraft.network.packet.Packet2Handshake;
import net.minecraft.network.packet.Packet30Entity;
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
import net.minecraft.network.packet.Packet8UpdateHealth;
import net.minecraft.network.packet.Packet91ActivateGenerator;
import net.minecraft.network.packet.Packet9Respawn;
import util.MathHelper;

public class NetClientHandler
extends NetHandler {
    private boolean disconnected = false;
    private NetworkManager netManager;
    public String customGreeting;
    private d mc;
    private WorldClient level;
    private boolean hasRespawned = false;
    Random rand = new Random();
    public byte[] levelBytes;
    public byte[] levelMetaBytes;
    public String motd = "";
    public String serverName = "";
    private Map<String, GuiPlayerInfo> playerInfoMap;
    public List<GuiPlayerInfo> playerNames;
    public int currentServerMaxPlayers;
    public int pvn;
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public NetClientHandler(d d2, String string, int n) throws UnknownHostException, IOException {
        this.mc = d2;
        Socket socket = new Socket(InetAddress.getByName(string), n);
        this.netManager = new NetworkManager(socket, "Client", this);
        this.playerNames = new ArrayList<GuiPlayerInfo>();
        this.playerInfoMap = new HashMap<String, GuiPlayerInfo>();
        this.currentServerMaxPlayers = 20;
    }

    public void processReadPackets() {
        if (!this.disconnected) {
            this.netManager.processReadPackets();
        }
        this.netManager.interruptThreads();
    }

    @Override
    public void handleLogin(Packet1Login packet1Login) {
        this.mc.a = new net.minecraft.client.dx.C_d(this.mc, this);
        this.pvn = packet1Login.protocolVersion;
    }

    @Override
    public void handlePickupSpawn(Packet21PickupSpawn packet21PickupSpawn) {
        float f = (float)packet21PickupSpawn.xPosition / 32.0f;
        float f2 = (float)packet21PickupSpawn.yPosition / 32.0f;
        float f3 = (float)packet21PickupSpawn.zPosition / 32.0f;
        net.minecraft.a.c.c.EntityItem c_b = new net.minecraft.a.c.c.EntityItem(this.level, f, f2, f3, packet21PickupSpawn.itemStack);
        c_b.k = (float)packet21PickupSpawn.rotation / 128.0f;
        c_b.l = (float)packet21PickupSpawn.pitch / 128.0f;
        c_b.m = (float)packet21PickupSpawn.roll / 128.0f;
        c_b.serverPosX = packet21PickupSpawn.xPosition;
        c_b.serverPosY = packet21PickupSpawn.yPosition;
        c_b.serverPosZ = packet21PickupSpawn.zPosition;
        this.level.addEntityToWorld(packet21PickupSpawn.entityId, c_b);
    }

    @Override
    public void handleVehicleSpawn(Packet23VehicleSpawn packet23VehicleSpawn) {
        float f = (float)packet23VehicleSpawn.xPosition / 32.0f;
        float f2 = (float)packet23VehicleSpawn.yPosition / 32.0f;
        float f3 = (float)packet23VehicleSpawn.zPosition / 32.0f;
        Entity c_b = null;
        switch (packet23VehicleSpawn.type) {
            case DART: {
                c_b = new net.minecraft.a.c.d.C_b(this.level, f, f2, f3);
                break;
            }
            case ARROW: {
                c_b = new net.minecraft.a.c.d.C_a((World)this.level, f, f2, f3);
                break;
            }
            case TNT: {
                c_b = new net.minecraft.a.c.c.C_a(this.level, f, f2, f3);
                break;
            }
            case SAND: {
                c_b = new net.minecraft.a.c.c.C_c(this.level, f, f2, f3, packet23VehicleSpawn.metadata);
                break;
            }
            case MINECART: {
                c_b = new net.minecraft.a.c.c.C_g(this.level, f, f2, f3, packet23VehicleSpawn.metadata);
                break;
            }
            case SPEAR: {
                c_b = new net.minecraft.a.c.d.C_g(this.level, f, f2, f3);
                break;
            }
            case SNOWBALL: {
                c_b = new net.minecraft.a.c.d.C_f(this.level, f, f2, f3);
                break;
            }
            case SANDBALL: {
                c_b = new net.minecraft.a.c.d.C_e(this.level, f, f2, f3);
                break;
            }
            case FIREBALL: {
                c_b = new net.minecraft.a.c.d.C_d(this.level, f, f2, f3);
                break;
            }
            case FEATHER: {
                c_b = new net.minecraft.a.c.d.C_c(this.level, f, f2, f3);
                break;
            }
            case BOBBER: {
                c_b = new net.minecraft.a.c.c.C_d(this.level, f, f2, f3);
                break;
            }
        }
        if (c_b != null) {
            c_b.serverPosX = packet23VehicleSpawn.xPosition;
            c_b.serverPosY = packet23VehicleSpawn.yPosition;
            c_b.serverPosZ = packet23VehicleSpawn.zPosition;
            c_b.n = 0.0f;
            c_b.o = 0.0f;
            c_b.entityId = packet23VehicleSpawn.entityId;
            this.level.addEntityToWorld(packet23VehicleSpawn.entityId, c_b);
            if (packet23VehicleSpawn.updateCounter > 0) {
                switch (packet23VehicleSpawn.type) {
                    case ARROW: {
                        Entity c_b2 = this.getEntityByID(packet23VehicleSpawn.updateCounter);
                        if (!(c_b2 instanceof EntityLiving)) break;
                        ((net.minecraft.a.c.d.C_a)c_b).S = (EntityLiving)c_b2;
                        break;
                    }
                    case SPEAR: {
                        Entity c_b3 = this.getEntityByID(packet23VehicleSpawn.updateCounter);
                        if (!(c_b3 instanceof EntityLiving)) break;
                        ((net.minecraft.a.c.d.C_g)c_b).owner = (EntityLiving)c_b3;
                        break;
                    }
                    case SNOWBALL: {
                        Entity c_b4 = this.getEntityByID(packet23VehicleSpawn.updateCounter);
                        if (!(c_b4 instanceof EntityLiving)) break;
                        ((net.minecraft.a.c.d.C_f)c_b).thrower = (EntityLiving)c_b4;
                        break;
                    }
                    case SANDBALL: {
                        Entity c_b5 = this.getEntityByID(packet23VehicleSpawn.updateCounter);
                        if (!(c_b5 instanceof EntityLiving)) break;
                        ((net.minecraft.a.c.d.C_e)c_b).thrower = (EntityLiving)c_b5;
                        break;
                    }
                    case FIREBALL: {
                        Entity c_b6 = this.getEntityByID(packet23VehicleSpawn.updateCounter);
                        if (!(c_b6 instanceof EntityLiving)) break;
                        ((net.minecraft.a.c.d.C_d)c_b).thrower = (EntityLiving)c_b6;
                        break;
                    }
                    case FEATHER: {
                        Entity c_b7 = this.getEntityByID(packet23VehicleSpawn.updateCounter);
                        if (!(c_b7 instanceof EntityLiving)) break;
                        ((net.minecraft.a.c.d.C_c)c_b).thrower = (EntityLiving)c_b7;
                        break;
                    }
                    case BOBBER: {
                        Entity c_b8 = this.getEntityByID(packet23VehicleSpawn.updateCounter);
                        if (!(c_b8 instanceof EntityLiving)) break;
                        ((net.minecraft.a.c.c.C_d)c_b).angler = (EntityPlayer)c_b8;
                        break;
                    }
                }
                c_b.setVelocity((float)packet23VehicleSpawn.newX / 8000.0f, (float)packet23VehicleSpawn.newY / 8000.0f, (float)packet23VehicleSpawn.newZ / 8000.0f);
            }
        }
    }

    @Override
    public void handlePlacePainting(Packet25EntityPainting packet25EntityPainting) {
        C_a c_a = new C_a(this.level, packet25EntityPainting.xPosition, packet25EntityPainting.yPosition, packet25EntityPainting.zPosition, packet25EntityPainting.direction, packet25EntityPainting.title, packet25EntityPainting.meta);
        if (packet25EntityPainting.meta == -1) {
            c_a = new net.minecraft.a.c.c.C_e(this.level, packet25EntityPainting.xPosition, packet25EntityPainting.yPosition, packet25EntityPainting.zPosition, packet25EntityPainting.direction);
            if (packet25EntityPainting.itemId > 0) {
                ((net.minecraft.a.c.c.C_e)c_a).setDisplayedItem(new ItemStack(packet25EntityPainting.itemId, 1));
                ((net.minecraft.a.c.c.C_e)c_a).setItemRotation(packet25EntityPainting.rotation);
            }
        }
        this.level.addEntityToWorld(packet25EntityPainting.entityId, c_a);
    }

    @Override
    public void handleBlockDig(Packet14BlockDig packet14BlockDig) {
        this.mc.g.a(packet14BlockDig.xPosition, packet14BlockDig.yPosition, packet14BlockDig.zPosition);
        World c_g = this.mc.d;
        Block c_x = Block.c[c_g.a(packet14BlockDig.xPosition, packet14BlockDig.yPosition, packet14BlockDig.zPosition)];
        byte by = c_g.e(packet14BlockDig.xPosition, packet14BlockDig.yPosition, packet14BlockDig.zPosition);
        if (c_x != null) {
            net.minecraft.client.e.C_c c_c = this.mc.x;
            String string = c_x.getStepSound(by).a();
            float f = (float)packet14BlockDig.xPosition + 0.5f;
            float f2 = (float)packet14BlockDig.yPosition + 0.5f;
            float f3 = (float)packet14BlockDig.zPosition + 0.5f;
            float f4 = (c_x.getStepSound((int)by).a + 1.0f) / 2.0f;
            c_c.playBlockSound(string, f, f2, f3, f4, c_x.getStepSound((int)by).b * 0.8f);
        }
    }

    @Override
    public void handleDoorChange(Packet61DoorChange packet61DoorChange) {
        Block c_x = Block.c[this.mc.d.a(packet61DoorChange.xCoord, packet61DoorChange.yCoord, packet61DoorChange.zCoord)];
        if (c_x != null) {
            this.mc.d.c(packet61DoorChange.xCoord, packet61DoorChange.yCoord, packet61DoorChange.zCoord, c_x.at);
        }
    }

    @Override
    public void handleVelocity(Packet28EntityVelocity packet28EntityVelocity) {
        Entity c_b = this.getEntityByID(packet28EntityVelocity.entityId);
        if (c_b != null) {
            c_b.setVelocity((float)packet28EntityVelocity.motionX / 8000.0f, (float)packet28EntityVelocity.motionY / 8000.0f, (float)packet28EntityVelocity.motionZ / 8000.0f);
        }
    }

    @Override
    public void handleMetadata(Packet40EntityMetadata packet40EntityMetadata) {
        Entity c_b = this.getEntityByID(packet40EntityMetadata.entityId);
        if (c_b != null && packet40EntityMetadata.getData() != null) {
            c_b.getDataWatcher().updateWatchedObjectsFromList(packet40EntityMetadata.getData());
        }
    }

    @Override
    public void handleNamedEntitySpawn(Packet20NamedEntitySpawn packet20NamedEntitySpawn) {
        float f = (float)packet20NamedEntitySpawn.xPosition / 32.0f;
        float f2 = (float)packet20NamedEntitySpawn.yPosition / 32.0f;
        float f3 = (float)packet20NamedEntitySpawn.zPosition / 32.0f;
        float f4 = (float)(packet20NamedEntitySpawn.rotation * 360) / 256.0f;
        float f5 = (float)(packet20NamedEntitySpawn.pitch * 360) / 256.0f;
        C_c c_c = new C_c(this.mc.d, packet20NamedEntitySpawn.name);
        c_c.serverPosX = packet20NamedEntitySpawn.xPosition;
        c_c.e = c_c.B = (float)c_c.serverPosX;
        c_c.serverPosY = packet20NamedEntitySpawn.yPosition;
        c_c.f = c_c.C = (float)c_c.serverPosY;
        c_c.serverPosZ = packet20NamedEntitySpawn.zPosition;
        c_c.g = c_c.D = (float)c_c.serverPosZ;
        int n = packet20NamedEntitySpawn.currentItem;
        c_c.b.a[c_c.b.c] = n == 0 ? null : new ItemStack(n, 1, 0);
        c_c.b(f, f2 - c_c.v, f3, f4, f5);
        this.level.addEntityToWorld(packet20NamedEntitySpawn.entityId, c_c);
    }

    @Override
    public void handleEntityTeleport(Packet34EntityTeleport packet34EntityTeleport) {
        Entity c_b = this.getEntityByID(packet34EntityTeleport.entityId);
        if (c_b != null) {
            c_b.serverPosX = packet34EntityTeleport.xPosition;
            c_b.serverPosY = packet34EntityTeleport.yPosition;
            c_b.serverPosZ = packet34EntityTeleport.zPosition;
            float f = (float)c_b.serverPosX / 32.0f;
            float f2 = (float)c_b.serverPosY / 32.0f + 0.015625f;
            float f3 = (float)c_b.serverPosZ / 32.0f;
            float f4 = (float)(packet34EntityTeleport.yaw * 360) / 256.0f;
            float f5 = (float)(packet34EntityTeleport.pitch * 360) / 256.0f;
            c_b.setPositionAndRotation2(f, f2, f3, f4, f5, 3);
        }
    }

    @Override
    public void handleEntity(Packet30Entity packet30Entity) {
        Entity c_b = this.getEntityByID(packet30Entity.entityId);
        if (c_b != null) {
            c_b.serverPosX += packet30Entity.xPosition;
            c_b.serverPosY += packet30Entity.yPosition;
            c_b.serverPosZ += packet30Entity.zPosition;
            float f = (float)c_b.serverPosX / 32.0f;
            float f2 = (float)c_b.serverPosY / 32.0f;
            float f3 = (float)c_b.serverPosZ / 32.0f;
            float f4 = packet30Entity.rotating ? (float)(packet30Entity.yaw * 360) / 256.0f : c_b.n;
            float f5 = packet30Entity.rotating ? (float)(packet30Entity.pitch * 360) / 256.0f : c_b.o;
            c_b.setPositionAndRotation2(f, f2, f3, f4, f5, 3);
        }
    }

    @Override
    public void handleRide(Packet39AttachEntity packet39AttachEntity) {
        Entity c_b = this.getEntityByID(packet39AttachEntity.entityId);
        Entity c_b2 = this.getEntityByID(packet39AttachEntity.vehicleEntityId);
        if (packet39AttachEntity.entityId == this.mc.f.entityId) {
            c_b = this.mc.f;
        }
        if (c_b != null) {
            c_b.mountEntity(c_b2);
            c_b.isSitting = true;
        }
        if (c_b2 == null) {
            c_b.isSitting = false;
        }
    }

    @Override
    public void handleDestroyEntity(Packet29DestroyEntity packet29DestroyEntity) {
        this.level.removeEntityFromWorld(packet29DestroyEntity.entityId);
    }

    @Override
    public void handleFlying(Packet10Flying packet10Flying) {
        net.minecraft.client.g.EntityPlayerSP c_a = this.mc.f;
        float f = c_a.h;
        float f2 = c_a.i;
        float f3 = c_a.j;
        float f4 = c_a.n;
        float f5 = c_a.o;
        if (packet10Flying.moving) {
            f = packet10Flying.xPosition;
            f2 = packet10Flying.yPosition;
            f3 = packet10Flying.zPosition;
        }
        if (packet10Flying.rotating) {
            f4 = packet10Flying.yaw;
            f5 = packet10Flying.pitch;
        }
        c_a.P = 0.0f;
        c_a.m = 0.0f;
        c_a.l = 0.0f;
        c_a.k = 0.0f;
        c_a.b(f, f2 - c_a.v, f3, f4, f5);
        packet10Flying.xPosition = c_a.h;
        packet10Flying.yPosition = c_a.r.b;
        packet10Flying.zPosition = c_a.j;
        packet10Flying.stance = c_a.i;
        this.netManager.addToSendQueue(packet10Flying);
        if (!this.hasRespawned) {
            this.mc.f.e = this.mc.f.h;
            this.mc.f.f = this.mc.f.i;
            this.mc.f.g = this.mc.f.j;
            this.hasRespawned = true;
            this.mc.a((GuiScreen)null);
        }
    }

    @Override
    public void handleMultiBlockChange(Packet52MultiBlockChange packet52MultiBlockChange) {
        int n = packet52MultiBlockChange.xPosition;
        int n2 = packet52MultiBlockChange.zPosition;
        for (int i = 0; i < packet52MultiBlockChange.size; ++i) {
            short s = packet52MultiBlockChange.coordinateArray[i];
            int n3 = packet52MultiBlockChange.typeArray[i] & 0xFF;
            byte by = packet52MultiBlockChange.metadataArray[i];
            int n4 = s & 0xFF;
            if (this.level == null) continue;
            this.level.setBlockAndMetadata(n, n4, n2, n3, by);
        }
    }

    @Override
    public void handleBlockChange(Packet53BlockChange packet53BlockChange) {
        if (this.level != null) {
            this.level.b(packet53BlockChange.xPosition, packet53BlockChange.yPosition, packet53BlockChange.zPosition, packet53BlockChange.type);
            this.level.setBlockMetadata(packet53BlockChange.xPosition, packet53BlockChange.yPosition, packet53BlockChange.zPosition, packet53BlockChange.metadata);
        }
    }

    @Override
    public void handleNotePlay(Packet54PlayNoteBlock packet54PlayNoteBlock) {
        this.mc.d.playNoteAt(packet54PlayNoteBlock.xLocation, packet54PlayNoteBlock.yLocation, packet54PlayNoteBlock.zLocation, packet54PlayNoteBlock.instrumentType, packet54PlayNoteBlock.pitch);
        if (this.mc.d.j(packet54PlayNoteBlock.xLocation, packet54PlayNoteBlock.yLocation, packet54PlayNoteBlock.zLocation) != null) {
            C_i c_i = (C_i)this.mc.d.j(packet54PlayNoteBlock.xLocation, packet54PlayNoteBlock.yLocation, packet54PlayNoteBlock.zLocation);
            c_i.note = (byte)packet54PlayNoteBlock.pitch;
        }
    }

    @Override
    public void handlePlayRecord(Packet55PlayRecord packet55PlayRecord) {
        if (!packet55PlayRecord.name.isEmpty()) {
            this.mc.d.playRecord(packet55PlayRecord.name, packet55PlayRecord.xLocation, packet55PlayRecord.yLocation, packet55PlayRecord.zLocation);
        } else {
            this.mc.x.a.stop("streaming");
        }
    }

    @Override
    public void handleErrorMessage(String string) {
        if (!this.disconnected) {
            this.disconnected = true;
            this.mc.a((World)null);
            this.mc.a(new C_ai("Connection lost", string));
        }
    }

    public void sendPacketAndDie(Packet packet) {
        if (!this.disconnected) {
            this.netManager.addToSendQueue(packet);
            this.netManager.closeConnection();
        }
    }

    public void addToSendQueue(Packet packet) {
        if (!this.disconnected) {
            this.netManager.addToSendQueue(packet);
        }
    }

    @Override
    public void handleCollect(Packet22Collect packet22Collect) {
        Entity c_b = this.getEntityByID(packet22Collect.collectedEntityId);
        EntityLiving c_e = (EntityLiving)this.getEntityByID(packet22Collect.collectorEntityId);
        if (c_e == null) {
            c_e = this.mc.f;
        }
        if (c_b != null) {
            this.level.a(c_b, "random.pop", 0.2f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            this.mc.g.a(new net.minecraft.client.f.C_e(this.mc.d, c_b, c_e, -0.5f));
            this.level.removeEntityFromWorld(packet22Collect.collectedEntityId);
        }
    }

    @Override
    public void handleChat(Packet3Chat packet3Chat) {
        this.mc.t.addChatMessage(packet3Chat.message);
    }

    @Override
    public void handleHandshake(Packet2Handshake packet2Handshake) {
        if (packet2Handshake.username.equals("-")) {
            this.addToSendQueue(new Packet1Login(this.mc.h.b, 20251026));
        } else {
            try {
                URL uRL = new URL("http://session.minecraft.net/game/joinserver.jsp?user=" + this.mc.h.b + "&sessionId=" + this.mc.h.c + "&serverId=" + packet2Handshake.username);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRL.openStream()));
                String string = bufferedReader.readLine();
                bufferedReader.close();
                if (string.equalsIgnoreCase("ok")) {
                    this.addToSendQueue(new Packet1Login(this.mc.h.b, 20251026));
                } else {
                    this.netManager.networkShutdown("Failed to log in: " + string);
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
                this.netManager.networkShutdown("Internal client error: " + exception.toString());
            }
        }
    }

    public void disconnect() {
        this.levelBytes = null;
        this.levelMetaBytes = null;
        this.disconnected = true;
        this.netManager.interruptThreads();
        this.netManager.networkShutdown("Connection closed");
    }

    @Override
    public void handleMobSpawn(Packet24MobSpawn packet24MobSpawn) {
        float f = (float)packet24MobSpawn.xPosition / 32.0f;
        float f2 = (float)packet24MobSpawn.yPosition / 32.0f;
        float f3 = (float)packet24MobSpawn.zPosition / 32.0f;
        float f4 = (float)(packet24MobSpawn.yaw * 360) / 256.0f;
        float f5 = (float)(packet24MobSpawn.pitch * 360) / 256.0f;
        EntityLiving c_e = (EntityLiving)EntityList.createEntity(packet24MobSpawn.type, this.mc.d);
        c_e.serverPosX = packet24MobSpawn.xPosition;
        c_e.serverPosY = packet24MobSpawn.yPosition;
        c_e.serverPosZ = packet24MobSpawn.zPosition;
        c_e.entityId = packet24MobSpawn.entityId;
        c_e.b(f, f2 - c_e.v, f3, f4, f5);
        c_e.isMultiplayerEntity = true;
        this.level.addEntityToWorld(packet24MobSpawn.entityId, c_e);
        List<WatchableObject> list = packet24MobSpawn.getMetadata();
        if (list != null) {
            c_e.getDataWatcher().updateWatchedObjectsFromList(list);
        }
    }

    @Override
    public void handleUpdateTime(Packet4UpdateTime packet4UpdateTime) {
        this.mc.d.D = packet4UpdateTime.time;
    }

    @Override
    public void handleUpdateSeason(Packet41UpdateSeason packet41UpdateSeason) {
        this.mc.d.season.seasonTime = packet41UpdateSeason.seasonTime;
    }

    @Override
    public void handleWeather(Packet71Weather packet71Weather) {
        float f = (float)packet71Weather.xPosition / 32.0f;
        float f2 = (float)packet71Weather.yPosition / 32.0f;
        float f3 = (float)packet71Weather.zPosition / 32.0f;
        net.minecraft.a.c.c.C_f c_f = null;
        if (packet71Weather.lightningStrike == 1) {
            c_f = new net.minecraft.a.c.c.C_f(this.mc.d, f, f2, f3);
        }
        if (c_f != null) {
            c_f.serverPosX = packet71Weather.xPosition;
            c_f.serverPosY = packet71Weather.yPosition;
            c_f.serverPosZ = packet71Weather.zPosition;
            c_f.n = 0.0f;
            c_f.o = 0.0f;
            c_f.entityId = packet71Weather.playerEntity;
            this.mc.d.spawnEntityInWorld(c_f);
        }
        this.mc.d.setRaining(packet71Weather.raining);
        this.mc.d.setThundering(packet71Weather.thundering);
        this.mc.d.setFogDensity(packet71Weather.fogDensity);
        this.mc.d.setWindDirection(packet71Weather.windDirection, packet71Weather.windForce);
        this.mc.d.bloodMoonChance = packet71Weather.bloodMoon;
        if (packet71Weather.bloodMoon == 9) {
            this.mc.d.setBloodMoon(true);
        } else {
            this.mc.d.setBloodMoon(false);
        }
    }

    @Override
    public void handleSpawnPosition(Packet6SpawnPosition packet6SpawnPosition) {
        if (this.mc.d == null) {
            return;
        }
        this.mc.d.i = packet6SpawnPosition.xPosition;
        this.mc.d.j = packet6SpawnPosition.yPosition;
        this.mc.d.k = packet6SpawnPosition.zPosition;
        this.mc.d.l = packet6SpawnPosition.yaw;
        if (packet6SpawnPosition.teleport) {
            this.mc.f.setLocationAndAngles(packet6SpawnPosition.xPosition, packet6SpawnPosition.yPosition, packet6SpawnPosition.zPosition, packet6SpawnPosition.yaw, packet6SpawnPosition.pitch);
        }
    }

    @Override
    public void handleSpawnPositionLocal(Packet18SpawnPos packet18SpawnPos) {
        if (this.mc.f == null) {
            return;
        }
        this.mc.f.spawnX = (int)packet18SpawnPos.xPosition;
        this.mc.f.spawnY = (int)packet18SpawnPos.yPosition;
        this.mc.f.spawnZ = (int)packet18SpawnPos.zPosition;
    }

    @Override
    public void handleGenerator(Packet91ActivateGenerator packet91ActivateGenerator) {
        if (this.mc.d.j(packet91ActivateGenerator.xPosition, packet91ActivateGenerator.yPosition, packet91ActivateGenerator.zPosition) != null && this.mc.d.j(packet91ActivateGenerator.xPosition, packet91ActivateGenerator.yPosition, packet91ActivateGenerator.zPosition) instanceof C_h) {
            ((C_h)this.mc.d.j((int)packet91ActivateGenerator.xPosition, (int)packet91ActivateGenerator.yPosition, (int)packet91ActivateGenerator.zPosition)).active = packet91ActivateGenerator.state;
        }
    }

    @Override
    public void handleStatus(Packet38EntityStatus packet38EntityStatus) {
        Entity c_b = this.getEntityByID(packet38EntityStatus.entityId);
        if (c_b != null) {
            c_b.handleHealthUpdate(packet38EntityStatus.entityStatus);
        }
    }

    @Override
    public void handlePlayerState(Packet26PlayerState packet26PlayerState) {
        Entity c_b = this.getEntityByID(packet26PlayerState.entityId);
        if (c_b != null) {
            if (packet26PlayerState.type <= 2) {
                c_b.isSneaking = packet26PlayerState.type;
            } else if (packet26PlayerState.type == 3) {
                c_b.isSitting = packet26PlayerState.state;
            } else if (packet26PlayerState.type == 4) {
                c_b.isLaying = packet26PlayerState.state;
            }
        }
    }

    private Entity getEntityByID(int n) {
        return n == this.mc.f.entityId ? this.mc.f : this.level.getEntityByID(n);
    }

    @Override
    public void handleHealth(Packet8UpdateHealth packet8UpdateHealth) {
        if (this.mc.f != null) {
            this.mc.f.setHealth(packet8UpdateHealth.healthMP);
        }
    }

    @Override
    public void handleRespawn(Packet9Respawn packet9Respawn) {
        this.hasRespawned = false;
        this.mc.a(new C_ar(this));
        this.mc.respawn();
    }

    @Override
    public void handleExplosion(Packet60Explosion packet60Explosion) {
        C_m c_m = new C_m(this.mc.d, null, packet60Explosion.explosionX, packet60Explosion.explosionY, packet60Explosion.explosionZ, packet60Explosion.explosionSize);
        c_m.destroyedBlockPositions = packet60Explosion.destroyedBlockPositions;
        c_m.doExplosionB(true);
    }

    @Override
    public void handleOpenWindow(Packet100OpenWindow packet100OpenWindow) {
        if (packet100OpenWindow.inventoryType == 0) {
            C_q c_q = new C_q(packet100OpenWindow.windowTitle, packet100OpenWindow.slotsCount);
            this.mc.f.a(c_q);
            this.mc.f.craftingInventory.windowId = packet100OpenWindow.windowId;
        } else if (packet100OpenWindow.inventoryType == 2) {
            net.minecraft.a.a.b.a.C_b c_b = new net.minecraft.a.a.b.a.C_b();
            this.mc.f.a(c_b);
            this.mc.f.craftingInventory.windowId = packet100OpenWindow.windowId;
        } else if (packet100OpenWindow.inventoryType == 1) {
            net.minecraft.client.g.EntityPlayerSP c_a = this.mc.f;
            this.mc.f.displayWorkbenchGUI(MathHelper.a((double)c_a.h), MathHelper.a((double)c_a.i), MathHelper.a((double)c_a.j));
            this.mc.f.craftingInventory.windowId = packet100OpenWindow.windowId;
        } else if (packet100OpenWindow.inventoryType == 3) {
            C_q c_q = new C_q(packet100OpenWindow.windowTitle, packet100OpenWindow.slotsCount);
            this.mc.f.displayGUIBarrel(c_q, true);
            this.mc.f.craftingInventory.windowId = packet100OpenWindow.windowId;
        } else if (packet100OpenWindow.inventoryType == 4) {
            C_q c_q = new C_q(packet100OpenWindow.windowTitle, packet100OpenWindow.slotsCount);
            this.mc.f.displayGUIBookshelf(c_q);
            this.mc.f.craftingInventory.windowId = packet100OpenWindow.windowId;
        } else if (packet100OpenWindow.inventoryType == 5) {
            C_h c_h = new C_h();
            c_h.b = packet100OpenWindow.xPosition;
            c_h.c = packet100OpenWindow.yPosition;
            c_h.d = packet100OpenWindow.zPosition;
            c_h.active = packet100OpenWindow.state;
            this.mc.f.displayGUIGenerator(c_h);
            this.mc.f.craftingInventory.windowId = packet100OpenWindow.windowId;
        } else if (packet100OpenWindow.inventoryType == 6) {
            this.mc.f.displayGUIEnderChest(this.mc.f.inventoryChest);
            this.mc.f.craftingInventory.windowId = packet100OpenWindow.windowId;
        }
    }

    @Override
    public void handleSetSlot(Packet103SetSlot packet103SetSlot) {
        if (packet103SetSlot.windowId == -1) {
            this.mc.f.b.setItemStack(packet103SetSlot.myItemStack);
        } else if (packet103SetSlot.windowId == 0 && packet103SetSlot.itemSlot >= 41 && packet103SetSlot.itemSlot < 50) {
            ItemStack itemStack = this.mc.f.inventorySlots.getSlot(packet103SetSlot.itemSlot).getStack();
            if (packet103SetSlot.myItemStack != null && (itemStack == null || itemStack.a < packet103SetSlot.myItemStack.a)) {
                packet103SetSlot.myItemStack.b = 5;
            }
            this.mc.f.inventorySlots.putStackInSlot(packet103SetSlot.itemSlot, packet103SetSlot.myItemStack);
        } else if (packet103SetSlot.windowId == this.mc.f.craftingInventory.windowId) {
            this.mc.f.craftingInventory.putStackInSlot(packet103SetSlot.itemSlot, packet103SetSlot.myItemStack);
        }
        if (this.mc.o instanceof net.minecraft.client.c.a.C_m) {
            this.mc.o.refreshScreen();
        }
    }

    @Override
    public void handleTransaction(Packet106Transaction packet106Transaction) {
        net.minecraft.a.C_c c_c = null;
        if (packet106Transaction.windowId == 0) {
            c_c = this.mc.f.inventorySlots;
        } else if (packet106Transaction.windowId == this.mc.f.craftingInventory.windowId) {
            c_c = this.mc.f.craftingInventory;
        }
        if (c_c != null) {
            if (packet106Transaction.activate) {
                c_c.cancelTransaction(packet106Transaction.transactionID);
            } else {
                c_c.sendTransaction(packet106Transaction.transactionID);
                this.addToSendQueue(new Packet106Transaction(packet106Transaction.windowId, packet106Transaction.transactionID, true));
            }
        }
    }

    @Override
    public void handleWindowItems(Packet104WindowItems packet104WindowItems) {
        if (packet104WindowItems.windowId == 0) {
            this.mc.f.inventorySlots.putStacksInSlots(packet104WindowItems.itemStack);
        } else if (packet104WindowItems.windowId == this.mc.f.craftingInventory.windowId) {
            this.mc.f.craftingInventory.putStacksInSlots(packet104WindowItems.itemStack);
        }
    }

    @Override
    public void handleProgressBar(Packet105UpdateProgressbar packet105UpdateProgressbar) {
        this.registerPacket(packet105UpdateProgressbar);
        if (this.mc.f.craftingInventory != null && this.mc.f.craftingInventory.windowId == packet105UpdateProgressbar.windowId) {
            this.mc.f.craftingInventory.getProgressBar(packet105UpdateProgressbar.progressBar, packet105UpdateProgressbar.progressBarValue);
        }
    }

    @Override
    public void handlePlayerInventory(Packet5PlayerInventory packet5PlayerInventory) {
        Entity c_b = this.getEntityByID(packet5PlayerInventory.entityID);
        if (c_b != null) {
            c_b.outfitWithItem(packet5PlayerInventory.slot, packet5PlayerInventory.getItemSlot());
        }
        if (c_b instanceof net.minecraft.a.c.a.C_e) {
            ((net.minecraft.a.c.a.C_e)c_b).armorInventory[packet5PlayerInventory.slot] = packet5PlayerInventory.getItemSlot();
        }
    }

    @Override
    public void handleCloseWindow(Packet101CloseWindow packet101CloseWindow) {
        this.mc.f.closeScreen();
    }

    @Override
    public void handleLevelInit(Packet49LevelInit packet49LevelInit) {
        this.mc.a(new C_ar(this));
        this.levelBytes = null;
        this.levelMetaBytes = null;
    }

    @Override
    public void handleLevelData(Packet50LevelData packet50LevelData) {
        this.levelBytes = packet50LevelData.blocks;
    }

    public static String bytesToHex(byte[] byArray) {
        char[] cArray = new char[byArray.length * 2];
        for (int i = 0; i < byArray.length; ++i) {
            int n = byArray[i] & 0xFF;
            cArray[i * 2] = HEX_ARRAY[n >>> 4];
            cArray[i * 2 + 1] = HEX_ARRAY[n & 0xF];
        }
        return new String(cArray);
    }

    @Override
    public void handleLevelFinalized(Packet51LevelFinalized packet51LevelFinalized) {
        byte[] byArray;
        byte[] byArray2;
        if (this.levelBytes == null || this.levelMetaBytes == null) {
            this.disconnect();
            this.mc.a((World)null);
            this.mc.a(new C_ai("Internal client error", "Failed to load level! No data"));
            return;
        }
        System.out.println("Level size (compressed): " + this.levelBytes.length + ", received byte array is: " + this.levelBytes);
        System.out.println("Level meta size (compressed): " + this.levelMetaBytes.length + ", received meta array is: " + this.levelMetaBytes);
        try {
            byArray2 = net.minecraft.a.a.C_a.loadBlocks(new ByteArrayInputStream(this.levelBytes));
        }
        catch (Exception exception) {
            this.disconnect();
            this.mc.a((World)null);
            this.mc.a(new C_ai("Internal client error", "Failed to load level! Wrong data \n" + exception.toString()));
            exception.printStackTrace();
            return;
        }
        try {
            byArray = net.minecraft.a.a.C_a.loadBlocks(new ByteArrayInputStream(this.levelMetaBytes));
        }
        catch (Exception exception) {
            this.disconnect();
            this.mc.a((World)null);
            this.mc.a(new C_ai("Internal client error", "Failed to load level! Wrong metabytes\n" + exception.toString()));
            exception.printStackTrace();
            return;
        }
        this.levelBytes = null;
        this.levelMetaBytes = null;
        int n = packet51LevelFinalized.width;
        int n2 = packet51LevelFinalized.height;
        int n3 = packet51LevelFinalized.depth;
        this.level = new WorldClient(this.mc, this);
        new WorldClient(this.mc, this).multiplayerWorld = true;
        this.level.A = packet51LevelFinalized.skyBrightness;
        this.level.B = packet51LevelFinalized.skylightSubtracted;
        this.level.u = packet51LevelFinalized.cloudHeight;
        this.level.t = packet51LevelFinalized.groundLevel;
        this.level.s = packet51LevelFinalized.waterLevel;
        this.level.generate(n, n2, n3, byArray2, byArray, null, null);
        this.mc.a(this.level);
        this.mc.p.a("Lighting..");
        this.level.initLighting();
        for (C_l c_l : C_l.values()) {
            this.level.scheduleLightingUpdate(c_l, 0, 0, 0, this.level.a, this.level.c, this.level.b);
            int n4 = this.level.getLightingQueue();
            for (int i = 10000; this.level.updatingLighting() && i > 0; --i) {
                int n5 = this.level.getLightingQueue();
                if (n5 <= n4) continue;
                n4 = n5;
            }
        }
        this.mc.f.entityId = this.pvn;
        this.mc.a((GuiScreen)null);
    }

    @Override
    public void handlePlayerInfo(Packet201PlayerInfo packet201PlayerInfo) {
        GuiPlayerInfo guiPlayerInfo = this.playerInfoMap.get(packet201PlayerInfo.playerName);
        if (guiPlayerInfo == null && packet201PlayerInfo.isConnected) {
            guiPlayerInfo = new GuiPlayerInfo(packet201PlayerInfo.playerName, packet201PlayerInfo.score);
            this.playerInfoMap.put(packet201PlayerInfo.playerName, guiPlayerInfo);
            this.playerNames.add(guiPlayerInfo);
        }
        if (guiPlayerInfo != null && !packet201PlayerInfo.isConnected) {
            this.playerInfoMap.remove(packet201PlayerInfo.playerName);
            this.playerNames.remove(guiPlayerInfo);
        }
        if (packet201PlayerInfo.isConnected && guiPlayerInfo != null) {
            guiPlayerInfo.responseTime = packet201PlayerInfo.ping;
            guiPlayerInfo.score = packet201PlayerInfo.score;
            if (guiPlayerInfo.name.equals(this.mc.h.b)) {
                this.mc.f.P = guiPlayerInfo.score;
            }
        }
    }

    @Override
    public void handleLevelThemes(Packet251LevelThemes packet251LevelThemes) {
        if (this.level == null) {
            return;
        }
        this.level.v = packet251LevelThemes.skyColor;
        this.level.w = packet251LevelThemes.fogColor;
        this.level.x = packet251LevelThemes.cloudColor;
        this.level.m = packet251LevelThemes.defaultFluid;
        this.mc.updateBorderTexture(this.level);
        ((C_d)this.mc.f).canUpdate = true;
    }

    @Override
    public void handleLevelMetaData(Packet252LevelMetadata packet252LevelMetadata) {
        this.mc.p.a("Loading metadata...");
        this.levelMetaBytes = packet252LevelMetadata.metadata;
    }

    @Override
    public void handleServerName(Packet253ServerName packet253ServerName) {
        this.serverName = packet253ServerName.name;
        this.motd = packet253ServerName.motd;
        this.mc.t.addChatMessage(this.serverName);
        this.mc.t.addChatMessage(this.motd);
    }

    @Override
    public void handleReload(Packet254Reload packet254Reload) {
        this.addToSendQueue(new Packet2Handshake(this.mc.h.b));
    }

    @Override
    public void handleGamemode(Packet17Gamemode packet17Gamemode) {
        this.mc.a.b = packet17Gamemode.gamemode == 1;
        this.mc.d.z = !this.mc.a.b;
        this.mc.d.revival = packet17Gamemode.revive == 1;
        this.mc.f.operator = packet17Gamemode.op;
        this.mc.f.gamemode = packet17Gamemode.gamemode;
        this.mc.d.gamemode = packet17Gamemode.gamemode;
        this.mc.f.craftingInventory = new C_j(this.mc.f.b);
        this.mc.f.inventorySlots = new C_j(this.mc.f.b);
        if (this.mc.o instanceof net.minecraft.client.c.a.C_m) {
            ((net.minecraft.client.c.a.C_m)this.mc.o).f_();
        }
        if (this.mc.f.gamemode == 0) {
            this.mc.f.isFlying = false;
        }
    }

    @Override
    public void handleArmAnimation(Packet19Animation packet19Animation) {
        Entity c_b = this.getEntityByID(packet19Animation.entityId);
        if (c_b != null && packet19Animation.animate == 1) {
            EntityPlayer entityPlayer = (EntityPlayer)c_b;
            entityPlayer.swingItem();
        }
    }

    @Override
    public void handleKickDisconnect(Packet255KickDisconnect packet255KickDisconnect) {
        this.netManager.networkShutdown("Kicked");
        this.disconnected = true;
        this.mc.a(new C_ai("Disconnected by Server", packet255KickDisconnect.reason));
        this.mc.a((World)null);
    }

    @Override
    public void handleUpdateSign(Packet130UpdateSign packet130UpdateSign) {
        net.minecraft.a.a.b.a.C_l c_l;
        net.minecraft.a.a.b.a.TileEntity c_a = this.mc.d.j(packet130UpdateSign.x, packet130UpdateSign.y, packet130UpdateSign.z);
        if (c_a instanceof net.minecraft.a.a.b.a.C_l && (c_l = (net.minecraft.a.a.b.a.C_l)c_a).isEditable()) {
            for (int i = 0; i < 4; ++i) {
                c_l.signText[i] = packet130UpdateSign.lines[i];
            }
            c_l.onInventoryChanged();
        }
    }

    @Override
    public boolean isServerHandler() {
        return false;
    }

    @Override
    public void handleKeepAlive(Packet0KeepAlive packet0KeepAlive) {
        this.addToSendQueue(new Packet0KeepAlive(packet0KeepAlive.randomValue));
    }
}

