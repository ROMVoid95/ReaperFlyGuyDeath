package net.romvoid95.mcdeath.Client;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.romvoid95.mcdeath.Client.screen.MCDeathGuiGameOver;

public class MCDeathHandler {
	
	private Minecraft mc = Minecraft.getMinecraft();
	
  @SideOnly(Side.CLIENT)
  @SubscribeEvent
  public void onPlayerDeath(GuiOpenEvent event) {
    if (event.getGui() instanceof net.minecraft.client.gui.GuiGameOver && 
      (Minecraft.getMinecraft()).currentScreen == null && !mc.player.isDead) {
      event.setGui(new MCDeathGuiGameOver());
      EntityPlayerSP entityPlayerSP = mc.player;
      Random random = new Random();
      entityPlayerSP.playSound(SoundsHandler.MIIIIINCRAFT, 5.0F, (random.nextInt(1) + 1));
    } 
  }
}
