package io.github.thebluetropics.snowextras.mixin;

import io.github.thebluetropics.snowextras.block.ModBlocks;
import io.github.thebluetropics.snowextras.helper.BlockStateHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.village.raid.Raid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Raid.class)
public class RaidMixin {
  /// Allows ravagers to spawn on top of thin snow, eternal snow and eternal thin snow.
  @Redirect(
    method = "getRavagerSpawnLocation(II)Lnet/minecraft/util/math/BlockPos;",
    at = @At(
      value = "INVOKE",
      target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z",
      ordinal = 0
    )
  )
  private boolean isOf(BlockState instance, Block block) {
    if (BlockStateHelper.isOf(instance, ModBlocks.THIN_SNOW, ModBlocks.ETERNAL_SNOW, ModBlocks.ETERNAL_THIN_SNOW)) {
      return true;
    }

    return instance.isOf(block);
  }
}
