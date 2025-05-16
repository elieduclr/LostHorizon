package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.losthorizon.init.LosthorizonModEntities;
import net.mcreator.losthorizon.init.LosthorizonModBlocks;

public class HeartActivatorLorsqueVousCliquezAvecLeBoutonDroitDeLaSourisSurUnBlocProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (LosthorizonModBlocks.HEART_BLOCK.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = LosthorizonModEntities.LINKED.get().spawn(_level, BlockPos.containing(x - 4, y - 1, z - 4), EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = LosthorizonModEntities.LINKED.get().spawn(_level, BlockPos.containing(x + 4, y - 1, z - 4), EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = LosthorizonModEntities.LINKED.get().spawn(_level, BlockPos.containing(x + 4, y - 1, z + 4), EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = LosthorizonModEntities.LINKED.get().spawn(_level, BlockPos.containing(x - 4, y - 1, z + 4), EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			itemstack.shrink(1);
		}
	}
}
