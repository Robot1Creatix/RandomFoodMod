package com.creatix.randomfood.jei.oven;

import com.creatix.randomfood.registry.OvenRegistry;
import com.creatix.randomfood.registry.OvenRegistry.OvenRecipe;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class OvenRecipeHandler implements IRecipeHandler<OvenRecipe>
{

	@Override
	public Class<OvenRecipe> getRecipeClass()
	{
		return OvenRecipe.class;
	}

	@Override
	public String getRecipeCategoryUid()
	{
		return OvenRecepieCategory.UID;
	}

	@Override
	public String getRecipeCategoryUid(OvenRecipe recipe)
	{
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(OvenRecipe recipe)
	{
		return new OvenRecepieWrapper(recipe);
	}

	@Override
	public boolean isRecipeValid(OvenRecipe recipe)
	{
		return recipe != OvenRegistry.INVALID_RECIPE;
	}

}
