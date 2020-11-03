package the_beginning_remaster.the_beginning.util;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import the_beginning_remaster.the_beginning.blockentity.renderers.portalrender;

public class TBRenderLayer extends RenderLayer {

    public TBRenderLayer(String name, VertexFormat vertexFormat, int drawMode, int expectedBufferSize, boolean hasCrumbling, boolean translucent, Runnable startAction, Runnable endAction) {
        super(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, startAction, endAction);
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
}
