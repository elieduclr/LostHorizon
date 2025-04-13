package net.mcreator.losthorizon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.util.List;

@EventBusSubscriber
public class MagnetismProcedureProcedure {
    
    // Paramètres ajustables
    private static final float BASE_RANGE = 4.0f;
    private static final float RANGE_PER_LEVEL = 1.5f;
    private static final float BASE_SPEED = 0.12f;
    private static final float SPEED_PER_LEVEL = 0.05f;
    private static final float DAMPING_FACTOR = 0.9f; // Nouveau: amortissement

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        execute(event, event.getEntity().level(), event.getEntity());
    }

    public static void execute(LevelAccessor world, Entity entity) {
        execute(null, world, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
        if (entity == null || !(entity instanceof Player player) || world.isClientSide()) 
            return;

        ItemStack chestplate = ((LivingEntity) entity).getItemBySlot(EquipmentSlot.CHEST);
        
        int levelEnchant = chestplate.getEnchantmentLevel(
            world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(ResourceKey.create(
                    Registries.ENCHANTMENT, 
                    ResourceLocation.parse("losthorizon:magnetism")
                )
        ));

        if (levelEnchant <= 0) return;

        // Calcul des valeurs dynamiques
        float attractionRange = BASE_RANGE + (RANGE_PER_LEVEL * (levelEnchant - 1));
        float speedFactor = BASE_SPEED + (SPEED_PER_LEVEL * (levelEnchant - 1));
        
        AABB range = player.getBoundingBox().inflate(attractionRange);
        List<ItemEntity> items = player.level().getEntitiesOfClass(ItemEntity.class, range);

        for (ItemEntity item : items) {
            if (item.isAlive() && !item.hasPickUpDelay()) {
                Vec3 direction = player.position().subtract(item.position())
                    .normalize()
                    .scale(speedFactor);
                
                // Application avec amortissement progressif
                Vec3 newMotion = item.getDeltaMovement()
                    .add(direction)
                    .scale(DAMPING_FACTOR);
                
                item.setDeltaMovement(newMotion);
            }
        }
    }
}