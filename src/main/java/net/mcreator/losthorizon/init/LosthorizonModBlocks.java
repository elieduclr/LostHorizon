
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.losthorizon.block.RuniteOreBlock;
import net.mcreator.losthorizon.block.RuniteBlockBlock;
import net.mcreator.losthorizon.block.OnyxOreBlock;
import net.mcreator.losthorizon.block.OnyxBlockBlock;
import net.mcreator.losthorizon.block.MythrilOreBlock;
import net.mcreator.losthorizon.block.MythrilBlockBlock;
import net.mcreator.losthorizon.block.BasaltObsidianOreBlock;
import net.mcreator.losthorizon.LosthorizonMod;

import java.util.function.Function;

public class LosthorizonModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(LosthorizonMod.MODID);
	public static final DeferredBlock<Block> ONYX_ORE = register("onyx_ore", OnyxOreBlock::new);
	public static final DeferredBlock<Block> ONYX_BLOCK = register("onyx_block", OnyxBlockBlock::new);
	public static final DeferredBlock<Block> RUNITE_ORE = register("runite_ore", RuniteOreBlock::new);
	public static final DeferredBlock<Block> RUNITE_BLOCK = register("runite_block", RuniteBlockBlock::new);
	public static final DeferredBlock<Block> MYTHRIL_ORE = register("mythril_ore", MythrilOreBlock::new);
	public static final DeferredBlock<Block> MYTHRIL_BLOCK = register("mythril_block", MythrilBlockBlock::new);
	public static final DeferredBlock<Block> BASALT_OBSIDIAN_ORE = register("basalt_obsidian_ore", BasaltObsidianOreBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier, BlockBehaviour.Properties.of());
	}
}
