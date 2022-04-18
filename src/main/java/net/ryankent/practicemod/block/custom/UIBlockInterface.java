package net.ryankent.practicemod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface UIBlockInterface {
    void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, Boolean moved);
}
