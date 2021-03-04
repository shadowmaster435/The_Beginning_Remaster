package shadowmaster435.the_beginning.blockentity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.Direction;
import shadowmaster435.the_beginning.registry.TBBlocks;

public class portalentity extends BlockEntity {
    public portalentity() {
        super(TBBlocks.PORTAL_ENTITY);
    }


    @Environment(EnvType.CLIENT)
    public boolean shouldDrawSide(Direction direction) {
        return direction == Direction.UP;
    }
}
