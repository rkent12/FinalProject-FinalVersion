package net.ryankent.practicemod.block.custom;

import net.minecraft.block.Block;

import java.util.ArrayList;

public class QuestBlocks extends Block {

    private boolean hasBeenFound;
    private static int blockOrder = 0;
    private int blockReturn;

    public QuestBlocks(Settings settings) {
        super(settings);
    }

    public int checkBlockProgression(String blockName) {

        if (blockName == "First Block") {
            if (blockOrder == 0) {
                blockOrder = 1;
                blockReturn = 1;
                return blockReturn;
            } else if (blockOrder > 0) {
                //blockOrder = 0;
                blockReturn = 2;
                return blockReturn;
            }
        }
        else if(blockName == "Second Block") {
            if(blockOrder == 1) {
                blockOrder = 2;
                blockReturn = 1;
                return blockReturn;
            }
            else if(blockOrder < 1) {
                blockReturn = 2;
                return blockReturn;

            }
            else if(blockOrder > 1) {
                blockReturn = 3;
                return blockReturn;

            }
        }
        else if(blockName == "Third Block") {
            if(blockOrder == 2) {
                blockOrder = 3;
                blockReturn = 1;
                return blockReturn;
            }
            else if(blockOrder < 2) {
                blockReturn = 2;
                return blockReturn;

            }
            else if(blockOrder > 2) {
                blockReturn = 3;
                return blockReturn;

            }
        }
        else if(blockName == "Fourth Block") {
            if(blockOrder == 3) {
                blockOrder = 4;
                blockReturn = 1;
                return blockReturn;
            }
            else if(blockOrder < 3) {
                blockReturn = 2;
                return blockReturn;

            }
            else if(blockOrder > 3) {
                blockReturn = 3;
                return blockReturn;

            }
        }
        else if(blockName == "Fifth Block") {
            if(blockOrder == 4) {
                blockOrder = 5;
                blockReturn = 1;
                return blockReturn;
            }
            else if(blockOrder < 4) {
                blockReturn = 2;
                return blockReturn;

            }
            else if(blockOrder > 4) {
                blockReturn = 3;
                return blockReturn;

            }
        }

        return blockReturn;
    }



}
