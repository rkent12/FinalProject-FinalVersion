package net.ryankent.practicemod.world.features;

import com.mojang.datafixers.kinds.Const;
import com.mojang.serialization.Decoder;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.ryankent.practicemod.PracticeMod;
import net.ryankent.practicemod.block.ModBlocks;
import net.ryankent.practicemod.world.gen.ModWorldGen;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_TREE_KEY = registerKey("corrupted_spawn");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");

    public static final ConfiguredFeature<TreeFeatureConfig, ?> CORRUPTED_TREE = register("corrupted",
            Feature.TREE.configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.CORRUPTED_LOG.getDefaultState()),
                    new StraightTrunkPlacer(5,5,4),
                    new SimpleBlockStateProvider(ModBlocks.CORRUPTED_LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(ModBlocks.CORRUPTED_SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1,0,1)).build()));


    public static final ConfiguredFeature<?, ?> CORRUPTED_TREE_SPAWN = register(CORRUPTED_TREE
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING))
                    .spreadHorizontally().applyChance(3)), CORRUPTED_TREE_KEY);


    public static final ConfiguredFeature<?, ?> RUBY_ORE = register(Feature.ORE.configure(new OreFeatureConfig(
            OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.RUBY_ORE.getDefaultState(), 8))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(2),YOffset.fixed(45)))) // Bottom Y Level of Spawn and Top Y level of spawn
            .spreadHorizontally().repeat(8), RUBY_ORE_KEY); // Number of Veins per chunk


    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(PracticeMod.MOD_ID, name));
    }

    private static ConfiguredFeature<TreeFeatureConfig, ?> register(String name,ConfiguredFeature<TreeFeatureConfig, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(PracticeMod.MOD_ID, name),
            configuredFeature);
    }



    private static ConfiguredFeature<?, ?> register(ConfiguredFeature<?, ?> configuredFeature,
                                                    RegistryKey<ConfiguredFeature<?, ?>> key) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), configuredFeature);
    }


    public static void registerConfiguredFeatures() {
        System.out.println("Registering Mod Configs for" + PracticeMod.MOD_ID);
    }
}
