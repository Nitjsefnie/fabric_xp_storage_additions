package com.notker.xps_additions.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import java.util.Random;


public class GiggleStatusEffect extends StatusEffect {
    public GiggleStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x93E477);

    }



    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i;
        i = 32 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }

    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            //((PlayerEntity) entity).giveItemStack(new ItemStack(Items.GOLD_NUGGET, 1 << amplifier));

            //Horizontal
            float x = new Random().nextFloat(0.4f) - 0.2f;
            float z = new Random().nextFloat(0.4f) - 0.2f;

            //Vertical
            //float y = new Random().nextFloat(0.4f);

            entity.addVelocity(x, 0.2f ,z);

            //Random Inventor slot without Hotbar/Armor/Offhand
            int randomSlot = new Random().nextInt(26) + 9;

            ItemStack itemToDrop = ((PlayerEntity) entity).getInventory().getStack(randomSlot).copy();
            if (!itemToDrop.isEmpty()) {

                ((PlayerEntity) entity).getInventory().getStack(randomSlot).decrement(1);
                itemToDrop.setCount(1);
                ((PlayerEntity) entity).dropItem(itemToDrop,true,true);
            }

        }
    }


}
