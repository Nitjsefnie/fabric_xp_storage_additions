package com.notker.xps_additions.blocks;

import com.notker.xps_additions.XpsAdditions;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalConnectingBlock;
import net.minecraft.block.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.Objects;

@SuppressWarnings("deprecation")
public class Street extends HorizontalConnectingBlock {

    public Street() {
        super(8F, 8F, 15F, 15F, 14F, FabricBlockSettings
                .of(Material.GOURD)
                .strength(1F, 6F)
                .nonOpaque()
                .velocityMultiplier(XpsAdditions.RUNNING_SPEED));
        this.setDefaultState(getDefaultState()
                .with(NORTH, false)
                .with(EAST, false)
                .with(SOUTH, false)
                .with(WEST, false)
                .with(WATERLOGGED, false));
    }


    public boolean canConnect(BlockState state) {
        Block block = state.getBlock();
        return  block instanceof Street;
    }


    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockView blockView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        BlockState blockState_north = blockView.getBlockState(blockPos.north());
        BlockState blockState_east = blockView.getBlockState(blockPos.east());
        BlockState blockState_south = blockView.getBlockState(blockPos.south());
        BlockState blockState_west = blockView.getBlockState(blockPos.west());
        return Objects.requireNonNull(super.getPlacementState(ctx))
                .with(NORTH, this.canConnect(blockState_north))
                .with(EAST, this.canConnect(blockState_east))
                .with(SOUTH, this.canConnect(blockState_south))
                .with(WEST, this.canConnect(blockState_west))
                .with(WATERLOGGED, false);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return direction.getAxis().getType() == Direction.Type.HORIZONTAL ? state.with(FACING_PROPERTIES.get(direction), this.canConnect(neighborState)) : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }


}
