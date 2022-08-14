package com.notker.xps_additions.regestry;

import com.notker.xp_storage.XpStorage;
import com.notker.xps_additions.XpsAdditions;
import com.notker.xps_additions.items.Mystical_Candy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AdditionItems {


    private static BlockItem createBlockItemWithGroup(Block block) {
        return new BlockItem(block, new Item.Settings().group(XpStorage.ITEM_GROUP));
    }


    // Items
    public static final Item MYSTICAL_CANDY = new Mystical_Candy();

    public static void registerItems() {
        //Items
        Registry.register(Registry.ITEM, new Identifier(XpsAdditions.MOD_ID,"mystical_candy"), MYSTICAL_CANDY);

        //BlockItems
        Registry.register(Registry.ITEM, new Identifier(XpsAdditions.MOD_ID, "soul_copper_door"), createBlockItemWithGroup(AdditionBlocks.SOUL_COPPER_DOOR));
        Registry.register(Registry.ITEM, new Identifier(XpsAdditions.MOD_ID, "soul_copper_trap_door"), createBlockItemWithGroup(AdditionBlocks.SOUL_COPPER_TRAP_DOOR));
        Registry.register(Registry.ITEM, new Identifier(XpsAdditions.MOD_ID, "soul_copper_pressure_plate"), createBlockItemWithGroup(AdditionBlocks.SOUL_COPPER_PRESSURE_PLATE));
        Registry.register(Registry.ITEM, new Identifier(XpsAdditions.MOD_ID, "soul_copper_bars"), createBlockItemWithGroup(AdditionBlocks.SOUL_COPPER_BARS));
    }
}
