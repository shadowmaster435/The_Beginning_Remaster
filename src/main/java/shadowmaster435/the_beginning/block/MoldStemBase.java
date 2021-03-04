package shadowmaster435.the_beginning.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class MoldStemBase extends Block {
    public static final VoxelShape OUTLINE_SHAPE;

    public MoldStemBase(Settings settings) {
        super(settings);
    }
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return OUTLINE_SHAPE;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return OUTLINE_SHAPE;
    }
    static {
    OUTLINE_SHAPE = VoxelShapes.combineAndSimplify(VoxelShapes.empty(), VoxelShapes.union(
           createCuboidShape(6, 0, 7, 7, 2, 9),
           createCuboidShape(8, 1, 6, 9, 2, 8),
           createCuboidShape(6, 0, 6, 8, 1, 7),
           createCuboidShape(8, 0, 10, 9, 1, 11),
           createCuboidShape(8, 1, 9, 9, 2, 10),
           createCuboidShape(8, 0, 9, 10, 1, 10),
           createCuboidShape(7, 0, 7, 9, 16, 9),
           createCuboidShape(8, 0, 5, 9, 1, 8),
           createCuboidShape(9, 0, 6, 10, 1, 7),
           createCuboidShape(9, 0, 7, 10, 2, 9),
           createCuboidShape(10, 0, 7, 11, 1, 8),
           createCuboidShape(7, 0, 9, 8, 1, 10),
           createCuboidShape(5, 0, 8, 6, 1, 9),
           createCuboidShape(2, 0, 11, 3, 4, 12),
           createCuboidShape(6, 0, 3, 7, 3, 4),
           createCuboidShape(0, 4.75, 9, 5, 5.25, 14),
           createCuboidShape(10, 2.75, 7, 15, 3.25, 12),
           createCuboidShape(4, 3.75, 1, 9, 4.25, 6),
           createCuboidShape(0, 2.5, 11.25, 5, 7.5, 11.75),
           createCuboidShape(10, 0.5, 9.25, 15, 5.5, 9.75),
           createCuboidShape(4, 1.5, 3.25, 9, 6.5, 3.75),
           createCuboidShape(2.25, 2.5, 9, 2.75, 7.5, 14),
           createCuboidShape(12.25, 0.5, 7, 12.75, 5.5, 12),
           createCuboidShape(6.25, 1.5, 1, 6.75, 6.5, 6),
           createCuboidShape(12, 0, 9, 13, 2, 10) ), BooleanBiFunction.ONLY_FIRST);
    }
}
