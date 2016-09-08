package com.creatix.randomfood.jei.oven;

import java.util.Collection;
import java.util.List;

import com.creatix.randomfood.core.Core;
import com.creatix.randomfood.jei.RecipeWrapperBase;
import com.creatix.randomfood.registry.OvenRegistry.OvenRecipe;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class OvenRecepieCategory implements IRecipeCategory<RecipeWrapperBase<OvenRecipe>>
{
	
	private static final ResourceLocation oven = new ResourceLocation(Core.modid, "textures/gui/oven.png");;
	public static final String UID = "RANDOMFOODOVEN";
	private RecipeWrapperBase<OvenRecipe> recipe;
	private IDrawable back;
	private IGuiHelper helper;
	public OvenRecepieCategory(IGuiHelper g)
	{
		back = g.createDrawable(oven, 0, 0, 176, 166);
		helper = g;
	}
	
	@Override
	public String getUid()
	{
		return UID;
	}

	@Override
	public String getTitle()
	{
		return I18n.format("randomfood.oven");
	}

	@Override
	public IDrawable getBackground()
	{
		return back;
	}

	@Override
	public void drawExtras(Minecraft minecraft)
	{
		String fuel = I18n.format("randomfood.oven.reqfuel", recipe.recipe.reqFuel);
		minecraft.fontRendererObj.drawStringWithShadow(fuel, (88 - minecraft.fontRendererObj.getStringWidth(fuel) / 2), 10, 0xB0B0B0);
	}

	@Override
	public void drawAnimations(Minecraft minecraft)
	{
		
	}

	@Override
	public void setRecipe(IRecipeLayout layout, RecipeWrapperBase<OvenRecipe> rec)
	{
		IGuiItemStackGroup stacks = layout.getItemStacks();
		stacks.init(0, true, 79, 31);
		stacks.init(1, false, 79, 58);
		stacks.set(0, (ItemStack) rec.getInputs().get(0));
	    List<?> outputs = rec.getOutputs();
	    stacks.set(1, (ItemStack)rec.getOutputs().get(0));
	    recipe = rec;
	}

}
