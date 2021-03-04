package shadowmaster435.the_beginning.mixin;


import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(WorldRenderer.class)
class WorldRendererMixin {

    @Shadow
    @Final
    private MinecraftClient client;

    @Shadow
    @Final
    private TextureManager textureManager;

    @Unique
    private static final Identifier POINT_ONE_SKY = new Identifier("textures/environment/end_sky.png");

    @Inject(method = "renderSky", at = @At("HEAD"))
    private void theGarden_renderSky(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        this.renderPointOneSky(matrices);
    }

    @Unique
    private void renderPointOneSky(MatrixStack matrices) {
        RenderSystem.disableAlphaTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);
        textureManager.bindTexture(new Identifier("the_beginning_remaster:textures/block/template.png"));
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();

        matrices.push();
        double Sinefunc = (Math.sin(MinecraftClient.getInstance().getTickDelta() / 8.0) / 8.0);
        matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(180.0F));
        matrices.translate(1, 1 - Sinefunc, 1);
        Matrix4f matrix4f = matrices.peek().getModel();
        bufferBuilder.begin(7, VertexFormats.POSITION_TEXTURE_COLOR);
        bufferBuilder.vertex(matrix4f, -100, -20, -100).texture(0.0F, 0.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, -100, -20, 100).texture(0.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, 100, -20, 100).texture(1.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, 100, -20, -100).texture(1.0F, 0.0F).color(255, 255, 255, 255).next();
        tessellator.draw();
        matrices.pop();

        RenderSystem.depthMask(true);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
        RenderSystem.enableAlphaTest();
    }

}
