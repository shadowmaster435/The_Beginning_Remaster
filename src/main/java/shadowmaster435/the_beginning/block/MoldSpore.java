package shadowmaster435.the_beginning.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class MoldSpore extends Block {
        public static final VoxelShape OUTLINE_SHAPE;

        public MoldSpore(AbstractBlock.Settings settings) {
            super(settings);
        }
        public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
            return VoxelShapes.fullCube();
        }

        public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            return OUTLINE_SHAPE;
        }
        static {
            OUTLINE_SHAPE = VoxelShapes.combineAndSimplify(VoxelShapes.union(
                    createCuboidShape(4, 3, 4, 12, 13, 12),
                    createCuboidShape(2, 5, 5, 14, 11, 11),
                    createCuboidShape(5, 5, 2, 11, 11, 14),
                    createCuboidShape(5, 2, 5, 11, 14, 11),
                    createCuboidShape(4, 4, 3, 12, 12, 13),
                    createCuboidShape(3, 4, 4, 13, 12, 12),
                    createCuboidShape(7, 0, 7, 9, 2, 9),
                    createCuboidShape(8, -2, -2, 8, 18, 18),
                    createCuboidShape(3.5, 7.75, -1.5, 12.5, 8.25, 17.5),
                    createCuboidShape(0.5, 7.75, 0.5, 15.5, 8.25, 15.5),
                    createCuboidShape(-1.5, 7.75, 3.5, 17.5, 8.25, 12.5),
                    createCuboidShape(-1.5, 3.5, 7.75, 17.5, 12.5, 8.25),
                    createCuboidShape(0.5, 0.5, 7.75, 15.5, 15.5, 8.25),
                    createCuboidShape(3.5, -1.5, 7.75, 12.5, 17.5, 8.25),
                    createCuboidShape(7.75, -1.5, 3.5, 8.25, 17.5, 12.5),
                    createCuboidShape(7.75, 0.5, 0.5, 8.25, 15.5, 15.5),
                    createCuboidShape(7.75, 3.5, -1.5, 8.25, 12.5, 17.5)), VoxelShapes.empty(), BooleanBiFunction.ONLY_FIRST);
        }
    }
