package net.ryankent.practicemod.world.gen;


public class ModWorldGen {
    public static void generateModWorldGen() { // Loads the changes to any world generation that I make
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
    }


}
