package net.ryankent.practicemod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.ryankent.practicemod.PracticeMod;
import net.ryankent.practicemod.screenhandler.screen.BoxScreen;

@Environment(EnvType.CLIENT)
public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(PracticeMod.BOX_SCREEN_HANDLER, BoxScreen::new);
    }
}
