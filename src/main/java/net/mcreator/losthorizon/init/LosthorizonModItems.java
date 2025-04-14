
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.losthorizon.item.inventory.BackPackInventoryCapability;
import net.mcreator.losthorizon.item.inventory.BackPackExtendedInventoryCapability;
import net.mcreator.losthorizon.item.TotemOfTheMoonItem;
import net.mcreator.losthorizon.item.TechnobladeTotemItem;
import net.mcreator.losthorizon.item.RuniteSwordItem;
import net.mcreator.losthorizon.item.RuniteShovelItem;
import net.mcreator.losthorizon.item.RunitePickaxeItem;
import net.mcreator.losthorizon.item.RuniteIngotItem;
import net.mcreator.losthorizon.item.RuniteHoeItem;
import net.mcreator.losthorizon.item.RuniteAxeItem;
import net.mcreator.losthorizon.item.RuniteArmorItem;
import net.mcreator.losthorizon.item.RedGrouperRawItem;
import net.mcreator.losthorizon.item.RedGrouperCookedItem;
import net.mcreator.losthorizon.item.RedBelliedPiranhaRawItem;
import net.mcreator.losthorizon.item.RedBelliedPiranhaCookedItem;
import net.mcreator.losthorizon.item.OnyxKnifeItem;
import net.mcreator.losthorizon.item.OnyxItem;
import net.mcreator.losthorizon.item.MythrilSwordItem;
import net.mcreator.losthorizon.item.MythrilShovelItem;
import net.mcreator.losthorizon.item.MythrilPickaxeItem;
import net.mcreator.losthorizon.item.MythrilItem;
import net.mcreator.losthorizon.item.MythrilHoeItem;
import net.mcreator.losthorizon.item.MythrilEnchantedSwordItem;
import net.mcreator.losthorizon.item.MythrilEnchantedShovelItem;
import net.mcreator.losthorizon.item.MythrilEnchantedPickaxeItem;
import net.mcreator.losthorizon.item.MythrilEnchantedHoeItem;
import net.mcreator.losthorizon.item.MythrilEnchantedAxeItem;
import net.mcreator.losthorizon.item.MythrilEnchantedArmorItem;
import net.mcreator.losthorizon.item.MythrilAxeItem;
import net.mcreator.losthorizon.item.MythrilArmorItem;
import net.mcreator.losthorizon.item.LanternShieldItem;
import net.mcreator.losthorizon.item.KnifeItem;
import net.mcreator.losthorizon.item.IceCrystalItem;
import net.mcreator.losthorizon.item.FrosbiteDaggerItem;
import net.mcreator.losthorizon.item.ClimbingPickItem;
import net.mcreator.losthorizon.item.BasaltEdgeItem;
import net.mcreator.losthorizon.item.BackPackItem;
import net.mcreator.losthorizon.item.BackPackExtendedItem;
import net.mcreator.losthorizon.item.ArapaimaRawItem;
import net.mcreator.losthorizon.item.ArapaimaCookedItem;
import net.mcreator.losthorizon.item.AnchorTotemItem;
import net.mcreator.losthorizon.LosthorizonMod;

