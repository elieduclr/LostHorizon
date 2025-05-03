
package net.mcreator.losthorizon.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.losthorizon.procedures.LuminousBerriesLeJoueurTermineDutiliserLitemProcedure;

public class LuminousBerriesItem extends Item {
	public LuminousBerriesItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).stacksTo(64).food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.3f).alwaysEdible().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		LuminousBerriesLeJoueurTermineDutiliserLitemProcedure.execute(entity);
		return retval;
	}
}
