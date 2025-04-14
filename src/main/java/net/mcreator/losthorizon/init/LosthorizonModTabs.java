
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.losthorizon.LosthorizonMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class LosthorizonModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LosthorizonMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(LosthorizonModItems.SCULK_WITCH_SPAWN_EGG.get());
			tabData.accept(LosthorizonModItems.ANCIENT_GOLEM_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(LosthorizonModItems.FROSBITE_DAGGER.get());
			tabData.accept(LosthorizonModItems.KNIFE.get());
			tabData.accept(LosthorizonModItems.ONYX_KNIFE.get());
			tabData.accept(LosthorizonModItems.LANTERN_SHIELD.get());
			tabData.accept(LosthorizonModItems.RUNITE_SWORD.get());
			tabData.accept(LosthorizonModItems.RUNITE_ARMOR_HELMET.get());
			tabData.accept(LosthorizonModItems.RUNITE_ARMOR_CHESTPLATE.get());
			tabData.accept(LosthorizonModItems.RUNITE_ARMOR_LEGGINGS.get());
			tabData.accept(LosthorizonModItems.RUNITE_ARMOR_BOOTS.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_SWORD.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_ARMOR_HELMET.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_ARMOR_CHESTPLATE.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_ARMOR_LEGGINGS.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_ARMOR_BOOTS.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_ENCHANTED_SWORD.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_ENCHANTED_ARMOR_HELMET.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_ENCHANTED_ARMOR_CHESTPLATE.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_ENCHANTED_ARMOR_LEGGINGS.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_ENCHANTED_ARMOR_BOOTS.get());
			tabData.accept(LosthorizonModItems.BASALT_EDGE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(LosthorizonModItems.ONYX.get());
			tabData.accept(LosthorizonModItems.RUNITE_INGOT.get());
			tabData.accept(LosthorizonModItems.ICE_CRYSTAL.get());
			tabData.accept(LosthorizonModItems.MYTHRIL.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(LosthorizonModBlocks.ONYX_ORE.get().asItem());
			tabData.accept(LosthorizonModBlocks.ONYX_BLOCK.get().asItem());
			tabData.accept(LosthorizonModBlocks.RUNITE_ORE.get().asItem());
			tabData.accept(LosthorizonModBlocks.RUNITE_BLOCK.get().asItem());
			tabData.accept(LosthorizonModBlocks.MYTHRIL_ORE.get().asItem());
			tabData.accept(LosthorizonModBlocks.MYTHRIL_BLOCK.get().asItem());
			tabData.accept(LosthorizonModBlocks.BASALT_OBSIDIAN_ORE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(LosthorizonModItems.TOTEM_OF_THE_MOON.get());
			tabData.accept(LosthorizonModItems.RUNITE_PICKAXE.get());
			tabData.accept(LosthorizonModItems.RUNITE_AXE.get());
			tabData.accept(LosthorizonModItems.RUNITE_SHOVEL.get());
			tabData.accept(LosthorizonModItems.RUNITE_HOE.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_PICKAXE.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_AXE.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_SHOVEL.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_HOE.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_ENCHANTED_PICKAXE.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_ENCHANTED_AXE.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_ENCHANTED_SHOVEL.get());
			tabData.accept(LosthorizonModItems.MYTHRIL_ENCHANTED_HOE.get());
			tabData.accept(LosthorizonModItems.BACK_PACK.get());
			tabData.accept(LosthorizonModItems.BACK_PACK_EXTENDED.get());
			tabData.accept(LosthorizonModItems.CLIMBING_PICK.get());
			tabData.accept(LosthorizonModItems.TECHNOBLADE_TOTEM.get());
			tabData.accept(LosthorizonModItems.ANCHOR_TOTEM.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(LosthorizonModItems.RED_GROUPER_RAW.get());
			tabData.accept(LosthorizonModItems.RED_GROUPER_COOKED.get());
			tabData.accept(LosthorizonModItems.RED_BELLIED_PIRANHA_RAW.get());
			tabData.accept(LosthorizonModItems.RED_BELLIED_PIRANHA_COOKED.get());
			tabData.accept(LosthorizonModItems.ARAPAIMA_RAW.get());
			tabData.accept(LosthorizonModItems.ARAPAIMA_COOKED.get());
		}
	}
}
