package net.ryankent.practicemod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.ryankent.practicemod.PracticeMod;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {

    public static Enchantment THOR = register("thor",
            new ThorEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND)); // Registers the thor enchantment

    public static Enchantment ADRENALINE = register("adrenaline",
            new AdrenalineEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEARABLE, EquipmentSlot.CHEST)); // Registers the adrenaline enchantment


    private static Enchantment register(String name, Enchantment enchantment) { // Function to register enchantments
        return Registry.register(Registry.ENCHANTMENT, new Identifier(PracticeMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering Mod Enchantments for " + PracticeMod.MOD_ID);
    }
}
