
package net.mcreator.losthorizon.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.WitchRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.WitchModel;

import net.mcreator.losthorizon.entity.SculkWitchEntity;
import net.mcreator.losthorizon.client.model.animations.SculkWitchAnimation;

public class SculkWitchRenderer extends MobRenderer<SculkWitchEntity, WitchRenderState, WitchModel> {
	private SculkWitchEntity entity = null;

	public SculkWitchRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelLayers.WITCH)), 0.5f);
	}

	@Override
	public WitchRenderState createRenderState() {
		return new WitchRenderState();
	}

	@Override
	public void extractRenderState(SculkWitchEntity entity, WitchRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
		if (this.model instanceof AnimatedModel) {
			((AnimatedModel) this.model).setEntity(entity);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(WitchRenderState state) {
		return ResourceLocation.parse("losthorizon:textures/entities/sculk_witch.png");
	}

	private static final class AnimatedModel extends WitchModel {
		private SculkWitchEntity entity = null;

		public AnimatedModel(ModelPart root) {
			super(root);
		}

		public void setEntity(SculkWitchEntity entity) {
			this.entity = entity;
		}

		@Override
		public void setupAnim(WitchRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.animate(entity.animationState0, SculkWitchAnimation.sculk_witch_general, state.ageInTicks, 1f);
			this.animateWalk(SculkWitchAnimation.sculk_witch_move, state.walkAnimationPos, state.walkAnimationSpeed, 1f, 1f);
			this.animate(entity.animationState2, SculkWitchAnimation.sculk_witch_villager_general, state.ageInTicks, 1f);
			super.setupAnim(state);
		}
	}
}
