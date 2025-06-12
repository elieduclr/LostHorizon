package net.mcreator.losthorizon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.losthorizon.LosthorizonMod;

public class ShardOfTheVoidEvenementAuClicDroitDansLairProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("VoidShard") == false) {
			{
				final String _tagName = "VoidShard";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				Entity _ent = entity;
				_ent.teleportTo(entity.getX() + entity.getLookAngle().x * 4, entity.getY() + entity.getLookAngle().y + 0 * 4, entity.getZ() + entity.getLookAngle().z * 4);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(entity.getX() + entity.getLookAngle().x * 4, entity.getY() + entity.getLookAngle().y + 0 * 4, entity.getZ() + entity.getLookAngle().z * 4, _ent.getYRot(), _ent.getXRot());
			}
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			LosthorizonMod.queueServerWork(1200, () -> {
				{
					final String _tagName = "VoidShard";
					final boolean _tagValue = false;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
				}
			});
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Attendez"), false);
		}
	}
}
