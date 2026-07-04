package net.minecraft.client.md3;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;

public class MD3Loader {
   private MD3Model load(ByteBuffer var1) throws IOException {
      var1.order(ByteOrder.LITTLE_ENDIAN);
      if (!readString(var1, 4).equals("IDP3")) {
         throw new IOException("Not a valid MD3 file (bad magic number)");
      } else {
         MD3Model var3 = new MD3Model();
         var1.getInt();
         readString(var1, 64);
         var1.getInt();
         int var4 = var1.getInt();
         System.out.println(var4 + " frames");
         int var5 = var1.getInt();
         int var6 = var1.getInt();
         var1.getInt();
         int var7 = var1.getInt();
         var1.getInt();
         int var8 = var1.getInt();
         var1.getInt();
         var3.animFrames = var4;
         var3.frames = new MD3Frame[var4];
         var3.tags = new HashMap<>();
         var3.surfaces = new MD3Surface[var6];
         ((Buffer)var1).position(var7);

         for (int var9 = 0; var9 < var4; var9++) {
            MD3Frame var10 = new MD3Frame();
            var10.radius = var1.getFloat();
            var10.name = readString(var1, 16);
            var3.frames[var9] = var10;
         }

         MD3Tag[] var16 = new MD3Tag[var5];

         for (int var2 = 0; var2 < var5; var2++) {
            var16[var2] = new MD3Tag(var4);
         }

         for (int var13 = 0; var13 < var4; var13++) {
            MD3Tag[] var17 = var16;
            int var11 = var16.length;

            for (int var12 = 0; var12 < var11; var12++) {
               var17[var12].name = readString(var1, 64);
            }
         }

         for (int var14 = 0; var14 < var5; var14++) {
            var3.tags.put(var16[var14].name, var16[var14]);
         }

         ((Buffer)var1).position(var8);

         for (int var15 = 0; var15 < var6; var15++) {
            var3.surfaces[var15] = this.loadSurface(var1);
         }

         return var3;
      }
   }

   private MD3Surface loadSurface(ByteBuffer var1) throws IOException {
      int var3 = var1.position();
      if (!readString(var1, 4).equals("IDP3")) {
         throw new IOException("Not a valid MD3 file (bad surface magic number)");
      } else {
         System.out.println("Name: " + readString(var1, 64));
         var1.getInt();
         int var4 = var1.getInt();
         int var5 = var1.getInt();
         int var6 = var1.getInt();
         int var7 = var1.getInt();
         MD3Surface var8 = new MD3Surface(var7, var6, var4);
         int var9 = var1.getInt() + var3;
         int var10 = var1.getInt() + var3;
         int var11 = var1.getInt() + var3;
         var3 += var1.getInt();
         var1.getInt();
         var8.verts = var6;
         var8.shaders = new MD3Shader[var5];
         System.out.println("Triangles: " + var7);
         System.out.println("OFS_SHADERS: " + var10 + " (current location: " + var1.position() + ")");
         ((Buffer)var1).position(var10);

         for (int var2 = 0; var2 < var5; var2++) {
            MD3Shader var12 = new MD3Shader();
            readString(var1, 64);
            var1.getInt();
            var8.shaders[var2] = var12;
         }

         System.out.println("OFS_TRIANGLES: " + var9 + " (current location: " + var1.position() + ")");
         ((Buffer)var1).position(var9);

         for (int var19 = 0; var19 < var7 * 3; var19++) {
            var8.triangles.put(var1.getInt());
         }

         System.out.println("OFS_ST: " + var11 + " (current location: " + var1.position() + ")");
         ((Buffer)var1).position(var11);

         for (int var20 = 0; var20 < var6 << 1; var20++) {
            var8.polygons.put(var1.getFloat());
         }

         System.out.println("OFS_XYZ_NORMAL: " + var3 + " (current location: " + var1.position() + ")");
         ((Buffer)var1).position(var3);

         for (int var21 = 0; var21 < var6 * var4; var21++) {
            var8.vertices.put((float)var1.getShort() / 64.0F);
            var8.vertices.put((float)var1.getShort() / 64.0F);
            var8.vertices.put((float)var1.getShort() / 64.0F);
            double var23 = (double)(var1.get() & 255) * Math.PI * 2.0 / 255.0;
            double var14 = (double)(var1.get() & 255) * Math.PI * 2.0 / 255.0;
            float var16 = (float)(Math.cos(var14) * Math.sin(var23));
            float var17 = (float)(Math.sin(var14) * Math.sin(var23));
            float var18 = (float)Math.cos(var23);
            var8.normals.put(var16);
            var8.normals.put(var17);
            var8.normals.put(var18);
         }

         return var8;
      }
   }

   private static String readString(ByteBuffer var0, int var1) {
      byte[] var2 = new byte[var1];
      var0.get(var2);

      for (int var3 = 0; var3 < var2.length; var3++) {
         if (var2[var3] == 0) {
            return new String(var2, 0, var3);
         }
      }

      return new String(var2);
   }

   public final MD3Model newLoad(String var1) throws IOException {
      DataInputStream var3 = new DataInputStream(MD3Loader.class.getResourceAsStream(var1));
      ByteArrayOutputStream var4 = new ByteArrayOutputStream();
      byte[] var5 = new byte[4096];

      int var2;
      while ((var2 = var3.read(var5)) >= 0) {
         var4.write(var5, 0, var2);
      }

      var3.close();
      var4.close();
      return this.load(ByteBuffer.wrap(var4.toByteArray()));
   }
}
