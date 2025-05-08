
package net.mcreator.losthorizon.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.losthorizon.procedures.DestinyDiceEvenementAuClicDroitDansLairProcedure;

import java.util.List;

public class DestinyDiceItem extends Item {
	public DestinyDiceItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).durability(10));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.losthorizon.destiny_dice.description_0"));
		list.add(Component.translatable("item.losthorizon.destiny_dice.description_1"));
		list.add(Component.translatable("item.losthorizon.destiny_dice.description_2"));
		list.add(Component.translatable("item.losthorizon.destiny_dice.description_3"));
		list.add(Component.translatable("item.losthorizon.destiny_dice.description_4"));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		DestinyDiceEvenementAuClicDroitDansLairProcedure.execute(world, entity, entity.getItemInHand(hand));
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		DestinyDiceEvenementAuClicDroitDansLairProcedure.execute(context.getLevel(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
