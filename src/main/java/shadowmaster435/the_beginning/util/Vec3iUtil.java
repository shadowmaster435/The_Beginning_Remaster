package shadowmaster435.the_beginning.util;


import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class Vec3iUtil implements StringIdentifiable {


    @Override
    public String asString() {
        return null;
    }

    public enum all {

          up(0, new Vec3i(0f, 1f, 0f)),
          down(1,  new Vec3i(0f, -1f, 0f)),
          north(2,  new Vec3i(0f, 0f, -1f)),
          south(3,  new Vec3i(0f, 0f, 1f)),
          east(4,  new Vec3i(1f, 0f, 0f)),
          west(5,  new Vec3i(-1f, 0f, 0f)),
          upnorth(6,  new Vec3i(0f, 1f, -1f)),
          upsouth(7,  new Vec3i(0f, 1f, 0f)),
          upeast(8,  new Vec3i(0f, 1f, 0f)),
          upwest(9,  new Vec3i(0f, 1f, 0f)),
          downnorth(10,  new Vec3i(0f, -1f, -1f)),
          downsouth(11,  new Vec3i(0f, -1f, 0f)),
          downeast(12,  new Vec3i(0f, -1f, 1f)),
          downwest(13,  new Vec3i(0f,  -1f, 1f)),
          upne(14,  new Vec3i(1f, 1f, -1f)),
          upnw(15,  new Vec3i(-1f, 1f, -1f)),
          upse(16,  new Vec3i(1f, 1f, 1f)),
          upsw(17,  new Vec3i(-1f, 1f, 1f)),
          downne(18,  new Vec3i(1f, -1f, -1f)),
          downnw(19,  new Vec3i(-1f, -1f, -1f)),
          downse(20,  new Vec3i(1f, -1f, 1f)),
          downsw(21,  new Vec3i(-1f, -1f, 1f)),
          ne(22,  new Vec3i(1f, 0f, -1f)),
          nw(23,  new Vec3i(-1f, 0f, -1f)),
          se(24,  new Vec3i(1f, 0f, 1f)),
          sw(25,  new Vec3i(-1f, 0f, 1f));
        private final Vec3i vector;
        public static final Vec3iUtil.all[] ALL = values();
        public static int id;
        public Vec3i getVector() {
            return this.vector;
        }

        public BlockPos blockpos = new BlockPos(getOffsetX(), getOffsetY(), getOffsetZ());
        public BlockPos getPos() {
            return this.blockpos;
        }

         all(int id1, Vec3i vector) {
            this.vector = vector;
        }
        public int getOffsetX() {
            return this.vector.getX();
        }
        
        public int getOffsetY() {
            return this.vector.getY();
        }
        
        public int getOffsetZ() {
            return this.vector.getZ();
        }
    }
    public enum cardinal {

        up(0, new Vec3i(0f, 1f, 0f)),
        down(1,  new Vec3i(0f, -1f, 0f)),
        north(2,  new Vec3i(0f, 0f, -1f)),
        south(3,  new Vec3i(0f, 0f, 1f)),
        east(4,  new Vec3i(1f, 0f, 0f)),
        west(5,  new Vec3i(-1f, 0f, 0f));
        private final Vec3i vector;
        cardinal(int id, Vec3i vector) {
            this.vector = vector;
        }
        public int getOffsetX() {
            return this.vector.getX();
        }

        public int getOffsetY() {
            return this.vector.getY();
        }

        public int getOffsetZ() {
            return this.vector.getZ();
        }
    }
}
