package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.losthorizon.network.LosthorizonModVariables;

public class HomeShortProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo(entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeX, entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeY, entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeZ);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeX, entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeY, entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeZ,
						_ent.getYRot(), _ent.getXRot());
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\uD83C\uDF00 Le tissu de la r\u00E9alit\u00E9 se tord... Votre \u00EAtre se fragmente un instant."), false);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null,
						BlockPos.containing(entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeX, entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeY, entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeZ),
						BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.ender_dragon.growl")), SoundSource.HOSTILE, 1, 1);
			} else {
				_level.playLocalSound(entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeX, entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeY, entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeZ,
						BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.ender_dragon.growl")), SoundSource.HOSTILE, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeX, entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeY,
					entity.getData(LosthorizonModVariables.PLAYER_VARIABLES).homeZ, 200, 2, 3, 2, 1);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 160, 1, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 320, 1, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 240, 1, false, false));
	}
}
