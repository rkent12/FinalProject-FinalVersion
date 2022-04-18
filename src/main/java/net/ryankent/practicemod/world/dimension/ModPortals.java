package net.ryankent.practicemod.world.dimension;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.ryankent.practicemod.block.ModBlocks;
import net.ryankent.practicemod.item.ModItems;

public class ModPortals {
    public static void registerPortals() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.RUBY_BLOCK)
                .lightWithItem(ModItems.RUBY)
                .destDimID(ModDimensions.KJDIM_KEY.getValue())
                .tintColor(225,30,80)
                .registerPortal();
    }
}

