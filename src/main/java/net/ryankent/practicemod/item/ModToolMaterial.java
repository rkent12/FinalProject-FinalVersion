package net.ryankent.practicemod.item;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

//Got majority of material code from C:\Users\ryang\.gradle\caches\fabric-loom\1.17.1\net.fabricmc.yarn.1_17_1.1.17.1+build.63-v2\minecraft-mapped.jar!\net\minecraft\item\ToolMaterials.class

public enum ModToolMaterial implements ToolMaterial {

        RUBY(2, 350, 6.5F, 3.0F, 25, () -> {
        return Ingredient.ofItems(ModItems.RUBY);
        }),

        RUBY2(4, 2031, 9.0F, 4.0F, 15, () -> {
            return Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_INGOT});
        });

        private final int miningLevel;
        private final int itemDurability;
        private final float miningSpeed;
        private final float attackDamage;
        private final int enchantability;
        private final Lazy<Ingredient> repairIngredient;

        private ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
            this.miningLevel = miningLevel;
            this.itemDurability = itemDurability;
            this.miningSpeed = miningSpeed;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairIngredient = new Lazy(repairIngredient);
        }

        public int getDurability() {
            return this.itemDurability;
        }

        public float getMiningSpeedMultiplier() {
            return this.miningSpeed;
        }

        public float getAttackDamage() {
            return this.attackDamage;
        }

        public int getMiningLevel() {
            return this.miningLevel;
        }

        public int getEnchantability() {
            return this.enchantability;
        }

        public Ingredient getRepairIngredient() {
            return (Ingredient)this.repairIngredient.get();
        }
    }

