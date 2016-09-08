package com.creatix.randomfood.jei.oven;

import com.creatix.randomfood.jei.RecipeHandlerBase;
import com.creatix.randomfood.jei.RecipeWrapperBase;
import com.creatix.randomfood.registry.OvenRegistry;
import com.creatix.randomfood.registry.OvenRegistry.OvenRecipe;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class OvenRecipeHandler extends RecipeHandlerBase<OvenRecipe>
{

	public OvenRecipeHandler()
	{
		super(OvenRecepieCategory.UID, OvenRecipe.class, RecipeWrapperBase<OvenRecipe>::new);
	}

}
