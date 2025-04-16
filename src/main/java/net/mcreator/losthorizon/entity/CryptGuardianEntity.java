
package net.mcreator.losthorizon.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.losthorizon.procedures.CryptGuardianQuandLentiteMeurtProcedure;
import net.mcreator.losthorizon.procedures.CryptGuardianPlaybackDeathConditionProcedure;
import net.mcreator.losthorizon.procedures.CryptGuardianPlaybackConditionProcedure;
import net.mcreator.losthorizon.procedures.CryptGuardianPlaybackAttackConditionProcedure;
import net.mcreator.losthorizon.procedures.CryptGuardianChaqueMiseAJourDeTickDeLentiteProcedure;

public class CryptGuardianEntity extends Monster {
	public static final EntityDataAccessor<Boolean> DATA_death = SynchedEntityData.defineId(CryptGuardianEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_idle = SynchedEntityData.defineId(CryptGuardianEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_attack = SynchedEntityData.defineId(CryptGuardianEntity.class, EntityDataSerializers.BOOLEAN);
	public final AnimationState animationState1 = new AnimationState();
	public final AnimationState animationState2 = new AnimationState();
	public final AnimationState animationState3 = new AnimationState();

	public CryptGuardianEntity(EntityType<CryptGuardianEntity> type, Level world) {
		super(type, world);
		xpReward = 25;
		setNoAi(false);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_death, false);
		builder.define(DATA_idle, false);
		builder.define(DATA_attack, false);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(serverLevel, new ItemStack(Items.AMETHYST_SHARD));
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
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		return super.hurtServer(level, damagesource, amount);
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		CryptGuardianQuandLentiteMeurtProcedure.execute(this);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("Datadeath", this.entityData.get(DATA_death));
		compound.putBoolean("Dataidle", this.entityData.get(DATA_idle));
		compound.putBoolean("Dataattack", this.entityData.get(DATA_attack));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Datadeath"))
			this.entityData.set(DATA_death, compound.getBoolean("Datadeath"));
		if (compound.contains("Dataidle"))
			this.entityData.set(DATA_idle, compound.getBoolean("Dataidle"));
		if (compound.contains("Dataattack"))
			this.entityData.set(DATA_attack, compound.getBoolean("Dataattack"));
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.animationState1.animateWhen(CryptGuardianPlaybackConditionProcedure.execute(this), this.tickCount);
			this.animationState2.animateWhen(CryptGuardianPlaybackAttackConditionProcedure.execute(this), this.tickCount);
			this.animationState3.animateWhen(CryptGuardianPlaybackDeathConditionProcedure.execute(this), this.tickCount);
		}
	}

	@Override
	public void baseTick() {
		super.baseTick();
		CryptGuardianChaqueMiseAJourDeTickDeLentiteProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 40);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}
