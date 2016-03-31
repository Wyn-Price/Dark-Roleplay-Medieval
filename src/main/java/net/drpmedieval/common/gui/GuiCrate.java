package net.drpmedieval.common.gui;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiCrate extends GuiContainer{
public static final ResourceLocation BACKGROUND = new ResourceLocation(DarkRoleplayMedieval.MODID+ ":textures/guis/Crate.png");
	
	public GuiCrate(Container container) {
		super(container);
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks,int mouseX, int mouseY) {

		mc.renderEngine.bindTexture(BACKGROUND);
		
		int k = (this.width - this.xSize)/2;
		int l = (this.height - this.ySize)/2;
		drawTexturedModalRect(k,l,0,0,xSize,ySize);
		
	}
}
