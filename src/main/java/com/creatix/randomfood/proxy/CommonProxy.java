package com.creatix.randomfood.proxy;

import com.creatix.randomfood.core.Core;
import com.creatix.randomfood.registry.BlockRegistry;
import com.creatix.randomfood.registry.ItemRegistry;
import com.gt22.gt22core.texturegen.TextureGenRegistry;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy
{
	public void preInit(FMLPreInitializationEvent e)
	{

	}
	public void init(FMLInitializationEvent e)
	{
		ItemRegistry.init(e.getSide());
	}

	public void postInit(FMLPostInitializationEvent e)
	{		GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.toast, 3),new Object[]{new ItemStack(ItemRegistry.knife, 1, OreDictionary.WILDCARD_VALUE), Items.BREAD});
	}
}
