// Save this class in your mod and generate all required imports

/**
 * Made with Blockbench 4.12.4 Exported for Minecraft version 1.19 or later with
 * Mojang mappings
 * 
 * @author Author
 */
public class black_blazeAnimation {
	public static final AnimationDefinition move = AnimationDefinition.Builder.withLength(0.0F).looping()
			.addAnimation("upperBodyParts0",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.0F, KeyframeAnimations.posVec(9.0F, 3.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upperBodyParts1",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.8776F, 9.0F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upperBodyParts10",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.0F, KeyframeAnimations.posVec(-4.455F, -11.8211F, -2.27F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upperBodyParts11",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.0F, KeyframeAnimations.posVec(2.27F, -11.5551F, -4.455F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upperBodyParts2",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.0F, KeyframeAnimations.posVec(-9.0F, 2.5405F, 0.0F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upperBodyParts3",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0711F, -9.0F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upperBodyParts4",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.0F, KeyframeAnimations.posVec(4.9497F, -2.4156F, 4.9497F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upperBodyParts5",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.0F, KeyframeAnimations.posVec(-4.9497F, -2.8007F, 4.9497F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upperBodyParts6",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.0F, KeyframeAnimations.posVec(-4.9497F, -2.9899F, -4.9497F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upperBodyParts7",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.0F, KeyframeAnimations.posVec(4.9497F, -2.9368F, -4.9497F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upperBodyParts8",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.0F, KeyframeAnimations.posVec(4.455F, -11.9899F, 2.27F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upperBodyParts9", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F,
					KeyframeAnimations.posVec(-2.27F, -11.9731F, 4.455F), AnimationChannel.Interpolations.LINEAR)))
			.build();
}