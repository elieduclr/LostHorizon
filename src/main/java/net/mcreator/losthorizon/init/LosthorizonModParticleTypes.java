
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.losthorizon.LosthorizonMod;

public class LosthorizonModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, LosthorizonMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LINK_DAGGER_PARTICLE = REGISTRY.register("link_dagger_particle", () -> new SimpleParticleType(true));
}
