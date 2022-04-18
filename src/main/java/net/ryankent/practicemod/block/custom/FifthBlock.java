package net.ryankent.practicemod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FifthBlock extends QuestBlocks {

    private int returnedVal;

    public FifthBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient()) {
            if (hand == Hand.MAIN_HAND) {
                returnedVal = checkBlockProgression("Fifth Block");
                if(returnedVal == 1) {

                    player.sendMessage(new LiteralText("You have completed the quest! Congratulations!"), false);
                    player.addExperienceLevels(30);
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK,600,2));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE,600,2));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,600,3));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION,600,4));
                }
                else if(returnedVal == 2) {
                    player.sendMessage(new LiteralText("You are not ready to interact with this block yet"), false);
                }
                else if(returnedVal == 3) {
                    player.sendMessage(new LiteralText("You have already interacted with this block"), false);
                }
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

}

