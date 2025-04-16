
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class LosthorizonModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == LosthorizonModVillagerProfessions.NECROMANCER_WORK.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.SHIELD), new ItemStack(Items.TORCH, 2), new ItemStack(LosthorizonModItems.LANTERN_SHIELD.get()), 4, 7, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(LosthorizonModItems.ONYX.get(), 8), new ItemStack(LosthorizonModItems.ONYX_KNIFE.get(), 3), 8, 5, 0.08f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(LosthorizonModItems.RUNITE_INGOT.get(), 2), new ItemStack(Items.EMERALD, 6), 10, 7, 0.07f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(LosthorizonModItems.RUNITE_INGOT.get(), 4), new ItemStack(LosthorizonModItems.RUNITE_SWORD.get()), 4, 8, 0.06f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(LosthorizonModItems.ICE_CRYSTAL.get(), 3), new ItemStack(Items.TOTEM_OF_UNDYING), new ItemStack(LosthorizonModItems.TOTEM_OF_THE_MOON.get()), 2, 10, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(LosthorizonModItems.MYTHRIL.get(), 2), new ItemStack(Items.TOTEM_OF_UNDYING), new ItemStack(LosthorizonModItems.ANCHOR_TOTEM.get()), 2, 10, 0.05f));
			event.getTrades().get(5)
					.add(new BasicItemListing(new ItemStack(LosthorizonModItems.TOTEM_OF_THE_MOON.get()), new ItemStack(LosthorizonModItems.RUNITE_INGOT.get(), 2), new ItemStack(LosthorizonModItems.TECHNOBLADE_TOTEM.get()), 2, 10, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(LosthorizonModBlocks.BASALT_OBSIDIAN_ORE.get(), 5), new ItemStack(LosthorizonModItems.BASALT_EDGE.get()), 2, 15, 0.05f));
		}
		if (event.getType() == LosthorizonModVillagerProfessions.HUNTER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.ARROW, 16), new ItemStack(Items.EMERALD, 2), 15, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(Items.SPECTRAL_ARROW, 5), 15, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.LEATHER, 6), new ItemStack(Items.EMERALD), 10, 6, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(LosthorizonModBlocks.TRAP.get()), 8, 7, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), new ItemStack(LosthorizonModItems.CLIMBING_PICK.get()), 8, 7, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(LosthorizonModItems.TOTEM_OF_THE_MOON.get()), 6, 10, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), new ItemStack(Items.IRON_INGOT, 2), new ItemStack(LosthorizonModItems.KNIFE.get()), 6, 10, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(LosthorizonModItems.FROSTBITE_DAGGER.get()), 2, 15, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(LosthorizonModItems.ANCHOR_TOTEM.get()), 2, 15, 0.05f));
		}
	}
}
