package shadowmaster435.the_beginning.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import shadowmaster435.the_beginning.block.*;
import shadowmaster435.the_beginning.blockentity.*;
import shadowmaster435.the_beginning.blockentity.renderers.ItemPipeRenderer;
import shadowmaster435.the_beginning.blockentity.renderers.LightningRender;
import shadowmaster435.the_beginning.blockentity.renderers.animationtestrender;
import shadowmaster435.the_beginning.blockentity.renderers.portalrender;
import shadowmaster435.the_beginning.pipes.ItemPipeEntity;

public class TBBlocks {
    public static final portaltest PORTAL_BLOCK = new portaltest(Block.Settings.of(Material.STONE));
    public static final Block DISTORTED_TEST = new Block(FabricBlockSettings.of(Material.METAL));
    public static final Block TESTSLOPE = new Block(FabricBlockSettings.of(Material.METAL));
    public static final ProgressBlock PROGRESS_BLOCK = new ProgressBlock(Block.Settings.of(Material.STONE));
    public static final testblock EXAMPLE_BLOCK = new testblock(Block.Settings.of(Material.STONE));
    public static final lightningblock LIGHTNING_BLOCK = new lightningblock(Block.Settings.of(Material.STONE));
    public static final Block BLAZING_ROCK = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.0f).luminance((state) -> 2));
    public static final Block MELTY_ROCK = new Block(FabricBlockSettings.of(Material.STONE).hardness(0.5f).luminance((state) -> 4));
    public static final Block FROSTBURNT_STONE = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.25f));
    public static final Block CTTEST = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.25f));
    public static final Block MOLD_STEM_BASE = new Block(FabricBlockSettings.of(Material.NETHER_WOOD).hardness(0.75f).nonOpaque());
    public static final MoldSpore MOLD_SPORE = new MoldSpore(FabricBlockSettings.of(Material.WOOD).hardness(0.75f).sounds(BlockSoundGroup.NETHER_STEM).nonOpaque());
    public static final GenericMultiblockTile GENERIC_MULTIBLOCK = new GenericMultiblockTile(FabricBlockSettings.of(Material.WOOD).hardness(0.75f).sounds(BlockSoundGroup.NETHER_STEM).nonOpaque());
    public static final Multiblocktest MULTIBLOCK_TEST = new Multiblocktest(FabricBlockSettings.of(Material.WOOD).hardness(0.75f).sounds(BlockSoundGroup.NETHER_STEM).nonOpaque());
    public static final ItemPipe ITEM_PIPE = new ItemPipe(FabricBlockSettings.of(Material.STONE).hardness(0.75f).sounds(BlockSoundGroup.GLASS).nonOpaque());

    public static BlockEntityType<animationtest> DEMO_BLOCK_ENTITY;
    public static BlockEntityType<ProgressEntity> PROGRESS_ENTITY;
    public static BlockEntityType<portalentity> PORTAL_ENTITY;
    public static BlockEntityType<lightningentity> LIGHTNING_ENTITY;
    public static BlockEntityType<GenericMultiblockEntity> GENERIC_MULTIBLOCK_ENTITY;
    public static BlockEntityType<ItemPipeEntity> ITEM_PIPE_ENTITY;

    public static void init() {
        // Blocks
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "blazing_rock"), BLAZING_ROCK);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "melty_rock"), MELTY_ROCK);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "frostburnt_stone"), FROSTBURNT_STONE);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "testblock"), EXAMPLE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "portal"), PORTAL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "distort"), DISTORTED_TEST);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "testslope"), TESTSLOPE);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "lightning"), LIGHTNING_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "cttest"), CTTEST);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "moldstem"), MOLD_STEM_BASE);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "moldspore"), MOLD_SPORE);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "multiblocktest"), MULTIBLOCK_TEST);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "progress"), PROGRESS_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("the_beginning_remaster", "itempipe"), ITEM_PIPE);

        // Itemblocks
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "progress"), new BlockItem(PROGRESS_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "blazing_rock"), new BlockItem(BLAZING_ROCK, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "distort"), new BlockItem(DISTORTED_TEST, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "testblock"), new BlockItem(EXAMPLE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "cttest"), new BlockItem(CTTEST, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "moldstem"), new BlockItem(MOLD_STEM_BASE, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "moldspore"), new BlockItem(MOLD_SPORE, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "lightning"), new BlockItem(LIGHTNING_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "multiblocktest"), new BlockItem(MULTIBLOCK_TEST, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "testslope"), new BlockItem(TESTSLOPE, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "itempipe"), new BlockItem(ITEM_PIPE, new Item.Settings().group(ItemGroup.MISC)));

        // BlockEntities
        DEMO_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "the_beginning_remaster:demo", BlockEntityType.Builder.create(animationtest::new, EXAMPLE_BLOCK).build(null));
        PORTAL_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "the_beginning_remaster:portal", BlockEntityType.Builder.create(portalentity::new, PORTAL_BLOCK).build(null));
        LIGHTNING_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "the_beginning_remaster:lightning", BlockEntityType.Builder.create(lightningentity::new, LIGHTNING_BLOCK).build(null));
        GENERIC_MULTIBLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "the_beginning_remaster:multiblock", BlockEntityType.Builder.create(GenericMultiblockEntity::new, GENERIC_MULTIBLOCK).build(null));
        PROGRESS_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "the_beginning_remaster:progress", BlockEntityType.Builder.create(ProgressEntity::new, PROGRESS_BLOCK).build(null));
        ITEM_PIPE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "the_beginning_remaster:itempipeentity", BlockEntityType.Builder.create(ItemPipeEntity::new, ITEM_PIPE).build(null));

    }
    @Environment(EnvType.CLIENT)
    public static void initClient() {
        BlockEntityRendererRegistry.INSTANCE.register(TBBlocks.DEMO_BLOCK_ENTITY, animationtestrender::new);
        BlockEntityRendererRegistry.INSTANCE.register(TBBlocks.LIGHTNING_ENTITY, LightningRender::new);
        BlockEntityRendererRegistry.INSTANCE.register(TBBlocks.PORTAL_ENTITY, portalrender::new);
        BlockEntityRendererRegistry.INSTANCE.register(TBBlocks.ITEM_PIPE_ENTITY, ItemPipeRenderer::new);

        // Render Layer
        BlockRenderLayerMap.INSTANCE.putBlock(MOLD_SPORE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ITEM_PIPE, RenderLayer.getCutout());

    }
}

