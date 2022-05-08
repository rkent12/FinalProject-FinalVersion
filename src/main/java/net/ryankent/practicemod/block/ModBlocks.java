package net.ryankent.practicemod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.ryankent.practicemod.PracticeMod;
import net.ryankent.practicemod.block.custom.*;
import net.ryankent.practicemod.item.ModItemGroup;
import net.ryankent.practicemod.world.features.tree.CorruptedSaplingGenerator;


public class ModBlocks {

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
        new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f)
                .breakByTool(FabricToolTags.PICKAXES,2).requiresTool()));

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6.0f)
                    .breakByTool(FabricToolTags.PICKAXES,2).requiresTool()));
    public static final Block RUBY_STAIRS = registerBlock("ruby_stairs",
            new ModStairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(6.0f)
                    .breakByTool(FabricToolTags.PICKAXES,2).requiresTool()));
    public static final Block RUBY_SLAB = registerBlock("ruby_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(6.0f)
                    .breakByTool(FabricToolTags.PICKAXES,2).requiresTool()));


    public static final Block UI_BLOCK = registerBlock("ui_block",
            new UIBlock(FabricBlockSettings.of(Material.STONE).strength(6f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().nonOpaque()));

    public static final Block STATUS_BLOCK = registerBlock("status_block",
            new StatusBlock(FabricBlockSettings.of(Material.STONE).strength(6.0f)
                    .breakByTool(FabricToolTags.PICKAXES,2).requiresTool()));

    public static final Block FIRST_BLOCK = registerBlock("first_block",
            new FirstBlock(FabricBlockSettings.of(Material.STONE).strength(6.0f)
                    .breakByTool(FabricToolTags.PICKAXES,2).requiresTool()));
    public static final Block SECOND_BLOCK = registerBlock("second_block",
            new SecondBlock(FabricBlockSettings.of(Material.STONE).strength(6.0f)
                    .breakByTool(FabricToolTags.PICKAXES,2).requiresTool()));
    public static final Block THIRD_BLOCK = registerBlock("third_block",
            new ThirdBlock(FabricBlockSettings.of(Material.STONE).strength(6.0f)
                    .breakByTool(FabricToolTags.PICKAXES,2).requiresTool()));
    public static final Block FOURTH_BLOCK = registerBlock("fourth_block",
            new FourthBlock(FabricBlockSettings.of(Material.STONE).strength(6.0f)
                    .breakByTool(FabricToolTags.PICKAXES,2).requiresTool()));
    public static final Block FIFTH_BLOCK = registerBlock("fifth_block",
            new FifthBlock(FabricBlockSettings.of(Material.STONE).strength(6.0f)
                    .breakByTool(FabricToolTags.PICKAXES,2).requiresTool()));

    public static final Block CORRUPTED_LOG = registerBlock("corrupted_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CORRUPTED_WOOD = registerBlock("corrupted_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));


    public static final Block STRIPPED_CORRUPTED_LOG = registerBlock("stripped_corrupted_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_CORRUPTED_WOOD = registerBlock("stripped_corrupted_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block CORRUPTED_PLANKS = registerBlock("corrupted_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block CORRUPTED_LEAVES = registerBlock("corrupted_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block CORRUPTED_SAPLING = registerBlock("corrupted_sapling",
            new ModSaplingBlock(new CorruptedSaplingGenerator(),
                        FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name,block);
        return Registry.register(Registry.BLOCK, new Identifier(PracticeMod.mod_id, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(PracticeMod.mod_id, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.MOD)));
    }

    public static void registerModBlocks() {
        System.out.println("Registering ModBlocks for " + PracticeMod.mod_id);
    }
}
