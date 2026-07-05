package net.minecraft.a.a;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.a.b.Block;

public final class C_h {
   private int a = 0;
   private List b = new ArrayList();
   private World c;
   private int d;
   private int e;
   private int f;
   private byte[] g;
   private byte[] h;
   private int[] i;
   private List j = new ArrayList();
   private List k = new ArrayList();
   private List l = new ArrayList();
   private List m = new ArrayList();
   private int[] n = this.c();
   private byte[] o;
   private C_c p = null;
   private int q = 0;
   private int r;

   public C_h(World var1) {
      this.c = var1;
      this.d = var1.a;
      this.e = var1.b;
      this.f = var1.c;
      this.o = new byte[var1.d.length / 8];
      this.g = var1.d;
      this.h = var1.e;
      this.i = var1.p;
   }

   private int[] c() {
      return this.m.size() > 0 ? (int[])this.m.remove(this.m.size() - 1) : new int[32768];
   }

   public final void a(int var1, int var2, int var3, int var4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: Constructor net/minecraft/a/a/C_c.<init>(Lnet/minecraft/a/a/C_h;IIIIII)V not found
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.ExprUtil.getSyntheticParametersMask(ExprUtil.java:49)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.appendParamList(InvocationExprent.java:957)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.NewExprent.toJava(NewExprent.java:460)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.getCastedExprent(ExprProcessor.java:1018)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.appendParamList(InvocationExprent.java:1153)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.toJava(InvocationExprent.java:902)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.listToJava(ExprProcessor.java:895)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.BasicBlockStatement.toJava(BasicBlockStatement.java:90)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.RootStatement.toJava(RootStatement.java:36)
      //   at org.jetbrains.java.decompiler.main.ClassWriter.writeMethod(ClassWriter.java:1283)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield net/minecraft/a/a/C_h.l Ljava/util/List;
      // 04: new net/minecraft/a/a/C_c
      // 07: dup
      // 08: aload 0
      // 09: iload 1
      // 0a: iload 2
      // 0b: bipush 0
      // 0c: iload 3
      // 0d: iload 4
      // 0f: bipush 1
      // 10: invokespecial net/minecraft/a/a/C_c.<init> (Lnet/minecraft/a/a/C_h;IIIIII)V
      // 13: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 18: pop
      // 19: return
   }

   public final void a(int var1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: Constructor net/minecraft/a/a/C_c.<init>(Lnet/minecraft/a/a/C_h;IIIIII)V not found
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.ExprUtil.getSyntheticParametersMask(ExprUtil.java:49)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.appendParamList(InvocationExprent.java:957)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.NewExprent.toJava(NewExprent.java:460)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.getCastedExprent(ExprProcessor.java:1018)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.AssignmentExprent.toJava(AssignmentExprent.java:154)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.listToJava(ExprProcessor.java:895)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.BasicBlockStatement.toJava(BasicBlockStatement.java:90)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.SequenceStatement.toJava(SequenceStatement.java:107)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.IfStatement.toJava(IfStatement.java:241)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.SequenceStatement.toJava(SequenceStatement.java:107)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.RootStatement.toJava(RootStatement.java:36)
      //   at org.jetbrains.java.decompiler.main.ClassWriter.writeMethod(ClassWriter.java:1283)
      //
      // Bytecode:
      // 00: iload 1
      // 01: bipush 15
      // 03: if_icmple 09
      // 06: bipush 15
      // 08: istore 1
      // 09: iload 1
      // 0a: ifge 0f
      // 0d: bipush 0
      // 0e: istore 1
      // 0f: aload 0
      // 10: iload 1
      // 11: aload 0
      // 12: getfield net/minecraft/a/a/C_h.c Lnet/minecraft/a/a/World;
      // 15: getfield net/minecraft/a/a/World.B I
      // 18: isub
      // 19: putfield net/minecraft/a/a/C_h.r I
      // 1c: aload 0
      // 1d: getfield net/minecraft/a/a/C_h.r I
      // 20: ifne 24
      // 23: return
      // 24: aload 0
      // 25: aload 0
      // 26: getfield net/minecraft/a/a/C_h.c Lnet/minecraft/a/a/World;
      // 29: getfield net/minecraft/a/a/World.B I
      // 2c: putfield net/minecraft/a/a/C_h.q I
      // 2f: aload 0
      // 30: getfield net/minecraft/a/a/C_h.c Lnet/minecraft/a/a/World;
      // 33: iload 1
      // 34: putfield net/minecraft/a/a/World.B I
      // 37: aload 0
      // 38: getfield net/minecraft/a/a/C_h.p Lnet/minecraft/a/a/C_c;
      // 3b: ifnull 47
      // 3e: aload 0
      // 3f: bipush 64
      // 41: invokespecial net/minecraft/a/a/C_h.b (I)V
      // 44: goto 37
      // 47: aload 0
      // 48: new net/minecraft/a/a/C_c
      // 4b: dup
      // 4c: aload 0
      // 4d: bipush 0
      // 4e: bipush 0
      // 4f: bipush 0
      // 50: aload 0
      // 51: getfield net/minecraft/a/a/C_h.c Lnet/minecraft/a/a/World;
      // 54: getfield net/minecraft/a/a/World.a I
      // 57: aload 0
      // 58: getfield net/minecraft/a/a/C_h.c Lnet/minecraft/a/a/World;
      // 5b: getfield net/minecraft/a/a/World.c I
      // 5e: aload 0
      // 5f: getfield net/minecraft/a/a/C_h.c Lnet/minecraft/a/a/World;
      // 62: getfield net/minecraft/a/a/World.b I
      // 65: invokespecial net/minecraft/a/a/C_c.<init> (Lnet/minecraft/a/a/C_h;IIIIII)V
      // 68: putfield net/minecraft/a/a/C_h.p Lnet/minecraft/a/a/C_c;
      // 6b: return
   }

