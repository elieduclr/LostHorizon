package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

public class ShardOfTheVoidEvenementAuClicDroitDansLairProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack, 1200);
		}
		{
			Entity _ent = entity;
			_ent.teleportTo(entity.getX() + entity.getLookAngle().x * 4, entity.getY() + entity.getLookAngle().y + 0 * 4, entity.getZ() + entity.getLookAngle().z * 4);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(entity.getX() + entity.getLookAngle().x * 4, entity.getY() + entity.getLookAngle().y + 0 * 4, entity.getZ() + entity.getLookAngle().z * 4, _ent.getYRot(), _ent.getXRot());
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}
