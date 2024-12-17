package io.github.thebluetropics.snowextras;

import io.github.thebluetropics.snowextras.block.ModBlocks;
import io.github.thebluetropics.snowextras.item.ModItems;
import io.github.thebluetropics.snowextras.item.group.ModItemGroups;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SnowExtrasMod implements ModInitializer {
  public static final String ID = "snow_extras";
  public static final Logger LOGGER = LoggerFactory.getLogger(SnowExtrasMod.class);

  @Override
  public void onInitialize() {
    ModBlocks.initialize();
    ModItems.initialize();
    ModItemGroups.initialize();
  }
}
