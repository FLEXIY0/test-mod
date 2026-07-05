#!/usr/bin/env python3
"""Rewrite a zip/jar deterministically so identical content yields identical bytes.

`jar uf` produces non-reproducible archives (varying entry order and
compression), which churns the jar in git on every build even when no bytecode
changed. This pass rewrites the jar with a stable layout:
  - unique entries, sorted by name (META-INF/MANIFEST.MF first)
  - fixed timestamp (2010-01-01)
  - fixed deflate compression

The JVM does not care about entry order or compression, and PrismLauncher
supplies the main class externally, so reordering is safe.
"""
import os
import sys
import zipfile

FIXED_DATE = (2010, 1, 1, 0, 0, 0)


def main(path):
    with zipfile.ZipFile(path) as zin:
        # dedupe by name, keep last occurrence
        data = {}
        for info in zin.infolist():
            data[info.filename] = zin.read(info.filename)

    manifest = "META-INF/MANIFEST.MF"
    names = sorted(data)
    if manifest in data:
        names.remove(manifest)
        names.insert(0, manifest)

    tmp = path + ".norm"
    with zipfile.ZipFile(tmp, "w", zipfile.ZIP_DEFLATED) as zout:
        for name in names:
            zi = zipfile.ZipInfo(name, date_time=FIXED_DATE)
            zi.compress_type = zipfile.ZIP_DEFLATED
            zi.external_attr = 0o644 << 16
            zout.writestr(zi, data[name])
    os.replace(tmp, path)


if __name__ == "__main__":
    main(sys.argv[1])
