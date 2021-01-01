package net.romvoid95.mcdeath.Client.screen;

import java.io.IOException;

import javax.annotation.Nullable;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MCDeathGuiGameOver extends GuiScreen {
  private int enableButtonsTimer;
  
  private final ITextComponent causeOfDeath = null;
  
  @Override
public void initGui() {
    this.buttonList.clear();
    this.enableButtonsTimer = 0;
    if (this.mc.world.getWorldInfo().isHardcoreModeEnabled()) {
      this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 72, 
            I18n.format("deathScreen.spectate", new Object[0])));
      this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96, 
            I18n.format("deathScreen." + (this.mc.isIntegratedServerRunning() ? "deleteWorld" : "leaveServer"), new Object[0])));
    } else {
      this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 72, 
            I18n.format("deathScreen.respawn", new Object[0])));
      this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96, 
            I18n.format("deathScreen.titleScreen", new Object[0])));
      if (this.mc.getSession() == null)
        this.buttonList.get(1).enabled = false; 
    } 
    for (GuiButton guibutton : this.buttonList)
      guibutton.enabled = false; 
  }
  
  @Override
protected void keyTyped(char typedChar, int keyCode) throws IOException {}
  
  @Override
protected void actionPerformed(GuiButton button) throws IOException {
    GuiYesNo guiyesno;
    switch (button.id) {
      case 0:
        this.mc.player.respawnPlayer();
        this.mc.displayGuiScreen((GuiScreen)null);
        break;
      case 1:
        if (this.mc.world.getWorldInfo().isHardcoreModeEnabled()) {
          this.mc.displayGuiScreen(new GuiMainMenu());
          break;
        } 
        guiyesno = new GuiYesNo(this, I18n.format("deathScreen.quit.confirm", new Object[0]), "", I18n.format("deathScreen.titleScreen", new Object[0]), I18n.format("deathScreen.respawn", new Object[0]), 0);
        this.mc.displayGuiScreen(guiyesno);
        guiyesno.setButtonDelay(20);
        break;
    } 
  }
  
  @Override
public void confirmClicked(boolean result, int id) {
    if (result) {
      if (this.mc.world != null)
        this.mc.world.sendQuittingDisconnectingPacket(); 
      this.mc.loadWorld(null);
      this.mc.displayGuiScreen(new GuiMainMenu());
    } else {
      this.mc.player.respawnPlayer();
      this.mc.displayGuiScreen(null);
    } 
  }
  
  @Override
public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    drawGradientRect(0, 0, this.width, this.height, 1615855616, -1602211792);
    GlStateManager.pushMatrix();
    GlStateManager.scale(2.0F, 2.0F, 2.0F);
    drawCenteredString(this.fontRenderer, 
        I18n.format("mcdeath.deathScreen.title", new Object[0]), this.width / 2 / 2, 30, 16777215);
    GlStateManager.popMatrix();
    if (this.causeOfDeath != null)
      drawCenteredString(this.fontRenderer, this.causeOfDeath.getFormattedText(), this.width / 2, 85, 16777215); 
    drawCenteredString(this.fontRenderer, 
        I18n.format("deathScreen.score", new Object[0]) + ": " + TextFormatting.YELLOW + this.mc.player.getScore(), this.width / 2, 100, 16777215);
    if (this.causeOfDeath != null && mouseY > 85 && mouseY < 85 + this.fontRenderer.FONT_HEIGHT) {
      ITextComponent itextcomponent = getClickedComponentAt(mouseX);
      if (itextcomponent != null && itextcomponent.getStyle().getHoverEvent() != null)
        handleComponentHover(itextcomponent, mouseX, mouseY); 
    } 
    super.drawScreen(mouseX, mouseY, partialTicks);
  }
  
  @Nullable
  public ITextComponent getClickedComponentAt(int p_184870_1_) {
    if (this.causeOfDeath == null)
      return null; 
    int i = this.mc.fontRenderer.getStringWidth(this.causeOfDeath.getFormattedText());
    int j = this.width / 2 - i / 2;
    int k = this.width / 2 + i / 2;
    int l = j;
    if (p_184870_1_ >= j && p_184870_1_ <= k) {
      for (ITextComponent itextcomponent : this.causeOfDeath) {
        l += this.mc.fontRenderer.getStringWidth(
            GuiUtilRenderComponents.removeTextColorsIfConfigured(itextcomponent.getUnformattedComponentText(), false));
        if (l > p_184870_1_)
          return itextcomponent; 
      } 
      return null;
    } 
    return null;
  }
  
  @Override
public boolean doesGuiPauseGame() {
    return false;
  }
  
  @Override
public void updateScreen() {
    super.updateScreen();
    this.enableButtonsTimer++;
    if (this.enableButtonsTimer == 20)
      for (GuiButton guibutton : this.buttonList)
        guibutton.enabled = true;  
  }
}
