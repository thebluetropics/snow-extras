package io.github.thebluetropics.permasnow.mixin;

import io.github.thebluetropics.permasnow.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

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
      world.setBlockState(pos, ModBlocks.THIN_SNOW.getDefaultState(), Block.NOTIFY_ALL);

      info.setReturnValue(ActionResult.SUCCESS);
    }
  }
}
