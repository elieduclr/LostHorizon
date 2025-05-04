package net.mcreator.losthorizon.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.losthorizon.init.LosthorizonModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MythrilSilverRingKnockbackProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == LosthorizonModItems.MYTHRIL_IRON_RING.get()) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
				_livingEntity2.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(1);
		} else {
			if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
				_livingEntity4.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
						.setBaseValue((entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE) ? _livingEntity3.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue() : 0));
		}
	}
}
