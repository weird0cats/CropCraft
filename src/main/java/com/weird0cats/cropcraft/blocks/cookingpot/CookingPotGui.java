package com.weird0cats.cropcraft.blocks.cookingpot;

import com.weird0cats.cropcraft.CropCraft;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;

public class CookingPotGui extends GuiContainer
{
   public static final int WIDTH = 176;
   public static final int HEIGHT = 166;

   private static final ResourceLocation background = new ResourceLocation(CropCraft.MODID, "textures/gui/cookingpot.png");

   private TileEntityCookingPot te;
   private InventoryPlayer playerInv;

   public CookingPotGui(ContainerCookingPot container, InventoryPlayer playerInv)
   {
      super(container);
      
      this.playerInv = playerInv;
		this.te = container.getTile();
      xSize = WIDTH;
      ySize = HEIGHT;
   }

   @Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
   {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

   @Override
   protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
   {
      mc.getTextureManager().bindTexture(background);
      drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
   }
   
   @Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
   {
      
      this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 4210752);
      if (this.playerInv.getDisplayName()!=null)
      {
         
         this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
      }
   }
}