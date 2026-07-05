#!/bin/bash
#
# Rebuilds the Indev+ language patch.
#
#   ./build.sh <input-customjar.jar> <output-customjar.jar>
#
# <input> must be an Indev+ jar WITHOUT this language mod already applied
# (running the patch twice would add a second language button). Java 8+ and
# `curl`/`unzip`/`jar` are required. Dependencies (LWJGL 2, ASM, Javassist)
# are downloaded into ./libs on first run.
#
set -e
cd "$(dirname "$0")"
IN="${1:?usage: build.sh <input.jar> <output.jar>}"
OUT="${2:?usage: build.sh <input.jar> <output.jar>}"
# Resolve to absolute paths so the `cd`-into-subshell jar updates below work
# regardless of whether the caller passed relative or absolute paths.
IN="$(realpath "$IN")"
mkdir -p "$(dirname "$OUT")"
OUT="$(realpath -m "$OUT")"

LIBS=libs
mkdir -p "$LIBS" build/classes build/patched
fetch() { [ -f "$LIBS/$1" ] || curl -sSL -o "$LIBS/$1" "$2"; }
fetch lwjgl-2.9.3.jar       https://repo1.maven.org/maven2/org/lwjgl/lwjgl/lwjgl/2.9.3/lwjgl-2.9.3.jar
fetch lwjgl_util-2.9.3.jar  https://repo1.maven.org/maven2/org/lwjgl/lwjgl/lwjgl_util/2.9.3/lwjgl_util-2.9.3.jar
fetch asm-9.7.jar           https://repo1.maven.org/maven2/org/ow2/asm/asm/9.7/asm-9.7.jar
fetch asm-commons-9.7.jar   https://repo1.maven.org/maven2/org/ow2/asm/asm-commons/9.7/asm-commons-9.7.jar
fetch asm-tree-9.7.jar      https://repo1.maven.org/maven2/org/ow2/asm/asm-tree/9.7/asm-tree-9.7.jar
fetch asm-analysis-9.7.jar  https://repo1.maven.org/maven2/org/ow2/asm/asm-analysis/9.7/asm-analysis-9.7.jar
fetch javassist-3.30.2-GA.jar https://repo1.maven.org/maven2/org/javassist/javassist/3.30.2-GA/javassist-3.30.2-GA.jar

LW=$LIBS/lwjgl-2.9.3.jar; LWU=$LIBS/lwjgl_util-2.9.3.jar
ASM="$LIBS/asm-9.7.jar:$LIBS/asm-commons-9.7.jar:$LIBS/asm-tree-9.7.jar:$LIBS/asm-analysis-9.7.jar"
JAS=$LIBS/javassist-3.30.2-GA.jar

rm -rf build/classes build/patched; mkdir -p build/classes build/patched

# 1. Compile the runtime localization class against the (obfuscated) game jar.
javac --release 8 -encoding UTF-8 -cp "$IN:$LW:$LWU" -d build/classes \
      src/net/minecraft/client/Lang.java
# 2. Compile the bytecode patchers.
javac -cp "$ASM:$JAS" -d build/classes patch/StringPatch.java patch/StructPatch.java
# 3. Strip the Legacy+ branding strings from every class.
java -cp "build/classes:$ASM" StringPatch "$IN" "$OUT"
# 4. Add Lang.class + built-in language files into the jar.
( cd build/classes && jar uf "$OUT" net/minecraft/client/Lang.class )
( cd res && jar uf "$OUT" lang/en_US.lang lang/ru_RU.lang )
# 5. Wrap the font renderer + add the main-menu language button.
java -cp "build/classes:$JAS:$LW:$LWU" StructPatch "$OUT" build/patched "$LW" "$LWU"
( cd build/patched && jar uf "$OUT" \
      net/minecraft/client/c/j.class net/minecraft/client/c/at.class )

echo "Built: $OUT"
