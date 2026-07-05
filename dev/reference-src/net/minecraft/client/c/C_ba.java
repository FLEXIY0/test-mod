package net.minecraft.client.c;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.ClientConstants;
import net.minecraft.network.packet.Packet;
import org.lwjgl.input.Keyboard;

public class C_ba extends GuiScreen {
   private static int threadsPending = 0;
   private static Object lock = new Object();
   private GuiScreen parentScreen;
   private C_az serverSlotContainer;
   private List<C_ax> serverList = new ArrayList<>();
   private int selectedServer = -1;
   private GuiButton buttonEdit;
   private GuiButton buttonSelect;
   private GuiButton buttonDelete;
   private boolean deleteClicked = false;
   private boolean addClicked = false;
   private boolean editClicked = false;
   private boolean directClicked = false;
   private String statusString = null;
   private C_ax tempServer = null;
   private C_bt searchField;

   public C_ba(GuiScreen var1) {
      this.parentScreen = var1;
   }

   @Override
   public void f_() {
      this.searchField.updateCursorCounter();
   }

   @Override
   public void b() {
      if (ClientConstants.MP_TEST && !ClientConstants.MP_JOIN_LOCAL_OVERRIDE) {
         this.b.a(new C_ak(this.b, "genericpnpserver.ddns.net", 25565));
      } else {
         this.loadServerList();
         Keyboard.enableRepeatEvents(true);
         this.e.clear();
         this.serverSlotContainer = new C_az(this);
         this.initGuiControls();
      }
   }

