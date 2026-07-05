#!/usr/bin/env python3
"""
Apply the beta-names.csv class renames to Java source trees, package-aware so
simple-name collisions across packages are never confused:

  * exact fully-qualified refs (net.minecraft.a.a.b.C_x) -> new FQ, always.
  * a bare simple name (C_x) is renamed only in a file that either DEFINES that
    class or IMPORTS exactly that FQ — and only when standalone (a negative
    lookbehind skips any dotted/word-joined occurrence, so a different class's
    FQ tail like net.minecraft.a.b.C_x is left alone).
  * the class's own .java file is moved to the new simple name.
"""
import os, re, sys

CSV = sys.argv[1]
TREES = sys.argv[2:]

renames = []  # (old_slash, new_slash)
for line in open(CSV, encoding="utf-8"):
    line = line.strip()
    if not line or line.startswith("#"):
        continue
    a, b = [x.strip() for x in line.split(",")]
    renames.append((a, b))

def process():
    changed = 0
    moves = []
    for tree in TREES:
        for root, _, files in os.walk(tree):
            for fn in files:
                if not fn.endswith(".java"):
                    continue
                path = os.path.join(root, fn)
                rel = os.path.relpath(path, tree).replace(os.sep, "/")
                with open(path, encoding="utf-8") as f:
                    orig = f.read()
                text = orig
                for old_s, new_s in renames:
                    old_fq = old_s.replace("/", ".")
                    new_fq = new_s.replace("/", ".")
                    old_simple = old_s.rsplit("/", 1)[1]
                    new_simple = new_s.rsplit("/", 1)[1]
                    imports_it = ("import " + old_fq + ";") in orig
                    is_definer = rel[:-5] == old_s  # path == old_slash + ".java"
                    # same package -> simple name is visible without an import ...
                    same_pkg = os.path.dirname(rel) == os.path.dirname(old_s)
                    # ... UNLESS an explicit import of the same simple name from a
                    # different package shadows it (an import wins over same-package).
                    conflict = re.search(r"(?m)^\s*import\s+([\w.]+\." + re.escape(old_simple) + r")\s*;", orig)
                    shadowed = bool(conflict) and conflict.group(1) != old_fq
                    text = text.replace(old_fq, new_fq)
                    if imports_it or is_definer or (same_pkg and not shadowed):
                        text = re.sub(r"(?<![\w.])" + re.escape(old_simple) + r"(?![\w])",
                                      new_simple, text)
                    if is_definer:
                        moves.append((path, os.path.join(root, new_simple + ".java")))
                if text != orig:
                    with open(path, "w", encoding="utf-8") as f:
                        f.write(text)
                    changed += 1
    for src, dst in moves:
        if os.path.exists(src) and src != dst:
            os.rename(src, dst)
    print("rewrote %d files, moved %d defining files" % (changed, len(moves)))

process()
