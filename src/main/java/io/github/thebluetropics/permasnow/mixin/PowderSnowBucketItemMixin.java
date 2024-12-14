package io.github.thebluetropics.permasnow.mixin;

import io.github.thebluetropics.permasnow.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.item.PowderSnowBucketItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PowderSnowBucketItem.class)
public class PowderSnowBucketItemMixin {
  /// Allows snow and ice block be converted into it's eternal variant.
  @Inject(
    at = @At("HEAD"),
    method = "useOnBlock(Lnet/minecraft/item/ItemUsageContext;)Lnet/minecraft/util/ActionResult;",
    cancellable = true
  )
  private void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> info) {
    var world = context.getWorld();
    var player = context.getPlayer();

    var blockPos = context.getBlockPos();
    var blockState = world.getBlockState(blockPos);

    // Convert snow into eternal snow
    if (blockState.isOf(Blocks.SNOW)) {
      world.setBlockState(
        blockPos,
        ModBlocks.ETERNAL_SNOW.getDefaultState()
          .with(SnowBlock.LAYERS, blockState.get(SnowBlock.LAYERS)),
        Block.NOTIFY_LISTENERS
      );

      if (player != null && !player.isCreative()) {
        player.setStackInHand(context.getHand(), Items.BUCKET.getDefaultStack());
      }

      world.playSound(null, blockPos, SoundEvents.BLOCK_SNOW_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);

      info.setReturnValue(ActionResult.SUCCESS);
    }

    // Convert ice into eternal ice
    if (blockState.isOf(Blocks.ICE)) {
      world.setBlockState(blockPos, ModBlocks.ETERNAL_ICE.getDefaultState(), Block.NOTIFY_LISTENERS);

      if (player != null && !player.isCreative()) {
        player.setStackInHand(context.getHand(), Items.BUCKET.getDefaultStack());
      }

      world.playSound(null, blockPos, SoundEvents.BLOCK_SNOW_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);

      info.setReturnValue(ActionResult.SUCCESS);
    }
  }
}
