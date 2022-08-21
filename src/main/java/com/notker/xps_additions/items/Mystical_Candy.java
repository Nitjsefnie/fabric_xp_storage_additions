package com.notker.xps_additions.items;

import com.notker.xp_storage.XpStorage;
import com.notker.xps_additions.XpsAdditions;
import com.notker.xps_additions.TooltipHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class Mystical_Candy extends Item {
    public Mystical_Candy() { super(new Item.Settings()
            .group(XpStorage.ITEM_GROUP)
            .food(new FoodComponent.Builder()
                    .statusEffect(new StatusEffectInstance(XpsAdditions.GIGGLE, XpsAdditions.GIGGLE_EFFECT_DURATION, 0), XpsAdditions.GIGGLE_EFFECT_CHANCE)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, XpsAdditions.HASTE_EFFECT_DURATION, XpsAdditions.HASTE_EFFECT_AMPLIFIER), XpsAdditions.HASTE_EFFECT_CHANCE)
                    .hunger(2)
                    .saturationModifier(0.8f)
                    .snack()
                    .alwaysEdible()
                    .build()));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ServerWorld sw = world instanceof ServerWorld ? (ServerWorld)world : null;
        PlayerEntity pe = user instanceof PlayerEntity ? (PlayerEntity) user : null;
        if (sw != null && pe != null) {
            world.spawnEntity(new ExperienceOrbEntity(world, user.getX(), user.getY(), user.getZ(), XpsAdditions.XP_PER_MYSTICAL_CANDY));
        }

        return super.finishUsing(stack, world, user);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        super.appendTooltip(stack, world, tooltip, tooltipContext);

        tooltip.add(Text.translatable("item.xps.more.info.tooltip"));
        if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), XpStorage.shiftKey)) {
            tooltip.remove(Text.translatable("item.xps.more.info.tooltip"));

            tooltip.add(Text.translatable("item.tooltip.mystical_candy", XpsAdditions.XP_PER_MYSTICAL_CANDY).formatted(Formatting.WHITE));
            tooltip.add(Text.translatable("item.tooltip.mystical_candy_effect_Giggle",
                    TooltipHelper.potionTooltipHelper(XpsAdditions.GIGGLE_EFFECT_DURATION),
                    TooltipHelper.chanceToString(XpsAdditions.GIGGLE_EFFECT_CHANCE)
            ).formatted(Formatting.RED));
            tooltip.add(Text.translatable("item.tooltip.mystical_candy_effect_Haste",
                    TooltipHelper.potionTooltipHelper(XpsAdditions.HASTE_EFFECT_AMPLIFIER, XpsAdditions.HASTE_EFFECT_DURATION),
                    TooltipHelper.chanceToString(XpsAdditions.HASTE_EFFECT_CHANCE)
            ).formatted(Formatting.BLUE));
        }
    }
}
