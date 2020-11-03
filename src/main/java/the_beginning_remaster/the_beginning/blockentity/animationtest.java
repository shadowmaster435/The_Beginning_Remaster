package the_beginning_remaster.the_beginning.blockentity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import the_beginning_remaster.the_beginning.The_beginning;

public class animationtest extends BlockEntity {
    public animationtest() {
        super(The_beginning.DEMO_BLOCK_ENTITY);
    }
    // Store the current value of the number
    public boolean currentanim = false;

    // Serialize the BlockEntity
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);

        // Save the current value of the number to the tag
        tag.putBoolean("currentanim", currentanim);

        return tag;
    }
}