package shadowmaster435.the_beginning.blockentity.renderers;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Matrix4f;
import shadowmaster435.the_beginning.blockentity.DistortedEntity;
import shadowmaster435.the_beginning.util.TBRenderLayer;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class DistortedRenderer extends BlockEntityRenderer<DistortedEntity> {
    public static final Identifier SKY_TEXTURE = new Identifier("the_beginning_remaster:textures/environment/portal_background.png");
    public static final Identifier PORTAL_TEXTURE = new Identifier("the_beginning_remaster:textures/environment/portal_overlay.png");
    private static final Random RANDOM = new Random(31100L);
    public static final SpriteIdentifier BASE_TEXTURE;

    private static final List<TBRenderLayer> field_21732 = (List)IntStream.range(0, 16).mapToObj((i) -> TBRenderLayer.getTestPortal(i + 1)).collect(ImmutableList.toImmutableList());
    public DistortedRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
        super(blockEntityRenderDispatcher);
    }

    public void render(DistortedEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        Matrix4f matrix4f = matrices.peek().getModel();
        this.method_23084(entity, 1.0F, 0.15F, matrix4f, (VertexConsumer) vertexConsumers);
    }

    private void method_23084(DistortedEntity entity, float tickDelta, float g, Matrix4f matrix4f, VertexConsumer vertexConsumer) {
        float h = 1.0F;
        float i = 1.0F;
        float j = 1.0F;
        this.method_23086(entity, matrix4f, vertexConsumer, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, h, i, j, Direction.SOUTH);
        this.method_23086(entity, matrix4f, vertexConsumer, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, h, i, j, Direction.NORTH);
        this.method_23086(entity, matrix4f, vertexConsumer, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, h, i, j, Direction.EAST);
        this.method_23086(entity, matrix4f, vertexConsumer, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, h, i, j, Direction.WEST);
        this.method_23086(entity, matrix4f, vertexConsumer, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, h, i, j, Direction.DOWN);
        this.method_23086(entity, matrix4f, vertexConsumer, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, h, i, j, Direction.UP);
    }
    private void method_23086(DistortedEntity entity, Matrix4f matrix4f, VertexConsumer vertexConsumer, float f, float g, float h, float i, float j, float k, float l, float m, float n, float o, float p, Direction direction) {
        if (entity.shouldDrawSide(direction)) {
            vertexConsumer.vertex(matrix4f, f, h, j).color(n, o, p, 1.0F).next();
            vertexConsumer.vertex(matrix4f, g, h, k).color(n, o, p, 1.0F).next();
            vertexConsumer.vertex(matrix4f, g, i, l).color(n, o, p, 1.0F).next();
            vertexConsumer.vertex(matrix4f, f, i, m).color(n, o, p, 1.0F).next();
        }

    }
    static {
        BASE_TEXTURE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("the_beginning_remaster:entity/test/texture"));
    }



}
