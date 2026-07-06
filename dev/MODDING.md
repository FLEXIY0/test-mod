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
| `net.minecraft.a.a.TileEntityRegistry` (`C_o`) | реестр тайл-энтити | `addMapping(class,"Name")` |
| `net.minecraft.a.a.d.Material` (`C_c`) | материал блока | `Material.d`=камень и т.п. |
| `net.minecraft.a.b.Item` | Item + реестр (`Item.b[1024]`) | `ap`=id, `as`=иконка |
| `net.minecraft.a.b.ItemStack` | ItemStack | `a`=count, `c`=itemID, `d`=meta |
| `net.minecraft.a.b.a.CraftingManager` (`C_f`) | крафт | `a(result, "###", ..., '#', ingr)`=shaped |
| `net.minecraft.a.c.e.EntityPlayer` | игрок (**разблокирован** — компилируется из dev/src) | `S`=hp, `addHealth`, `J`=огонь, `k/l/m`=motion, `nightVision`, `b`=инвентарь (`InventoryPlayer`) |
| `net.minecraft.a.c.e.InventoryPlayer` (`C_b`) | инвентарь игрока | `a[36]`=слоты, `c`=выбранный, `d()`=в руке, `getDamageVsEntity` |
| `net.minecraft.a.c.a.EntityZombie` (`C_f`) | зомби | база для `EntityPigZombie` |
| `net.minecraft.client.g.EntityPlayerSP` (`C_a`) | локальный игрок клиента | `d.f` — его экземпляр |
| `net.minecraft.a.c.Entity` (`C_b`) | базовая сущность | `spawnEntityInWorld` принимает её |
| `net.minecraft.a.c.EntityLiving` (`C_e`) | живая сущность | `addHealth`, `S`=hp |
| `net.minecraft.a.c.EntityList` (`C_f`) | реестр сущностей | `addMapping(class,"Name",id)` |
| `net.minecraft.a.c.c.EntityItem` (`C_b`) | брошенный предмет | `new EntityItem(world,x,y,z,stack)`, `.O`=задержка |
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
Hooks.onAttack(new Hooks.AttackListener() {          // удар игрока по сущности
    public void onAttack(EntityPlayer p, Entity target, int damage) { ... }
});
Hooks.onBlockBreak(new Hooks.BlockBreakListener() {  // слом блока в выживании
    public void onBlockBreak(World w, int x, int y, int z, int blockId) { ... }
});
```

Точки вызова в движке: `Hooks.fireTick` — из `d.java` (раз в тик, первый тик
лениво поднимает `Platform.init()`); `fireAttack` — из
`EntityPlayer.attackTargetEntityWithCurrentItem` (класс разблокирован);
`fireBlockBreak` — из контроллера выживания (`dx/C_b.sendBlockRemoved`). Так
подключены зелья (`PotionManager`). Новые фичи добавляют строку в
`Platform.init()` и **не трогают** движок.

## Реестры — `ModRegistry`

```java
ModRegistry.registerTileEntity(TileEntityCauldron.class, "Cauldron");
ModRegistry.registerEntity(EntityPigZombie.class, "PigZombie", 94);
ModRegistry.addShapedRecipe(new ItemStack(Block.cauldron), "I I", "I I", "III", 'I', Item.k);
ModRegistry.addShapelessRecipe(new ItemStack(Item.z, 4), Block.m);
```

## Бета-методы прямо на World

`World` перекомпилируется из dev/src и несёт читаемые алиасы 1:1 с бетой —
портируемый код компилируется без правок: `getBlockId`, `setBlock`,
`setBlockWithNotify`, `getBlockMetadata`, `setBlockMetadata` (нативный),
`setBlockAndMetadataWithNotify` (нативный), `getBlockTileEntity`,
`setBlockTileEntity`, `removeBlockTileEntity`, `spawnEntityInWorld` (нативный),
`markBlockNeedsUpdate` (нативный).

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

## Статус арки «движок → платформа»
Сделано: ремап ядровых классов (3 батча), шина событий (tick/attack/block-break),
`WorldApi` + бета-методы прямо на `World`, `ModRegistry`, разблокирован
`EntityPlayer` (5 правок артефактов декомпилятора — теперь обычный dev/src-файл).
Осталось при желании: разблокировать `RenderEngine` тем же способом, добавить
события (`onItemUse`, `onEntitySpawn`), ремапнуть остальные `C_*`.
