package the_beginning_remaster.the_beginning.blockentity.renderers;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Matrix4f;
import the_beginning_remaster.the_beginning.blockentity.portalentity;
import the_beginning_remaster.the_beginning.util.TBRenderLayer;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class portalrender extends BlockEntityRenderer<portalentity> {
    public static final Identifier SKY_TEXTURE = new Identifier("the_beginning_remaster:textures/environment/portal_background.png");
    public static final Identifier PORTAL_TEXTURE = new Identifier("the_beginning_remaster:textures/environment/portal_overlay.png");
    private static final Random RANDOM = new Random(31100L);
    private final ModelPart field_20823 = new ModelPart(16, 16, 0, 0);

    private static final List<TBRenderLayer> field_21732 = (List)IntStream.range(0, 16).mapToObj((i) -> TBRenderLayer.getTestPortal(i + 1)).collect(ImmutableList.toImmutableList());
    public portalrender(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
        super(blockEntityRenderDispatcher);
    }



    public void render(portalentity entity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {

        RANDOM.setSeed(31100L);
        double d = entity.getPos().getSquaredDistance(this.dispatcher.camera.getPos(), true);
        int k = this.method_3592(d);
        float g = this.method_3594();
        Matrix4f matrix4f = matrixStack.peek().getModel();
        this.method_23084(entity, g, 0.15F, matrix4f, vertexConsumerProvider.getBuffer(field_21732.get(0)));

        for(int l = 1; l < k; ++l) {
            this.method_23084(entity, g, 2.0F / (float)(18 - l), matrix4f, vertexConsumerProvider.getBuffer(field_21732.get(l)));
        }

    }

    private void method_23084(portalentity entity, float f, float g, Matrix4f matrix4f, VertexConsumer vertexConsumer) {
        float h = 1.0F;
        float i = 1.0F;
        float j = 1.0F;
        this.method_23086(entity, matrix4f, vertexConsumer, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, h, i, j, Direction.SOUTH);
        this.method_23086(entity, matrix4f, vertexConsumer, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, h, i, j, Direction.NORTH);
        this.method_23086(entity, matrix4f, vertexConsumer, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, h, i, j, Direction.EAST);
        this.method_23086(entity, matrix4f, vertexConsumer, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, h, i, j, Direction.WEST);
        this.method_23086(entity, matrix4f, vertexConsumer, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, h, i, j, Direction.DOWN);
        this.method_23086(entity, matrix4f, vertexConsumer, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, 2.0F, -1.0F, -1.0F, h, i, j, Direction.UP);
    }
    private void method_23086(portalentity entity, Matrix4f matrix4f, VertexConsumer vertexConsumer, float f, float g, float h, float i, float j, float k, float l, float m, float n, float o, float p, Direction direction) {
        if (entity.shouldDrawSide(direction)) {
            vertexConsumer.vertex(matrix4f, f, h, j).color(n, o, p, 1.0F).next();
            vertexConsumer.vertex(matrix4f, g, h, k).color(n, o, p, 1.0F).next();
            vertexConsumer.vertex(matrix4f, g, i, l).color(n, o, p, 1.0F).next();
            vertexConsumer.vertex(matrix4f, f, i, m).color(n, o, p, 1.0F).next();
        }

    }
    private void method_23085(portalentity entity, Matrix4f matrix4f, VertexConsumer vertexConsumer, float f, float g, float h, float i, float j, float k, float l, float m, float n, float o, float p, Direction direction) {
        if (entity.shouldDrawSide(direction)) {
            vertexConsumer.vertex(matrix4f, f, h, j).color(1.0F, 1.0F, 1.0F, 1.0F).next();
            vertexConsumer.vertex(matrix4f, g, h, k).color(1.0F, 1.0F, 1.0F, 1.0F).next();
            vertexConsumer.vertex(matrix4f, g, i, l).color(1.0F, 1.0F, 1.0F, 1.0F).next();
            vertexConsumer.vertex(matrix4f, f, i, m).color(1.0F, 1.0F, 1.0F, 1.0F).next();
        }

    }

    protected int method_3592(double d) {
        if (d > 36864.0D) {
            return 1;
        } else if (d > 25600.0D) {
            return 3;
        } else if (d > 16384.0D) {
            return 5;
        } else if (d > 9216.0D) {
            return 7;
        } else if (d > 4096.0D) {
            return 9;
        } else if (d > 1024.0D) {
            return 11;
        } else if (d > 576.0D) {
            return 13;
        } else {
            return d > 256.0D ? 14 : 15;
        }
    }

    protected float method_3594() {
        return 1.0F;
    }
}
