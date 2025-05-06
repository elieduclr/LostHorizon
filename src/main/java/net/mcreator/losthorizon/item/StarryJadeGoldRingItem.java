
package net.mcreator.losthorizon.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class StarryJadeGoldRingItem extends Item {
	public StarryJadeGoldRingItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).stacksTo(64));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.losthorizon.starry_jade_gold_ring.description_0"));
		list.add(Component.translatable("item.losthorizon.starry_jade_gold_ring.description_1"));
		list.add(Component.translatable("item.losthorizon.starry_jade_gold_ring.description_2"));
		list.add(Component.translatable("item.losthorizon.starry_jade_gold_ring.description_3"));
	}
}
