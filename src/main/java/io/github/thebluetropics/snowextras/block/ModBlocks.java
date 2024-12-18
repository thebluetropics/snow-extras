package io.github.thebluetropics.snowextras.block;

import io.github.thebluetropics.snowextras.SnowExtrasMod;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class ModBlocks {
  public static final Block ETERNAL_ICE = register(
    "eternal_ice",
    new EternalIceBlock(
      AbstractBlock.Settings.create()
        .mapColor(MapColor.PALE_PURPLE)
        .slipperiness(0.98f)
        .ticksRandomly()
        .strength(0.5f)
        .sounds(BlockSoundGroup.GLASS)
        .nonOpaque()
        .allowsSpawning((state, world, pos, entitType) -> Objects.equals(entitType, EntityType.POLAR_BEAR))
        .solidBlock(Blocks::never)
    )
  );
  public static final Block ETERNAL_SNOW = register(
    "eternal_snow",
    new EternalSnowBlock(
      AbstractBlock.Settings.create()
        .mapColor(MapColor.WHITE)
        .replaceable()
        .notSolid()
        .ticksRandomly()
        .strength(0.1f)
        .requiresTool()
        .sounds(BlockSoundGroup.SNOW)
        .blockVision((state, world, pos) -> (Integer) state.get(SnowBlock.LAYERS) >= 0)
        .pistonBehavior(PistonBehavior.DESTROY)
    )
  );
  public static final Block THIN_SNOW = register(
    "thin_snow",
    new ThinSnowBlock(
      AbstractBlock.Settings.create()
        .mapColor(MapColor.WHITE)
        .replaceable()
        .solidBlock((state, world, pos) -> false)
        .ticksRandomly()
        .strength(0.1F)
        .requiresTool()
        .sounds(BlockSoundGroup.SNOW)
        .blockVision((state, world, pos) -> false)
        .pistonBehavior(PistonBehavior.DESTROY)
        .noCollision()
    )
  );
  public static final Block ETERNAL_THIN_SNOW = register(
    "eternal_thin_snow",
    new EternalThinSnowBlock(
      AbstractBlock.Settings.create()
        .mapColor(MapColor.WHITE)
        .replaceable()
        .solidBlock((state, world, pos) -> false)
        .ticksRandomly()
        .strength(0.1F)
        .requiresTool()
        .sounds(BlockSoundGroup.SNOW)
        .blockVision((state, world, pos) -> false)
        .pistonBehavior(PistonBehavior.DESTROY)
        .noCollision()
    )
  );

  public static <T extends Block> T register(String id, T block) {
    return Registry.register(Registries.BLOCK, new Identifier(SnowExtrasMod.ID, id), block);
  }

  public static void initialize() { /* ... */ }
}
