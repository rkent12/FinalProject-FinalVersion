package net.ryankent.practicemod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class AdrenalineEnchantment extends Enchantment {
    protected AdrenalineEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEARABLE, new EquipmentSlot[] {EquipmentSlot.CHEST});
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity target, int level) {  //The function that actually applies speed to the user when they are damaged
        if(!user.world.isClient()) {
            ServerWorld world = ((ServerWorld) user.world);
            PlayerEntity player = ((PlayerEntity) user);
            BlockPos position = target.getBlockPos();

            if(level==1) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10 * 2 * level, level - 1));
            }
            if(level==2) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 15 * 2 * level, level + 1));
            }
        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    } // The maximum level of the enchantment
}