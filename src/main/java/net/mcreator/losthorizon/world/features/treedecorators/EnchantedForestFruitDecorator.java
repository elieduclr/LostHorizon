
package net.mcreator.losthorizon.world.features.treedecorators;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.util.RandomSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;

import com.mojang.serialization.MapCodec;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class EnchantedForestFruitDecorator extends CocoaDecorator {
	public static MapCodec<EnchantedForestFruitDecorator> CODEC = MapCodec.unit(EnchantedForestFruitDecorator::new);
	public static TreeDecoratorType<?> DECORATOR_TYPE = new TreeDecoratorType<>(CODEC);

	@SubscribeEvent
	public static void registerTreeDecorator(RegisterEvent event) {
		event.register(Registries.TREE_DECORATOR_TYPE, ResourceLocation.parse("losthorizon:enchanted_forest_tree_fruit_decorator"), () -> DECORATOR_TYPE);
	}

	public EnchantedForestFruitDecorator() {
		super(0.2f);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return DECORATOR_TYPE;
	}

	@Override
	public void place(TreeDecorator.Context context) {
		RandomSource randomsource = context.random();
		if (!(randomsource.nextFloat() >= 0.2F)) {
			List<BlockPos> list = context.logs();
			if (!list.isEmpty()) {
				int i = list.getFirst().getY();
				list.stream().filter(p_69980_ -> p_69980_.getY() - i <= 2).forEach(p_226026_ -> {
					for (Direction direction : Direction.Plane.HORIZONTAL) {
						if (randomsource.nextFloat() <= 0.25F) {
							Direction direction1 = direction.getOpposite();
							BlockPos blockpos = p_226026_.offset(direction1.getStepX(), 0, direction1.getStepZ());
							if (context.isAir(blockpos)) {
								context.setBlock(blockpos, oriented(Blocks.AIR.defaultBlockState(), direction1));
							}
						}
					}
				});
			}
		}
	}

	@SuppressWarnings("deprecation")
	private static BlockState oriented(BlockState blockstate, Direction direction) {
		return switch (direction) {
			case SOUTH -> blockstate.rotate(Rotation.CLOCKWISE_180);
			case EAST -> blockstate.rotate(Rotation.CLOCKWISE_90);
			case WEST -> blockstate.rotate(Rotation.COUNTERCLOCKWISE_90);
			default -> blockstate;
		};
	}
}
