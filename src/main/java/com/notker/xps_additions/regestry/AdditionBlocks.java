package com.notker.xps_additions.regestry;

import com.notker.xps_additions.XpsAdditions;
import com.notker.xps_additions.blocks.*;

import com.notker.xps_additions.entity.XpItemInserterEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

public class AdditionBlocks {

    public static final SoulCopperDoor SOUL_COPPER_DOOR = new SoulCopperDoor();
    public static final SoulCopperTrapDoor SOUL_COPPER_TRAP_DOOR = new SoulCopperTrapDoor();
    public static final SoulCopperPressurePlate SOUL_COPPER_PRESSURE_PLATE = new SoulCopperPressurePlate();
    public static final SoulCopperBars SOUL_COPPER_BARS = new SoulCopperBars();
    public static final CutSoulCopper CUT_SOUL_COPPER = new CutSoulCopper();
    public static final CutSoulCopperSlab CUT_SOUL_COPPER_SLAB = new CutSoulCopperSlab();
    public static final CutSoulCopperStairs CUT_SOUL_COPPER_STAIRS = new CutSoulCopperStairs();
    public static final XpItemInserter XP_ITEM_INSERTER = new XpItemInserter();
    public static final Block RAW_ESSENCE_BLOCK = new Block(FabricBlockSettings.of(Material.AMETHYST).sounds(BlockSoundGroup.CALCITE).strength( 5F, 6F).requiresTool());
    public static final Street STREET = new Street();


    public static final BlockEntityType<XpItemInserterEntity> XP_ITEM_INSERTER_ENTITY = FabricBlockEntityTypeBuilder.create(XpItemInserterEntity::new, XP_ITEM_INSERTER).build(null);





    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("soul_copper_door"), SOUL_COPPER_DOOR);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("soul_copper_trap_door"), SOUL_COPPER_TRAP_DOOR);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("soul_copper_pressure_plate"), SOUL_COPPER_PRESSURE_PLATE);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("soul_copper_bars"), SOUL_COPPER_BARS);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("cut_soul_copper"), CUT_SOUL_COPPER);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("cut_soul_copper_slab"), CUT_SOUL_COPPER_SLAB);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("cut_soul_copper_stairs"), CUT_SOUL_COPPER_STAIRS);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("xp_item_inserter"), XP_ITEM_INSERTER);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("raw_essence_block"), RAW_ESSENCE_BLOCK);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("street"), STREET);


        Registry.register(Registry.BLOCK_ENTITY_TYPE, XpsAdditions.createModIdIdentifier("entity_xp_obelisk"), XP_ITEM_INSERTER_ENTITY);
    }
}
