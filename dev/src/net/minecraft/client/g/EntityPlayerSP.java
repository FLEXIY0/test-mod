/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package net.minecraft.client.g;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import java.io.File;
import java.util.HashMap;
import net.minecraft.a.C_m;
import net.minecraft.a.a.World;
import net.minecraft.a.a.LevelOptions;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.C_h;
import net.minecraft.a.b.C_bm;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.C_l;
import net.minecraft.client.c.C_z;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.c.GuiScreenBook;
import net.minecraft.client.c.a.C_c;
import net.minecraft.client.c.a.C_i;
import net.minecraft.client.c.a.C_k;
import net.minecraft.client.c.a.C_o;
import net.minecraft.client.d;
import net.minecraft.client.f.C_n;
import net.minecraft.client.g.C_b;
import net.minecraft.client.g.C_e;
import net.minecraft.client.statistics.Achievement;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatBase;
import net.minecraft.client.statistics.StatList;
import org.lwjgl.input.Keyboard;
import util.MathHelper;

public class EntityPlayerSP
extends EntityPlayer {
    public C_b a;
    protected d an;
    public float prevRenderArmYaw;
    public float renderArmYaw;
    public float prevRenderArmPitch;
    public float renderArmPitch;
    private LevelOptions worldOptions = new LevelOptions();
    public float timeInPortal;
    public float prevTimeInPortal;
    private static HashMap<Integer, String> subtype = new C_e();

    public EntityPlayerSP(d d2, World c_g, C_l c_l) {
        super(c_g);
        this.an = d2;
        if (c_l != null) {
            this.N = "http://betacraft.uk/skin/" + c_l.b + ".png";
            this.name = c_l.b;
        }
    }

    public EntityPlayerSP(d d2, World c_g, C_l c_l, boolean bl, boolean bl2, String string, String string2, int n, int n2, int n3) {
        super(c_g);
        this.an = d2;
        this.cheats = bl;
        this.keepInventory = bl2;
        this.name = string;
        this.skinId = string2;
        this.difficulty = n;
        this.P = n2;
        this.gamemode = n3;
        if (c_l != null) {
            this.N = "http://betacraft.uk/skin/" + c_l.b + ".png";
        }
    }

    @Override
    public void e() {
        super.e();
        if (this.isSitting || this.isLaying || this.an.cameraMob != this) {
            this.aj = 0.0f;
            this.ak = 0.0f;
            this.isJumping = false;
        } else {
            this.aj = this.a.a;
            this.ak = this.a.b;
        }
        if (this.isUsingItem()) {
            this.aj *= 0.2f;
            this.ak *= 0.2f;
        }
        this.isJumping = this.an.f.canSneakHere() || this.an.f.m() ? this.a.c : false;
        if (this.isFlying && this.isJumping && this.an.o == null && this.an.cameraMob == this) {
            this.l += 0.3f;
        }
        if (this.isFlying && Keyboard.isKeyDown((int)this.an.w.keyBindSneak.b) && this.an.o == null && this.an.cameraMob == this) {
            this.l -= 0.3f;
        }
        if (this.an.w.sneakMode) {
            this.updateSneakState();
        }
        if (this.isLaying && this.an.w.thirdPersonView == 0) {
            this.v = 1.0f;
        }
        this.prevTimeInPortal = this.timeInPortal;
        if (this.isInsideOfMaterial(net.minecraft.a.a.d.Material.portal)) {
            if (!this.d.multiplayerWorld && this.ridingEntity != null) {
                this.mountEntity(null);
            }
            if (this.an.o != null) {
                this.an.a((GuiScreen)null);
            }
            this.timeInPortal += 0.0125f;
            if (this.timeInPortal >= 1.0f) {
                this.timeInPortal = 1.0f;
                if (!this.d.multiplayerWorld) {
                    this.an.x.a("portal.travel", 1.0f, this.G.nextFloat() * 0.4f + 0.8f);
                    byte by = this.d.e(MathHelper.d(this.h), MathHelper.d(this.i), MathHelper.d(this.j));
                    this.changeWorld(by);
                }
            }
        } else {
            if (this.timeInPortal > 0.0f) {
                this.timeInPortal -= 0.05f;
            }
            if (this.timeInPortal < 0.0f) {
                this.timeInPortal = 0.0f;
            }
        }
        this.prevRenderArmPitch = this.renderArmPitch;
        this.prevRenderArmYaw = this.renderArmYaw;
        this.renderArmPitch = (float)((double)this.renderArmPitch + (double)(this.o - this.renderArmPitch) * 0.5);
        this.renderArmYaw = (float)((double)this.renderArmYaw + (double)(this.n - this.renderArmYaw) * 0.5);
    }

    private void changeWorld(int n) {
        String string = subtype.get(n);
        if (this.d.fileName.equals(string)) {
            n = 11;
        }
        if (n == 11 && this.d.f.equals(this.d.parentName)) {
            return;
        }
        this.an.x.a("random.portal", 1.0f, 1.0f);
        File file = new File(this.an.z, "saves/" + this.d.parentName + "/");
        if (n == 11) {
            string = this.d.parentName + ".mclevel";
            file = new File(this.an.z, "saves/");
        }
        if (!file.exists()) {
            file.mkdir();
        }
        File[] fileArray = file.listFiles();
        boolean bl = false;
        NBTTagCompound nBTTagCompound = null;
        this.an.saveCharacter();
        nBTTagCompound = this.an.characters.currentCharacter;
        int n2 = 0;
        for (File file2 : fileArray) {
            ++n2;
            if (!file2.getName().equals(string)) continue;
            if (n == 11) {
                this.an.loadLevel(file2.getName());
            } else {
                this.an.loadLevel(file2.getName(), this.d.parentName);
            }
            bl = true;
        }
        if (!bl) {
            this.generateSubWorld(string, n);
        }
        if (n2 >= 15) {
            this.an.f.triggerAchievement(AchievementList.adventure);
        }
        this.an.a((GuiScreen)null);
        this.an.f.readFromNBTWithoutPos(nBTTagCompound);
    }

    private void generateSubWorld(String string, int n) {
        switch (n) {
            case 0: {
                this.worldOptions.type = this.d.type;
                this.worldOptions.theme = 1;
                break;
            }
            case 1: {
                this.worldOptions.type = 3;
                this.worldOptions.theme = this.d.theme;
                break;
            }
            case 2: {
                this.worldOptions.type = 4;
                this.worldOptions.theme = this.d.theme;
                break;
            }
            case 3: {
                this.worldOptions.type = 0;
                this.worldOptions.theme = this.d.theme;
                break;
            }
            case 4: {
                this.worldOptions.type = this.d.type;
                this.worldOptions.theme = 3;
                break;
            }
            case 5: {
                this.worldOptions.type = 9;
                this.worldOptions.theme = this.d.theme;
                break;
            }
            case 6: {
                this.worldOptions.type = 2;
                this.worldOptions.theme = this.d.theme;
                break;
            }
            case 7: {
                this.worldOptions.type = 1;
                this.worldOptions.theme = this.d.theme;
                break;
            }
            case 8: {
                this.worldOptions.type = 7;
                this.worldOptions.theme = this.d.theme;
                break;
            }
            case 9: {
                this.worldOptions.type = this.d.type;
                this.worldOptions.theme = 0;
                break;
            }
            case 10: {
                this.worldOptions.type = this.d.type;
                this.worldOptions.theme = 4;
                break;
            }
            case 12: {
                this.worldOptions.type = this.d.type;
                this.worldOptions.theme = 2;
                break;
            }
            case 13: {
                this.worldOptions.type = 5;
                this.worldOptions.theme = this.d.theme;
                break;
            }
            case 14: {
                this.worldOptions.type = 6;
                this.worldOptions.theme = this.d.theme;
                break;
            }
            case 15: {
                this.worldOptions.type = 8;
                this.worldOptions.theme = this.d.theme;
                break;
            }
            default: {
                this.worldOptions.type = this.d.type;
                this.worldOptions.theme = n;
            }
        }
        this.worldOptions.seed = "" + this.d.seed;
        this.worldOptions.seasonLock = this.d.season.seasonsDisabled;
        this.worldOptions.seasons = this.d.season.currentSeason;
        this.worldOptions.width = this.d.a;
        this.worldOptions.height = this.d.c;
        this.worldOptions.length = this.d.b;
        this.worldOptions.house = n + 3;
        this.an.generateLevelSubtype(this.worldOptions, string, this.d.parentName);
    }

    @Override
    public void spawnCritParticles(net.minecraft.a.c.Entity c_b) {
        this.an.g.a(new C_n(this.an.d, c_b));
    }

    protected void updateSneakState() {
        if (Keyboard.isKeyDown((int)this.an.w.keyBindSneak.b) && this.isSneaking != 2 && this.s && !this.isInWater() && !this.isSitting && !this.isLaying && this.an.o == null) {
            this.isSneaking = 1;
            this.v = 1.42f;
        } else if (this.isSneaking != 2 && !this.isInWater() && !this.isSitting) {
            this.isSneaking = 0;
            this.v = 1.62f;
        }
    }

    @Override
    public void f() {
        if (!this.an.statFileWriter.hasAchievementUnlocked(AchievementList.openInventory)) {
            this.triggerAchievement(AchievementList.openInventory);
        }
        this.a.a();
        super.f();
    }

    @Override
    public void resetPlayerKeyState() {
        this.a.b();
    }

    @Override
    public void chatMessage(String string) {
        this.an.t.addChatMessage(string);
    }

    @Override
    public void sendMessage(String string) {
        if (string.startsWith("/") && this.an.f.cheats && !this.an.d.multiplayerWorld) {
            C_z.executeCommand(this.an, string);
        } else {
            this.chatMessage("<" + this.name + "> " + string);
        }
    }

    @Override
    protected void a(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2;
        int n;
        super.a(nBTTagCompound);
        nBTTagCompound.a("Score", this.P);
        nBTTagCompound.a("Skin", this.skinId);
        net.minecraft.a.c.e.InventoryPlayer c_b = this.b;
        C_m c_m = this.inventoryChest;
        NBTTagList nBTTagList = new NBTTagList();
        NBTTagList nBTTagList2 = new NBTTagList();
        net.minecraft.a.c.e.InventoryPlayer c_b2 = c_b;
        for (n = 0; n < c_b2.a.length; ++n) {
            if (c_b2.a[n] == null) continue;
            nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)n);
            c_b2.a[n].a(nBTTagCompound2);
            nBTTagList.a(nBTTagCompound2);
        }
        for (n = 0; n < c_b2.b.length; ++n) {
            if (c_b2.b[n] == null) continue;
            nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)(n + 100));
            c_b2.b[n].a(nBTTagCompound2);
            nBTTagList.a(nBTTagCompound2);
        }
        for (n = 0; n < c_b2.quiverInventory.length; ++n) {
            if (c_b2.quiverInventory[n] == null) continue;
            nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)(n + 200));
            c_b2.quiverInventory[n].a(nBTTagCompound2);
            nBTTagList.a(nBTTagCompound2);
        }
        for (n = 0; n < c_b2.charmSlot.length; ++n) {
            if (c_b2.charmSlot[n] == null) continue;
            nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)(n + 205));
            c_b2.charmSlot[n].a(nBTTagCompound2);
            nBTTagList.a(nBTTagCompound2);
        }
        nBTTagCompound.a("Inventory", nBTTagList);
        for (int i = 0; i < c_m.mainInventory.length; ++i) {
            if (c_m.mainInventory[i] == null) continue;
            NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
            nBTTagCompound3.a("Slot", (byte)i);
            c_m.mainInventory[i].a(nBTTagCompound3);
            nBTTagList2.a(nBTTagCompound3);
        }
        nBTTagCompound.a("InventoryChest", nBTTagList2);
    }

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        int n;
        NBTTagCompound nBTTagCompound2;
        int n2;
        super.b(nBTTagCompound);
        this.P = nBTTagCompound.d("Score");
        this.skinId = nBTTagCompound.g("Skin");
        NBTTagList nBTTagList = nBTTagCompound.j("Inventory");
        NBTTagList nBTTagList2 = nBTTagCompound.j("InventoryChest");
        NBTTagList nBTTagList3 = nBTTagList;
        net.minecraft.a.c.e.InventoryPlayer c_b = this.b;
        C_m c_m = this.inventoryChest;
        c_m.mainInventory = new ItemStack[27];
        c_b.a = new ItemStack[36];
        c_b.b = new ItemStack[4];
        c_b.quiverInventory = new ItemStack[3];
        c_b.charmSlot = new ItemStack[1];
        for (n2 = 0; n2 < nBTTagList3.b(); ++n2) {
            nBTTagCompound2 = (NBTTagCompound)nBTTagList3.a(n2);
            n = nBTTagCompound2.b("Slot") & 0xFF;
            if (n >= 0 && n < c_b.a.length) {
                c_b.a[n] = new ItemStack(nBTTagCompound2);
                c_b.a[n].readFromNBT(nBTTagCompound2);
            }
            if (n >= 100 && n < c_b.b.length + 100) {
                c_b.b[n - 100] = new ItemStack(nBTTagCompound2);
            }
            if (n >= 200 && n < c_b.quiverInventory.length + 200) {
                c_b.quiverInventory[n - 200] = new ItemStack(nBTTagCompound2);
            }
            if (n < 205 || n >= c_b.charmSlot.length + 205) continue;
            c_b.charmSlot[n - 205] = new ItemStack(nBTTagCompound2);
        }
        for (n2 = 0; n2 < nBTTagList2.b(); ++n2) {
            nBTTagCompound2 = (NBTTagCompound)nBTTagList2.a(n2);
            n = nBTTagCompound2.b("Slot") & 0xFF;
            if (n < 0 || n >= c_m.mainInventory.length) continue;
            c_m.mainInventory[n] = new ItemStack(nBTTagCompound2);
            c_m.mainInventory[n].readFromNBT(nBTTagCompound2);
        }
        this.b(this.h, this.i + 0.1f, this.j);
        if (this.isSneaking == 2) {
            this.v = 0.56f;
        }
    }

    public void readEntityWithoutInv(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        this.P = nBTTagCompound.d("Score");
        this.skinId = nBTTagCompound.g("Skin");
    }

    @Override
    public void addStat(StatBase statBase, int n) {
        if (statBase != null) {
            if (statBase.isAchievement()) {
                Achievement achievement = (Achievement)statBase;
                if (achievement.parentAchievement == null || this.an.statFileWriter.hasAchievementUnlocked(achievement.parentAchievement)) {
                    if (!this.an.statFileWriter.hasAchievementUnlocked(achievement)) {
                        this.an.guiAchievement.queueTakenAchievement(achievement);
                    }
                    this.an.statFileWriter.writeStat(statBase, n);
                }
            } else {
                this.an.statFileWriter.writeStat(statBase, n);
            }
        }
    }

    @Override
    public String a() {
        return "LocalPlayer";
    }

    @Override
    public void a(net.minecraft.a.C_b c_b) {
        this.an.a(new C_i(this.b, c_b, false));
        c_b.openInventory();
        this.addStat(StatList.chestUse, 1);
    }

    @Override
    public void displayGUIBarrel(net.minecraft.a.C_b c_b, boolean bl) {
        this.an.a(new C_k(this.b, c_b, bl));
        c_b.openInventory();
        this.addStat(StatList.barrelUse, 1);
    }

    @Override
    public void displayWorkbenchGUI(int n, int n2, int n3) {
        this.an.a(new net.minecraft.client.c.a.C_b(this.b, this.d, n, n2, n3));
        this.addStat(StatList.benchUse, 1);
    }

    @Override
    public void a(net.minecraft.a.a.b.a.C_b c_b) {
        this.an.a(new C_c(this.b, c_b));
        this.addStat(StatList.furnaceUse, 1);
    }

    @Override
    public void displayGUIEditSign(net.minecraft.a.a.b.a.C_l c_l) {
        this.an.a(new net.minecraft.client.c.a.C_n(c_l));
        this.addStat(StatList.signUse, 1);
    }

    @Override
    public void displayGUIEnderChest(net.minecraft.a.C_b c_b) {
        this.an.a(new C_i(this.b, c_b, true));
        this.addStat(StatList.endChestUse, 1);
    }

    @Override
    public void displayGUIGenerator(C_h c_h) {
        this.an.a(new C_o(this.b, c_h));
        this.addStat(StatList.generatorUse, 1);
    }

    @Override
    public void displayGUIBook(ItemStack itemStack) {
        Item item = itemStack.a();
        if (item == Item.writtenBook) {
            this.an.a(new GuiScreenBook(this, itemStack, false));
        } else if (item == Item.bookAndQuill) {
            this.an.a(new GuiScreenBook(this, itemStack, true));
        } else if (item == Item.obsidianBookAndQuill) {
            this.an.a(new net.minecraft.client.c.GuiScreenObsidianBook(this, itemStack, true));
        }
    }

    @Override
    public void displayGUIBookshelf(net.minecraft.a.C_b c_b) {
        this.an.a(new net.minecraft.client.c.a.C_l(this.b, c_b));
        this.addStat(StatList.shelfUse, 1);
    }

    @Override
    public void h_() {
        this.b.a(this.b.c, null);
    }

    @Override
    public void a(net.minecraft.a.c.Entity c_b) {
        this.an.g.a(new net.minecraft.client.f.C_e(this.an.d, c_b, this, -0.5f));
    }

    @Override
    public void closeScreen() {
        super.closeScreen();
        this.an.a((GuiScreen)null);
    }

    public net.minecraft.a.d.C_a getLook(float f) {
        if (f == 1.0f) {
            float f2 = MathHelper.b(-this.n * ((float)Math.PI / 180) - (float)Math.PI);
            float f3 = MathHelper.a(-this.n * ((float)Math.PI / 180) - (float)Math.PI);
            float f4 = -MathHelper.b(-this.o * ((float)Math.PI / 180));
            float f5 = MathHelper.a(-this.o * ((float)Math.PI / 180));
            return new net.minecraft.a.d.C_a(f3 * f4, f5, f2 * f4);
        }
        float f6 = this.q + (this.o - this.q) * f;
        float f7 = this.p + (this.n - this.p) * f;
        float f8 = MathHelper.b(-f7 * ((float)Math.PI / 180) - (float)Math.PI);
        float f9 = MathHelper.a(-f7 * ((float)Math.PI / 180) - (float)Math.PI);
        float f10 = -MathHelper.b(-f6 * ((float)Math.PI / 180));
        float f11 = MathHelper.a(-f6 * ((float)Math.PI / 180));
        return new net.minecraft.a.d.C_a(f9 * f10, f11, f8 * f10);
    }

    public void setHealth(int n) {
        int n2 = this.W - n;
        if (n2 <= 0) {
            this.W = n;
            if (n2 < 0) {
                this.L = this.S / 2;
            }
        } else {
            this.X = this.W;
            this.L = this.S;
            this.W -= n2;
            this.Z = 10;
            this.Y = 10;
        }
    }

    public boolean canHarvestBlock(Block c_x) {
        return this.canHarvestBlock(c_x, (byte)0);
    }

    @Override
    public void doRespawn() {
        this.P /= 2;
        this.an.respawn();
    }

    public float getFOVMultiplier() {
        float f = 1.0f;
        if (this.isFlying) {
            f *= 1.1f;
        }
        if (this.isUsingItem() && (this.getItemInUse().c == Item.g.ap || this.getItemInUse().a() instanceof C_bm)) {
            int n = this.getItemInUseDuration();
            float f2 = (float)n / 20.0f;
            f2 = f2 > 1.0f ? 1.0f : (f2 *= f2);
            f *= 1.0f - f2 * 0.15f;
        }
        return f;
    }
}

