package the_beginning_remaster.the_beginning;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import the_beginning_remaster.the_beginning.block.portaltest;
import the_beginning_remaster.the_beginning.block.testblock;
import the_beginning_remaster.the_beginning.blockentity.animationtest;
import the_beginning_remaster.the_beginning.blockentity.portalentity;
import the_beginning_remaster.the_beginning.item.rclicktest;

public class The_beginning implements ModInitializer {
    public static final rclicktest FABRIC_ITEM = new rclicktest(new FabricItemSettings().group(ItemGroup.MISC));
    public static final testblock EXAMPLE_BLOCK = new testblock(Block.Settings.of(Material.STONE));
    public static final portaltest PORTAL_BLOCK = new portaltest(Block.Settings.of(Material.STONE));


    public static BlockEntityType<animationtest> DEMO_BLOCK_ENTITY;
    public static BlockEntityType<portalentity> PORTAL_ENTITY;
    public ClientWorld client;

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "fabric_item"), FABRIC_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "testblock"), EXAMPLE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "portal"), PORTAL_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "testblock"), new BlockItem(EXAMPLE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        DEMO_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "the_beginning_remaster:demo", BlockEntityType.Builder.create(animationtest::new, EXAMPLE_BLOCK).build(null));
        PORTAL_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "the_beginning_remaster:portal", BlockEntityType.Builder.create(portalentity::new, PORTAL_BLOCK).build(null));

    }

}
