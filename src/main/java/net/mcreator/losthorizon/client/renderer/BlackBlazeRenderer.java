
package net.mcreator.losthorizon.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;

import net.mcreator.losthorizon.entity.BlackBlazeEntity;
import net.mcreator.losthorizon.client.model.animations.black_blazeAnimation;
import net.mcreator.losthorizon.client.model.Modelblack_blaze;

public class BlackBlazeRenderer extends MobRenderer<BlackBlazeEntity, LivingEntityRenderState, Modelblack_blaze> {
	private BlackBlazeEntity entity = null;

	public BlackBlazeRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelblack_blaze.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(BlackBlazeEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
		if (this.model instanceof AnimatedModel) {
			((AnimatedModel) this.model).setEntity(entity);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("losthorizon:textures/entities/black_blaze.png");
	}

	private static final class AnimatedModel extends Modelblack_blaze {
		private BlackBlazeEntity entity = null;

		public AnimatedModel(ModelPart root) {
			super(root);
		}

		public void setEntity(BlackBlazeEntity entity) {
			this.entity = entity;
		}

		@Override
		public void setupAnim(LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.animateWalk(black_blazeAnimation.move, state.walkAnimationPos, state.walkAnimationSpeed, 1f, 1f);
			super.setupAnim(state);
		}
	}
}
