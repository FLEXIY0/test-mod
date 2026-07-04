# Нативная разработка Indev+ (после деобфускации)

Jar инстанса (`InDevPlus/libraries/customjar-1.jar`) **деобфусцирован
ремаппером** (`tools/deobf/`): все классы переименованы так, что исчез
конфликт «класс = пакет», из-за которого `javac` раньше отказывался
компилировать декомпилированный код. Теперь правки — это обычное
редактирование `.java`-файлов.

## Быстрый цикл правки

```bash
# 1. найдите класс в справочных исходниках
ls dev/reference-src/net/minecraft/client/c/

# 2. скопируйте его в dev/src С СОХРАНЕНИЕМ ПУТИ ПАКЕТА
mkdir -p dev/src/net/minecraft/client/c
cp dev/reference-src/net/minecraft/client/c/GuiScreenBook.java dev/src/net/minecraft/client/c/

# 3. редактируйте dev/src/... в любом редакторе/IDE
#    (в IDE добавьте в classpath: InDevPlus/libraries/customjar-1.jar + LWJGL 2 из dev/libs)

# 4. соберите — классы вживляются в jar инстанса, InDev++.zip пересобирается
./dev/build.sh
```

`dev/reference-src/` — полное декомпилированное дерево (852 файла) для чтения
и копирования. **809 из 852 (95%) компилируются без правок**, включая все
ключевые классы (см. таблицу имён ниже). Файлы в `dev/src/` — ваши активные
правки; всё остальное остаётся оригинальным байткодом (нулевой риск регрессий
в нетронутых классах).

## Таблица главных классов

| Файл | Что это |
|---|---|
| `net/minecraft/client/d.java` | **Minecraft** — главный класс (имя `d` менять нельзя: его вызывает PrismLauncher как mainClass) |
| `net/minecraft/client/GameSettings.java` | настройки/опции |
| `net/minecraft/client/KeyBinding.java` | привязки клавиш |
| `net/minecraft/client/Lang.java` | система языков (исходник: `tools/russian-lang/src/`) |
| `net/minecraft/client/a/RenderEngine.java` | текстуры/рендер |
| `net/minecraft/client/c/FontRenderer.java` | шрифт (здесь хук перевода `Lang.tr`) |
| `net/minecraft/client/c/GuiScreen.java` / `Gui.java` / `GuiButton.java` | база GUI |
| `net/minecraft/client/c/GuiMainMenu.java` | главное меню (здесь кнопка Language) |
| `net/minecraft/client/c/GuiScreenBook.java` | книга с пером |
| `net/minecraft/client/c/GuiOptions.java` / `GuiCredits.java` / `GuiAchievement.java` | экраны |
| `net/minecraft/client/c/ChatAllowedCharacters.java` | разрешённые символы (читает `font.txt`) |
| `net/minecraft/a/b/Item.java` / `ItemStack.java` | предметы |
| `net/minecraft/a/c/e/EntityPlayer.java` | игрок |
| `com/a/a/NBTTagCompound.java` и др. `NBT*` | NBT |
| `util/MathHelper.java` | математика |

Остальные обфусцированные классы названы механически `C_<старое имя>`
(например `net/minecraft/client/c/C_ag.java` — экран чата). Пакет
`net/minecraft/client/d/*` перенесён в `dx/*`, корневой пакет `a/*` — в
`util/*`. Хотите дать классу осмысленное имя — добавьте строку в
`tools/deobf/mappings.csv` и перегенерируйте jar (см. `tools/deobf/`).

## Известные ограничения (43 файла не компилируются)

Обфускатор создал конструкции, невыразимые в исходниках Java (методы,
различающиеся только типом возврата; поля-тёзки разных типов в иерархии), а
на части старых библиотек спотыкаются декомпиляторы. Эти файлы годятся для
чтения, но для их правки используйте байткод-подход из `tools/russian-lang/`
(ASM/Javassist). Полный список:

- библиотеки: `com/jcraft/jorbis/{Floor0,Floor1,Mapping0,Residue0}`,
  `com/mojang/json/{J_CompactJsonFormatter,J_JsonNodeList,J_JsonObjectNodeList}`,
  `paulscode/sound/{Library,MidiChannel,SoundSystem,SoundSystemConfig}`,
  `paulscode/sound/libraries/{LibraryLWJGLOpenAL,SourceLWJGLOpenAL}`
- игровой код: `net/minecraft/a/a/C_a`, `net/minecraft/a/a/b/{C_a,C_ac,C_f,C_s,C_t,C_z}`,
  `net/minecraft/a/c/{C_b,C_c,C_e}`, `net/minecraft/a/c/a/{C_e,C_h,C_i,C_l}`,
  `net/minecraft/a/c/b/{C_a,C_d,C_k}`, `net/minecraft/a/c/c/C_g`,
  `net/minecraft/a/c/e/EntityPlayer`, `net/minecraft/client/a/RenderEngine`,
  `net/minecraft/client/c/{C_ab,C_aq,C_ay,C_az,C_bh,C_e,C_o}`,
  `net/minecraft/client/g/C_d`, `net/minecraft/client/statistics/StatFileWriter`,
  `net/minecraft/network/NetClientHandler`

## Как это было сделано (tools/deobf/)

1. `Remap.java` (ASM) — переименование классов + вычистка протухших
   атрибутов `EnclosingMethod`/`InnerClasses`, оставленных обфускатором
   (JVM их игнорирует, javac — нет).
2. Декомпиляция: CFR + Vineflower, для каждого файла выбран компилируемый
   вариант; два места дочинены `fix_decompiler_artifacts.py`.
3. `VerifyAll.java` — все 861 классов ремапнутого jar проходят верификатор
   байткода JVM; функциональные тесты языковой системы — 10/10.

Сохранения совместимы: сериализации Java и рефлексии по именам классов в
коде нет (проверено), формат мира/книг — NBT со строковыми ключами.
