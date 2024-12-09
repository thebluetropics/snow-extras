package io.github.thebluetropics.permasnow.client;

import io.github.thebluetropics.permasnow.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PermasnowModClient implements ClientModInitializer {
  public static final Logger LOGGER = LoggerFactory.getLogger(PermasnowModClient.class);

  @Override
  public void onInitializeClient() {
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ETERNAL_ICE, RenderLayer.getTranslucent());
  }
}
