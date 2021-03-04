package shadowmaster435.the_beginning.blockentity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;
import shadowmaster435.the_beginning.gui.handler.ProgressTestScreen;
import shadowmaster435.the_beginning.registry.TBBlocks;
import shadowmaster435.the_beginning.util.ImplementedInventory;

public class ProgressEntity extends BlockEntity implements Tickable, ExtendedScreenHandlerFactory, ImplementedInventory {
    public static int Time;
    private static int TimeTotal;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(0, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;

    public ProgressEntity() {
        super(TBBlocks.PROGRESS_ENTITY);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                if (index == 1) {
                    return TimeTotal;
                }
                return Time;
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        Time = value;
                    case 1:
                        TimeTotal = value;
                }
            }

            public int size() {
                return 2;
            }
        };
    }
    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
    public void tick() {
        --Time;
        if (Time <= 0) {
            Time = 200;
        }
    }
    protected int getTime() {
        return 200;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        Time = tag.getShort("CookTime");
        TimeTotal = tag.getShort("CookTimeTotal");
        Inventories.fromTag(tag,inventory);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        Inventories.toTag(tag,inventory);
        tag.putShort("CookTime", (short) Time);
        tag.putShort("CookTimeTotal", (short) TimeTotal);
        return super.toTag(tag);
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ProgressTestScreen(syncId, playerInventory, this);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }


    @Override
    public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
        //The pos field is a public field from BlockEntity
        packetByteBuf.writeBlockPos(pos);
    }
}