   private void b(int var1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: Constructor net/minecraft/a/a/C_c.<init>(Lnet/minecraft/a/a/C_h;IIIIII)V not found
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.ExprUtil.getSyntheticParametersMask(ExprUtil.java:49)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.appendParamList(InvocationExprent.java:957)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.NewExprent.toJava(NewExprent.java:460)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.getCastedExprent(ExprProcessor.java:1018)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.appendParamList(InvocationExprent.java:1153)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.toJava(InvocationExprent.java:902)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.listToJava(ExprProcessor.java:895)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.BasicBlockStatement.toJava(BasicBlockStatement.java:90)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.DoStatement.toJava(DoStatement.java:141)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.DoStatement.toJava(DoStatement.java:141)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.SequenceStatement.toJava(SequenceStatement.java:107)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.RootStatement.toJava(RootStatement.java:36)
      //   at org.jetbrains.java.decompiler.main.ClassWriter.writeMethod(ClassWriter.java:1283)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield net/minecraft/a/a/C_h.p Lnet/minecraft/a/a/C_c;
      // 004: getfield net/minecraft/a/a/C_c.a I
      // 007: istore 2
      // 008: aload 0
      // 009: getfield net/minecraft/a/a/C_h.p Lnet/minecraft/a/a/C_c;
      // 00c: getfield net/minecraft/a/a/C_c.d I
      // 00f: istore 3
      // 010: aload 0
      // 011: getfield net/minecraft/a/a/C_h.p Lnet/minecraft/a/a/C_c;
      // 014: getfield net/minecraft/a/a/C_c.c I
      // 017: istore 4
      // 019: aload 0
      // 01a: getfield net/minecraft/a/a/C_h.p Lnet/minecraft/a/a/C_c;
      // 01d: getfield net/minecraft/a/a/C_c.f I
      // 020: istore 5
      // 022: iload 2
      // 023: istore 2
      // 024: iload 2
      // 025: iload 3
      // 026: if_icmpge 112
      // 029: iload 1
      // 02a: iinc 1 -1
      // 02d: ifgt 040
      // 030: iload 2
      // 031: iload 3
      // 032: bipush 1
      // 033: isub
      // 034: if_icmpeq 040
      // 037: aload 0
      // 038: getfield net/minecraft/a/a/C_h.p Lnet/minecraft/a/a/C_c;
      // 03b: iload 2
      // 03c: putfield net/minecraft/a/a/C_c.a I
      // 03f: return
      // 040: iload 4
      // 042: istore 6
      // 044: iload 6
      // 046: iload 5
      // 048: if_icmpge 10c
      // 04b: aload 0
      // 04c: getfield net/minecraft/a/a/C_h.i [I
      // 04f: iload 2
      // 050: iload 6
      // 052: aload 0
      // 053: getfield net/minecraft/a/a/C_h.d I
      // 056: imul
      // 057: iadd
      // 058: iaload
      // 059: bipush 1
      // 05a: isub
      // 05b: istore 7
      // 05d: iload 7
      // 05f: ifle 087
      // 062: getstatic net/minecraft/a/a/b/Block.f [I
      // 065: aload 0
      // 066: getfield net/minecraft/a/a/C_h.g [B
      // 069: iload 7
      // 06b: aload 0
      // 06c: getfield net/minecraft/a/a/C_h.e I
      // 06f: imul
      // 070: iload 6
      // 072: iadd
      // 073: aload 0
      // 074: getfield net/minecraft/a/a/C_h.d I
      // 077: imul
      // 078: iload 2
      // 079: iadd
      // 07a: baload
      // 07b: iaload
      // 07c: bipush 100
      // 07e: if_icmpge 087
      // 081: iinc 7 -1
      // 084: goto 05d
      // 087: iload 7
      // 089: bipush 1
      // 08a: iadd
      // 08b: istore 7
      // 08d: iload 7
      // 08f: aload 0
      // 090: getfield net/minecraft/a/a/C_h.f I
      // 093: if_icmpge 106
      // 096: iload 7
      // 098: aload 0
      // 099: getfield net/minecraft/a/a/C_h.e I
      // 09c: imul
      // 09d: iload 6
      // 09f: iadd
      // 0a0: aload 0
      // 0a1: getfield net/minecraft/a/a/C_h.d I
      // 0a4: imul
      // 0a5: iload 2
      // 0a6: iadd
      // 0a7: istore 8
      // 0a9: getstatic net/minecraft/a/a/b/Block.h [I
      // 0ac: aload 0
      // 0ad: getfield net/minecraft/a/a/C_h.g [B
      // 0b0: iload 8
      // 0b2: baload
      // 0b3: iaload
      // 0b4: ifne 100
      // 0b7: aload 0
      // 0b8: getfield net/minecraft/a/a/C_h.h [B
      // 0bb: iload 8
      // 0bd: baload
      // 0be: bipush 15
      // 0c0: iand
      // 0c1: dup
      // 0c2: istore 9
      // 0c4: aload 0
      // 0c5: getfield net/minecraft/a/a/C_h.q I
      // 0c8: if_icmpgt 100
      // 0cb: aload 0
      // 0cc: getfield net/minecraft/a/a/C_h.r I
      // 0cf: ifge 0e6
      // 0d2: iload 9
      // 0d4: ifle 0e6
      // 0d7: aload 0
      // 0d8: getfield net/minecraft/a/a/C_h.h [B
      // 0db: iload 8
      // 0dd: dup2
      // 0de: baload
      // 0df: bipush 1
      // 0e0: isub
      // 0e1: i2b
      // 0e2: bastore
      // 0e3: goto 100
      // 0e6: aload 0
      // 0e7: getfield net/minecraft/a/a/C_h.r I
      // 0ea: ifle 100
      // 0ed: iload 9
      // 0ef: bipush 15
      // 0f1: if_icmpge 100
      // 0f4: aload 0
      // 0f5: getfield net/minecraft/a/a/C_h.h [B
      // 0f8: iload 8
      // 0fa: dup2
      // 0fb: baload
      // 0fc: bipush 1
      // 0fd: iadd
      // 0fe: i2b
      // 0ff: bastore
      // 100: iinc 7 1
      // 103: goto 08d
      // 106: iinc 6 1
      // 109: goto 044
      // 10c: iinc 2 1
      // 10f: goto 024
      // 112: bipush 0
      // 113: istore 6
      // 115: iload 6
      // 117: aload 0
      // 118: getfield net/minecraft/a/a/C_h.d I
      // 11b: if_icmpge 180
      // 11e: bipush 0
      // 11f: istore 7
      // 121: iload 7
      // 123: aload 0
      // 124: getfield net/minecraft/a/a/C_h.e I
      // 127: if_icmpge 17a
      // 12a: aload 0
      // 12b: getfield net/minecraft/a/a/C_h.k Ljava/util/List;
      // 12e: new net/minecraft/a/a/C_c
      // 131: dup
      // 132: aload 0
      // 133: iload 6
      // 135: bipush 0
      // 136: iload 7
      // 138: iload 6
      // 13a: bipush 32
      // 13c: iadd
      // 13d: aload 0
      // 13e: getfield net/minecraft/a/a/C_h.f I
      // 141: iload 7
      // 143: bipush 32
      // 145: iadd
      // 146: invokespecial net/minecraft/a/a/C_c.<init> (Lnet/minecraft/a/a/C_h;IIIIII)V
      // 149: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 14e: pop
      // 14f: aload 0
      // 150: getfield net/minecraft/a/a/C_h.j Ljava/util/List;
      // 153: new net/minecraft/a/a/C_c
      // 156: dup
      // 157: aload 0
      // 158: iload 6
      // 15a: bipush 0
      // 15b: iload 7
      // 15d: iload 6
      // 15f: bipush 32
      // 161: iadd
      // 162: aload 0
      // 163: getfield net/minecraft/a/a/C_h.f I
      // 166: iload 7
      // 168: bipush 32
      // 16a: iadd
      // 16b: invokespecial net/minecraft/a/a/C_c.<init> (Lnet/minecraft/a/a/C_h;IIIIII)V
      // 16e: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 173: pop
      // 174: iinc 7 32
      // 177: goto 121
      // 17a: iinc 6 32
      // 17d: goto 115
      // 180: bipush 0
      // 181: istore 6
      // 183: iload 6
      // 185: aload 0
      // 186: getfield net/minecraft/a/a/C_h.c Lnet/minecraft/a/a/World;
      // 189: getfield net/minecraft/a/a/World.n Ljava/util/List;
      // 18c: invokeinterface java/util/List.size ()I 1
      // 191: if_icmpge 1b3
      // 194: aload 0
      // 195: getfield net/minecraft/a/a/C_h.c Lnet/minecraft/a/a/World;
      // 198: getfield net/minecraft/a/a/World.n Ljava/util/List;
      // 19b: iload 6
      // 19d: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 1a2: checkcast net/minecraft/a/a/C_d
      // 1a5: dup
      // 1a6: astore 7
      // 1a8: invokeinterface net/minecraft/a/a/C_d.h ()V 1
      // 1ad: iinc 6 1
      // 1b0: goto 183
      // 1b3: aload 0
      // 1b4: aconst_null
      // 1b5: putfield net/minecraft/a/a/C_h.p Lnet/minecraft/a/a/C_c;
      // 1b8: return
   }

