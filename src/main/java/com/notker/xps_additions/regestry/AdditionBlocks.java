package com.notker.xps_additions.regestry;

import com.notker.xps_additions.XpsAdditions;
import com.notker.xps_additions.blocks.*;

import net.minecraft.util.registry.Registry;

public class AdditionBlocks {

    public static final SoulCopperDoor SOUL_COPPER_DOOR = new SoulCopperDoor();
    public static final SoulCopperTrapDoor SOUL_COPPER_TRAP_DOOR = new SoulCopperTrapDoor();
    public static final SoulCopperPressurePlate SOUL_COPPER_PRESSURE_PLATE = new SoulCopperPressurePlate();
    public static final SoulCopperBars SOUL_COPPER_BARS = new SoulCopperBars();
    public static final CutSoulCopper CUT_SOUL_COPPER = new CutSoulCopper();
    public static final CutSoulCopperSlab CUT_SOUL_COPPER_SLAB = new CutSoulCopperSlab();
    public final static CutSoulCopperStairs CUT_SOUL_COPPER_STAIRS = new CutSoulCopperStairs();



    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("soul_copper_door"), SOUL_COPPER_DOOR);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("soul_copper_trap_door"), SOUL_COPPER_TRAP_DOOR);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("soul_copper_pressure_plate"), SOUL_COPPER_PRESSURE_PLATE);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("soul_copper_bars"), SOUL_COPPER_BARS);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("cut_soul_copper"), CUT_SOUL_COPPER);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("cut_soul_copper_slab"), CUT_SOUL_COPPER_SLAB);
        Registry.register(Registry.BLOCK, XpsAdditions.createModIdIdentifier("cut_soul_copper_stairs"), CUT_SOUL_COPPER_STAIRS);
    }
}
