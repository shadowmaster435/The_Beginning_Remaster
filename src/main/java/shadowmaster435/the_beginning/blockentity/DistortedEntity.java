package shadowmaster435.the_beginning.blockentity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.Direction;

public class DistortedEntity extends BlockEntity {
    public DistortedEntity(BlockEntityType<?> type) {
        super(type);
    }

    @Environment(EnvType.CLIENT)
    public boolean shouldDrawSide(Direction direction) {
        assert this.world != null;
        return Block.shouldDrawSide(this.getCachedState(), this.world, this.getPos(), direction);
    }
}
