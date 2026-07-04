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
