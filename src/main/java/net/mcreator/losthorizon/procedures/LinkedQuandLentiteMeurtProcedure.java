package net.mcreator.losthorizon.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.losthorizon.network.LosthorizonModVariables;
import net.mcreator.losthorizon.init.LosthorizonModItems;

public class LinkedQuandLentiteMeurtProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LosthorizonModItems.LINK_DAGGER.get()) {
			{
				LosthorizonModVariables.PlayerVariables _vars = sourceentity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
				_vars.linked_soul = sourceentity.getData(LosthorizonModVariables.PLAYER_VARIABLES).linked_soul + 1;
				_vars.syncPlayerVariables(sourceentity);
			}
		}
	}
}
