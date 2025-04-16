package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.losthorizon.entity.CryptGuardianEntity;

public class CryptGuardianChaqueMiseAJourDeTickDeLentiteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			entity.getPersistentData().putDouble("IA", (entity.getPersistentData().getDouble("IA") + 1));
			if (entity instanceof CryptGuardianEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CryptGuardianEntity.DATA_idle, false);
		} else {
			if (entity instanceof CryptGuardianEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CryptGuardianEntity.DATA_idle, true);
			if (entity instanceof CryptGuardianEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CryptGuardianEntity.DATA_attack, false);
			entity.getPersistentData().putDouble("IA", 0);
			entity.getPersistentData().putString("State", "Idle");
		}
		if ((entity.getPersistentData().getString("State")).equals("Idle")) {
			if (entity.getPersistentData().getDouble("IA") == 20) {
				CryptGuardianRandomProcedure.execute(world, x, y, z, entity);
			}
		}
		if ((entity.getPersistentData().getString("State")).equals("Melee")) {
			CryptGuardianMeleeProcedure.execute(world, x, y, z, entity);
		}
		if ((entity.getPersistentData().getString("State")).equals("Potion")) {
			CryptGuardianPotionProcedure.execute(entity);
		}
		if ((entity.getPersistentData().getString("State")).equals("Regen")) {
			CryptGuardianRegenProcedure.execute(entity);
		}
		if (entity.getPersistentData().getDouble("IA") == 200) {
			entity.getPersistentData().putDouble("IA", 0);
			CryptGuardianRandomProcedure.execute(world, x, y, z, entity);
		}
	}
}
