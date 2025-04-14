package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class TrapQuandLentiteEntreEnCollisionAvecLeBlocProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Villager == false) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("losthorizon:trap_damage")))), 2);
		}
	}
}
