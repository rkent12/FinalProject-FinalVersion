package net.ryankent.practicemod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

import java.util.ArrayList;

public class QuestBlocks extends Block {

    private boolean hasBeenFound;
    private static int blockOrder = 0;
    private int blockReturn;
    private int worldPosition;
    private boolean questCompleted;
    private ArrayList<RegistryKey<World>> worlds;


    public QuestBlocks(Settings settings) {
        super(settings);
    }

    public void checkBlockProgression(String blockName, PlayerEntity player, World world) { // Function to see handle which block is passed into it and handle what the output should be accordingly


        //blockOrder = getPositionPerWorld(world.getRegistryKey());

        if (blockName == "First Block") {
            if (blockOrder == 0) {
                blockOrder = 1;
                // To Reset the quest block line I comment out the line immediately above this, and uncomment the line immediately below this. Then I interact with the first block, close the app and revert the two lines previously edited to their original state
                //blockOrder = 0;
                blockReturn = 1;
                player.sendMessage(new LiteralText("You have begun the quest, the next block is the Second block"), false);
                RegistryKey<World> thisWorld = world.getRegistryKey();

            } else if (blockOrder > 0) {
                //blockOrder = 0;
                blockReturn = 2;
                player.sendMessage(new LiteralText("You have already interacted with this block"), false);

            }
        }
        else if(blockName == "Second Block") {
            if(blockOrder == 1) {
                blockOrder = 2;
                blockReturn = 1;
                player.sendMessage(new LiteralText("You completed a step in the quest, the next block is the Third block"), false);

            }
            else if(blockOrder < 1) {
                blockReturn = 2;
                player.sendMessage(new LiteralText("You are not ready to interact with this block"), false);


            }
            else if(blockOrder > 1) {
                blockReturn = 3;
                player.sendMessage(new LiteralText("You have already interacted with this block"), false);


            }
        }
        else if(blockName == "Third Block") {
            if(blockOrder == 2) {
                blockOrder = 3;
                blockReturn = 1;
                player.sendMessage(new LiteralText("You completed a step in the quest, the next block is the Fourth block"), false);
                player.addExperienceLevels(5);

            }
            else if(blockOrder < 2) {
                blockReturn = 2;
                player.sendMessage(new LiteralText("You are not ready to interact with this block"), false);


            }
            else if(blockOrder > 2) {
                blockReturn = 3;
                player.sendMessage(new LiteralText("You have already interacted with this block"), false);


            }
        }
        else if(blockName == "Fourth Block") {
            if(blockOrder == 3) {
                blockOrder = 4;
                blockReturn = 1;
                player.sendMessage(new LiteralText("You completed a step in the quest, the next block is the Fifth block"), false);
                player.addExperienceLevels(10);

            }
            else if(blockOrder < 3) {
                blockReturn = 2;
                player.sendMessage(new LiteralText("You are not ready to interact with this block"), false);


            }
            else if(blockOrder > 3) {
                blockReturn = 3;
                player.sendMessage(new LiteralText("You have already interacted with this block"), false);


            }
        }
        else if(blockName == "Fifth Block") {
            if(blockOrder == 4) {
                blockOrder = 5;
                blockReturn = 1;
                player.sendMessage(new LiteralText("You have completed the quest! Congratulations!"), false);
                player.addExperienceLevels(30);
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK,600,2));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE,600,2));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,600,3));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION,600,4));

            }
            else if(blockOrder < 4) {
                blockReturn = 2;
                player.sendMessage(new LiteralText("You are not ready to interact with this block"), false);


            }
        }


    }


    /*

    // This is one of the versions of what I came up with for trying to differentiate the worlds. It is just a rough idea because I couldn't really even access the World Registry Key

    public int getPositionPerWorld(RegistryKey<World> currentWorld) {
        int worldPosition;

        if((worlds.isEmpty()) || (worlds == null)) {
            worlds.set(0, currentWorld);
            worldPosition = 0;
        }
        else {
            if(worlds.contains(currentWorld)) {
                worldPosition = blockOrder;
            }
            else {
                worlds.add(currentWorld);
                worldPosition = 0;
            }
        }

        return worldPosition;
    }

    */

}
