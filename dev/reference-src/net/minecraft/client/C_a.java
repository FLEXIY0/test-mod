/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client;

import java.util.Random;
import net.minecraft.client.C_p;
import net.minecraft.client.a.C_d;
import net.minecraft.client.c.ScaledResolution;
import net.minecraft.client.d;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import util.C_b;

public class C_a
implements C_b {
    private String a = "";
    private d b;
    private String c = "";
    private Random rand = new Random();
    private long d;
    private String currentTip = "";
    private String[] tips = new String[]{"Golden weapons increase rare mob drops!", "You can block incoming damage with your sword!", "You can do a sweeping attack with your battleaxe by holding right-click!", "Thrown spears stun mobs for a few seconds!", "Skyrunner boots and climbing gloves make an excellent combo!", "Wooden tools give double drops!", "Wooden weapons have a chance to deal quadruple their damage per hit!", "Golden tools have silk touch!", "Dart guns act like the original bows, meaning they are spammable!", "You can shoot a fireball if your hand is empty while the ring is equipped!", "Wearing the tide amulet allows you to breathe on the moon!", "Equipping the magic mirror lets you respawn any time like in creative!", "You can smelt coral blocks into sponges!", "Right-click a double slab with a pickaxe to split it!", "Lowered water levels will fill up during rain!", "You can smelt antlion pincers into extract!", "Fish fins can be acquired by fishing!", "You can force a blood moon to happen by using a blood pearl!", "Fire on coal blocks will never burn out (except during blood moons)!", "Spring rain causes grass to grow!", "Your torches burn out during blood moons, but lanterns don't!", "You can use pumps to drain large bodies of water and lava!", "Bookshelves can be filled with books!", "Barrels can be used as portable storage!", "Dirt makes for great scaffolding!", "Don't trust the ducks!", "A moon watch shows if the following night will be a blood moon!", "You can strip logs for their bark, which makes paper!", "If you accidentally strip a log, simply right-click with its bark!", "There are five item rarities: common, uncommon, rare, epic & legendary!", "Use dyes to color portals! Different colors take you to different places!", "Some mobs drop special items that can be used to make powerful charms!", "Recipes become visible as you acquire their ingredients!", "Feeling stuck? Use the achievements as a guide!", "Crossbows can only fire adminium-tipped bolts, but are very powerful!", "Crawling on water with the tide amulet equipped will turn it into ice!", "Blood tears are dropped by Ranas on the moon and very useful crafting ingredients!"};

    public C_a(d d2) {
        this.d = System.currentTimeMillis();
        this.b = d2;
    }

    @Override
    public final void a(String string) {
        if (!this.b.A) {
            throw new C_p();
        }
        this.c = string;
        this.currentTip = "\u00a7eTip: \u00a7f" + this.tips[this.rand.nextInt(this.tips.length)];
        ScaledResolution scaledResolution = new ScaledResolution(this.b.w, this.b.b, this.b.c);
        int n = scaledResolution.a();
        int n2 = scaledResolution.b();
        GL11.glClear((int)256);
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        GL11.glOrtho((double)0.0, (double)n, (double)n2, (double)0.0, (double)100.0, (double)300.0);
        GL11.glMatrixMode((int)5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-200.0f);
    }

    @Override
    public final void b(String string) {
        if (!this.b.A) {
            throw new C_p();
        }
        this.d = 0L;
        this.a = string;
        this.a(-1);
        this.d = 0L;
    }

    @Override
    public final void a(int n) {
        if (!this.b.A) {
            throw new C_p();
        }
        long l = System.currentTimeMillis();
        if (l - this.d >= 20L) {
            this.d = l;
            ScaledResolution scaledResolution = new ScaledResolution(this.b.w, this.b.b, this.b.c);
            int n2 = scaledResolution.a();
            int n3 = scaledResolution.b();
            GL11.glClear((int)256);
            GL11.glMatrixMode((int)5889);
            GL11.glLoadIdentity();
            GL11.glOrtho((double)0.0, (double)n2, (double)n3, (double)0.0, (double)100.0, (double)300.0);
            GL11.glMatrixMode((int)5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-200.0f);
            GL11.glClear((int)16640);
            C_d c_d = C_d.a;
            int n4 = this.b.m.a("/dirt.png");
            GL11.glBindTexture((int)3553, (int)n4);
            c_d.b();
            c_d.b(0x404040);
            c_d.a(0.0f, n3, 0.0f, 0.0f, (float)n3 / 32.0f);
            c_d.a(n2, n3, 0.0f, (float)n2 / 32.0f, (float)n3 / 32.0f);
            c_d.a(n2, 0.0f, 0.0f, (float)n2 / 32.0f, 0.0f);
            c_d.a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
            c_d.a();
            if (n >= 0) {
                n4 = n2 / 2 - 50;
                int n5 = n3 / 2 + 16;
                GL11.glDisable((int)3553);
                c_d.b();
                c_d.b(0x808080);
                c_d.b(n4, n5, 0.0f);
                c_d.b(n4, n5 + 2, 0.0f);
                c_d.b(n4 + 100, n5 + 2, 0.0f);
                c_d.b(n4 + 100, n5, 0.0f);
                c_d.b(0x80FF80);
                c_d.b(n4, n5, 0.0f);
                c_d.b(n4, n5 + 2, 0.0f);
                c_d.b(n4 + n, n5 + 2, 0.0f);
                c_d.b(n4 + n, n5, 0.0f);
                c_d.a();
                GL11.glEnable((int)3553);
            }
            this.b.n.a(this.c, (n2 - this.b.n.a(this.c)) / 2, n3 / 2 - 4 - 16, 0xFFFFFF);
            this.b.n.a(this.a, (n2 - this.b.n.a(this.a)) / 2, n3 / 2 - 4 + 8, 0xFFFFFF);
            this.b.n.a(this.currentTip, (n2 - this.b.n.a(this.currentTip)) / 2, n3 - 12, 0xFFFFFF);
            Display.update();
            try {
                Thread.yield();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }
}

