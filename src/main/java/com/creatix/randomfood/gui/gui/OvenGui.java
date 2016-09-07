package com.creatix.randomfood.gui.gui;

import com.creatix.randomfood.core.Core;
import com.creatix.randomfood.te.TileOven;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;

public class OvenGui extends GuiContainer{

	private TileOven te;
	public OvenGui(Container cont, TileOven te) {
		super(cont);
		this.te = te;

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		mc.renderEngine.bindTexture(new ResourceLocation(Core.modid, "textures/gui/oven.png"));
		int k = (this.width - this.xSize) / 2;
	    int l = (this.height - this.ySize) / 2;
	    drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	    if(te.isProcessing())
	    {
	    	int pr = te.getScaledProcess();
	    	drawTexturedModalRect(k + 72, l + 54 - pr, 176, 31 - pr, 32, pr);
	    }
	    if(te.fuel > 0)
	    {
	    	int fuel = te.getFuelLevel();
	    	drawTexturedModalRect(k + 159, l + 56 - fuel, 176, 81 - fuel, 12, fuel);
	    }

	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		if(com.creatix.randomfood.utils.GuiHelper.isMouseBetween(mouseX, mouseY,k+159, l+9, 14, 50))
            this.drawHoveringText(Arrays.asList(te.fuel+"%"), mouseX-k, mouseY-l);
        if(te.getStackInSlot(0) == null)
            if(this.isPointInRegion(80, 32, 16, 16, mouseX, mouseY))
                 this.drawHoveringText(Arrays.asList("Input"), mouseX-k, mouseY-l);
        if(te.getStackInSlot(1) == null)
            if(this.isPointInRegion(80, 59, 16, 16, mouseX, mouseY))
                this.drawHoveringText(Arrays.asList("Output"), mouseX-k, mouseY-l);
        if(te.getStackInSlot(2) == null)
            if(this.isPointInRegion(157, 59, 16, 16, mouseX, mouseY))
                this.drawHoveringText(Arrays.asList("Fuel"), mouseX-k, mouseY-l);
	}
}
