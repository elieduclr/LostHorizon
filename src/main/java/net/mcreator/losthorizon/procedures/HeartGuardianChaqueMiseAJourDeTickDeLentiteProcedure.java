package net.mcreator.losthorizon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.losthorizon.network.LosthorizonModVariables;
import net.mcreator.losthorizon.init.LosthorizonModParticleTypes;
import net.mcreator.losthorizon.entity.HeartGuardianEntity;

import java.util.Comparator;

public class HeartGuardianChaqueMiseAJourDeTickDeLentiteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (false == (entity instanceof HeartGuardianEntity _datEntL0 && _datEntL0.getEntityData().get(HeartGuardianEntity.DATA_awaken))
				&& false == (entity instanceof HeartGuardianEntity _datEntL1 && _datEntL1.getEntityData().get(HeartGuardianEntity.DATA_activate))) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(18 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if ((entityiterator instanceof Player || entityiterator instanceof ServerPlayer) && 4 <= entityiterator.getData(LosthorizonModVariables.PLAYER_VARIABLES).linked_soul) {
						{
							LosthorizonModVariables.PlayerVariables _vars = entityiterator.getData(LosthorizonModVariables.PLAYER_VARIABLES);
							_vars.linked_soul = 0;
							_vars.syncPlayerVariables(entityiterator);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (LosthorizonModParticleTypes.LINK_DAGGER_PARTICLE.get()), x, y, z, 1000, 3, 3, 3, 0.1);
						if (entity instanceof HeartGuardianEntity _datEntSetL)
							_datEntSetL.getEntityData().set(HeartGuardianEntity.DATA_activate, true);
						if (entity instanceof HeartGuardianEntity _datEntSetL)
							_datEntSetL.getEntityData().set(HeartGuardianEntity.DATA_awaken, false);
					}
				}
			}
		}
		if (false == (entity instanceof HeartGuardianEntity _datEntL8 && _datEntL8.getEntityData().get(HeartGuardianEntity.DATA_awaken))
				&& true == (entity instanceof HeartGuardianEntity _datEntL9 && _datEntL9.getEntityData().get(HeartGuardianEntity.DATA_activate))) {
			if (entity instanceof HeartGuardianEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HeartGuardianEntity.DATA_awaken, true);
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(18 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("message.heart_guardian_awake_0").getString())), false);
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("message.heart_guardian_awake_1").getString())), false);
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("message.heart_guardian_awake_2").getString())), false);
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("message.heart_guardian_awake_3").getString())), false);
				}
			}
		}
	}
}
