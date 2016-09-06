package com.creatix.randomfood.blocks;

import com.creatix.randomfood.core.Core;
import com.creatix.randomfood.gui.GuiHandler;
import com.creatix.randomfood.te.TileOven;
import com.gt22.gt22core.texturegen.IMultitextureBlock;

import net.minecraft.block.BlockFurnace;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Oven extends BlockFurnace implements IMultitextureBlock {

	public Oven() {
		super(false);
		setRegistryName(new ResourceLocation(Core.modid, "oven"));
		setUnlocalizedName("Oven");
		setCreativeTab(Core.tab);
		setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public ResourceLocation getTexture(EnumFacing side) {
		String textureside;
		switch(side)
		{
			case NORTH:
			{
				textureside = "front";
				break;
			}
			case UP: case DOWN:
			{
				textureside = "top";
				break;
			}
			default:
			{
				textureside = "side";
			}
		}
		return new ResourceLocation(Core.modid, "blocks/oven_" + textureside);
	}
	
	@Override
	public ResourceLocation getParticleTexture() {
		return getTexture(EnumFacing.SOUTH);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileOven();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		playerIn.openGui(Core.instance, GuiHandler.OVEN, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this);
	}
}
