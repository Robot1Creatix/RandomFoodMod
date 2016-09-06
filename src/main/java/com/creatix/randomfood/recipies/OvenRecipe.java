package com.creatix.randomfood.recipies;

import com.creatix.randomfood.blocks.Oven;
import com.creatix.randomfood.core.Core;
import com.creatix.randomfood.registry.ItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Root on 9/6/2016.
 */
public class OvenRecipe {

    public static List<OvenRecipe> recipeList;

    public static final OvenRecipe INVALID_RECIPE = new OvenRecipe(new ItemStack(Blocks.FIRE), new ItemStack(Blocks.FIRE), 0);

    public int reqFuel;
    public ItemStack input;
    public ItemStack output;

    public OvenRecipe(ItemStack input, ItemStack output, int fuel)
    {
        this.reqFuel = fuel;
        this.input = input;
        this.output = output;
    }
    public OvenRecipe(ItemStack input, ItemStack output)
    {
        this(input, output, 3);
    }

    public static void initRecipies()
    {
        recipeList = new ArrayList<OvenRecipe>();
        register(new OvenRecipe(new ItemStack(ItemRegistry.baked_toast) , new ItemStack(ItemRegistry.burned_toast), 1));
    }

    private static void register(OvenRecipe rec)
    {
        if(!recipeList.contains(rec)) {
            recipeList.add(rec);
            Core.log.info("Registered oven recipe for "+rec.output.getItem().getRegistryName());
        }else{
            Core.log.info("Unable to register oven recipe for "+rec.output.getItem().getRegistryName()+": Recipe already exists");
            return;
        }
    }
    public static List<OvenRecipe> getRecipe(ItemStack output)
    {
        List<OvenRecipe> ret = new ArrayList<OvenRecipe>();
        for(OvenRecipe r : recipeList)
        {
            if(ItemStack.areItemStacksEqual(output, r.output))
                ret.add(r);
        }
        return ret;
    }
    public static OvenRecipe getRecipeByInput(ItemStack input)
    {
        for(OvenRecipe r : recipeList)
        {
            if(r.input.isItemEqual(input))
                return r;
        }
        return INVALID_RECIPE;
    }
}
