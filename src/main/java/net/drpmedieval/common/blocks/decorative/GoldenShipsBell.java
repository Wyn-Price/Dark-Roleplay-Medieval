package net.drpmedieval.common.blocks.decorative;

import net.drpmedieval.client.sound.SoundEvents;
import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.blocks.templates.DRPMedievalMaterials;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.drpmedieval.common.util.SittingUtil;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class GoldenShipsBell   extends Block {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public GoldenShipsBell() {
		super(DRPMedievalMaterials.iron);
		this.setRegistryName("GoldenShipsBell");
		this.setUnlocalizedName("GoldenShipsBell");
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(2F);
		this.setSoundType(SoundType.ANVIL);
	}
	
	// -------------------------------------------------- Block Data --------------------------------------------------
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.25F, 0.4375F, 0.25F, 0.75F, 1F, 0.75F);
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
			case 0:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
			case 1:
				return this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
			case 2:
				return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
			case 3:
				return this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
			default:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {

		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		if(facing.equals(EnumFacing.NORTH)) return 0;
		if(facing.equals(EnumFacing.EAST)) return 1;
		if(facing.equals(EnumFacing.SOUTH)) return 2;
		if(facing.equals(EnumFacing.WEST)) return 3;
		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {FACING});
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	// -------------------------------------------------- Block Placement --------------------------------------------------
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock){
		if(!this.canBlockStay(worldIn, pos, EnumFacing.UP)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
		super.neighborChanged(state, worldIn, pos, neighborBlock);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {
		return worldIn.isSideSolid(pos.offset(EnumFacing.UP), EnumFacing.DOWN);
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		if(!worldIn.isSideSolid(pos.offset(EnumFacing.UP), EnumFacing.DOWN, true)) return Blocks.AIR.getDefaultState();
		EntityPlayer entity = (EntityPlayer) placer;
		if(entity != null){
			int dir = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			switch (dir) {
				case 0:
					return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
				case 1:
					return this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
				case 2:
					return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
				case 3:
					return this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
				default:
					return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
			}
		}
		return Blocks.AIR.getDefaultState();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		worldIn.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.ShipsBell, SoundCategory.BLOCKS, 3F, 1F, true);
		return true;
	}
	
	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn){
		worldIn.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.ShipsBell, SoundCategory.BLOCKS, 3F, 1F, true);
	}

}

