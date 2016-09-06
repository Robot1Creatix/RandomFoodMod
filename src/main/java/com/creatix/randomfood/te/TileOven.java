package com.creatix.randomfood.te;

import com.creatix.randomfood.blocks.Oven;
import com.creatix.randomfood.recipies.OvenRecipe;
import com.gt22.gt22core.baseclasses.tileEntity.TileWithInventory;
import mezz.jei.plugins.jei.JEIInternalPlugin;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;

public class TileOven extends TileWithInventory implements ITickable{

	public int processTime;
	public int fuel = 20;

	public TileOven() {
		super(2, true);
		OvenRecipe.initRecipies();
	}

	public float getFuelLevel() {
		if(fuel < 0)
			fuel = 0;
		if(fuel > 100)
			fuel = 100;
		return fuel / 100;
	}
	public int getScaledProcess(int i) {
		if(processTime < 0)
			processTime = 0;
		if(processTime > 150)
			processTime = 150;
		return processTime * i / 150;
	}
	public boolean isProcessing() {
		return processTime > 0 && processTime <= 150;
	}
	@Override
	public void update() {

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		ItemStack fuelSlot = getStackInSlot(2);
		ItemStack out = getStackInSlot(1);
		ItemStack in = getStackInSlot(0);
				if(OvenRecipe.getRecipeByInput(in) != OvenRecipe.INVALID_RECIPE)
				{
					OvenRecipe rec = OvenRecipe.getRecipeByInput(in);
					if(in.stackSize < rec.input.stackSize)
						return;
					if(fuel < rec.reqFuel)
						return;
					if(out == null || (out.isItemEqual(rec.input) && out.stackSize <= getInventoryStackLimit()-rec.output.stackSize)) {
						processTime++;
						if(processTime == 150) {
							if (out == null) {
								decrStackSize(0, rec.input.stackSize);
								setInventorySlotContents(1, rec.output);
								fuel -= rec.reqFuel;
							} else {
								decrStackSize(0, rec.input.stackSize);
								getStackInSlot(1).stackSize+=rec.output.stackSize;
								fuel -=rec.reqFuel;
							}
							processTime = 0;
						}
					}else{}
				}
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setInteger("fuel", fuel);
		return  nbt;
	}
	@Override
	protected void writeSyncNbt(NBTTagCompound nbt)
	{
		super.writeSyncNbt(nbt);
		nbt.setInteger("FUEL", fuel);
		nbt.setInteger("PROC", processTime);
	}
	@Override
	protected void readSyncNbt(NBTTagCompound nbt)
	{
		super.readSyncNbt(nbt);
		fuel = nbt.getInteger("FUEL");
		processTime = nbt.getInteger("PROC");
	}
}
