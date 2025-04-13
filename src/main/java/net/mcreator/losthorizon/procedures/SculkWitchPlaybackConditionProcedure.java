package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;

public class SculkWitchPlaybackConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		boolean login = false;
		if (world.getLevelData().isRaining()) {
			login = true;
		} else {
			login = false;
		}
		return login;
	}
}
