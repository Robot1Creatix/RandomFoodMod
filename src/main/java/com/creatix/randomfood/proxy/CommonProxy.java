package com.creatix.randomfood.proxy;

import com.creatix.randomfood.core.Core;
import com.creatix.randomfood.gui.GuiHandler;
import com.creatix.randomfood.registry.BlockRegistry;
import com.creatix.randomfood.registry.ItemRegistry;
import com.creatix.randomfood.registry.ModelRegistry;
import com.creatix.randomfood.registry.OvenRegistry;
import com.gt22.gt22core.texturegen.TextureGenRegistry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		ItemRegistry.init();
		BlockRegistry.init();
		OvenRegistry.init();
		TextureGenRegistry.reigster(new ItemRegistry(), Core.modid);
		TextureGenRegistry.reigster(new BlockRegistry(), Core.modid);
	}

	public void init(FMLInitializationEvent e) {
		ModelRegistry.init();
	}

	public static final ItemStack KNIFE = new ItemStack(ItemRegistry.knife, 1, OreDictionary.WILDCARD_VALUE);

	public void postInit(FMLPostInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(Core.instance, new GuiHandler());
		GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.toast, 3), new Object[] {KNIFE, Items.BREAD});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.apple_piece, 4), new Object[]{KNIFE, Items.APPLE});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.APPLE), new Object[]{ItemRegistry.apple_piece, ItemRegistry.apple_piece,ItemRegistry.apple_piece,ItemRegistry.apple_piece});
		GameRegistry.addRecipe(new ItemStack(BlockRegistry.oven),
				new Object[]{ "BPB", "IFI", "BIB",
						('B'), Blocks.BRICK_BLOCK, ('P'), Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, ('I'), Items.IRON_INGOT, ('F'), Blocks.FURNACE});
	}
	
	@SideOnly(Side.CLIENT)
	public void cache(Item i)
	{
		//NO-OP
	}
	
	@SideOnly(Side.CLIENT)
	public void cache(Block b)
	{
		//NO-OP
	}
}
