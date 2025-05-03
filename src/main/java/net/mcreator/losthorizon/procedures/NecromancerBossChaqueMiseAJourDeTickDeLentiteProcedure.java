package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.losthorizon.entity.NecromancerBossEntity;

public class NecromancerBossChaqueMiseAJourDeTickDeLentiteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Chain = 0;
		double ChainWait = 0;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			entity.getPersistentData().putDouble("IA", (entity.getPersistentData().getDouble("IA") + 1));
			if (entity instanceof NecromancerBossEntity _datEntSetL)
				_datEntSetL.getEntityData().set(NecromancerBossEntity.DATA_idle, false);
			if (entity instanceof NecromancerBossEntity _datEntSetL)
				_datEntSetL.getEntityData().set(NecromancerBossEntity.DATA_attack, false);
		} else {
			if (entity instanceof NecromancerBossEntity _datEntSetL)
				_datEntSetL.getEntityData().set(NecromancerBossEntity.DATA_attack, false);
			if (entity instanceof NecromancerBossEntity _datEntSetL)
				_datEntSetL.getEntityData().set(NecromancerBossEntity.DATA_idle, true);
			entity.getPersistentData().putDouble("IA", 0);
			entity.getPersistentData().putString("State", "Idle");
		}
		if ((entity.getPersistentData().getString("State")).equals("Idle")) {
			if (entity.getPersistentData().getDouble("IA") == 20) {
				NecromancerRandomProcedure.execute(world, x, y, z, entity);
			}
		}
		if ((entity.getPersistentData().getString("State")).equals("Melee")) {
			NecromancerMeleeProcedure.execute(world, x, y, z, entity);
		}
		if ((entity.getPersistentData().getString("State")).equals("Fireball")) {
			NecromancerFireballProcedure.execute(world, entity);
		}
		if ((entity.getPersistentData().getString("State")).equals("Summon")) {
			NecromancerSummonProcedure.execute(world, x, y, z, entity);
		}
		if ((entity.getPersistentData().getString("State")).equals("Regen")) {
			NecromancerRegenProcedure.execute(entity);
		}
		if (entity.getPersistentData().getDouble("IA") == 200) {
			entity.getPersistentData().putDouble("IA", 0);
			NecromancerRandomProcedure.execute(world, x, y, z, entity);
		}
	}
}
