package shadowmaster435.the_beginning.block;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Util;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import shadowmaster435.the_beginning.blockentity.ItemPipeEntity;
import shadowmaster435.the_beginning.registry.TBBlocks;

import java.util.Map;
import java.util.Random;

public class ItemPipe extends Block implements BlockEntityProvider {
    public static BooleanProperty EXTRACT = BooleanProperty.of("extract");
    public static BooleanProperty INSERT = BooleanProperty.of("insert");
    public static BooleanProperty UP;
    public static BooleanProperty DOWN;
    public static BooleanProperty NORTH;
    public static BooleanProperty SOUTH;
    public static BooleanProperty EAST;
    public static BooleanProperty WEST;
    public static final Map<Direction, BooleanProperty> FACING_PROPERTIES;

    private static VoxelShape U = Block.createCuboidShape(5, 11, 5, 11, 16, 11);
    private static VoxelShape D = Block.createCuboidShape(5, 0, 5, 11, 5, 11);
    private static VoxelShape N = Block.createCuboidShape(5, 5, 0, 11, 11, 5);
    private static VoxelShape S = Block.createCuboidShape(11, 5, 5, 16, 11, 11);
    private static VoxelShape E = Block.createCuboidShape(5, 5, 11, 11, 11, 16);
    private static VoxelShape W = Block.createCuboidShape(0, 5, 5, 5, 11, 11);
    private static final VoxelShape CENTER = Block.createCuboidShape(5, 5, 5, 11, 11, 11);

