/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a;

import com.a.a.NBTTagCompound;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;
import net.minecraft.a.a.C_d;
import net.minecraft.a.a.C_e;
import net.minecraft.a.a.C_i;
import net.minecraft.a.a.C_j;
import net.minecraft.a.a.C_l;
import net.minecraft.a.a.C_n;
import net.minecraft.a.a.C_p;
import net.minecraft.a.a.a.C_c;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.c.C_f;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.d;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.container.BlockContainer;
import util.MathHelper;

public class World {
    private static float[] F = new float[16];
    public int a;
    public int b;
    public int c;
    public byte[] d;
    public byte[] e;
    public String f;
    public String g;
    public long h;
    public long seed;
    public int i;
    public int j;
    public int k;
    public float l;
    public int m;
    public int defaultBlock;
    public List<C_d> n;
    private List<C_e> G;
    public Map<Object, TileEntity> o;
    public List<TileEntity> H;
    int[] p;
    public Random q;
    public Random I;
    private int J;
    public C_i r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    private int K;
    public net.minecraft.a.c.EntityLiving y;
    public boolean z;
    public int A;
    public int B;
    public C_c C;
    public C_n season;
    public int D;
    private static short N;
    private short[] O;
    private int[] P;
    private int[] Q;
    public int E;
    public int gamemode;
    private float[] colorsSunriseSunset;
    public int daysPassed;
    public int theme;
    public int type;
    private boolean tileEntityFlag;
    public boolean multiplayerWorld;
    public boolean cantGrow;
    protected boolean bloodMoon;
    public boolean isNight;
    public boolean physicsDisabled;
    public boolean AIDisabled;
    public boolean cheats;
    public boolean hardcore;
    public ArrayList<net.minecraft.a.d.C_b> collidingBoxes;
    public d mc;
    public int bloodMoonChance;
    protected float prevRainingStrength;
    protected float rainingStrength;
    protected float prevThunderingStrength;
    protected float thunderingStrength;
    protected boolean raining;
    protected int rainTime;
    protected boolean thundering;
    protected int thunderTime;
    protected int weatherUpdates;
    public int lightStrike;
    protected float windForce;
    protected byte windDirection;
    protected int windTime;
    protected float fogDistance;
    protected int fogTime;
    protected int fogDensity;
    public String fileName;
    protected int soundCounter;
    public boolean freezeWeatherUpdates;
    public List<EntityPlayer> playerEntities;
    public List<Entity> loadedEntityList;
    public C_j chunkMap;
    private List<Entity> unloadedEntityList;
    public boolean revival;
    private static int lightingUpdatesScheduled;
    private List<net.minecraft.a.a.C_c> lightingToUpdate;
    public byte[] light;
    private int minHeight;
    private int lightingUpdatesCounter;
    public boolean child;
    public boolean active;
    public String parentName;
    public static HashMap<Integer, Integer> seasonColor;

    public World() {
        this.m = Block.p.at;
        this.defaultBlock = Block.j.at;
        this.n = new ArrayList<C_d>();
        this.G = new LinkedList<C_e>();
        this.o = new HashMap<Object, TileEntity>();
        this.H = new ArrayList<TileEntity>();
        this.q = new Random();
        this.I = new Random();
        this.J = this.q.nextInt();
        this.v = 0x99CCFF;
        this.w = 0xFFFFFF;
        this.x = 0xFFFFFF;
        this.K = 0;
        this.z = true;
        this.A = 15;
        this.B = 15;
        this.C = new C_c(this);
        this.season = new C_n();
        this.D = 650;
        this.O = new short[0x100000];
        this.P = new int[0x100000];
        this.Q = new int[0x100000];
        this.E = 2;
        this.gamemode = 0;
        this.colorsSunriseSunset = new float[4];
        this.theme = 0;
        this.type = 0;
        this.multiplayerWorld = false;
        this.isNight = false;
        this.physicsDisabled = false;
        this.AIDisabled = false;
        this.cheats = false;
        this.hardcore = false;
        this.collidingBoxes = new ArrayList();
        this.fogDistance = 512.0f;
        this.freezeWeatherUpdates = false;
        this.playerEntities = new ArrayList<EntityPlayer>();
        this.loadedEntityList = new ArrayList<Entity>();
        this.chunkMap = new C_j();
        this.unloadedEntityList = new ArrayList<Entity>();
        this.revival = true;
        this.lightingToUpdate = new ArrayList<net.minecraft.a.a.C_c>();
        this.child = false;
        this.active = false;
        this.parentName = "";
    }

    public void a() {
        if (this.d == null) {
            throw new RuntimeException("The level is corrupt!");
        }
        this.n = new ArrayList<C_d>();
        this.q = new Random();
        this.J = this.q.nextInt();
        this.soundCounter = this.I.nextInt(12000);
        this.G = new ArrayList<C_e>();
        if (this.r == null) {
            this.r = new C_i(this.a, this.c, this.b);
        }
        this.updateWeatherStatus();
    }

    public void setPartialData(int n, int n2, int n3, byte[] byArray, byte[] byArray2, byte[] byArray3, int[] nArray) {
        if (byArray2 != null && byArray2.length == 0) {
            byArray2 = null;
        }
        if (byArray3 != null && byArray3.length == 0) {
            byArray3 = null;
        }
        if (nArray != null && nArray.length == 0) {
            nArray = null;
        }
        this.a = n;
        this.b = n3;
        this.c = n2;
        this.d = byArray;
        this.light = new byte[byArray.length];
        for (n2 = 0; n2 < this.a; ++n2) {
            for (int i = 0; i < this.b; ++i) {
                for (int j = 0; j < this.c; ++j) {
                    int n4 = 0;
                    if (this.type != 8) {
                        if (j <= 1 && j < this.t - 1 && byArray[((j + 1) * this.b + i) * this.a + n2] == 0 && this.type == 5) {
                            n4 = Block.s.at;
                        } else if (j < this.t - 1) {
                            n4 = Block.o.at;
                        } else if (j < this.t) {
                            n4 = this.t > this.s && this.m == Block.p.at ? (this.theme == 4 ? Block.mycelium.at : this.defaultBlock) : (this.type == 4 ? Block.redSand.at : (this.theme == 4 ? Block.mycelium.at : Block.k.at));
                        } else if (j < this.s) {
                            n4 = this.m;
                        }
                    }
                    byArray[(j * this.b + i) * this.a + n2] = (byte)n4;
                    if (j != 1 || n2 == 0 || i == 0 || n2 == this.a - 1 || i == this.b - 1) continue;
                    j = this.c - 2;
                }
            }
        }
        this.p = new int[n * n3];
        Arrays.fill(this.p, this.c);
        this.e = byArray2 == null ? new byte[byArray.length] : byArray2;
        this.light = byArray3 == null ? new byte[byArray.length] : byArray3;
        if (nArray == null) {
            this.p = new int[n * n3];
            Arrays.fill(this.p, this.c);
            this.initLighting();
        } else {
            this.p = nArray;
        }
        if (byArray3 != null) {
            this.lightingToUpdate.clear();
        }
        for (n2 = 0; n2 < this.n.size(); ++n2) {
            this.n.get(n2).a();
        }
        this.G.clear();
        this.b();
        this.a();
        System.gc();
    }

    public void generate(int n, int n2, int n3, byte[] byArray, byte[] byArray2, byte[] byArray3, int[] nArray) {
        if (byArray2 != null && byArray2.length == 0) {
            byArray2 = null;
        }
        if (byArray3 != null && byArray3.length == 0) {
            byArray3 = null;
        }
        if (nArray != null && nArray.length == 0) {
            nArray = null;
        }
        this.a = n;
        this.b = n3;
        this.c = n2;
        this.d = byArray;
        this.light = new byte[byArray.length];
        for (n2 = 0; n2 < this.a; ++n2) {
            for (int i = 0; i < this.b; ++i) {
                for (int j = 0; j < this.c; ++j) {
                    int n4 = 0;
                    if (this.type != 8) {
                        if (j <= 1 && j < this.t - 1 && byArray[((j + 1) * this.b + i) * this.a + n2] == 0) {
                            n4 = Block.s.at;
                        } else if (j < this.t - 1) {
                            n4 = Block.o.at;
                        } else if (j < this.t) {
                            n4 = this.t > this.s && this.m == Block.p.at ? (this.theme == 4 ? Block.mycelium.at : this.defaultBlock) : (this.type == 4 ? Block.redSand.at : Block.k.at);
                        } else if (j < this.s) {
                            n4 = this.m;
                        }
                    }
                    byArray[(j * this.b + i) * this.a + n2] = (byte)n4;
                    if (j != 1 || n2 == 0 || i == 0 || n2 == this.a - 1 || i == this.b - 1) continue;
                    j = this.c - 2;
                }
            }
        }
        this.p = new int[n * n3];
        Arrays.fill(this.p, this.c);
        this.e = byArray2 == null ? new byte[byArray.length] : byArray2;
        this.light = byArray3 == null ? new byte[byArray.length] : byArray3;
        if (nArray == null) {
            this.p = new int[n * n3];
            Arrays.fill(this.p, this.c);
            this.initLighting();
        } else {
            this.p = nArray;
        }
        if (byArray3 != null) {
            this.lightingToUpdate.clear();
        }
        for (n2 = 0; n2 < this.n.size(); ++n2) {
            this.n.get(n2).a();
        }
        this.G.clear();
        this.b();
        this.a();
        System.gc();
    }

    public int calculateSkylightSubtracted(float f) {
        float f2 = this.c(f);
        float f3 = 1.0f - (MathHelper.b(f2 * (float)Math.PI * 2.0f) * 2.0f + 0.5f);
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        f3 = 1.0f - f3;
        f3 = (float)((double)f3 * (1.0 - (double)(this.getRainStatus(f) * 5.0f) / 16.0));
        f3 = (float)((double)f3 * (1.0 - (double)(this.getThunderStatus(f) * 5.0f) / 16.0));
        f3 = 1.0f - f3;
        return (int)(f3 * 11.0f);
    }

    public void b() {
        int n;
        int n2;
        int n3;
        Random random = new Random();
        int n4 = 0;
        block0: while (true) {
            int n5;
            int n6;
            int n7;
            ++n4;
            n3 = random.nextInt(this.a / 2) + this.a / 4;
            n2 = random.nextInt(this.b / 2) + this.b / 4;
            n = this.a(n3, n2) + 1;
            if (this.type == 5) {
                n = this.getLastUncoveredBlock(n3, n2) + 1;
            }
            if (n4 == 1000000) {
                this.i = n3;
                this.j = n + 3;
                this.k = n2;
                this.l = 180.0f;
                return;
            }
            if (n < 4 || n <= this.s) continue;
            for (n7 = n3 - 3; n7 <= n3 + 3; ++n7) {
                for (n6 = n - 1; n6 <= n + 2; ++n6) {
                    for (n5 = n2 - 3 - 2; n5 <= n2 + 3; ++n5) {
                        if (this.f(n7, n6, n5).a()) continue block0;
                    }
                }
            }
            n7 = n - 2;
            for (n6 = n3 - 3; n6 <= n3 + 3; ++n6) {
                for (n5 = n2 - 3 - 2; n5 <= n2 + 3; ++n5) {
                    if (Block.e[this.a(n6, n7, n5)]) continue;
                    continue block0;
                }
            }
            break;
        }
        this.i = n3;
        this.j = n;
        this.k = n2;
        this.l = 180.0f;
    }

    public void a(C_d c_d) {
        for (int i = 0; i < this.r.e.size(); ++i) {
            c_d.a(this.r.e.get(i));
        }
        this.n.add(c_d);
    }

    public void b(C_d c_d) {
        this.n.remove(c_d);
    }

    public List<net.minecraft.a.d.C_b> getCollidingBoundingBoxes(Entity c_b, net.minecraft.a.d.C_b c_b2) {
        this.collidingBoxes.clear();
        int n = MathHelper.a((double)c_b2.a);
        int n2 = MathHelper.a((double)c_b2.d + 1.0);
        int n3 = MathHelper.a((double)c_b2.b);
        int n4 = MathHelper.a((double)c_b2.e + 1.0);
        int n5 = MathHelper.a((double)c_b2.c);
        int n6 = MathHelper.a((double)c_b2.f + 1.0);
        if (c_b2.a < 0.0f) {
            --n;
        }
        if (c_b2.b < 0.0f) {
            --n3;
        }
        if (c_b2.c < 0.0f) {
            --n5;
        }
        for (int i = n; i < n2; ++i) {
            for (int j = n5; j < n6; ++j) {
                for (int k = n3 - 1; k < n4; ++k) {
                    Block c_x = Block.c[this.a(i, k, j)];
                    if (c_x == null) continue;
                    c_x.getCollidingBoundingBoxes(this, i, k, j, c_b2, this.collidingBoxes);
                    net.minecraft.a.d.C_b c_b3 = c_x.getCollisionBoundingBoxFromPool(this, i, k, j);
                    if (c_b3 == null || !c_b2.a(c_b3)) continue;
                    this.collidingBoxes.add(c_b3);
                }
            }
        }
        return this.collidingBoxes;
    }

    public int countBlocks(net.minecraft.a.d.C_b c_b, int n) {
        int n2 = 0;
        int n3 = (int)c_b.a;
        int n4 = (int)c_b.d + 1;
        int n5 = (int)c_b.b;
        int n6 = (int)c_b.e + 1;
        int n7 = (int)c_b.c;
        int n8 = (int)c_b.f + 1;
        if (c_b.a < 0.0f) {
            --n3;
        }
        if (c_b.b < 0.0f) {
            --n5;
        }
        if (c_b.c < 0.0f) {
            --n7;
        }
        for (int i = n3; i < n4; ++i) {
            for (int j = n5; j < n6; ++j) {
                for (int k = n7; k < n8; ++k) {
                    if (i < 0 || j < 0 || k < 0 || i >= this.a || j >= this.c || k >= this.b || this.a(i, j, k) != n) continue;
                    ++n2;
                }
            }
        }
        return n2;
    }

    public void a(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = this.a(n, n2, n3);
        int n8 = this.a(n4, n5, n6);
        this.a(n, n2, n3, n8);
        this.a(n4, n5, n6, n7);
        this.c(n, n2, n3, n8);
        this.c(n4, n5, n6, n7);
    }

    public boolean a(int n, int n2, int n3, int n4) {
        return this.setBlockAndMetadata(n, n2, n3, n4, 0);
    }

    public boolean setBlockAndMetadata(int n, int n2, int n3, int n4, int n5) {
        if (n > 0 && n2 > 0 && n3 > 0 && n < this.a - 1 && n2 < this.c - 1 && n3 < this.b - 1) {
            if (n4 == this.d[(n2 * this.b + n3) * this.a + n]) {
                return false;
            }
            int n6 = this.getHeightValue(n, n3);
            if (n4 == 0 && (n == 0 || n3 == 0 || n == this.a - 1 || n3 == this.b - 1) && n2 >= this.t && n2 < this.s) {
                n4 = Block.p.at;
            }
            byte by = this.d[(n2 * this.b + n3) * this.a + n];
            this.d[(n2 * this.b + n3) * this.a + n] = (byte)n4;
            if (by != 0 && !this.multiplayerWorld) {
                Block.c[by & 0xFF].b(this, n, n2, n3);
                Block.c[by & 0xFF].breakBlock(this, n, n2, n3, by, this.e(n, n2, n3));
            }
            this.setBlockMetadata(n, n2, n3, n5);
            if (Block.f[n4] != 0) {
                if (n2 >= n6) {
                    this.relightBlock(n, n2 + 1, n3);
                }
            } else if (n2 == n6 - 1) {
                this.relightBlock(n, n2, n3);
            }
            this.scheduleLightingUpdate(C_l.Sky, n, n2, n3, n, n2, n3);
            this.scheduleLightingUpdate(C_l.Block, n, n2, n3, n, n2, n3);
            this.updateSkylight_do(n, n3);
            if (n4 != 0 && !this.multiplayerWorld && n4 != Block.Z.at && n4 != Block.stairUpsideDown.at) {
                Block.c[n4].d(this, n, n2, n3);
            }
            for (int i = 0; i < this.n.size(); ++i) {
                this.n.get(i).a(n, n2, n3);
            }
            this.markBlocksDirtyVertical(n, n2, n3, n4);
            return true;
        }
        return false;
    }

