package com.notker.xps_additions.regestry;

import com.notker.xps_additions.XpsAdditions;
import com.notker.xps_additions.blocks.SoulCopperBars;
import com.notker.xps_additions.blocks.SoulCopperDoorBlock;
import com.notker.xps_additions.blocks.SoulCopperPressurePlate;
import com.notker.xps_additions.blocks.SoulCopperTrapDoorBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import net.minecraft.util.registry.Registry;

public class AdditionBlocks {

    public static final SoulCopperDoorBlock SOUL_COPPER_DOOR = new SoulCopperDoorBlock(FabricBlockSettings
            .of(Material.METAL)
            .sounds(BlockSoundGroup.METAL)
            .strength(5f, 5f)
            .nonOpaque()
            .requiresTool()
    );

    public static final SoulCopperTrapDoorBlock SOUL_COPPER_TRAP_DOOR = new SoulCopperTrapDoorBlock(FabricBlockSettings
            .of(Material.METAL)
            .sounds(BlockSoundGroup.METAL)
            .strength(5f, 5f)
            .nonOpaque()
            .requiresTool()
    );

    public static final SoulCopperPressurePlate SOUL_COPPER_PRESSURE_PLATE = new SoulCopperPressurePlate(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings
            .of(Material.METAL)
            .sounds(BlockSoundGroup.METAL)
            .strength(0.5f, 0.5f)
            .nonOpaque()
            .requiresTool()
    );

    public static final SoulCopperBars SOUL_COPPER_BARS = new SoulCopperBars( FabricBlockSettings
            .of(Material.METAL)
            .sounds(BlockSoundGroup.METAL)
            .strength(6f, 5f)
            .nonOpaque()
            .requiresTool()
    );



    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(XpsAdditions.MOD_ID, "soul_copper_door"), SOUL_COPPER_DOOR);
        Registry.register(Registry.BLOCK, new Identifier(XpsAdditions.MOD_ID, "soul_copper_trap_door"), SOUL_COPPER_TRAP_DOOR);
        Registry.register(Registry.BLOCK, new Identifier(XpsAdditions.MOD_ID, "soul_copper_pressure_plate"), SOUL_COPPER_PRESSURE_PLATE);
        Registry.register(Registry.BLOCK, new Identifier(XpsAdditions.MOD_ID, "soul_copper_bars"), SOUL_COPPER_BARS);
    }
}
