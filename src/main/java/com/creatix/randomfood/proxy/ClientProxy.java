package com.creatix.randomfood.proxy;

import com.creatix.randomfood.registry.ModelRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void cache(Item i) {
		ModelRegistry.cachedItems.add(i);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void cache(Block b) {
		ModelRegistry.cachedBlocks.add(b);
	}
}
