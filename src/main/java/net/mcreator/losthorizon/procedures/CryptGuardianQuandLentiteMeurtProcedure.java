package net.mcreator.losthorizon.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.losthorizon.entity.CryptGuardianEntity;

public class CryptGuardianQuandLentiteMeurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof CryptGuardianEntity _datEntSetL)
			_datEntSetL.getEntityData().set(CryptGuardianEntity.DATA_death, true);
	}
}
