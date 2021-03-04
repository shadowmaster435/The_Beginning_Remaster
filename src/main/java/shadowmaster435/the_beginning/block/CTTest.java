package shadowmaster435.the_beginning.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import shadowmaster435.the_beginning.registry.TBBlocks;

import java.util.Random;

public class CTTest extends Block {
    public CTTest(Settings settings) {
        super(settings);
    }
    public static final Block block = TBBlocks.CTTEST;
    public static BlockPos bpos = BlockPos.ORIGIN;
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.getBlockTickScheduler().schedule(pos, this, 2);
    }
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.getBlockTickScheduler().schedule(pos, this, 2);
    }
}
