
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.losthorizon.client.model.Modelnecromancer;
import net.mcreator.losthorizon.client.model.Modelcryptguardian;
import net.mcreator.losthorizon.client.model.Modelblack_blaze;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class LosthorizonModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelcryptguardian.LAYER_LOCATION, Modelcryptguardian::createBodyLayer);
		event.registerLayerDefinition(Modelnecromancer.LAYER_LOCATION, Modelnecromancer::createBodyLayer);
		event.registerLayerDefinition(Modelblack_blaze.LAYER_LOCATION, Modelblack_blaze::createBodyLayer);
	}
}
