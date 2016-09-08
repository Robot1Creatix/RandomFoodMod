package com.creatix.randomfood.jei.oven;

import java.util.Arrays;
import java.util.List;

import com.creatix.randomfood.registry.OvenRegistry.OvenRecipe;

import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fluids.FluidStack;

public class OvenRecepieWrapper implements IRecipeWrapper
{
	private OvenRecipe recipe;
	public OvenRecepieWrapper(OvenRecipe recipe)
	{
		this.recipe = recipe;
	}
	
	@Override
	public List getInputs()
	{
		return Arrays.asList(recipe.input);
	}

	@Override
	public List getOutputs()
	{
		return Arrays.asList(recipe.output);
	}

	@Override
	public List<FluidStack> getFluidInputs()
	{
		return null;
	}

	@Override
	public List<FluidStack> getFluidOutputs()
	{
		return null;
	}

	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
	{
		
	}

	@Override
	public void drawAnimations(Minecraft minecraft, int recipeWidth, int recipeHeight)
	{
		
	}

	@Override
	public List<String> getTooltipStrings(int mouseX, int mouseY)
	{
		return null;
	}

	@Override
	public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int mouseButton)
	{
		return false;
	}

	public int getFuel()
	{
		return recipe.reqFuel;
	}
	
}
