
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

import net.mcreator.losthorizon.procedures.AetherHeartQuandLitemEstDansLinventaireParTickProcedure;

import java.util.List;

public class AetherHeartItem extends Item {
	public AetherHeartItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).durability(5));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.losthorizon.aether_heart.description_0"));
		list.add(Component.translatable("item.losthorizon.aether_heart.description_1"));
		list.add(Component.translatable("item.losthorizon.aether_heart.description_2"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		AetherHeartQuandLitemEstDansLinventaireParTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
