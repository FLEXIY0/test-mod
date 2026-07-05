/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a;

import com.a.a.C_h;
import com.a.a.C_m;
import com.a.a.NBTBase;
import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import net.minecraft.a.a.World;
import net.minecraft.a.a.C_o;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_f;

public abstract class C_a {
    private util.C_b a;

    public C_a(util.C_b c_b) {
        this.a = c_b;
    }

    public final World a(InputStream inputStream) throws IOException {
        if (this.a != null) {
            this.a.a("Loading level");
        }
        if (this.a != null) {
            this.a.b("Reading..");
        }
        NBTTagCompound nBTTagCompound = C_m.readTags(inputStream);
        NBTTagCompound nBTTagCompound2 = nBTTagCompound.i("About");
        NBTTagCompound nBTTagCompound3 = nBTTagCompound.i("Map");
        NBTTagCompound nBTTagCompound4 = nBTTagCompound.i("Environment");
        NBTTagList nBTTagList = nBTTagCompound.j("Entities");
        short s = nBTTagCompound3.c("Width");
        short s2 = nBTTagCompound3.c("Length");
        short s3 = nBTTagCompound3.c("Height");
        World c_g = new World();
        if (this.a != null) {
            this.a.b("Preparing level..");
        }
        c_g.g = nBTTagCompound2.g("Author");
        c_g.f = nBTTagCompound2.g("Name");
        c_g.h = nBTTagCompound2.e("CreatedOn");
        c_g.x = nBTTagCompound4.d("CloudColor");
        c_g.v = nBTTagCompound4.d("SkyColor");
        c_g.w = nBTTagCompound4.d("FogColor");
        c_g.A = nBTTagCompound4.b("SkyBrightness");
        if (c_g.A < -1) {
            c_g.A = 0;
        }
        if (c_g.A > 16) {
            c_g.A = c_g.A * 15 / 100;
        }
        c_g.u = nBTTagCompound4.c("CloudHeight");
        c_g.t = nBTTagCompound4.c("SurroundingGroundHeight");
        c_g.s = nBTTagCompound4.c("SurroundingWaterHeight");
        c_g.m = nBTTagCompound4.b("SurroundingWaterType");
        c_g.defaultBlock = nBTTagCompound4.b("SurroundingGroundType");
        c_g.theme = nBTTagCompound4.c("WorldType");
        c_g.type = nBTTagCompound4.c("WorldStyle");
        c_g.gamemode = nBTTagCompound4.c("Gamemode");
        c_g.hardcore = nBTTagCompound4.k("Hardcore");
        c_g.D = nBTTagCompound4.c("TimeOfDay");
        c_g.daysPassed = nBTTagCompound4.d("DaysPassed");
        c_g.season.currentSeason = nBTTagCompound4.c("Season");
        c_g.season.nextSeason = nBTTagCompound4.c("NextSeason");
        c_g.season.lastSeason = nBTTagCompound4.c("PrevSeason");
        c_g.season.seasonProgress = nBTTagCompound4.f("SeasonProgress");
        c_g.season.seasonTime = nBTTagCompound4.d("SeasonTime");
        c_g.season.seasonsDisabled = nBTTagCompound4.k("SeasonsDisabled");
        c_g.prevRainingStrength = nBTTagCompound4.f("PrevRainStr");
        c_g.rainingStrength = nBTTagCompound4.f("RainStr");
        c_g.prevThunderingStrength = nBTTagCompound4.f("PrevThundStr");
        c_g.thunderingStrength = nBTTagCompound4.f("ThundStr");
        c_g.windForce = nBTTagCompound4.f("WindStr");
        c_g.fogDistance = nBTTagCompound4.f("FogDist");
        c_g.child = nBTTagCompound4.k("Child");
        c_g.active = nBTTagCompound4.k("Active");
        c_g.raining = nBTTagCompound4.k("Raining");
        c_g.thundering = nBTTagCompound4.k("Thundering");
        c_g.rainTime = nBTTagCompound4.d("RainTime");
        c_g.thunderTime = nBTTagCompound4.d("ThunderTime");
        c_g.windTime = nBTTagCompound4.d("WindTime");
        c_g.fogTime = nBTTagCompound4.d("FogTime");
        c_g.fogDensity = nBTTagCompound4.d("FogDensity");
        c_g.windDirection = nBTTagCompound4.b("WindDirection");
        c_g.weatherUpdates = nBTTagCompound4.d("WeatherUpdates");
        c_g.bloodMoonChance = nBTTagCompound4.d("BloodMoonChance");
        c_g.bloodMoon = nBTTagCompound4.k("BloodMoon");
        c_g.physicsDisabled = nBTTagCompound4.k("Physics");
        c_g.AIDisabled = nBTTagCompound4.k("AI");
        c_g.cheats = nBTTagCompound4.k("Cheats");
        c_g.freezeWeatherUpdates = nBTTagCompound4.k("Weather");
        c_g.seed = nBTTagCompound4.e("Seed");
        c_g.B = c_g.e();
        c_g.parentName = nBTTagCompound4.g("Parent");
        c_g.setPartialData(s, s3, s2, nBTTagCompound3.h("Blocks"), nBTTagCompound3.h("Data"), nBTTagCompound3.h("Light"), nBTTagCompound3.getIntArray("Heightmap"));
        NBTTagList nBTTagList2 = nBTTagCompound3.j("Spawn");
        c_g.i = ((C_h)nBTTagList2.a((int)0)).a;
        c_g.j = ((C_h)nBTTagList2.a((int)1)).a;
        c_g.k = ((C_h)nBTTagList2.a((int)2)).a;
        if (this.a != null) {
            this.a.b("Preparing entities..");
        }
        for (int i = 0; i < nBTTagList.b(); ++i) {
            try {
                nBTTagCompound3 = (NBTTagCompound)nBTTagList.a(i);
                String string = nBTTagCompound3.g("id");
                C_b c_b = this.a(c_g, string);
                if (c_b != null) {
                    c_b.d(nBTTagCompound3);
                    c_g.spawnEntityInWorld(c_b);
                    continue;
                }
                System.out.println("Skipping unknown entity id \"" + string + "\"");
                continue;
            }
            catch (Exception exception) {
                System.out.println("Error reading entity");
                exception.printStackTrace();
            }
        }
        NBTTagList nBTTagList3 = nBTTagCompound.j("TileEntities");
        for (int i = 0; i < nBTTagList3.b(); ++i) {
            try {
                nBTTagCompound4 = (NBTTagCompound)nBTTagList3.a(i);
                int n = nBTTagCompound4.d("Pos");
                int n2 = n % 1024;
                int n3 = (n >> 10) % 1024;
                n = (n >> 20) % 1024;
                net.minecraft.a.a.b.a.TileEntity c_a = C_o.loadFromCompound(nBTTagCompound4);
                if (c_a == null) continue;
                c_g.a(n2, n3, n, c_a);
                continue;
            }
            catch (Exception exception) {
                System.out.println("Error reading tileentity");
                exception.printStackTrace();
            }
        }
        return c_g;
    }

