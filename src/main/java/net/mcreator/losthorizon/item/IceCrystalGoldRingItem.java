
package net.mcreator.losthorizon.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.losthorizon.procedures.IceCrystalGoldRingQuandLitemEstDansLinventaireParTickProcedure;

import java.util.List;

public class IceCrystalGoldRingItem extends Item {
	public IceCrystalGoldRingItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).stacksTo(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.losthorizon.ice_crystal_gold_ring.description_0"));
		list.add(Component.translatable("item.losthorizon.ice_crystal_gold_ring.description_1"));
		list.add(Component.translatable("item.losthorizon.ice_crystal_gold_ring.description_2"));
		list.add(Component.translatable("item.losthorizon.ice_crystal_gold_ring.description_3"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		IceCrystalGoldRingQuandLitemEstDansLinventaireParTickProcedure.execute(world, entity);
	}
}
