
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.losthorizon.block.TrapBlock;
import net.mcreator.losthorizon.block.StarryJadeOreBlock;
import net.mcreator.losthorizon.block.StarryJadeBlockBlock;
import net.mcreator.losthorizon.block.RuniteOreBlock;
import net.mcreator.losthorizon.block.RuniteBlockBlock;
import net.mcreator.losthorizon.block.RingInfuserBlock;
import net.mcreator.losthorizon.block.OnyxOreBlock;
import net.mcreator.losthorizon.block.OnyxBlockBlock;
import net.mcreator.losthorizon.block.NecromancerGrimoireBlocBlock;
import net.mcreator.losthorizon.block.MythrilOreBlock;
import net.mcreator.losthorizon.block.MythrilBlockBlock;
import net.mcreator.losthorizon.block.MagicWoodBlock;
import net.mcreator.losthorizon.block.MagicStairsBlock;
import net.mcreator.losthorizon.block.MagicSlabBlock;
import net.mcreator.losthorizon.block.MagicPressurePlateBlock;
import net.mcreator.losthorizon.block.MagicPlanksBlock;
import net.mcreator.losthorizon.block.MagicLogBlock;
import net.mcreator.losthorizon.block.MagicLeavesBlock;
import net.mcreator.losthorizon.block.MagicFenceGateBlock;
import net.mcreator.losthorizon.block.MagicFenceBlock;
import net.mcreator.losthorizon.block.MagicButtonBlock;
import net.mcreator.losthorizon.block.HeartBlockBlock;
import net.mcreator.losthorizon.block.EnchantedBlossomBlock;
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
	public static final DeferredBlock<Block> TRAP = register("trap", TrapBlock::new);
	public static final DeferredBlock<Block> NECROMANCER_GRIMOIRE_BLOCK = register("necromancer_grimoire_block", NecromancerGrimoireBlocBlock::new);
	public static final DeferredBlock<Block> MAGIC_WOOD = register("magic_wood", MagicWoodBlock::new);
	public static final DeferredBlock<Block> MAGIC_LOG = register("magic_log", MagicLogBlock::new);
	public static final DeferredBlock<Block> MAGIC_PLANKS = register("magic_planks", MagicPlanksBlock::new);
	public static final DeferredBlock<Block> MAGIC_LEAVES = register("magic_leaves", MagicLeavesBlock::new);
	public static final DeferredBlock<Block> MAGIC_STAIRS = register("magic_stairs", MagicStairsBlock::new);
	public static final DeferredBlock<Block> MAGIC_SLAB = register("magic_slab", MagicSlabBlock::new);
	public static final DeferredBlock<Block> MAGIC_FENCE = register("magic_fence", MagicFenceBlock::new);
	public static final DeferredBlock<Block> MAGIC_FENCE_GATE = register("magic_fence_gate", MagicFenceGateBlock::new);
	public static final DeferredBlock<Block> MAGIC_PRESSURE_PLATE = register("magic_pressure_plate", MagicPressurePlateBlock::new);
	public static final DeferredBlock<Block> MAGIC_BUTTON = register("magic_button", MagicButtonBlock::new);
	public static final DeferredBlock<Block> ENCHANTED_BLOSSOM = register("enchanted_blossom", EnchantedBlossomBlock::new);
	public static final DeferredBlock<Block> RING_INFUSER = register("ring_infuser", RingInfuserBlock::new);
	public static final DeferredBlock<Block> STARRY_JADE_ORE = register("starry_jade_ore", StarryJadeOreBlock::new);
	public static final DeferredBlock<Block> STARRY_JADE_BLOCK = register("starry_jade_block", StarryJadeBlockBlock::new);
	public static final DeferredBlock<Block> HEART_BLOCK = register("heart_block", HeartBlockBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier, BlockBehaviour.Properties.of());
	}
}
