package com.creatix.randomfood.blocks;

import com.creatix.randomfood.core.Core;
import com.gt22.gt22core.texturegen.IMultitextureBlock;

import net.minecraft.block.BlockFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

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

}
