package io.github.thebluetropics.permasnow.item.group;

import io.github.thebluetropics.permasnow.PermasnowMod;
import io.github.thebluetropics.permasnow.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
  public static final ItemGroup PERMASNOW = register(
    "permasnow",
    FabricItemGroup.builder()
      .displayName(Text.translatable("itemGroup." + PermasnowMod.ID + ".permasnow"))
      .icon(ModItems.ETERNAL_ICE::getDefaultStack)
      .noScrollbar()
      .entries((context, entries) -> {
        entries.add(ModItems.ETERNAL_ICE);
        entries.add(ModItems.ETERNAL_SNOW);
      })
      .build()
  );

  public static <T extends ItemGroup> T register(String id, T itemGroup) {
    return Registry.register(Registries.ITEM_GROUP, Identifier.of(PermasnowMod.ID, id), itemGroup);
  }

  public static void initialize() { /* ... */ }
}
