#!/usr/bin/env bash
# Headless test suite for the Obsidian Book (no display / no LWJGL runtime needed).
# Compiles each test against the instance jar + LWJGL jars and runs it.
#
#   ./dev/test/run.sh
#
# Covers: BookLayout markdown engine (BLTest), the caret-line reveal (RevealTest),
# display pagination (PageTest), mouse hit-testing (MouseTest), and text
# selection + clipboard state machine (SelTest). See dev/FEATURES.md.
set -e
cd "$(dirname "$0")/../.."

JAR=InDevPlus/libraries/customjar-1.jar
CP="$JAR:dev/libs/lwjgl-2.9.3.jar:dev/libs/lwjgl_util-2.9.3.jar"
OUT=$(mktemp -d)
SRC=dev/test

# VerifyAll: every class in the jar passes the JVM bytecode verifier.
echo "=== VerifyAll ==="
javac -d "$OUT" tools/deobf/VerifyAll.java
java -cp "$OUT:$JAR" VerifyAll "$JAR" dev/libs/lwjgl-2.9.3.jar dev/libs/lwjgl_util-2.9.3.jar \
    2>/dev/null | grep -E 'OK, .* failed' || true

run() { # <mainclass> <src> [args...]
    local main="$1"; local src="$2"; shift 2
    javac -cp "$CP" -d "$OUT" "$src" 2>/dev/null
    echo "=== $main ==="
    java -cp "$OUT:$CP" "$main" "$@" 2>/dev/null | tail -2
}

run BLTest    "$SRC/BLTest.java"
run MouseTest "$SRC/MouseTest.java" "$JAR" dev/libs/lwjgl-2.9.3.jar
run net.minecraft.client.c.PageTest   "$SRC/net/minecraft/client/c/PageTest.java"
run net.minecraft.client.c.RevealTest "$SRC/net/minecraft/client/c/RevealTest.java"
run net.minecraft.client.c.SelTest    "$SRC/net/minecraft/client/c/SelTest.java"
run net.minecraft.a.a.b.ReactorTest   "$SRC/net/minecraft/a/a/b/ReactorTest.java"
run net.minecraft.a.a.b.a.CauldronTest "$SRC/net/minecraft/a/a/b/a/CauldronTest.java"

rm -rf "$OUT"
