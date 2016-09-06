package com.creatix.randomfood.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelRegistry {

	public static List<Item> cachedItems = new ArrayList<>();
	public static List<Block> cachedBlocks = new ArrayList<>();
	
	public static void register(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	public static void register(Block block)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
	public static void init()
	{
		for(Item i : cachedItems)
		{
			register(i);
		}
		for(Block b : cachedBlocks)
		{
			register(b);
		}
		cachedBlocks = null;
		cachedItems = null;
	}
	
}
