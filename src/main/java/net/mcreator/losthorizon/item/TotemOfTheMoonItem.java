
package net.mcreator.losthorizon.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.mcreator.losthorizon.procedures.TotemOfTheMoonEvenementAuClicDroitDansLairProcedure;

public class TotemOfTheMoonItem extends Item {
	public TotemOfTheMoonItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).durability(3));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		TotemOfTheMoonEvenementAuClicDroitDansLairProcedure.execute(world, entity, entity.getItemInHand(hand));
		return ar;
	}
}
