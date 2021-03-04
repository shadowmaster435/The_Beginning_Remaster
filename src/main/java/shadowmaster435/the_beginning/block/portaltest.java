package shadowmaster435.the_beginning.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import shadowmaster435.the_beginning.blockentity.portalentity;

public class portaltest extends Block implements BlockEntityProvider {
    public portaltest(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new portalentity();
    }


}
