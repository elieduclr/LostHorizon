
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.losthorizon.client.gui.RingInfuserGUIScreen;
import net.mcreator.losthorizon.client.gui.BackPackGuiScreen;
import net.mcreator.losthorizon.client.gui.BackPackExtendedGuiScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LosthorizonModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(LosthorizonModMenus.BACK_PACK_GUI.get(), BackPackGuiScreen::new);
		event.register(LosthorizonModMenus.BACK_PACK_EXTENDED_GUI.get(), BackPackExtendedGuiScreen::new);
		event.register(LosthorizonModMenus.RING_INFUSER_GUI.get(), RingInfuserGUIScreen::new);
	}
}
