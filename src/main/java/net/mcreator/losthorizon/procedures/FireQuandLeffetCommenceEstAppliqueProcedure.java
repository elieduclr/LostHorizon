package net.mcreator.losthorizon.procedures;

import net.minecraft.world.entity.Entity;

public class FireQuandLeffetCommenceEstAppliqueProcedure {
	public static void execute(Entity entity, double amplifier) {
		if (entity == null)
			return;
		entity.igniteForSeconds((int) (3 * amplifier + 1));
	}
}
