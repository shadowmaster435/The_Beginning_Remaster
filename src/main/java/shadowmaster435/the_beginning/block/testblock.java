package shadowmaster435.the_beginning.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import shadowmaster435.the_beginning.blockentity.animationtest;
import shadowmaster435.the_beginning.gravity.PlayerGravity;

import java.util.Random;

public class testblock extends Block implements BlockEntityProvider {
    public testblock(Settings settings) {
        super(settings);
    }
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.getBlockTickScheduler().schedule(pos, this, 2);
    }
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.getBlockTickScheduler().schedule(pos, this, 2);
        PlayerEntity playercontroller = MinecraftClient.getInstance().player;
        if (playercontroller != null) {
            if (playercontroller.getPos().squaredDistanceTo(new Vec3d(BlockPos.ORIGIN.getX(), BlockPos.ORIGIN.getY(), BlockPos.ORIGIN.getZ())) < 300) {
                PlayerGravity.BlockX = BlockPos.ORIGIN.getX();
                PlayerGravity.BlockY = BlockPos.ORIGIN.getY();
                PlayerGravity.BlockZ = BlockPos.ORIGIN.getZ();
                PlayerGravity.InGravField = true;
                System.out.println(PlayerGravity.VelX + ":" + PlayerGravity.VelY + ":" + PlayerGravity.VelZ);
            } else {
                PlayerGravity.BlockX = PlayerGravity.PlayerX;
                PlayerGravity.BlockY = PlayerGravity.PlayerY;
                PlayerGravity.BlockZ = PlayerGravity.PlayerZ;
                PlayerGravity.InGravField = false;
               }
            System.out.println(playercontroller.getPos().squaredDistanceTo(new Vec3d(BlockPos.ORIGIN.getX(), BlockPos.ORIGIN.getY(), BlockPos.ORIGIN.getZ())));

        }
    }
    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new animationtest();
    }
    //public CompoundTag tag;
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {


        return ActionResult.SUCCESS;
    }
}