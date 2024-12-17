package io.github.thebluetropics.snowextras.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class EternalSnowBlock extends SnowBlock {
  public EternalSnowBlock(Settings settings) {
    super(settings);
  }

  @Override
  protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) { /* ... */ }
}
