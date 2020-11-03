package the_beginning_remaster.the_beginning.blockentity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.Direction;
import the_beginning_remaster.the_beginning.The_beginning;

public class portalentity extends BlockEntity {
    public portalentity() {
        super(The_beginning.PORTAL_ENTITY);
    }


    @Environment(EnvType.CLIENT)
    public boolean shouldDrawSide(Direction direction) {
        return direction == Direction.UP;
    }
}
