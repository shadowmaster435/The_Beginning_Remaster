package shadowmaster435.the_beginning.gui.handler;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import shadowmaster435.the_beginning.registry.TBGuis;

public class ProgressTestScreen extends ScreenHandler {
    //We save the blockPos we got from the Server and provide a getter for it so the BoxScreen can read that information
    private BlockPos pos;
    private final Inventory inventory;

    //This constructor gets called on the client when the server wants it to open the screenHandler,
    //The client will call the super constructor with an empty Inventory and the screenHandler will automatically
    //sync this empty inventory with the inventory on the server

    //NEW: The constructor of the client now gets the PacketByteBuf we filled in the BlockEntity
    public ProgressTestScreen(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, new SimpleInventory(1));
        pos = buf.readBlockPos();
    }

    //This constructor gets called from the BlockEntity on the server, the server knows the inventory of the container
    //and can therefore directly provide it as an argument. This inventory will then be synced to the Client
    public ProgressTestScreen(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(TBGuis.PROGRESS_TEST_SCREEN_SCREEN_HANDLER_TYPE, syncId);
        pos = BlockPos.ORIGIN;

        this.inventory = inventory;
    }

    //this getter will be used by our Screen class
    public BlockPos getPos() {
        return pos;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
    public static PropertyDelegate delegate;
    @Environment(EnvType.CLIENT)
    public int getCookProgress() {
        int i = delegate.get(0);
        int j = delegate.get(1);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }
    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        return null;
    }
}