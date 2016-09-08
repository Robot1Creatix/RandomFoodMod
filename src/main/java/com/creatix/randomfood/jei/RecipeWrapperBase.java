package com.creatix.randomfood.jei;

import java.util.List;

import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fluids.FluidStack;
public class RecipeWrapperBase<T extends RecipeWrapperBase.RecipeBase> implements IRecipeWrapper
{
	
	public static class RecipeBase
	{
		private List in, out;
		
		public RecipeBase(List input, List output)
		{
			in = input;
			out = output;
		}
		
		public List getInputs()
		{
			return in;
		}

		public List getOutputs()
		{
			return out;
		}
	}
	
	public static class RecipeFluid extends RecipeBase
	{
		private List<FluidStack> fluidin, fluidout;
		public RecipeFluid(List input, List output, List<FluidStack> fluidinput, List<FluidStack> fluidoutput)
		{
			super(input, output);
			fluidin = fluidinput;
			fluidout = fluidoutput;
		}
		
		public List<FluidStack> getFluidInputs()
		{
			return fluidin;
		}

		public List<FluidStack> getFluidOutputs()
		{
			return fluidout;
		}
	}
	
	public T recipe;
	
	public RecipeWrapperBase(T recipe)
	{
		this.recipe = recipe;
	}
	
	@Override
	public List getInputs()
	{
		return recipe.getInputs();
	}

	@Override
	public List getOutputs()
	{
		return recipe.getOutputs();
	}

	@Override
	public List<FluidStack> getFluidInputs()
	{
		return recipe instanceof RecipeFluid ? ((RecipeFluid) recipe).getFluidInputs() : null;
	}

	@Override
	public List<FluidStack> getFluidOutputs()
	{
		return recipe instanceof RecipeFluid ? ((RecipeFluid) recipe).getFluidOutputs() : null;
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
	
	

}
