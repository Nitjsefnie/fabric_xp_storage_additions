package com.notker.xps_additions;

import com.notker.xp_storage.XpStorage;
import com.notker.xp_storage.regestry.ModFluids;
import com.notker.xp_storage.regestry.ModItems;
import com.notker.xps_additions.effects.GiggleStatusEffect;
import com.notker.xps_additions.regestry.AdditionBlocks;
import com.notker.xps_additions.regestry.AdditionItems;
import com.notker.xps_additions.screen.BoxScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;

import static java.util.Map.entry;

public class XpsAdditions implements ModInitializer {

    public static final  String MOD_ID = "xps_additions";

    public static final int XP_PER_MYSTICAL_CANDY = (XpStorage.XP_PER_BERRIE * 4);

    public static final int HASTE_EFFECT_DURATION = 1700;
    public static final float HASTE_EFFECT_CHANCE = 0.75f;
    public static final int HASTE_EFFECT_AMPLIFIER = 4;

    public static final int GIGGLE_EFFECT_DURATION = 200;
    public static final float GIGGLE_EFFECT_CHANCE = 0.25f;


    public static final int RAW_ESSENCE_SHARD_FUEL_DURATION = 16 * 200; //Items * smelt time
    public static final int RAW_ESSENCE_FUEL_DURATION = RAW_ESSENCE_SHARD_FUEL_DURATION * 10; //Items * smelt time


    public static final Map<Block, Block> BLOCKS_TO_REBARK = Map.ofEntries(
            entry(Blocks.STRIPPED_OAK_WOOD, Blocks.OAK_WOOD),
            entry(Blocks.STRIPPED_OAK_LOG, Blocks.OAK_LOG),
            entry(Blocks.STRIPPED_DARK_OAK_WOOD, Blocks.DARK_OAK_WOOD),
            entry(Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_LOG),
            entry(Blocks.STRIPPED_ACACIA_WOOD, Blocks.ACACIA_WOOD),
            entry(Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_LOG),
            entry(Blocks.STRIPPED_BIRCH_WOOD, Blocks.BIRCH_WOOD),
            entry(Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_LOG),
            entry(Blocks.STRIPPED_JUNGLE_WOOD, Blocks.JUNGLE_WOOD),
            entry(Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_LOG),
            entry(Blocks.STRIPPED_SPRUCE_WOOD, Blocks.SPRUCE_WOOD),
            entry(Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_LOG),
            entry(Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_STEM),
            entry(Blocks.STRIPPED_WARPED_HYPHAE, Blocks.WARPED_HYPHAE),
            entry(Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_STEM),
            entry(Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.CRIMSON_HYPHAE)
    );

    public static final int ITEM_SLOTS = 9;
    public static final Item[] ITEMS_TO_XP = {ModItems.XP_BERRIES, Items.EXPERIENCE_BOTTLE, ModFluids.XP_BUCKET};

    public static Identifier createModIdIdentifier (String path) {
        return new Identifier(MOD_ID, path);
    }


    public static final ScreenHandlerType<BoxScreenHandler> BOX_SCREEN_HANDLER = new ExtendedScreenHandlerType<>(BoxScreenHandler::new);

    public static final StatusEffect GIGGLE = new GiggleStatusEffect();


    @Override
    public void onInitialize() {
        AdditionBlocks.registerBlocks();
        AdditionItems.registerItems();
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "giggle"), GIGGLE);
        Registry.register(Registry.SCREEN_HANDLER, new Identifier(MOD_ID, "xp_item_inserter"), BOX_SCREEN_HANDLER);
    }
}
