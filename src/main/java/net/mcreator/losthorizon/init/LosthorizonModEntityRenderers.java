
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.losthorizon.client.renderer.SculkWitchRenderer;
import net.mcreator.losthorizon.client.renderer.AncientGolemRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LosthorizonModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(LosthorizonModEntities.SCULK_WITCH.get(), SculkWitchRenderer::new);
		event.registerEntityRenderer(LosthorizonModEntities.THROWING_KNIFE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(LosthorizonModEntities.THROWING_ONYX_KNIFE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(LosthorizonModEntities.ANCIENT_GOLEM.get(), AncientGolemRenderer::new);
	}
}
