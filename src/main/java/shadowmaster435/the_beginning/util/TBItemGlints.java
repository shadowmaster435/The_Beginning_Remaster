package shadowmaster435.the_beginning.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.block.TransparentBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.render.*;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TBItemGlints extends ItemRenderer {
    public static final Identifier TESTGLINT = new Identifier("the_beginning_remaster:textures/glint/glinttest.png");
    private final ItemModels models;
    private final ItemColors colorMap;

    public TBItemGlints(TextureManager manager, BakedModelManager bakery, ItemColors colorMap, ItemModels models, ItemColors colorMap1) {
        super(manager, bakery, colorMap);
        this.models = models;
        this.colorMap = colorMap1;
    }

    public static VertexConsumer getItemGlintConsumer(VertexConsumerProvider vertexConsumers, RenderLayer layer, boolean solid, boolean test) {
        if (test) {
            return MinecraftClient.isFabulousGraphicsOrBetter() && layer == TexturedRenderLayers.getItemEntityTranslucentCull() ? VertexConsumers.dual(vertexConsumers.getBuffer(RenderLayer.method_30676()), vertexConsumers.getBuffer(layer)) : VertexConsumers.dual(vertexConsumers.getBuffer(solid ? TBRenderLayer.getTestGlint() : RenderLayer.getEntityGlint()), vertexConsumers.getBuffer(layer));
        } else {
            return vertexConsumers.getBuffer(layer);
        }
    }
    private void renderBakedItemQuads(MatrixStack matrices, VertexConsumer vertices, List<BakedQuad> quads, ItemStack stack, int light, int overlay) {
        boolean bl = !stack.isEmpty();
        MatrixStack.Entry entry = matrices.peek();
        Iterator var9 = quads.iterator();

        while(var9.hasNext()) {
            BakedQuad bakedQuad = (BakedQuad)var9.next();
            int i = -1;
            if (bl && bakedQuad.hasColor()) {
                i = this.colorMap.getColorMultiplier(stack, bakedQuad.getColorIndex());
            }

            float f = (float)(i >> 16 & 255) / 255.0F;
            float g = (float)(i >> 8 & 255) / 255.0F;
            float h = (float)(i & 255) / 255.0F;
            vertices.quad(entry, bakedQuad, f, g, h, light, overlay);
        }

    }
    private void renderBakedItemModel(BakedModel model, ItemStack stack, int light, int overlay, MatrixStack matrices, VertexConsumer vertices) {
        Random random = new Random();
        long l = 42L;
        Direction[] var10 = Direction.values();
        int var11 = var10.length;

        for(int var12 = 0; var12 < var11; ++var12) {
            Direction direction = var10[var12];
            random.setSeed(42L);
            this.renderBakedItemQuads(matrices, vertices, model.getQuads((BlockState)null, direction, random), stack, light, overlay);
        }

        random.setSeed(42L);
        this.renderBakedItemQuads(matrices, vertices, model.getQuads((BlockState)null, (Direction)null, random), stack, light, overlay);
    }
    public Item itemStack;
    public ItemStack item;

    public void renderItem(ItemStackGlints stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel model) {
        if (!item.isEmpty()) {
            matrices.push();
            boolean bl = renderMode == ModelTransformation.Mode.GUI || renderMode == ModelTransformation.Mode.GROUND || renderMode == ModelTransformation.Mode.FIXED;
            if (item.getItem() == Items.TRIDENT && bl) {
                model = this.models.getModelManager().getModel(new ModelIdentifier("minecraft:trident#inventory"));
            }

            model.getTransformation().getTransformation(renderMode).apply(leftHanded, matrices);
            matrices.translate(-0.5D, -0.5D, -0.5D);
            if (model.isBuiltin() || item.getItem() == Items.TRIDENT && !bl) {
                BuiltinModelItemRenderer.INSTANCE.render(item, renderMode, matrices, vertexConsumers, light, overlay);
            } else {
                boolean bl3;
                if (renderMode != ModelTransformation.Mode.GUI && !renderMode.isFirstPerson() && item.getItem() instanceof BlockItem) {
                    Block block = ((BlockItem)item.getItem()).getBlock();
                    bl3 = !(block instanceof TransparentBlock) && !(block instanceof StainedGlassPaneBlock);
                } else {
                    bl3 = true;
                }

                TBRenderLayer renderLayer = (TBRenderLayer) RenderLayers.getItemLayer(item, bl3);
                VertexConsumer vertexConsumer4;
                if (bl3) {
                    vertexConsumer4 = getDirectItemGlintConsumer(vertexConsumers, renderLayer, true, stack.hasTestGlint(itemStack));
                } else {
                    vertexConsumer4 = getItemGlintConsumer(vertexConsumers, renderLayer, true, stack.hasTestGlint(itemStack));
                }

                this.renderBakedItemModel(model, item, light, overlay, matrices, vertexConsumer4);
            }

            matrices.pop();
        }
    }
}
