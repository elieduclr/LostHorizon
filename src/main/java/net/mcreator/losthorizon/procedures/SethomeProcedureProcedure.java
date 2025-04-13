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
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.losthorizon.network.LosthorizonModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class SethomeProcedureProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			LosthorizonModVariables.PlayerVariables _vars = (commandParameterEntity(arguments, "target")).getData(LosthorizonModVariables.PLAYER_VARIABLES);
			_vars.homeX = commandParameterBlockPos(arguments, "pos").getX();
			_vars.syncPlayerVariables((commandParameterEntity(arguments, "target")));
		}
		{
			LosthorizonModVariables.PlayerVariables _vars = (commandParameterEntity(arguments, "target")).getData(LosthorizonModVariables.PLAYER_VARIABLES);
			_vars.homeZ = commandParameterBlockPos(arguments, "pos").getZ();
			_vars.syncPlayerVariables((commandParameterEntity(arguments, "target")));
		}
		{
			LosthorizonModVariables.PlayerVariables _vars = (commandParameterEntity(arguments, "target")).getData(LosthorizonModVariables.PLAYER_VARIABLES);
			_vars.homeY = commandParameterBlockPos(arguments, "pos").getY();
			_vars.syncPlayerVariables((commandParameterEntity(arguments, "target")));
		}
		if ((commandParameterEntity(arguments, "target")) instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("La base de " + (commandParameterEntity(arguments, "target")).getDisplayName().getString() + " est fix\u00E9e \u00E0 " + commandParameterBlockPos(arguments, "pos").getX() + " "
					+ commandParameterBlockPos(arguments, "pos").getY() + " " + commandParameterBlockPos(arguments, "pos").getZ() + ". Esp\u00E9rons qu\u2019il s\u2019y sente chez lui !")), false);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.activate")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.activate")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY()), (entity.getZ()), 200, 2, 3, 2, 1);
	}

	private static BlockPos commandParameterBlockPos(CommandContext<CommandSourceStack> arguments, String parameter) {
		try {
			return BlockPosArgument.getLoadedBlockPos(arguments, parameter);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return new BlockPos(0, 0, 0);
		}
	}

	private static Entity commandParameterEntity(CommandContext<CommandSourceStack> arguments, String parameter) {
		try {
			return EntityArgument.getEntity(arguments, parameter);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
}
