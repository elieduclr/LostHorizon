
package net.mcreator.losthorizon.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.losthorizon.procedures.SolarFeatherQuandLitemEstDansLinventaireParTickProcedure;
import net.mcreator.losthorizon.procedures.SolarFeatherEvenementAuClicDroitDansLairProcedure;

import java.util.List;

public class SolarFeatherItem extends Item {
	public SolarFeatherItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).durability(10));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.losthorizon.solar_feather.description_0"));
		list.add(Component.translatable("item.losthorizon.solar_feather.description_1"));
		list.add(Component.translatable("item.losthorizon.solar_feather.description_2"));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		SolarFeatherEvenementAuClicDroitDansLairProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getItemInHand(hand));
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		SolarFeatherQuandLitemEstDansLinventaireParTickProcedure.execute(world, entity, itemstack);
	}
}
