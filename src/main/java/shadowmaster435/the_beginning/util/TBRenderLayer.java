package shadowmaster435.the_beginning.util;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import shadowmaster435.the_beginning.blockentity.renderers.LightningRender;
import shadowmaster435.the_beginning.blockentity.renderers.portalrender;

public class TBRenderLayer extends RenderLayer {

    private static final RenderLayer TEST;

    public TBRenderLayer(String name, VertexFormat vertexFormat, int drawMode, int expectedBufferSize, boolean hasCrumbling, boolean translucent, Runnable startAction, Runnable endAction) {
        super(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, startAction, endAction);
    }
    public static RenderLayer getTestGlint() {

        return of("glint", VertexFormats.POSITION_TEXTURE, 7, 256, RenderLayer.MultiPhaseParameters.builder().texture(new RenderPhase.Texture(TBItemGlints.TESTGLINT, true, false)).writeMaskState(COLOR_MASK).cull(DISABLE_CULLING).depthTest(EQUAL_DEPTH_TEST).transparency(GLINT_TRANSPARENCY).texturing(GLINT_TEXTURING).build(false));
    }
    public static RenderLayer getLightningrender(int layer) {
        RenderPhase.Texture texture1;
        RenderPhase.Transparency transparency1 = null;
        transparency1 = NO_TRANSPARENCY;

        texture1 = new RenderPhase.Texture(LightningRender.tex, false, false);
        return of("lightningrender", VertexFormats.POSITION_COLOR, 7, 256, false, false, RenderLayer.MultiPhaseParameters.builder().transparency(transparency1).texture(texture1).texturing(new TBRenderPhase.BeginningPortalOverlayTexturing(layer)).fog(NO_FOG).build(false));

    }

    public static RenderLayer getTestPortal(int layer) {
        RenderPhase.Transparency transparency2;
        RenderPhase.Texture texture2;
        RenderPhase.Transparency transparency1 = null;
        RenderPhase.Texture texture1 = null;
        if (layer <= 1) {
            transparency2 = NO_TRANSPARENCY;
            texture2 = new RenderPhase.Texture(portalrender.SKY_TEXTURE, false, false);
        } else {
            if (layer > 1) {
                transparency1 = TRANSLUCENT_TRANSPARENCY;
                texture1 = new RenderPhase.Texture(portalrender.PORTAL_TEXTURE, false, false);
            }
            return of("test_portal", VertexFormats.POSITION_COLOR, 7, 256, false, false, RenderLayer.MultiPhaseParameters.builder().transparency(transparency1).texture(texture1).texturing(new TBRenderPhase.BeginningPortalOverlayTexturing(layer)).fog(NO_FOG).build(false));

        }

        return of("test_portal", VertexFormats.POSITION_COLOR, 7, 256, false, false, RenderLayer.MultiPhaseParameters.builder().transparency(transparency2).texture(texture2).texturing(new TBRenderPhase.BeginningPortalTexturing(layer)).fog(NO_FOG).build(false));
    }
    public static RenderLayer getLightning() {
        return TESTLIGHTNING;
    }

    private static final RenderLayer TESTLIGHTNING;

    static {
        TESTLIGHTNING = of("lightning", VertexFormats.POSITION_COLOR, 7, 256, false, true, RenderLayer.MultiPhaseParameters.builder().writeMaskState(ALL_MASK).transparency(LIGHTNING_TRANSPARENCY).target(WEATHER_TARGET).shadeModel(SMOOTH_SHADE_MODEL).build(false));
        TEST = of("glint", VertexFormats.POSITION_TEXTURE, 7, 256, RenderLayer.MultiPhaseParameters.builder().texture(new RenderPhase.Texture(TBItemGlints.TESTGLINT, true, false)).writeMaskState(COLOR_MASK).cull(DISABLE_CULLING).depthTest(EQUAL_DEPTH_TEST).transparency(GLINT_TRANSPARENCY).texturing(GLINT_TEXTURING).build(false));
    }
}
