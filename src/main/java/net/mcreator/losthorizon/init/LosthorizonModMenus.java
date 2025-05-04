
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.losthorizon.world.inventory.RingInfuserGUIMenu;
import net.mcreator.losthorizon.world.inventory.BackPackGuiMenu;
import net.mcreator.losthorizon.world.inventory.BackPackExtendedGuiMenu;
import net.mcreator.losthorizon.LosthorizonMod;

public class LosthorizonModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, LosthorizonMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<BackPackGuiMenu>> BACK_PACK_GUI = REGISTRY.register("back_pack_gui", () -> IMenuTypeExtension.create(BackPackGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BackPackExtendedGuiMenu>> BACK_PACK_EXTENDED_GUI = REGISTRY.register("back_pack_extended_gui", () -> IMenuTypeExtension.create(BackPackExtendedGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RingInfuserGUIMenu>> RING_INFUSER_GUI = REGISTRY.register("ring_infuser_gui", () -> IMenuTypeExtension.create(RingInfuserGUIMenu::new));
}
