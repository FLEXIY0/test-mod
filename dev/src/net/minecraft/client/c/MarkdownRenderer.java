/*
 * Draws the spans produced by MarkdownLayout onto the Obsidian Book page.
 * The 8px font has no real bold/italic/size, so:
 *   - bold    -> the run is drawn twice, offset 1px (faux bold)
 *   - italic  -> a shear matrix slants the glyphs
 *   - heading -> a scale matrix enlarges the run
 * Rectangles (rules, underlines, code background, quote bar) are filled with
 * the shared Gui.a() helper.
 */
package net.minecraft.client.c;

import java.nio.FloatBuffer;
import java.util.List;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public final class MarkdownRenderer {

    private static final FloatBuffer SHEAR = makeShear();

    private static FloatBuffer makeShear() {
        FloatBuffer b = BufferUtils.createFloatBuffer(16);
        // column-major: element [row0][col1] = -0.21 => x' = x - 0.21*y (top leans right)
        b.put(new float[]{
                1f, 0f, 0f, 0f,
                -0.21f, 1f, 0f, 0f,
                0f, 0f, 1f, 0f,
                0f, 0f, 0f, 1f});
        b.flip();
        return b;
    }

    /** Render markdown into the page box at (x,y); spans below maxHeight are culled. */
    public static void render(FontRenderer fr, String markdown, final int x, final int y, int width, int maxHeight) {
        List<MarkdownLayout.Span> spans = MarkdownLayout.layout(markdown, width, new MarkdownLayout.Metrics() {
            @Override
            public int width(String s) {
                return fr.a(s);
            }
        });
        // rectangles first (backgrounds), then text on top
        for (MarkdownLayout.Span s : spans) {
            if (s.text != null || s.y > maxHeight) continue;
            int color = s.color;
            if ((color & 0xFF000000) == 0) color |= 0xFF000000;
            Gui.a(x + s.x, y + s.y, x + s.x + s.w, y + s.y + s.h, color);
        }
        for (MarkdownLayout.Span s : spans) {
            if (s.text == null || s.text.length() == 0 || s.y > maxHeight) continue;
            drawText(fr, s, x, y);
        }
    }

    private static void drawText(FontRenderer fr, MarkdownLayout.Span s, int x, int y) {
        GL11.glPushMatrix();
        GL11.glTranslatef(x + s.x, y + s.y, 0f);
        if (s.scale != 1f) {
            GL11.glScalef(s.scale, s.scale, 1f);
        }
        if (s.italic) {
            SHEAR.rewind();
            GL11.glMultMatrix(SHEAR);
            GL11.glTranslatef(1.5f, 0f, 0f);
        }
        fr.b(s.text, 0, 0, s.color);
        if (s.bold) {
            fr.b(s.text, 1, 0, s.color);
        }
        GL11.glPopMatrix();
    }
}
