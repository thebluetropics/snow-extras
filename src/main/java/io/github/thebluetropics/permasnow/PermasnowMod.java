package io.github.thebluetropics.permasnow;

import io.github.thebluetropics.permasnow.block.ModBlocks;
import io.github.thebluetropics.permasnow.item.ModItems;
import io.github.thebluetropics.permasnow.item.group.ModItemGroups;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PermasnowMod implements ModInitializer {
  public static final String ID = "permasnow";
  public static final Logger LOGGER = LoggerFactory.getLogger(PermasnowMod.class);

  @Override
  public void onInitialize() {
    ModBlocks.initialize();
    ModItems.initialize();
    ModItemGroups.initialize();
  }
}
