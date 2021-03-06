package net.dark_roleplay.medieval.common.blocks.helper;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface RopeFixPoint {

	boolean isRopeFixable(World worldIn, BlockPos pos, EnumFacing side);

	BlockPos getPlacementOffset(World world, BlockPos fixPoint, BlockPos rope);

}
