package shadowmaster435.the_beginning.util;

import net.minecraft.util.math.Direction;

import java.util.HashMap;

public class MiscUtil {
    @Deprecated
    public static int hashToInt(HashMap<Direction, Boolean> hash) {
        boolean[] array = new boolean[]{
                hash.get(Direction.NORTH),
                hash.get(Direction.WEST),
                hash.get(Direction.EAST),
                hash.get(Direction.UP),
                hash.get(Direction.DOWN),
                hash.get(Direction.SOUTH)};
        return booleansToInt(array);
    }
    public static boolean[] intsToBoolean(int n, int size) {
        boolean[] result = new boolean[size];
        for (int i = size - 1, c = 1 << i; i >= 0; c = 1 << --i) {
            result[i] = n >= c;
            n = n >= c ? n - c : n;
        }
        return result;
    }
    @Deprecated
    public static HashMap<Direction, Boolean> intToHash(int n) {
        boolean[] array = intsToBoolean(n, 6);
        HashMap<Direction, Boolean> result = new HashMap<>();
        result.put(Direction.NORTH, array[0]);
        result.put(Direction.WEST, array[1]);
        result.put(Direction.EAST, array[2]);
        result.put(Direction.UP, array[3]);
        result.put(Direction.DOWN, array[4]);
        result.put(Direction.SOUTH, array[5]);
        return result;
    }
    public static int booleansToInt(boolean[] arr) {
        int n = 0;
        for (int i = -1; i < arr.length - 1; n += arr[++i] ? 1 << i : 0) ;
        return n;
    }
}
