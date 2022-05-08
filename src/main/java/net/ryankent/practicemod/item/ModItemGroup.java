package net.ryankent.practicemod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.ryankent.practicemod.PracticeMod;

public class ModItemGroup { // Makes the mod tab in the creative menu, as well as the general mod category for items that I create
    public static final ItemGroup MOD = FabricItemGroupBuilder.build(new Identifier(PracticeMod.mod_id, "mod"),
            () -> new ItemStack(ModItems.BajaBlast));
}
