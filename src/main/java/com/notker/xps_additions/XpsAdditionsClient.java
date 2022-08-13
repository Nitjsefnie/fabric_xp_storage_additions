package com.notker.xps_additions;

import com.notker.xps_additions.regestry.AdditionBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class XpsAdditionsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(AdditionBlocks.SOUL_COPPER_TRAP_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AdditionBlocks.SOUL_COPPER_DOOR, RenderLayer.getCutout());
    }
}
