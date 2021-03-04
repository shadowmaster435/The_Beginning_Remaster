package shadowmaster435.the_beginning.blockentity;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.model.ForwardingBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockRenderView;
import shadowmaster435.the_beginning.models.CTTestModel;
import shadowmaster435.the_beginning.models.modelresource.CTTestResource;
import shadowmaster435.the_beginning.registry.TBBlocks;
import shadowmaster435.the_beginning.util.CTBakeLogic;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConnectingTexture extends ForwardingBakedModel implements UnbakedModel, FabricBakedModel {
    public static UnbakedModel baseModel;
    public static BakedModel baked;

    public static String full;
    public static String horizantal;
    public static String vertical;
    public static String cross;
    public static String normal;

    public static final SpriteIdentifier[] SPRITE_IDS = new SpriteIdentifier[]{
        new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("the_beginning_remaster:block/" + normal)),
        new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("the_beginning_remaster:block/" + horizantal)),
        new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("the_beginning_remaster:block/" + vertical)),
        new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("the_beginning_remaster:block/" + cross)),
        new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("the_beginning_remaster:block/" + full)),
    };
    public static Sprite[] SPRITES = new Sprite[5];

    public ConnectingTexture(UnbakedModel baseModel, Sprite[] spriteProviders) {
        ConnectingTexture.baseModel = baseModel;
        SPRITES = spriteProviders;
    }
    @Override
    public Collection<Identifier> getModelDependencies() {
        return Collections.emptyList(); // This model does not depend on other models.
    }

    @Override
    public Collection<SpriteIdentifier> getTextureDependencies(Function<Identifier, UnbakedModel> unbakedModelGetter, Set<Pair<String, String>> unresolvedTextureReferences) {
        return Arrays.asList(SPRITE_IDS); // The textures this model (and all its model dependencies, and their dependencies, etc...!) depends on.
    }


    public static Block block;
    @Override
    public BakedModel bake(ModelLoader loader, Function<SpriteIdentifier, Sprite> textureGetter, ModelBakeSettings rotationContainer, Identifier modelId) {
        if (modelId == CTTestResource.CTMODEL) {
            block = TBBlocks.CTTEST;
            full = "cttestfull";
            normal = "cttestnormal";
            cross = "cttestcross";
            horizantal = "cttesthorizontal";
            vertical = "cttestvertical";
            for(int i = 0; i < 5; ++i) {
                SPRITES[i] = textureGetter.apply(CTTestModel.SPRITE_IDS[i]);
            }
        }
        return baked;
    }

    @Override
    public boolean isVanillaAdapter() {
        return false;
    }

    public static void logic(BlockRenderView blockRenderView, RenderContext renderContext) {
        System.out.println("baked");
        QuadEmitter emitter = renderContext.getEmitter();
        BlockPos blockPos = BlockPos.ORIGIN;
        BlockState u = blockRenderView.getBlockState(blockPos.up());
        BlockState d = blockRenderView.getBlockState(blockPos.down());
        BlockState n = blockRenderView.getBlockState(blockPos.north());
        BlockState s = blockRenderView.getBlockState(blockPos.south());
        BlockState e = blockRenderView.getBlockState(blockPos.east());
        BlockState w = blockRenderView.getBlockState(blockPos.west());
        BlockState un = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(0, 1, -1)));
        BlockState us = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(0, 1, 1)));
        BlockState ue = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(1, 1, 0)));
        BlockState uw = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(-1, 1, 0)));
        BlockState dn = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(0, -1, -1)));
        BlockState ds = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(0, -1, 1)));
        BlockState de = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(1, -1, 0)));
        BlockState dw = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(-1, -1, 0)));
        BlockState ne = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(1, 0, -1)));
        BlockState ns = blockRenderView.getBlockState(blockPos.crossProduct(new Vec3i(-1, 0, -1)));
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
        Block northwest = ns.getBlock();
        Block southeast = se.getBlock();
        Block southwest = sw.getBlock();
        boolean Up = up == block;
        boolean Down = down == block;
        boolean North = north == block;
        boolean South = south == block;
        boolean East = east == block;
        boolean West = west == block;
        boolean UpNorth = upnorth == block;
        boolean UpSouth = upsouth == block;
        boolean UpEast = upeast == block;
        boolean UpWest = upwest == block;
        boolean DownNorth = downnorth == block;
        boolean DownSouth = downsouth == block;
        boolean DownEast = downeast == block;
        boolean DownWest = downwest == block;
        boolean NorthEast = northeast == block;
        boolean NorthWest = northwest == block;
        boolean SouthEast = southeast == block;
        boolean SouthWest = southwest == block;
            for (Direction dir : Direction.values()) {
                if (!Up && !Down && !North && !South && !East && !West) {
                    emitter.square(dir, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f);
                    emitter.spriteBake(0, ConnectingTexture.SPRITES[0], MutableQuadView.BAKE_LOCK_UV);
                    emitter.spriteColor(0, -1, -1, -1, -1);
                    emitter.emit();
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
        }

    @Override
    public void emitItemQuads(ItemStack itemStack, Supplier<Random> supplier, RenderContext renderContext) {

    }
}
