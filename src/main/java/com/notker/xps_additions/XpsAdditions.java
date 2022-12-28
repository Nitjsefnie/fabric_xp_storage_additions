package com.notker.xps_additions;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.notker.xp_storage.XpStorage;
import com.notker.xps_additions.effects.GiggleStatusEffect;
import com.notker.xps_additions.items.StaffOfRebark;
import com.notker.xps_additions.mixin.AxeItemAccessor;
import com.notker.xps_additions.regestry.AdditionBlocks;
import com.notker.xps_additions.regestry.AdditionItems;
import com.notker.xps_additions.screen.BoxScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;


public class XpsAdditions implements ModInitializer {

    public static final  String MOD_ID = "xps_additions";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final int XP_PER_MYSTICAL_CANDY = (XpStorage.XP_PER_BERRIE * 4);

    public static final int HASTE_EFFECT_DURATION = 1700;
    public static final float HASTE_EFFECT_CHANCE = 0.75f;
    public static final int HASTE_EFFECT_AMPLIFIER = 4;

    public static final int GIGGLE_EFFECT_DURATION = 200;
    public static final float GIGGLE_EFFECT_CHANCE = 0.25f;

    public static final int RAW_ESSENCE_BLOCK_FUEL_DURATION = 160 * 200; //160 Items * smelt time
    public static final int RAW_ESSENCE_FUEL_DURATION = RAW_ESSENCE_BLOCK_FUEL_DURATION / 5; //32 Items
    public static final int RAW_ESSENCE_SHARD_FUEL_DURATION = RAW_ESSENCE_FUEL_DURATION / 4; // 8 Items

    public static final float RUNNING_SPEED = 1.20F;

    public static final int ITEM_SLOTS = 9;

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


        ServerWorldEvents.LOAD.register((server, level) -> {
            if (StaffOfRebark.STRIPPED_BLOCKS == null) {
                System.out.println("Null on Server");
                // get Actual Name of Staff
                final String staffName = new TranslatableText(AdditionItems.STAFF_OF_REBARK.getTranslationKey()).getString();
                // Start Logging Process
                LOGGER.info("Null on Server -> Add Log/Stripped variants to " + staffName);

                // Create Map Builder
                ImmutableMultimap.Builder<Block, Block> builder = ImmutableMultimap.builder();
                // Get Blocks from Mixin and put it switched in to Map
                AxeItemAccessor.getStrip().forEach((block, strippedBlock) -> builder.put(strippedBlock, block));
                // Build the Map
                Multimap<Block, Block> strippedBlock_Block = builder.build();
                // Add Map to Staff
                StaffOfRebark.STRIPPED_BLOCKS = strippedBlock_Block;

                // InfoLogg Blocks
                strippedBlock_Block.forEach((block, block2) -> LOGGER.info(staffName + " add: " + Registry.BLOCK.getId(block) + " to " +  Registry.BLOCK.getId(block2)));
                // End Staff Logging
                LOGGER.info("Finished adding " + strippedBlock_Block.size() + " Blocks to " + staffName);
            }
        });

    }
}
