package com.creatix.randomfood.jei;

import com.creatix.randomfood.jei.RecipeWrapperBase.RecipeBase;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class RecipeHandlerBase<T extends RecipeBase> implements IRecipeHandler<T>
{
	@FunctionalInterface
	public static interface IWrapperFactory<T extends RecipeBase>
	{
		public IRecipeWrapper create(T recipe);
	}
	
	private String uid;
	private Class<T> recipe;
	private IWrapperFactory<T> factory;
	public RecipeHandlerBase(String uid, Class<T> recipe, IWrapperFactory<T> factory)
	{
		this.uid = uid;
		this.recipe = recipe;
		this.factory = factory;
	}
	
	@Override
	public Class<T> getRecipeClass()
	{
		return recipe;
	}

	@Override
	public String getRecipeCategoryUid()
	{
		return uid;
	}

	@Override
	public String getRecipeCategoryUid(T recipe)
	{
		return getRecipeCategoryUid();
	}

	@Override
	public boolean isRecipeValid(T recipe)
	{
		return true;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(T recipe)
	{
		return factory.create(recipe);
	}

}
