package io.github.thebluetropics.snowextras.block;

import io.github.thebluetropics.snowextras.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;

public class EternalThinSnowBlock extends ThinSnowBlock {
  public EternalThinSnowBlock(Settings settings) {
    super(settings);
  }

  /// Force this thin snow block to not melt.
  @Override
  protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) { /* ... */ }

  @Override
  public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
    return new ItemStack(ModItems.ETERNAL_SNOW);
  }
}
