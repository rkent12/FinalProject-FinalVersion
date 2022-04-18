package net.ryankent.practicemod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.ryankent.practicemod.block.ModBlocks;
import net.ryankent.practicemod.block.custom.BoxBlockEntity;
import net.ryankent.practicemod.block.custom.UIBlock;
import net.ryankent.practicemod.item.ModItems;
import net.ryankent.practicemod.enchantments.ModEnchantments;
import net.ryankent.practicemod.registries.ModRegistries;
import net.ryankent.practicemod.screenhandler.screen.BoxScreenHandler;
import net.ryankent.practicemod.util.ModRendererHelper;
import net.ryankent.practicemod.world.dimension.ModPortals;
import net.ryankent.practicemod.world.features.ModConfiguredFeatures;
import net.ryankent.practicemod.world.gen.ModWorldGen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PracticeMod implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("modid");
	public static final String mod_id = "practicemod";

	public static final Block UI_BLOCK;
	public static final BlockItem UI_BLOCK_ITEM;
	public static final BlockEntityType<BoxBlockEntity> BOX_BLOCK_ENTITY;
	public static final ScreenHandlerType<BoxScreenHandler> BOX_SCREEN_HANDLER;

	public static final String MOD_ID = "practicemod";
	public static final Identifier BOX = new Identifier(MOD_ID, "box_block");

	static {
		UI_BLOCK = Registry.register(Registry.BLOCK, BOX, new UIBlock(FabricBlockSettings.copyOf(Blocks.CHEST)));
		UI_BLOCK_ITEM = Registry.register(Registry.ITEM, BOX, new BlockItem(UI_BLOCK, new Item.Settings().group(ItemGroup.MISC)));

		//The parameter of build at the very end is always null, do not worry about it
		// pre-1.17
		//BOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, BOX, BlockEntityType.Builder.create(BoxBlockEntity::new, BOX_BLOCK).build(null));
		// In 1.17 use FabricBlockEntityTypeBuilder instead of BlockEntityType.Builder
		BOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, BOX, FabricBlockEntityTypeBuilder.create(BoxBlockEntity::new, UI_BLOCK).build(null));

		BOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(BOX, BoxScreenHandler::new);

		ModEnchantments.registerModEnchantments();
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModConfiguredFeatures.registerConfiguredFeatures();

		ModRendererHelper.setRenderLayers();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModFuels();
		ModRegistries.registerStrippables();

		ModWorldGen.generateModWorldGen();

		ModPortals.registerPortals();

		System.out.println("Hello Fabric world!");
	}
}
