package shadowmaster435.the_beginning.blockentity.renderers;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import shadowmaster435.the_beginning.blockentity.lightningentity;

public class FogRenderer extends BlockEntityRenderer<lightningentity> {
    public static int delay;
    public static float anglerestrict;
    public static float prevoriginx;
    public static float prevoriginy;
    public static float prevoriginz;
    public static float nextoriginx;
    public static float nextoriginy;
    public static float nextoriginz;
    public FogRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    public void render(lightningentity le, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int c, int j) {

    }
}