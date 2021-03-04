package shadowmaster435.the_beginning.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class TBTabs {
    public static final ItemGroup BEGINNING_BLOCKS = FabricItemGroupBuilder.create(
            new Identifier("the_beginning_remaster", "beginning.blocks"))
            .icon(() -> new ItemStack(TBBlocks.BLAZING_ROCK))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(TBBlocks.BLAZING_ROCK));
                // Reference: stacks.add(new ItemStack(ENTRY));
            })
            .build();
    public static final ItemGroup BEGINNING_ITEMS = FabricItemGroupBuilder.create(
            new Identifier("the_beginning_remaster", "beginning.blocks"))
            .icon(() -> new ItemStack(TBBlocks.BLAZING_ROCK))
            .appendItems(stacks -> {
                // Reference: stacks.add(new ItemStack(ENTRY));
            })
            .build();
}
