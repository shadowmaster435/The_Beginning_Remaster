package shadowmaster435.the_beginning.models;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.mesh.Mesh;
import net.fabricmc.fabric.api.renderer.v1.mesh.MeshBuilder;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.model.ForwardingBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.*;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockRenderView;
import shadowmaster435.the_beginning.registry.TBBlocks;
import shadowmaster435.the_beginning.util.CTBakeLogic;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class CTTestModel extends ForwardingBakedModel implements UnbakedModel, BakedModel, FabricBakedModel {
    private Mesh mesh;

    public static final SpriteIdentifier[] SPRITE_IDS = new SpriteIdentifier[]{
            new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("the_beginning_remaster:block/cttestnormal")),
            new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("the_beginning_remaster:block/cttesthorizantal")),
            new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("the_beginning_remaster:block/cttestvertical")),
            new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("the_beginning_remaster:block/cttestcross")),
            new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("the_beginning_remaster:block/cttestfull")),
    };
    public static Sprite[] SPRITES = new Sprite[5];
    public static FabricBakedModel baseModel;

    public CTTestModel() { 
    }

    @Override
    public Collection<Identifier> getModelDependencies() {
        return Collections.emptyList();
    }

    @Override
    public Collection<SpriteIdentifier> getTextureDependencies(Function<Identifier, UnbakedModel> unbakedModelGetter, Set<Pair<String, String>> unresolvedTextureReferences) {
        return Arrays.asList(SPRITE_IDS); // The textures this model (and all its model dependencies, and their dependencies, etc...!) depends on.
    }

    @Override
    public BakedModel bake(ModelLoader loader, Function<SpriteIdentifier, Sprite> textureGetter, ModelBakeSettings rotationContainer, Identifier modelId) {
        for (int i = 0; i < 5; ++i) {
            SPRITES[i] = textureGetter.apply(SPRITE_IDS[i]);
        }
        Renderer renderer = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderer.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();
        for (Direction dir : Direction.values()) {
            emitter.square(dir, 0.0f, 0.0f, 0.5f, 0.5f, 0.0f);
            emitter.spriteBake(0, SPRITES[1], MutableQuadView.BAKE_LOCK_UV);
            emitter.spriteColor(0, -1, -1, -1, -1);
            emitter.emit();
            emitter.square(dir, 0.5f, 0.0f, 1.0f, 0.5f, 0.0f);
            emitter.spriteBake(0, SPRITES[1], MutableQuadView.BAKE_LOCK_UV);
            emitter.spriteColor(0, -1, -1, -1, -1);
            emitter.emit();
            emitter.square(dir, 0.0f, 0.5f, 0.5f, 1.0f, 0.0f);
            emitter.spriteBake(0, SPRITES[1], MutableQuadView.BAKE_LOCK_UV);
            emitter.spriteColor(0, -1, -1, -1, -1);
            emitter.emit();
            emitter.square(dir, 0.5f, 0.0f, 1.0f, 1.0f, 0.0f);
            emitter.spriteBake(0, SPRITES[1], MutableQuadView.BAKE_LOCK_UV);
            emitter.spriteColor(0, -1, -1, -1, -1);
            emitter.emit();
        }
        baseModel = this;
        mesh = builder.build();

        return this;
    }

    @Override
    public boolean isVanillaAdapter() {
        return false;
    }
    @Override
    public void emitBlockQuads(BlockRenderView blockRenderView, BlockState blockState, BlockPos blockPos, Supplier<Random> supplier, RenderContext renderContext) {
        QuadEmitter emitter = renderContext.getEmitter();
        Block block = TBBlocks.CTTEST.getDefaultState().getBlock();


        renderContext.pushTransform(quad -> {
            BlockState u = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(0, 1, 0)));
            BlockState d = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(0, -1, 0)));
            BlockState n = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(0, 0, -1)));
            BlockState s = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(0, 0, 1)));
            BlockState e = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(1, 0, 0)));
            BlockState w = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(-1, 0, 0)));
            BlockState un = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(0, 1, -1)));
            BlockState us = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(0, 1, 1)));
            BlockState ue = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(1, 1, 0)));
            BlockState uw = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(-1, 1, 0)));
            BlockState dn = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(0, -1, -1)));
            BlockState ds = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(0, -1, 1)));
            BlockState de = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(1, -1, 0)));
            BlockState dw = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(-1, -1, 0)));
            BlockState ne = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(1, 0, -1)));
            BlockState nw = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(-1, 0, -1)));
            BlockState se = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(1, 0, 1)));
            BlockState sw = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(-1, 0, 1)));
            Block up = u.getBlock();
            Block down = d.getBlock();
            Block north = n.getBlock();
            Block south = s.getBlock();
            Block east = e.getBlock();
            Block west = w.getBlock();
            Block upnorth = un.getBlock();
            Block upsouth = us.getBlock();
            Block upeast = ue.getBlock();
            Block upwest = uw.getBlock();
            Block downnorth = dn.getBlock();
            Block downsouth = ds.getBlock();
            Block downeast = de.getBlock();
            Block downwest = dw.getBlock();
            Block northeast = ne.getBlock();
            Block northwest = nw.getBlock();
            Block southeast = se.getBlock();
            Block southwest = sw.getBlock();
            boolean Up = up.is(block);
            boolean Down = down.is(block);
            boolean North = north.is(block);
            boolean South = south.is(block);
            boolean East = east.is(block);
            boolean West = west.is(block);
            boolean UpNorth = upnorth.is(block);
            boolean UpSouth = upsouth.is(block);
            boolean UpEast = upeast.is(block);
            boolean UpWest = upwest.is(block);
            boolean DownNorth = downnorth.is(block);
            boolean DownSouth = downsouth.is(block);
            boolean DownEast = downeast.is(block);
            boolean DownWest = downwest.is(block);
            boolean NorthEast = northeast.is(block);
            boolean NorthWest = northwest.is(block);
            boolean SouthEast = southeast.is(block);
            boolean SouthWest = southwest.is(block);
            for (Direction dir : Direction.values()) {
                if (!Up && !Down && !North && !South && !East && !West) {
                        emitter.square(dir, 0.0f, 0.0f, 0.5f, 0.5f, 0.0f);
                        emitter.spriteBake(0, SPRITES[1], MutableQuadView.BAKE_LOCK_UV);
                        emitter.spriteColor(0, -1, -1, -1, -1);
                        emitter.emit();
                        emitter.square(dir, 0.5f, 0.0f, 1.0f, 0.5f, 0.0f);
                        emitter.spriteBake(0, SPRITES[1], MutableQuadView.BAKE_LOCK_UV);
                        emitter.spriteColor(0, -1, -1, -1, -1);
                        emitter.emit();
                        emitter.square(dir, 0.0f, 0.5f, 0.5f, 1.0f, 0.0f);
                        emitter.spriteBake(0, SPRITES[1], MutableQuadView.BAKE_LOCK_UV);
                        emitter.spriteColor(0, -1, -1, -1, -1);
                        emitter.emit();
                        emitter.square(dir, 0.5f, 0.0f, 1.0f, 1.0f, 0.0f);
                        emitter.spriteBake(0, SPRITES[1], MutableQuadView.BAKE_LOCK_UV);
                        emitter.spriteColor(0, -1, -1, -1, -1);
                        emitter.emit();
                        System.out.println("none");
                } else {
                    if (dir == Direction.UP || dir == Direction.DOWN) {
                        if (South && !West && dir != Direction.SOUTH || dir != Direction.NORTH) {
                            CTBakeLogic.bottomleftv();
                            if (!East) {
                                CTBakeLogic.bottomrightv();
                            }
                        } else if (West && !South && dir != Direction.WEST || dir != Direction.EAST) {
                            CTBakeLogic.bottomlefth();
                            if (!North) {
                                CTBakeLogic.toplefth();
                            }
                        } else if (South && West && dir == Direction.UP || dir == Direction.DOWN) {
                            if (!SouthWest) {
                                CTBakeLogic.bottomleftcross();
                            } else {
                                CTBakeLogic.bottomleftfull();
                            }
                            if (!North) {
                                CTBakeLogic.toplefth();
                            }
                            if (!East) {
                                CTBakeLogic.bottomrightv();
                            }
                        }
                        if (North && !East && dir != Direction.SOUTH || dir != Direction.NORTH) {
                            CTBakeLogic.toprightv();
                            if (!West) {
                                CTBakeLogic.topleftv();
                            }
                        } else if (East && !North && dir != Direction.WEST || dir != Direction.EAST) {
                            CTBakeLogic.toprighth();
                            if (!South) {
                                CTBakeLogic.bottomrighth();
                            }
                        } else if (North && East && dir == Direction.UP || dir == Direction.DOWN) {
                            if (!NorthEast) {
                                CTBakeLogic.toprightcross();
                            } else {
                                CTBakeLogic.toprightfull();
                            }
                            if (!South) {
                                CTBakeLogic.toplefth();
                            }
                            if (!West) {
                                CTBakeLogic.bottomrightv();
                            }
                        }
                        if (North && !West && dir != Direction.SOUTH || dir != Direction.NORTH) {
                            CTBakeLogic.topleftv();
                            if (!East) {
                                CTBakeLogic.toprightv();
                            }
                        } else if (West && !North && dir != Direction.WEST || dir != Direction.EAST) {
                            CTBakeLogic.toprighth();
                            if (!South) {
                                CTBakeLogic.bottomrighth();
                            }
                        } else if (North && West && dir == Direction.UP || dir == Direction.DOWN) {
                            if (!NorthWest) {
                                CTBakeLogic.toprightcross();
                            } else {
                                CTBakeLogic.toprightfull();
                            }
                            if (!South) {
                                CTBakeLogic.bottomlefth();
                            }
                            if (!East) {
                                CTBakeLogic.toprightv();
                            }
                        }
                        if (South && !East && dir != Direction.SOUTH || dir != Direction.NORTH) {
                            CTBakeLogic.bottomleftv();
                            if (!West) {
                                CTBakeLogic.bottomleftv();
                            }
                        } else if (East && !South && dir != Direction.WEST || dir != Direction.EAST) {
                            CTBakeLogic.toplefth();
                            if (!South) {
                                CTBakeLogic.bottomlefth();
                            }
                        } else if (East && South && dir == Direction.UP || dir == Direction.DOWN) {
                            if (!SouthEast) {
                                CTBakeLogic.bottomleftcross();
                            } else {
                                CTBakeLogic.bottomleftfull();
                            }
                            if (!North) {
                                CTBakeLogic.toplefth();
                            }
                            if (!East) {
                                CTBakeLogic.bottomrightv();
                            }
                        }
                    } else {
                        if (Down && !West) {
                            CTBakeLogic.bottomleftv();
                            if (!East) {
                                CTBakeLogic.bottomrightv();
                            }
                        } else if (West && !Down) {
                            CTBakeLogic.bottomlefth();
                            if (!Up) {
                                CTBakeLogic.toplefth();
                            }
                        } else if (Down && West) {
                            if (!DownWest) {
                                CTBakeLogic.bottomleftcross();
                            } else {
                                CTBakeLogic.bottomleftfull();
                            }
                            if (!Up) {
                                CTBakeLogic.toplefth();
                            }
                            if (!East) {
                                CTBakeLogic.bottomrightv();
                            }
                        }
                        if (Up && !East && dir != Direction.SOUTH || dir != Direction.NORTH) {
                            CTBakeLogic.toprightv();
                            if (!West) {
                                CTBakeLogic.topleftv();
                            }
                        } else if (East && !Up && dir != Direction.WEST || dir != Direction.EAST) {
                            CTBakeLogic.toprighth();
                            if (!Down) {
                                CTBakeLogic.bottomrighth();
                            }
                        } else if (Up && East && dir == Direction.UP || dir == Direction.DOWN) {
                            if (!UpEast) {
                                CTBakeLogic.toprightcross();
                            } else {
                                CTBakeLogic.toprightfull();
                            }
                            if (!Down) {
                                CTBakeLogic.toplefth();
                            }
                            if (!West) {
                                CTBakeLogic.bottomrightv();
                            }
                        }
                        if (Up && !West && dir != Direction.SOUTH || dir != Direction.NORTH) {
                            CTBakeLogic.topleftv();
                            if (!East) {
                                CTBakeLogic.toprightv();
                            }
                        } else if (West && !Up && dir != Direction.WEST || dir != Direction.EAST) {
                            CTBakeLogic.toprighth();
                            if (!Down) {
                                CTBakeLogic.bottomrighth();
                            }
                        } else if (Up && West && dir == Direction.UP || dir == Direction.DOWN) {
                            if (!UpWest) {
                                CTBakeLogic.toprightcross();
                            } else {
                                CTBakeLogic.toprightfull();
                            }
                            if (!Down) {
                                CTBakeLogic.bottomlefth();
                            }
                            if (!East) {
                                CTBakeLogic.toprightv();
                            }
                        }
                        if (Down && !East && dir != Direction.SOUTH || dir != Direction.NORTH) {
                            CTBakeLogic.bottomleftv();
                            if (!West) {
                                CTBakeLogic.bottomleftv();
                            }
                        } else if (East && !Down && dir != Direction.WEST || dir != Direction.EAST) {
                            CTBakeLogic.toplefth();
                            if (!Down) {
                                CTBakeLogic.bottomlefth();
                            }
                        } else if (East && Down && dir == Direction.UP || dir == Direction.DOWN) {
                            if (!DownEast) {
                                CTBakeLogic.bottomleftcross();
                            } else {
                                CTBakeLogic.bottomleftfull();
                            }
                            if (!Up) {
                                CTBakeLogic.toplefth();
                            }
                            if (!East) {
                                CTBakeLogic.bottomrightv();
                            }
                        }
                    }
                }
            }
            System.out.println(Up);
            return true;
        });

        renderContext.popTransform();
    }

    @Override
    public void emitItemQuads(ItemStack itemStack, Supplier<Random> supplier, RenderContext renderContext) {

    }

    @Override
    public List<BakedQuad> getQuads(BlockState state, Direction face, Random random) {
        return null; // Don't need because we use FabricBakedModel instead
    }

    @Override
    public boolean useAmbientOcclusion() {
        return true; // we want the block to have a shadow depending on the adjacent blocks
    }

    @Override
    public boolean isBuiltin() {
        return false;
    }

    @Override
    public boolean hasDepth() {
        return false;
    }

    @Override
    public boolean isSideLit() {
        return false;
    }

    @Override
    public Sprite getSprite() {
        return SPRITES[1]; // Block break particle, let's use furnace_top
    }

    @Override
    public ModelTransformation getTransformation() {
        return null;
    }

    @Override
    public ModelOverrideList getOverrides() {
        return null;
    }
}