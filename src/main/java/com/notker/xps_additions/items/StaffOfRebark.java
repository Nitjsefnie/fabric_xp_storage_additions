package com.notker.xps_additions.items;

import com.notker.xps_additions.XpsAdditions;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;


public class StaffOfRebark extends Item {

    public StaffOfRebark(Settings settings) {
        super(settings);
    }


    private Optional<BlockState> getStrippedState(BlockState state) {
        return Optional.ofNullable(XpsAdditions.BLOCKS_TO_REBARK.get(state.getBlock())).map((block) -> block.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS)));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState = world.getBlockState(blockPos);
        Optional<BlockState> unStrippedState = this.getStrippedState(blockState);

        if (unStrippedState.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);

            if (playerEntity != null && !playerEntity.isCreative()) {
                playerEntity.getStackInHand(context.getHand()).damage(1, playerEntity, p -> {
                    p.sendToolBreakStatus(context.getHand());
                });
            }

            if (!world.isClient()) {
                world.setBlockState(blockPos, unStrippedState.get(), 11);
            }


        }

        return super.useOnBlock(context);
    }
}
