package net.ryankent.practicemod.world.dimension;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.ryankent.practicemod.block.ModBlocks;
import net.ryankent.practicemod.item.ModItems;

public class ModPortals {
    public static void registerPortals() { // Just sets the blocks that the portal has to be built with, the item to activate the portal, and the dimension it goes too
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.RUBY_BLOCK)
                .lightWithItem(ModItems.RUBY)
                .destDimID(ModDimensions.CUSTOM_DIMENSION_KEY.getValue())
                .tintColor(225,30,80)
                .registerPortal();
    }
}

