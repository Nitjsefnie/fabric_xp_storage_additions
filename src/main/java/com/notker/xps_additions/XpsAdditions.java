package com.notker.xps_additions;

import com.notker.xps_additions.effects.GiggleStatusEffect;
import com.notker.xps_additions.regestry.AdditionBlocks;
import com.notker.xps_additions.regestry.AdditionItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("UnstableApiUsage")
public class XpsAdditions implements ModInitializer {

    public static final  String MOD_ID = "xps_additions";

    public static final  int XP_PER_BERRIE = 3;
    public static final int shiftKey = 340;

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(AdditionItems.MYSTICAL_CANDY)
    );


    public static final int XP_PER_MYSTICAL_CANDY = (XP_PER_BERRIE * 4);




    public static final StatusEffect GIGGLE = new GiggleStatusEffect();



    @Override
    public void onInitialize() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "giggle"), GIGGLE);

        AdditionBlocks.registerBlocks();
        AdditionItems.registerItems();
    }
}
