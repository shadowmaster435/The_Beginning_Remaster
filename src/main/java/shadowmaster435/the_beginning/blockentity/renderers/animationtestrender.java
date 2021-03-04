package shadowmaster435.the_beginning.blockentity.renderers;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;
import shadowmaster435.the_beginning.blockentity.animationtest;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public class animationtestrender extends BlockEntityRenderer<animationtest> {
    public static final SpriteIdentifier BASE_TEXTURE;
    private final ModelPart field_20825;

        public animationtestrender(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
            super(blockEntityRenderDispatcher);
            this.field_20825 = new ModelPart(64, 32, 0, 0);
            this.field_20825.addCuboid(-4.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F);
        }
    public void render(animationtest blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        int lightAbove = WorldRenderer.getLightmapCoordinates(Objects.requireNonNull(blockEntity.getWorld()), blockEntity.getPos().up());
        matrices.translate(0.5, 1.25, 0.5);
        int overlaytex = OverlayTexture.DEFAULT_UV;

        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((blockEntity.getWorld().getTime() + tickDelta) * 4));
        this.field_20825.render(matrices, (BASE_TEXTURE).getVertexConsumer(vertexConsumers, RenderLayer::getEntityCutoutNoCull), 15728864, overlaytex);
        // Mandatory call after GL calls
        matrices.pop();
           }
    static {
        BASE_TEXTURE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("the_beginning_remaster:entity/test/texture"));
    }
}