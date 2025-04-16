package net.mcreator.losthorizon.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.losthorizon.entity.NecromancerBossEntity;

public class NecromancerBossQuandLentiteMeurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof NecromancerBossEntity _datEntSetL)
			_datEntSetL.getEntityData().set(NecromancerBossEntity.DATA_death, true);
	}
}
