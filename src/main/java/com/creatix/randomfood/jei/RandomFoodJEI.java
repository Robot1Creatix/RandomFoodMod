package com.creatix.randomfood.jei;

import com.creatix.randomfood.jei.oven.OvenRecepieCategory;
import com.creatix.randomfood.jei.oven.OvenRecipeHandler;
import com.creatix.randomfood.registry.BlockRegistry;
import com.creatix.randomfood.registry.OvenRegistry.OvenRecipe;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class RandomFoodJEI extends BlankModPlugin
{
	@Override
	public void register(IModRegistry r)
	{
		r.addRecipeCategories(new OvenRecepieCategory(r.getJeiHelpers().getGuiHelper()));
		r.addRecipeHandlers(new OvenRecipeHandler());
		r.addRecipes(OvenRecipe.recipeList);
		r.addRecipeCategoryCraftingItem(new ItemStack(BlockRegistry.oven), OvenRecepieCategory.UID);
	}
}
