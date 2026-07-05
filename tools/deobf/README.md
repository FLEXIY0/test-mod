# Деобфускация Indev+ customjar

`Remap.java` — ASM-ремаппер: переименовывает обфусцированные классы
(1-3 строчные буквы) в имена из `mappings.csv` либо механические `C_<имя>`,
переносит пакеты `net/minecraft/client/d/*`→`dx/*` и `a/*`→`util/*`, удаляет
протухшие атрибуты EnclosingMethod/InnerClasses. `net/minecraft/client/d`
не переименовывается — это mainClass из меты PrismLauncher.

`VerifyAll.java` — прогоняет каждый класс jar через верификатор байткода JVM.

`fix_decompiler_artifacts.py` — два текстовых фикса декомпилированных
исходников (запускать из dev/reference-src).

Полный конвейер регенерации (нужен только если меняете mappings.csv):

```bash
# зависимости: ASM 9.7 (+commons/tree/analysis), CFR 0.152, Vineflower 1.10.1, LWJGL 2.9.3
javac -cp <asm> -d build Remap.java VerifyAll.java
java  -cp build:<asm> Remap <старый.jar> remapped.jar mappings.csv
java  -cp build VerifyAll remapped.jar <lwjgl.jar> <lwjgl_util.jar>   # 861 OK ожидается
java  -jar cfr.jar remapped.jar --outputdir ../../dev/reference-src --silent true
java  -jar vineflower.jar --silent remapped.jar /tmp/vf-src
# для файлов, где вариант CFR не компилируется, а Vineflower компилируется —
# подставить файл из /tmp/vf-src (в t.ч. net/minecraft/client/d.java)
cd ../../dev/reference-src && python3 ../../tools/deobf/fix_decompiler_artifacts.py
```

Внимание: после смены маппингов старый `dev/src/` может ссылаться на прежние
имена — обновите его вручную.

## Второй проход: бета-имена (RemapBeta) — совместимость с бетой/ReIndev

Первый проход (`Remap.java`) требует исходный обфусцированный jar, которого в
репозитории нет. Чтобы давать классам осмысленные бета-имена уже на
**текущем** (деобфусцированном) jar, есть второй проход:

- `RemapBeta.java` — ASM-ремаппер, переименовывает классы текущего jar по
  полным именам из `beta-names.csv` (`текущееИмя,новоеБетаИмя`). Безопасен при
  коллизиях простых имён (ключ — полное имя). Переименовывает **только классы**;
  имена методов/полей не трогаются (для них — фасад-синонимы отдельно).
- `beta-names.csv` — курируемый список переименований (батчами).
- `source_rename.py` — синхронно правит исходники (`dev/src`, `dev/test`,
  `dev/reference-src`): полные ссылки заменяет всегда; простое имя `C_x` —
  только в файле, который его **определяет**, **импортирует** именно это полное
  имя, или лежит в **том же пакете** (кроме случая, когда простое имя затенено
  явным импортом из другого пакета). Файл класса переносится на новое имя.

Конвейер (батч уже в `beta-names.csv`):

```bash
JAR=../../InDevPlus/libraries/customjar-1.jar
ASM=$(ls ../russian-lang/libs/asm-*.jar | tr '\n' ':')
javac -cp "$ASM" -d /tmp/rb RemapBeta.java
java  -cp "/tmp/rb:$ASM" RemapBeta "$JAR" /tmp/out.jar beta-names.csv
cp /tmp/out.jar "$JAR"                       # заменить jar на переименованный
python3 source_rename.py beta-names.csv ../../dev/src ../../dev/test ../../dev/reference-src
( cd ../.. && ./dev/build.sh && ./dev/test/run.sh )   # пересобрать + прогнать тесты
```

Расширение — добавить строки в `beta-names.csv` и повторить конвейер. Классы
`net/minecraft/client/d` и `MinecraftApplet` не переименовывать (mainClass/аплет
PrismLauncher). Батч 1 уже применён: `C_x→Block`, `C_g→World`, `C_a→TileEntity`.
