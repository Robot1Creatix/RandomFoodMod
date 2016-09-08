package com.creatix.randomfood.jei;

import java.util.List;

import com.creatix.randomfood.jei.oven.OvenRecepieCategory;
import com.creatix.randomfood.jei.oven.OvenRecipeHandler;
import com.creatix.randomfood.registry.BlockRegistry;
import com.creatix.randomfood.registry.OvenRegistry.OvenRecipe;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeHandler;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class RandomFoodJEI extends BlankModPlugin
{
	@Override
	public void register(IModRegistry r)
	{
		IGuiHelper h = r.getJeiHelpers().getGuiHelper();
		registerCat(r, new OvenRecepieCategory(h), new OvenRecipeHandler(), OvenRecipe.recipeList, new ItemStack(BlockRegistry.oven));
	}
	
	private void registerCat(IModRegistry r, IRecipeCategory cat, IRecipeHandler handler, List recipes, ItemStack craftingStack)
	{
		r.addRecipeCategories(cat);
		r.addRecipeHandlers(handler);
		r.addRecipes(recipes);
		r.addRecipeCategoryCraftingItem(craftingStack, cat.getUid());
	}
}
