package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class NecromancerRandomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double StateSelector = 0;
		entity.getPersistentData().putString("PreviousPreviousState", (entity.getPersistentData().getString("PreviousState")));
		entity.getPersistentData().putString("PreviousState", (entity.getPersistentData().getString("State")));
		StateSelector = Mth.nextInt(RandomSource.create(), 0, 3);
		if (StateSelector == 0) {
			entity.getPersistentData().putString("State", "Melee");
		}
		if (StateSelector == 1) {
			entity.getPersistentData().putString("State", "Fireball");
		}
		if (StateSelector == 2) {
			entity.getPersistentData().putString("State", "Summon");
		}
		if (StateSelector == 3) {
			entity.getPersistentData().putString("State", "Regen");
		}
		if ((entity.getPersistentData().getString("PreviousPreviousState")).equals("PreviousState") || (entity.getPersistentData().getString("PreviousState")).equals("State")) {
			NecromancerRandomProcedure.execute(world, x, y, z, entity);
		}
	}
}
