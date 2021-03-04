package shadowmaster435.the_beginning.util.gui;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.Property;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;

import java.util.List;

public class TBScreenHandler extends ScreenHandler {
    public final DefaultedList<ItemStack> trackedStacks = DefaultedList.of();
    public final List<Property> properties = Lists.newArrayList();

    public void addProperties(PropertyDelegate propertyDelegate) {
        for(int i = 0; i < propertyDelegate.size(); ++i) {
            this.addProperty(Property.create(propertyDelegate, i));
        }

    }

    public Slot addSlot(Slot slot) {
        slot.id = this.slots.size();
        this.slots.add(slot);
        this.trackedStacks.add(ItemStack.EMPTY);
        return slot;
    }

    public Property addProperty(Property property) {
        this.properties.add(property);
        return property;
    }
    public TBScreenHandler(ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return false;
    }
}
