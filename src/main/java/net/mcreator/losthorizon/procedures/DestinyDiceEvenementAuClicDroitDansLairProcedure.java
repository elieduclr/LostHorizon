package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.losthorizon.network.LosthorizonModVariables;
import net.mcreator.losthorizon.LosthorizonMod;

public class DestinyDiceEvenementAuClicDroitDansLairProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double choice = 0;
		if (entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).dice_cooldown == false) {
			{
				LosthorizonModVariables.PlayerVariables _vars = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
				_vars.dice_cooldown = true;
				_vars.syncPlayerVariables(entity);
			}
			choice = Mth.nextInt(RandomSource.create(), 1, 6);
			if (choice == 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));
			} else if (choice == 2) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 0, false, false));
			} else if (choice == 3) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0, false, false));
			} else if (choice == 4) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0, false, false));
			} else if (choice == 5) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, false));
			} else if (choice == 6) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 200, 0, false, false));
			}
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			LosthorizonMod.queueServerWork(1200, () -> {
				{
					LosthorizonModVariables.PlayerVariables _vars = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
					_vars.dice_cooldown = false;
					_vars.syncPlayerVariables(entity);
				}
			});
		}
	}
}
