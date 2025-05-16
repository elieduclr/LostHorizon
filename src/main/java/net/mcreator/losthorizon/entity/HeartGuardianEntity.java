
package net.mcreator.losthorizon.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.losthorizon.procedures.HeartGuardianIsActivateProcedure;
import net.mcreator.losthorizon.procedures.HeartGuardianChaqueMiseAJourDeTickDeLentiteProcedure;
import net.mcreator.losthorizon.procedures.CryptGuardianPlaybackConditionProcedure;
import net.mcreator.losthorizon.init.LosthorizonModItems;

public class HeartGuardianEntity extends Monster {
	public static final EntityDataAccessor<Boolean> DATA_activate = SynchedEntityData.defineId(HeartGuardianEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_awaken = SynchedEntityData.defineId(HeartGuardianEntity.class, EntityDataSerializers.BOOLEAN);
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.RED, ServerBossEvent.BossBarOverlay.NOTCHED_20);

	public HeartGuardianEntity(EntityType<HeartGuardianEntity> type, Level world) {
		super(type, world);
		xpReward = 50;
		setNoAi(false);
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(LosthorizonModItems.LINK_DAGGER.get()));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_activate, false);
		builder.define(DATA_awaken, false);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}

			@Override
			public boolean canUse() {
				double x = HeartGuardianEntity.this.getX();
				double y = HeartGuardianEntity.this.getY();
				double z = HeartGuardianEntity.this.getZ();
				Entity entity = HeartGuardianEntity.this;
				Level world = HeartGuardianEntity.this.level();
				return super.canUse() && HeartGuardianIsActivateProcedure.execute(entity);
			}

		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = HeartGuardianEntity.this.getX();
				double y = HeartGuardianEntity.this.getY();
				double z = HeartGuardianEntity.this.getZ();
				Entity entity = HeartGuardianEntity.this;
				Level world = HeartGuardianEntity.this.level();
				return super.canUse() && CryptGuardianPlaybackConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, false, false) {
			@Override
			public boolean canUse() {
				double x = HeartGuardianEntity.this.getX();
				double y = HeartGuardianEntity.this.getY();
				double z = HeartGuardianEntity.this.getZ();
				Entity entity = HeartGuardianEntity.this;
				Level world = HeartGuardianEntity.this.level();
				return super.canUse() && HeartGuardianIsActivateProcedure.execute(entity);
			}
		});
	}

	@Override
	public Vec3 getPassengerRidingPosition(Entity entity) {
		return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(serverLevel, new ItemStack(LosthorizonModItems.HEART_LINK.get()));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.DRAGON_BREATH))
			return false;
		return super.hurtServer(level, damagesource, amount);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("Dataactivate", this.entityData.get(DATA_activate));
		compound.putBoolean("Dataawaken", this.entityData.get(DATA_awaken));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Dataactivate"))
			this.entityData.set(DATA_activate, compound.getBoolean("Dataactivate"));
		if (compound.contains("Dataawaken"))
			this.entityData.set(DATA_awaken, compound.getBoolean("Dataawaken"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		HeartGuardianChaqueMiseAJourDeTickDeLentiteProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void customServerAiStep(ServerLevel serverLevel) {
		super.customServerAiStep(serverLevel);
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 100);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}
