package shadowmaster435.the_beginning.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import shadowmaster435.the_beginning.pipes.ItemPipeEntity;
import shadowmaster435.the_beginning.pipes.PipeSide;

public class ItemPipe extends Block implements BlockEntityProvider{
    public static final EnumProperty<PipeSide> UP;
    public static final EnumProperty<PipeSide> DOWN;
    public static final EnumProperty<PipeSide> NORTH;
    public static final EnumProperty<PipeSide> SOUTH;
    public static final EnumProperty<PipeSide> EAST;
    public static final EnumProperty<PipeSide> WEST;
    private static final VoxelShape NODE;
    private static final VoxelShape C_UP;
    private static final VoxelShape C_DOWN;
    private static final VoxelShape C_EAST;
    private static final VoxelShape C_WEST;
    private static final VoxelShape C_NORTH;
    private static final VoxelShape C_SOUTH;
    private static final VoxelShape S_UP;
    private static final VoxelShape S_DOWN;
    private static final VoxelShape S_EAST;
    private static final VoxelShape S_WEST;
    private static final VoxelShape S_NORTH;
    private static final VoxelShape S_SOUTH;

    static {
        UP = EnumProperty.of("up", PipeSide.class);
        DOWN = EnumProperty.of("down", PipeSide.class);
        NORTH = EnumProperty.of("north", PipeSide.class);
        SOUTH = EnumProperty.of("south", PipeSide.class);
        EAST = EnumProperty.of("east", PipeSide.class);
        WEST = EnumProperty.of("west", PipeSide.class);

        NODE = Block.createCuboidShape(5, 5, 5, 11, 11, 11);
        C_DOWN = Block.createCuboidShape(5, 0, 5, 11, 5, 11);
        C_UP = Block.createCuboidShape(5, 11, 5, 11, 16, 11);
        C_EAST = Block.createCuboidShape(11, 5, 5, 16, 11, 11);
        C_WEST = Block.createCuboidShape(0, 5, 5, 5, 11, 11);
        C_NORTH = Block.createCuboidShape(5, 5, 0, 11, 11, 5);
        C_SOUTH = Block.createCuboidShape(5, 5, 11, 11, 11, 16);
        S_UP = Block.createCuboidShape(4, 14, 4, 13, 16, 13);
        S_DOWN = Block.createCuboidShape(4, 0, 4, 13, 2, 13);
        S_EAST = Block.createCuboidShape(14, 4, 4, 16, 13, 13);
        S_WEST = Block.createCuboidShape(0, 4, 4, 2, 13, 13);
        S_NORTH = Block.createCuboidShape(4, 4, 0, 13, 13, 2);
        S_SOUTH = Block.createCuboidShape(4, 4, 14, 13, 13, 16);
    }



    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = getDefaultState();
        BlockPos blockPos = ctx.getBlockPos();
        for (Direction direction : Direction.values()) {
            BlockState neighborState = ctx.getWorld().getBlockState(blockPos.offset(direction));
            Block neighbor = neighborState.getBlock();

            if (neighbor instanceof ItemPipe && !isWrenched(ctx.getWorld(), blockPos.offset(direction), direction.getOpposite()))
                state = state.with(getProperty(direction), PipeSide.NONE);
            else
                state = state.with(getProperty(direction), isConnectable(neighbor, ctx.getWorld().getBlockEntity(blockPos.offset(direction))) ? PipeSide.CONNECTED : PipeSide.NONE);

        }
        return state;
    }


    public static boolean success;

    public static float x2;
    public static float y2;
    public static float z2;
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockState state2 = world.getBlockState(BlockPos.ORIGIN);
        MinecraftClient instance = MinecraftClient.getInstance();
        if (instance != null && instance.player != null) {
            Vec3d vec3d = instance.player.raycast(player.limbDistance, instance.getTickDelta(), false).getPos();
            double x = vec3d.x;
            double y = vec3d.y;
            double z = vec3d.z;
            x = x - Math.floor(x);
            y = y - Math.floor(y);
            z = z - Math.floor(z);
            if (state2.getBlock() instanceof ItemPipe) {
                if (y <= 0.3125 && world.getBlockState(pos.offset(Direction.UP)).getBlock() instanceof ItemPipe) {
                    if (state2 == state.with(DOWN, PipeSide.CONNECTED )) {
                        world.setBlockState(pos.offset(Direction.DOWN), state2.with(UP, PipeSide.NONE));
                        world.setBlockState(BlockPos.ORIGIN, state2.with(DOWN, PipeSide.NONE));
                    } else {
                        world.setBlockState(pos.offset(Direction.DOWN), state2.with(UP, PipeSide.CONNECTED));
                        world.setBlockState(BlockPos.ORIGIN, state2.with(DOWN, PipeSide.CONNECTED));
                    }
                } else if (y >= 0.6875 && world.getBlockState(pos.offset(Direction.DOWN)).getBlock() instanceof ItemPipe) {
                    if (state2 == state.with(UP, PipeSide.CONNECTED)) {
                        world.setBlockState(pos.offset(Direction.UP), state2.with(DOWN, PipeSide.NONE));
                        world.setBlockState(BlockPos.ORIGIN, state2.with(UP, PipeSide.NONE));
                    } else {
                        world.setBlockState(pos.offset(Direction.UP), state2.with(DOWN, PipeSide.CONNECTED));
                        world.setBlockState(BlockPos.ORIGIN, state2.with(UP, PipeSide.CONNECTED));
                    }
                } else if (y >= 0.3125 && y <= 0.6875) {
                    if (x >= 0.6875 && world.getBlockState(pos.offset(Direction.EAST)).getBlock() instanceof ItemPipe) {
                        if (state2 == state.with(EAST, PipeSide.CONNECTED)) {
                            world.setBlockState(pos.offset(Direction.EAST), state2.with(WEST, PipeSide.NONE));
                            world.setBlockState(BlockPos.ORIGIN, state2.with(EAST, PipeSide.NONE));
                        } else {
                            world.setBlockState(pos.offset(Direction.EAST), state2.with(WEST, PipeSide.CONNECTED));
                            world.setBlockState(BlockPos.ORIGIN, state2.with(EAST, PipeSide.CONNECTED));
                        }
                    } else if (x <= 0.3125 && world.getBlockState(pos.offset(Direction.WEST)).getBlock() instanceof ItemPipe) {
                        if (state2 == state.with(WEST, PipeSide.CONNECTED)) {
                            world.setBlockState(pos.offset(Direction.WEST), state2.with(EAST, PipeSide.NONE));
                            world.setBlockState(BlockPos.ORIGIN, state2.with(WEST, PipeSide.NONE));
                        } else {
                            world.setBlockState(pos.offset(Direction.WEST), state2.with(EAST, PipeSide.CONNECTED));
                            world.setBlockState(BlockPos.ORIGIN, state2.with(WEST, PipeSide.CONNECTED));
                        }
                    } else if (z >= 0.6875 && world.getBlockState(pos.offset(Direction.SOUTH)).getBlock() instanceof ItemPipe) {
                        if (state2 == state.with(SOUTH, PipeSide.CONNECTED)) {
                            world.setBlockState(pos.offset(Direction.SOUTH), state2.with(NORTH, PipeSide.NONE));
                            world.setBlockState(BlockPos.ORIGIN, state2.with(SOUTH, PipeSide.NONE));
                        } else {
                            world.setBlockState(pos.offset(Direction.SOUTH), state2.with(NORTH, PipeSide.CONNECTED));
                            world.setBlockState(BlockPos.ORIGIN, state2.with(SOUTH, PipeSide.CONNECTED));
                        }
                    } else if (z <= 0.3125 && world.getBlockState(pos.offset(Direction.NORTH)).getBlock() instanceof ItemPipe) {
                        if (state2 == state.with(NORTH, PipeSide.CONNECTED)) {
                            world.setBlockState(pos.offset(Direction.NORTH), state2.with(SOUTH, PipeSide.NONE));
                            world.setBlockState(BlockPos.ORIGIN, state2.with(NORTH, PipeSide.NONE));
                        } else {
                            world.setBlockState(pos.offset(Direction.NORTH), state2.with(SOUTH, PipeSide.CONNECTED));
                            world.setBlockState(BlockPos.ORIGIN, state2.with(NORTH, PipeSide.CONNECTED));
                        }
                    }
                }
            }
            System.out.println("X: " + x + " Y: " + y + " Z: " + z);

        }
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }
    public static float x;
    public static float y;
    public static float z;


    private boolean isConnectable(Block block, BlockEntity entity) {
        return (block instanceof ItemPipe || entity instanceof Inventory && ((Inventory) entity).size() > 0);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        super.onStateReplaced(state, world, pos, newState, moved);
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {

        if (world.isClient())
            return state;

        Block neighbor = world.getBlockState(posFrom).getBlock();
        if (state.get(getProperty(direction)) == PipeSide.SERVO || isWrenched(world, pos, direction))
            return state;

        if (neighbor instanceof ItemPipe && isWrenched(world, posFrom, direction.getOpposite())) {
            return state;
        }

        return state.with(getProperty(direction), isConnectable(neighbor, world.getBlockEntity(posFrom)) ? PipeSide.CONNECTED : PipeSide.NONE);
    }
    private void openScreen(World world, BlockPos pos, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof ItemPipeEntity) {
            boolean bl = false;
            BlockState state = world.getBlockState(pos);
            for (Direction dir : Direction.values()) {
                if (state.get(getProperty(dir)) == PipeSide.SERVO)
                    bl = true;
            }

            if (bl)
                player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);
        }


    }
    private boolean isWrenched(WorldAccess world, BlockPos pos, Direction d) {
        BlockEntity b = world.getBlockEntity(pos);
        if (!(b instanceof ItemPipeEntity))
            return false;
        return ((ItemPipeEntity) b).wrenched.get(d);
    }
    private void setWrenched(WorldAccess world, BlockPos pos, Direction d, boolean value) {
        BlockEntity b = world.getBlockEntity(pos);
        if (!(b instanceof ItemPipeEntity))
            return;
        ((ItemPipeEntity) b).wrenched.put(d, value);
    }
    public ItemPipe(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(UP, PipeSide.NONE)
                .with(DOWN, PipeSide.NONE)
                .with(NORTH, PipeSide.NONE)
                .with(SOUTH, PipeSide.NONE)
                .with(EAST, PipeSide.NONE)
                .with(WEST, PipeSide.NONE));
    }



    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN, NORTH, SOUTH, EAST, WEST);
    }



    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = NODE;
        if (state.get(UP) != PipeSide.NONE)
            shape = VoxelShapes.combineAndSimplify(shape, C_UP, BooleanBiFunction.OR);
        if (state.get(DOWN) != PipeSide.NONE)
            shape = VoxelShapes.combineAndSimplify(shape, C_DOWN, BooleanBiFunction.OR);
        if (state.get(NORTH) != PipeSide.NONE)
            shape = VoxelShapes.combineAndSimplify(shape, C_NORTH, BooleanBiFunction.OR);
        if (state.get(EAST) != PipeSide.NONE)
            shape = VoxelShapes.combineAndSimplify(shape, C_EAST, BooleanBiFunction.OR);
        if (state.get(SOUTH) != PipeSide.NONE)
            shape = VoxelShapes.combineAndSimplify(shape, C_SOUTH, BooleanBiFunction.OR);
        if (state.get(WEST) != PipeSide.NONE)
            shape = VoxelShapes.combineAndSimplify(shape, C_WEST, BooleanBiFunction.OR);

        if (state.get(UP) == PipeSide.SERVO)
            shape = VoxelShapes.combineAndSimplify(shape, S_UP, BooleanBiFunction.OR);
        if (state.get(DOWN) == PipeSide.SERVO)
            shape = VoxelShapes.combineAndSimplify(shape, S_DOWN, BooleanBiFunction.OR);
        if (state.get(NORTH) == PipeSide.SERVO)
            shape = VoxelShapes.combineAndSimplify(shape, S_NORTH, BooleanBiFunction.OR);
        if (state.get(EAST) == PipeSide.SERVO)
            shape = VoxelShapes.combineAndSimplify(shape, S_EAST, BooleanBiFunction.OR);
        if (state.get(SOUTH) == PipeSide.SERVO)
            shape = VoxelShapes.combineAndSimplify(shape, S_SOUTH, BooleanBiFunction.OR);
        if (state.get(WEST) == PipeSide.SERVO)
            shape = VoxelShapes.combineAndSimplify(shape, S_WEST, BooleanBiFunction.OR);

        return shape;
    }


    public static EnumProperty<PipeSide> getProperty(Direction facing) {

        switch (facing) {
            case UP:
                return UP;
            case DOWN:
                return DOWN;
            case EAST:
                return EAST;
            case WEST:
                return WEST;
            case NORTH:
                return NORTH;
            case SOUTH:
                return SOUTH;
        }
        return null;
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new ItemPipeEntity();
    }
}