import java.util.function.Function;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class LosthorizonModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(LosthorizonMod.MODID);
	public static final DeferredItem<Item> SCULK_WITCH_SPAWN_EGG = register("sculk_witch_spawn_egg", properties -> new SpawnEggItem(LosthorizonModEntities.SCULK_WITCH.get(), properties));
	public static final DeferredItem<Item> FROSBITE_DAGGER = register("frosbite_dagger", FrosbiteDaggerItem::new);
	public static final DeferredItem<Item> KNIFE = register("knife", KnifeItem::new);
	public static final DeferredItem<Item> ONYX = register("onyx", OnyxItem::new);
	public static final DeferredItem<Item> ONYX_ORE = block(LosthorizonModBlocks.ONYX_ORE);
	public static final DeferredItem<Item> ONYX_BLOCK = block(LosthorizonModBlocks.ONYX_BLOCK);
	public static final DeferredItem<Item> ONYX_KNIFE = register("onyx_knife", OnyxKnifeItem::new);
	public static final DeferredItem<Item> TOTEM_OF_THE_MOON = register("totem_of_the_moon", TotemOfTheMoonItem::new);
	public static final DeferredItem<Item> LANTERN_SHIELD = register("lantern_shield", LanternShieldItem::new);
	public static final DeferredItem<Item> RUNITE_INGOT = register("runite_ingot", RuniteIngotItem::new);
	public static final DeferredItem<Item> RUNITE_ORE = block(LosthorizonModBlocks.RUNITE_ORE);
	public static final DeferredItem<Item> RUNITE_BLOCK = block(LosthorizonModBlocks.RUNITE_BLOCK);
	public static final DeferredItem<Item> RUNITE_PICKAXE = register("runite_pickaxe", RunitePickaxeItem::new);
	public static final DeferredItem<Item> RUNITE_AXE = register("runite_axe", RuniteAxeItem::new);
	public static final DeferredItem<Item> RUNITE_SWORD = register("runite_sword", RuniteSwordItem::new);
	public static final DeferredItem<Item> RUNITE_SHOVEL = register("runite_shovel", RuniteShovelItem::new);
	public static final DeferredItem<Item> RUNITE_HOE = register("runite_hoe", RuniteHoeItem::new);
	public static final DeferredItem<Item> RUNITE_ARMOR_HELMET = register("runite_armor_helmet", RuniteArmorItem.Helmet::new);
	public static final DeferredItem<Item> RUNITE_ARMOR_CHESTPLATE = register("runite_armor_chestplate", RuniteArmorItem.Chestplate::new);
	public static final DeferredItem<Item> RUNITE_ARMOR_LEGGINGS = register("runite_armor_leggings", RuniteArmorItem.Leggings::new);
	public static final DeferredItem<Item> RUNITE_ARMOR_BOOTS = register("runite_armor_boots", RuniteArmorItem.Boots::new);
	public static final DeferredItem<Item> ICE_CRYSTAL = register("ice_crystal", IceCrystalItem::new);
	public static final DeferredItem<Item> MYTHRIL = register("mythril", MythrilItem::new);
	public static final DeferredItem<Item> MYTHRIL_ORE = block(LosthorizonModBlocks.MYTHRIL_ORE);
	public static final DeferredItem<Item> MYTHRIL_BLOCK = block(LosthorizonModBlocks.MYTHRIL_BLOCK);
	public static final DeferredItem<Item> MYTHRIL_PICKAXE = register("mythril_pickaxe", MythrilPickaxeItem::new);
	public static final DeferredItem<Item> MYTHRIL_AXE = register("mythril_axe", MythrilAxeItem::new);
	public static final DeferredItem<Item> MYTHRIL_SWORD = register("mythril_sword", MythrilSwordItem::new);
	public static final DeferredItem<Item> MYTHRIL_SHOVEL = register("mythril_shovel", MythrilShovelItem::new);
	public static final DeferredItem<Item> MYTHRIL_HOE = register("mythril_hoe", MythrilHoeItem::new);
	public static final DeferredItem<Item> MYTHRIL_ARMOR_HELMET = register("mythril_armor_helmet", MythrilArmorItem.Helmet::new);
	public static final DeferredItem<Item> MYTHRIL_ARMOR_CHESTPLATE = register("mythril_armor_chestplate", MythrilArmorItem.Chestplate::new);
	public static final DeferredItem<Item> MYTHRIL_ARMOR_LEGGINGS = register("mythril_armor_leggings", MythrilArmorItem.Leggings::new);
	public static final DeferredItem<Item> MYTHRIL_ARMOR_BOOTS = register("mythril_armor_boots", MythrilArmorItem.Boots::new);
	public static final DeferredItem<Item> MYTHRIL_ENCHANTED_PICKAXE = register("mythril_enchanted_pickaxe", MythrilEnchantedPickaxeItem::new);
	public static final DeferredItem<Item> MYTHRIL_ENCHANTED_AXE = register("mythril_enchanted_axe", MythrilEnchantedAxeItem::new);
	public static final DeferredItem<Item> MYTHRIL_ENCHANTED_SWORD = register("mythril_enchanted_sword", MythrilEnchantedSwordItem::new);
	public static final DeferredItem<Item> MYTHRIL_ENCHANTED_SHOVEL = register("mythril_enchanted_shovel", MythrilEnchantedShovelItem::new);
	public static final DeferredItem<Item> MYTHRIL_ENCHANTED_HOE = register("mythril_enchanted_hoe", MythrilEnchantedHoeItem::new);
	public static final DeferredItem<Item> MYTHRIL_ENCHANTED_ARMOR_HELMET = register("mythril_enchanted_armor_helmet", MythrilEnchantedArmorItem.Helmet::new);
	public static final DeferredItem<Item> MYTHRIL_ENCHANTED_ARMOR_CHESTPLATE = register("mythril_enchanted_armor_chestplate", MythrilEnchantedArmorItem.Chestplate::new);
	public static final DeferredItem<Item> MYTHRIL_ENCHANTED_ARMOR_LEGGINGS = register("mythril_enchanted_armor_leggings", MythrilEnchantedArmorItem.Leggings::new);
	public static final DeferredItem<Item> MYTHRIL_ENCHANTED_ARMOR_BOOTS = register("mythril_enchanted_armor_boots", MythrilEnchantedArmorItem.Boots::new);
	public static final DeferredItem<Item> BASALT_OBSIDIAN_ORE = block(LosthorizonModBlocks.BASALT_OBSIDIAN_ORE);
	public static final DeferredItem<Item> BASALT_EDGE = register("basalt_edge", BasaltEdgeItem::new);
	public static final DeferredItem<Item> BACK_PACK = register("back_pack", BackPackItem::new);
	public static final DeferredItem<Item> BACK_PACK_EXTENDED = register("back_pack_extended", BackPackExtendedItem::new);
	public static final DeferredItem<Item> CLIMBING_PICK = register("climbing_pick", ClimbingPickItem::new);
	public static final DeferredItem<Item> RED_GROUPER_RAW = register("red_grouper_raw", RedGrouperRawItem::new);
	public static final DeferredItem<Item> RED_GROUPER_COOKED = register("red_grouper_cooked", RedGrouperCookedItem::new);
	public static final DeferredItem<Item> RED_BELLIED_PIRANHA_RAW = register("red_bellied_piranha_raw", RedBelliedPiranhaRawItem::new);
	public static final DeferredItem<Item> RED_BELLIED_PIRANHA_COOKED = register("red_bellied_piranha_cooked", RedBelliedPiranhaCookedItem::new);
	public static final DeferredItem<Item> ARAPAIMA_RAW = register("arapaima_raw", ArapaimaRawItem::new);
	public static final DeferredItem<Item> ARAPAIMA_COOKED = register("arapaima_cooked", ArapaimaCookedItem::new);
	public static final DeferredItem<Item> ANCIENT_GOLEM_SPAWN_EGG = register("ancient_golem_spawn_egg", properties -> new SpawnEggItem(LosthorizonModEntities.ANCIENT_GOLEM.get(), properties));
	public static final DeferredItem<Item> TECHNOBLADE_TOTEM = register("technoblade_totem", TechnobladeTotemItem::new);
	public static final DeferredItem<Item> ANCHOR_TOTEM = register("anchor_totem", AnchorTotemItem::new);
	public static final DeferredItem<Item> TRAP = block(LosthorizonModBlocks.TRAP);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.registerItem(block.getId().getPath(), properties -> new BlockItem(block.get(), properties), new Item.Properties());
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new BackPackInventoryCapability(stack), BACK_PACK.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new BackPackExtendedInventoryCapability(stack), BACK_PACK_EXTENDED.get());
	}
}
