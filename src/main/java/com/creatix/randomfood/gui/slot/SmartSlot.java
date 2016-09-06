package com.creatix.randomfood.gui.slot;

import java.util.function.Function;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SmartSlot extends Slot {

	private Function<ItemStack, Boolean> isvalid;
	public SmartSlot(IInventory inventoryIn, int index, int xPosition, int yPosition, Function<ItemStack, Boolean> isItemValid) {
		super(inventoryIn, index, xPosition, yPosition);
		isvalid = isItemValid;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return isvalid.apply(stack);
	}

}
