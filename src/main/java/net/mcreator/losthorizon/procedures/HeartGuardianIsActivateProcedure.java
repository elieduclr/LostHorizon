package net.mcreator.losthorizon.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.losthorizon.entity.HeartGuardianEntity;

public class HeartGuardianIsActivateProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof HeartGuardianEntity _datEntL0 && _datEntL0.getEntityData().get(HeartGuardianEntity.DATA_activate)) {
			return true;
		}
		return false;
	}
}
