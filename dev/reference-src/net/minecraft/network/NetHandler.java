/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet100OpenWindow;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet102WindowClick;
import net.minecraft.network.packet.Packet103SetSlot;
import net.minecraft.network.packet.Packet104WindowItems;
import net.minecraft.network.packet.Packet105UpdateProgressbar;
import net.minecraft.network.packet.Packet106Transaction;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet130UpdateSign;
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

public abstract class NetHandler {
    public abstract boolean isServerHandler();

    public void registerPacket(Packet packet) {
    }

    public void handleErrorMessage(String string) {
    }

    public void handlePing(Packet192Ping packet192Ping) {
        this.registerPacket(packet192Ping);
    }

    public void handleKickDisconnect(Packet255KickDisconnect packet255KickDisconnect) {
        this.registerPacket(packet255KickDisconnect);
    }

    public void handleLogin(Packet1Login packet1Login) {
        this.registerPacket(packet1Login);
    }

    public void handleChat(Packet3Chat packet3Chat) {
        this.registerPacket(packet3Chat);
    }

    public void handleHandshake(Packet2Handshake packet2Handshake) {
        this.registerPacket(packet2Handshake);
    }

    public void handleUpdateTime(Packet4UpdateTime packet4UpdateTime) {
        this.registerPacket(packet4UpdateTime);
    }

    public void handleSpawnPosition(Packet6SpawnPosition packet6SpawnPosition) {
        this.registerPacket(packet6SpawnPosition);
    }

    public void handleUseEntity(Packet7UseEntity packet7UseEntity) {
        this.registerPacket(packet7UseEntity);
    }

    public void handleHealth(Packet8UpdateHealth packet8UpdateHealth) {
        this.registerPacket(packet8UpdateHealth);
    }

    public void handleRespawn(Packet9Respawn packet9Respawn) {
        this.registerPacket(packet9Respawn);
    }

    public void handleFlying(Packet10Flying packet10Flying) {
        this.registerPacket(packet10Flying);
    }

    public void handleBlockDig(Packet14BlockDig packet14BlockDig) {
        this.registerPacket(packet14BlockDig);
    }

    public void handlePlace(Packet15Place packet15Place) {
        this.registerPacket(packet15Place);
    }

    public void handleBlockItemSwitch(Packet16BlockItemSwitch packet16BlockItemSwitch) {
        this.registerPacket(packet16BlockItemSwitch);
    }

    public void handleGamemode(Packet17Gamemode packet17Gamemode) {
        this.registerPacket(packet17Gamemode);
    }

    public void handleNamedEntitySpawn(Packet20NamedEntitySpawn packet20NamedEntitySpawn) {
        this.registerPacket(packet20NamedEntitySpawn);
    }

    public void handlePickupSpawn(Packet21PickupSpawn packet21PickupSpawn) {
        this.registerPacket(packet21PickupSpawn);
    }

    public void handleCollect(Packet22Collect packet22Collect) {
        this.registerPacket(packet22Collect);
    }

    public void handleVehicleSpawn(Packet23VehicleSpawn packet23VehicleSpawn) {
        this.registerPacket(packet23VehicleSpawn);
    }

    public void handleMobSpawn(Packet24MobSpawn packet24MobSpawn) {
        this.registerPacket(packet24MobSpawn);
    }

    public void handlePlacePainting(Packet25EntityPainting packet25EntityPainting) {
        this.registerPacket(packet25EntityPainting);
    }

    public void handleVelocity(Packet28EntityVelocity packet28EntityVelocity) {
        this.registerPacket(packet28EntityVelocity);
    }

    public void handleDestroyEntity(Packet29DestroyEntity packet29DestroyEntity) {
        this.registerPacket(packet29DestroyEntity);
    }

    public void handleEntity(Packet30Entity packet30Entity) {
        this.registerPacket(packet30Entity);
    }

    public void handleEntityTeleport(Packet34EntityTeleport packet34EntityTeleport) {
        this.registerPacket(packet34EntityTeleport);
    }

    public void handleStatus(Packet38EntityStatus packet38EntityStatus) {
        this.registerPacket(packet38EntityStatus);
    }

    public void handleMetadata(Packet40EntityMetadata packet40EntityMetadata) {
        this.registerPacket(packet40EntityMetadata);
    }

    public void handleLevelInit(Packet49LevelInit packet49LevelInit) {
        this.registerPacket(packet49LevelInit);
    }

    public void handleLevelData(Packet50LevelData packet50LevelData) {
        this.registerPacket(packet50LevelData);
    }

