package io.github.thebluetropics.snowextras.block;

import io.github.thebluetropics.snowextras.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.LightType;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class ThinSnowBlock extends Block {
  public static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);

  public ThinSnowBlock(Settings settings) {
    super(settings);
  }

  @Override
  protected boolean canPathfindThrough(BlockState state, NavigationType type) {
    return type.equals(NavigationType.LAND);
  }

  @Override
  protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return SHAPE;
  }

  @Override
  protected boolean hasSidedTransparency(BlockState state) {
    return true;
  }

  @Override
  protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
    BlockState lowerBlockState = world.getBlockState(pos.down());

    if (lowerBlockState.isIn(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON)) {
      return false;
    }

    if (lowerBlockState.isIn(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON)) {
      return true;
    }

    if (lowerBlockState.isOf(Blocks.SNOW) && Objects.equals(lowerBlockState.get(SnowBlock.LAYERS), 8)) {
      return true;
    }

    return Block.isFaceFullSquare(lowerBlockState.getCollisionShape(world, pos.down()), Direction.UP);
  }

  @Override
  protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
    if (!state.canPlaceAt(world, pos)) {
      return Blocks.AIR.getDefaultState();
    }

    return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
  }

  @Override
  protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
    if (world.getLightLevel(LightType.BLOCK, pos) > 11) {
      dropStacks(state, world, pos);
      world.removeBlock(pos, false);
    }
  }

  @Override
  protected boolean canReplace(BlockState state, ItemPlacementContext context) {
    if (!context.getStack().isOf(Items.SNOW)) {
      return true;
    }

    if (context.canReplaceExisting()) {
      return context.getSide().equals(Direction.UP);
    }

    return true;
  }

  @Nullable
  @Override
  public BlockState getPlacementState(ItemPlacementContext context) {
    // TODO

    return super.getPlacementState(context);
  }

  @Override
  public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
    return new ItemStack(Items.SNOW);
  }
}
