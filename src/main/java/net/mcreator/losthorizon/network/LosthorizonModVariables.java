package net.mcreator.losthorizon.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.losthorizon.LosthorizonMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class LosthorizonModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, LosthorizonMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		LosthorizonMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.homeX = original.homeX;
			clone.homeZ = original.homeZ;
			clone.homeY = original.homeY;
			if (!event.isWasDeath()) {
				clone.PreventClimbingFallDamage = original.PreventClimbingFallDamage;
				clone.nbrjump = original.nbrjump;
				clone.necromancer_grimoire = original.necromancer_grimoire;
				clone.ice_crystal_silver_ring_cooldown = original.ice_crystal_silver_ring_cooldown;
				clone.ice_crystal_gold_ring_cooldown = original.ice_crystal_gold_ring_cooldown;
				clone.onyx_gold_ring_cooldown = original.onyx_gold_ring_cooldown;
				clone.emerald_gold_ring_cooldown = original.emerald_gold_ring_cooldown;
				clone.starry_jade_iron_rinh_cooldown = original.starry_jade_iron_rinh_cooldown;
				clone.dice_cooldown = original.dice_cooldown;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public boolean PreventClimbingFallDamage = false;
		public double homeX = 0;
		public double homeZ = 0;
		public double homeY = 0;
		public double nbrjump = 0;
		public boolean necromancer_grimoire = false;
		public boolean ice_crystal_silver_ring_cooldown = false;
		public boolean ice_crystal_gold_ring_cooldown = false;
		public boolean onyx_gold_ring_cooldown = false;
		public boolean emerald_gold_ring_cooldown = false;
		public boolean starry_jade_iron_rinh_cooldown = false;
		public boolean dice_cooldown = false;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("PreventClimbingFallDamage", PreventClimbingFallDamage);
			nbt.putDouble("homeX", homeX);
			nbt.putDouble("homeZ", homeZ);
			nbt.putDouble("homeY", homeY);
			nbt.putDouble("nbrjump", nbrjump);
			nbt.putBoolean("necromancer_grimoire", necromancer_grimoire);
			nbt.putBoolean("ice_crystal_silver_ring_cooldown", ice_crystal_silver_ring_cooldown);
			nbt.putBoolean("ice_crystal_gold_ring_cooldown", ice_crystal_gold_ring_cooldown);
			nbt.putBoolean("onyx_gold_ring_cooldown", onyx_gold_ring_cooldown);
			nbt.putBoolean("emerald_gold_ring_cooldown", emerald_gold_ring_cooldown);
			nbt.putBoolean("starry_jade_iron_rinh_cooldown", starry_jade_iron_rinh_cooldown);
			nbt.putBoolean("dice_cooldown", dice_cooldown);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			PreventClimbingFallDamage = nbt.getBoolean("PreventClimbingFallDamage");
			homeX = nbt.getDouble("homeX");
			homeZ = nbt.getDouble("homeZ");
			homeY = nbt.getDouble("homeY");
			nbrjump = nbt.getDouble("nbrjump");
			necromancer_grimoire = nbt.getBoolean("necromancer_grimoire");
			ice_crystal_silver_ring_cooldown = nbt.getBoolean("ice_crystal_silver_ring_cooldown");
			ice_crystal_gold_ring_cooldown = nbt.getBoolean("ice_crystal_gold_ring_cooldown");
			onyx_gold_ring_cooldown = nbt.getBoolean("onyx_gold_ring_cooldown");
			emerald_gold_ring_cooldown = nbt.getBoolean("emerald_gold_ring_cooldown");
			starry_jade_iron_rinh_cooldown = nbt.getBoolean("starry_jade_iron_rinh_cooldown");
			dice_cooldown = nbt.getBoolean("dice_cooldown");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(LosthorizonMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
