package net.ryankent.practicemod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.ryankent.practicemod.PracticeMod;

public class ModItemGroup {
    public static final ItemGroup MOD = FabricItemGroupBuilder.build(new Identifier(PracticeMod.mod_id, "mod"),
            () -> new ItemStack(ModItems.BajaBlast));
}
