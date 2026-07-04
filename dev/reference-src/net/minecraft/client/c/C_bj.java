/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import com.a.a.C_m;
import com.a.a.NBTTagCompound;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.a.a.LevelOptions;
import net.minecraft.client.c.C_ah;
import net.minecraft.client.c.C_bf;
import net.minecraft.client.c.C_bh;
import net.minecraft.client.c.C_bi;
import net.minecraft.client.c.C_bt;
import net.minecraft.client.c.C_n;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;

public class C_bj
extends GuiScreen {
    protected GuiScreen parentScreen;
    protected String screenTitle = "Search levels...";
    private boolean selected = false;
    private int selectedLevel;
    private List<C_bi> saveList;
    private C_bh worldSlotContainer;
    private boolean deleting;
    private GuiButton buttonRename;
    private GuiButton buttonSelect;
    private GuiButton buttonDelete;
    private GuiButton buttonRecreate;
    private LevelOptions worldOptions;
    private C_bt searchField;

    public C_bj(GuiScreen guiScreen) {
        this.parentScreen = guiScreen;
    }

    @Override
    public void b() {
        this.worldOptions = new LevelOptions();
        this.loadSaves();
        this.worldSlotContainer = new C_bh(this, this);
        this.worldSlotContainer.registerScrollButtons(this.e, 4, 5);
        this.initButtons();
    }

    private void loadSaves() {
        this.saveList = this.getSaves();
        this.selectedLevel = -1;
    }

    private List<C_bi> getSaves() {
        File[] fileArray;
        ArrayList<C_bi> arrayList = new ArrayList<C_bi>();
        File file = new File(this.b.z, "saves/");
        if (!file.exists()) {
            file.mkdir();
        }
        for (File file2 : fileArray = file.listFiles()) {
            if (!file2.getName().endsWith(".mclevel")) continue;
            try {
                NBTTagCompound nBTTagCompound = C_m.readTags(new FileInputStream(file2));
                NBTTagCompound nBTTagCompound2 = nBTTagCompound.i("About");
                NBTTagCompound nBTTagCompound3 = nBTTagCompound.i("Environment");
                if (nBTTagCompound2 == null || nBTTagCompound3 == null) continue;
                arrayList.add(new C_bi(this, nBTTagCompound2.g("Name"), file2.getName(), nBTTagCompound3.c("WorldStyle"), nBTTagCompound3.c("WorldType"), nBTTagCompound3.c("Season"), nBTTagCompound3.c("Gamemode"), nBTTagCompound3.k("Cheats"), nBTTagCompound3.k("Hardcore"), C_bj.getFileSizeKiloBytes(file2), file2.lastModified()));
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        C_bj.sort(arrayList);
        return arrayList;
    }

    public static void sort(List<C_bi> list) {
        list.sort((c_bi, c_bi2) -> Long.compare(C_bi.access$1700(c_bi2), C_bi.access$1700(c_bi)));
    }

    private static String getFileSizeKiloBytes(File file) {
        return file.length() / 1024L + "KB";
    }

    protected String getFileName(int n) {
        return C_bi.access$000(this.saveList.get(n));
    }

    protected String getSaveName(int n) {
        return C_bi.access$100(this.saveList.get(n));
    }

    protected String getSaveType(int n) {
        return C_bi.access$200(this.saveList.get(n));
    }

    protected String getSaveTheme(int n) {
        return C_bi.access$300(this.saveList.get(n));
    }

    protected String getSaveSize(int n) {
        return C_bi.access$400(this.saveList.get(n));
    }

    public void initButtons() {
        this.e.clear();
        this.buttonSelect = new GuiButton(1, this.c / 2 - 154, this.d - 52, 150, 20, "Select level");
        this.e.add(this.buttonSelect);
        this.buttonRename = new GuiButton(6, this.c / 2 - 154, this.d - 28, 78, 20, "Rename");
        this.e.add(this.buttonRename);
        this.buttonDelete = new GuiButton(2, this.c / 2 - 74, this.d - 28, 70, 20, "Delete");
        this.e.add(this.buttonDelete);
        this.e.add(new GuiButton(3, this.c / 2 + 4, this.d - 52, 150, 20, "Create new level..."));
        this.e.add(new GuiButton(0, this.c / 2 + 84, this.d - 28, 70, 20, "Cancel"));
        this.buttonRecreate = new GuiButton(4, this.c / 2 + 4, this.d - 28, 78, 20, "Re-create");
        this.e.add(this.buttonRecreate);
        this.buttonSelect.c = false;
        this.buttonRename.c = false;
        this.buttonDelete.c = false;
        this.buttonRecreate.c = false;
        this.searchField = new C_bt(this.g, this.c / 2 - 100, 6, 200, 20);
        this.searchField.setFlavorText(this.screenTitle);
        this.searchField.setMaxStringLength(32);
    }

    @Override
    protected void a(GuiButton guiButton) {
        if (guiButton.c) {
            if (guiButton.b == 2) {
                String string = this.getSaveName(this.selectedLevel);
                if (string != null) {
                    this.deleting = true;
                    String string2 = "Are you sure you want to delete this level?";
                    String string3 = "'" + string + "'  will be lost forever (a long time)!";
                    String string4 = "Delete";
                    String string5 = "Cancel";
                    C_ah c_ah = new C_ah(this, string2, string3, string4, string5, this.selectedLevel);
                    this.b.a(c_ah);
                }
            } else if (guiButton.b == 1) {
                this.selectWorld(this.selectedLevel);
            } else if (guiButton.b == 3) {
                this.b.a(new C_n(this));
            } else if (guiButton.b == 4) {
                File file = new File(this.b.z, "saves/" + this.getFileName(this.selectedLevel));
                try {
                    NBTTagCompound nBTTagCompound = C_m.readTags(new FileInputStream(file)).i("Environment");
                    NBTTagCompound nBTTagCompound2 = C_m.readTags(new FileInputStream(file)).i("Map");
                    this.worldOptions.seed = Long.toString(nBTTagCompound.e("Seed"));
                    this.worldOptions.type = nBTTagCompound.c("WorldStyle");
                    this.worldOptions.theme = nBTTagCompound.c("WorldType");
                    this.worldOptions.seasonLock = nBTTagCompound.k("SeasonsDisabled");
                    this.worldOptions.seasons = nBTTagCompound.c("Season");
                    this.worldOptions.width = nBTTagCompound2.c("Width");
                    this.worldOptions.height = nBTTagCompound2.c("Height");
                    this.worldOptions.length = nBTTagCompound2.c("Length");
                    this.b.generateLevel(this.worldOptions, this.getSaveName(this.selectedLevel));
                    this.b.a((GuiScreen)null);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            } else if (guiButton.b == 6) {
                this.b.a(new C_bf(this, this.getSaveName(this.selectedLevel), this.getFileName(this.selectedLevel)));
            } else if (guiButton.b == 0) {
                this.b.a(this.parentScreen);
            } else {
                this.worldSlotContainer.actionPerformed(guiButton);
            }
        }
    }

    public void selectWorld(int n) {
        this.b.a((GuiScreen)null);
        if (!this.selected) {
            File file;
            this.selected = true;
            if (this.b.d != null) {
                file = new File(this.b.z, "saves/");
                file.mkdirs();
                file = new File(file, this.b.d.fileName);
                try {
                    this.b.levelIo.a(this.b.d, new FileOutputStream(file));
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            file = new File(this.b.z, "saves/" + this.getFileName(this.selectedLevel).replace(".mclevel", ""));
            boolean bl = true;
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    try {
                        NBTTagCompound nBTTagCompound = C_m.readTags(new FileInputStream(file2));
                        NBTTagCompound nBTTagCompound2 = nBTTagCompound.i("Environment");
                        if (!nBTTagCompound2.k("Active")) continue;
                        this.b.loadLevel(file2.getName(), this.getFileName(this.selectedLevel).replace(".mclevel", ""));
                        bl = false;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
            if (bl) {
                this.b.loadLevel(this.getFileName(this.selectedLevel));
            }
            this.b.a((GuiScreen)null);
        }
    }

    @Override
    public void buttonAction(boolean bl, int n) {
        if (this.deleting) {
            this.deleting = false;
            if (bl) {
                this.b.deleteLevel(this.getFileName(n));
            }
            this.b.a(this);
        }
    }

    @Override
    public void a(int n, int n2, float f) {
        this.worldSlotContainer.drawScreen(n, n2, f);
        this.searchField.drawTextBox();
        super.a(n, n2, f);
    }

    @Override
    protected void a(char c, int n) {
        if (this.searchField.isFocused) {
            this.searchField.textboxKeyTyped(c, n);
            this.filterWorlds();
        }
    }

    private void filterWorlds() {
        String string = this.searchField.getText().toLowerCase();
        this.saveList.clear();
        for (C_bi c_bi : this.getSaves()) {
            String string2 = C_bi.access$100(c_bi).toLowerCase();
            if (!string2.contains(string)) continue;
            this.saveList.add(c_bi);
        }
        Collections.sort(this.saveList);
        this.selectedLevel = -1;
        this.buttonSelect.c = false;
        this.buttonRename.c = false;
        this.buttonDelete.c = false;
        this.buttonRecreate.c = false;
    }

    @Override
    protected void mouseClick(int n, int n2, int n3) {
        super.mouseClick(n, n2, n3);
        this.searchField.mouseClicked(n, n2, n3);
    }

    @Override
    public void f_() {
        this.searchField.updateCursorCounter();
    }

    static /* synthetic */ List access$500(C_bj c_bj) {
        return c_bj.saveList;
    }

    static /* synthetic */ int access$602(C_bj c_bj, int n) {
        c_bj.selectedLevel = n;
        return c_bj.selectedLevel;
    }

    static /* synthetic */ int access$600(C_bj c_bj) {
        return c_bj.selectedLevel;
    }

    static /* synthetic */ GuiButton access$700(C_bj c_bj) {
        return c_bj.buttonSelect;
    }

    static /* synthetic */ GuiButton access$800(C_bj c_bj) {
        return c_bj.buttonRename;
    }

    static /* synthetic */ GuiButton access$900(C_bj c_bj) {
        return c_bj.buttonDelete;
    }

    static /* synthetic */ GuiButton access$1000(C_bj c_bj) {
        return c_bj.buttonRecreate;
    }
}

