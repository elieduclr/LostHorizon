package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.losthorizon.network.LosthorizonModVariables;
import net.mcreator.losthorizon.init.LosthorizonModItems;
import net.mcreator.losthorizon.LosthorizonMod;

public class IceCrystalGoldRingQuandLitemEstDansLinventaireParTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).ice_crystal_gold_ring_cooldown == false
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == LosthorizonModItems.ICE_CRYSTAL_GOLD_RING.get()) {
			{
				LosthorizonModVariables.PlayerVariables _vars = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
				_vars.ice_crystal_gold_ring_cooldown = true;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
			LosthorizonMod.queueServerWork(1200, () -> {
				{
					LosthorizonModVariables.PlayerVariables _vars = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
					_vars.ice_crystal_gold_ring_cooldown = false;
					_vars.syncPlayerVariables(entity);
				}
			});
		}
	}
}
