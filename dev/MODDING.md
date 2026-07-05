# Расширение Indev++ — платформа

Цель: добавлять контент и поведение, **подключаясь** к движку через реестры и
хуки, а не вырезая правки в обфусцированные классы каждый раз. Плюс —
совместимость с бетой/ReIndev на уровне исходников.

## Карта имён (Rosetta)

Классы ядра переименованы в бета-имена (см. `tools/deobf/beta-names.csv`), но
имена **методов/полей** пока обфусцированы — для них есть фасад (`WorldApi`) и
эта шпаргалка.

| Обфускация | Смысл | Примечание |
|---|---|---|
| `net.minecraft.a.a.b.Block` (`C_x`) | Block + реестр блоков (`Block.c[256]`) | статики-блоки, авто-ItemBlock |
| `net.minecraft.a.a.World` (`C_g`) | World | `a(x,y,z)`=getBlockId, `a(x,y,z,id)`=setBlock, `e`=getMeta, `d`=setMeta, `j`=getTileEntity, `spawnEntityInWorld`, `markBlockNeedsUpdate` |
| `net.minecraft.a.a.b.a.TileEntity` (`C_a`) | TileEntity база | `a`=world, `b/c/d`=x/y/z, `d()`=тик, `a(nbt)`/`b(nbt)`=read/write |
| `net.minecraft.a.a.C_o` | реестр тайл-энтити | `addMapping(class,"Name")` |
| `net.minecraft.a.b.Item` | Item + реестр (`Item.b[1024]`) | `ap`=id, `as`=иконка |
| `net.minecraft.a.b.ItemStack` | ItemStack | `a`=count, `c`=itemID, `d`=meta |
| `net.minecraft.a.b.a.C_f` | CraftingManager | `a(result, "###", ..., '#', ingr)`=shaped |
| `net.minecraft.a.c.e.EntityPlayer` | игрок (не компилируется — 43 файла) | `S`=hp, `addHealth`, `J`=огонь, `k/l/m`=motion, `nightVision`, `b`=инвентарь |
| `net.minecraft.a.c.c.C_b` | EntityItem | `new C_b(world,x,y,z,stack)`, `.O`=задержка |
| `net.minecraft.client.d` | Minecraft (главный, **не переименовывать**) | `f`=игрок |

## Как добавить…

**Блок** — статик в `Block` (`dev/src/.../a/a/b/Block.java`), рядом с другими,
до цикла авто-ItemBlock (id < 256, свободные — от 202). Тайл-энтити — через
`BlockContainer` (см. `BlockCauldron`).

**Тайл-энтити** — класс `extends TileEntity`, `d()` тикается как печь, NBT в
`b(nbt)` пишет `nbt.a("id","Имя")`; регистрация в `C_o.addMapping(...)`.

**Предмет** — статик в `Item`, свободный id от 192; метадата-иконки — переопредели
`getIconFromDamage` (см. `ItemPotion`).

**Рецепт** — строка в `C_f` (`this.a(...)` shaped / `addShapelessRecipe`).

**Текстуры** — вживи тайл в атлас (`dev/resources/terrain.png` / `gui/items.png`,
32×32, индекс = row*32+col; свободно от 967). Скрипт-пример — в истории коммитов.

## Хуки событий — `net.minecraft.platform`

Вместо правки игрового цикла фича регистрирует слушателя один раз в
`Platform.init()`:

```java
Hooks.onTick(new Hooks.TickListener() {
    public void onTick(EntityPlayer player) { /* каждый тик */ }
});
```

Движок дёргает `Hooks.fireTick(player)` из `d.java` раз в тик; первый тик лениво
поднимает `Platform.init()`. Так подключены зелья (`PotionManager`). Новые
per-tick фичи добавляют строку в `Platform.init()` и **не трогают** `d.java`.

## Фасад мира — `WorldApi`

Читаемые операции с миром без запоминания обфускации:

```java
int id = WorldApi.getBlockId(world, x, y, z);
WorldApi.setBlockAndMetadata(world, x, y, z, Block.cauldron.at, 1);
TileEntity te = WorldApi.getTileEntity(world, x, y, z);
```

## Тесты

Headless-набор — `dev/test/run.sh` (VerifyAll + сюиты). Новую фичу покрывай
тестом рядом (реестр/логика), GUI/геймплей — проверка в игре.

## Дальше по арке «движок → платформа»
- Фасад-методы прямо на `World`/`Block` (1:1 с бетой) — потребует перекомпиляции
  крупных классов (риск).
- Разблокировать `EntityPlayer`/`RenderEngine` байткод-патчем (`tools/russian-lang`).
- Реестры блоков/предметов/сущностей с чистой регистрацией.
