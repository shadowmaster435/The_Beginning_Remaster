package shadowmaster435.the_beginning.blockentity.multiblock;

import shadowmaster435.the_beginning.blockentity.GenericMultiblockEntity;

public class TestMultiblockEntity extends GenericMultiblockEntity {
   /* BlockEntity entity = new TestMultiblockEntity();
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putBoolean("center", Multiblocktest.center);

        return tag;
    }

    public void fromTag(BlockState state, CompoundTag tag) {

        for(int i = 0; i < 4; ++i) {
            String string = tag.getString("Text" + (i + 1));
            Text text = Text.Serializer.fromJson(string.isEmpty() ? "\"\"" : string);
            if (this.world instanceof ServerWorld) {
                try {
                    this.text[i] = Texts.parse(this.getCommandSource((ServerPlayerEntity)null), text, (Entity)null, 0);
                } catch (CommandSyntaxException var7) {
                    this.text[i] = text;
                }
            } else {
                this.text[i] = text;
            }

            this.textBeingEdited[i] = null;
        }

    }
    b
 */
}
