
package net.mcreator.losthorizon.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class OnyxOreBlock extends Block {
	public OnyxOreBlock(BlockBehaviour.Properties properties) {
		super(properties.instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.NETHER_ORE).strength(20f, 8.705505633f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
