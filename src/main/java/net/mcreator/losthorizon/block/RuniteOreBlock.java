
package net.mcreator.losthorizon.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class RuniteOreBlock extends Block {
	public RuniteOreBlock(BlockBehaviour.Properties properties) {
		super(properties.instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(45f, 500f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
