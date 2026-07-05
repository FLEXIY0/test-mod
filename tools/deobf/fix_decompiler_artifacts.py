#!/usr/bin/env python3
"""Post-decompilation fixes for the Indev+ reference sources (run from
dev/reference-src). The tree is CFR output with Vineflower substituted for
files CFR mishandles; two spots need textual repair either way.

1. NetworkManager (CFR): Thread.sleep inside anonymous reader/writer threads
   is rendered as "<n>.sleep(2L)".
2. net/minecraft/client/d (Vineflower): displayGuiScreen(null) calls lack the
   cast that disambiguates a(GuiScreen) from a(C_g).
"""
import re

p = 'net/minecraft/network/NetworkManager.java'
s = open(p, encoding='utf-8').read()
n = len(re.findall(r'\b\d+\.sleep\(2L\)', s))
s = re.sub(r'\b\d+\.sleep\(2L\)', 'Thread.sleep(2L)', s)
open(p, 'w', encoding='utf-8').write(s)
print(f'NetworkManager.java: fixed {n} Thread.sleep call(s)')

p = 'net/minecraft/client/d.java'
s = open(p, encoding='utf-8').read()
n = s.count('this.a(null);')
s = s.replace('this.a(null);', 'this.a((GuiScreen)null);')
open(p, 'w', encoding='utf-8').write(s)
print(f'd.java: disambiguated {n} displayGuiScreen(null) call(s)')

p = 'net/minecraft/client/c/C_l.java'
s = open(p, encoding='utf-8').read()
if 'float f4 = (float)itemStack.b - f;' in s:
    s = s.replace("""                float f3;
                n10 = n2 / 2 - 90 + n11 * 20 + 2;
                n8 = n3 - 16 - 5;
                ItemStack itemStack = this.d.f.b.a[n11];
                if (itemStack == null) continue;
                float f4 = (float)itemStack.b - f;
                if (f3 > 0.0f) {""", """                n10 = n2 / 2 - 90 + n11 * 20 + 2;
                n8 = n3 - 16 - 5;
                ItemStack itemStack = this.d.f.b.a[n11];
                if (itemStack == null) continue;
                float f3 = (float)itemStack.b - f;
                if (f3 > 0.0f) {""")
    s = s.replace('float f5 = 1.0f + f4 / 5.0f;', 'float f5 = 1.0f + f3 / 5.0f;')
    s = s.replace("""                if (f4 > 0.0f) {
                    GL11.glPopMatrix();
                }""", """                if (f3 > 0.0f) {
                    GL11.glPopMatrix();
                }""")
    open(p, 'w', encoding='utf-8').write(s)
    print('C_l.java: hotbar animation variable reunified')
