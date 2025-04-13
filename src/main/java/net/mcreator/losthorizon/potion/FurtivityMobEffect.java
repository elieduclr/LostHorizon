
package net.mcreator.losthorizon.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.losthorizon.LosthorizonMod;

public class FurtivityMobEffect extends MobEffect {
	public FurtivityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13434829, mobEffectInstance -> ParticleTypes.WITCH);
		this.withSoundOnAdded(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.player.splash.high_speed")));
		this.addAttributeModifier(Attributes.SNEAKING_SPEED, ResourceLocation.fromNamespaceAndPath(LosthorizonMod.MODID, "effect.furtivity_0"), 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
	}
}
