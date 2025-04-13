
package net.mcreator.losthorizon.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class TechnobladeTotemItem extends Item {
	public TechnobladeTotemItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).durability(1).fireResistant());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.losthorizon.technoblade_totem.description_0"));
		list.add(Component.translatable("item.losthorizon.technoblade_totem.description_1"));
		list.add(Component.translatable("item.losthorizon.technoblade_totem.description_2"));
	}
}
