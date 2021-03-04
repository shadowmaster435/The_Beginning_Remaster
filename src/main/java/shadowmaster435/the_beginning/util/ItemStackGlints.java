package shadowmaster435.the_beginning.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class ItemStackGlints {
    public boolean test;
    public boolean empty;
    public ItemStack istack;
    public ItemStackGlints item;
    public Item itemStack = ItemStack.EMPTY.getItem();


    public ItemStackGlints getItem() {
        return this;
    }

    public boolean hasTestGlint(Item stack) {
        return this.getItem().test;
    }
}
