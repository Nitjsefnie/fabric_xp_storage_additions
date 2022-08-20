package com.notker.xps_additions.regestry;

import com.notker.xp_storage.XpStorage;
import com.notker.xps_additions.XpsAdditions;
import com.notker.xps_additions.items.Mystical_Candy;
import com.notker.xps_additions.items.StaffOfRebark;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class AdditionItems {


    private static BlockItem createBlockItemWithGroup(Block block) {
        return new BlockItem(block, new Item.Settings().group(XpStorage.ITEM_GROUP));
    }

    private static Item.Settings newSettings() {
        return new Item.Settings().group(XpStorage.ITEM_GROUP);
    }



    // Items
    public static final Item MYSTICAL_CANDY = new Mystical_Candy();
    public static final Item RAW_ESSENCE = new Item(newSettings().rarity(Rarity.RARE));
    public static final Item RAW_ESSENCE_SHARD = new Item(newSettings().rarity(Rarity.RARE));
    public static final Item STAFF_OF_REBARK = new StaffOfRebark(newSettings().rarity(Rarity.EPIC).maxDamage(1561));
    public static final Item ESSENCE_CRYSTAL = new Item(newSettings().rarity(Rarity.EPIC));

    //Block Items
    public static final BlockItem SOUL_COPPER_DOOR_ITEM = createBlockItemWithGroup(AdditionBlocks.SOUL_COPPER_DOOR);
    public static final BlockItem SOUL_COPPER_TRAP_DOOR_ITEM = createBlockItemWithGroup(AdditionBlocks.SOUL_COPPER_TRAP_DOOR);
    public static final BlockItem SOUL_COPPER_PRESSURE_PLATE_ITEM = createBlockItemWithGroup(AdditionBlocks.SOUL_COPPER_PRESSURE_PLATE);
    public static final BlockItem SOUL_COPPER_BARS_ITEM = createBlockItemWithGroup(AdditionBlocks.SOUL_COPPER_BARS);
    public static final BlockItem CUT_SOUL_COPPER_ITEM = createBlockItemWithGroup(AdditionBlocks.CUT_SOUL_COPPER);
    public static final BlockItem CUT_SOUL_COPPER_SLAB_ITEM = createBlockItemWithGroup(AdditionBlocks.CUT_SOUL_COPPER_SLAB);
    public static final BlockItem CUT_SOUL_COPPER_STAIRS_ITEM = createBlockItemWithGroup(AdditionBlocks.CUT_SOUL_COPPER_STAIRS);
    public static final BlockItem XP_ITEM_INSERTER_ITEM = createBlockItemWithGroup(AdditionBlocks.XP_ITEM_INSERTER);

    public static void registerItems() {
        //Items
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("mystical_candy"), MYSTICAL_CANDY);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("raw_essence"), RAW_ESSENCE);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("raw_essence_shard"), RAW_ESSENCE_SHARD);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("staff_of_rebark"), STAFF_OF_REBARK);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("essence_crystal"), ESSENCE_CRYSTAL);

        //BlockItems
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("soul_copper_door"), SOUL_COPPER_DOOR_ITEM);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("soul_copper_trap_door"), SOUL_COPPER_TRAP_DOOR_ITEM);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("soul_copper_pressure_plate"), SOUL_COPPER_PRESSURE_PLATE_ITEM);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("soul_copper_bars"), SOUL_COPPER_BARS_ITEM);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("cut_soul_copper"), CUT_SOUL_COPPER_ITEM);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("cut_soul_copper_slab"), CUT_SOUL_COPPER_SLAB_ITEM);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("cut_soul_copper_stairs"), CUT_SOUL_COPPER_STAIRS_ITEM);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("xp_item_inserter"), XP_ITEM_INSERTER_ITEM);

        //Fuel
        FuelRegistry.INSTANCE.add(RAW_ESSENCE, XpsAdditions.RAW_ESSENCE_FUEL_DURATION);
        FuelRegistry.INSTANCE.add(RAW_ESSENCE_SHARD, XpsAdditions.RAW_ESSENCE_SHARD_FUEL_DURATION);
    }
}
