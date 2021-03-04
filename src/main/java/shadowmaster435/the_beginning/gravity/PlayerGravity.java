package shadowmaster435.the_beginning.gravity;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class PlayerGravity {
    public static double PlayerX;
    public static double PlayerY;
    public static double PlayerZ;
    public static double BlockX;
    public static double BlockY;
    public static double BlockZ;
    public static double VelX;
    public static double VelY;
    public static double VelZ;
    public static boolean InGravField;
    public static Vec3i PlayerVec;
    public static void GravUtil() {
        if (MinecraftClient.getInstance().player != null) {
            PlayerX = MinecraftClient.getInstance().player.getX();
            PlayerY = MinecraftClient.getInstance().player.getY();
            PlayerZ = MinecraftClient.getInstance().player.getZ();
            PlayerVec = new Vec3i(PlayerX, PlayerY, PlayerZ);

            if (InGravField) {
                /*VelX = Math.log((PlayerX - BlockX));
                VelY = Math.log((PlayerX - BlockY));
                VelZ = Math.log((PlayerZ - BlockZ));*/
                if (BlockX > PlayerX) {
                    VelX = (VelX) * -1;
                } else {
                    VelX = Math.abs(VelX);
                }

                if (BlockY > PlayerY) {
                    VelY = VelY * -1;
                } else {
                    VelY = Math.abs(VelY);
                }

                if (BlockZ > PlayerZ) {
                    VelZ = VelZ * -1;
                } else {
                    VelZ = Math.abs(VelZ);
                }
                MinecraftClient.getInstance().player.setVelocity(new Vec3d(VelX, VelY, VelZ));
            }
        }
    }
}