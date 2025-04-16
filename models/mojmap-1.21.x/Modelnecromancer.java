// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelnecromancer<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "necromancer"), "main");
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart hat;
	private final ModelPart hat2;
	private final ModelPart hat3;
	private final ModelPart hat4;
	private final ModelPart arms;
	private final ModelPart leg0;
	private final ModelPart leg1;

	public Modelnecromancer(ModelPart root) {
		this.body = root.getChild("body");
		this.head = this.body.getChild("head");
		this.nose = this.head.getChild("nose");
		this.hat = this.head.getChild("hat");
		this.hat2 = this.hat.getChild("hat2");
		this.hat3 = this.hat2.getChild("hat3");
		this.hat4 = this.hat3.getChild("hat4");
		this.arms = this.body.getChild("arms");
		this.leg0 = this.body.getChild("leg0");
		this.leg1 = this.body.getChild("leg1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 20).mirror()
				.addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 38)
				.mirror().addBox(-4.0F, 0.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 0).mirror()
				.addBox(-1.0F, 0.0F, -6.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false).texOffs(24, 0)
				.mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition hat = head.addOrReplaceChild("hat",
				CubeListBuilder.create().texOffs(0, 64).mirror()
						.addBox(-10.0F, -2.02F, 0.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(5.0F, -8.03F, -5.0F));

		PartDefinition hat2 = hat.addOrReplaceChild("hat2",
				CubeListBuilder.create().texOffs(0, 76).mirror()
						.addBox(-2.0F, -5.5F, -5.0F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-6.75F, 0.03F, 7.0F, -0.0524F, 0.0F, 0.0262F));

		PartDefinition hat3 = hat2.addOrReplaceChild("hat3",
				CubeListBuilder.create().texOffs(0, 87).mirror()
						.addBox(-0.75F, -5.5F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.1047F, 0.0F, 0.0524F));

		PartDefinition hat4 = hat3.addOrReplaceChild("hat4",
				CubeListBuilder.create().texOffs(0, 95).mirror()
						.addBox(0.5F, -4.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.2094F, 0.0F, 0.1047F));

		PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create().texOffs(40, 38).mirror()
				.addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(44, 22)
				.mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
				.mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, -0.75F, 0.0F, 0.0F));

		PartDefinition leg0 = body.addOrReplaceChild("leg0",
				CubeListBuilder.create().texOffs(0, 22).mirror()
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F,
				-2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}