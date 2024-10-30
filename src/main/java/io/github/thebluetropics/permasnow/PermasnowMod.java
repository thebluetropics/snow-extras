package io.github.thebluetropics.permasnow;

import io.github.thebluetropics.permasnow.block.ModBlocks;
import io.github.thebluetropics.permasnow.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class PermasnowMod implements ModInitializer {
  public static final String ID = "permasnow";
  public static final Logger LOGGER = LoggerFactory.getLogger(ID);

  @Override
  public void onInitialize() {
    ModBlocks.initialize();
    ModItems.initialize();

    ItemGroupEvents.MODIFY_ENTRIES_ALL.register((itemGroup, fabricItemGroupEntries) -> {
      if (Objects.equals(itemGroup, ItemGroups.getDefaultTab())) {
        fabricItemGroupEntries.add(ModItems.ETERNAL_ICE.getDefaultStack());
        fabricItemGroupEntries.add(ModItems.ETERNAL_SNOW.getDefaultStack());
      }
    });
  }
}