    public void handleLevelFinalized(Packet51LevelFinalized packet51LevelFinalized) {
        this.registerPacket(packet51LevelFinalized);
    }

    public void handleMultiBlockChange(Packet52MultiBlockChange packet52MultiBlockChange) {
        this.registerPacket(packet52MultiBlockChange);
    }

    public void handleBlockChange(Packet53BlockChange packet53BlockChange) {
        this.registerPacket(packet53BlockChange);
    }

    public void handleExplosion(Packet60Explosion packet60Explosion) {
        this.registerPacket(packet60Explosion);
    }

    public void handleOpenWindow(Packet100OpenWindow packet100OpenWindow) {
        this.registerPacket(packet100OpenWindow);
    }

    public void handleCloseWindow(Packet101CloseWindow packet101CloseWindow) {
        this.registerPacket(packet101CloseWindow);
    }

    public void handleClick(Packet102WindowClick packet102WindowClick) {
        this.registerPacket(packet102WindowClick);
    }

    public void handleSetSlot(Packet103SetSlot packet103SetSlot) {
        this.registerPacket(packet103SetSlot);
    }

    public void handleWindowItems(Packet104WindowItems packet104WindowItems) {
        this.registerPacket(packet104WindowItems);
    }

    public void handleProgressBar(Packet105UpdateProgressbar packet105UpdateProgressbar) {
        this.registerPacket(packet105UpdateProgressbar);
    }

    public void handlePlayerInventory(Packet5PlayerInventory packet5PlayerInventory) {
        this.registerPacket(packet5PlayerInventory);
    }

    public void handleTransaction(Packet106Transaction packet106Transaction) {
        this.registerPacket(packet106Transaction);
    }

    public void handlePlayerInfo(Packet201PlayerInfo packet201PlayerInfo) {
        this.registerPacket(packet201PlayerInfo);
    }

    public void handleCreativeInventory(Packet202CreativeInventory packet202CreativeInventory) {
        this.registerPacket(packet202CreativeInventory);
    }

    public void handleLevelThemes(Packet251LevelThemes packet251LevelThemes) {
        this.registerPacket(packet251LevelThemes);
    }

    public void handleLevelMetaData(Packet252LevelMetadata packet252LevelMetadata) {
        this.registerPacket(packet252LevelMetadata);
    }

    public void handleServerName(Packet253ServerName packet253ServerName) {
        this.registerPacket(packet253ServerName);
    }

    public void handleReload(Packet254Reload packet254Reload) {
        this.registerPacket(packet254Reload);
    }

    public void handleUpdateSign(Packet130UpdateSign packet130UpdateSign) {
        this.registerPacket(packet130UpdateSign);
    }

    public void handleDoorChange(Packet61DoorChange packet61DoorChange) {
        this.registerPacket(packet61DoorChange);
    }

    public void handleWeather(Packet71Weather packet71Weather) {
        this.registerPacket(packet71Weather);
    }

    public void handleUpdateSeason(Packet41UpdateSeason packet41UpdateSeason) {
        this.registerPacket(packet41UpdateSeason);
    }

    public void handleSpawnPositionLocal(Packet18SpawnPos packet18SpawnPos) {
        this.registerPacket(packet18SpawnPos);
    }

    public void handleNotePlay(Packet54PlayNoteBlock packet54PlayNoteBlock) {
        this.registerPacket(packet54PlayNoteBlock);
    }

    public void handlePlayRecord(Packet55PlayRecord packet55PlayRecord) {
        this.registerPacket(packet55PlayRecord);
    }

    public void handleGenerator(Packet91ActivateGenerator packet91ActivateGenerator) {
        this.registerPacket(packet91ActivateGenerator);
    }

    public void handleRide(Packet39AttachEntity packet39AttachEntity) {
        this.registerPacket(packet39AttachEntity);
    }

    public void handleCustomPayload(Packet250CustomPayload packet250CustomPayload) {
        this.registerPacket(packet250CustomPayload);
    }

    public void handleArmAnimation(Packet19Animation packet19Animation) {
        this.registerPacket(packet19Animation);
    }

    public void handlePlayerState(Packet26PlayerState packet26PlayerState) {
        this.registerPacket(packet26PlayerState);
    }

    public void handleUseItem(Packet27UseCharm packet27UseCharm) {
        this.registerPacket(packet27UseCharm);
    }

    public void handleKeepAlive(Packet0KeepAlive packet0KeepAlive) {
        this.registerPacket(packet0KeepAlive);
    }
}

