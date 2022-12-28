package com.notker.xps_additions;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.notker.xps_additions.items.StaffOfRebark;
import com.notker.xps_additions.mixin.AxeItemAccessor;
import com.notker.xps_additions.regestry.AdditionBlocks;
import com.notker.xps_additions.regestry.AdditionItems;
import com.notker.xps_additions.screen.PositionedScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

public class XpsAdditionsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(AdditionBlocks.SOUL_COPPER_TRAP_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AdditionBlocks.SOUL_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AdditionBlocks.SOUL_COPPER_BARS, RenderLayer.getCutout());

        HandledScreens.register(XpsAdditions.BOX_SCREEN_HANDLER, PositionedScreen::new);

        ClientPlayConnectionEvents.JOIN.register((packetListener, packetSender, mc) -> {
            if (StaffOfRebark.STRIPPED_BLOCKS == null) {
                // get Actual Name of Staff
                final String staffName = new TranslatableText(AdditionItems.STAFF_OF_REBARK.getTranslationKey()).getString();
                // Start Logging Process
                XpsAdditions.LOGGER.info("Null on Client -> Add Log/Stripped variants to " + staffName);

                // Create Map Builder
                ImmutableMultimap.Builder<Block, Block> builder = ImmutableMultimap.builder();
                // Get Blocks from Mixin and put it switched in to Map
                AxeItemAccessor.getStrip().forEach((block, strippedBlock) -> builder.put(strippedBlock, block));
                // Build the Map
                Multimap<Block, Block> strippedBlock_Block = builder.build();
                // Add Map to Staff
                StaffOfRebark.STRIPPED_BLOCKS = strippedBlock_Block;

                // InfoLogg Blocks
                strippedBlock_Block.forEach((block, block2) -> XpsAdditions.LOGGER.info(staffName + " add: " + Registry.BLOCK.getId(block) + " to " +  Registry.BLOCK.getId(block2)));
                // End Staff Logging
                XpsAdditions.LOGGER.info("Finished adding " + strippedBlock_Block.size() + " Blocks to " + staffName);
            }
        });
    }
}
