package io.github.thebluetropics.snowextras.mixin;

import io.github.thebluetropics.snowextras.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(SnowBlock.class)
public class SnowBlockMixin {
  /// Allows snow to be placed on top of full block eternal snow.
  @Inject(
    at = @At("HEAD"),
    method = "canPlaceAt",
    cancellable = true
  )
  private void canPlaceAt(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> info) {
    BlockState lowerState = world.getBlockState(pos.down());

    if (lowerState.isOf(ModBlocks.ETERNAL_SNOW) && Objects.equals(lowerState.get(SnowBlock.LAYERS), 8)) {
      info.setReturnValue(true);
    }
  }

  @Inject(
    at = @At("HEAD"),
    method = "canReplace",
    cancellable = true
  )
  private void canReplace(BlockState state, ItemPlacementContext context, CallbackInfoReturnable<Boolean> info) {
    // TODO
  }

  @Inject(
    at = @At("HEAD"),
    method = "getPlacementState",
    cancellable = true
  )
  private void getPlacementState(ItemPlacementContext context, CallbackInfoReturnable<BlockState> info) {
    // TODO
  }
}
