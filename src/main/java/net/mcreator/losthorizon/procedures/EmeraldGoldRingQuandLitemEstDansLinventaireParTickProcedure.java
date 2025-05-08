package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.losthorizon.network.LosthorizonModVariables;
import net.mcreator.losthorizon.init.LosthorizonModItems;
import net.mcreator.losthorizon.LosthorizonMod;

public class EmeraldGoldRingQuandLitemEstDansLinventaireParTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == LosthorizonModItems.EMERALD_GOLD_RING.get()
				&& entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).emerald_gold_ring_cooldown == false) {
			{
				LosthorizonModVariables.PlayerVariables _vars = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
				_vars.emerald_gold_ring_cooldown = true;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0, false, false));
			LosthorizonMod.queueServerWork(1200, () -> {
				{
					LosthorizonModVariables.PlayerVariables _vars = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
					_vars.emerald_gold_ring_cooldown = false;
					_vars.syncPlayerVariables(entity);
				}
			});
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == LosthorizonModItems.EMERALD_GOLD_RING.get()
				&& world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_forest")))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0, false, false));
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == LosthorizonModItems.EMERALD_GOLD_RING.get() && (entity.level().dimension()) == Level.NETHER) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0, false, false));
		}
	}
}
