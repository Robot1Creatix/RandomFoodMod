package com.creatix.randomfood.gui.container;

import com.creatix.randomfood.gui.slot.SmartSlot;
import com.creatix.randomfood.registry.OvenRegistry;
import com.creatix.randomfood.te.TileOven;
import com.gt22.gt22core.baseclasses.container.ContainerWithPlayerInv;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class OvenContainer extends ContainerWithPlayerInv {

	private TileOven te;
	public OvenContainer(IInventory playerInv, TileOven te) {
		super(playerInv, new Slot[] {new Slot(te, 0, 80, 32),new SmartSlot(te, 1, 80, 59, (stack) -> false)  ,new SmartSlot(te, 2, 157, 59, (stack) -> OvenRegistry.getFuel(stack) > 0)});
		this.te = te;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return te.isUseableByPlayer(playerIn);
	}

}
