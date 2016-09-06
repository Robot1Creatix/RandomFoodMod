package com.creatix.randomfood.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.creatix.randomfood.core.Core;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class OvenRegistry
{
	private static final List<IFuelHandler> ovenFuels = new ArrayList<>();
	public static final OvenRecipe INVALID_RECIPE = new OvenRecipe(new ItemStack(Blocks.FIRE), new ItemStack(Blocks.FIRE), 0);

	public static void init()
	{
		OvenRecipe.recipeList = new ArrayList<OvenRecipe>();
		registerRecepie(ItemRegistry.toast, ItemRegistry.baked_toast, 1);
		registerRecepie(ItemRegistry.baked_toast, ItemRegistry.burned_toast, 1);
		registerFuel(stack -> {
			if(stack.getItem() == Items.COAL)
			{
				return 3;
			}
			if(Block.getBlockFromItem(stack.getItem()) == Blocks.DRAGON_EGG)
			{
				return 100;
			}
			return 0;
		});
	}

	public static void registerRecepie(OvenRecipe rec)
	{
		OvenRecipe.register(rec);
	}

	public static void registerRecepie(ItemStack in, ItemStack out, int fuel)
	{
		registerRecepie(new OvenRecipe(in, out, fuel));
	}

	public static void registerRecepie(Item in, Item out, int fuel)
	{
		registerRecepie(new ItemStack(in), new ItemStack(out), fuel);
	}

	public static void registerFuel(IFuelHandler fuel)
	{
		ovenFuels.add(fuel);
	}

	public static void registerFuel(ItemStack fuel, int fuelValue)
	{
		registerFuel(stack -> ItemStack.areItemsEqual(stack, fuel) ? fuelValue : 0);
	}

	public static OvenRecipe getByInput(ItemStack input)
	{
		return OvenRecipe.getRecipeByInput(input);
	}

	public static List<OvenRecipe> getByOutput(ItemStack output)
	{
		return OvenRecipe.getRecipeByOutput(output);
	}

	public static int getFuel(ItemStack fuel)
	{
		if(fuel == null)
		{
			return 0;
		}
		int value = 0;
		for(IFuelHandler h : ovenFuels)
		{
			value = Math.max(value, h.getBurnTime(fuel));
		}
		return value;
	}

	public static class OvenRecipe
	{

		private static List<OvenRecipe> recipeList;

		public int reqFuel;
		public ItemStack input;
		public ItemStack output;

		public OvenRecipe(ItemStack input, ItemStack output, int fuel)
		{
			this.reqFuel = fuel;
			this.input = input;
			this.output = output;
		}

		private static void register(OvenRecipe rec)
		{
			if (!recipeList.contains(rec))
			{
				recipeList.add(rec);
				Core.log.info("Registered oven recipe for " + rec.output.getItem().getRegistryName());
			}
			else
			{
				Core.log.info("Unable to register oven recipe for " + rec.output.getItem().getRegistryName() + ": Recipe already exists");
				return;
			}
		}

		private static List<OvenRecipe> getRecipeByOutput(ItemStack output)
		{
			List<OvenRecipe> ret = new ArrayList<OvenRecipe>();
			recipeList.stream().filter(r -> ItemStack.areItemStacksEqual(output, r.output)).forEach(r -> ret.add(r));
			return ret;
		}

		private static OvenRecipe getRecipeByInput(ItemStack input)
		{
			OvenRecipe[] recepies = recipeList.stream().filter(r -> ItemStack.areItemsEqual(input, r.input)).toArray(size -> new OvenRecipe[size]);
			return recepies.length == 0 ? INVALID_RECIPE : recepies[0];
		}
	}

}
