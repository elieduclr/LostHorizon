package net.mcreator.losthorizon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.losthorizon.network.LosthorizonModVariables;

public class DimensionalStepProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("losthorizon:dimensional_step")))) != 0
				&& entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).nbrjump < 1 * (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("losthorizon:dimensional_step"))))) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()),
					(0.4 + 0.1 * (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("losthorizon:dimensional_step"))))),
					(entity.getDeltaMovement().z())));
			{
				LosthorizonModVariables.PlayerVariables _vars = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
				_vars.nbrjump = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).nbrjump + 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				LosthorizonModVariables.PlayerVariables _vars = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
				_vars.PreventClimbingFallDamage = true;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.onGround()) {
			{
				LosthorizonModVariables.PlayerVariables _vars = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
				_vars.nbrjump = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
