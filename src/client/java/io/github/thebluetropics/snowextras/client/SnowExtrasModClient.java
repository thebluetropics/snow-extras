package io.github.thebluetropics.snowextras.client;

import io.github.thebluetropics.snowextras.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SnowExtrasModClient implements ClientModInitializer {
  public static final Logger LOGGER = LoggerFactory.getLogger(SnowExtrasModClient.class);

  @Override
  public void onInitializeClient() {
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ETERNAL_ICE, RenderLayer.getTranslucent());
  }
}
