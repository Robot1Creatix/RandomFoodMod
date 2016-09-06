package com.creatix.randomfood.gui;

import com.creatix.randomfood.gui.container.OvenContainer;
import com.creatix.randomfood.gui.gui.OvenGui;
import com.creatix.randomfood.te.TileOven;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int OVEN = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		switch(ID)
		{
			case(OVEN):
			{
				return new OvenContainer(player.inventory, (TileOven) te);
			}
			default:
			{
				return null;
			}
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		switch(ID)
		{
			case(OVEN):
			{
				return new OvenGui(new OvenContainer(player.inventory, (TileOven) te), (TileOven) te);
			}
			default:
			{
				return null;
			}
		}
	}

}
