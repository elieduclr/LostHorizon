package net.mcreator.losthorizon.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.losthorizon.entity.NecromancerBossEntity;

public class NecromancerBossPlayback3ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof NecromancerBossEntity _datEntL0 && _datEntL0.getEntityData().get(NecromancerBossEntity.DATA_attack);
	}
}