    protected C_b a(World c_g, String string) {
        return C_f.createEntityInWorld(string, c_g);
    }

    public final void a(World c_g, OutputStream outputStream) throws IOException {
        NBTTagCompound nBTTagCompound;
        Object object;
        if (this.a != null) {
            this.a.a("Saving level");
        }
        if (this.a != null) {
            this.a.b("Preparing level..");
        }
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        nBTTagCompound2.a("CloudColor", c_g.x);
        nBTTagCompound2.a("SkyColor", c_g.v);
        nBTTagCompound2.a("FogColor", c_g.w);
        nBTTagCompound2.a("SkyBrightness", (byte)c_g.A);
        nBTTagCompound2.a("CloudHeight", (short)c_g.u);
        nBTTagCompound2.a("SurroundingGroundHeight", (short)c_g.t);
        nBTTagCompound2.a("SurroundingWaterHeight", (short)c_g.s);
        nBTTagCompound2.a("SurroundingGroundType", (byte)c_g.defaultBlock);
        nBTTagCompound2.a("SurroundingWaterType", (byte)c_g.m);
        nBTTagCompound2.a("WorldType", (short)c_g.theme);
        nBTTagCompound2.a("WorldStyle", (short)c_g.type);
        nBTTagCompound2.a("Gamemode", (short)c_g.gamemode);
        nBTTagCompound2.a("TimeOfDay", (short)c_g.D);
        nBTTagCompound2.a("DaysPassed", c_g.daysPassed);
        nBTTagCompound2.a("Season", (short)c_g.season.currentSeason);
        nBTTagCompound2.a("NextSeason", (short)c_g.season.nextSeason);
        nBTTagCompound2.a("PrevSeason", (short)c_g.season.lastSeason);
        nBTTagCompound2.a("SeasonProgress", c_g.season.seasonProgress);
        nBTTagCompound2.a("SeasonTime", c_g.season.seasonTime);
        nBTTagCompound2.a("SeasonsDisabled", c_g.season.seasonsDisabled);
        nBTTagCompound2.a("PrevRainStr", c_g.prevRainingStrength);
        nBTTagCompound2.a("RainStr", c_g.rainingStrength);
        nBTTagCompound2.a("PrevThundStr", c_g.prevRainingStrength);
        nBTTagCompound2.a("ThundStr", c_g.prevThunderingStrength);
        nBTTagCompound2.a("WindStr", c_g.windForce);
        nBTTagCompound2.a("FogDist", c_g.fogDistance);
        nBTTagCompound2.a("Raining", c_g.raining);
        nBTTagCompound2.a("Thundering", c_g.thundering);
        nBTTagCompound2.a("RainTime", c_g.rainTime);
        nBTTagCompound2.a("ThunderTime", c_g.thunderTime);
        nBTTagCompound2.a("WindTime", c_g.windTime);
        nBTTagCompound2.a("FogTime", c_g.fogTime);
        nBTTagCompound2.a("FogDensity", c_g.fogDensity);
        nBTTagCompound2.a("WindDirection", c_g.windDirection);
        nBTTagCompound2.a("WeatherUpdates", c_g.weatherUpdates);
        nBTTagCompound2.a("BloodMoonChance", c_g.bloodMoonChance);
        nBTTagCompound2.a("BloodMoon", c_g.bloodMoon);
        nBTTagCompound2.a("Physics", c_g.physicsDisabled);
        nBTTagCompound2.a("AI", c_g.AIDisabled);
        nBTTagCompound2.a("Cheats", c_g.cheats);
        nBTTagCompound2.a("Weather", c_g.freezeWeatherUpdates);
        nBTTagCompound2.a("Hardcore", c_g.hardcore);
        nBTTagCompound2.a("Child", c_g.child);
        nBTTagCompound2.a("Active", c_g.active);
        nBTTagCompound2.a("Seed", c_g.seed);
        nBTTagCompound2.a("Parent", c_g.parentName);
        NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
        nBTTagCompound3.a("Width", (short)c_g.a);
        nBTTagCompound3.a("Length", (short)c_g.b);
        nBTTagCompound3.a("Height", (short)c_g.c);
        nBTTagCompound3.a("Blocks", c_g.d);
        nBTTagCompound3.a("Data", c_g.e);
        nBTTagCompound3.a("Light", c_g.light);
        nBTTagCompound3.setIntArray("Heightmap", c_g.p);
        NBTTagList nBTTagList = new NBTTagList();
        nBTTagList.a(new C_h((short)c_g.i));
        nBTTagList.a(new C_h((short)c_g.j));
        nBTTagList.a(new C_h((short)c_g.k));
        nBTTagCompound3.a("Spawn", nBTTagList);
        NBTTagCompound nBTTagCompound4 = new NBTTagCompound();
        nBTTagCompound4.a("Author", c_g.g);
        nBTTagCompound4.a("Name", c_g.f);
        nBTTagCompound4.a("CreatedOn", c_g.h);
        if (this.a != null) {
            this.a.b("Preparing entities..");
        }
        NBTTagList nBTTagList2 = new NBTTagList();
        for (C_b object22 : c_g.r.e) {
            object = new NBTTagCompound();
            object22.c((NBTTagCompound)object);
            if (((NBTTagCompound)object).b()) continue;
            nBTTagList2.a((NBTBase)object);
        }
        NBTTagList nBTTagList3 = new NBTTagList();
        object = c_g.o.keySet().iterator();
        while (object.hasNext()) {
            int nBTTagCompound5 = (Integer)object.next();
            nBTTagCompound = new NBTTagCompound();
            nBTTagCompound.a("Pos", nBTTagCompound5);
            c_g.o.get(nBTTagCompound5).b(nBTTagCompound);
            nBTTagList3.a(nBTTagCompound);
        }
        NBTTagCompound nBTTagCompound5 = new NBTTagCompound();
        nBTTagCompound5.l("MinecraftLevel");
        nBTTagCompound5.a("About", nBTTagCompound4);
        nBTTagCompound5.a("Map", nBTTagCompound3);
        nBTTagCompound5.a("Environment", nBTTagCompound2);
        nBTTagCompound5.a("Entities", nBTTagList2);
        nBTTagCompound5.a("TileEntities", nBTTagList3);
        if (this.a != null) {
            this.a.b("Writing..");
        }
        nBTTagCompound = nBTTagCompound5;
        C_m.writeTags(nBTTagCompound, outputStream);
    }

    public static byte[] loadBlocks(InputStream inputStream) throws Exception {
        DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(inputStream));
        int n = dataInputStream.readInt();
        byte[] byArray = new byte[n];
        dataInputStream.readFully(byArray);
        dataInputStream.close();
        return byArray;
    }
}