   public final void a(int var1, int var2, int var3, int var4, int var5, int var6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: Constructor net/minecraft/a/a/C_c.<init>(Lnet/minecraft/a/a/C_h;IIIIII)V not found
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.ExprUtil.getSyntheticParametersMask(ExprUtil.java:49)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.appendParamList(InvocationExprent.java:957)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.NewExprent.toJava(NewExprent.java:460)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.getCastedExprent(ExprProcessor.java:1018)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.appendParamList(InvocationExprent.java:1153)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.toJava(InvocationExprent.java:902)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.listToJava(ExprProcessor.java:895)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.BasicBlockStatement.toJava(BasicBlockStatement.java:90)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.RootStatement.toJava(RootStatement.java:36)
      //   at org.jetbrains.java.decompiler.main.ClassWriter.writeMethod(ClassWriter.java:1283)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield net/minecraft/a/a/C_h.k Ljava/util/List;
      // 04: new net/minecraft/a/a/C_c
      // 07: dup
      // 08: aload 0
      // 09: iload 1
      // 0a: iload 2
      // 0b: iload 3
      // 0c: iload 4
      // 0e: iload 5
      // 10: iload 6
      // 12: invokespecial net/minecraft/a/a/C_c.<init> (Lnet/minecraft/a/a/C_h;IIIIII)V
      // 15: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1a: pop
      // 1b: return
   }

   private void b(int var1, int var2, int var3, int var4, int var5, int var6) {
      for (int var10 = var2; var10 < var5; var10++) {
         for (int var7 = var3; var7 < var6; var7++) {
            for (int var8 = var1; var8 < var4; var8++) {
               int var9 = var8 + var10 * this.d + var7 * this.d * this.f;
               if ((this.o[var9 >> 3] & 1 << (var9 & 7)) == 0) {
                  this.o[var9 >> 3] = (byte)(this.o[var9 >> 3] | 1 << (var9 & 7));
                  this.n[this.a++] = var9;
                  if ((this.o[var9 >> 3] & 1 << (var9 & 7)) == 0) {
                     System.out.println("OMG ERROR!");
                  }

                  if (this.a > this.n.length - 32) {
                     var9 = this.n[--this.a];
                     this.n[this.n.length - 1] = this.a;
                     this.b.add(this.n);
                     this.n = this.c();
                     this.a = 1;
                     this.n[0] = var9;
                  }
               }
            }
         }
      }
   }

