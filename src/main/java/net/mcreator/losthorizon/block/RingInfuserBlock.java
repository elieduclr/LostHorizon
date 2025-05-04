
package net.mcreator.losthorizon.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.Containers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.losthorizon.world.inventory.RingInfuserGUIMenu;
import net.mcreator.losthorizon.block.entity.RingInfuserBlockEntity;

import io.netty.buffer.Unpooled;

public class RingInfuserBlock extends Block implements EntityBlock {
	public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

	public RingInfuserBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NETHER_BRICKS).strength(1f, 6000f).lightLevel(s -> 5).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.join(Shapes.or(box(0, 0, 0, 16, 12, 16), box(7, 28, 7, 16, 30, 9), box(7, 23, 7, 9, 28, 9), box(7, 22, 6, 8, 23, 8), box(8, 22, 7, 10, 23, 8), box(8, 22, 8, 9, 23, 10), box(6, 22, 8, 8, 23, 9), box(7, 18, 5, 8, 23, 6),
					box(8, 18, 10, 9, 23, 11), box(5, 18, 8, 6, 23, 9), box(10, 18, 7, 11, 23, 8)), Shapes.or(box(14, 5, 7, 16, 17, 9), box(22.5, 13.5, 7, 24.5, 21.5, 9), box(15, 28.5, 7, 27, 30.5, 9)), BooleanOp.ONLY_FIRST);
			case NORTH -> Shapes.join(Shapes.or(box(0, 0, 0, 16, 12, 16), box(0, 28, 7, 9, 30, 9), box(7, 23, 7, 9, 28, 9), box(8, 22, 8, 9, 23, 10), box(6, 22, 8, 8, 23, 9), box(7, 22, 6, 8, 23, 8), box(8, 22, 7, 10, 23, 8),
					box(8, 18, 10, 9, 23, 11), box(7, 18, 5, 8, 23, 6), box(10, 18, 7, 11, 23, 8), box(5, 18, 8, 6, 23, 9)), Shapes.or(box(0, 5, 7, 2, 17, 9), box(-8.5, 13.5, 7, -6.5, 21.5, 9), box(-11, 28.5, 7, 1, 30.5, 9)), BooleanOp.ONLY_FIRST);
			case EAST -> Shapes.join(Shapes.or(box(0, 0, 0, 16, 12, 16), box(7, 28, 0, 9, 30, 9), box(7, 23, 7, 9, 28, 9), box(6, 22, 8, 8, 23, 9), box(7, 22, 6, 8, 23, 8), box(8, 22, 7, 10, 23, 8), box(8, 22, 8, 9, 23, 10), box(5, 18, 8, 6, 23, 9),
					box(10, 18, 7, 11, 23, 8), box(8, 18, 10, 9, 23, 11), box(7, 18, 5, 8, 23, 6)), Shapes.or(box(7, 5, 0, 9, 17, 2), box(7, 13.5, -8.5, 9, 21.5, -6.5), box(7, 28.5, -11, 9, 30.5, 1)), BooleanOp.ONLY_FIRST);
			case WEST -> Shapes.join(Shapes.or(box(0, 0, 0, 16, 12, 16), box(7, 28, 7, 9, 30, 16), box(7, 23, 7, 9, 28, 9), box(8, 22, 7, 10, 23, 8), box(8, 22, 8, 9, 23, 10), box(6, 22, 8, 8, 23, 9), box(7, 22, 6, 8, 23, 8),
					box(10, 18, 7, 11, 23, 8), box(5, 18, 8, 6, 23, 9), box(7, 18, 5, 8, 23, 6), box(8, 18, 10, 9, 23, 11)), Shapes.or(box(7, 5, 14, 9, 17, 16), box(7, 13.5, 22.5, 9, 21.5, 24.5), box(7, 28.5, 15, 9, 30.5, 27)), BooleanOp.ONLY_FIRST);
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		if (entity instanceof ServerPlayer player) {
			player.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Ring Infuser");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new RingInfuserGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new RingInfuserBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof RingInfuserBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof RingInfuserBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
