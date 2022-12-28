package com.notker.xps_additions.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class SoulCopperPressurePlate extends PressurePlateBlock {
    public SoulCopperPressurePlate() {
        super(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings
                .of(Material.METAL)
                .sounds(BlockSoundGroup.METAL)
                .strength(0.5f, 0.5f)
                .nonOpaque()
                .requiresTool(),
                SoundEvents.BLOCK_IRON_DOOR_CLOSE,
                SoundEvents.BLOCK_IRON_DOOR_OPEN);
    }
}