    public final void d() {
        this.updatingLighting();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void scheduleLightingUpdate(C_l c_l, int n, int n2, int n3, int n4, int n5, int n6) {
        ++lightingUpdatesScheduled;
        try {
            if (lightingUpdatesScheduled == 50) {
                return;
            }
            int n7 = 5;
            int n8 = this.lightingToUpdate.size();
            if (n7 > n8) {
                n7 = n8;
            }
            for (int i = 0; i < n7; ++i) {
                net.minecraft.a.a.C_c c_c = this.lightingToUpdate.get(this.lightingToUpdate.size() - i - 1);
                if (c_c.skyBlock != c_l || !c_c.getLightUpdated(n, n2, n3, n4, n5, n6)) continue;
                return;
            }
            this.lightingToUpdate.add(new net.minecraft.a.a.C_c(c_l, n, n2, n3, n4, n5, n6));
            n7 = 1000000;
            if (this.lightingToUpdate.size() > 1000000) {
                System.out.println("More than " + n7 + " updates, aborting lighting updates");
                this.lightingToUpdate.clear();
            }
        }
        finally {
            --lightingUpdatesScheduled;
        }
    }

    public void initLighting() {
        int n;
        int n2;
        Arrays.fill(this.p, 0);
        int n3 = this.c - 1;
        this.lightingToUpdate.clear();
        for (n2 = 0; n2 <= this.a; ++n2) {
            for (n = 0; n <= this.b; ++n) {
                this.setHeightValue(n2, n, this.c - 1);
                this.relightBlock(n2, this.c - 1, n);
                n3 = Math.min(this.minHeight, this.getHeightValue(n2, n));
            }
        }
        this.minHeight = n3;
        for (n2 = 0; n2 <= this.a; ++n2) {
            for (n = 0; n <= this.b; ++n) {
                this.updateSkylight_do(n2, n);
            }
        }
    }

    public int getHeightValue(int n, int n2) {
        try {
            return this.p[n + n2 * this.a];
        }
        catch (Exception exception) {
            return 0;
        }
    }

    public void setHeightValue(int n, int n2, int n3) {
        try {
            this.p[n + n2 * this.a] = n3;
        }
        catch (Exception exception) {
            return;
        }
    }

    private void updateSkylight_do(int n, int n2) {
        if (n < 0 || n >= this.a || n2 < 0 || n2 >= this.b) {
            return;
        }
        int n3 = this.getHeightValue(n, n2);
        this.checkSkylightNeighborHeight(n - 1, n2, n3);
        this.checkSkylightNeighborHeight(n + 1, n2, n3);
        this.checkSkylightNeighborHeight(n, n2 - 1, n3);
        this.checkSkylightNeighborHeight(n, n2 + 1, n3);
    }

    private void checkSkylightNeighborHeight(int n, int n2, int n3) {
        if (n < 0 || n >= this.a || n2 < 0 || n2 >= this.b || n3 < 0 || n3 >= this.c) {
            return;
        }
        int n4 = this.getHeightValue(n, n2);
        if (n4 > n3) {
            this.scheduleLightingUpdate(C_l.Sky, n, n3, n2, n, n4, n2);
        } else if (n4 < n3) {
            this.scheduleLightingUpdate(C_l.Sky, n, n4, n2, n, n3, n2);
        }
    }

    private void relightBlock(int n, int n2, int n3) {
        int n4;
        int n5 = n4 = this.getHeightValue(n, n3);
        if (n2 > n4) {
            n5 = n2;
        }
        while (n5 > 0 && Block.f[this.a(n, n5 - 1, n3)] == 0) {
            --n5;
        }
        if (n5 != n4) {
            int n6;
            int n7;
            int n8;
            int n9;
            int n10 = n5;
            int n11 = n4;
            if (n10 > n11) {
                n9 = n11;
                n11 = n10;
                n10 = n9;
            }
            for (n9 = 0; n9 < this.n.size(); ++n9) {
                this.n.get(n9).a(n, n10, n3, n, n11, n3);
            }
            this.setHeightValue(n, n3, n5);
            if (n5 < this.minHeight) {
                this.minHeight = n5;
            } else {
                n9 = this.c - 1;
                for (n8 = 0; n8 < 16; ++n8) {
                    for (n7 = 0; n7 < 16; ++n7) {
                        if (this.getHeightValue(n8, n7) >= n9) continue;
                        n9 = this.getHeightValue(n8, n7);
                    }
                }
                this.minHeight = n9;
            }
            n9 = n;
            n8 = n3;
            if (n5 < n4) {
                for (n7 = n5; n7 < n4; ++n7) {
                    this.setSavedLightValue(C_l.Sky, n, n7, n3, 15);
                }
            } else {
                this.scheduleLightingUpdate(C_l.Sky, n9, n4, n8, n9, n5, n8);
                for (n7 = n4; n7 < n5; ++n7) {
                    this.setSavedLightValue(C_l.Sky, n, n7, n3, 0);
                }
            }
            n7 = 15;
            int n12 = n5;
            while (n5 > 0 && n7 > 0) {
                if ((n6 = Block.f[this.a(n, --n5, n3)]) == 0) {
                    n6 = 1;
                }
                if ((n7 -= n6) < 0) {
                    n7 = 0;
                }
                this.setSavedLightValue(C_l.Sky, n, n5, n3, n7);
            }
            while (n5 > 0 && Block.f[this.a(n, n5 - 1, n3)] == 0) {
                --n5;
            }
            if (n5 != n12) {
                if (n5 > n12) {
                    n6 = n5;
                    n5 = n12;
                    n12 = n6;
                }
                if (n5 > n10) {
                    n5 = n10;
                }
                if (n12 < n11) {
                    n12 = n11;
                }
                this.scheduleLightingUpdate(C_l.Sky, n9 - 1, n5, n8 - 1, n9 + 1, n12, n8 + 1);
            }
        }
    }

    public final boolean updatingLighting() {
        if (this.lightingUpdatesCounter >= 50) {
            return false;
        }
        ++this.lightingUpdatesCounter;
        int n = 500;
        while (!this.lightingToUpdate.isEmpty()) {
            if (--n <= 0) {
                --this.lightingUpdatesCounter;
                return true;
            }
            this.lightingToUpdate.remove(this.lightingToUpdate.size() - 1).updateLight(this);
        }
        --this.lightingUpdatesCounter;
        return false;
    }

    public final void neighborLightPropagationChanged(C_l c_l, int n, int n2, int n3, int n4) {
        if (n >= 0 && n < this.a && n2 >= 0 && n2 < this.c && n3 >= 0 && n3 < this.b) {
            int n5;
            if (c_l == C_l.Sky) {
                if (this.l(n, n2, n3)) {
                    n4 = 15;
                }
            } else if (c_l == C_l.Block && Block.h[n5 = this.a(n, n2, n3)] > n4) {
                n4 = Block.h[n5];
            }
            if (this.getSavedLightValue(c_l, n, n2, n3) != n4) {
                this.scheduleLightingUpdate(c_l, n, n2, n3, n, n2, n3);
            }
        }
    }

    public final int getSavedLightValue(C_l c_l, int n, int n2, int n3) {
        if (n < 0) {
            n = 0;
        } else if (n >= this.a) {
            n = this.a - 1;
        }
        if (n2 < 0) {
            n2 = 0;
        } else if (n2 >= this.c) {
            n2 = this.c - 1;
        }
        if (n3 < 0) {
            n3 = 0;
        } else if (n3 >= this.b) {
            n3 = this.b - 1;
        }
        byte by = this.light[(n2 * this.b + n3) * this.a + n];
        if (c_l == C_l.Sky) {
            by = (byte)(by >>> 4);
        }
        return by & 0xF;
    }

    public final void setSavedLightValue(C_l c_l, int n, int n2, int n3, int n4) {
        int n5 = (n2 * this.b + n3) * this.a + n;
        byte by = this.light[n5];
        if (c_l == C_l.Sky) {
            by = (byte)(by & 0xF);
            by = (byte)(by | (byte)(n4 << 4));
        } else {
            by = (byte)(by & 0xFFFFFFF0);
            by = (byte)(by | (byte)(n4 & 0xF));
        }
        this.light[n5] = by;
        for (int i = 0; i < this.n.size(); ++i) {
            this.n.get(i).a(n, n2, n3);
        }
    }

    public boolean setBlockWithClipping(int n, int n2, int n3, int n4) {
        if (n > 0 && n2 > 0 && n3 > 0 && n < this.a - 1 && n2 < this.c - 1 && n3 < this.b - 1) {
            if (n4 == this.d[(n2 * this.b + n3) * this.a + n]) {
                return false;
            }
            if (n4 == 0 && (n == 0 || n3 == 0 || n == this.a - 1 || n3 == this.b - 1) && n2 >= this.t && n2 < this.s) {
                n4 = Block.p.at;
            }
            this.d[(n2 * this.b + n3) * this.a + n] = (byte)n4;
            this.setBlockMetadata(n, n2, n3, 0);
            this.markBlocksDirtyVertical(n, n2, n3, n4);
            return true;
        }
        return false;
    }

    public boolean b(int n, int n2, int n3, int n4) {
        if (this.a(n, n2, n3, n4)) {
            this.c(n, n2, n3, n4);
            return true;
        }
        return false;
    }

    public void markBlocksDirtyVertical(int n, int n2, int n3, int n4) {
        if (n3 > n4) {
            int n5 = n4;
            n4 = n3;
            n3 = n5;
        }
        this.markBlocksDirty(n, n3, n2, n, n4, n2);
    }

    public void markBlocksDirty(int n, int n2, int n3, int n4, int n5, int n6) {
        for (int i = 0; i < this.n.size(); ++i) {
            this.n.get(i).a(n, n2, n3, n4, n5, n6);
        }
    }

    public boolean setBlockAndMetadataWithNotify(int n, int n2, int n3, int n4, int n5) {
        if (this.setBlockAndMetadata(n, n2, n3, n4, n5)) {
            this.notifyBlockChange(n, n2, n3, n4);
            return true;
        }
        return false;
    }

    public void setBlockMetadataWithNotify(int n, int n2, int n3, int n4) {
        this.setBlockMetadata(n, n2, n3, n4);
        int n5 = this.a(n, n2, n3);
        if (Block.hasMetadata[n5 & 0xFF]) {
            this.notifyBlockChange(n, n2, n3, n5);
        } else {
            this.c(n, n2, n3, n5);
        }
    }

    public void markBlockNeedsUpdate(int n, int n2, int n3) {
        for (int i = 0; i < this.n.size(); ++i) {
            this.n.get(i).a(n, n2, n3);
        }
    }

    protected void notifyBlockChange(int n, int n2, int n3, int n4) {
        this.markBlockNeedsUpdate(n, n2, n3);
        this.c(n, n2, n3, n4);
    }

    public void c(int n, int n2, int n3, int n4) {
        this.h(n - 1, n2, n3, n4);
        this.h(n + 1, n2, n3, n4);
        this.h(n, n2 - 1, n3, n4);
        this.h(n, n2 + 1, n3, n4);
        this.h(n, n2, n3 - 1, n4);
        this.h(n, n2, n3 + 1, n4);
    }

    public boolean d(int n, int n2, int n3, int n4) {
        if (n >= 0 && n2 >= 0 && n3 >= 0 && n < this.a && n2 < this.c && n3 < this.b) {
            if (n4 == this.d[(n2 * this.b + n3) * this.a + n]) {
                return false;
            }
            this.d[(n2 * this.b + n3) * this.a + n] = (byte)n4;
            return true;
        }
        return false;
    }

    private void h(int n, int n2, int n3, int n4) {
        Block c_x;
        if (n >= 0 && n2 >= 0 && n3 >= 0 && n < this.a && n2 < this.c && n3 < this.b && (c_x = Block.c[this.d[(n2 * this.b + n3) * this.a + n] & 0xFF]) != null) {
            c_x.b(this, n, n2, n3, n4);
        }
    }

    public int a(int n, int n2, int n3) {
        if (n < 0) {
            n = 0;
        } else if (n >= this.a) {
            n = this.a - 1;
        }
        if (n2 < 0) {
            n2 = 0;
        } else if (n2 >= this.c) {
            n2 = this.c - 1;
        }
        if (n3 < 0) {
            n3 = 0;
        } else if (n3 >= this.b) {
            n3 = this.b - 1;
        }
        return this.d[(n2 * this.b + n3) * this.a + n] & 0xFF;
    }

    public boolean b(int n, int n2, int n3) {
        Block c_x = Block.c[this.a(n, n2, n3)];
        return c_x == null ? false : c_x.isOpaqueCube(this.e(n, n2, n3));
    }

    public void c() {
        this.r.a();
        this.tileEntityFlag = true;
        for (int i = 0; i < this.H.size(); ++i) {
            TileEntity c_a = this.H.get(i);
            if (!c_a.isRemoving()) {
                c_a.d();
            }
            if (!c_a.isRemoving()) continue;
            this.H.remove(c_a);
            this.i(c_a.b, c_a.c, c_a.d);
            --i;
        }
        this.tileEntityFlag = false;
    }

    public float a(float f) {
        float f2;
        f = this.c(f);
        f = 1.0f - (MathHelper.b(f * (float)Math.PI * 2.0f) * 2.0f + 0.75f);
        if (f2 < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (this.type == 8) {
            return 1.0f;
        }
        this.isNight = f == 1.0f;
        return f * f * 0.5f;
    }

    public net.minecraft.a.d.C_a b(float f) {
        float f2;
        float f3;
        f = MathHelper.b(this.c(f) * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        if (f3 < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        float f4 = (float)(this.v >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(this.v >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(this.v & 0xFF) / 255.0f;
        float f7 = this.getRainStatus(f4);
        float f8 = this.getThunderStatus(f4);
        int n = this.season.currentSeason;
        int n2 = this.season.lastSeason;
        int n3 = this.season.nextSeason;
        float f9 = this.season.seasonProgress;
        int n4 = f9 <= 0.5f ? n2 : n3;
        float f10 = -(Math.abs(f9 * 2.0f - 1.0f) - 1.0f) * 0.5f + 0.5f;
        float f11 = 1.0f - f10;
        int n5 = seasonColor.get(n);
        int n6 = seasonColor.get(n4);
        float f12 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f13 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f14 = (float)(n5 >> 0 & 0xFF) / 255.0f;
        float f15 = (float)(n6 >> 16 & 0xFF) / 255.0f;
        float f16 = (float)(n6 >> 8 & 0xFF) / 255.0f;
        float f17 = (float)(n6 >> 0 & 0xFF) / 255.0f;
        if (this.theme == 0 && !this.multiplayerWorld) {
            f4 = f12 * f10 + f15 * f11;
            f5 = f13 * f10 + f16 * f11;
            f6 = f14 * f10 + f17 * f11;
        }
        if (f7 > 0.0f) {
            float f18 = (f4 * 0.3f + f5 * 0.59f + f6 * 0.11f) * 0.6f;
            f2 = 1.0f - f7 * 0.75f;
            if (this.type == 4 && this.theme != 1) {
                f2 = 1.0f - f7;
                f4 = f4 * f2 + f7 * 0.7f;
                f5 = f5 * f2 + f7 * 0.5f;
                f6 = f6 * f2 + f7 * 0.2f;
            } else {
                f4 = f4 * f2 + f18 * (1.0f - f2);
                f5 = f5 * f2 + f18 * (1.0f - f2);
                f6 = f6 * f2 + f18 * (1.0f - f2);
            }
        }
        if (f8 > 0.0f) {
            f2 = (f4 * 0.3f + f5 * 0.59f + f6 * 0.11f) * 0.2f;
            float f19 = 1.0f - f8 * 0.75f;
            f4 = f4 * f19 + f2 * (1.0f - f19);
            f5 = f5 * f19 + f2 * (1.0f - f19);
            f6 = f6 * f19 + f2 * (1.0f - f19);
        }
        if (this.lightStrike > 0) {
            f2 = (float)this.lightStrike - f4;
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            f4 = f4 * (1.0f - (f2 *= 0.45f)) + 0.8f * f2;
            f5 = f5 * (1.0f - f2) + 0.8f * f2;
            f6 = f6 * (1.0f - f2) + 1.0f * f2;
        }
        if (this.type == 8) {
            f4 = 0.0f;
            f5 = 0.0f;
            f6 = 0.0f;
        }
        return new net.minecraft.a.d.C_a(f4 *= f, f5 *= f, f6 *= f);
    }

    public float[] calcSunriseSunsetColors(float f, float f2) {
        float f3 = 0.4f;
        float f4 = MathHelper.b(f * (float)Math.PI * 2.0f) - 0.0f;
        float f5 = -0.0f;
        if (this.type == 8) {
            return null;
        }
        if (f4 >= f5 - f3 && f4 <= f5 + f3) {
            float f6 = (f4 - f5) / f3 * 0.5f + 0.5f;
            float f7 = 1.0f - (1.0f - MathHelper.a(f6 * (float)Math.PI)) * 0.99f;
            f7 *= f7;
            this.colorsSunriseSunset[0] = f6 * 0.3f + 0.7f;
            this.colorsSunriseSunset[1] = f6 * f6 * 0.7f + 0.2f;
            this.colorsSunriseSunset[2] = f6 * f6 * 0.0f + 0.2f;
            this.colorsSunriseSunset[3] = f7;
            return this.colorsSunriseSunset;
        }
        return null;
    }

    public float c(float f) {
        float f2 = (float)(this.D % 24000) + f;
        float f3 = 0.5f;
        float f4 = 0.5f;
        int n = this.season.currentSeason;
        int n2 = this.season.seasonProgress <= 0.5f ? this.season.lastSeason : this.season.nextSeason;
        switch (n) {
            case 1: {
                f3 = 0.7f;
                break;
            }
            case 3: {
                f3 = 0.3f;
                break;
            }
            default: {
                f3 = 0.5f;
            }
        }
        switch (n2) {
            case 1: {
                f4 = 0.7f;
                break;
            }
            case 3: {
                f4 = 0.3f;
                break;
            }
            default: {
                f4 = 0.5f;
            }
        }
        float f5 = Math.abs(this.season.seasonProgress - 0.5f);
        float f6 = f3 + (f4 - f3) * f5;
        float f7 = 1.0f - f6;
        int n3 = (int)(24000.0f * f6);
        int n4 = (int)(24000.0f * f7);
        boolean bl = f2 < (float)n3;
        float f8 = bl ? f2 / (float)n3 : (f2 - (float)n3) / (float)n4;
        float f9 = bl ? f8 / 2.0f : 0.5f + f8 / 2.0f;
        f9 -= 0.25f;
        if (f9 < 0.0f) {
            f9 += 1.0f;
        }
        if (f9 > 1.0f) {
            f9 -= 1.0f;
        }
        float f10 = f9;
        f9 = 1.0f - (float)((Math.cos((double)f9 * Math.PI) + 1.0) / 2.0);
        f9 = f10 + (f9 - f10) / 3.0f;
        if (this.A > 15) {
            return 0.0f;
        }
        if (this.A < 0) {
            return 1.0f;
        }
        return f9;
    }

    public float getSunsetAngle(float f) {
        float f2 = this.c(f);
        return f2 * (float)Math.PI * 2.0f;
    }

    public net.minecraft.a.d.C_a d(float f) {
        float f2;
        f = MathHelper.b(this.c(f) * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        if (f2 < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        float f3 = (float)(this.w >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(this.w >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(this.w & 0xFF) / 255.0f;
        return new net.minecraft.a.d.C_a(f3 *= f * 0.94f + 0.06f, f4 *= f * 0.94f + 0.06f, f5 *= f * 0.91f + 0.09f);
    }

    public net.minecraft.a.d.C_a e(float f) {
        float f2;
        float f3;
        f = MathHelper.b(this.c(f) * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        if (f3 < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        float f4 = (float)(this.x >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(this.x >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(this.x & 0xFF) / 255.0f;
        float f7 = this.getRainStatus(f);
        float f8 = this.getThunderStatus(f);
        if (f7 > 0.0f) {
            float f9 = (f4 * 0.3f + f5 * 0.59f + f6 * 0.11f) * 0.6f;
            f2 = 1.0f - f7 * 0.95f;
            if (this.type == 4 && this.theme != 1) {
                f4 = f4 * f2 + f7 * 0.5f;
                f5 = f5 * f2 + f7 * 0.3f;
                f6 = f6 * f2 + f7 * 0.0f;
            } else {
                f4 = f4 * f2 + f9 * (1.0f - f2);
                f5 = f5 * f2 + f9 * (1.0f - f2);
                f6 = f6 * f2 + f9 * (1.0f - f2);
            }
        }
        if (f8 > 0.0f) {
            f2 = (f4 * 0.3f + f5 * 0.59f + f6 * 0.11f) * 0.2f;
            float f10 = 1.0f - f8 * 0.95f;
            f4 = f4 * f10 + f2 * (1.0f - f10);
            f5 = f5 * f10 + f2 * (1.0f - f10);
            f6 = f6 * f10 + f2 * (1.0f - f10);
        }
        return new net.minecraft.a.d.C_a(f4 *= f * 0.9f + 0.1f, f5 *= f * 0.9f + 0.1f, f6 *= f * 0.85f + 0.15f);
    }

    public int e() {
        int n;
        float f;
        float f2 = MathHelper.b(this.c(1.0f) * (float)Math.PI * 2.0f) * 1.5f + 0.5f;
        if (f < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if ((n = (int)(f2 * ((float)(15 * this.A) / 15.0f - 4.0f) + 4.0f)) > 15) {
            n = 15;
        }
        if (n < 4) {
            n = 4;
        }
        if (this.raining && n > 12) {
            n = 12;
        }
        if (this.thundering && n > 8) {
            n = 8;
        }
        return n;
    }

    public void f() {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        ++this.D;
        if (this.bloodMoonChance == 9 && this.E > 0 && this.theme != 2 && this.type != 5 && this.type != 8 && this.daysPassed >= 5) {
            Item.clock.a(299);
        } else if (this.bloodMoon) {
            Item.clock.a(299);
        } else {
            Item.clock.a(298);
        }
        if (this.D == 24000) {
            this.D = 0;
            ++this.daysPassed;
            if (this.bloodMoon) {
                this.mc.f.addStat(StatList.bloodMoons, 1);
                this.bloodMoon = false;
                this.bloodMoonChance = 0;
            } else {
                this.bloodMoonChance = this.I.nextInt(10);
            }
            this.mc.f.addStat(StatList.daysPassed, 1);
            if (this.daysPassed >= 100 && this.mc.f.gamemode != 2) {
                this.mc.f.triggerAchievement(AchievementList.yearChallenge);
            }
        }
        if (this.mc != null && this.a(this.mc.G.c) > 0.0f && this.bloodMoonChance == 9 && this.E > 0 && !this.bloodMoon && this.theme != 2 && this.type != 5 && this.type != 8 && this.daysPassed >= 5) {
            this.bloodMoon = true;
            this.mc.f.triggerAchievement(AchievementList.bloodMoon);
            this.mc.t.addChatMessage("\u00a7cThe blood moon is rising...");
        }
        this.season.tick();
        if (this.type != 5 && this.type != 8 && this.theme != 2 && !this.freezeWeatherUpdates) {
            this.updateWeather();
        }
        if (this.B != (n7 = this.e())) {
            this.a(n7);
        }
        n7 = 1;
        int n8 = 1;
        while (1 << n7 < this.a) {
            ++n7;
        }
        while (1 << n8 < this.b) {
            ++n8;
        }
        int n9 = this.b - 1;
        int n10 = this.a - 1;
        int n11 = this.c - 1;
        int n12 = this.G.size();
        if (n12 > 200) {
            n12 = 200;
        }
        for (n6 = 0; n6 < n12; ++n6) {
            C_e c_e = this.G.remove(0);
            if (c_e.e > 0) {
                --c_e.e;
                this.G.add(c_e);
                continue;
            }
            n5 = c_e.c;
            n4 = c_e.b;
            n3 = c_e.a;
            if (n3 < 0 || n4 < 0 || n5 < 0 || n3 >= this.a || n4 >= this.c || n5 >= this.b || (n2 = this.d[(c_e.b * this.b + c_e.c) * this.a + c_e.a]) != c_e.d || n2 <= 0 || this.physicsDisabled) continue;
            Block.c[n2].a(this, c_e.a, c_e.b, c_e.c, this.q);
        }
        this.K += this.a * this.b * this.c;
        n12 = this.K / 200;
        this.K -= n12 * 200;
        if (this.I.nextInt(250) == 0 && this.raining && this.thundering && !this.multiplayerWorld && this.season.currentSeason == 1) {
            this.J = this.J * 3 + 1013904223;
            n5 = this.J >> 2;
            n3 = n5 >> n7 & n9;
            n5 = n5 >> n7 + n8 & n10;
            int n13 = this.a(n3, n5);
            n4 = 10;
            block3: for (n2 = n3 - n4; n2 <= n3 + n4; ++n2) {
                for (n = n5 - n4; n <= n5 + n4; ++n) {
                    int n14 = this.a(n2, n);
                    if (n14 <= n13 || this.a(n2, n14 - 1, n) != Block.rod.at) continue;
                    n3 = n2;
                    n5 = n;
                    n13 = n14;
                    continue block3;
                }
            }
            if (this.canBlockBeRainedOn(n3, n13, n5)) {
                this.spawnEntityInWorld(new C_f(this, n3, n13, n5));
                this.weatherUpdates = 2;
            }
        }
        if (this.raining && (this.season.currentSeason != 2 || this.type == 4)) {
            this.J = this.J * 3 + 1013904223;
            n4 = this.J >> 2;
            n3 = n4 & n9;
            n2 = n4 >> 8 & n10;
            int n15 = this.a(n3, n2);
            if (n15 >= 1 && n15 < this.c) {
                n = this.a(n3, n15 - 1, n2);
                n5 = this.a(n3, n15, n2);
                Block c_x = Block.tallGrass;
                if (this.season.currentSeason == 3) {
                    c_x = Block.snowLayer;
                    if (this.theme == 1) {
                        c_x = Block.ash;
                    }
                }
                if (this.type == 4) {
                    c_x = Block.sandLayer;
                }
                if (c_x.at == Block.tallGrass.at) {
                    if (this.I.nextInt(150) == 0 && n5 == 0 && c_x.canBlockStay(this, n3, n15, n2) && n != 0 && n != Block.ice.at && Block.c[n].getMaterial(0).c() && this.season.currentSeason == 0) {
                        this.b(n3, n15, n2, c_x.at);
                    }
                } else if (n5 == 0 && c_x.canBlockStay(this, n3, n15, n2) && n != 0 && n != Block.ice.at && Block.c[n].getMaterial(0).c()) {
                    this.b(n3, n15, n2, c_x.at);
                }
                if (n == c_x.at && c_x.at != Block.tallGrass.at && this.e(n3, n15 - 1, n2) < 7 && this.thundering) {
                    this.setBlockMetadataWithNotify(n3, n15 - 1, n2, this.e(n3, n15 - 1, n2) + 1);
                }
                if (this.season.currentSeason == 3 && (n == Block.q.at || n == Block.p.at) && this.e(n3, n15 - 1, n2) == 0 && this.theme != 1 && this.type != 4) {
                    this.b(n3, n15 - 1, n2, Block.ice.at);
                }
            }
        }
        for (n6 = 0; n6 < n12; ++n6) {
            this.J = this.J * 3 + 1013904223;
            n4 = this.J >> 2;
            n3 = n4 >> n7 & n9;
            n2 = n4 & n10;
            n = this.d[((n4 = n4 >> n7 + n8 & n11) * this.b + n3) * this.a + n2];
            if (!Block.d[n & 0xFF] || this.physicsDisabled) continue;
            Block.c[n & 0xFF].a(this, n2, n4, n3, this.q);
        }
        if (this.type == 5) {
            if (this.soundCounter > 0) {
                --this.soundCounter;
            }
            if (this.soundCounter == 0 && !this.mc.l) {
                this.mc.x.playAllocatedAmbience("loops.cave chimes", 0.1f, 1.0f, false);
                this.soundCounter = this.I.nextInt(12000) + 6000;
            }
        }
    }

    public boolean canBlockBeRainedOn(int n, int n2, int n3) {
        if (!this.thundering) {
            return false;
        }
        if (!this.l(n, n2, n3)) {
            return false;
        }
        if (this.a(n, n3) > n2) {
            return false;
        }
        return this.season.currentSeason != 3;
    }

    public int a(Class<?> clazz) {
        int n = 0;
        for (int i = 0; i < this.r.e.size(); ++i) {
            Entity c_b = this.r.e.get(i);
            if (!clazz.isAssignableFrom(c_b.getClass())) continue;
            ++n;
        }
        return n;
    }

    public int g() {
        return this.t;
    }

    public int h() {
        return this.s;
    }

    public boolean b(net.minecraft.a.d.C_b c_b) {
        int n = (int)c_b.a;
        int n2 = (int)c_b.d + 1;
        int n3 = (int)c_b.b;
        int n4 = (int)c_b.e + 1;
        int n5 = (int)c_b.c;
        int n6 = (int)c_b.f + 1;
        if (c_b.a < 0.0f) {
            --n;
        }
        if (c_b.b < 0.0f) {
            --n3;
        }
        if (c_b.c < 0.0f) {
            --n5;
        }
        if (n < 0) {
            n = 0;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        if (n5 < 0) {
            n5 = 0;
        }
        if (n2 > this.a) {
            n2 = this.a;
        }
        if (n4 > this.c) {
            n4 = this.c;
        }
        if (n6 > this.b) {
            n6 = this.b;
        }
        for (int i = n; i < n2; ++i) {
            for (n = n3; n < n4; ++n) {
                for (int j = n5; j < n6; ++j) {
                    Block c_x = Block.c[this.a(i, n, j)];
                    if (c_x == null || !c_x.getMaterial(this.e(i, n, j)).d()) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean c(net.minecraft.a.d.C_b c_b) {
        int n = (int)c_b.d + 1;
        int n2 = (int)c_b.b;
        int n3 = (int)c_b.e + 1;
        int n4 = (int)c_b.c;
        int n5 = (int)c_b.f + 1;
        for (int i = (int)c_b.a; i < n; ++i) {
            for (int j = n2; j < n3; ++j) {
                for (int k = n4; k < n5; ++k) {
                    if (this.a(i, j, k) != Block.ag.at) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBoundingBoxHellfire(net.minecraft.a.d.C_b c_b) {
        int n = (int)c_b.d + 1;
        int n2 = (int)c_b.b;
        int n3 = (int)c_b.e + 1;
        int n4 = (int)c_b.c;
        int n5 = (int)c_b.f + 1;
        for (int i = (int)c_b.a; i < n; ++i) {
            for (int j = n2; j < n3; ++j) {
                for (int k = n4; k < n5; ++k) {
                    int n6 = this.a(i, j, k);
                    if (n6 != Block.hellfire.at) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBoundingBoxLava(net.minecraft.a.d.C_b c_b) {
        int n = (int)c_b.d + 1;
        int n2 = (int)c_b.b;
        int n3 = (int)c_b.e + 1;
        int n4 = (int)c_b.c;
        int n5 = (int)c_b.f + 1;
        for (int i = (int)c_b.a; i < n; ++i) {
            for (int j = n2; j < n3; ++j) {
                for (int k = n4; k < n5; ++k) {
                    int n6 = this.a(i, j, k);
                    if (n6 != Block.ag.at && n6 != Block.r.at && n6 != Block.s.at) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(net.minecraft.a.d.C_b c_b, net.minecraft.a.a.d.Material c_c) {
        int n = (int)c_b.d + 1;
        int n2 = (int)c_b.b;
        int n3 = (int)c_b.e + 1;
        int n4 = (int)c_b.c;
        int n5 = (int)c_b.f + 1;
        for (int i = (int)c_b.a; i < n; ++i) {
            for (int j = n2; j < n3; ++j) {
                for (int k = n4; k < n5; ++k) {
                    Block c_x = Block.c[this.a(i, j, k)];
                    if (c_x == null || c_x.getMaterial(this.e(i, j, k)) != c_c) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public void e(int n, int n2, int n3, int n4) {
        C_e c_e = new C_e(n, n2, n3, n4);
        if (n4 > 0) {
            c_e.e = n3 = Block.c[n4].e();
        }
        this.G.add(c_e);
    }

    public void immediateUpdate(int n, int n2, int n3, int n4) {
        C_e c_e = new C_e(n, n2, n3, n4);
        if (n4 > 0) {
            c_e.e = n3 = Block.c[n4].e();
        }
        this.G.add(0, c_e);
    }

    public boolean d(net.minecraft.a.d.C_b c_b) {
        return this.r.a(null, c_b).size() == 0;
    }

    public boolean e(net.minecraft.a.d.C_b c_b) {
        List<Entity> list = this.r.a(null, c_b);
        for (int i = 0; i < list.size(); ++i) {
            if (!list.get((int)i).c) continue;
            return false;
        }
        return true;
    }

    public List<Entity> a(Entity c_b, net.minecraft.a.d.C_b c_b2) {
        return this.r.a(c_b, c_b2);
    }

    public boolean a(float f, float f2, float f3, float f4) {
        return this.a(f - 0.1f, f2 - 0.1f, f3 - 0.1f) ? true : (this.a(f - 0.1f, f2 - 0.1f, f3 + 0.1f) ? true : (this.a(f - 0.1f, f2 + 0.1f, f3 - 0.1f) ? true : (this.a(f - 0.1f, f2 + 0.1f, f3 + 0.1f) ? true : (this.a(f + 0.1f, f2 - 0.1f, f3 - 0.1f) ? true : (this.a(f + 0.1f, f2 - 0.1f, f3 + 0.1f) ? true : (this.a(f + 0.1f, f2 + 0.1f, f3 - 0.1f) ? true : this.a(f + 0.1f, f2 + 0.1f, f3 + 0.1f)))))));
    }

    public boolean a(float f, float f2, float f3) {
        int n = this.a((int)f, (int)f2, (int)f3);
        return n > 0 && Block.c[n].isOpaqueCube(this.e((int)f, (int)f2, (int)f3));
    }

    public boolean isSolidTile(int n, int n2, int n3) {
        Block c_x = Block.c[this.a(n, n2, n3)];
        return c_x == null ? false : c_x.d();
    }

    public boolean isQuicksand(float f, float f2, float f3) {
        int n = this.a((int)f, (int)f2, (int)f3);
        return n > 0 && Block.c[n].at == Block.quickSand.at;
    }

    public int a(int n, int n2) {
        int n3;
        for (n3 = this.c; (this.a(n, n3 - 1, n2) == 0 || Block.c[this.a(n, n3 - 1, n2)].getMaterial(this.a(n, n3 - 1, n2)) == net.minecraft.a.a.d.Material.a) && n3 > 0; --n3) {
        }
        return n3;
    }

    public int getLastUncoveredBlock(int n, int n2) {
        int n3;
        for (n3 = this.c / 4; (this.a(n, n3 + 1, n2) == 0 || Block.c[this.a(n, n3 + 1, n2)].getMaterial(this.a(n, n3 + 1, n2)) == net.minecraft.a.a.d.Material.a) && n3 < this.c; ++n3) {
        }
        return n3;
    }

    public void a(int n, int n2, int n3, float f) {
        this.i = n;
        this.j = n2;
        this.k = n3;
        this.l = f;
    }

    public float c(int n, int n2, int n3) {
        return F[this.d(n, n2, n3)];
    }

    public byte d(int n, int n2, int n3) {
        return (byte)Math.max(this.getSavedLightValue(C_l.Sky, n, n2, n3) - (15 - this.B), this.getSavedLightValue(C_l.Block, n, n2, n3));
    }

    public byte e(int n, int n2, int n3) {
        if (n < 0) {
            n = 0;
        } else if (n >= this.a) {
            n = this.a - 1;
        }
        if (n2 < 0) {
            n2 = 0;
        } else if (n2 >= this.c) {
            n2 = this.c - 1;
        }
        if (n3 < 0) {
            n3 = 0;
        } else if (n3 >= this.b) {
            n3 = this.b - 1;
        }
        return (byte)(this.e[(n2 * this.b + n3) * this.a + n] >>> 4 & 0xF);
    }

    public boolean setBlockMetadata(int n, int n2, int n3, int n4) {
        if (n > 0 && n2 > 0 && n3 > 0 && n < this.a - 1 && n2 < this.c - 1 && n3 < this.b - 1) {
            if (n4 == this.d[(n2 * this.b + n3) * this.a + n]) {
                return false;
            }
            if (n < 0) {
                n = 0;
            } else if (n >= this.a) {
                n = this.a - 1;
            }
            if (n2 < 0) {
                n2 = 0;
            } else if (n2 >= this.c) {
                n2 = this.c - 1;
            }
            if (n3 < 0) {
                n3 = 0;
            } else if (n3 >= this.b) {
                n3 = this.b - 1;
            }
            this.e[(n2 * this.b + n3) * this.a + n] = (byte)((this.e[(n2 * this.b + n3) * this.a + n] & 0xF) + (n4 << 4));
            for (n4 = 0; n4 < this.n.size(); ++n4) {
                this.n.get(n4).a(n, n2, n3);
            }
            return true;
        }
        return false;
    }

    public net.minecraft.a.a.d.Material f(int n, int n2, int n3) {
        int n4 = this.a(n, n2, n3);
        return n4 == 0 ? net.minecraft.a.a.d.Material.a : Block.c[n4].getMaterial(this.e(n, n2, n3));
    }

    public boolean g(int n, int n2, int n3) {
        int n4 = this.a(n, n2, n3);
        return n4 > 0 && Block.c[n4].getMaterial(this.e(n, n2, n3)) == net.minecraft.a.a.d.Material.f;
    }

    public boolean isLava(int n, int n2, int n3) {
        int n4 = this.a(n, n2, n3);
        return n4 > 0 && Block.c[n4].getMaterial(this.e(n, n2, n3)) == net.minecraft.a.a.d.Material.g;
    }

    public net.minecraft.a.d.C_c a(net.minecraft.a.d.C_a c_a, net.minecraft.a.d.C_a c_a2) {
        return this.rayTraceBlocks_do(c_a, c_a2, false, false);
    }

    public net.minecraft.a.d.C_c rayTraceBlocks_do(net.minecraft.a.d.C_a c_a, net.minecraft.a.d.C_a c_a2, boolean bl, boolean bl2) {
        if (!(Double.isNaN(c_a.a) || Double.isNaN(c_a.b) || Double.isNaN(c_a.c))) {
            if (!(Double.isNaN(c_a2.a) || Double.isNaN(c_a2.b) || Double.isNaN(c_a2.c))) {
                net.minecraft.a.d.C_c c_c;
                int n = MathHelper.a((double)c_a2.a);
                int n2 = MathHelper.a((double)c_a2.b);
                int n3 = MathHelper.a((double)c_a2.c);
                int n4 = MathHelper.a((double)c_a.a);
                int n5 = MathHelper.a((double)c_a.b);
                int n6 = MathHelper.a((double)c_a.c);
                int n7 = this.a(n4, n5, n6);
                byte by = this.e(n4, n5, n6);
                Block c_x = Block.c[n7];
                if ((!bl2 || c_x == null || c_x.getCollisionBoundingBoxFromPool(this, n4, n5, n6) != null) && n7 > 0 && c_x.canCollideCheck(by, bl) && (c_c = c_x.a(this, n4, n5, n6, c_a, c_a2)) != null) {
                    return c_c;
                }
                n7 = 200;
                while (n7-- >= 0) {
                    net.minecraft.a.d.C_c c_c2;
                    int n8;
                    if (Double.isNaN(c_a.a) || Double.isNaN(c_a.b) || Double.isNaN(c_a.c)) {
                        return null;
                    }
                    if (n4 == n && n5 == n2 && n6 == n3) {
                        return null;
                    }
                    boolean bl3 = true;
                    boolean bl4 = true;
                    boolean bl5 = true;
                    float f = 999.0f;
                    float f2 = 999.0f;
                    float f3 = 999.0f;
                    if (n > n4) {
                        f = (float)n4 + 1.0f;
                    } else if (n < n4) {
                        f = (float)n4 + 0.0f;
                    } else {
                        bl3 = false;
                    }
                    if (n2 > n5) {
                        f2 = (float)n5 + 1.0f;
                    } else if (n2 < n5) {
                        f2 = (float)n5 + 0.0f;
                    } else {
                        bl4 = false;
                    }
                    if (n3 > n6) {
                        f3 = (float)n6 + 1.0f;
                    } else if (n3 < n6) {
                        f3 = (float)n6 + 0.0f;
                    } else {
                        bl5 = false;
                    }
                    double d2 = 999.0;
                    double d3 = 999.0;
                    double d4 = 999.0;
                    double d5 = c_a2.a - c_a.a;
                    double d6 = c_a2.b - c_a.b;
                    double d7 = c_a2.c - c_a.c;
                    if (bl3) {
                        d2 = (double)(f - c_a.a) / d5;
                    }
                    if (bl4) {
                        d3 = (double)(f2 - c_a.b) / d6;
                    }
                    if (bl5) {
                        d4 = (double)(f3 - c_a.c) / d7;
                    }
                    if (d2 < d3 && d2 < d4) {
                        n8 = n > n4 ? 4 : 5;
                        c_a.a = f;
                        c_a.b = (float)((double)c_a.b + d6 * d2);
                        c_a.c = (float)((double)c_a.c + d7 * d2);
                    } else if (d3 < d4) {
                        n8 = n2 > n5 ? 0 : 1;
                        c_a.a = (float)((double)c_a.a + d5 * d3);
                        c_a.b = f2;
                        c_a.c = (float)((double)c_a.c + d7 * d3);
                    } else {
                        n8 = n3 > n6 ? 2 : 3;
                        c_a.a = (float)((double)c_a.a + d5 * d4);
                        c_a.b = (float)((double)c_a.b + d6 * d4);
                        c_a.c = f3;
                    }
                    net.minecraft.a.d.C_a c_a3 = new net.minecraft.a.d.C_a(c_a.a, c_a.b, c_a.c);
                    c_a3.a = MathHelper.a((double)c_a.a);
                    n4 = (int)c_a3.a;
                    if (n8 == 5) {
                        --n4;
                        c_a3.a += 1.0f;
                    }
                    c_a3.b = MathHelper.a((double)c_a.b);
                    n5 = (int)c_a3.b;
                    if (n8 == 1) {
                        --n5;
                        c_a3.b += 1.0f;
                    }
                    c_a3.c = MathHelper.a((double)c_a.c);
                    n6 = (int)c_a3.c;
                    if (n8 == 3) {
                        --n6;
                        c_a3.c += 1.0f;
                    }
                    int n9 = this.a(n4, n5, n6);
                    byte by2 = this.e(n4, n5, n6);
                    Block c_x2 = Block.c[n9];
                    if (bl2 && c_x2 != null && c_x2.getCollisionBoundingBoxFromPool(this, n4, n5, n6) == null || n9 <= 0 || !c_x2.canCollideCheck(by2, bl) || (c_c2 = c_x2.a(this, n4, n5, n6, c_a, c_a2)) == null) continue;
                    return c_c2;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public boolean genBigFlowerFeature1(int n, boolean bl, World c_g, Random random, int n2, int n3, int n4) {
        int n5 = random.nextInt(4) + n;
        boolean bl2 = true;
        int n6 = Block.flowerPetal.at;
        if (n3 >= 1 && n3 + n5 + 1 <= c_g.c) {
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            for (n11 = n3; n11 <= n3 + 1 + n5; ++n11) {
                n10 = 1;
                if (n11 == n3) {
                    n10 = 0;
                }
                if (n11 >= n3 + 1 + n5 - 2) {
                    n10 = 2;
                }
                for (n9 = n2 - n10; n9 <= n2 + n10 && bl2; ++n9) {
                    for (n8 = n4 - n10; n8 <= n4 + n10 && bl2; ++n8) {
                        if (n11 >= 0 && n9 >= 0 && n8 >= 0 && n9 < this.a && n8 < this.b && n11 < this.c) {
                            n7 = c_g.a(n9, n11, n8);
                            if (n7 == 0 || n7 == Block.plantPurple.at || n7 == Block.plantBlue.at || n7 == Block.plantYellow.at || n7 == Block.plantRed.at) continue;
                            bl2 = false;
                            continue;
                        }
                        bl2 = false;
                    }
                }
            }
            if (!bl2) {
                this.cantGrow = true;
                return false;
            }
            n11 = c_g.a(n2, n3 - 1, n4);
            if ((n11 == Block.j.at || n11 == Block.k.at) && n3 < c_g.c - n5 - 1) {
                c_g.a(n2, n3 - 1, n4, Block.k.at);
                n10 = 3;
                n9 = 0;
                for (n8 = n3 - n10 + n5; n8 <= n3 + n5; ++n8) {
                    n7 = n8 - (n3 + n5);
                    int n12 = n9 + 1 - n7 / 2;
                    for (int i = n2 - n12; i <= n2 + n12; ++i) {
                        int n13 = i - n2;
                        for (int j = n4 - n12; j <= n4 + n12; ++j) {
                            int n14 = j - n4;
                            if ((Math.abs(n13) != n12 || Math.abs(n14) != n12 || random.nextInt(2) != 0 && n7 != 0) && Block.e[c_g.a(i, n8, j)]) continue;
                        }
                    }
                }
                for (n8 = 0; n8 < n5; ++n8) {
                    n7 = c_g.a(n2, n3 + n8, n4);
                    if (n7 != 0 && n7 != Block.plantRed.at && n7 != Block.plantYellow.at && n7 != Block.plantPurple.at && n7 != Block.plantBlue.at) continue;
                    c_g.setBlockAndMetadata(n2, n3 + n8, n4, Block.flowerStem.at, 0);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + (n5 - 1), n4, n6, 1);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + (n5 - 1), n4, n6, 1);
                    c_g.setBlockAndMetadata(n2, n3 + (n5 - 1), n4 - 1, n6, 1);
                    c_g.setBlockAndMetadata(n2, n3 + (n5 - 1), n4 + 1, n6, 1);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4, n6, 1);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4, n6, 1);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4, n6, 1);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 - 1, n6, 1);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 + 1, n6, 1);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5, n4, n6, 1);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5, n4, n6, 1);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 - 2, n6, 1);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 + 2, n6, 1);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4 - 1, n6, 1);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4 + 1, n6, 1);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4 - 1, n6, 1);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4 + 1, n6, 1);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5, n4 - 2, n6, 1);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5, n4 + 2, n6, 1);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5, n4 - 2, n6, 1);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5, n4 + 2, n6, 1);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 1, n4, n6, 1);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 1, n4, n6, 1);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 1, n4 - 2, n6, 1);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 1, n4 + 2, n6, 1);
                    c_g.setBlockAndMetadata(n2 - 3, n3 + n5 + 2, n4, n6, 1);
                    c_g.setBlockAndMetadata(n2 + 3, n3 + n5 + 2, n4, n6, 1);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 2, n4 - 3, n6, 1);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 2, n4 + 3, n6, 1);
                }
                this.cantGrow = false;
                return true;
            }
            this.cantGrow = true;
            return false;
        }
        this.cantGrow = true;
        return false;
    }

    public boolean genBigFlowerFeature2(int n, boolean bl, World c_g, Random random, int n2, int n3, int n4) {
        int n5 = random.nextInt(4) + n;
        boolean bl2 = true;
        int n6 = Block.flowerPetal.at;
        if (n3 >= 1 && n3 + n5 + 1 <= c_g.c) {
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            for (n11 = n3; n11 <= n3 + 1 + n5; ++n11) {
                n10 = 1;
                if (n11 == n3) {
                    n10 = 0;
                }
                if (n11 >= n3 + 1 + n5 - 2) {
                    n10 = 2;
                }
                for (n9 = n2 - n10; n9 <= n2 + n10 && bl2; ++n9) {
                    for (n8 = n4 - n10; n8 <= n4 + n10 && bl2; ++n8) {
                        if (n11 >= 0 && n9 >= 0 && n8 >= 0 && n9 < this.a && n8 < this.b && n11 < this.c) {
                            n7 = c_g.a(n9, n11, n8);
                            if (n7 == 0 || n7 == Block.plantPurple.at || n7 == Block.plantBlue.at || n7 == Block.plantYellow.at || n7 == Block.plantRed.at) continue;
                            bl2 = false;
                            continue;
                        }
                        bl2 = false;
                    }
                }
            }
            if (!bl2) {
                this.cantGrow = true;
                return false;
            }
            n11 = c_g.a(n2, n3 - 1, n4);
            if ((n11 == Block.j.at || n11 == Block.k.at) && n3 < c_g.c - n5 - 1) {
                c_g.a(n2, n3 - 1, n4, Block.k.at);
                n10 = 3;
                n9 = 0;
                for (n8 = n3 - n10 + n5; n8 <= n3 + n5; ++n8) {
                    n7 = n8 - (n3 + n5);
                    int n12 = n9 + 1 - n7 / 2;
                    for (int i = n2 - n12; i <= n2 + n12; ++i) {
                        int n13 = i - n2;
                        for (int j = n4 - n12; j <= n4 + n12; ++j) {
                            int n14 = j - n4;
                            if ((Math.abs(n13) != n12 || Math.abs(n14) != n12 || random.nextInt(2) != 0 && n7 != 0) && Block.e[c_g.a(i, n8, j)]) continue;
                        }
                    }
                }
                for (n8 = 0; n8 < n5; ++n8) {
                    n7 = c_g.a(n2, n3 + n8, n4);
                    if (n7 != 0 && n7 != Block.plantRed.at && n7 != Block.plantYellow.at && n7 != Block.plantPurple.at && n7 != Block.plantBlue.at) continue;
                    c_g.setBlockAndMetadata(n2, n3 + n8, n4, Block.flowerStem.at, 0);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4, n6, 0);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4, n6, 0);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4, n6, 0);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 - 1, n6, 0);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 + 1, n6, 0);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4 - 1, n6, 0);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4 + 1, n6, 0);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4 - 1, n6, 0);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4 + 1, n6, 0);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4 - 2, n6, 0);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4 + 2, n6, 0);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4 - 2, n6, 0);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4 + 2, n6, 0);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5, n4 - 1, n6, 0);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5, n4 + 1, n6, 0);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5, n4 - 1, n6, 0);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5, n4 + 1, n6, 0);
                }
                if (random.nextInt(2) == 0) {
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n8 / 6 + 1, n4, Block.flowerStem.at, 0);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n8 / 6 + 2, n4, Block.flowerStem.at, 0);
                } else {
                    c_g.setBlockAndMetadata(n2, n3 + n8 / 6 + 1, n4 - 1, Block.flowerStem.at, 0);
                    c_g.setBlockAndMetadata(n2, n3 + n8 / 6 + 2, n4 + 1, Block.flowerStem.at, 0);
                }
                this.cantGrow = false;
                return true;
            }
            this.cantGrow = true;
            return false;
        }
        this.cantGrow = true;
        return false;
    }

    public boolean genBigFlowerFeature3(int n, boolean bl, World c_g, Random random, int n2, int n3, int n4) {
        int n5 = random.nextInt(4) + n;
        boolean bl2 = true;
        int n6 = Block.flowerPetal.at;
        if (n3 >= 1 && n3 + n5 + 1 <= c_g.c) {
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            for (n11 = n3; n11 <= n3 + 1 + n5; ++n11) {
                n10 = 1;
                if (n11 == n3) {
                    n10 = 0;
                }
                if (n11 >= n3 + 1 + n5 - 2) {
                    n10 = 2;
                }
                for (n9 = n2 - n10; n9 <= n2 + n10 && bl2; ++n9) {
                    for (n8 = n4 - n10; n8 <= n4 + n10 && bl2; ++n8) {
                        if (n11 >= 0 && n9 >= 0 && n8 >= 0 && n9 < this.a && n8 < this.b && n11 < this.c) {
                            n7 = c_g.a(n9, n11, n8);
                            if (n7 == 0 || n7 == Block.plantPurple.at || n7 == Block.plantBlue.at || n7 == Block.plantYellow.at || n7 == Block.plantRed.at) continue;
                            bl2 = false;
                            continue;
                        }
                        bl2 = false;
                    }
                }
            }
            if (!bl2) {
                this.cantGrow = true;
                return false;
            }
            n11 = c_g.a(n2, n3 - 1, n4);
            if ((n11 == Block.j.at || n11 == Block.k.at) && n3 < c_g.c - n5 - 1) {
                c_g.a(n2, n3 - 1, n4, Block.k.at);
                n10 = 3;
                n9 = 0;
                for (n8 = n3 - n10 + n5; n8 <= n3 + n5; ++n8) {
                    n7 = n8 - (n3 + n5);
                    int n12 = n9 + 1 - n7 / 2;
                    for (int i = n2 - n12; i <= n2 + n12; ++i) {
                        int n13 = i - n2;
                        for (int j = n4 - n12; j <= n4 + n12; ++j) {
                            int n14 = j - n4;
                            if ((Math.abs(n13) != n12 || Math.abs(n14) != n12 || random.nextInt(2) != 0 && n7 != 0) && Block.e[c_g.a(i, n8, j)]) continue;
                        }
                    }
                }
                for (n8 = 0; n8 < n5; ++n8) {
                    n7 = c_g.a(n2, n3 + n8, n4);
                    if (n7 != 0 && n7 != Block.plantRed.at && n7 != Block.plantYellow.at && n7 != Block.plantPurple.at && n7 != Block.plantBlue.at) continue;
                    c_g.setBlockAndMetadata(n2, n3 + n8, n4, Block.flowerStem.at, 0);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + (n5 - 1), n4, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + (n5 - 1), n4, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + (n5 - 1), n4 - 1, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + (n5 - 1), n4 + 1, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 - 1, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 + 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5, n4, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5, n4, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 - 2, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 + 2, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4 - 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4 + 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4 - 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4 + 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 1, n4, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 1, n4, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 1, n4 - 2, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 1, n4 + 2, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 1, n4 + 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 1, n4 - 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 1, n4 + 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 1, n4 - 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5 + 1, n4 - 2, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5 + 1, n4 - 2, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5 + 1, n4 + 2, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5 + 1, n4 + 2, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5 + 2, n4, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5 + 2, n4, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 2, n4 - 1, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 2, n4 + 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 2, n4, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 2, n4, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 2, n4 - 2, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 2, n4 + 2, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5 + 2, n4 - 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5 + 2, n4 + 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5 + 2, n4 - 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5 + 2, n4 + 1, n6, 3);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5 + 3, n4, n6, 3);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5 + 3, n4, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 3, n4 - 1, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 3, n4 + 1, n6, 3);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 3, n4, n6, 3);
                }
                this.cantGrow = false;
                return true;
            }
            this.cantGrow = true;
            return false;
        }
        this.cantGrow = true;
        return false;
    }

    public boolean genBigFlowerFeature4(int n, boolean bl, World c_g, Random random, int n2, int n3, int n4) {
        int n5 = random.nextInt(4) + n;
        boolean bl2 = true;
        int n6 = Block.flowerPetal.at;
        if (n3 >= 1 && n3 + n5 + 1 <= c_g.c) {
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            for (n11 = n3; n11 <= n3 + 1 + n5; ++n11) {
                n10 = 1;
                if (n11 == n3) {
                    n10 = 0;
                }
                if (n11 >= n3 + 1 + n5 - 2) {
                    n10 = 2;
                }
                for (n9 = n2 - n10; n9 <= n2 + n10 && bl2; ++n9) {
                    for (n8 = n4 - n10; n8 <= n4 + n10 && bl2; ++n8) {
                        if (n11 >= 0 && n9 >= 0 && n8 >= 0 && n9 < this.a && n8 < this.b && n11 < this.c) {
                            n7 = c_g.a(n9, n11, n8);
                            if (n7 == 0 || n7 == Block.plantPurple.at || n7 == Block.plantBlue.at || n7 == Block.plantYellow.at || n7 == Block.plantRed.at) continue;
                            bl2 = false;
                            continue;
                        }
                        bl2 = false;
                    }
                }
            }
            if (!bl2) {
                this.cantGrow = true;
                return false;
            }
            n11 = c_g.a(n2, n3 - 1, n4);
            if ((n11 == Block.j.at || n11 == Block.k.at) && n3 < c_g.c - n5 - 1) {
                c_g.a(n2, n3 - 1, n4, Block.k.at);
                n10 = 3;
                n9 = 0;
                for (n8 = n3 - n10 + n5; n8 <= n3 + n5; ++n8) {
                    n7 = n8 - (n3 + n5);
                    int n12 = n9 + 1 - n7 / 2;
                    for (int i = n2 - n12; i <= n2 + n12; ++i) {
                        int n13 = i - n2;
                        for (int j = n4 - n12; j <= n4 + n12; ++j) {
                            int n14 = j - n4;
                            if ((Math.abs(n13) != n12 || Math.abs(n14) != n12 || random.nextInt(2) != 0 && n7 != 0) && Block.e[c_g.a(i, n8, j)]) continue;
                        }
                    }
                }
                for (n8 = 0; n8 < n5; ++n8) {
                    n7 = c_g.a(n2, n3 + n8, n4);
                    if (n7 != 0 && n7 != Block.plantRed.at && n7 != Block.plantYellow.at && n7 != Block.plantPurple.at && n7 != Block.plantBlue.at) continue;
                    c_g.setBlockAndMetadata(n2, n3 + n8, n4, Block.flowerStem.at, 0);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + (n5 - 1), n4, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + (n5 - 1), n4, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + (n5 - 1), n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + (n5 - 1), n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + (n5 - 1), n4, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + (n5 - 1), n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + (n5 - 1), n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + (n5 - 1), n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + (n5 - 1), n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5 + 1, n4, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5 + 1, n4, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 1, n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 1, n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 1, n4, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5 + 1, n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5 + 1, n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5 + 1, n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5 + 1, n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5, n4, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5, n4, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 - 2, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + n5, n4 + 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5, n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5, n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5, n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5, n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4 - 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4 - 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5, n4 + 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5, n4 + 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 1, n4, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 1, n4, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 1, n4 - 2, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 1, n4 + 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 1, n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 1, n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 1, n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 1, n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5 + 1, n4 - 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5 + 1, n4 - 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5 + 1, n4 + 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5 + 1, n4 + 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 2, n4, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 2, n4, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 2, n4 - 2, n6, 2);
                    c_g.setBlockAndMetadata(n2, n3 + n5 + 2, n4 + 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 2, n4 + 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 2, n4 + 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 2, n4 + 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 2, n4 + 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 2, n4 - 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 2, n4 - 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 2, n4 - 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 2, n4 - 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 2, n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 2, n3 + n5 + 2, n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 2, n4 + 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 2, n3 + n5 + 2, n4 - 1, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5 + 2, n4 - 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5 + 2, n4 - 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 + 1, n3 + n5 + 2, n4 + 2, n6, 2);
                    c_g.setBlockAndMetadata(n2 - 1, n3 + n5 + 2, n4 + 2, n6, 2);
                }
                c_g.setBlockAndMetadata(n2 + 1, n3 + n8 / 2, n4, Block.flowerStem.at, 0);
                c_g.setBlockAndMetadata(n2 - 1, n3 + n8 / 2, n4, Block.flowerStem.at, 0);
                c_g.setBlockAndMetadata(n2, n3 + n8 / 2, n4 + 1, Block.flowerStem.at, 0);
                c_g.setBlockAndMetadata(n2, n3 + n8 / 2, n4 - 1, Block.flowerStem.at, 0);
                c_g.setBlockAndMetadata(n2 + 2, n3 + n8 / 2 + 1, n4, Block.flowerStem.at, 0);
                c_g.setBlockAndMetadata(n2 - 2, n3 + n8 / 2 + 1, n4, Block.flowerStem.at, 0);
                c_g.setBlockAndMetadata(n2, n3 + n8 / 2 + 1, n4 + 2, Block.flowerStem.at, 0);
                c_g.setBlockAndMetadata(n2, n3 + n8 / 2 + 1, n4 - 2, Block.flowerStem.at, 0);
                this.cantGrow = false;
                return true;
            }
            this.cantGrow = true;
            return false;
        }
        this.cantGrow = true;
        return false;
    }

    private void generateVines(World c_g, int n, int n2, int n3, int n4) {
        c_g.setBlockAndMetadata(n, n2, n3, Block.vine.at, n4);
        int n5 = 4;
        while (c_g.a(n, --n2, n3) == 0 && n5 > 0) {
            c_g.setBlockAndMetadata(n, n2, n3, Block.vine.at, n4);
            --n5;
        }
        return;
    }

    public boolean growSwampTrees(World c_g, Random random, int n, int n2, int n3) {
        int n4 = random.nextInt(4) + 5;
        while (c_g.f(n, n2 - 1, n3) == net.minecraft.a.a.d.Material.f) {
            --n2;
        }
        boolean bl = true;
        if (n2 >= 1 && n2 + n4 + 1 <= c_g.c) {
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            for (n9 = n2; n9 <= n2 + 1 + n4; ++n9) {
                n8 = 1;
                if (n9 == n2) {
                    n8 = 0;
                }
                if (n9 >= n2 + 1 + n4 - 2) {
                    n8 = 3;
                }
                for (n7 = n - n8; n7 <= n + n8 && bl; ++n7) {
                    for (n6 = n3 - n8; n6 <= n3 + n8 && bl; ++n6) {
                        if (n9 >= 0 && n9 < c_g.c && n7 > 0 && n7 < c_g.a && n6 > 0 && n6 < c_g.b) {
                            n5 = c_g.a(n7, n9, n6);
                            if (n5 == 0 || n5 == Block.z.at) continue;
                            if (n5 != Block.q.at && n5 != Block.p.at) {
                                bl = false;
                                continue;
                            }
                            if (n9 <= n2) continue;
                            bl = false;
                            continue;
                        }
                        bl = false;
                    }
                }
            }
            if (!bl) {
                return false;
            }
            n9 = c_g.a(n, n2 - 1, n3);
            if ((n9 == Block.j.at || n9 == Block.k.at) && n2 < c_g.c - n4 - 1) {
                int n10;
                c_g.a(n, n2 - 1, n3, Block.k.at);
                for (n10 = n2 - 3 + n4; n10 <= n2 + n4; ++n10) {
                    n7 = n10 - (n2 + n4);
                    n6 = 2 - n7 / 2;
                    for (n5 = n - n6; n5 <= n + n6; ++n5) {
                        n8 = n5 - n;
                        for (int i = n3 - n6; i <= n3 + n6; ++i) {
                            int n11 = i - n3;
                            if (Math.abs(n8) == n6 && Math.abs(n11) == n6 && (random.nextInt(2) == 0 || n7 == 0) || Block.e[c_g.a(n5, n10, i)] || this.a(n5, n10, i) == Block.portal.at) continue;
                            c_g.a(n5, n10, i, Block.z.at);
                        }
                    }
                }
                for (n10 = 0; n10 < n4; ++n10) {
                    n7 = c_g.a(n, n2 + n10, n3);
                    if (n7 != 0 && n7 != Block.z.at && n7 != Block.p.at && n7 != Block.q.at) continue;
                    c_g.a(n, n2 + n10, n3, Block.y.at);
                }
                for (n10 = n2 - 3 + n4; n10 <= n2 + n4; ++n10) {
                    n7 = n10 - (n2 + n4);
                    n6 = 2 - n7 / 2;
                    for (n5 = n - n6; n5 <= n + n6; ++n5) {
                        for (n8 = n3 - n6; n8 <= n3 + n6; ++n8) {
                            if (c_g.a(n5, n10, n8) != Block.z.at) continue;
                            if (random.nextInt(4) == 0 && c_g.a(n5 - 1, n10, n8) == 0) {
                                this.generateVines(c_g, n5 - 1, n10, n8, 4);
                            }
                            if (random.nextInt(4) == 0 && c_g.a(n5 + 1, n10, n8) == 0) {
                                this.generateVines(c_g, n5 + 1, n10, n8, 5);
                            }
                            if (random.nextInt(4) == 0 && c_g.a(n5, n10, n8 - 1) == 0) {
                                this.generateVines(c_g, n5, n10, n8 - 1, 2);
                            }
                            if (random.nextInt(4) != 0 || c_g.a(n5, n10, n8 + 1) != 0) continue;
                            this.generateVines(c_g, n5, n10, n8 + 1, 3);
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean growTrees(int n, int n2, int n3, int n4) {
        int n5 = this.q.nextInt(3) + 4;
        if (n4 == 2) {
            n5 = this.q.nextInt(3) + 6;
        }
        boolean bl = true;
        if (n2 > 0 && n2 + n5 + 1 <= this.c) {
            int n6;
            int n7;
            int n8;
            int n9;
            for (n9 = n2; n9 <= n2 + 1 + n5; ++n9) {
                n8 = 1;
                if (n9 == n2) {
                    n8 = 0;
                }
                if (n9 >= n2 + 1 + n5 - 2) {
                    n8 = 2;
                }
                for (n7 = n - n8; n7 <= n + n8 && bl; ++n7) {
                    for (n6 = n3 - n8; n6 <= n3 + n8 && bl; ++n6) {
                        if (n7 >= 0 && n9 >= 0 && n6 >= 0 && n7 < this.a && n9 < this.c && n6 < this.b) {
                            if ((this.d[(n9 * this.b + n6) * this.a + n7] & 0xFF) == 0) continue;
                            bl = false;
                            continue;
                        }
                        bl = false;
                    }
                }
            }
            if (!bl) {
                return false;
            }
            n9 = this.d[((n2 - 1) * this.b + n3) * this.a + n] & 0xFF;
            if ((n9 == Block.j.at || n9 == Block.k.at) && n2 < this.c - n5 - 1) {
                this.b(n, n2 - 1, n3, Block.k.at);
                for (n8 = n2 - 3 + n5; n8 <= n2 + n5; ++n8) {
                    n7 = n8 - (n2 + n5);
                    n6 = 1 - n7 / 2;
                    for (int i = n - n6; i <= n + n6; ++i) {
                        int n10 = i - n;
                        block9: for (n9 = n3 - n6; n9 <= n3 + n6; ++n9) {
                            int n11 = n9 - n3;
                            if (Math.abs(n10) == n6 && Math.abs(n11) == n6 && (this.q.nextInt(2) == 0 || n7 == 0) || Block.e[this.a(i, n8, n9)] || this.a(i, n8, n9) == Block.portal.at || n4 == 3) continue;
                            switch (n4) {
                                case 1: {
                                    this.setBlockAndMetadataWithNotify(i, n8, n9, Block.z.at, this.q.nextInt(2) + 1);
                                    continue block9;
                                }
                                case 2: {
                                    this.setBlockAndMetadataWithNotify(i, n8, n9, Block.z.at, 3);
                                    continue block9;
                                }
                                default: {
                                    this.setBlockAndMetadataWithNotify(i, n8, n9, Block.z.at, n4);
                                }
                            }
                        }
                    }
                }
                for (n8 = 0; n8 < n5; ++n8) {
                    if (Block.e[this.a(n, n2 + n8, n3)]) continue;
                    if (n4 == 2) {
                        this.setBlockAndMetadataWithNotify(n, n2 + n8, n3, Block.y.at, 1);
                        continue;
                    }
                    this.b(n, n2 + n8, n3, Block.y.at);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean growCaveTrees(int n, int n2, int n3) {
        int n4 = this.q.nextInt(2) + 3;
        boolean bl = true;
        if (n2 > 0 && n2 + n4 + 1 <= this.c) {
            int n5;
            int n6;
            int n7;
            for (n7 = n2; n7 <= n2 + 1 + n4; ++n7) {
                n6 = 1;
                if (n7 >= n2 + 1 + n4 - 2) {
                    n6 = 2;
                }
                for (n5 = n - n6; n5 <= n + n6 && bl; ++n5) {
                    for (int i = n3 - n6; i <= n3 + n6 && bl; ++i) {
                        if (n5 >= 0 && n7 >= 0 && i >= 0 && n5 < this.a && n7 < this.c && i < this.b) {
                            if ((this.d[(n7 * this.b + i) * this.a + n5] & 0xFF) == 0) continue;
                            bl = false;
                            continue;
                        }
                        bl = false;
                    }
                }
            }
            if (!bl) {
                return false;
            }
            n7 = this.d[((n2 - 1) * this.b + n3) * this.a + n] & 0xFF;
            if ((n7 == Block.j.at || n7 == Block.k.at || n7 == Block.moss.at) && n2 < this.c - n4 - 1) {
                this.b(n, n2 - 1, n3, Block.k.at);
                int n8 = 2;
                if (n4 == 4) {
                    n8 = 3;
                }
                for (n6 = n2 - n8 + n4; n6 <= n2 + n4; ++n6) {
                    n5 = n6 - (n2 + n4);
                    for (int i = n - 1; i <= n + 1; ++i) {
                        int n9 = i - n;
                        for (n7 = n3 - 1; n7 <= n3 + 1; ++n7) {
                            int n10 = n7 - n3;
                            if (n5 != -1 && (n5 != -2 || n4 != 4) && Math.abs(n9) == 1 && Math.abs(n10) == 1) continue;
                            this.setBlockAndMetadataWithNotify(i, n6, n7, Block.z.at, 5);
                        }
                    }
                }
                for (n6 = 0; n6 < n4; ++n6) {
                    if (Block.e[this.a(n, n2 + n6, n3)]) continue;
                    this.setBlockAndMetadataWithNotify(n, n2 + n6, n3, Block.y.at, 3);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean growPalmTrees(int n, int n2, int n3) {
        int n4 = this.I.nextInt(3) + 6;
        int n5 = this.I.nextInt(3) - 1;
        int n6 = this.I.nextInt(2);
        int n7 = n4 - 6;
        boolean bl = true;
        if (n2 > 0 && n2 + n4 + 1 <= this.c) {
            int n8;
            int n9;
            for (n9 = n2; n9 <= n2 + 1 + n4; ++n9) {
                n8 = 1;
                if (n9 == n2) {
                    n8 = 0;
                }
                if (n9 >= n2 + 1 + n4 - 1) {
                    n8 = 3;
                }
                for (int i = n - n8; i <= n + n8 && bl; ++i) {
                    for (int j = n3 - n8; j <= n3 + n8 && bl; ++j) {
                        if (i >= 0 && n9 >= 0 && j >= 0 && i < this.a && n9 < this.c && j < this.b) {
                            if ((this.d[(n9 * this.b + j) * this.a + i] & 0xFF) == 0) continue;
                            bl = false;
                            continue;
                        }
                        bl = false;
                    }
                }
            }
            if (!bl) {
                return false;
            }
            n9 = this.d[((n2 - 1) * this.b + n3) * this.a + n] & 0xFF;
            if ((n9 == Block.j.at || n9 == Block.k.at) && n2 < this.c - n4 - 1) {
                int n10;
                int n11;
                this.b(n, n2 - 1, n3, Block.k.at);
                if (n5 != 0) {
                    this.b(n, n2 - 1, n3 + 1 * n5, Block.k.at);
                    this.b(n + 1 * n5, n2 - 1, n3, Block.k.at);
                    this.b(n, n2 - 1, n3 - 1 * n5, Block.k.at);
                    this.b(n - 1 * n5, n2 - 1, n3, Block.k.at);
                }
                n8 = n + 2 * n5;
                int n12 = n2 + n4;
                int n13 = n3;
                if (n6 == 1) {
                    n8 = n;
                    n13 = n3 + 2 * n5;
                }
                this.setBlockAndMetadataWithNotify(n8, n12, n13, Block.z.at, 4);
                this.setBlockAndMetadataWithNotify(n8, n12 + 1, n13, Block.z.at, 4);
                for (n11 = 1; n11 <= 3; ++n11) {
                    n10 = n12;
                    if (n11 == 3) {
                        --n10;
                    }
                    this.setBlockAndMetadataWithNotify(n8 + n11, n10, n13 - n11, Block.z.at, 4);
                    this.setBlockAndMetadataWithNotify(n8 + n11, n10, n13 + n11, Block.z.at, 4);
                    this.setBlockAndMetadataWithNotify(n8 - n11, n10, n13 - n11, Block.z.at, 4);
                    this.setBlockAndMetadataWithNotify(n8 - n11, n10, n13 + n11, Block.z.at, 4);
                }
                this.setBlockAndMetadataWithNotify(n8 + 1, n12 - 1, n13, Block.z.at, 4);
                this.setBlockAndMetadataWithNotify(n8 - 1, n12 - 1, n13, Block.z.at, 4);
                this.setBlockAndMetadataWithNotify(n8, n12 - 1, n13 + 1, Block.z.at, 4);
                this.setBlockAndMetadataWithNotify(n8, n12 - 1, n13 - 1, Block.z.at, 4);
                for (n11 = 1; n11 <= 4; ++n11) {
                    n10 = n12;
                    if (n11 == 4) {
                        --n10;
                    }
                    this.setBlockAndMetadataWithNotify(n8 + n11, n10, n13, Block.z.at, 4);
                    this.setBlockAndMetadataWithNotify(n8 - n11, n10, n13, Block.z.at, 4);
                    this.setBlockAndMetadataWithNotify(n8, n10, n13 + n11, Block.z.at, 4);
                    this.setBlockAndMetadataWithNotify(n8, n10, n13 - n11, Block.z.at, 4);
                }
                this.setBlockAndMetadataWithNotify(n, n2 + n7, n3, Block.y.at, 2);
                for (n11 = 0; n11 < n4; ++n11) {
                    n10 = n11 / 2;
                    if (n10 > 2) {
                        n10 = 2;
                    }
                    int n14 = 0;
                    if (n4 == 8 && n5 != 0) {
                        n14 = 1;
                    }
                    if (n6 == 1) {
                        this.setBlockAndMetadataWithNotify(n, n2 + n11 + n14, n3 + n10 * n5, Block.y.at, 2);
                    } else {
                        this.setBlockAndMetadataWithNotify(n + n10 * n5, n2 + n11 + n14, n3, Block.y.at, 2);
                    }
                    if (n5 == 0) continue;
                    this.setBlockAndMetadataWithNotify(n, n2, n3 + 1 * n5, Block.y.at, 2);
                    this.setBlockAndMetadataWithNotify(n + 1 * n5, n2, n3, Block.y.at, 2);
                    this.setBlockAndMetadataWithNotify(n, n2, n3 - 1 * n5, Block.y.at, 2);
                    this.setBlockAndMetadataWithNotify(n - 1 * n5, n2, n3, Block.y.at, 2);
                    this.setBlockAndMetadataWithNotify(n, n2, n3, Block.y.at, 2);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean growCorals(int n, int n2, int n3) {
        int n4 = this.I.nextInt(3) + 4;
        int n5 = this.I.nextInt(4);
        int n6 = this.I.nextInt(4) - 1;
        int n7 = n4 - 6;
        boolean bl = true;
        if (n2 > 0 && n2 + n4 + 1 <= this.c) {
            int n8;
            int n9;
            for (n9 = n2; n9 <= n2 + 1 + n4; ++n9) {
                n8 = 1;
                if (n9 == n2) {
                    n8 = 0;
                }
                if (n9 >= n2 + 1 + n4 - 1) {
                    n8 = 3;
                }
                for (int i = n - n8; i <= n + n8 && bl; ++i) {
                    for (int j = n3 - n8; j <= n3 + n8 && bl; ++j) {
                        if (i >= 0 && n9 >= 0 && j >= 0 && i < this.a && n9 < this.c && j < this.b) {
                            if ((this.d[(n9 * this.b + j) * this.a + i] & 0xFF) == Block.q.at) continue;
                            bl = false;
                            continue;
                        }
                        bl = false;
                    }
                }
            }
            if (!bl) {
                return false;
            }
            n9 = this.d[((n2 - 1) * this.b + n3) * this.a + n] & 0xFF;
            if (n9 == Block.coral.at && n2 < this.c - n4 - 1) {
                this.setBlockAndMetadataWithNotify(n, n2 + n7, n3, Block.coral.at, n5);
                for (n8 = 0; n8 < n4; ++n8) {
                    int n10 = n8 / 2;
                    if (n6 == 0) {
                        this.setBlockAndMetadataWithNotify(n, n2 + n7 + 1, n3 + 1, Block.coral.at, n5);
                        this.setBlockAndMetadataWithNotify(n + 1, n2 + n7 + 1, n3, Block.coral.at, n5);
                        this.setBlockAndMetadataWithNotify(n, n2 + n8, n3 + n10 + 1, Block.coral.at, n5);
                        this.setBlockAndMetadataWithNotify(n + n10 + 1, n2 + n8, n3, Block.coral.at, n5);
                        continue;
                    }
                    if (n6 == 2) {
                        this.setBlockAndMetadataWithNotify(n, n2 + n7 + 1, n3 - 1, Block.coral.at, n5);
                        this.setBlockAndMetadataWithNotify(n - 1, n2 + n7 + 1, n3, Block.coral.at, n5);
                        this.setBlockAndMetadataWithNotify(n, n2 + n8, n3 - n10 - 1, Block.coral.at, n5);
                        this.setBlockAndMetadataWithNotify(n - n10 - 1, n2 + n8, n3, Block.coral.at, n5);
                        continue;
                    }
                    this.setBlockAndMetadataWithNotify(n, n2 + n8, n3 + n10 - n6, Block.coral.at, n5);
                    this.setBlockAndMetadataWithNotify(n + n10 - n6, n2 + n8, n3, Block.coral.at, n5);
                    this.setBlockAndMetadataWithNotify(n, n2 + n8, n3 - n10 - n6, Block.coral.at, n5);
                    this.setBlockAndMetadataWithNotify(n - n10 - n6, n2 + n8, n3, Block.coral.at, n5);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean growSpikes(int n, int n2, int n3) {
        int n4 = this.q.nextInt(20) + 4;
        int n5 = this.q.nextInt(16) + 2;
        int n6 = this.q.nextInt(18) + 3;
        int n7 = this.q.nextInt(17) + 3;
        int n8 = this.q.nextInt(17) + 2;
        int n9 = this.q.nextInt(19) + 1;
        int n10 = this.q.nextInt(15) + 4;
        int n11 = this.q.nextInt(16) + 3;
        int n12 = this.q.nextInt(17) + 4;
        int n13 = this.q.nextInt(13) + 4;
        int n14 = this.q.nextInt(12) + 3;
        int n15 = this.q.nextInt(14) + 1;
        int n16 = this.q.nextInt(12) + 4;
        boolean bl = true;
        if (n2 > 0 && n2 + n4 + 1 <= this.c) {
            int n17;
            int n18;
            for (n18 = n2; n18 <= n2 + 1 + n4; ++n18) {
                n17 = 1;
                if (n18 == n2) {
                    n17 = 0;
                }
                if (n18 >= n2 + 1 + n4 - 2) {
                    n17 = 2;
                }
                for (int i = n - n17; i <= n + n17 && bl; ++i) {
                    for (int j = n3 - n17; j <= n3 + n17 && bl; ++j) {
                        if (i >= 0 && n18 >= 0 && j >= 0 && i < this.a && n18 < this.c && j < this.b) {
                            if ((this.d[(n18 * this.b + j) * this.a + i] & 0xFF) == 0) continue;
                            bl = false;
                            continue;
                        }
                        bl = false;
                    }
                }
            }
            if (!bl) {
                return false;
            }
            n18 = this.d[((n2 - 1) * this.b + n3) * this.a + n] & 0xFF;
            if ((n18 == Block.s.at || n18 == Block.r.at) && n2 < this.c - n4 - 1) {
                for (n17 = -1; n17 < 2; ++n17) {
                    for (int i = -1; i < 2; ++i) {
                        this.b(n + n17, n2 - 1, n3 + i, Block.ae.at);
                    }
                }
                for (n17 = 0; n17 < n4; ++n17) {
                    if (Block.e[this.a(n, n2 + n17, n3)]) continue;
                    this.b(n, n2 + n17, n3, Block.ae.at);
                }
                for (n17 = 0; n17 < n5; ++n17) {
                    if (Block.e[this.a(n + 1, n2 + n17, n3)]) continue;
                    this.b(n + 1, n2 + n17, n3, Block.ae.at);
                }
                for (n17 = 0; n17 < n6; ++n17) {
                    if (Block.e[this.a(n, n2 + n17, n3 + 1)]) continue;
                    this.b(n, n2 + n17, n3 + 1, Block.ae.at);
                }
                for (n17 = 0; n17 < n7; ++n17) {
                    if (Block.e[this.a(n, n2 + n17, n3 - 1)]) continue;
                    this.b(n, n2 + n17, n3 - 1, Block.ae.at);
                }
                for (n17 = 0; n17 < n8; ++n17) {
                    if (Block.e[this.a(n - 1, n2 + n17, n3)]) continue;
                    this.b(n - 1, n2 + n17, n3, Block.ae.at);
                }
                for (n17 = 0; n17 < n9; ++n17) {
                    if (Block.e[this.a(n - 1, n2 + n17, n3 - 1)]) continue;
                    this.b(n - 1, n2 + n17, n3 - 1, Block.ae.at);
                }
                for (n17 = 0; n17 < n10; ++n17) {
                    if (Block.e[this.a(n + 1, n2 + n17, n3 + 1)]) continue;
                    this.b(n + 1, n2 + n17, n3 + 1, Block.ae.at);
                }
                for (n17 = 0; n17 < n11; ++n17) {
                    if (Block.e[this.a(n - 1, n2 + n17, n3 + 1)]) continue;
                    this.b(n - 1, n2 + n17, n3 + 1, Block.ae.at);
                }
                for (n17 = 0; n17 < n12; ++n17) {
                    if (Block.e[this.a(n + 1, n2 + n17, n3 - 1)]) continue;
                    this.b(n + 1, n2 + n17, n3 - 1, Block.ae.at);
                }
                for (n17 = 0; n17 < n13; ++n17) {
                    if (Block.e[this.a(n + 2, n2 + n17, n3)]) continue;
                    this.b(n + 2, n2 - 1 + n17, n3, Block.ae.at);
                }
                for (n17 = 0; n17 < n14; ++n17) {
                    if (Block.e[this.a(n - 2, n2 + n17, n3)]) continue;
                    this.b(n - 2, n2 - 1 + n17, n3, Block.ae.at);
                }
                for (n17 = 0; n17 < n15; ++n17) {
                    if (Block.e[this.a(n, n2 + n17, n3 + 2)]) continue;
                    this.b(n, n2 - 1 + n17, n3 + 2, Block.ae.at);
                }
                for (n17 = 0; n17 < n16; ++n17) {
                    if (Block.e[this.a(n, n2 + n17, n3 - 2)]) continue;
                    this.b(n, n2 - 1 + n17, n3 - 2, Block.ae.at);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void growPalmTree(int n, int n2, int n3) {
        int n4 = this.I.nextInt(3) + 6;
        int n5 = this.I.nextInt(3) - 1;
        int n6 = this.I.nextInt(2);
        int n7 = n4 - 6;
        boolean bl = true;
        if (n2 > 0 && n2 + n4 + 1 <= this.c) {
            int n8;
            int n9;
            for (n9 = n2; n9 <= n2 + 1 + n4; ++n9) {
                n8 = 1;
                if (n9 == n2) {
                    n8 = 0;
                }
                if (n9 >= n2 + 1 + n4 - 1) {
                    n8 = 3;
                }
                for (int i = n - n8; i <= n + n8 && bl; ++i) {
                    for (int j = n3 - n8; j <= n3 + n8 && bl; ++j) {
                        if (i >= 0 && n9 >= 0 && j >= 0 && i < this.a && n9 < this.c && j < this.b) {
                            if ((this.d[(n9 * this.b + j) * this.a + i] & 0xFF) == 0) continue;
                            bl = false;
                            this.cantGrow = true;
                            continue;
                        }
                        bl = false;
                        this.cantGrow = true;
                    }
                }
            }
            if (!bl) {
                this.cantGrow = true;
                return;
            }
            n9 = this.d[((n2 - 1) * this.b + n3) * this.a + n] & 0xFF;
            if ((n9 == Block.j.at || n9 == Block.k.at) && n2 < this.c - n4 - 1) {
                int n10;
                int n11;
                this.b(n, n2 - 1, n3, Block.k.at);
                n8 = n + 2 * n5;
                int n12 = n2 + n4;
                int n13 = n3;
                if (n6 == 1) {
                    n8 = n;
                    n13 = n3 + 2 * n5;
                }
                this.setBlockAndMetadataWithNotify(n8, n12, n13, Block.z.at, 4);
                this.setBlockAndMetadataWithNotify(n8, n12 + 1, n13, Block.z.at, 4);
                for (n11 = 1; n11 <= 3; ++n11) {
                    n10 = n12;
                    if (n11 == 3) {
                        --n10;
                    }
                    this.setBlockAndMetadataWithNotify(n8 + n11, n10, n13 - n11, Block.z.at, 4);
                    this.setBlockAndMetadataWithNotify(n8 + n11, n10, n13 + n11, Block.z.at, 4);
                    this.setBlockAndMetadataWithNotify(n8 - n11, n10, n13 - n11, Block.z.at, 4);
                    this.setBlockAndMetadataWithNotify(n8 - n11, n10, n13 + n11, Block.z.at, 4);
                }
                this.setBlockAndMetadataWithNotify(n8 + 1, n12 - 1, n13, Block.z.at, 4);
                this.setBlockAndMetadataWithNotify(n8 - 1, n12 - 1, n13, Block.z.at, 4);
                this.setBlockAndMetadataWithNotify(n8, n12 - 1, n13 + 1, Block.z.at, 4);
                this.setBlockAndMetadataWithNotify(n8, n12 - 1, n13 - 1, Block.z.at, 4);
                for (n11 = 1; n11 <= 4; ++n11) {
                    n10 = n12;
                    if (n11 == 4) {
                        --n10;
                    }
                    this.setBlockAndMetadataWithNotify(n8 + n11, n10, n13, Block.z.at, 4);
                    this.setBlockAndMetadataWithNotify(n8 - n11, n10, n13, Block.z.at, 4);
                    this.setBlockAndMetadataWithNotify(n8, n10, n13 + n11, Block.z.at, 4);
                    this.setBlockAndMetadataWithNotify(n8, n10, n13 - n11, Block.z.at, 4);
                }
                this.setBlockAndMetadataWithNotify(n, n2 + n7, n3, Block.y.at, 2);
                for (n11 = 0; n11 < n4; ++n11) {
                    n10 = n11 / 2;
                    if (n10 > 2) {
                        n10 = 2;
                    }
                    int n14 = 0;
                    if (n4 == 8 && n5 != 0) {
                        n14 = 1;
                    }
                    if (n6 == 1) {
                        this.setBlockAndMetadataWithNotify(n, n2 + n11 + n14, n3 + n10 * n5, Block.y.at, 2);
                    } else {
                        this.setBlockAndMetadataWithNotify(n + n10 * n5, n2 + n11 + n14, n3, Block.y.at, 2);
                    }
                    if (n5 == 0) continue;
                    this.setBlockAndMetadataWithNotify(n, n2, n3 + 1 * n5, Block.y.at, 2);
                    this.setBlockAndMetadataWithNotify(n + 1 * n5, n2, n3, Block.y.at, 2);
                    this.setBlockAndMetadataWithNotify(n, n2, n3 - 1 * n5, Block.y.at, 2);
                    this.setBlockAndMetadataWithNotify(n - 1 * n5, n2, n3, Block.y.at, 2);
                    this.setBlockAndMetadataWithNotify(n, n2, n3, Block.y.at, 2);
                }
                this.cantGrow = false;
            } else {
                this.cantGrow = true;
            }
        } else {
            this.cantGrow = true;
        }
    }

    public void growTree(int n, int n2, int n3, int n4) {
        int n5 = this.q.nextInt(3) + 4;
        if (n4 == 2) {
            n5 = this.q.nextInt(3) + 6;
        }
        boolean bl = true;
        if (n2 > 0 && n2 + n5 + 1 <= this.c) {
            int n6;
            int n7;
            int n8;
            int n9;
            for (n9 = n2; n9 <= n2 + 1 + n5; ++n9) {
                n8 = 1;
                if (n9 == n2) {
                    n8 = 0;
                }
                if (n9 >= n2 + 1 + n5 - 2) {
                    n8 = 2;
                }
                for (n7 = n - n8; n7 <= n + n8 && bl; ++n7) {
                    for (n6 = n3 - n8; n6 <= n3 + n8 && bl; ++n6) {
                        if (n7 >= 0 && n9 >= 0 && n6 >= 0 && n7 < this.a && n9 < this.c && n6 < this.b) {
                            if ((this.d[(n9 * this.b + n6) * this.a + n7] & 0xFF) == 0) continue;
                            bl = false;
                            this.cantGrow = true;
                            continue;
                        }
                        bl = false;
                        this.cantGrow = true;
                    }
                }
            }
            if (!bl) {
                this.cantGrow = true;
                return;
            }
            n9 = this.d[((n2 - 1) * this.b + n3) * this.a + n] & 0xFF;
            if ((n9 == Block.j.at || n9 == Block.k.at) && n2 < this.c - n5 - 1) {
                this.b(n, n2 - 1, n3, Block.k.at);
                for (n8 = n2 - 3 + n5; n8 <= n2 + n5; ++n8) {
                    n7 = n8 - (n2 + n5);
                    n6 = 1 - n7 / 2;
                    for (int i = n - n6; i <= n + n6; ++i) {
                        int n10 = i - n;
                        for (n9 = n3 - n6; n9 <= n3 + n6; ++n9) {
                            int n11 = n9 - n3;
                            if (Math.abs(n10) == n6 && Math.abs(n11) == n6 && (this.q.nextInt(2) == 0 || n7 == 0) || Block.e[this.a(i, n8, n9)] || this.a(i, n8, n9) == Block.portal.at) continue;
                            if (n4 == 1) {
                                this.setBlockAndMetadataWithNotify(i, n8, n9, Block.z.at, this.q.nextInt(2) + 1);
                                continue;
                            }
                            if (n4 == 2) {
                                this.setBlockAndMetadataWithNotify(i, n8, n9, Block.z.at, 3);
                                continue;
                            }
                            this.setBlockAndMetadataWithNotify(i, n8, n9, Block.z.at, n4);
                        }
                    }
                }
                for (n8 = 0; n8 < n5; ++n8) {
                    if (Block.e[this.a(n, n2 + n8, n3)]) continue;
                    if (n4 == 2) {
                        this.setBlockAndMetadataWithNotify(n, n2 + n8, n3, Block.y.at, 1);
                        continue;
                    }
                    this.b(n, n2 + n8, n3, Block.y.at);
                }
                this.cantGrow = false;
            } else {
                this.cantGrow = true;
            }
        } else {
            this.cantGrow = true;
        }
    }

    public void growCaveTree(int n, int n2, int n3) {
        int n4 = this.q.nextInt(2) + 3;
        boolean bl = true;
        if (n2 > 0 && n2 + n4 + 1 <= this.c) {
            int n5;
            int n6;
            int n7;
            for (n7 = n2; n7 <= n2 + 1 + n4; ++n7) {
                n6 = 1;
                for (n5 = n - n6; n5 <= n + n6 && bl; ++n5) {
                    for (int i = n3 - n6; i <= n3 + n6 && bl; ++i) {
                        if (n5 >= 0 && n7 >= 0 && i >= 0 && n5 < this.a && n7 < this.c && i < this.b) {
                            if ((this.d[(n7 * this.b + i) * this.a + n5] & 0xFF) == 0) continue;
                            bl = false;
                            this.cantGrow = true;
                            continue;
                        }
                        bl = false;
                        this.cantGrow = true;
                    }
                }
            }
            if (!bl) {
                this.cantGrow = true;
                return;
            }
            n7 = this.d[((n2 - 1) * this.b + n3) * this.a + n] & 0xFF;
            if ((n7 == Block.j.at || n7 == Block.k.at) && n2 < this.c - n4 - 1) {
                this.b(n, n2 - 1, n3, Block.k.at);
                int n8 = 2;
                if (n4 == 4) {
                    n8 = 3;
                }
                for (n6 = n2 - n8 + n4; n6 <= n2 + n4; ++n6) {
                    n5 = n6 - (n2 + n4);
                    for (int i = n - 1; i <= n + 1; ++i) {
                        int n9 = i - n;
                        for (n7 = n3 - 1; n7 <= n3 + 1; ++n7) {
                            int n10 = n7 - n3;
                            if (n5 != -1 && (n5 != -2 || n4 != 4) && Math.abs(n9) == 1 && Math.abs(n10) == 1) continue;
                            this.setBlockAndMetadataWithNotify(i, n6, n7, Block.z.at, 5);
                        }
                    }
                }
                for (n6 = 0; n6 < n4; ++n6) {
                    if (Block.e[this.a(n, n2 + n6, n3)]) continue;
                    this.setBlockAndMetadataWithNotify(n, n2 + n6, n3, Block.y.at, 3);
                }
                this.cantGrow = false;
            } else {
                this.cantGrow = true;
            }
        } else {
            this.cantGrow = true;
        }
    }

    public void growLargeMushroom(int n, int n2, int n3, int n4) {
        int n5 = this.I.nextInt(3) + 4;
        boolean bl = true;
        if (n2 >= 1 && n2 + n5 + 1 < this.c) {
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            for (n10 = n2; n10 <= n2 + 1 + n5; ++n10) {
                n9 = 3;
                if (n10 <= n2 + 3) {
                    n9 = 0;
                }
                for (n8 = n - n9; n8 <= n + n9 && bl; ++n8) {
                    for (n7 = n3 - n9; n7 <= n3 + n9 && bl; ++n7) {
                        if (n10 >= 0 && n8 >= 0 && n7 >= 0 && n8 < this.a && n7 < this.b && n10 < this.c) {
                            n6 = this.a(n8, n10, n7);
                            if (n6 == 0 || n6 == Block.z.at || n6 == Block.B.at || n6 == Block.portal.at) continue;
                            bl = false;
                            continue;
                        }
                        bl = false;
                    }
                }
            }
            if (!bl) {
                this.cantGrow = true;
            } else {
                n10 = this.a(n, n2 - 1, n3);
                if (n10 != Block.mycelium.at) {
                    this.cantGrow = true;
                } else {
                    n9 = n2 + n5;
                    if (n4 == 1) {
                        n9 = n2 + n5 - 3;
                    }
                    if (n4 == 2) {
                        n9 = n2 + n5 - 1;
                    }
                    for (n8 = n9; n8 <= n2 + n5; ++n8) {
                        n7 = 1;
                        if (n8 < n2 + n5) {
                            ++n7;
                        }
                        if (n4 == 0 || n4 == 2) {
                            n7 = 3;
                        }
                        for (n6 = n - n7; n6 <= n + n7; ++n6) {
                            for (int i = n3 - n7; i <= n3 + n7; ++i) {
                                int n11 = 5;
                                if (n6 == n - n7) {
                                    --n11;
                                }
                                if (n6 == n + n7) {
                                    ++n11;
                                }
                                if (i == n3 - n7) {
                                    n11 -= 3;
                                }
                                if (i == n3 + n7) {
                                    n11 += 3;
                                }
                                if (!(n4 != 0 && n4 != 2 && n8 >= n2 + n5 || n6 != n - n7 && n6 != n + n7) && (i == n3 - n7 || i == n3 + n7)) continue;
                                if (n4 == 2 && n8 == n2 + n5 && (n == n6 + 3 || n == n6 - 3 || n3 == i + 3 || n3 == i - 3)) {
                                    n11 = 0;
                                }
                                if (n11 == 5 && n8 < n2 + n5) {
                                    n11 = 0;
                                }
                                if (n11 == 0 && n2 < n2 + n5 - 1 || Block.e[this.a(n6, n8, i)]) continue;
                                this.setBlockAndMetadata(n6, n8, i, Block.mushroomCap.at, n4);
                            }
                        }
                    }
                    for (n8 = 0; n8 < n5; ++n8) {
                        n7 = this.a(n, n2 + n8, n3);
                        if (Block.e[n7]) continue;
                        this.a(n, n2 + n8, n3, Block.mushroomStem.at);
                    }
                    this.a(n, n2 - 1, n3, Block.k.at);
                    this.cantGrow = false;
                }
            }
        } else {
            this.cantGrow = true;
        }
    }

    public boolean growLargeMushrooms(int n, int n2, int n3, int n4) {
        int n5 = this.I.nextInt(3) + 4;
        boolean bl = true;
        if (n2 >= 1 && n2 + n5 + 1 < this.c) {
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            for (n10 = n2; n10 <= n2 + 1 + n5; ++n10) {
                n9 = 3;
                if (n10 <= n2 + 3) {
                    n9 = 0;
                }
                for (n8 = n - n9; n8 <= n + n9 && bl; ++n8) {
                    for (n7 = n3 - n9; n7 <= n3 + n9 && bl; ++n7) {
                        if (n10 >= 0 && n8 >= 0 && n7 >= 0 && n8 < this.a && n7 < this.b && n10 < this.c) {
                            n6 = this.a(n8, n10, n7);
                            if (n6 == 0 || n6 == Block.z.at || n6 == Block.B.at || n6 == Block.portal.at) continue;
                            bl = false;
                            continue;
                        }
                        bl = false;
                    }
                }
            }
            if (!bl) {
                return false;
            }
            n10 = this.a(n, n2 - 1, n3);
            if (n10 != Block.mycelium.at) {
                return false;
            }
            n9 = n2 + n5;
            if (n4 == 1) {
                n9 = n2 + n5 - 3;
            }
            if (n4 == 2) {
                n9 = n2 + n5 - 1;
            }
            for (n8 = n9; n8 <= n2 + n5; ++n8) {
                n7 = 1;
                if (n8 < n2 + n5) {
                    ++n7;
                }
                if (n4 == 0 || n4 == 2) {
                    n7 = 3;
                }
                for (n6 = n - n7; n6 <= n + n7; ++n6) {
                    for (int i = n3 - n7; i <= n3 + n7; ++i) {
                        int n11 = 5;
                        if (n6 == n - n7) {
                            --n11;
                        }
                        if (n6 == n + n7) {
                            ++n11;
                        }
                        if (i == n3 - n7) {
                            n11 -= 3;
                        }
                        if (i == n3 + n7) {
                            n11 += 3;
                        }
                        if (!(n4 != 0 && n4 != 2 && n8 >= n2 + n5 || n6 != n - n7 && n6 != n + n7) && (i == n3 - n7 || i == n3 + n7)) continue;
                        if (n4 == 2 && n8 == n2 + n5 && (n == n6 + 3 || n == n6 - 3 || n3 == i + 3 || n3 == i - 3)) {
                            n11 = 0;
                        }
                        if (n11 == 5 && n8 < n2 + n5) {
                            n11 = 0;
                        }
                        if (n11 == 0 && n2 < n2 + n5 - 1 || Block.e[this.a(n6, n8, i)]) continue;
                        this.setBlockAndMetadata(n6, n8, i, Block.mushroomCap.at, n4);
                    }
                }
            }
            for (n8 = 0; n8 < n5; ++n8) {
                n7 = this.a(n, n2 + n8, n3);
                if (Block.e[n7]) continue;
                this.a(n, n2 + n8, n3, Block.mushroomStem.at);
            }
            this.a(n, n2 - 1, n3, Block.k.at);
            return true;
        }
        return false;
    }

    public boolean growCactus(int n, int n2, int n3) {
        int n4;
        int n5 = this.q.nextInt(3) + 1;
        boolean bl = true;
        for (int i = n2; i <= n2 + 1 + n5; ++i) {
            n4 = 1;
            if (i == n2) {
                n4 = 0;
            }
            if (i >= n2 + 1 + n5 - 2) {
                n4 = 2;
            }
            for (int j = n - n4; j <= n + n4 && bl; ++j) {
                for (int k = n3 - n4; k <= n3 + n4 && bl; ++k) {
                    if (j >= 0 && i >= 0 && k >= 0 && j < this.a && i < this.c && k < this.b) {
                        if ((this.d[(i * this.b + k) * this.a + j] & 0xFF) == 0) continue;
                        bl = false;
                        continue;
                    }
                    bl = false;
                }
            }
        }
        if (!bl) {
            return false;
        }
        if ((this.d[((n2 - 1) * this.b + n3) * this.a + n] & 0xFF) == Block.t.at && n2 < this.c - n5 - 1) {
            for (n4 = 0; n4 < n5; ++n4) {
                if (!Block.cactus.canBlockStay(this, n, n2 + n4, n3)) continue;
                this.a(n, n2 + n4, n3, Block.cactus.at);
            }
            return true;
        }
        return false;
    }

    public boolean growSeaweed(int n, int n2, int n3) {
        int n4 = this.q.nextInt(12) + 1;
        if (n2 < n4) {
            return false;
        }
        if (this.a(n, n2, n3) == Block.k.at && this.f(n, n2 + 1, n3) == net.minecraft.a.a.d.Material.f && n2 < this.c - n4 - 1) {
            for (int i = 0; i < n4; ++i) {
                if (!Block.seaweed.canBlockStay(this, n, n2 + i + 1, n3)) continue;
                this.a(n, n2 + i + 1, n3, Block.seaweed.at);
            }
            return true;
        }
        return false;
    }

    public boolean growCoralFans(int n, int n2, int n3) {
        int n4 = this.q.nextInt(12) + 1;
        if (n2 < n4) {
            return false;
        }
        if (this.a(n, n2, n3) == Block.coral.at && this.f(n, n2 + 1, n3) == net.minecraft.a.a.d.Material.f && n2 < this.c - n4 - 1) {
            for (int i = 0; i < n4; ++i) {
                if (!Block.coralFan.canBlockStay(this, n, n2 + i + 1, n3)) continue;
                this.setBlockAndMetadata(n, n2 + i + 1, n3, Block.coralFan.at, this.e(n, n2, n3));
            }
            return true;
        }
        return false;
    }

    public boolean growStalactites(int n, int n2, int n3) {
        int n4;
        int n5 = this.q.nextInt(5) + 1;
        boolean bl = true;
        for (int i = n2; i <= n2 + 1 + n5; ++i) {
            n4 = 1;
            if (i == n2) {
                n4 = 0;
            }
            if (i >= n2 + 1 + n5 - 2) {
                n4 = 2;
            }
            for (int j = n - n4; j <= n + n4 && bl; ++j) {
                for (int k = n3 - n4; k <= n3 + n4 && bl; ++k) {
                    if (j >= 0 && i >= 0 && k >= 0 && j < this.a && i < this.c && k < this.b) {
                        if ((this.d[(i * this.b + k) * this.a + j] & 0xFF) == 0) continue;
                        bl = false;
                        continue;
                    }
                    bl = false;
                }
            }
        }
        if (!bl) {
            return false;
        }
        if ((this.d[((n2 - 1) * this.b + n3) * this.a + n] & 0xFF) == Block.i.at && n2 < this.c - n5 - 1) {
            for (n4 = 0; n4 < n5; ++n4) {
                if (!Block.stalactite.canBlockStay(this, n, n2 + n4, n3)) continue;
                this.a(n, n2 + n4, n3, Block.stalactite.at);
                if (this.a((float)n, (float)(n2 - 1), (float)n3) && n5 > 1) {
                    this.setBlockMetadata(n, n2, n3, 0);
                    continue;
                }
                this.setBlockMetadata(n, n2, n3, 2);
            }
            for (n4 = 0; n4 < n5; ++n4) {
                if (this.a(n, n2 + n4 - 1, n3) != Block.stalactite.at || this.a(n, n2 + n4 + 1, n3) != Block.stalactite.at || n5 <= 2) continue;
                this.setBlockMetadata(n, n2 + n4, n3, 1);
            }
            return true;
        }
        return false;
    }

    public boolean growStalagmites(int n, int n2, int n3) {
        int n4;
        int n5 = this.q.nextInt(7) + 1;
        if (n2 < n5) {
            return false;
        }
        boolean bl = true;
        for (int i = n2; i <= n2 - 1 - n5; --i) {
            n4 = 2;
            if (i == n2) {
                n4 = 0;
            }
            for (int j = n - n4; j <= n + n4 && bl; ++j) {
                for (int k = n3 - n4; k <= n3 + n4 && bl; ++k) {
                    if (j >= 0 && i >= 0 && k >= 0 && j < this.a && i < this.c && k < this.b) {
                        if ((this.d[(i * this.b + k) * this.a + j] & 0xFF) == 0) continue;
                        bl = false;
                        continue;
                    }
                    bl = false;
                }
            }
        }
        if (!bl) {
            return false;
        }
        if ((this.d[((n2 - 1) * this.b + n3) * this.a + n] & 0xFF) == Block.i.at && n2 < this.c - n5 - 1) {
            if (this.a(n, n2 + 1, n3) == Block.i.at) {
                for (n4 = 0; n4 < n5; ++n4) {
                    if (this.a(n, n2 - n4, n3) != 0 || this.a(n, n2 - n4 - 1, n3) != 0) continue;
                    this.a(n, n2 - n4, n3, Block.stalactite.at);
                    this.setBlockMetadata(n, n2, n3, 4);
                }
            }
            for (n4 = 0; n4 < n5; ++n4) {
                if (this.a(n, n2 - n4 + 1, n3) == Block.stalactite.at && this.a(n, n2 - n4 - 1, n3) == Block.stalactite.at && n5 > 2) {
                    this.setBlockMetadata(n, n2 - n4, n3, 5);
                }
                if (!this.a((float)n, (float)(n2 - n4 + 1), (float)n3) || this.a(n, n2 - n4 - 1, n3) != Block.stalactite.at) continue;
                this.setBlockMetadata(n, n2 - n4, n3, 3);
            }
            return true;
        }
        return false;
    }

    public Entity i() {
        return this.y;
    }

    public boolean spawnEntityInWorld(Entity c_b) {
        this.chunkMap.addEntity(c_b);
        this.r.a(c_b);
        c_b.a(this);
        if (c_b instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)c_b;
            this.playerEntities.add(entityPlayer);
        }
        this.obtainEntitySkin(c_b);
        return true;
    }

    public void obtainEntitySkin(Entity c_b) {
        for (int i = 0; i < this.n.size(); ++i) {
            this.n.get(i).a(c_b);
        }
    }

    public void b(Entity c_b) {
        this.r.b(c_b);
        for (int i = 0; i < this.n.size(); ++i) {
            this.n.get(i).b(c_b);
        }
    }

    public void a(Entity c_b, float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        int n;
        int n2;
        int n3;
        int n4;
        float f8;
        float f9;
        float f10;
        int n5;
        int n6;
        int n7;
        this.a(f, f2, f3, "random.explode", 4.0f, (1.0f + (this.q.nextFloat() - this.q.nextFloat()) * 0.2f) * 0.7f);
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        float f11 = f4;
        for (n7 = 0; n7 < 16; ++n7) {
            for (n6 = 0; n6 < 16; ++n6) {
                for (n5 = 0; n5 < 16; ++n5) {
                    if (n7 != 0 && n7 != 15 && n6 != 0 && n6 != 15 && n5 != 0 && n5 != 15) continue;
                    f10 = (float)n7 / 15.0f * 2.0f - 1.0f;
                    float f12 = (float)n6 / 15.0f * 2.0f - 1.0f;
                    float f13 = (float)n5 / 15.0f * 2.0f - 1.0f;
                    float f14 = (float)Math.sqrt(f10 * f10 + f12 * f12 + f13 * f13);
                    f10 /= f14;
                    f12 /= f14;
                    f13 /= f14;
                    float f15 = f;
                    f9 = f2;
                    f8 = f3;
                    for (float f16 = f4 * (0.7f + this.q.nextFloat() * 0.6f); f16 > 0.0f; f16 -= 0.22500001f) {
                        n4 = (int)f15;
                        n3 = (int)f9;
                        n2 = (int)f8;
                        n = this.a(n4, n3, n2);
                        if (n > 0) {
                            f16 -= (Block.c[n].g() + 0.3f) * 0.3f;
                        }
                        if (f16 > 0.0f) {
                            int n8 = n4 + (n3 << 10) + (n2 << 10 << 10);
                            treeSet.add(n8);
                        }
                        f15 += f10 * 0.3f;
                        f9 += f12 * 0.3f;
                        f8 += f13 * 0.3f;
                    }
                }
            }
        }
        n7 = (int)(f - (f4 *= 2.0f) - 1.0f);
        n6 = (int)(f + f4 + 1.0f);
        n5 = (int)(f2 - f4 - 1.0f);
        int n9 = (int)(f2 + f4 + 1.0f);
        int n10 = (int)(f3 - f4 - 1.0f);
        int n11 = (int)(f3 + f4 + 1.0f);
        List<Entity> list = this.r.a(c_b, n7, n5, n10, n6, n9, n11);
        net.minecraft.a.d.C_a c_a = new net.minecraft.a.d.C_a(f, f2, f3);
        for (int i = 0; i < list.size(); ++i) {
            float f17;
            Entity c_b2;
            Entity c_b3 = c_b2 = list.get(i);
            f9 = c_b2.h - f;
            float f18 = c_b3.i - f2;
            f7 = c_b3.j - f3;
            f8 = MathHelper.c(f9 * f9 + f18 * f18 + f7 * f7) / f4;
            if (!(f17 <= 1.0f)) continue;
            f7 = c_b2.h - f;
            f6 = c_b2.i - f2;
            float f19 = c_b2.j - f3;
            float f20 = MathHelper.c(f7 * f7 + f6 * f6 + f19 * f19);
            f7 /= f20;
            f6 /= f20;
            f19 /= f20;
            float f21 = this.a(c_a, c_b2.r);
            f5 = (1.0f - f8) * f21;
            float f22 = 1.0f - f8;
            if (!c_b2.deflectProjectile) {
                if (c_b != null) {
                    c_b2.attackEntityFrom(c_b, (int)(f22 * 25.0f + 1.0f), 0.4f);
                } else {
                    c_b2.attackEntityFrom(c_b, (int)((f5 * f5 + f5) / 2.0f * 8.0f * f4 + 1.0f), 0.4f);
                }
            } else {
                ItemStack itemStack = ((EntityPlayer)c_b2).b.charmSlot[0];
                if (itemStack != null && itemStack.c == Item.shield.ap) {
                    if (c_b != null) {
                        itemStack.damageItem2((int)(f22 * 25.0f + 1.0f), this);
                    } else {
                        itemStack.damageItem2((int)((f5 * f5 + f5) / 2.0f * 8.0f * f4 + 1.0f), this);
                    }
                }
            }
            c_b2.k += f7 * f5;
            c_b2.l += f6 * f5;
            c_b2.m += f19 * f5;
        }
        f4 = f11;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.addAll(treeSet);
        for (int i = arrayList.size() - 1; i >= 0; --i) {
            int n12 = (Integer)arrayList.get(i);
            n7 = n12 & 0x3FF;
            n4 = n12 >> 10 & 0x3FF;
            n3 = n12 >> 20 & 0x3FF;
            if (n7 <= 0 || n4 <= 0 || n3 <= 0 || n7 >= this.a - 1 || n4 >= this.c - 1 || n3 >= this.b - 1) continue;
            n2 = this.a(n7, n4, n3);
            for (n = 0; n <= 0; ++n) {
                f5 = (float)n7 + this.q.nextFloat();
                f9 = (float)n4 + this.q.nextFloat();
                f7 = (float)n3 + this.q.nextFloat();
                f6 = f5 - f;
                f11 = f9 - f2;
                float f23 = f7 - f3;
                f10 = MathHelper.c(f6 * f6 + f11 * f11 + f23 * f23);
                f6 /= f10;
                f11 /= f10;
                f23 /= f10;
                f10 = 0.5f / (f10 / f4 + 0.1f);
                this.a("explode", (f5 + f) / 2.0f, (f9 + f2) / 2.0f, (f7 + f3) / 2.0f, f6 *= (f10 *= this.q.nextFloat() * this.q.nextFloat() + 0.3f), f11 *= f10, f23 *= f10);
                this.a("smoke", f5, f9, f7, f6, f11, f23);
            }
            if (n2 <= 0) continue;
            Block.c[n2].a(this, n7, n4, n3, this.e(n7, n4, n3), 0.3f);
            this.b(n7, n4, n3, 0);
            Block.c[n2].c(this, n7, n4, n3);
        }
    }

    private float a(net.minecraft.a.d.C_a c_a, net.minecraft.a.d.C_b c_b) {
        float f = 1.0f / ((c_b.d - c_b.a) * 2.0f + 1.0f);
        float f2 = 1.0f / ((c_b.e - c_b.b) * 2.0f + 1.0f);
        float f3 = 1.0f / ((c_b.f - c_b.c) * 2.0f + 1.0f);
        int n = 0;
        int n2 = 0;
        for (float f4 = 0.0f; f4 <= 1.0f; f4 += f) {
            for (float f5 = 0.0f; f5 <= 1.0f; f5 += f2) {
                for (float f6 = 0.0f; f6 <= 1.0f; f6 += f3) {
                    float f7 = c_b.a + (c_b.d - c_b.a) * f4;
                    float f8 = c_b.b + (c_b.e - c_b.b) * f5;
                    float f9 = c_b.c + (c_b.f - c_b.c) * f6;
                    if (this.a(new net.minecraft.a.d.C_a(f7, f8, f9), c_a) == null) {
                        ++n;
                    }
                    ++n2;
                }
            }
        }
        return (float)n / (float)n2;
    }

    public Entity b(Class<?> clazz) {
        for (int i = 0; i < this.r.e.size(); ++i) {
            Entity c_b = this.r.e.get(i);
            if (!clazz.isAssignableFrom(c_b.getClass())) continue;
            return c_b;
        }
        return null;
    }

    public int a(int n, int n2, int n3, int n4, int n5) {
        if (n >= 0 && n2 >= 0 && n3 >= 0 && n < this.a && n2 < this.c && n3 < this.b) {
            boolean bl;
            int n6;
            int n7;
            int n72 = n;
            int n8 = n3;
            int n9 = ((n2 << 10) + n3 << 10) + n;
            int n10 = 0;
            int n11 = n10 + 1;
            this.P[0] = n + (n3 << 10);
            int by = -9999;
            if (n4 == Block.q.at || n4 == Block.p.at) {
                int n12 = Block.ah.at;
            }
            if (n4 == Block.s.at || n4 == Block.r.at) {
                n7 = Block.ai.at;
            }
            do {
                bl = false;
                int n13 = -1;
                n6 = 0;
                if ((N = (short)(N + 1)) == 30000) {
                    Arrays.fill(this.O, (short)0);
                    N = 1;
                }
                while (true) {
                    int n14;
                    if (n11 <= 0) {
                        ++n2;
                        break;
                    }
                    if (this.O[n14 = this.P[--n11]] == N) continue;
                    n = n14 % 1024;
                    n3 = n14 / 1024;
                    int n15 = n3 - n8;
                    n15 *= n15;
                    while (n > 0 && this.O[n14 - 1] != N && (this.d[(n2 * this.b + n3) * this.a + n - 1] == n4 || this.d[(n2 * this.b + n3) * this.a + n - 1] == n5)) {
                        --n;
                        --n14;
                    }
                    if (n > 0 && this.d[(n2 * this.b + n3) * this.a + n - 1] == n7) {
                        bl = true;
                    }
                    boolean bl2 = false;
                    boolean bl3 = false;
                    boolean bl4 = false;
                    while (n < this.a && this.O[n14] != N && (this.d[(n2 * this.b + n3) * this.a + n] == n4 || this.d[(n2 * this.b + n3) * this.a + n] == n5)) {
                        boolean bl5;
                        byte by2;
                        if (n3 > 0) {
                            by2 = this.d[(n2 * this.b + n3 - 1) * this.a + n];
                            if (by2 == n7) {
                                bl = true;
                            }
                            if ((bl5 = this.O[n14 - 1024] != N && (by2 == n4 || by2 == n5)) && !bl2) {
                                this.P[n11++] = n14 - 1024;
                            }
                            bl2 = bl5;
                        }
                        if (n3 < this.b - 1) {
                            by2 = this.d[(n2 * this.b + n3 + 1) * this.a + n];
                            if (by2 == n7) {
                                bl = true;
                            }
                            if ((bl5 = this.O[n14 + 1024] != N && (by2 == n4 || by2 == n5)) && !bl3) {
                                this.P[n11++] = n14 + 1024;
                            }
                            bl3 = bl5;
                        }
                        if (n2 < this.c - 1) {
                            by2 = this.d[((n2 + 1) * this.b + n3) * this.a + n];
                            bl5 = by2 == n4 || by2 == n5;
                            if (bl5 && !bl4) {
                                this.Q[n6++] = n14;
                            }
                            bl4 = bl5;
                        }
                        int n16 = n - n72;
                        if ((n16 = n16 * n16 + n15) > n13) {
                            n13 = n16;
                            n9 = ((n2 << 10) + n3 << 10) + n;
                        }
                        this.O[n14++] = N;
                        ++n;
                    }
                    if (n >= this.a || this.d[(n2 * this.b + n3) * this.a + n] != n7) continue;
                    bl = true;
                }
                int[] nArray = this.Q;
                this.Q = this.P;
                this.P = nArray;
                n11 = n6;
            } while (n6 > 0);
            if (bl) {
                return -9999;
            }
            return n9;
        }
        return -1;
    }

    public boolean floodFill(int n, int n2, int n3, int n4, int n5) {
        if (n >= 0 && n2 >= 0 && n3 >= 0 && n < this.a && n2 < this.c && n3 < this.b) {
            if ((N = (short)(N + 1)) == 30000) {
                Arrays.fill(this.O, (short)0);
                N = 1;
            }
            int n6 = 0;
            int n7 = n6 + 1;
            this.P[0] = n + (n3 << 10);
            while (true) {
                int n8;
                if (n7 <= 0) {
                    return true;
                }
                if (this.O[n8 = this.P[--n7]] == N) continue;
                n = n8 % 1024;
                n3 = n8 / 1024;
                if (n == 0 || n == this.a - 1 || n2 == 0 || n2 == this.c - 1 || n3 == 0 || n3 == this.b - 1) {
                    return false;
                }
                while (n > 0 && this.O[n8 - 1] != N && (this.d[(n2 * this.b + n3) * this.a + n - 1] == n4 || this.d[(n2 * this.b + n3) * this.a + n - 1] == n5)) {
                    --n;
                    --n8;
                }
                if (n > 0 && this.d[(n2 * this.b + n3) * this.a + n - 1] == 0) {
                    return false;
                }
                boolean bl = false;
                boolean bl2 = false;
                while (n < this.a && this.O[n8] != N && (this.d[(n2 * this.b + n3) * this.a + n] == n4 || this.d[(n2 * this.b + n3) * this.a + n] == n5)) {
                    boolean bl3;
                    byte by;
                    if (n == 0 || n == this.a - 1) {
                        return false;
                    }
                    if (n3 > 0) {
                        by = this.d[(n2 * this.b + n3 - 1) * this.a + n];
                        if (by == 0) {
                            return false;
                        }
                        bl3 = this.O[n8 - 1024] != N && (by == n4 || by == n5);
                        if (bl3 && !bl) {
                            this.P[n7++] = n8 - 1024;
                        }
                        bl = bl3;
                    }
                    if (n3 < this.c - 1) {
                        by = this.d[(n2 * this.b + n3 + 1) * this.a + n];
                        if (by == 0) {
                            return false;
                        }
                        bl3 = this.O[n8 + 1024] != N && (by == n4 || by == n5);
                        if (bl3 && !bl2) {
                            this.P[n7++] = n8 + 1024;
                        }
                        bl2 = bl3;
                    }
                    this.O[n8] = N;
                    ++n8;
                    ++n;
                }
                if (n < this.a && this.d[(n2 * this.b + n3) * this.a + n] == 0) break;
            }
            return false;
        }
        return false;
    }

    protected void updateWeather() {
        int n;
        if (this.weatherUpdates > 0) {
            --this.weatherUpdates;
        }
        if (this.season.currentSeason == 1 || this.season.currentSeason == 3) {
            n = this.getThunderTime();
            if (n <= 0) {
                if (this.getThundering()) {
                    if (this.season.currentSeason == 3) {
                        this.setThunderTime(this.I.nextInt(24000) + 7200);
                    } else {
                        this.setThunderTime(this.I.nextInt(12000) + 3600);
                    }
                } else {
                    this.setThunderTime(this.I.nextInt(168000) + 12000);
                }
            } else {
                this.setThunderTime(--n);
                if (n <= 0 && this.raining) {
                    this.setThundering(!this.getThundering());
                }
            }
        }
        if ((n = this.getRainTime()) <= 0) {
            if (this.getRaining()) {
                if (this.season.currentSeason == 3) {
                    this.setRainTime(this.I.nextInt(24000) + 24000);
                } else {
                    this.setRainTime(this.I.nextInt(12000) + 12000);
                }
            } else {
                this.setRainTime(this.I.nextInt(168000) + 12000);
            }
        } else {
            this.setRainTime(--n);
            if (n <= 0) {
                this.setRaining(!this.getRaining());
                if (!this.getRaining() && this.getThundering()) {
                    this.setThundering(false);
                }
            }
        }
        if (this.season.currentSeason == 2) {
            int n2 = this.getWindTime();
            if (n2 <= 0) {
                this.windForce = this.I.nextFloat();
                this.windDirection = (byte)this.I.nextInt(8);
                this.setWindTime(this.I.nextInt(600) + 12000);
            } else {
                this.setWindTime(--n2);
            }
        } else {
            this.windForce = 0.0f;
        }
        double d2 = 512 >> (this.fogDensity << 1);
        if (d2 == 32.0) {
            d2 = 64.0;
        }
        if ((double)this.fogDistance > d2) {
            this.fogDistance = (float)((double)this.fogDistance - 0.1);
            if (this.fogDensity == 1 && this.fogDistance < 128.0f) {
                this.fogDistance = 128.0f;
            }
            if (this.fogDensity == 2 && this.fogDistance < 64.0f) {
                this.fogDistance = 64.0f;
            }
        } else if ((double)this.fogDistance < d2) {
            this.fogDistance = (float)((double)this.fogDistance + 0.1);
            if (this.fogDensity == 1 && this.fogDistance > 128.0f) {
                this.fogDistance = 128.0f;
            }
            if (this.fogDensity == 2 && this.fogDistance > 64.0f) {
                this.fogDistance = 64.0f;
            }
        }
        if (this.fogDistance > 512.0f) {
            this.fogDistance = 512.0f;
        }
        if (this.fogDistance < 16.0f) {
            this.fogDistance = 16.0f;
        }
        if (this.season.currentSeason == 3) {
            int n3 = this.getFogTime();
            if (n3 <= 0) {
                this.fogDensity = this.I.nextInt(4);
                this.setFogTime(this.I.nextInt(12000) + 12000);
            } else {
                this.setFogTime(--n3);
            }
        } else {
            this.fogDensity = 0;
        }
        this.prevRainingStrength = this.rainingStrength;
        this.rainingStrength = this.getRaining() ? (float)((double)this.rainingStrength + 0.01) : (float)((double)this.rainingStrength - 0.01);
        if (this.rainingStrength < 0.0f) {
            this.rainingStrength = 0.0f;
        }
        if (this.rainingStrength > 1.0f) {
            this.rainingStrength = 1.0f;
        }
        this.prevThunderingStrength = this.thunderingStrength;
        this.thunderingStrength = this.getThundering() ? (float)((double)this.thunderingStrength + 0.01) : (float)((double)this.thunderingStrength - 0.01);
        if (this.thunderingStrength < 0.0f) {
            this.thunderingStrength = 0.0f;
        }
        if (this.thunderingStrength > 1.0f) {
            this.thunderingStrength = 1.0f;
        }
    }

    public float getThunderStatus(float f) {
        return (this.prevThunderingStrength + (this.thunderingStrength - this.prevThunderingStrength) * f) * this.getRainStatus(f);
    }

    public float getRainStatus(float f) {
        return this.prevRainingStrength + (this.rainingStrength - this.prevRainingStrength) * f;
    }

    public void setWeather(float f) {
        this.prevRainingStrength = f;
        this.rainingStrength = f;
    }

    public boolean getThundering() {
        return this.thundering;
    }

    public void setThundering(boolean bl) {
        this.thundering = bl;
    }

    public int getThunderTime() {
        return this.thunderTime;
    }

    public void setThunderTime(int n) {
        this.thunderTime = n;
    }

    public boolean getRaining() {
        return this.raining;
    }

    public void setRaining(boolean bl) {
        this.raining = bl;
    }

    public int getRainTime() {
        return this.rainTime;
    }

    public void setRainTime(int n) {
        this.rainTime = n;
    }

    public int getWindTime() {
        return this.windTime;
    }

    public void setWindTime(int n) {
        this.windTime = n;
    }

    public float getWindForce() {
        return this.windForce;
    }

    public int getWindDirection() {
        return this.windDirection;
    }

    public void setWindDirection(byte by, float f) {
        this.windDirection = by;
        this.windForce = f;
    }

    public int getFogTime() {
        return this.fogTime;
    }

    public void setFogTime(int n) {
        this.fogTime = n;
    }

    public float getFogDistance() {
        return this.fogDistance;
    }

    public int getFogDensity() {
        return this.fogDensity;
    }

    public void setFogDensity(int n) {
        this.fogDensity = n;
    }

    public boolean isBloodMoon() {
        return this.bloodMoon;
    }

    public void setBloodMoon(boolean bl) {
        this.bloodMoon = bl;
    }

    private void updateWeatherStatus() {
        if (this.getRaining()) {
            this.rainingStrength = 1.0f;
            if (this.getThundering()) {
                this.thunderingStrength = 1.0f;
            }
        }
    }

    public boolean isBlockProvidingPowerTo(int n, int n2, int n3, int n4) {
        int n5 = this.a(n, n2, n3);
        return n5 == 0 ? false : Block.c[n5].isProvidingStrongPower(this, n, n2, n3, n4);
    }

    public boolean isBlockGettingPowered(int n, int n2, int n3) {
        return this.isBlockProvidingPowerTo(n, n2 - 1, n3, 0) ? true : (this.isBlockProvidingPowerTo(n, n2 + 1, n3, 1) ? true : (this.isBlockProvidingPowerTo(n, n2, n3 - 1, 2) ? true : (this.isBlockProvidingPowerTo(n, n2, n3 + 1, 3) ? true : (this.isBlockProvidingPowerTo(n - 1, n2, n3, 4) ? true : this.isBlockProvidingPowerTo(n + 1, n2, n3, 5)))));
    }

    public boolean isBlockIndirectlyProvidingPowerTo(int n, int n2, int n3, int n4) {
        int n5 = this.a(n, n2, n3);
        Block c_x = Block.c[n5];
        boolean bl = false;
        boolean bl2 = false;
        if (this.b(n, n2, n3)) {
            bl |= this.isBlockGettingPowered(n, n2, n3);
            if (!c_x.canProvidePower()) {
                bl2 = true;
            }
        }
        if (!bl2) {
            bl |= n5 == 0 ? false : Block.c[n5].isProvidingWeakPower(this, n, n2, n3, n4);
        }
        return bl;
    }

    public boolean isBlockIndirectlyGettingPowered(int n, int n2, int n3) {
        return this.isBlockIndirectlyProvidingPowerTo(n, n2 - 1, n3, 0) ? true : (this.isBlockIndirectlyProvidingPowerTo(n, n2 + 1, n3, 1) ? true : (this.isBlockIndirectlyProvidingPowerTo(n, n2, n3 - 1, 2) ? true : (this.isBlockIndirectlyProvidingPowerTo(n, n2, n3 + 1, 3) ? true : (this.isBlockIndirectlyProvidingPowerTo(n - 1, n2, n3, 4) ? true : this.isBlockIndirectlyProvidingPowerTo(n + 1, n2, n3, 5)))));
    }

    public void a(Entity c_b, String string, float f, float f2) {
        for (int i = 0; i < this.n.size(); ++i) {
            float f3;
            float f4;
            float f5;
            float f6 = 16.0f;
            if (f > 1.0f) {
                f6 = 16.0f * f;
            }
            if (!((f5 = c_b.h - this.y.h) * f5 + (f4 = c_b.i - this.y.i) * f4 + (f3 = c_b.j - this.y.j) * f3 < f6 * f6)) continue;
            this.n.get(i).playMobSound(string, c_b.h, c_b.i - c_b.v, c_b.j, f, f2);
        }
    }

    public void a(float f, float f2, float f3, String string, float f4, float f5) {
        try {
            for (int i = 0; i < this.n.size(); ++i) {
                float f6;
                float f7;
                float f8;
                float f9 = 16.0f;
                if (f4 > 1.0f) {
                    f9 = 16.0f * f4;
                }
                if (!((f8 = f - this.y.h) * f8 + (f7 = f2 - this.y.i) * f7 + (f6 = f3 - this.y.j) * f6 < f9 * f9)) continue;
                this.n.get(i).a(string, f, f2, f3, f4, f5);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void playSoundAtBlock(float f, float f2, float f3, String string, float f4, float f5) {
        try {
            for (int i = 0; i < this.n.size(); ++i) {
                float f6;
                float f7;
                float f8;
                float f9 = 16.0f;
                if (f4 > 1.0f) {
                    f9 = 16.0f * f4;
                }
                if (!((f8 = f - this.y.h) * f8 + (f7 = f2 - this.y.i) * f7 + (f6 = f3 - this.y.j) * f6 < f9 * f9)) continue;
                this.n.get(i).playBlockSound(string, f, f2, f3, f4, f5);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void playRecord(String string, int n, int n2, int n3) {
        for (int i = 0; i < this.n.size(); ++i) {
            this.n.get(i).playRecord(string, n, n2, n3);
        }
    }

    public boolean containsFire(int n, int n2, int n3, int n4) {
        boolean bl = false;
        if (this.multiplayerWorld) {
            return false;
        }
        if (n4 == 0) {
            --n2;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        if (this.a(n, n2, n3) == Block.ag.at || this.a(n, n2, n3) == Block.hellfire.at) {
            bl = true;
            this.a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.fizz", 0.5f, 2.6f + (this.q.nextFloat() - this.q.nextFloat()) * 0.8f);
            this.b(n, n2, n3, 0);
            this.mc.f.addStat(StatList.firesDoused, 1);
        }
        return bl;
    }

    public void a(int n, int n2, int n3, TileEntity c_a) {
        if (c_a != null && !c_a.isRemoving()) {
            this.H.add(c_a);
            c_a.a = this;
            c_a.b = n;
            c_a.c = n2;
            c_a.d = n3;
            if (this.a(n, n2, n3) != 0 && Block.c[this.a(n, n2, n3)] instanceof BlockContainer) {
                c_a.unmarkForRemoval();
                this.o.put(n + (n2 << 10) + (n3 << 10 << 10), c_a);
            } else {
                System.out.println("Attempted to place a tile entity where there was no entity tile!");
            }
        }
    }

    public void i(int n, int n2, int n3) {
        TileEntity c_a = this.j(n, n2, n3);
        if (c_a != null && this.tileEntityFlag) {
            c_a.markForRemoval();
        } else {
            TileEntity c_a2;
            if (c_a != null) {
                this.H.remove(c_a);
            }
            if ((c_a2 = this.o.remove(n + (n2 << 10) + (n3 << 10 << 10))) != null) {
                c_a2.markForRemoval();
            }
        }
    }

    public TileEntity j(int n, int n2, int n3) {
        int n4 = n + (n2 << 10) + (n3 << 10 << 10);
        TileEntity c_a = this.o.get(n4);
        if (c_a == null) {
            int n5 = this.a(n, n2, n3);
            if (n5 <= 0 || !Block.c[n5].hasTileEntity()) {
                return null;
            }
            if (c_a == null) {
                c_a = ((BlockContainer)Block.c[n5]).getBlockEntity();
                this.a(n, n2, n3, c_a);
            }
            c_a = this.o.get(n4);
        }
        if (c_a != null && c_a.isRemoving()) {
            this.o.remove(n4);
            return null;
        }
        return c_a;
    }

    public void a(String string, float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.mc.w.particleCount == 0) {
            for (int i = 0; i < this.n.size(); ++i) {
                this.n.get(i).a(string, f, f2, f3, f4, f5, f6);
            }
        }
    }

    public void k(int n, int n2, int n3) {
        for (int i = 0; i < 1000; ++i) {
            int n4;
            int n5;
            int n6 = n + this.q.nextInt(16) - this.q.nextInt(16);
            int n7 = this.a(n6, n5 = n2 + this.q.nextInt(16) - this.q.nextInt(16), n4 = n3 + this.q.nextInt(16) - this.q.nextInt(16));
            if (n7 <= 0) continue;
            Block.c[n7].b(this, n6, n5, n4, this.I);
        }
    }

    public String j() {
        return "" + this.G.size() + ", S: " + this.lightingToUpdate.size();
    }

    public final int getLightingQueue() {
        return this.lightingToUpdate.size();
    }

    public void k() {
        for (int i = 0; i < this.n.size(); ++i) {
            C_d c_d = this.n.get(i);
            for (int j = 0; j < this.r.e.size(); ++j) {
                c_d.b(this.r.e.get(i));
            }
        }
    }

    protected void a(int n) {
        this.B = n;
        for (int i = 0; i < this.n.size(); ++i) {
            this.n.get(i).h();
        }
    }

    public boolean l(int n, int n2, int n3) {
        return n2 >= this.getHeightValue(n, n3);
    }

    public void updateTileEntity(int n, int n2, int n3, TileEntity c_a) {
        for (int i = 0; i < this.n.size(); ++i) {
            this.n.get(i).updateTileEntity(n, n2, n3, c_a);
        }
    }

    public void setEntityDead(Entity c_b) {
        c_b.k();
    }

    public void joinEntityInSurroundings(Entity c_b) {
    }

    public void powerBlock(int n, int n2, int n3, int n4, int n5) {
        int n6 = this.a(n, n2, n3);
        if (n6 > 0) {
            Block.c[n6].powerBlock(this, n, n2, n3, n4, n5);
        }
    }

    public void playNoteAt(int n, int n2, int n3, int n4, int n5) {
        int n6 = this.a(n, n2, n3);
        if (n6 > 0) {
            Block.c[n6].playBlock(this, n, n2, n3, n4, n5);
        }
    }

    public void clearAllEntities() {
        Entity c_b;
        int n;
        for (n = 0; n < this.unloadedEntityList.size(); ++n) {
            c_b = this.unloadedEntityList.get(n);
            this.chunkMap.removeEntity(c_b);
        }
        for (n = 0; n < this.unloadedEntityList.size(); ++n) {
            this.b(this.unloadedEntityList.get(n));
        }
        for (n = 0; n < this.loadedEntityList.size(); ++n) {
            c_b = this.loadedEntityList.get(n);
            if (c_b instanceof net.minecraft.client.g.C_d) continue;
            this.chunkMap.removeEntity(c_b);
            this.loadedEntityList.remove(n--);
            this.b(c_b);
        }
    }

    public void updateEntityList() {
        Entity c_b;
        int n;
        this.loadedEntityList.removeAll(this.unloadedEntityList);
        for (n = 0; n < this.unloadedEntityList.size(); ++n) {
            c_b = this.unloadedEntityList.get(n);
            this.chunkMap.removeEntity(c_b);
        }
        for (n = 0; n < this.unloadedEntityList.size(); ++n) {
            this.b(this.unloadedEntityList.get(n));
        }
        this.unloadedEntityList.clear();
        for (n = 0; n < this.loadedEntityList.size(); ++n) {
            c_b = this.loadedEntityList.get(n);
            if (!c_b.u) continue;
            this.chunkMap.removeEntity(c_b);
            this.loadedEntityList.remove(n--);
            this.b(c_b);
        }
    }

    public void sendQuittingDisconnectingPacket() {
    }

    public ItemStack storeTEInStack(ItemStack itemStack, TileEntity c_a) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        c_a.b(nBTTagCompound);
        itemStack.setTagInfo("BlockEntityTag", nBTTagCompound);
        return itemStack;
    }

    static {
        lightingUpdatesScheduled = 0;
        seasonColor = new C_p();
        for (int i = 0; i <= 15; ++i) {
            float f = 1.0f - (float)i / 15.0f;
            World.F[i] = (1.0f - f) / (f * 3.0f + 1.0f) * 0.95f + 0.05f;
        }
        N = 0;
    }
}

