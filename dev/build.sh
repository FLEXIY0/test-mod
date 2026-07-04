#!/bin/bash
#
# Быстрый цикл правки Indev+:
#   1. скопируйте нужный файл из dev/reference-src/ в dev/src/ (с путём пакета)
#   2. отредактируйте его
#   3. ./build.sh  — скомпилирует dev/src и вживит классы в jar инстанса,
#                    затем пересоберёт InDev++.zip
#
set -e
cd "$(dirname "$0")"
JAR=../InDevPlus/libraries/customjar-1.jar

mkdir -p libs
fetch() { [ -f "libs/$1" ] || curl -sSL -o "libs/$1" "$2"; }
fetch lwjgl-2.9.3.jar      https://repo1.maven.org/maven2/org/lwjgl/lwjgl/lwjgl/2.9.3/lwjgl-2.9.3.jar
fetch lwjgl_util-2.9.3.jar https://repo1.maven.org/maven2/org/lwjgl/lwjgl/lwjgl_util/2.9.3/lwjgl_util-2.9.3.jar

if find src -name '*.java' 2>/dev/null | grep -q .; then
    rm -rf out && mkdir out
    find src -name '*.java' > .build-sources
    javac --release 8 -encoding UTF-8 \
          -cp "$JAR:libs/lwjgl-2.9.3.jar:libs/lwjgl_util-2.9.3.jar" \
          -d out @.build-sources
    rm .build-sources
    jar uf "$JAR" -C out .
    # Normalize the jar deterministically (sorted entries, fixed timestamps,
    # manifest first). `jar uf` order/compression is non-reproducible; without
    # this every build churns the jar bytes even when bytecode is unchanged.
    python3 normalize_zip.py "$JAR"
    echo "Обновлён jar: $(find out -name '*.class' | wc -l) классов"
else
    echo "dev/src пуст — только пересборка zip"
fi

( cd ../InDevPlus && rm -f ../InDev++.zip && zip -r -q -X ../InDev++.zip . && zip -q ../InDev++.zip .packignore )
python3 normalize_zip.py ../InDev++.zip
echo "Готово: InDev++.zip пересобран"
