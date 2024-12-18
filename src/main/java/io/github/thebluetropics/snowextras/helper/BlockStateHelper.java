package io.github.thebluetropics.snowextras.helper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class BlockStateHelper {
  public static boolean isOf(BlockState state, Block... compareBlocks) {
    for (Block compareBlock : compareBlocks) {
      if (state.isOf(compareBlock)) {
        return true;
      }
    }

    return false;
  }
}
