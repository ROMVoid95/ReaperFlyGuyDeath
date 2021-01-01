package net.romvoid95.mcdeath.Client;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {
  public static SoundEvent MIIIIINCRAFT;
  
  public static void registerSounds() {
    MIIIIINCRAFT = registerSound("miiiiinecraft");
  }
  
  private static SoundEvent registerSound(String soundName) {
    ResourceLocation location = new ResourceLocation("mcdeath", "" + soundName);
    SoundEvent event = new SoundEvent(location);
    event.setRegistryName(soundName);
    ForgeRegistries.SOUND_EVENTS.register(event);
    return event;
  }
}
