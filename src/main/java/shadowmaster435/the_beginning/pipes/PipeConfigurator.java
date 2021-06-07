package shadowmaster435.the_beginning.pipes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import shadowmaster435.the_beginning.block.ItemPipe;

public class PipeConfigurator extends Item {

    public PipeConfigurator(Settings settings) {
        super(settings);
    }
    public static ItemPipe pipe;
    public static String mode = "wrench";
    public static boolean firstpos = false;
    public static int x;
    public static int y;
    public static int z;
    public static int x2;
    public static int y2;
    public static int z2;
    public static int fx;
    public static int fy;
    public static int fz;
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        Block block = world.getBlockState(BlockPos.ORIGIN).getBlock();

        ItemStack wrench = playerEntity.getStackInHand(hand);
        CompoundTag compoundTag = wrench.getOrCreateTag();
        compoundTag.putString("wrench", mode);
        BlockEntity entity = world.getBlockEntity(BlockPos.ORIGIN);
        if (world.getBlockState(BlockPos.ORIGIN).getBlock() == block && entity != null) {
            if (compoundTag.contains("wrench")) {
                if (firstpos) {
                    x = entity.getPos().getX();
                    y = entity.getPos().getY();
                    z = entity.getPos().getZ();
                    compoundTag.putInt("x", x);
                    compoundTag.putInt("y", y);
                    compoundTag.putInt("z", z);
                    firstpos = false;
                } else {
                    x = entity.getPos().getX();
                    y = entity.getPos().getY();
                    z = entity.getPos().getZ();
                    fx = x - x2;
                    fy = y - y2;
                    fz = z - z2;
                    compoundTag.putInt("x2", x2);
                    compoundTag.putInt("y2", y2);
                    compoundTag.putInt("z2", z2);
                    firstpos = true;
                }
            }
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }
}