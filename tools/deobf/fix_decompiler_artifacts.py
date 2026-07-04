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
