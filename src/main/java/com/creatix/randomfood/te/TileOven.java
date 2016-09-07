package com.creatix.randomfood.te;

import com.creatix.randomfood.registry.OvenRegistry;
import com.creatix.randomfood.registry.OvenRegistry.OvenRecipe;
import com.gt22.gt22core.baseclasses.tileEntity.TileWithInventory;
import com.gt22.gt22core.utils.Gt22MathHelper;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;

public class TileOven extends TileWithInventory implements ITickable
{

	public int processTime = 0;
	public int fuel = 0;
	public static final int MAX_FUEL = 100;
	public static final int MAX_PROGRESS = 150;
	public static final int PROGRESS_BAR_HEIGHT = 32;
	public static final int FUEL_BAR_HEIGTH = 50;
	public TileOven()
	{
		super(3, true);
	}

	public int getFuelLevel()
	{
		return (fuel = (int) Gt22MathHelper.bound(fuel, 0, MAX_FUEL)) * FUEL_BAR_HEIGTH / MAX_FUEL;
	}

	public int getScaledProcess()
	{
		return (processTime = (int) Gt22MathHelper.bound(processTime, 0, MAX_PROGRESS)) * PROGRESS_BAR_HEIGHT / MAX_PROGRESS;
	}

	public boolean isProcessing()
	{
		return processTime > 0 && processTime <= 150;
	}

	public boolean canConsumeFuel(ItemStack fuel)
	{
		return Gt22MathHelper.isInBound(OvenRegistry.getFuel(fuel), 1, MAX_FUEL - this.fuel);
	}

	@Override
	public void update()
	{
		if (canConsumeFuel(getStackInSlot(2)))
		{
			fuel += OvenRegistry.getFuel(getStackInSlot(2));
			decrStackSize(2, 1);
		}
		OvenRecipe rec = OvenRegistry.getByInput(getStackInSlot(0));
		if (canProcess())
		{
			processTime++;
			if (processTime == MAX_PROGRESS)
			{
				decrStackSize(0, rec.input.stackSize);
				fuel -= rec.reqFuel;
				ItemStack outs = rec.output.copy();
				outs.stackSize += getOutputStackSize();
				setInventorySlotContents(1, outs);
				processTime = 0;
			}
		}
		else
		{
			processTime = 0;
		}
	}

	private boolean canProcess()
	{
		ItemStack out = getStackInSlot(1);
		ItemStack in = getStackInSlot(0);
		OvenRecipe rec = OvenRegistry.getByInput(in);
		return rec != OvenRegistry.INVALID_RECIPE && in.stackSize >= rec.input.stackSize && fuel >= rec.reqFuel && (out == null || (out.isItemEqual(rec.output) && out.stackSize <= getInventoryStackLimit() - rec.output.stackSize));
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		switch (index)
		{
			case (0):
			{
				return true;
			}
			case (1):
			{
				return false;
			}
			case (2):
			{
				return OvenRegistry.getFuel(stack) > 0;
			}
			default:
			{
				return false;
			}
		}
	}

	private int getOutputStackSize()
	{
		ItemStack out = getStackInSlot(1);
		return out == null ? 0 : out.stackSize;
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