   private void loadServerList() {
      try {
         NBTTagCompound var1 = com.a.a.C_m.read(new File(this.b.z, "servers.dat"));
         NBTTagList var2 = var1.j("servers");
         this.serverList.clear();

         for (int var3 = 0; var3 < var2.b(); var3++) {
            this.serverList.add(C_ax.createFromCompound((NBTTagCompound)var2.a(var3)));
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   private void saveServerList() {
      try {
         NBTTagList var1 = new NBTTagList();

         for (int var2 = 0; var2 < this.serverList.size(); var2++) {
            var1.appendTag(this.serverList.get(var2).getCompoundTag());
         }

         NBTTagCompound var4 = new NBTTagCompound();
         var4.a("servers", var1);
         com.a.a.C_m.safeWrite(var4, new File(this.b.z, "servers.dat"));
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   public void initGuiControls() {
      this.e.add(this.buttonEdit = new GuiButton(7, this.c / 2 - 154, this.d - 28, 70, 20, "Edit"));
      this.e.add(this.buttonDelete = new GuiButton(2, this.c / 2 - 74, this.d - 28, 70, 20, "Delete"));
      this.e.add(this.buttonSelect = new GuiButton(1, this.c / 2 - 154, this.d - 52, 100, 20, "Connect"));
      this.e.add(new GuiButton(4, this.c / 2 - 50, this.d - 52, 100, 20, "Direct Connect..."));
      this.e.add(new GuiButton(3, this.c / 2 + 4 + 50, this.d - 52, 100, 20, "Add Server..."));
      this.e.add(new GuiButton(8, this.c / 2 + 4, this.d - 28, 70, 20, "Refresh"));
      this.e.add(new GuiButton(0, this.c / 2 + 4 + 76, this.d - 28, 75, 20, "Cancel"));
      boolean var1 = this.selectedServer >= 0 && this.selectedServer < this.serverSlotContainer.getSize();
      this.buttonSelect.c = var1;
      this.buttonEdit.c = var1;
      this.buttonDelete.c = var1;
      this.searchField = new C_bt(this.g, this.c / 2 - 100, 6, 200, 20);
      this.searchField.setFlavorText("Search servers...");
      this.searchField.setMaxStringLength(32);
   }

   @Override
   public void a() {
      super.a();
      Keyboard.enableRepeatEvents(false);
   }

   @Override
   protected void a(GuiButton var1) {
      if (var1.c) {
         if (var1.b == 2) {
            String var2 = this.serverList.get(this.selectedServer).name;
            if (var2 != null) {
               this.deleteClicked = true;
               String var3 = "Are you sure you want to delete this server?";
               String var4 = "'" + var2 + "' will be deleted";
               String var5 = "Delete";
               String var6 = "Cancel";
               C_aw var7 = new C_aw(this, this, var3, var4, var5, var6, this.selectedServer);
               this.b.a(var7);
            }
         } else if (var1.b == 1) {
            this.joinServer(this.selectedServer);
         } else if (var1.b == 4) {
            this.directClicked = true;
            this.b.a(new C_av(this, this, this.tempServer = new C_ax("Minecraft Server", "")));
         } else if (var1.b == 3) {
            this.addClicked = true;
            this.b.a(new C_au(this, this, this.tempServer = new C_ax("Minecraft Server", "")));
         } else if (var1.b == 7) {
            this.editClicked = true;
            C_ax var8 = this.serverList.get(this.selectedServer);
            this.b.a(new C_au(this, this, this.tempServer = new C_ax(var8.name, var8.ip)));
         } else if (var1.b == 0) {
            this.b.a(this.parentScreen);
         } else if (var1.b == 8) {
            this.b.a(new C_ba(this.parentScreen));
         } else {
            this.serverSlotContainer.actionPerformed(var1);
         }
      }
   }

   @Override
   public void confirmClicked(boolean var1, int var2) {
      if (this.deleteClicked) {
         this.deleteClicked = false;
         if (var1) {
            this.serverList.remove(var2);
            this.saveServerList();
         }

         this.b.a(this);
      } else if (this.directClicked) {
         this.directClicked = false;
         if (var1) {
            this.joinServer(this.tempServer);
         } else {
            this.b.a(this);
         }
      } else if (this.addClicked) {
         this.addClicked = false;
         if (var1) {
            this.serverList.add(this.tempServer);
            this.saveServerList();
         }

         this.b.a(this);
      } else if (this.editClicked) {
         this.editClicked = false;
         if (var1) {
            C_ax var3 = this.serverList.get(this.selectedServer);
            var3.name = this.tempServer.name;
            var3.ip = this.tempServer.ip;
            this.saveServerList();
         }

         this.b.a(this);
      }
   }

   private int parseIntWithDefault(String var1, int var2) {
      try {
         return Integer.parseInt(var1.trim());
      } catch (Exception var4) {
         return var2;
      }
   }

   @Override
   protected void a(char var1, int var2) {
      if (var1 == '\r') {
         this.a(this.e.get(2));
      }

      if (this.searchField.isFocused) {
         this.searchField.textboxKeyTyped(var1, var2);
         this.filterServerList();
      }
   }

   private void filterServerList() {
      try {
         NBTTagCompound var1 = com.a.a.C_m.read(new File(this.b.z, "servers.dat"));
         NBTTagList var2 = var1.j("servers");
         String var3 = this.searchField.getText().toLowerCase();
         this.serverList.clear();

         for (int var4 = 0; var4 < var2.b(); var4++) {
            C_ax var5 = C_ax.createFromCompound((NBTTagCompound)var2.a.get(var4));
            if (var5.name.toLowerCase().contains(var3)) {
               this.serverList.add(var5);
            }
         }

         Collections.sort(this.serverList);
         this.selectedServer = -1;
         this.buttonDelete.c = false;
         this.buttonEdit.c = false;
         this.buttonSelect.c = false;
      } catch (Exception var6) {
      }
   }

   @Override
   protected void mouseClick(int var1, int var2, int var3) {
      super.mouseClick(var1, var2, var3);
      this.searchField.mouseClicked(var1, var2, var3);
   }

   @Override
   public void a(int var1, int var2, float var3) {
      this.statusString = null;
      this.h();
      this.serverSlotContainer.drawScreen(var1, var2, var3);
      this.searchField.drawTextBox();
      super.a(var1, var2, var3);
      if (this.statusString != null) {
         this.renderTooltip(this.statusString, var1, var2);
      }
   }

   private void joinServer(int var1) {
      this.joinServer(this.serverList.get(var1));
   }

   private void joinServer(C_ax var1) {
      String var2 = var1.ip;
      String[] var3 = var2.split(":");
      if (var2.startsWith("[")) {
         int var4 = var2.indexOf("]");
         if (var4 > 0) {
            String var5 = var2.substring(1, var4);
            String var6 = var2.substring(var4 + 1).trim();
            if (var6.startsWith(":") && var6.length() > 0) {
               var6 = var6.substring(1);
               var3 = new String[]{var5, var6};
            } else {
               var3 = new String[]{var5};
            }
         }
      }

      if (var3.length > 2) {
         var3 = new String[]{var2};
      }

      this.b.a(new C_ak(this.b, var3[0], var3.length > 1 ? this.parseIntWithDefault(var3[1], 25565) : 25565));
   }

   private void pingServer(C_ax var1) throws IOException {
      String var2 = var1.ip;
      String[] var3 = var2.split(":");
      if (var2.startsWith("[")) {
         int var4 = var2.indexOf("]");
         if (var4 > 0) {
            String var5 = var2.substring(1, var4);
            String var6 = var2.substring(var4 + 1).trim();
            if (var6.startsWith(":") && var6.length() > 0) {
               var6 = var6.substring(1);
               var3 = new String[]{var5, var6};
            } else {
               var3 = new String[]{var5};
            }
         }
      }

      if (var3.length > 2) {
         var3 = new String[]{var2};
      }

      String var31 = var3[0];
      int var32 = var3.length > 1 ? this.parseIntWithDefault(var3[1], 25565) : 25565;
      Socket var34 = null;
      DataInputStream var7 = null;
      DataOutputStream var8 = null;

      try {
         var34 = new Socket();
         var34.setSoTimeout(3000);
         var34.setTcpNoDelay(true);
         var34.setTrafficClass(18);
         var34.connect(new InetSocketAddress(var31, var32), 3000);
         var7 = new DataInputStream(var34.getInputStream());
         var8 = new DataOutputStream(var34.getOutputStream());
         var8.write(192);
         if (var7.read() != 255) {
            throw new IOException("Bad message");
         }

         String var9 = Packet.readString(var7, 512);
         char[] var10 = var9.toCharArray();

         for (int var11 = 0; var11 < var10.length; var11++) {
            if (var10[var11] != 167 && ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(var10[var11]) < 0) {
               var10[var11] = 'c';
            }
         }

         var9 = new String(var10);
         var3 = var9.split("§");
         var9 = var3[0];
         int var37 = -1;
         int var12 = -1;
         int var13 = -1;

         try {
            var37 = Integer.parseInt(var3[1]);
            var12 = Integer.parseInt(var3[2]);
            var13 = Integer.parseInt(var3[4].substring(3));
         } catch (Exception var28) {
         }

         var1.motd = "§7" + var9;
         var1.gamemode = var13;
         var1.serversideName = "§7" + var3[3];
         if (var37 >= 0 && var12 > 0) {
            var1.playerCount = "§7" + var37 + "§8/§7" + var12;
         } else {
            var1.playerCount = "§8???";
         }
      } finally {
         try {
            if (var7 != null) {
               var7.close();
            }
         } catch (Throwable var27) {
         }

         try {
            if (var8 != null) {
               var8.close();
            }
         } catch (Throwable var26) {
         }

         try {
            if (var34 != null) {
               var34.close();
            }
         } catch (Throwable var25) {
         }
      }
   }

   protected void renderTooltip(String var1, int var2, int var3) {
      if (var1 != null) {
         int var4 = var2 + 12;
         int var5 = var3 - 12;
         int var6 = this.g.a(var1);
         drawGradientRect(var4 - 3, var5 - 3, var4 + var6 + 3, var5 + 8 + 3, -1073741824, -1073741824, 1.5F);
         this.g.a(var1, var4, var5, -1);
      }
   }

   private String gamemode_string(int var1) {
      switch (var1) {
         case 0:
            return "§cSurvival";
         case 1:
            return "§9Creative";
         default:
            return "";
      }
   }
}
