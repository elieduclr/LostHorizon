package net.mcreator.losthorizon.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.losthorizon.init.LosthorizonModMobEffects;

public class BasaltEdgeQuandUneEntiteVivanteEstFrappeeAvecLoutilProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Mth.nextInt(RandomSource.create(), 1, 100) <= 15) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(LosthorizonModMobEffects.FIRE, 60, 1, false, false));
		}
	}
}
