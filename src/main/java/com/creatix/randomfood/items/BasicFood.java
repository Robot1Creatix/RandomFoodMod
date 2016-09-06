package com.creatix.randomfood.items;

import com.creatix.randomfood.core.Core;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Root on 9/5/2016.
 */
public class BasicFood extends ItemFood {

    public List<PotionEffect> effects;
    public boolean canDamage;
    private List<String> desc;
    public static final DamageSource poisoning = new DamageSource("poisoning");

    public BasicFood(String name, int amount, float saturation, boolean isWolfFood, boolean cd) {
        super(amount, saturation, isWolfFood);
        this.setUnlocalizedName(name);
        this.setCreativeTab(Core.tab);
        this.setRegistryName(name);
        this.setMaxStackSize(16);
        effects = new ArrayList<PotionEffect>();
        canDamage = cd;
    }
    public BasicFood(String name, int amount, float saturation, boolean isWolfFood, boolean cd, List<String> desc) {
    	this(name, amount, saturation, isWolfFood, cd);
    	this.desc = desc;
    }
    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
       super.onFoodEaten(stack, worldIn, player);
    }
    @Override
    @Nullable
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        if(!this.effects.isEmpty())
        {
            if(entityLiving instanceof EntityPlayer)
            {
                entityLiving.addPotionEffect(effects.get(worldIn.rand.nextInt(effects.size())));
            }
        }
        if(canDamage)
            entityLiving.attackEntityFrom(poisoning, 3F);
        return stack;
    }
    public BasicFood addEffect(PotionEffect e)
    {
        if(!effects.contains(e))
            effects.add(e);
        return this;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
    	if(desc != null)
    		tooltip.addAll(desc);
    }
}
