
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.losthorizon.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.losthorizon.potion.FurtivityMobEffect;
import net.mcreator.losthorizon.potion.FireMobEffect;
import net.mcreator.losthorizon.LosthorizonMod;

public class LosthorizonModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, LosthorizonMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> FURTIVITY = REGISTRY.register("furtivity", () -> new FurtivityMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FIRE = REGISTRY.register("fire", () -> new FireMobEffect());
}
