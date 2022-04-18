package net.ryankent.practicemod.item.custom;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import net.ryankent.practicemod.item.ModItems;


public class ModAxeItem extends AxeItem {
    public ModAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
