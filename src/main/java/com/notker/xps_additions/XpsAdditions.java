package com.notker.xps_additions;

import com.notker.xp_storage.XpStorage;
import com.notker.xps_additions.effects.GiggleStatusEffect;
import com.notker.xps_additions.regestry.AdditionBlocks;
import com.notker.xps_additions.regestry.AdditionItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class XpsAdditions implements ModInitializer {

    public static final  String MOD_ID = "xps_additions";

    public static final int XP_PER_MYSTICAL_CANDY = (XpStorage.XP_PER_BERRIE * 4);

    public static final int HASTE_EFFECT_DURATION = 1700;
    public static final float HASTE_EFFECT_CHANCE = 0.75f;
    public static final int HASTE_EFFECT_AMPLIFIER = 4;

    public static final int GIGGLE_EFFECT_DURATION = 200;
    public static final float GIGGLE_EFFECT_CHANCE = 0.25f;

    public static Identifier createModIdIdentifier (String path) {
        return new Identifier(MOD_ID, path);
    }



    public static final StatusEffect GIGGLE = new GiggleStatusEffect();



    @Override
    public void onInitialize() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "giggle"), GIGGLE);

        AdditionBlocks.registerBlocks();
        AdditionItems.registerItems();
    }
}