   public final void a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: Constructor net/minecraft/a/a/C_c.<init>(Lnet/minecraft/a/a/C_h;IIIIII)V not found
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.ExprUtil.getSyntheticParametersMask(ExprUtil.java:49)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.appendParamList(InvocationExprent.java:957)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.NewExprent.toJava(NewExprent.java:460)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.getCastedExprent(ExprProcessor.java:1018)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.appendParamList(InvocationExprent.java:1153)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.toJava(InvocationExprent.java:902)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.listToJava(ExprProcessor.java:895)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.BasicBlockStatement.toJava(BasicBlockStatement.java:90)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.IfStatement.toJava(IfStatement.java:241)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.SequenceStatement.toJava(SequenceStatement.java:107)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.DoStatement.toJava(DoStatement.java:141)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.SequenceStatement.toJava(SequenceStatement.java:107)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.IfStatement.toJava(IfStatement.java:261)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.SequenceStatement.toJava(SequenceStatement.java:107)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.RootStatement.toJava(RootStatement.java:36)
      //   at org.jetbrains.java.decompiler.main.ClassWriter.writeMethod(ClassWriter.java:1283)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield net/minecraft/a/a/C_h.m Ljava/util/List;
      // 004: invokeinterface java/util/List.size ()I 1
      // 009: ifle 021
      // 00c: aload 0
      // 00d: getfield net/minecraft/a/a/C_h.m Ljava/util/List;
      // 010: aload 0
      // 011: getfield net/minecraft/a/a/C_h.m Ljava/util/List;
      // 014: invokeinterface java/util/List.size ()I 1
      // 019: bipush 1
      // 01a: isub
      // 01b: invokeinterface java/util/List.remove (I)Ljava/lang/Object; 2
      // 020: pop
      // 021: bipush 5
      // 022: istore 1
      // 023: aload 0
      // 024: getfield net/minecraft/a/a/C_h.j Ljava/util/List;
      // 027: invokeinterface java/util/List.size ()I 1
      // 02c: ifle 08c
      // 02f: iload 1
      // 030: iinc 1 -1
      // 033: ifle 08c
      // 036: aload 0
      // 037: getfield net/minecraft/a/a/C_h.j Ljava/util/List;
      // 03a: bipush 0
      // 03b: invokeinterface java/util/List.remove (I)Ljava/lang/Object; 2
      // 040: checkcast net/minecraft/a/a/C_c
      // 043: astore 2
      // 044: bipush 0
      // 045: istore 3
      // 046: iload 3
      // 047: aload 0
      // 048: getfield net/minecraft/a/a/C_h.c Lnet/minecraft/a/a/World;
      // 04b: getfield net/minecraft/a/a/World.n Ljava/util/List;
      // 04e: invokeinterface java/util/List.size ()I 1
      // 053: if_icmpge 089
      // 056: aload 0
      // 057: getfield net/minecraft/a/a/C_h.c Lnet/minecraft/a/a/World;
      // 05a: getfield net/minecraft/a/a/World.n Ljava/util/List;
      // 05d: iload 3
      // 05e: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 063: checkcast net/minecraft/a/a/C_d
      // 066: aload 2
      // 067: getfield net/minecraft/a/a/C_c.a I
      // 06a: aload 2
      // 06b: getfield net/minecraft/a/a/C_c.b I
      // 06e: aload 2
      // 06f: getfield net/minecraft/a/a/C_c.c I
      // 072: aload 2
      // 073: getfield net/minecraft/a/a/C_c.d I
      // 076: aload 2
      // 077: getfield net/minecraft/a/a/C_c.e I
      // 07a: aload 2
      // 07b: getfield net/minecraft/a/a/C_c.f I
      // 07e: invokeinterface net/minecraft/a/a/C_d.a (IIIIII)V 7
      // 083: iinc 3 1
      // 086: goto 046
      // 089: goto 023
      // 08c: aload 0
      // 08d: getfield net/minecraft/a/a/C_h.p Lnet/minecraft/a/a/C_c;
      // 090: ifnull 09a
      // 093: aload 0
      // 094: bipush 8
      // 096: invokespecial net/minecraft/a/a/C_h.b (I)V
      // 099: return
      // 09a: bipush 0
      // 09b: istore 2
      // 09c: iload 2
      // 09d: bipush 16
      // 09f: if_icmpge 88b
      // 0a2: aload 0
      // 0a3: astore 1
      // 0a4: bipush 0
      // 0a5: istore 3
      // 0a6: aload 1
      // 0a7: getfield net/minecraft/a/a/C_h.k Ljava/util/List;
      // 0aa: invokeinterface java/util/List.size ()I 1
      // 0af: ifle 0de
      // 0b2: bipush 1
      // 0b3: istore 3
      // 0b4: aload 1
      // 0b5: getfield net/minecraft/a/a/C_h.k Ljava/util/List;
      // 0b8: bipush 0
      // 0b9: invokeinterface java/util/List.remove (I)Ljava/lang/Object; 2
      // 0be: checkcast net/minecraft/a/a/C_c
      // 0c1: astore 3
      // 0c2: aload 1
      // 0c3: aload 3
      // 0c4: getfield net/minecraft/a/a/C_c.a I
      // 0c7: aload 3
      // 0c8: getfield net/minecraft/a/a/C_c.b I
      // 0cb: aload 3
      // 0cc: getfield net/minecraft/a/a/C_c.c I
      // 0cf: aload 3
      // 0d0: getfield net/minecraft/a/a/C_c.d I
      // 0d3: aload 3
      // 0d4: getfield net/minecraft/a/a/C_c.e I
      // 0d7: aload 3
      // 0d8: getfield net/minecraft/a/a/C_c.f I
      // 0db: invokespecial net/minecraft/a/a/C_h.b (IIIIII)V
      // 0de: aload 1
      // 0df: getfield net/minecraft/a/a/C_h.l Ljava/util/List;
      // 0e2: invokeinterface java/util/List.size ()I 1
      // 0e7: ifle 1cc
      // 0ea: bipush 1
      // 0eb: istore 3
      // 0ec: aload 1
      // 0ed: getfield net/minecraft/a/a/C_h.l Ljava/util/List;
      // 0f0: bipush 0
      // 0f1: invokeinterface java/util/List.remove (I)Ljava/lang/Object; 2
      // 0f6: checkcast net/minecraft/a/a/C_c
      // 0f9: astore 3
      // 0fa: aload 1
      // 0fb: aload 3
      // 0fc: getfield net/minecraft/a/a/C_c.a I
      // 0ff: aload 3
      // 100: getfield net/minecraft/a/a/C_c.b I
      // 103: aload 3
      // 104: getfield net/minecraft/a/a/C_c.d I
      // 107: aload 3
      // 108: getfield net/minecraft/a/a/C_c.e I
      // 10b: istore 7
      // 10d: istore 6
      // 10f: istore 5
      // 111: istore 4
      // 113: astore 3
      // 114: iload 4
      // 116: istore 8
      // 118: iload 8
      // 11a: iload 4
      // 11c: iload 6
      // 11e: iadd
      // 11f: if_icmpge 1cc
      // 122: iload 5
      // 124: istore 9
      // 126: iload 9
      // 128: iload 5
      // 12a: iload 7
      // 12c: iadd
      // 12d: if_icmpge 1c6
      // 130: aload 3
      // 131: getfield net/minecraft/a/a/C_h.i [I
      // 134: iload 8
      // 136: iload 9
      // 138: aload 3
      // 139: getfield net/minecraft/a/a/C_h.d I
      // 13c: imul
      // 13d: iadd
      // 13e: iaload
      // 13f: istore 10
      // 141: aload 3
      // 142: getfield net/minecraft/a/a/C_h.f I
      // 145: bipush 1
      // 146: isub
      // 147: istore 11
      // 149: iload 11
      // 14b: ifle 172
      // 14e: getstatic net/minecraft/a/a/b/Block.f [I
      // 151: aload 3
      // 152: getfield net/minecraft/a/a/C_h.g [B
      // 155: iload 11
      // 157: aload 3
      // 158: getfield net/minecraft/a/a/C_h.e I
      // 15b: imul
      // 15c: iload 9
      // 15e: iadd
      // 15f: aload 3
      // 160: getfield net/minecraft/a/a/C_h.d I
      // 163: imul
      // 164: iload 8
      // 166: iadd
      // 167: baload
      // 168: iaload
      // 169: ifne 172
      // 16c: iinc 11 -1
      // 16f: goto 149
      // 172: aload 3
      // 173: getfield net/minecraft/a/a/C_h.i [I
      // 176: iload 8
      // 178: iload 9
      // 17a: aload 3
      // 17b: getfield net/minecraft/a/a/C_h.d I
      // 17e: imul
      // 17f: iadd
      // 180: iload 11
      // 182: bipush 1
      // 183: iadd
      // 184: iastore
      // 185: iload 10
      // 187: iload 11
      // 189: if_icmpeq 1c0
      // 18c: iload 10
      // 18e: iload 11
      // 190: if_icmpge 198
      // 193: iload 10
      // 195: goto 19a
      // 198: iload 11
      // 19a: istore 12
      // 19c: iload 10
      // 19e: iload 11
      // 1a0: if_icmple 1a8
      // 1a3: iload 10
      // 1a5: goto 1aa
      // 1a8: iload 11
      // 1aa: istore 13
      // 1ac: aload 3
      // 1ad: iload 8
      // 1af: iload 12
      // 1b1: iload 9
      // 1b3: iload 8
      // 1b5: bipush 1
      // 1b6: iadd
      // 1b7: iload 13
      // 1b9: iload 9
      // 1bb: bipush 1
      // 1bc: iadd
      // 1bd: invokespecial net/minecraft/a/a/C_h.b (IIIIII)V
      // 1c0: iinc 9 1
      // 1c3: goto 126
      // 1c6: iinc 8 1
      // 1c9: goto 118
      // 1cc: aload 1
      // 1cd: dup
      // 1ce: astore 3
      // 1cf: getfield net/minecraft/a/a/C_h.c Lnet/minecraft/a/a/World;
      // 1d2: getfield net/minecraft/a/a/World.B I
      // 1d5: istore 4
      // 1d7: sipush -999
      // 1da: istore 5
      // 1dc: sipush -999
      // 1df: istore 6
      // 1e1: sipush -999
      // 1e4: istore 7
      // 1e6: sipush -999
      // 1e9: istore 8
      // 1eb: sipush -999
      // 1ee: istore 9
      // 1f0: sipush -999
      // 1f3: istore 10
      // 1f5: sipush 1024
      // 1f8: istore 11
      // 1fa: bipush 0
      // 1fb: istore 12
      // 1fd: iload 11
      // 1ff: iinc 11 -1
      // 202: ifle 856
      // 205: aload 3
      // 206: getfield net/minecraft/a/a/C_h.a I
      // 209: ifgt 218
      // 20c: aload 3
      // 20d: getfield net/minecraft/a/a/C_h.b Ljava/util/List;
      // 210: invokeinterface java/util/List.size ()I 1
      // 215: ifle 856
      // 218: iinc 12 1
      // 21b: aload 3
      // 21c: getfield net/minecraft/a/a/C_h.a I
      // 21f: ifne 268
      // 222: aload 3
      // 223: getfield net/minecraft/a/a/C_h.n [I
      // 226: ifnull 23d
      // 229: aload 3
      // 22a: aload 3
      // 22b: getfield net/minecraft/a/a/C_h.n [I
      // 22e: astore 13
      // 230: dup
      // 231: astore 1
      // 232: getfield net/minecraft/a/a/C_h.m Ljava/util/List;
      // 235: aload 13
      // 237: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 23c: pop
      // 23d: aload 3
      // 23e: aload 3
      // 23f: getfield net/minecraft/a/a/C_h.b Ljava/util/List;
      // 242: aload 3
      // 243: getfield net/minecraft/a/a/C_h.b Ljava/util/List;
      // 246: invokeinterface java/util/List.size ()I 1
      // 24b: bipush 1
      // 24c: isub
      // 24d: invokeinterface java/util/List.remove (I)Ljava/lang/Object; 2
      // 252: checkcast [I
      // 255: putfield net/minecraft/a/a/C_h.n [I
      // 258: aload 3
      // 259: aload 3
      // 25a: getfield net/minecraft/a/a/C_h.n [I
      // 25d: aload 3
      // 25e: getfield net/minecraft/a/a/C_h.n [I
      // 261: arraylength
      // 262: bipush 1
      // 263: isub
      // 264: iaload
      // 265: putfield net/minecraft/a/a/C_h.a I
      // 268: aload 3
      // 269: getfield net/minecraft/a/a/C_h.a I
      // 26c: aload 3
      // 26d: getfield net/minecraft/a/a/C_h.n [I
      // 270: arraylength
      // 271: bipush 32
      // 273: isub
      // 274: if_icmple 2bf
      // 277: aload 3
      // 278: getfield net/minecraft/a/a/C_h.n [I
      // 27b: aload 3
      // 27c: dup
      // 27d: getfield net/minecraft/a/a/C_h.a I
      // 280: bipush 1
      // 281: isub
      // 282: dup_x1
      // 283: putfield net/minecraft/a/a/C_h.a I
      // 286: iaload
      // 287: istore 13
      // 289: aload 3
      // 28a: getfield net/minecraft/a/a/C_h.n [I
      // 28d: aload 3
      // 28e: getfield net/minecraft/a/a/C_h.n [I
      // 291: arraylength
      // 292: bipush 1
      // 293: isub
      // 294: aload 3
      // 295: getfield net/minecraft/a/a/C_h.a I
      // 298: iastore
      // 299: aload 3
      // 29a: getfield net/minecraft/a/a/C_h.b Ljava/util/List;
      // 29d: aload 3
      // 29e: getfield net/minecraft/a/a/C_h.n [I
      // 2a1: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 2a6: pop
      // 2a7: aload 3
      // 2a8: aload 3
      // 2a9: invokespecial net/minecraft/a/a/C_h.c ()[I
      // 2ac: putfield net/minecraft/a/a/C_h.n [I
      // 2af: aload 3
      // 2b0: bipush 1
      // 2b1: putfield net/minecraft/a/a/C_h.a I
      // 2b4: aload 3
      // 2b5: getfield net/minecraft/a/a/C_h.n [I
      // 2b8: bipush 0
      // 2b9: iload 13
      // 2bb: iastore
      // 2bc: goto 1fd
      // 2bf: aload 3
      // 2c0: getfield net/minecraft/a/a/C_h.n [I
      // 2c3: aload 3
      // 2c4: dup
      // 2c5: getfield net/minecraft/a/a/C_h.a I
      // 2c8: bipush 1
      // 2c9: isub
      // 2ca: dup_x1
      // 2cb: putfield net/minecraft/a/a/C_h.a I
      // 2ce: iaload
      // 2cf: dup
      // 2d0: istore 13
      // 2d2: aload 3
      // 2d3: getfield net/minecraft/a/a/C_h.d I
      // 2d6: irem
      // 2d7: istore 1
      // 2d8: iload 13
      // 2da: aload 3
      // 2db: getfield net/minecraft/a/a/C_h.d I
      // 2de: idiv
      // 2df: aload 3
      // 2e0: getfield net/minecraft/a/a/C_h.f I
      // 2e3: irem
      // 2e4: istore 14
      // 2e6: iload 13
      // 2e8: aload 3
      // 2e9: getfield net/minecraft/a/a/C_h.d I
      // 2ec: idiv
      // 2ed: aload 3
      // 2ee: getfield net/minecraft/a/a/C_h.f I
      // 2f1: idiv
      // 2f2: aload 3
      // 2f3: getfield net/minecraft/a/a/C_h.e I
      // 2f6: irem
      // 2f7: istore 15
      // 2f9: aload 3
      // 2fa: getfield net/minecraft/a/a/C_h.o [B
      // 2fd: iload 13
      // 2ff: bipush 3
      // 300: ishr
      // 301: dup2
      // 302: baload
      // 303: bipush 1
      // 304: iload 13
      // 306: bipush 7
      // 308: iand
      // 309: ishl
      // 30a: ixor
      // 30b: i2b
      // 30c: bastore
      // 30d: aload 3
      // 30e: getfield net/minecraft/a/a/C_h.i [I
      // 311: iload 1
      // 312: iload 15
      // 314: aload 3
      // 315: getfield net/minecraft/a/a/C_h.d I
      // 318: imul
      // 319: iadd
      // 31a: iaload
      // 31b: istore 13
      // 31d: iload 14
      // 31f: iload 13
      // 321: if_icmplt 329
      // 324: iload 4
      // 326: goto 32a
      // 329: bipush 0
      // 32a: istore 16
      // 32c: aload 3
      // 32d: getfield net/minecraft/a/a/C_h.g [B
      // 330: iload 14
      // 332: aload 3
      // 333: getfield net/minecraft/a/a/C_h.e I
      // 336: imul
      // 337: iload 15
      // 339: iadd
      // 33a: aload 3
      // 33b: getfield net/minecraft/a/a/C_h.d I
      // 33e: imul
      // 33f: iload 1
      // 340: iadd
      // 341: baload
      // 342: istore 13
      // 344: getstatic net/minecraft/a/a/b/Block.f [I
      // 347: iload 13
      // 349: iaload
      // 34a: dup
      // 34b: istore 17
      // 34d: bipush 100
      // 34f: if_icmple 358
      // 352: bipush 0
      // 353: istore 16
      // 355: goto 494
      // 358: iload 16
      // 35a: bipush 15
      // 35c: if_icmpge 494
      // 35f: iload 17
      // 361: dup
      // 362: istore 17
      // 364: ifne 36a
      // 367: bipush 1
      // 368: istore 17
      // 36a: iload 1
      // 36b: ifle 398
      // 36e: aload 3
      // 36f: getfield net/minecraft/a/a/C_h.h [B
      // 372: iload 14
      // 374: aload 3
      // 375: getfield net/minecraft/a/a/C_h.e I
      // 378: imul
      // 379: iload 15
      // 37b: iadd
      // 37c: aload 3
      // 37d: getfield net/minecraft/a/a/C_h.d I
      // 380: imul
      // 381: iload 1
      // 382: bipush 1
      // 383: isub
      // 384: iadd
      // 385: baload
      // 386: bipush 15
      // 388: iand
      // 389: iload 17
      // 38b: isub
      // 38c: dup
      // 38d: istore 18
      // 38f: iload 16
      // 391: if_icmple 398
      // 394: iload 18
      // 396: istore 16
      // 398: iload 1
      // 399: aload 3
      // 39a: getfield net/minecraft/a/a/C_h.d I
      // 39d: bipush 1
      // 39e: isub
      // 39f: if_icmpge 3cc
      // 3a2: aload 3
      // 3a3: getfield net/minecraft/a/a/C_h.h [B
      // 3a6: iload 14
      // 3a8: aload 3
      // 3a9: getfield net/minecraft/a/a/C_h.e I
      // 3ac: imul
      // 3ad: iload 15
      // 3af: iadd
      // 3b0: aload 3
      // 3b1: getfield net/minecraft/a/a/C_h.d I
      // 3b4: imul
      // 3b5: iload 1
      // 3b6: bipush 1
      // 3b7: iadd
      // 3b8: iadd
      // 3b9: baload
      // 3ba: bipush 15
      // 3bc: iand
      // 3bd: iload 17
      // 3bf: isub
      // 3c0: dup
      // 3c1: istore 18
      // 3c3: iload 16
      // 3c5: if_icmple 3cc
      // 3c8: iload 18
      // 3ca: istore 16
      // 3cc: iload 14
      // 3ce: ifle 3fb
      // 3d1: aload 3
      // 3d2: getfield net/minecraft/a/a/C_h.h [B
      // 3d5: iload 14
      // 3d7: bipush 1
      // 3d8: isub
      // 3d9: aload 3
      // 3da: getfield net/minecraft/a/a/C_h.e I
      // 3dd: imul
      // 3de: iload 15
      // 3e0: iadd
      // 3e1: aload 3
      // 3e2: getfield net/minecraft/a/a/C_h.d I
      // 3e5: imul
      // 3e6: iload 1
      // 3e7: iadd
      // 3e8: baload
      // 3e9: bipush 15
      // 3eb: iand
      // 3ec: iload 17
      // 3ee: isub
      // 3ef: dup
      // 3f0: istore 18
      // 3f2: iload 16
      // 3f4: if_icmple 3fb
      // 3f7: iload 18
      // 3f9: istore 16
      // 3fb: iload 14
      // 3fd: aload 3
      // 3fe: getfield net/minecraft/a/a/C_h.f I
      // 401: bipush 1
      // 402: isub
      // 403: if_icmpge 430
      // 406: aload 3
      // 407: getfield net/minecraft/a/a/C_h.h [B
      // 40a: iload 14
      // 40c: bipush 1
      // 40d: iadd
      // 40e: aload 3
      // 40f: getfield net/minecraft/a/a/C_h.e I
      // 412: imul
      // 413: iload 15
      // 415: iadd
      // 416: aload 3
      // 417: getfield net/minecraft/a/a/C_h.d I
      // 41a: imul
      // 41b: iload 1
      // 41c: iadd
      // 41d: baload
      // 41e: bipush 15
      // 420: iand
      // 421: iload 17
      // 423: isub
      // 424: dup
      // 425: istore 18
      // 427: iload 16
      // 429: if_icmple 430
      // 42c: iload 18
      // 42e: istore 16
      // 430: iload 15
      // 432: ifle 45f
      // 435: aload 3
      // 436: getfield net/minecraft/a/a/C_h.h [B
      // 439: iload 14
      // 43b: aload 3
      // 43c: getfield net/minecraft/a/a/C_h.e I
      // 43f: imul
      // 440: iload 15
      // 442: bipush 1
      // 443: isub
      // 444: iadd
      // 445: aload 3
      // 446: getfield net/minecraft/a/a/C_h.d I
      // 449: imul
      // 44a: iload 1
      // 44b: iadd
      // 44c: baload
      // 44d: bipush 15
      // 44f: iand
      // 450: iload 17
      // 452: isub
      // 453: dup
      // 454: istore 18
      // 456: iload 16
      // 458: if_icmple 45f
      // 45b: iload 18
      // 45d: istore 16
      // 45f: iload 15
      // 461: aload 3
      // 462: getfield net/minecraft/a/a/C_h.e I
      // 465: bipush 1
      // 466: isub
      // 467: if_icmpge 494
      // 46a: aload 3
      // 46b: getfield net/minecraft/a/a/C_h.h [B
      // 46e: iload 14
      // 470: aload 3
      // 471: getfield net/minecraft/a/a/C_h.e I
      // 474: imul
      // 475: iload 15
      // 477: bipush 1
      // 478: iadd
      // 479: iadd
      // 47a: aload 3
      // 47b: getfield net/minecraft/a/a/C_h.d I
      // 47e: imul
      // 47f: iload 1
      // 480: iadd
      // 481: baload
      // 482: bipush 15
      // 484: iand
      // 485: iload 17
      // 487: isub
      // 488: dup
      // 489: istore 18
      // 48b: iload 16
      // 48d: if_icmple 494
      // 490: iload 18
      // 492: istore 16
      // 494: iload 16
      // 496: getstatic net/minecraft/a/a/b/Block.h [I
      // 499: iload 13
      // 49b: iaload
      // 49c: if_icmpge 4a7
      // 49f: getstatic net/minecraft/a/a/b/Block.h [I
      // 4a2: iload 13
      // 4a4: iaload
      // 4a5: istore 16
      // 4a7: aload 3
      // 4a8: getfield net/minecraft/a/a/C_h.h [B
      // 4ab: iload 14
      // 4ad: aload 3
      // 4ae: getfield net/minecraft/a/a/C_h.e I
      // 4b1: imul
      // 4b2: iload 15
      // 4b4: iadd
      // 4b5: aload 3
      // 4b6: getfield net/minecraft/a/a/C_h.d I
      // 4b9: imul
      // 4ba: iload 1
      // 4bb: iadd
      // 4bc: baload
      // 4bd: bipush 15
      // 4bf: iand
      // 4c0: dup
      // 4c1: istore 17
      // 4c3: iload 16
      // 4c5: if_icmpeq 853
      // 4c8: aload 3
      // 4c9: getfield net/minecraft/a/a/C_h.h [B
      // 4cc: iload 14
      // 4ce: aload 3
      // 4cf: getfield net/minecraft/a/a/C_h.e I
      // 4d2: imul
      // 4d3: iload 15
      // 4d5: iadd
      // 4d6: aload 3
      // 4d7: getfield net/minecraft/a/a/C_h.d I
      // 4da: imul
      // 4db: iload 1
      // 4dc: iadd
      // 4dd: aload 3
      // 4de: getfield net/minecraft/a/a/C_h.h [B
      // 4e1: iload 14
      // 4e3: aload 3
      // 4e4: getfield net/minecraft/a/a/C_h.e I
      // 4e7: imul
      // 4e8: iload 15
      // 4ea: iadd
      // 4eb: aload 3
      // 4ec: getfield net/minecraft/a/a/C_h.d I
      // 4ef: imul
      // 4f0: iload 1
      // 4f1: iadd
      // 4f2: baload
      // 4f3: sipush 240
      // 4f6: iand
      // 4f7: iload 16
      // 4f9: iadd
      // 4fa: i2b
      // 4fb: bastore
      // 4fc: iload 1
      // 4fd: ifle 576
      // 500: aload 3
      // 501: getfield net/minecraft/a/a/C_h.h [B
      // 504: iload 14
      // 506: aload 3
      // 507: getfield net/minecraft/a/a/C_h.e I
      // 50a: imul
      // 50b: iload 15
      // 50d: iadd
      // 50e: aload 3
      // 50f: getfield net/minecraft/a/a/C_h.d I
      // 512: imul
      // 513: iload 1
      // 514: bipush 1
      // 515: isub
      // 516: iadd
      // 517: baload
      // 518: bipush 15
      // 51a: iand
      // 51b: iload 16
      // 51d: bipush 1
      // 51e: isub
      // 51f: if_icmpeq 576
      // 522: iload 1
      // 523: bipush 1
      // 524: isub
      // 525: iload 14
      // 527: aload 3
      // 528: getfield net/minecraft/a/a/C_h.d I
      // 52b: imul
      // 52c: iadd
      // 52d: iload 15
      // 52f: aload 3
      // 530: getfield net/minecraft/a/a/C_h.d I
      // 533: imul
      // 534: aload 3
      // 535: getfield net/minecraft/a/a/C_h.f I
      // 538: imul
      // 539: iadd
      // 53a: istore 13
      // 53c: aload 3
      // 53d: getfield net/minecraft/a/a/C_h.o [B
      // 540: iload 13
      // 542: bipush 3
      // 543: ishr
      // 544: baload
      // 545: bipush 1
      // 546: iload 13
      // 548: bipush 7
      // 54a: iand
      // 54b: ishl
      // 54c: iand
      // 54d: ifne 576
      // 550: aload 3
      // 551: getfield net/minecraft/a/a/C_h.o [B
      // 554: iload 13
      // 556: bipush 3
      // 557: ishr
      // 558: dup2
      // 559: baload
      // 55a: bipush 1
      // 55b: iload 13
      // 55d: bipush 7
      // 55f: iand
      // 560: ishl
      // 561: ior
      // 562: i2b
      // 563: bastore
      // 564: aload 3
      // 565: getfield net/minecraft/a/a/C_h.n [I
      // 568: aload 3
      // 569: dup
      // 56a: getfield net/minecraft/a/a/C_h.a I
      // 56d: dup_x1
      // 56e: bipush 1
      // 56f: iadd
      // 570: putfield net/minecraft/a/a/C_h.a I
      // 573: iload 13
      // 575: iastore
      // 576: iload 1
      // 577: aload 3
      // 578: getfield net/minecraft/a/a/C_h.d I
      // 57b: bipush 1
      // 57c: isub
      // 57d: if_icmpge 5f6
      // 580: aload 3
      // 581: getfield net/minecraft/a/a/C_h.h [B
      // 584: iload 14
      // 586: aload 3
      // 587: getfield net/minecraft/a/a/C_h.e I
      // 58a: imul
      // 58b: iload 15
      // 58d: iadd
      // 58e: aload 3
      // 58f: getfield net/minecraft/a/a/C_h.d I
      // 592: imul
      // 593: iload 1
      // 594: bipush 1
      // 595: iadd
      // 596: iadd
      // 597: baload
      // 598: bipush 15
      // 59a: iand
      // 59b: iload 16
      // 59d: bipush 1
      // 59e: isub
      // 59f: if_icmpeq 5f6
      // 5a2: iload 1
      // 5a3: bipush 1
      // 5a4: iadd
      // 5a5: iload 14
      // 5a7: aload 3
      // 5a8: getfield net/minecraft/a/a/C_h.d I
      // 5ab: imul
      // 5ac: iadd
      // 5ad: iload 15
      // 5af: aload 3
      // 5b0: getfield net/minecraft/a/a/C_h.d I
      // 5b3: imul
      // 5b4: aload 3
      // 5b5: getfield net/minecraft/a/a/C_h.f I
      // 5b8: imul
      // 5b9: iadd
      // 5ba: istore 13
      // 5bc: aload 3
      // 5bd: getfield net/minecraft/a/a/C_h.o [B
      // 5c0: iload 13
      // 5c2: bipush 3
      // 5c3: ishr
      // 5c4: baload
      // 5c5: bipush 1
      // 5c6: iload 13
      // 5c8: bipush 7
      // 5ca: iand
      // 5cb: ishl
      // 5cc: iand
      // 5cd: ifne 5f6
      // 5d0: aload 3
      // 5d1: getfield net/minecraft/a/a/C_h.o [B
      // 5d4: iload 13
      // 5d6: bipush 3
      // 5d7: ishr
      // 5d8: dup2
      // 5d9: baload
      // 5da: bipush 1
      // 5db: iload 13
      // 5dd: bipush 7
      // 5df: iand
      // 5e0: ishl
      // 5e1: ior
      // 5e2: i2b
      // 5e3: bastore
      // 5e4: aload 3
      // 5e5: getfield net/minecraft/a/a/C_h.n [I
      // 5e8: aload 3
      // 5e9: dup
      // 5ea: getfield net/minecraft/a/a/C_h.a I
      // 5ed: dup_x1
      // 5ee: bipush 1
      // 5ef: iadd
      // 5f0: putfield net/minecraft/a/a/C_h.a I
      // 5f3: iload 13
      // 5f5: iastore
      // 5f6: iload 14
      // 5f8: ifle 671
      // 5fb: aload 3
      // 5fc: getfield net/minecraft/a/a/C_h.h [B
      // 5ff: iload 14
      // 601: bipush 1
      // 602: isub
      // 603: aload 3
      // 604: getfield net/minecraft/a/a/C_h.e I
      // 607: imul
      // 608: iload 15
      // 60a: iadd
      // 60b: aload 3
      // 60c: getfield net/minecraft/a/a/C_h.d I
      // 60f: imul
      // 610: iload 1
      // 611: iadd
      // 612: baload
      // 613: bipush 15
      // 615: iand
      // 616: iload 16
      // 618: bipush 1
      // 619: isub
      // 61a: if_icmpeq 671
      // 61d: iload 1
      // 61e: iload 14
      // 620: bipush 1
      // 621: isub
      // 622: aload 3
      // 623: getfield net/minecraft/a/a/C_h.d I
      // 626: imul
      // 627: iadd
      // 628: iload 15
      // 62a: aload 3
      // 62b: getfield net/minecraft/a/a/C_h.d I
      // 62e: imul
      // 62f: aload 3
      // 630: getfield net/minecraft/a/a/C_h.f I
      // 633: imul
      // 634: iadd
      // 635: istore 13
      // 637: aload 3
      // 638: getfield net/minecraft/a/a/C_h.o [B
      // 63b: iload 13
      // 63d: bipush 3
      // 63e: ishr
      // 63f: baload
      // 640: bipush 1
      // 641: iload 13
      // 643: bipush 7
      // 645: iand
      // 646: ishl
      // 647: iand
      // 648: ifne 671
      // 64b: aload 3
      // 64c: getfield net/minecraft/a/a/C_h.o [B
      // 64f: iload 13
      // 651: bipush 3
      // 652: ishr
      // 653: dup2
      // 654: baload
      // 655: bipush 1
      // 656: iload 13
      // 658: bipush 7
      // 65a: iand
      // 65b: ishl
      // 65c: ior
      // 65d: i2b
      // 65e: bastore
      // 65f: aload 3
      // 660: getfield net/minecraft/a/a/C_h.n [I
      // 663: aload 3
      // 664: dup
      // 665: getfield net/minecraft/a/a/C_h.a I
      // 668: dup_x1
      // 669: bipush 1
      // 66a: iadd
      // 66b: putfield net/minecraft/a/a/C_h.a I
      // 66e: iload 13
      // 670: iastore
      // 671: iload 14
      // 673: aload 3
      // 674: getfield net/minecraft/a/a/C_h.f I
      // 677: bipush 1
      // 678: isub
      // 679: if_icmpge 6f2
      // 67c: aload 3
      // 67d: getfield net/minecraft/a/a/C_h.h [B
      // 680: iload 14
      // 682: bipush 1
      // 683: iadd
      // 684: aload 3
      // 685: getfield net/minecraft/a/a/C_h.e I
      // 688: imul
      // 689: iload 15
      // 68b: iadd
      // 68c: aload 3
      // 68d: getfield net/minecraft/a/a/C_h.d I
      // 690: imul
      // 691: iload 1
      // 692: iadd
      // 693: baload
      // 694: bipush 15
      // 696: iand
      // 697: iload 16
      // 699: bipush 1
      // 69a: isub
      // 69b: if_icmpeq 6f2
      // 69e: iload 1
      // 69f: iload 14
      // 6a1: bipush 1
      // 6a2: iadd
      // 6a3: aload 3
      // 6a4: getfield net/minecraft/a/a/C_h.d I
      // 6a7: imul
      // 6a8: iadd
      // 6a9: iload 15
      // 6ab: aload 3
      // 6ac: getfield net/minecraft/a/a/C_h.d I
      // 6af: imul
      // 6b0: aload 3
      // 6b1: getfield net/minecraft/a/a/C_h.f I
      // 6b4: imul
      // 6b5: iadd
      // 6b6: istore 13
      // 6b8: aload 3
      // 6b9: getfield net/minecraft/a/a/C_h.o [B
      // 6bc: iload 13
      // 6be: bipush 3
      // 6bf: ishr
      // 6c0: baload
      // 6c1: bipush 1
      // 6c2: iload 13
      // 6c4: bipush 7
      // 6c6: iand
      // 6c7: ishl
      // 6c8: iand
      // 6c9: ifne 6f2
      // 6cc: aload 3
      // 6cd: getfield net/minecraft/a/a/C_h.o [B
      // 6d0: iload 13
      // 6d2: bipush 3
      // 6d3: ishr
      // 6d4: dup2
      // 6d5: baload
      // 6d6: bipush 1
      // 6d7: iload 13
      // 6d9: bipush 7
      // 6db: iand
      // 6dc: ishl
      // 6dd: ior
      // 6de: i2b
      // 6df: bastore
      // 6e0: aload 3
      // 6e1: getfield net/minecraft/a/a/C_h.n [I
      // 6e4: aload 3
      // 6e5: dup
      // 6e6: getfield net/minecraft/a/a/C_h.a I
      // 6e9: dup_x1
      // 6ea: bipush 1
      // 6eb: iadd
      // 6ec: putfield net/minecraft/a/a/C_h.a I
      // 6ef: iload 13
      // 6f1: iastore
      // 6f2: iload 15
      // 6f4: ifle 76d
      // 6f7: aload 3
      // 6f8: getfield net/minecraft/a/a/C_h.h [B
      // 6fb: iload 14
      // 6fd: aload 3
      // 6fe: getfield net/minecraft/a/a/C_h.e I
      // 701: imul
      // 702: iload 15
      // 704: bipush 1
      // 705: isub
      // 706: iadd
      // 707: aload 3
      // 708: getfield net/minecraft/a/a/C_h.d I
      // 70b: imul
      // 70c: iload 1
      // 70d: iadd
      // 70e: baload
      // 70f: bipush 15
      // 711: iand
      // 712: iload 16
      // 714: bipush 1
      // 715: isub
      // 716: if_icmpeq 76d
      // 719: iload 1
      // 71a: iload 14
      // 71c: aload 3
      // 71d: getfield net/minecraft/a/a/C_h.d I
      // 720: imul
      // 721: iadd
      // 722: iload 15
      // 724: bipush 1
      // 725: isub
      // 726: aload 3
      // 727: getfield net/minecraft/a/a/C_h.d I
      // 72a: imul
      // 72b: aload 3
      // 72c: getfield net/minecraft/a/a/C_h.f I
      // 72f: imul
      // 730: iadd
      // 731: istore 13
      // 733: aload 3
      // 734: getfield net/minecraft/a/a/C_h.o [B
      // 737: iload 13
      // 739: bipush 3
      // 73a: ishr
      // 73b: baload
      // 73c: bipush 1
      // 73d: iload 13
      // 73f: bipush 7
      // 741: iand
      // 742: ishl
      // 743: iand
      // 744: ifne 76d
      // 747: aload 3
      // 748: getfield net/minecraft/a/a/C_h.o [B
      // 74b: iload 13
      // 74d: bipush 3
      // 74e: ishr
      // 74f: dup2
      // 750: baload
      // 751: bipush 1
      // 752: iload 13
      // 754: bipush 7
      // 756: iand
      // 757: ishl
      // 758: ior
      // 759: i2b
      // 75a: bastore
      // 75b: aload 3
      // 75c: getfield net/minecraft/a/a/C_h.n [I
      // 75f: aload 3
      // 760: dup
      // 761: getfield net/minecraft/a/a/C_h.a I
      // 764: dup_x1
      // 765: bipush 1
      // 766: iadd
      // 767: putfield net/minecraft/a/a/C_h.a I
      // 76a: iload 13
      // 76c: iastore
      // 76d: iload 15
      // 76f: aload 3
      // 770: getfield net/minecraft/a/a/C_h.e I
      // 773: bipush 1
      // 774: isub
      // 775: if_icmpge 7ee
      // 778: aload 3
      // 779: getfield net/minecraft/a/a/C_h.h [B
      // 77c: iload 14
      // 77e: aload 3
      // 77f: getfield net/minecraft/a/a/C_h.e I
      // 782: imul
      // 783: iload 15
      // 785: bipush 1
      // 786: iadd
      // 787: iadd
      // 788: aload 3
      // 789: getfield net/minecraft/a/a/C_h.d I
      // 78c: imul
      // 78d: iload 1
      // 78e: iadd
      // 78f: baload
      // 790: bipush 15
      // 792: iand
      // 793: iload 16
      // 795: bipush 1
      // 796: isub
      // 797: if_icmpeq 7ee
      // 79a: iload 1
      // 79b: iload 14
      // 79d: aload 3
      // 79e: getfield net/minecraft/a/a/C_h.d I
      // 7a1: imul
      // 7a2: iadd
      // 7a3: iload 15
      // 7a5: bipush 1
      // 7a6: iadd
      // 7a7: aload 3
      // 7a8: getfield net/minecraft/a/a/C_h.d I
      // 7ab: imul
      // 7ac: aload 3
      // 7ad: getfield net/minecraft/a/a/C_h.f I
      // 7b0: imul
      // 7b1: iadd
      // 7b2: istore 13
      // 7b4: aload 3
      // 7b5: getfield net/minecraft/a/a/C_h.o [B
      // 7b8: iload 13
      // 7ba: bipush 3
      // 7bb: ishr
      // 7bc: baload
      // 7bd: bipush 1
      // 7be: iload 13
      // 7c0: bipush 7
      // 7c2: iand
      // 7c3: ishl
      // 7c4: iand
      // 7c5: ifne 7ee
      // 7c8: aload 3
      // 7c9: getfield net/minecraft/a/a/C_h.o [B
      // 7cc: iload 13
      // 7ce: bipush 3
      // 7cf: ishr
      // 7d0: dup2
      // 7d1: baload
      // 7d2: bipush 1
      // 7d3: iload 13
      // 7d5: bipush 7
      // 7d7: iand
      // 7d8: ishl
      // 7d9: ior
      // 7da: i2b
      // 7db: bastore
      // 7dc: aload 3
      // 7dd: getfield net/minecraft/a/a/C_h.n [I
      // 7e0: aload 3
      // 7e1: dup
      // 7e2: getfield net/minecraft/a/a/C_h.a I
      // 7e5: dup_x1
      // 7e6: bipush 1
      // 7e7: iadd
      // 7e8: putfield net/minecraft/a/a/C_h.a I
      // 7eb: iload 13
      // 7ed: iastore
      // 7ee: iload 5
      // 7f0: sipush -999
      // 7f3: if_icmpne 80c
      // 7f6: iload 1
      // 7f7: istore 5
      // 7f9: iload 1
      // 7fa: istore 6
      // 7fc: iload 14
      // 7fe: istore 7
      // 800: iload 14
      // 802: istore 8
      // 804: iload 15
      // 806: istore 9
      // 808: iload 15
      // 80a: istore 10
      // 80c: iload 1
      // 80d: iload 5
      // 80f: if_icmpge 818
      // 812: iload 1
      // 813: istore 5
      // 815: goto 821
      // 818: iload 1
      // 819: iload 6
      // 81b: if_icmple 821
      // 81e: iload 1
      // 81f: istore 6
      // 821: iload 14
      // 823: iload 8
      // 825: if_icmple 82f
      // 828: iload 14
      // 82a: istore 8
      // 82c: goto 83a
      // 82f: iload 14
      // 831: iload 7
      // 833: if_icmpge 83a
      // 836: iload 14
      // 838: istore 7
      // 83a: iload 15
      // 83c: iload 9
      // 83e: if_icmpge 848
      // 841: iload 15
      // 843: istore 9
      // 845: goto 1fd
      // 848: iload 15
      // 84a: iload 10
      // 84c: if_icmple 853
      // 84f: iload 15
      // 851: istore 10
      // 853: goto 1fd
      // 856: iload 5
      // 858: sipush -999
      // 85b: if_icmple 87c
      // 85e: aload 3
      // 85f: getfield net/minecraft/a/a/C_h.j Ljava/util/List;
      // 862: new net/minecraft/a/a/C_c
      // 865: dup
      // 866: aload 3
      // 867: iload 5
      // 869: iload 7
      // 86b: iload 9
      // 86d: iload 6
      // 86f: iload 8
      // 871: iload 10
      // 873: invokespecial net/minecraft/a/a/C_c.<init> (Lnet/minecraft/a/a/C_h;IIIIII)V
      // 876: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 87b: pop
      // 87c: iload 12
      // 87e: dup
      // 87f: istore 3
      // 880: ifle 885
      // 883: bipush 1
      // 884: istore 3
      // 885: iinc 2 1
      // 888: goto 09c
      // 88b: return
   }

   public final String b() {
      return "" + (this.k.size() + this.j.size());
   }
}
