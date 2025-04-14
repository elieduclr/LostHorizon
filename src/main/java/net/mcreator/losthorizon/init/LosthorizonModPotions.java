
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.losthorizon.LosthorizonMod;

public class LosthorizonModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, LosthorizonMod.MODID);
	public static final DeferredHolder<Potion, Potion> FURTIVITY_POTION = REGISTRY.register("furtivity_potion", () -> new Potion("furtivity_potion", new MobEffectInstance(LosthorizonModMobEffects.FURTIVITY, 3600, 0, false, true)));
}
