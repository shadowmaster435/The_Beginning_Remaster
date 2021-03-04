package shadowmaster435.the_beginning.item;

import net.minecraft.item.Item;
import shadowmaster435.the_beginning.registry.TBItems;
import shadowmaster435.the_beginning.util.ItemStackGlints;

public class GlintTest extends Item {
    public Item item = TBItems.GLINT_TEST;
    public ItemStackGlints istack;

    public GlintTest(Settings settings) {
        super(settings);
    }

}
