package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.losthorizon.network.LosthorizonModVariables;

public class SethomeShortProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			LosthorizonModVariables.PlayerVariables _vars = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
			_vars.homeX = Math.round(entity.getX());
			_vars.syncPlayerVariables(entity);
		}
		{
			LosthorizonModVariables.PlayerVariables _vars = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
			_vars.homeZ = Math.round(entity.getZ());
			_vars.syncPlayerVariables(entity);
		}
		{
			LosthorizonModVariables.PlayerVariables _vars = entity.getData(LosthorizonModVariables.PLAYER_VARIABLES);
			_vars.homeY = Math.round(entity.getY());
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("La base de " + entity.getDisplayName().getString() + " est fix\u00E9e \u00E0 " + Math.round(entity.getX()) + " " + Math.round(entity.getY()) + " " + Math.round(entity.getZ())
					+ ". Esp\u00E9rons qu\u2019il s\u2019y sente chez lui !")), false);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(Math.round(entity.getX()), Math.round(entity.getY()), Math.round(entity.getZ())), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.activate")), SoundSource.BLOCKS,
						1, 1);
			} else {
				_level.playLocalSound(Math.round(entity.getX()), Math.round(entity.getY()), Math.round(entity.getZ()), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.activate")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, Math.round(entity.getX()), Math.round(entity.getY()), Math.round(entity.getZ()), 200, 2, 3, 2, 1);
	}
}
