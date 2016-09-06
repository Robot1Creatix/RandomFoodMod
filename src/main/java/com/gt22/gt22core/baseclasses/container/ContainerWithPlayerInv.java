package com.gt22.gt22core.baseclasses.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public abstract class ContainerWithPlayerInv extends Container {

	protected int teslotscout;
	/**
	 * Just a container that add player inventory
	 * @param playerInv - inventory of player
	 * @param teslots - slots that will be added before player inv
	 */
	public ContainerWithPlayerInv(IInventory playerInv, Slot[] teslots) {
		teslotscout = teslots.length;
		for(Slot s : teslots)
		{
			addSlotToContainer(s);
		}
		for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        for (int x = 0; x < 9; x++) {
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
        }
	}
	
	@Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack previous = null;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);
        
        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();
	            if (fromSlot < teslotscout) {	      
	                if (!this.mergeItemStack(current, teslotscout + 1, 36 + teslotscout, true))
	                    return null;
	            } else {	            		
	            		if (!this.mergeItemStack(current, 0, teslotscout, false))
	            				return null;
	            }
            if (current.stackSize == 0)
                slot.putStack((ItemStack) null);
            else
                slot.onSlotChanged();

            if (current.stackSize == previous.stackSize)
                return null;
            slot.onPickupFromSlot(playerIn, current);
        }
        return previous;
    }
	
}
