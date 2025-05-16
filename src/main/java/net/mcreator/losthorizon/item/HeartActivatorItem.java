
package net.mcreator.losthorizon.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import net.mcreator.losthorizon.procedures.HeartActivatorLorsqueVousCliquezAvecLeBoutonDroitDeLaSourisSurUnBlocProcedure;

import java.util.List;

public class HeartActivatorItem extends Item {
	public HeartActivatorItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).durability(10));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.losthorizon.heart_activator.description_0"));
		list.add(Component.translatable("item.losthorizon.heart_activator.description_1"));
		list.add(Component.translatable("item.losthorizon.heart_activator.description_2"));
		list.add(Component.translatable("item.losthorizon.heart_activator.description_3"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		HeartActivatorLorsqueVousCliquezAvecLeBoutonDroitDeLaSourisSurUnBlocProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
