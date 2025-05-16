
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.losthorizon.client.particle.LinkDaggerParticleParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LosthorizonModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(LosthorizonModParticleTypes.LINK_DAGGER_PARTICLE.get(), LinkDaggerParticleParticle::provider);
	}
}
