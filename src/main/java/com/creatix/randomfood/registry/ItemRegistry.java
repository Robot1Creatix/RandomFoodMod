package com.creatix.randomfood.registry;

import java.util.Arrays;

import com.creatix.randomfood.core.Core;
import com.creatix.randomfood.items.BasicFood;
import com.creatix.randomfood.items.Knife;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class ItemRegistry
{

	public static BasicFood toast = new BasicFood("toast", 1, 1F, false, false);
	public static BasicFood baked_toast = new BasicFood("baked_toast", 4, 4F, false, false);
	public static BasicFood burned_toast = new BasicFood("burned_toast", 1, 2F, false, true, Arrays.asList(new TextComponentTranslation("text.burned_toast.desc").getFormattedText()));
	public static Item knife = new Knife();

	private static void register(Item item,String name ,Side s)
	{
		if(s == Side.CLIENT)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Core.modid+":"+name, "inventory"));
		GameRegistry.registerItem(item);
	}

	public static void init(Side s)
	{
		register(toast, "toast", s);
		register(baked_toast, "baked_toast", s);
		register(burned_toast, "burned_toast", s);
		register(knife, "knife", s);
	}
}
