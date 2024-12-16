package io.github.thebluetropics.permasnow.mixin;

import io.github.thebluetropics.permasnow.block.EternalSnowBlock;
import io.github.thebluetropics.permasnow.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(ShovelItem.class)
public class ShovelItemMixin {
  /// Convert snow into thin snow.
  @Inject(
    method = "useOnBlock(Lnet/minecraft/item/ItemUsageContext;)Lnet/minecraft/util/ActionResult;",
    at = @At("HEAD"),
    cancellable = true
  )
  private void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> info) {
    var world = context.getWorld();
    var pos = context.getBlockPos();
    var state = world.getBlockState(pos);

    if (state.isOf(Blocks.SNOW)) {
      if (Objects.equals(state.get(SnowBlock.LAYERS), 1)) {
        world.setBlockState(pos, ModBlocks.THIN_SNOW.getDefaultState(), Block.NOTIFY_ALL);
      } else {
        world.setBlockState(pos, state.with(SnowBlock.LAYERS, state.get(SnowBlock.LAYERS) - 1), Block.NOTIFY_ALL);

        // TODO: drop stack
        // TODO: add particle
      }

      info.setReturnValue(ActionResult.SUCCESS);
    }

    if (state.isOf(ModBlocks.ETERNAL_SNOW)) {
      if (Objects.equals(state.get(EternalSnowBlock.LAYERS), 1)) {
        world.setBlockState(pos, ModBlocks.ETERNAL_THIN_SNOW.getDefaultState(), Block.NOTIFY_ALL);
      } else {
        world.setBlockState(pos, state.with(EternalSnowBlock.LAYERS, state.get(EternalSnowBlock.LAYERS) - 1), Block.NOTIFY_ALL);

        // TODO: drop stack
        // TODO: add particle
      }

      info.setReturnValue(ActionResult.SUCCESS);
    }
  }
}
