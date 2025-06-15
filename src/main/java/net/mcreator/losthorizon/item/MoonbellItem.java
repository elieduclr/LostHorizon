
package net.mcreator.losthorizon.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.losthorizon.procedures.MoonbellEvenementAuClicDroitDansLairProcedure;

import java.util.List;

public class MoonbellItem extends Item {
	public MoonbellItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).durability(20));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.losthorizon.moonbell.description_0"));
		list.add(Component.translatable("item.losthorizon.moonbell.description_1"));
		list.add(Component.translatable("item.losthorizon.moonbell.description_2"));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		MoonbellEvenementAuClicDroitDansLairProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getItemInHand(hand));
		return ar;
	}
}
