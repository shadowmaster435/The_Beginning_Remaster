package shadowmaster435.the_beginning.blockentity.renderers;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.VertexBuffer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import shadowmaster435.the_beginning.blockentity.lightningentity;

public class LightningRender extends BlockEntityRenderer<lightningentity> {
    public static int delay;
    public static float anglerestrict;
    public static float prevoriginx;
    public static float prevoriginy;
    public static float prevoriginz;
    public static float nextoriginx;
    public static float nextoriginy;
    public static float nextoriginz;
    public static DrawableHelper helper;
    public LightningRender(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }
    public static final Identifier tex = new Identifier("the_beginning_remaster:textures/block/blazing_rock.png");
    private final VertexFormat vformat = VertexFormats.POSITION;
    @Nullable
    private final VertexBuffer vbuffer = new VertexBuffer(this.vformat);
    public void render(lightningentity le, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int c, int j) {
        RenderSystem.disableBlend();
        RenderSystem.enableTexture();
        RenderSystem.enableDepthTest();
        RenderSystem.shadeModel(7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        MinecraftClient client = MinecraftClient.getInstance();
        float originx = 0f;
        float originy = 0f;
        float originz = 0f;
        delay++;
        anglerestrict = 1;

        if (helper != null) {
            helper.drawTexture(matrixStack, 16, 16, 0, 0, 16, 16);
            System.out.println("hello");
        }
        bufferBuilder.begin(3, VertexFormats.POSITION_COLOR_TEXTURE);
        for (int pointnumber = 0; pointnumber < 2; ++pointnumber) {
            RenderSystem.lineWidth(64f);
                if (delay >= 0f) {
                    float nextx = (float) (-3 + (Math.random() * 6));
                    float nexty = (float) (-3 + (Math.random() * 6));
                    float nextz = (float) (-3 + (Math.random() * 6));
                    float altx = (float) (-3 + (Math.random() * 6));
                    float alty = (float) (-3 + (Math.random() * 6));
                    float altz = (float) (-3 + (Math.random() * 6));
                    prevoriginx = (originx + nextx);
                    prevoriginy = (originy + nexty);
                    prevoriginz = (originz + nextz);
                    nextoriginx = prevoriginx + altx;
                    nextoriginy = prevoriginy + alty;
                    nextoriginz = prevoriginz + altz;

                    delay = 0;

                }
            float finalendx = nextoriginx;
            float finalendy = nextoriginy;
            float finalendz = nextoriginz;
            float finalstartx = prevoriginx;
            float finalstarty = prevoriginy;
            float finalstartz = prevoriginz;

            if (pointnumber <= 0) {
            bufferBuilder.vertex(matrixStack.peek().getModel(), originx, originy, originz).color(255.0F, 255.0F, 255.0F, 255.0F).next();
            bufferBuilder.vertex(matrixStack.peek().getModel(), finalstartx, finalstarty, finalstartz).color(255.0F, 255.0F, 255.0F, 255.0F).next();
            } else {
            bufferBuilder.vertex(matrixStack.peek().getModel(), finalendx, finalendy, finalendz).color(255.0F, 255.0F, 255.0F, 255.0F).next();
                bufferBuilder.vertex(matrixStack.peek().getModel(), finalstartx, finalstarty, finalstartz).color(255.0F, 255.0F, 255.0F, 255.0F).next();
                }
            }
        ++delay;

        tessellator.draw();
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
}
