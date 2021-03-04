package shadowmaster435.the_beginning.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import shadowmaster435.the_beginning.blockentity.multiblock.TestMultiblockEntity;
import shadowmaster435.the_beginning.registry.TBBlocks;
import shadowmaster435.the_beginning.util.Vec3iUtil;

public class Multiblocktest extends GenericMultiblockTile {

    public static int i;

    public static BooleanProperty CENTER = BooleanProperty.of("center");
    public static BooleanProperty INPUT = BooleanProperty.of("in");
    public static BooleanProperty OUTPUT = BooleanProperty.of("out");
    public static BooleanProperty INTERFACE = BooleanProperty.of("interface");
    public static BooleanProperty NONE = BooleanProperty.of("none");
    public static BooleanProperty FORMED = BooleanProperty.of("formed");
    public boolean isFormed;
    public boolean middle;
    public boolean none;
    public boolean isinterface;
    public boolean in;
    public boolean out;

    public Block block = TBBlocks.MULTIBLOCK_TEST;
    public Multiblocktest(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(NONE, true).with(CENTER, false).with(INPUT, false).with(OUTPUT, false).with(INTERFACE, false).with(FORMED, false));

    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.getBlockTickScheduler().schedule(pos, this, 2);
        for (Vec3iUtil.all vec3i : Vec3iUtil.all.values()) {
            world.getBlockTickScheduler().schedule(vec3i.getPos(), this, 2);
            middle = world.getBlockState(pos.crossProduct(new Vec3i(vec3i.getOffsetX(), vec3i.getOffsetY(), vec3i.getOffsetZ()))) == TBBlocks.MULTIBLOCK_TEST.getDefaultState();
            }
        }
    /*public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

      if (!middle) {
          for (Vec3iUtil.all directions : Vec3iUtil.all.ALL) {

              BlockPos pos1 = pos.crossProduct(new Vec3i(directions.getOffsetX(), directions.getOffsetY(), directions.getOffsetZ()));
            if (Vec3iUtil.all.id() >= Vec3iUtil.all.id()) {
                  if (world.getBlockState(pos.crossProduct(new Vec3i(directions.getOffsetX(), directions.getOffsetY(), directions.getOffsetZ()))) == TBBlocks.MULTIBLOCK_TEST.getDefaultState()) {


                          if (world.getBlockState(pos.north(1)).getBlock().getDefaultState() == this.getDefaultState()) {
                              isinterface = true;
                          } else if (world.getBlockState(pos.east(1)).getBlock().getDefaultState() == this.getDefaultState()) {
                              in = true;
                              isinterface = false;

                          } else if (world.getBlockState(pos.west(1)).getBlock().getDefaultState() == this.getDefaultState()) {
                              out = true;
                              in = false;

                          } else {
                              none = true;
                          }
                      }
                  }
                  world.setBlockState(pos1, state.with(FORMED, isFormed).with(NONE, none).with(INPUT, in).with(OUTPUT, out).with(INTERFACE, isinterface));
              }
          }
      }

             */
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new TestMultiblockEntity();
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CENTER, INPUT, OUTPUT, INTERFACE, NONE, FORMED);
    }

}
