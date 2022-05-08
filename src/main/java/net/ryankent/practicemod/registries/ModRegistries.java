package net.ryankent.practicemod.registries;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.ryankent.practicemod.PracticeMod;
import net.ryankent.practicemod.block.ModBlocks;
import net.ryankent.practicemod.item.ModItems;

public class ModRegistries {

    public static void registerModFuels() { // Registers special item categories that have to be loaded differently, like the custom fuel
        System.out.println("Registering Fuels For " + PracticeMod.mod_id);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.IRON_WOOL, 1000); // Seconds is = to X%20
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.CORRUPTED_LOG, ModBlocks.STRIPPED_CORRUPTED_LOG);
        StrippableBlockRegistry.register(ModBlocks.CORRUPTED_WOOD, ModBlocks.STRIPPED_CORRUPTED_WOOD);
    }

}
