package net.ryankent.practicemod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.ryankent.practicemod.PracticeMod;
import net.ryankent.practicemod.item.custom.*;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ShovelItem;


public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings().group(ModItemGroup.MOD)));

    public static final Item DOWSING_ROD = registerItem("dowsing_rod", new DowsingRodItem(new FabricItemSettings().group(ModItemGroup.MOD).maxDamage(10)));

    public static final Item IRON_WOOL = registerItem("iron_wool", new Item(new FabricItemSettings().group(ModItemGroup.MOD)));

    public static final Item CUSTOM_ITEM = registerItem("custom_item", new CustomItem(new FabricItemSettings().group(ModItemGroup.MOD).maxDamage(10)));


    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new SwordItem(ModToolMaterial.RUBY, 7, 3f,
                    new FabricItemSettings().group(ModItemGroup.MOD)));

    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
            new ShovelItem(ModToolMaterial.RUBY, 2, 1f,
                    new FabricItemSettings().group(ModItemGroup.MOD)));

    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new ModPickaxeItem(ModToolMaterial.RUBY, 4, 1f,
                    new FabricItemSettings().group(ModItemGroup.MOD)));
    public static final Item RUBY_AXE = registerItem("ruby_axe",
            new ModAxeItem(ModToolMaterial.RUBY, 9, 3f,
                    new FabricItemSettings().group(ModItemGroup.MOD)));
    public static final Item RUBY_HOE = registerItem("ruby_hoe",
            new ModHoeItem(ModToolMaterial.RUBY, 2, 1f,
                    new FabricItemSettings().group(ModItemGroup.MOD)));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.MOD)));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.MOD)));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.MOD)));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.MOD)));


    public static final Item BajaBlast = registerItem("bajablast", new Item(new FabricItemSettings().
        food(new FoodComponent.Builder().hunger(4).saturationModifier(1f).build()).group(ModItemGroup.MOD)));

    public static final Item Pepper = registerItem("pepper", new Item(new FabricItemSettings().
        food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()).group(ModItemGroup.MOD)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(PracticeMod.mod_id, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering mod items for " + PracticeMod.mod_id);
    }
}
