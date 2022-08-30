package com.notker.xps_additions;

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
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.entry;
import static org.apache.logging.log4j.ThreadContext.peek;

public class XpsAdditions implements ModInitializer {

    public static final  String MOD_ID = "xps_additions";

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
                StaffOfRebark.STRIPPED_BLOCKS = AxeItemAccessor.getStrip().entrySet()
                        .stream()
                        .map((e) -> new AbstractMap.SimpleImmutableEntry<>(e.getKey(), e.getValue()))
                        //.peek((e) -> System.out.printf("normal: %s - Stripped: %s\n", e.getKey().toString(), e.getValue().toString()))
                        .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (prev, curr) -> prev));
            }
        });

    }
}
