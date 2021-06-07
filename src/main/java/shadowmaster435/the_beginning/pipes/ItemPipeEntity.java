package shadowmaster435.the_beginning.pipes;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import shadowmaster435.the_beginning.block.ItemPipe;
import shadowmaster435.the_beginning.registry.TBBlocks;
import shadowmaster435.the_beginning.util.ImplementedInventory;
import shadowmaster435.the_beginning.util.MiscUtil;

import java.util.HashMap;

public class ItemPipeEntity extends BlockEntity implements ImplementedInventory, SidedInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static boolean UP;
    public static boolean DOWN;
    public static boolean NORTH;
    public static boolean SOUTH;
    public static boolean EAST;
    public static boolean WEST;
    public HashMap<Direction, Boolean> wrenched;
    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }
    public ItemPipeEntity() {
        super(TBBlocks.ITEM_PIPE_ENTITY);
        wrenched = new HashMap<>();
        for (Direction dir : Direction.values())
            wrenched.put(dir, false);
    }

    public PipeSide getSide(Direction d) {
        if (world == null)
            return null;
        BlockState state = world.getBlockState(pos);
        if (!(state.getBlock() instanceof ItemPipe))
            return null;
        return state.get(ItemPipe.getProperty(d));
    }
    public CompoundTag toTag(CompoundTag tag) {
        tag.putInt("wrenched", MiscUtil.hashToInt(wrenched));
        return super.toTag(tag);
    }
    @Override
    public void fromTag(BlockState state, CompoundTag tag) {

        this.wrenched = MiscUtil.intToHash(tag.getInt("wrenched"));
        super.fromTag(state, tag);
    }

    @Override
    public int[] getAvailableSlots(Direction var1) {
        // Just return an array of all slots
        int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    public static void updatenbt(BlockEntity entity, BlockPos pos) {

        if (entity.getWorld() != null) {
            UP = entity.getWorld().getBlockState(pos.up()).getBlock() == TBBlocks.ITEM_PIPE.getDefaultState().getBlock();
            DOWN = entity.getWorld().getBlockState(pos.down()).getBlock() == TBBlocks.ITEM_PIPE.getDefaultState().getBlock();
            NORTH = entity.getWorld().getBlockState(pos.north()).getBlock() == TBBlocks.ITEM_PIPE.getDefaultState().getBlock();
            SOUTH = entity.getWorld().getBlockState(pos.south()).getBlock() == TBBlocks.ITEM_PIPE.getDefaultState().getBlock();
            EAST = entity.getWorld().getBlockState(pos.east()).getBlock() == TBBlocks.ITEM_PIPE.getDefaultState().getBlock();
            WEST = entity.getWorld().getBlockState(pos.west()).getBlock() == TBBlocks.ITEM_PIPE.getDefaultState().getBlock();
        }
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction direction) {

        return direction != Direction.UP;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction direction) {
        return true;
    }
}
