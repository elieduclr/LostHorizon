package net.mcreator.losthorizon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.losthorizon.network.LosthorizonModVariables;
import net.mcreator.losthorizon.init.LosthorizonModItems;

public class ClimbingPickQuandLoutilEstDansLinventaireParTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (LosthorizonModItems.CLIMBING_PICK.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (world.getBlockState(BlockPos.containing(entity.getX() + 0.5, entity.getY(), entity.getZ())).canOcclude() || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 0.5)).canOcclude()
					|| world.getBlockState(BlockPos.containing(entity.getX() - 0.5, entity.getY(), entity.getZ())).canOcclude() || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 0.5)).canOcclude()) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getXRot() * (-0.005)), (entity.getDeltaMovement().z())));
				entity.fallDistance = 0;
				if (itemstack.getMaxDamage() >= itemstack.getDamageValue()) {
					if (world instanceof ServerLevel _level) {
						itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
					if (itemstack.getDamageValue() == itemstack.getMaxDamage() - 1 || itemstack.getDamageValue() == itemstack.getMaxDamage()) {
						{
							LosthorizonModVariables.PlayerVariables _vars = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
							_vars.PreventClimbingFallDamage = true;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
			}
		}
	}
}
