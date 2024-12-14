package io.github.thebluetropics.permasnow.mixin;

import io.github.thebluetropics.permasnow.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.passive.AbstractHorseEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractHorseEntity.class)
public class AbstractHorseEntityMixin {
  @Redirect(
    method = "playStepSound(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V",
    at = @At(
      value = "INVOKE",
      target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z",
      ordinal = 0
    )
  )
  private boolean isOf(BlockState state, Block block) {
    if(state.isOf(Blocks.SNOW)) {
      return true;
    }

    return state.isOf(ModBlocks.ETERNAL_SNOW);
  }
}
