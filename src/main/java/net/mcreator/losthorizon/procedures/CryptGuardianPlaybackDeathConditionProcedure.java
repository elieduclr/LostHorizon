package net.mcreator.losthorizon.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.losthorizon.entity.CryptGuardianEntity;

public class CryptGuardianPlaybackDeathConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof CryptGuardianEntity _datEntL0 && _datEntL0.getEntityData().get(CryptGuardianEntity.DATA_death);
	}
}
