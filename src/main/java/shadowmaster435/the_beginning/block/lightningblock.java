package shadowmaster435.the_beginning.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import shadowmaster435.the_beginning.blockentity.lightningentity;

public class lightningblock extends Block implements BlockEntityProvider {
    public lightningblock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new lightningentity();
    }


}
