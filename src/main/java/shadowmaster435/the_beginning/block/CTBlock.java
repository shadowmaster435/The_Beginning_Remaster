package shadowmaster435.the_beginning.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import shadowmaster435.the_beginning.blockentity.ConnectingTexture;

public class CTBlock extends Block {

    public CTBlock(Settings settings) {
        super(settings);
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        updateNeighbors(state, world, pos);
    }


    public static int up1;
    public static int up2;
    public static int up3;
    public static int up4;
    public static int down1;
    public static int down2;
    public static int down3;
    public static int down4;
    public static int north1;
    public static int north2;
    public static int north3;
    public static int north4;
    public static int south1;
    public static int south2;
    public static int south3;
    public static int south4;
    public static int east1;
    public static int east2;
    public static int east3;
    public static int east4;
    public static int west1;
    public static int west2;
    public static int west3;
    public static int west4;
    public static int normal = 0;
    public ConnectingTexture bakemodel;



    public static Block block;
    public void updateNeighbors(BlockState state, World world, BlockPos pos) {
        BlockState u = world.getBlockState(pos.up());
        BlockState d = world.getBlockState(pos.down());
        BlockState n = world.getBlockState(pos.north());
        BlockState s = world.getBlockState(pos.south());
        BlockState e = world.getBlockState(pos.east());
        BlockState w = world.getBlockState(pos.west());
        BlockState un = world.getBlockState(pos.crossProduct(new Vec3i(0, 1, -1)));
        BlockState us = world.getBlockState(pos.crossProduct(new Vec3i(0, 1, 1)));
        BlockState ue = world.getBlockState(pos.crossProduct(new Vec3i(1, 1, 0)));
        BlockState uw = world.getBlockState(pos.crossProduct(new Vec3i(-1, 1, 0)));
        BlockState dn = world.getBlockState(pos.crossProduct(new Vec3i(0, -1, -1)));
        BlockState ds = world.getBlockState(pos.crossProduct(new Vec3i(0, -1, 1)));
        BlockState de = world.getBlockState(pos.crossProduct(new Vec3i(1, -1, 0)));
        BlockState dw = world.getBlockState(pos.crossProduct(new Vec3i(-1, -1, 0)));
        BlockState ne = world.getBlockState(pos.crossProduct(new Vec3i(1, 0, -1)));
        BlockState ns = world.getBlockState(pos.crossProduct(new Vec3i(-1, 0, -1)));
        BlockState se = world.getBlockState(pos.crossProduct(new Vec3i(1, 0, 1)));
        BlockState sw = world.getBlockState(pos.crossProduct(new Vec3i(-1, 0, 1)));
        Block up = u.getBlock();
        Block down = d.getBlock();
        Block north = n.getBlock();
        Block south = s.getBlock();
        Block east = e.getBlock();
        Block west = w.getBlock();
        Block upnorth = un.getBlock();
        Block upsouth = us.getBlock();
        Block upeast = ue.getBlock();
        Block upwest = uw.getBlock();
        Block downnorth = dn.getBlock();
        Block downsouth = ds.getBlock();
        Block downeast = de.getBlock();
        Block downwest = dw.getBlock();
        Block northeast = ne.getBlock();
        Block northwest = ns.getBlock();
        Block southeast = se.getBlock();
        Block southwest = sw.getBlock();

        if (up == block) {
            world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(0, 1, 0)), this, 1);
            if (upnorth == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(0, 1, -1)), this, 1);
            } else if (upsouth == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(0, 1, 1)), this, 1);
            } else if (upeast == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(1, 1, 0)), this, 1);
            } else if (upwest == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(-1, 1, 0)), this, 1);
            }
        } else if (down == block) {
            world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(0, -1, 0)), this, 1);
            if (downnorth == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(0, -1, -1)), this, 1);
            } else if (downsouth == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(0, -1, 1)), this, 1);
            } else if (downeast == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(1, -1, 0)), this, 1);
            } else if (downwest == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(-1, -1, 0)), this, 1);
            }
        } else if (north == block) {
            world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(0, 0, -1)), this, 1);
            if (upnorth == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(0, 1, -1)), this, 1);
            } else if (downnorth == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(-1, 0, -1)), this, 1);
            } else if (northeast == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(1, 0, -1)), this, 1);
            } else if (northwest == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(-1, 0, -1)), this, 1);
            }
        } else if (south == block) {
            world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(0, 0, 1)), this, 1);
            if (upsouth == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(0, 1, 1)), this, 1);
            } else if (downsouth == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(0, -1, 1)), this, 1);
            } else if (southeast == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(1, 0, 1)), this, 1);
            } else if (southwest == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(-1, 0, 1)), this, 1);
            }
        } else if (east == block) {
            world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(1, 0, 0)), this, 1);
            if (upeast == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(1, 1, 0)), this, 1);
            } else if (downeast == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(1, -1, 0)), this, 1);
            } else if (northeast == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(1, 0, 1)), this, 1);
            } else if (southeast == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(1, 0, -1)), this, 1);
            }
        } else if (west == block) {
            world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(-1, 0, 0)), this, 1);
            if (upwest == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(-1, 1, 0)), this, 1);
            } else if (downwest == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(-1, -1, 0)), this, 1);
            } else if (northwest == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(-1, 0, 1)), this, 1);
            } else if (southwest == block) {
                world.getBlockTickScheduler().schedule(pos.crossProduct(new Vec3i(-1, 0, -1)), this, 1);
            }
        }
    }
}
