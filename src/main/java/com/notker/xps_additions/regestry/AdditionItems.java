package com.notker.xps_additions.regestry;

import com.notker.xp_storage.XpStorage;
import com.notker.xps_additions.XpsAdditions;
import com.notker.xps_additions.items.Mystical_Candy;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AdditionItems {

    public static final int HASTE_EFFECT_DURATION = 1700;
    public static final float HASTE_EFFECT_CHANCE = 0.75f;
    public static final int HASTE_EFFECT_AMPLIFIER = 4;

    public static final int GIGGLE_EFFECT_DURATION = 200;
    public static final float GIGGLE_EFFECT_CHANCE = 0.25f;

    // Items
    public static final Item MYSTICAL_CANDY = new Mystical_Candy(new Item.Settings()
            .group(XpStorage.ITEM_GROUP)
            .food(new FoodComponent.Builder()
                    .statusEffect(new StatusEffectInstance(XpsAdditions.GIGGLE, GIGGLE_EFFECT_DURATION, 0), GIGGLE_EFFECT_CHANCE)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, HASTE_EFFECT_DURATION, HASTE_EFFECT_AMPLIFIER), HASTE_EFFECT_CHANCE)
                    .hunger(2)
                    .saturationModifier(0.8f)
                    .snack()
                    .alwaysEdible()
                    .build()));

    //Block Items
    public static final BlockItem SOUL_COPPER_DOOR_ITEM = new BlockItem(AdditionBlocks.SOUL_COPPER_DOOR, new Item.Settings().group(XpStorage.ITEM_GROUP));
    public static final BlockItem SOUL_COPPER_TRAP_DOOR_ITEM = new BlockItem(AdditionBlocks.SOUL_COPPER_TRAP_DOOR, new Item.Settings().group(XpStorage.ITEM_GROUP));
    public static final BlockItem SOUL_COPPER_PRESSURE_PLATE_ITEM = new BlockItem(AdditionBlocks.SOUL_COPPER_PRESSURE_PLATE, new Item.Settings().group(XpStorage.ITEM_GROUP));
    public static final BlockItem SOUL_COPPER_BARS_ITEM = new BlockItem(AdditionBlocks.SOUL_COPPER_BARS, new Item.Settings().group(XpStorage.ITEM_GROUP));

    public static void registerItems() {
        //Items
        Registry.register(Registry.ITEM, new Identifier(XpsAdditions.MOD_ID,"mystical_candy"), MYSTICAL_CANDY);

        //BlockItems
        Registry.register(Registry.ITEM, new Identifier(XpsAdditions.MOD_ID, "soul_copper_door"), SOUL_COPPER_DOOR_ITEM);
        Registry.register(Registry.ITEM, new Identifier(XpsAdditions.MOD_ID, "soul_copper_trap_door"), SOUL_COPPER_TRAP_DOOR_ITEM);
        Registry.register(Registry.ITEM, new Identifier(XpsAdditions.MOD_ID, "soul_copper_pressure_plate"), SOUL_COPPER_PRESSURE_PLATE_ITEM);
        Registry.register(Registry.ITEM, new Identifier(XpsAdditions.MOD_ID, "soul_copper_bars"), SOUL_COPPER_BARS_ITEM);
    }
}
