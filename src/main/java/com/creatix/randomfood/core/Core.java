package com.creatix.randomfood.core;

import com.creatix.randomfood.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Core.modid, name = Core.modid, version = Core.version)
public class Core
{
	public static final int majorversion = 1, minorversion = 0, mcversion = 1102, bugfixversion = 0;
	public static final String modid = "randomfood", name = "RandomFood", version = majorversion + "." + minorversion + "." + mcversion + "." + bugfixversion;

	@SidedProxy(clientSide = "com.creatix." + modid + ".proxy.ClientProxy", serverSide = "com.creatix." + modid + ".proxy.ServerProxy")
	public static CommonProxy proxy;

	@Instance(modid)
	public static Core instance;

	public static CreativeTabs tab = new CreativeTabs(modid)
	{
		@Override
		public Item getTabIconItem()
		{
			return Items.APPLE;
		}

	};
	@EventHandler
	public static void preInit(FMLPreInitializationEvent e)
	{
		proxy.preInit(e);
	}

	@EventHandler
	public static void init(FMLInitializationEvent e)
	{
		proxy.init(e);
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit(e);
	}

}
