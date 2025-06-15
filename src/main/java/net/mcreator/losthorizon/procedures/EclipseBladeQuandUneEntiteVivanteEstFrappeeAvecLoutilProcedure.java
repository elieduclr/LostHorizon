package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.losthorizon.init.LosthorizonModParticleTypes;

public class EclipseBladeQuandUneEntiteVivanteEstFrappeeAvecLoutilProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2 <= (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), sourceentity), 2);
		} else {
			if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.WITHER))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0, false, false));
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (LosthorizonModParticleTypes.LINK_DAGGER_PARTICLE.get()), x, y, z, 100, 2, 3, 2, 1);
			}
		}
	}
}
