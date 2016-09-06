package com.creatix.randomfood.items;

import com.creatix.randomfood.core.Core;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Root on 9/5/2016.
 */
public class Knife extends ItemSword {

    public Knife(){
        super(ToolMaterial.IRON);
        this.setMaxStackSize(1);
        this.setRegistryName("knife");
        this.setUnlocalizedName("knife");
        this.setCreativeTab(Core.tab);
        this.setMaxDamage(40);
        this.setNoRepair();
    }

    @Override
    public boolean getShareTag()
    {
        return true;
    }

    public boolean hasContainerItem(ItemStack itemStack)
    {
       return true;
    }
    @Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        ItemStack stack = itemStack.copy();

        stack.setItemDamage(stack.getItemDamage() + 1);
        stack.stackSize = 1;

        return stack;
    }
}

