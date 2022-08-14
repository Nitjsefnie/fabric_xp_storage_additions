package com.notker.xps_additions.regestry;

import com.notker.xp_storage.XpStorage;
import com.notker.xps_additions.XpsAdditions;
import com.notker.xps_additions.items.Mystical_Candy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class AdditionItems {


    private static BlockItem createBlockItemWithGroup(Block block) {
        return new BlockItem(block, new Item.Settings().group(XpStorage.ITEM_GROUP));
    }




    // Items
    public static final Item MYSTICAL_CANDY = new Mystical_Candy();

    //Block Items
    public static final BlockItem SOUL_COPPER_DOOR_ITEM = createBlockItemWithGroup(AdditionBlocks.SOUL_COPPER_DOOR);
    public static final BlockItem SOUL_COPPER_TRAP_DOOR_ITEM = createBlockItemWithGroup(AdditionBlocks.SOUL_COPPER_TRAP_DOOR);
    public static final BlockItem SOUL_COPPER_PRESSURE_PLATE_ITEM = createBlockItemWithGroup(AdditionBlocks.SOUL_COPPER_PRESSURE_PLATE);
    public static final BlockItem SOUL_COPPER_BARS_ITEM = createBlockItemWithGroup(AdditionBlocks.SOUL_COPPER_BARS);

    public static void registerItems() {
        //Items
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("mystical_candy"), MYSTICAL_CANDY);

        //BlockItems
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("soul_copper_door"), SOUL_COPPER_DOOR_ITEM);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("soul_copper_trap_door"), SOUL_COPPER_TRAP_DOOR_ITEM);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("soul_copper_pressure_plate"), SOUL_COPPER_PRESSURE_PLATE_ITEM);
        Registry.register(Registry.ITEM, XpsAdditions.createModIdIdentifier("soul_copper_bars"), SOUL_COPPER_BARS_ITEM);
    }
}
