package net.romvoid95.mcdeath;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.romvoid95.mcdeath.Client.MCDeathHandler;
import net.romvoid95.mcdeath.Client.SoundsHandler;
import net.romvoid95.mcdeath.Util.MCDeathLog;

@Mod(modid = "mcdeath", name = "ReaperFlyGuyDeath", version = "1.0.0", clientSideOnly = true, canBeDeactivated = true, acceptedMinecraftVersions = "[1.12.2]")
public class MCDeath {
  @Instance
  MCDeath instance;
  
  public static final MCDeathLog LOGGER = new MCDeathLog();
  
  @EventHandler
  public static void preInit(FMLPreInitializationEvent event) {
    SoundsHandler.registerSounds();
    MinecraftForge.EVENT_BUS.register(new MCDeathHandler());
  }
  
  @EventHandler
  public static void init(FMLInitializationEvent event) {}
  
  @EventHandler
  public static void postInit(FMLPostInitializationEvent event) {}
}
