// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcryptguardian<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "cryptguardian"), "main");
	private final ModelPart Body3;
	private final ModelPart Leg;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart Body2;
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart Arm;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;

	public Modelcryptguardian(ModelPart root) {
		this.Body3 = root.getChild("Body3");
		this.Leg = this.Body3.getChild("Leg");
		this.RightLeg = this.Leg.getChild("RightLeg");
		this.LeftLeg = this.Leg.getChild("LeftLeg");
		this.Body2 = this.Body3.getChild("Body2");
		this.Head = this.Body2.getChild("Head");
		this.Body = this.Body2.getChild("Body");
		this.Arm = this.Body2.getChild("Arm");
		this.RightArm = this.Arm.getChild("RightArm");
		this.LeftArm = this.Arm.getChild("LeftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body3 = partdefinition.addOrReplaceChild("Body3", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Leg = Body3.addOrReplaceChild("Leg", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = Leg.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(0, 16)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 32)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(-1.9F, -12.0F, 0.0F));

		PartDefinition LeftLeg = Leg.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(16, 48)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 48)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(1.9F, -12.0F, 0.0F));

		PartDefinition Body2 = Body3.addOrReplaceChild("Body2", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head = Body2.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(32, 0)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition Body = Body2.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(16, 16)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 32)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition Arm = Body2.addOrReplaceChild("Arm", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = Arm.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(40, 16)
						.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 32)
						.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(-5.0F, -22.0F, 0.0F));

		PartDefinition LeftArm = Arm.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(32, 48)
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(48, 48)
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(5.0F, -22.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}