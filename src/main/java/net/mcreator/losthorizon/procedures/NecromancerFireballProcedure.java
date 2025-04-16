package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.mcreator.losthorizon.entity.NecromancerBossEntity;
import net.mcreator.losthorizon.LosthorizonMod;

public class NecromancerFireballProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double Chain = 0;
		double ChainWait = 0;
		if (entity.getPersistentData().getDouble("IA") == 20) {
			Chain = 5;
			for (int index0 = 0; index0 < (int) Chain; index0++) {
				LosthorizonMod.queueServerWork((int) ChainWait, () -> {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new SmallFireball(EntityType.SMALL_FIREBALL, projectileLevel);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 5);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (entity instanceof NecromancerBossEntity _datEntSetL)
						_datEntSetL.getEntityData().set(NecromancerBossEntity.DATA_attack, true);
				});
				if (entity instanceof NecromancerBossEntity _datEntSetL)
					_datEntSetL.getEntityData().set(NecromancerBossEntity.DATA_attack, false);
				ChainWait = ChainWait + 3;
			}
		}
		if (entity.getPersistentData().getDouble("IA") == 40) {
			Chain = 7;
			for (int index1 = 0; index1 < (int) Chain; index1++) {
				LosthorizonMod.queueServerWork((int) ChainWait, () -> {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new SmallFireball(EntityType.SMALL_FIREBALL, projectileLevel);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 5);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (entity instanceof NecromancerBossEntity _datEntSetL)
						_datEntSetL.getEntityData().set(NecromancerBossEntity.DATA_attack, true);
				});
				if (entity instanceof NecromancerBossEntity _datEntSetL)
					_datEntSetL.getEntityData().set(NecromancerBossEntity.DATA_attack, false);
				ChainWait = ChainWait + 5;
			}
		}
	}
}
