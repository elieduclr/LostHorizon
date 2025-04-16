
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.losthorizon.entity.ThrowingOnyxKnifeEntity;
import net.mcreator.losthorizon.entity.ThrowingKnifeEntity;
import net.mcreator.losthorizon.entity.NecromancerBossEntity;
import net.mcreator.losthorizon.entity.CryptGuardianEntity;
import net.mcreator.losthorizon.LosthorizonMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class LosthorizonModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, LosthorizonMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<ThrowingKnifeEntity>> THROWING_KNIFE = register("throwing_knife",
			EntityType.Builder.<ThrowingKnifeEntity>of(ThrowingKnifeEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrowingOnyxKnifeEntity>> THROWING_ONYX_KNIFE = register("throwing_onyx_knife",
			EntityType.Builder.<ThrowingOnyxKnifeEntity>of(ThrowingOnyxKnifeEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<NecromancerBossEntity>> NECROMANCER = register("necromancer",
			EntityType.Builder.<NecromancerBossEntity>of(NecromancerBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<CryptGuardianEntity>> CRYPT_GUARDIAN = register("crypt_guardian",
			EntityType.Builder.<CryptGuardianEntity>of(CryptGuardianEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(LosthorizonMod.MODID, registryname))));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		NecromancerBossEntity.init(event);
		CryptGuardianEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(NECROMANCER.get(), NecromancerBossEntity.createAttributes().build());
		event.put(CRYPT_GUARDIAN.get(), CryptGuardianEntity.createAttributes().build());
	}
}
