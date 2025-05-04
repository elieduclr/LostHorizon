
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.losthorizon.LosthorizonMod;

public class LosthorizonModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, LosthorizonMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> TECHNOBLADE_MOVIE_TRIBUTE = REGISTRY.register("technoblade_movie_tribute",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("losthorizon", "technoblade_movie_tribute")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TECHNOBLADE_NEVER_DIES = REGISTRY.register("technoblade_never_dies",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("losthorizon", "technoblade_never_dies")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FAIRY_HUMEUR = REGISTRY.register("fairy_humeur", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("losthorizon", "fairy_humeur")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FAIRY_AMBIENT = REGISTRY.register("fairy_ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("losthorizon", "fairy_ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FAIRY_BIRDS = REGISTRY.register("fairy_birds", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("losthorizon", "fairy_birds")));
	public static final DeferredHolder<SoundEvent, SoundEvent> RING_INFUSER = REGISTRY.register("ring_infuser", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("losthorizon", "ring_infuser")));
}
