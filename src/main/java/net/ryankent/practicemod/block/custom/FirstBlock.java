package net.ryankent.practicemod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public class FirstBlock extends QuestBlocks {

    private int returnedVal;

    public FirstBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient()) {
            if (hand == Hand.MAIN_HAND) {
                checkBlockProgression("First Block", player, world); // Checks if the player is on that block in the block progression
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

}

