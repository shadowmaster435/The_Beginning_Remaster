package shadowmaster435.the_beginning.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;
import shadowmaster435.the_beginning.registry.TBBlocks;
import shadowmaster435.the_beginning.util.ImplementedInventory;

public class GenericMultiblockEntity extends BlockEntity implements ImplementedInventory {
    public int size;
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(size, ItemStack.EMPTY);

    public GenericMultiblockEntity() {
        super(TBBlocks.GENERIC_MULTIBLOCK_ENTITY);
    }


    //These Methods are from the NamedScreenHandlerFactory Interface
    //createMenu creates the ScreenHandler itself
    //getDisplayName will Provide its name which is normally shown at the top



    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
    public static int invsize;
    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        inventory = DefaultedList.ofSize(invsize, ItemStack.EMPTY);
        Inventories.fromTag(tag, this.inventory);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        Inventories.toTag(tag, this.inventory);
        return tag;
    }
}
