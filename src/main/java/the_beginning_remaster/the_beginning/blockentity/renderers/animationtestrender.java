package the_beginning_remaster.the_beginning.blockentity.renderers;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;
import the_beginning_remaster.the_beginning.blockentity.animationtest;

import java.util.Objects;

public class animationtestrender extends BlockEntityRenderer<animationtest> {
    public static final SpriteIdentifier BASE_TEXTURE;
    private final ModelPart field_20825;

        public animationtestrender(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
            super(blockEntityRenderDispatcher);
            this.field_20825 = new ModelPart(64, 32, 0, 0);
            this.field_20825.addCuboid(-4.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.01F);
        }
    public void render(animationtest blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        int lightAbove = WorldRenderer.getLightmapCoordinates(Objects.requireNonNull(blockEntity.getWorld()), blockEntity.getPos().up());
        VertexConsumer vertexConsumer = BASE_TEXTURE.getVertexConsumer(vertexConsumers, RenderLayer::getEntitySolid);
        matrices.translate(0.5, 1.25, 0.5);
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((blockEntity.getWorld().getTime() + tickDelta) * 4));
        this.field_20825.render(matrices, vertexConsumer, lightAbove, overlay);
        // Mandatory call after GL calls
        matrices.pop();
    }
    static {
        BASE_TEXTURE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("the_beginning_remaster:entity/test/texture"));
    }
}