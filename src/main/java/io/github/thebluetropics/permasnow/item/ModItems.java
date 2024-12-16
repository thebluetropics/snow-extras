package io.github.thebluetropics.permasnow.item;

import io.github.thebluetropics.permasnow.PermasnowMod;
import io.github.thebluetropics.permasnow.block.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
  public static final BlockItem ETERNAL_ICE = register(
    "eternal_ice",
    new BlockItem(
      ModBlocks.ETERNAL_ICE,
      new Item.Settings()
    )
  );
  public static final BlockItem ETERNAL_SNOW = register(
    "eternal_snow",
    new BlockItem(
      ModBlocks.ETERNAL_SNOW,
      new Item.Settings()
    )
  );
  public static final Item POWDER_SNOW_BOTTLE = register(
    "powder_snow_bottle",
    new PowderSnowBottleItem(
      new Item.Settings()
        .recipeRemainder(Items.GLASS_BOTTLE)
    )
  );

  public static <T extends Item> T register(String id, T item) {
    return Registry.register(Registries.ITEM, new Identifier(PermasnowMod.ID, id), item);
  }

  public static void initialize() { /* ... */ }
}