    private static final VoxelShape full = VoxelShapes.union(Block.createCuboidShape(5, 5, 0, 11, 11, 5),
            Block.createCuboidShape(11, 5, 5, 16, 11, 11),
            Block.createCuboidShape(5, 11, 5, 11, 16, 11),
            Block.createCuboidShape(5, 5, 11, 11, 11, 16),
            Block.createCuboidShape(0, 5, 5, 5, 11, 11),
            Block.createCuboidShape(5, 0, 5, 11, 5, 11),
            Block.createCuboidShape(5, 5, 5, 11, 11, 11)
    );
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.withConnectionProperties(ctx.getWorld(), ctx.getBlockPos());
    }

    public BlockState withConnectionProperties(BlockView world, BlockPos pos) {
        Block block = world.getBlockState(pos.down()).getBlock();
        Block block2 = world.getBlockState(pos.up()).getBlock();
        Block block3 = world.getBlockState(pos.north()).getBlock();
        Block block4 = world.getBlockState(pos.east()).getBlock();
        Block block5 = world.getBlockState(pos.south()).getBlock();
        Block block6 = world.getBlockState(pos.west()).getBlock();
        return this.getDefaultState().with(DOWN, block == this).with(UP, block2 == this ).with(NORTH, block3 == this).with(EAST, block4 == this ).with(SOUTH, block5 == this ).with(WEST, block6 == this );
    }
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
            world.getBlockTickScheduler().schedule(pos, this, 1);
        boolean bl = newState.getBlock() == this;
        return state.with(FACING_PROPERTIES.get(direction), bl);
    }

    /*public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
       if (world.getBlockState(BlockPos.ORIGIN).getBlock() == TBBlocks.ITEM_PIPE) {

            if (world.getBlockState(pos.south(1)) == TBBlocks.ITEM_PIPE.getDefaultState().with(NORTH, true) && world.getBlockState(BlockPos.ORIGIN) == TBBlocks.ITEM_PIPE.getDefaultState().with(SOUTH, true)) {
                if (player.raycast(5, 2, false).getPos().equals()  N.getBoundingBox().getXLength()  N.getBoundingBox().maxX) {
                    world.setBlockState(BlockPos.ORIGIN, state.with(SOUTH, false));
                    world.setBlockState(pos.south(), state.with(NORTH, false));
                    System.out.println("success");
                    return ActionResult.SUCCESS;
                }
            } else if (world.getBlockState(pos.north(1)) == TBBlocks.ITEM_PIPE.getDefaultState().with(SOUTH, true) && world.getBlockState(BlockPos.ORIGIN) == TBBlocks.ITEM_PIPE.getDefaultState().with(NORTH, true)) {
                if (player.raycast(5, 2,false).getPos().isInRange(S.getBoundingBox().getCenter(), 6)) {
                    world.setBlockState(BlockPos.ORIGIN, state.with(NORTH, false));
                    world.setBlockState(pos.north(), state.with(SOUTH, false));
                    System.out.println("success");

                    return ActionResult.SUCCESS;
                }
            } else if (world.getBlockState(pos.west(1)) == TBBlocks.ITEM_PIPE.getDefaultState().with(EAST, true) && world.getBlockState(BlockPos.ORIGIN) == TBBlocks.ITEM_PIPE.getDefaultState().with(WEST, true)) {
                if (E.raycast(new Vec3d(E.getBoundingBox().minX, E.getBoundingBox().minY, E.getBoundingBox().minZ),  new Vec3d(E.getBoundingBox().maxX, E.getBoundingBox().maxY, E.getBoundingBox().maxZ), BlockPos.ORIGIN).isInsideBlock()) {
                    world.setBlockState(BlockPos.ORIGIN, state.with(WEST, false));

                    return ActionResult.SUCCESS;
                }
            } else if (world.getBlockState(pos.east(1)) == TBBlocks.ITEM_PIPE.getDefaultState().with(WEST, true) && world.getBlockState(BlockPos.ORIGIN) == TBBlocks.ITEM_PIPE.getDefaultState().with(WEST, true)) {
                if (W.raycast(new Vec3d(W.getBoundingBox().minX, W.getBoundingBox().minY, W.getBoundingBox().minZ), new Vec3d(W.getBoundingBox().maxX, W.getBoundingBox().maxY, W.getBoundingBox().maxZ), BlockPos.ORIGIN).isInsideBlock()) {
                    world.setBlockState(BlockPos.ORIGIN, state.with(EAST, false));

                    return ActionResult.SUCCESS;
                }
            } else if (world.getBlockState(pos.down(1)) == TBBlocks.ITEM_PIPE.getDefaultState().with(DOWN, true) && world.getBlockState(BlockPos.ORIGIN) == TBBlocks.ITEM_PIPE.getDefaultState().with(UP, true)) {
                if (D.raycast(new Vec3d(U.getBoundingBox().minX, U.getBoundingBox().minY, U.getBoundingBox().minZ), new Vec3d(U.getBoundingBox().maxX, U.getBoundingBox().maxY, U.getBoundingBox().maxZ), BlockPos.ORIGIN).isInsideBlock()) {
                    world.setBlockState(BlockPos.ORIGIN, state.with(DOWN, false));

                    return ActionResult.SUCCESS;
                }
            } else if (world.getBlockState(pos.up(1)) == TBBlocks.ITEM_PIPE.getDefaultState().with(UP, true) && world.getBlockState(BlockPos.ORIGIN) == TBBlocks.ITEM_PIPE.getDefaultState().with(DOWN, true)) {
                if (U.raycast(new Vec3d(D.getBoundingBox().minX, D.getBoundingBox().minY, D.getBoundingBox().minZ),  new Vec3d(D.getBoundingBox().maxX, D.getBoundingBox().maxY, D.getBoundingBox().maxZ), BlockPos.ORIGIN).isInsideBlock()) {
                    world.setBlockState(BlockPos.ORIGIN, state.with(UP, false));

                    return ActionResult.SUCCESS;
                }
            } else  {
                if (CENTER.raycast(new Vec3d(CENTER.getBoundingBox().minX, CENTER.getBoundingBox().minY, CENTER.getBoundingBox().minZ), new Vec3d(CENTER.getBoundingBox().maxX, CENTER.getBoundingBox().maxY, CENTER.getBoundingBox().maxZ), BlockPos.ORIGIN).getSide() == Direction.UP) {
                    world.setBlockState(BlockPos.ORIGIN, state.with(UP, true));
                    return ActionResult.SUCCESS;
                } else if (CENTER.raycast(new Vec3d(CENTER.getBoundingBox().minX, CENTER.getBoundingBox().minY, CENTER.getBoundingBox().minZ), new Vec3d(CENTER.getBoundingBox().maxX, CENTER.getBoundingBox().maxY, CENTER.getBoundingBox().maxZ), BlockPos.ORIGIN).getSide() == Direction.DOWN) {
                    world.setBlockState(BlockPos.ORIGIN, state.with(DOWN, true));
                    return ActionResult.SUCCESS;
                } else if (CENTER.raycast(new Vec3d(CENTER.getBoundingBox().minX, CENTER.getBoundingBox().minY, CENTER.getBoundingBox().minZ), new Vec3d(CENTER.getBoundingBox().maxX, CENTER.getBoundingBox().maxY, CENTER.getBoundingBox().maxZ), BlockPos.ORIGIN).getSide() == Direction.NORTH) {
                    world.setBlockState(BlockPos.ORIGIN, state.with(NORTH, true));
                    return ActionResult.SUCCESS;
                } else if (CENTER.raycast(new Vec3d(CENTER.getBoundingBox().minX, CENTER.getBoundingBox().minY, CENTER.getBoundingBox().minZ), new Vec3d(CENTER.getBoundingBox().maxX, CENTER.getBoundingBox().maxY, CENTER.getBoundingBox().maxZ), BlockPos.ORIGIN).getSide() == Direction.EAST) {
                    world.setBlockState(BlockPos.ORIGIN, state.with(SOUTH, true));
                    return ActionResult.SUCCESS;
                } else if (CENTER.raycast(new Vec3d(CENTER.getBoundingBox().minX, CENTER.getBoundingBox().minY, CENTER.getBoundingBox().minZ), new Vec3d(CENTER.getBoundingBox().maxX, CENTER.getBoundingBox().maxY, CENTER.getBoundingBox().maxZ), BlockPos.ORIGIN).getSide() == Direction.WEST) {
                    world.setBlockState(BlockPos.ORIGIN, state.with(EAST, true));
                    return ActionResult.SUCCESS;
                } else if (CENTER.raycast(new Vec3d(CENTER.getBoundingBox().minX, CENTER.getBoundingBox().minY, CENTER.getBoundingBox().minZ), new Vec3d(CENTER.getBoundingBox().maxX, CENTER.getBoundingBox().maxY, CENTER.getBoundingBox().maxZ), BlockPos.ORIGIN).getSide() == Direction.SOUTH) {
                    world.setBlockState(BlockPos.ORIGIN, state.with(WEST, true));
                    return ActionResult.SUCCESS;
                } else {
                    throw new IllegalStateException("Someones Been Tampering With The Universe!");
                }
            }
        }
        return ActionResult.SUCCESS;
    }*/



    public ItemPipe(Settings settings) {
        super(settings);
        this.setDefaultState(((((((this.stateManager.getDefaultState().with(NORTH, false)).with(EAST, false)).with(SOUTH, false)).with(WEST, false)).with(UP, false)).with(DOWN, false)));
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.getBlockTickScheduler().schedule(pos, this, 2);
        if (world.getBlockState(pos.up(1)) == TBBlocks.ITEM_PIPE.getDefaultState().with(DOWN, true).with(UP, state.get(UP)).with(NORTH, state.get(NORTH)).with(SOUTH, state.get(SOUTH)).with(EAST, state.get(EAST)).with(WEST, state.get(WEST)).with(EXTRACT, state.get(EXTRACT)).with(INSERT, state.get(INSERT))) {
            U = Block.createCuboidShape(5, 11, 5, 11, 16, 11);

        } else {
            U = CENTER;
        }
        if (world.getBlockState(pos.down(1)) == TBBlocks.ITEM_PIPE.getDefaultState().with(DOWN, state.get(DOWN)).with(UP, true).with(NORTH, state.get(NORTH)).with(SOUTH, state.get(SOUTH)).with(EAST, state.get(EAST)).with(WEST, state.get(WEST)).with(EXTRACT, state.get(EXTRACT)).with(INSERT, state.get(INSERT))) {
            D = Block.createCuboidShape(5, 0, 5, 11, 5, 11);

        } else {
            D = CENTER;
        }

        if (world.getBlockState(pos.north(1)) == TBBlocks.ITEM_PIPE.getDefaultState().with(DOWN, state.get(DOWN)).with(UP, state.get(UP)).with(NORTH, state.get(NORTH)).with(SOUTH, true).with(EAST, state.get(EAST)).with(WEST, state.get(WEST)).with(EXTRACT, state.get(EXTRACT)).with(INSERT, state.get(INSERT))) {
            N = Block.createCuboidShape(5, 5, 0, 11, 11, 5);


        } else {
            N = CENTER;
        }

        if (world.getBlockState(pos.south(1)) == TBBlocks.ITEM_PIPE.getDefaultState().with(DOWN, state.get(DOWN)).with(UP, state.get(UP)).with(NORTH, true).with(SOUTH, state.get(SOUTH)).with(EAST, state.get(EAST)).with(WEST, state.get(WEST)).with(EXTRACT, state.get(EXTRACT)).with(INSERT, state.get(INSERT))) {
            S = Block.createCuboidShape(5, 5, 11, 11, 11, 16);
        } else {

            S = CENTER;
        }

        if (world.getBlockState(pos.west(1)) == TBBlocks.ITEM_PIPE.getDefaultState().with(DOWN, state.get(DOWN)).with(UP, state.get(UP)).with(NORTH, state.get(NORTH)).with(SOUTH, state.get(SOUTH)).with(EAST, true).with(WEST, state.get(WEST)).with(EXTRACT, state.get(EXTRACT)).with(INSERT, state.get(INSERT))) {
            W = Block.createCuboidShape(0, 5, 5, 5, 11, 11);

        } else {
            W = CENTER;
        }

        if (world.getBlockState(pos.east(1)) == TBBlocks.ITEM_PIPE.getDefaultState().with(DOWN, state.get(DOWN)).with(UP, state.get(UP)).with(NORTH, state.get(NORTH)).with(SOUTH, state.get(SOUTH)).with(EAST, state.get(EAST)).with(WEST, true).with(EXTRACT, state.get(EXTRACT)).with(INSERT, state.get(INSERT))) {
            E = Block.createCuboidShape(5, 5, 5, 11, 11, 11);

        } else {
            E = CENTER;
        }
    }
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof ItemPipeEntity && be.getWorld() != null) {
            ItemPipeEntity.updatenbt(be, pos);
        }
        world.getBlockTickScheduler().schedule(pos, this, 2);
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(EXTRACT, INSERT, UP, DOWN, NORTH, SOUTH, EAST, WEST);
    }
    public VoxelShape COMBINED;

    /*private static Direction getFacing(BlockState state) {
        Direction direction = state.get(FACING);
        return direction.rotateYClockwise();
    @
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {

        switch (getFacing(state)) {
            case NORTH:
                //
            case SOUTH:
            case EAST:
            case WEST:
        }
    } */

    public VoxelShape COMBINED_RAYCAST;

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    /*
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof ItemPipeEntity && be.getWorld() != null) {
            ItemPipeEntity.updatenbt(be, pos);
        }
        if (be instanceof ItemPipeEntity && MinecraftClient.getInstance().crosshairTarget != null && be.getWorld() != null) {
           /*double X = MinecraftClient.getInstance().crosshairTarget.getPos().getX() - (pos.getX());
            double Y = MinecraftClient.getInstance().crosshairTarget.getPos().getY() - (pos.getY());
            double Z = MinecraftClient.getInstance().crosshairTarget.getPos().getZ() - (pos.getZ());
            Y = Y + Math.floor(-Y + Y * 2);
            if (X > 1 || X < 0) {
                X = X - Math.floor(X);
            }
            if (Y > 1 || Y < 0) {
                Y = Y - Math.floor(Y);
            }
            if (Z > 1 || Z < 0) {
                Z = Z - Math.floor(Z);
            }

            if (X >= 1) {
                X = X + 0.001;
            } else if (X <= 0) {
                X = X - 0.001;
            }
            if (Y >= 1) {
                Y = Y + 0.001;
            } else if (Y <= 0) {
                Y = Y - 0.001;
            }
            if (Z >= 1) {
                Z = Z + 0.001;
            } else if (Z <= 0) {
                Z = Z - 0.001;
            }
            System.out.println(X + " " + Y + " " + Z);
            // System.out.println(ItemPipeEntity.NORTH);
            if ((Z <= 0.6875D && Z >= 0.3125D) && (Y <= 0.6875D && Y >= 0.3125D) ) {
                if (X > 0.6875D) {
                    if (ItemPipeEntity.EAST) {
                        COMBINED = Block.createCuboidShape(11, 5, 5, 16, 11, 11);
                        }
                } else if (X < 0.3125D) {
                    if (ItemPipeEntity.WEST) {
                        COMBINED = Block.createCuboidShape(0, 5, 5, 5, 11, 11);
                    }
                } else {
                    return COMBINED_RAYCAST;
                }
            } else if ((X <= 0.6875D && X >= 0.3125D) && (Y <= 0.6875D && Y >= 0.3125D) )  {
                if (Z > 0.6875D) {
                    if (ItemPipeEntity.SOUTH) {
                        COMBINED = Block.createCuboidShape(5, 5, 11, 11, 11, 16);
                    }
                } if (Z < 0.3125D) {
                    if (ItemPipeEntity.NORTH) {
                        COMBINED = Block.createCuboidShape(5, 5, 0, 11, 11, 5);
                    }
                } else {
                    return COMBINED_RAYCAST;
                }
            } else if ((X >= 0.3125D && X <= 0.6875D) && (Z >= 0.3125D && Z <= 0.6875D)) {
                if (Y > 0.6875D) {
                    if (ItemPipeEntity.UP) {
                        COMBINED = Block.createCuboidShape(5, 11, 5, 11, 16, 11);
                    }
                } if (Y < 0.3125D) {
                    if (ItemPipeEntity.DOWN) {
                        COMBINED = Block.createCuboidShape(5, 0, 5, 11, 5, 11);
                    }
                } else {
                    return COMBINED_RAYCAST;
                }
            } else if ((X >= 0.3125D && X <= 0.6875D) && (Y >= 0.3125D && Y <= 0.6875D) && (Z >= 0.3125D && Z <= 0.6875D)) {
                return COMBINED_RAYCAST;
            }
        } else {
            COMBINED = CENTER;
        }*/
        return CENTER;
    }

    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        BlockEntity be = world.getBlockEntity(pos);
        if (ItemPipeEntity.UP) {
            U = Block.createCuboidShape(5, 11, 5, 11, 16, 11);

        } else {
            U = CENTER;
        }
        if (ItemPipeEntity.DOWN) {
            D = Block.createCuboidShape(5, 0, 5, 11, 5, 11);

        } else {
            D = CENTER;
        }

        if (ItemPipeEntity.NORTH) {
            N = Block.createCuboidShape(5, 5, 0, 11, 11, 5);


        } else {
            N = CENTER;
        }

        if (ItemPipeEntity.SOUTH) {
            S = Block.createCuboidShape(5, 5, 11, 11, 11, 16);
        } else {

            S = CENTER;
        }

        if (ItemPipeEntity.WEST) {
            W = Block.createCuboidShape(0, 5, 5, 5, 11, 11);

        } else {
            W = CENTER;
        }

        if (ItemPipeEntity.EAST) {
            E = Block.createCuboidShape(11, 5, 5, 16, 11, 11);

        } else {
            E = CENTER;
        }
        COMBINED_RAYCAST = VoxelShapes.combineAndSimplify(CENTER, VoxelShapes.union(U, D, N, S, E, W), BooleanBiFunction.OR);
        if (be instanceof ItemPipeEntity && MinecraftClient.getInstance().crosshairTarget != null && be.getWorld() != null) {
            return COMBINED_RAYCAST;
        } else {
            return full;
        }


    }
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {

        return CENTER;
    }
        static {
        NORTH = BooleanProperty.of("north");
        EAST = BooleanProperty.of("east");
        SOUTH = BooleanProperty.of("south");
        WEST = BooleanProperty.of("west");
        UP = BooleanProperty.of("up");
        DOWN = BooleanProperty.of("down");
        FACING_PROPERTIES = Util.make(Maps.newEnumMap(Direction.class), (enumMap) -> {
            enumMap.put(Direction.NORTH, NORTH);
            enumMap.put(Direction.EAST, EAST);
            enumMap.put(Direction.SOUTH, SOUTH);
            enumMap.put(Direction.WEST, WEST);
            enumMap.put(Direction.UP, UP);
            enumMap.put(Direction.DOWN, DOWN);
        });
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new ItemPipeEntity();
    }
}
