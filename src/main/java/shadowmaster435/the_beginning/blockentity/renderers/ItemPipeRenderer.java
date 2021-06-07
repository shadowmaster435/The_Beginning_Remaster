package shadowmaster435.the_beginning.blockentity.renderers;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import shadowmaster435.the_beginning.block.ItemPipe;
import shadowmaster435.the_beginning.pipes.ItemPipeEntity;
import shadowmaster435.the_beginning.pipes.PipeConfigurator;

public class ItemPipeRenderer extends BlockEntityRenderer<ItemPipeEntity> {

    public ItemPipeRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }
    public void render(ItemPipeEntity le, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int c, int j) {
        RenderSystem.disableBlend();
        RenderSystem.disableTexture();
        RenderSystem.disableDepthTest();
        RenderSystem.shadeModel(7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        float r;
        float g;
        float b;
        float a = 0;
        if (!PipeConfigurator.firstpos) {
            if (ItemPipe.success) {
                r = 0;
                g = 255;
                b = 0;
                a = 255;
                bufferBuilder.begin(3, VertexFormats.POSITION_COLOR);
                bufferBuilder.vertex(matrixStack.peek().getModel(), ItemPipe.x, ItemPipe.y, ItemPipe.z).color(r, g, b, a).next();
                bufferBuilder.vertex(matrixStack.peek().getModel(), ItemPipe.x2, ItemPipe.y2, ItemPipe.z2).color(r, g, b, a).next();
                tessellator.draw();
                RenderSystem.enableBlend();
                RenderSystem.enableTexture();
                RenderSystem.enableBlend();
                RenderSystem.shadeModel(7425);
            } else {
                r = 255;
                g = 0;
                b = 0;
                a = 255;
                bufferBuilder.begin(3, VertexFormats.POSITION_COLOR);
                bufferBuilder.vertex(matrixStack.peek().getModel(), ItemPipe.x, ItemPipe.y, ItemPipe.z).color(r, g, b, a).next();
                bufferBuilder.vertex(matrixStack.peek().getModel(), ItemPipe.x2, ItemPipe.y2, ItemPipe.z2).color(r, g, b, a).next();
                tessellator.draw();
                RenderSystem.enableBlend();
                RenderSystem.enableTexture();
                RenderSystem.enableBlend();
                RenderSystem.shadeModel(7425);
            }
        }
        if (a > 0) {
            --a;
        }
    }
}
