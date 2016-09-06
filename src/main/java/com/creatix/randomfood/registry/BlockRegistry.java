package com.creatix.randomfood.registry;

import com.creatix.randomfood.blocks.Oven;
import com.creatix.randomfood.core.Core;
import com.gt22.gt22core.baseclasses.block.BlockWithTile;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry
{
	public static Block oven;
	public static void register(Block b)
	{
		GameRegistry.registerBlock(b);
		Core.proxy.cache(b);
		if(b instanceof BlockWithTile)
		{
			Class<? extends TileEntity> te = ((BlockWithTile) b).getTe();
			GameRegistry.registerTileEntity(te, Core.modid + ":" + te.getSimpleName());
		}
		else if(b instanceof ITileEntityProvider)
		{
			TileEntity te = ((ITileEntityProvider) b).createNewTileEntity(null, 0);
			GameRegistry.registerTileEntity(te.getClass(), Core.modid + ":" + te.getClass().getSimpleName());
		}
	}
	
	public static void init() {
		register(oven = new Oven());
	}
	
}
