package com.notker.xps_additions.items;

import com.notker.xps_additions.TooltipHelper;
import com.notker.xps_additions.XpsAdditions;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class Street_Item extends BlockItem {

    public Street_Item(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        super.appendTooltip(stack, world, tooltip, tooltipContext);

        tooltip.add(Text.translatable("item.tooltip.street", TooltipHelper.chanceToString(XpsAdditions.RUNNING_SPEED)));

    }
}
