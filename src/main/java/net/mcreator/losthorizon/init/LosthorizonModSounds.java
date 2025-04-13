
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
}
