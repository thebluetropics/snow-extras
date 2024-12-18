package io.github.thebluetropics.snowextras.block;

import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class EternalThinSnowBlock extends ThinSnowBlock {
  public EternalThinSnowBlock(Settings settings) {
    super(settings);
  }

  /// Force this thin snow block to not melt.
  @Override
  protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) { /* ... */ }
}
