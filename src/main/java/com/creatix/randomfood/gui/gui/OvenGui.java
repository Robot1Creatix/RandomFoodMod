package com.creatix.randomfood.gui.gui;

import com.creatix.randomfood.core.Core;
import com.creatix.randomfood.te.TileOven;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

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
	}

}
