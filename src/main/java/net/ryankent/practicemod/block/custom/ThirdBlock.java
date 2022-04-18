package net.ryankent.practicemod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ThirdBlock extends QuestBlocks {

    private int returnedVal;

    public ThirdBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient()) {
            if (hand == Hand.MAIN_HAND) {
                returnedVal = checkBlockProgression("Third Block");
                if(returnedVal == 1) {

                    player.sendMessage(new LiteralText("You completed a step in the quest, the next block is the Fourth Block"), false);
                    player.addExperienceLevels(5);

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

