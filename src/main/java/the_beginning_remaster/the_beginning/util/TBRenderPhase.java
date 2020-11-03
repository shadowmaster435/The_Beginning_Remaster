package the_beginning_remaster.the_beginning.util;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.util.Util;

public class TBRenderPhase extends RenderPhase {
    public TBRenderPhase(String name, Runnable beginAction, Runnable endAction) {
        super(name, beginAction, endAction);
    }
    @Environment(EnvType.CLIENT)
    public static final class BeginningPortalTexturing extends RenderPhase.Texturing {
        private final int layer;

        public BeginningPortalTexturing(int layer) {
            super("beginning_portal_texturing", () -> {
                RenderSystem.matrixMode(5890);
                RenderSystem.pushMatrix();
                RenderSystem.loadIdentity();
                RenderSystem.translatef(0.5F, 0.5F, 0.5F);
                RenderSystem.scalef(0.5F, 0.25F, 0.5F);
                RenderSystem.mulTextureByProjModelView();
                RenderSystem.matrixMode(5888);
                RenderSystem.setupEndPortalTexGen();
            }, () -> {
                RenderSystem.matrixMode(5890);
                RenderSystem.popMatrix();
                RenderSystem.matrixMode(5888);
                RenderSystem.clearTexGen();
            });
            this.layer = layer;
        }
    }
    @Environment(EnvType.CLIENT)
    public static final class BeginningPortalOverlayTexturing extends RenderPhase.Texturing {
        private final int layer;

        public BeginningPortalOverlayTexturing(int layer) {
            super("portal_texturing", () -> {
                RenderSystem.matrixMode(5890);
                RenderSystem.pushMatrix();
                RenderSystem.loadIdentity();
                RenderSystem.scalef(0.5F, 0.5F, 1.0F);
                RenderSystem.translatef(17.0F / (float)layer, (256.0F + (float)layer / 1.5F) * ((float)(Util.getMeasuringTimeMs() % 800000L) / 800000.0F), 0.0F);
                RenderSystem.rotatef(((float)(layer * layer) * 4321.0F + (float)layer * 9.0F) * 2.0F, 0.0F, 0.0F, 1.0F);
                RenderSystem.scalef(4.5F - (float)layer / 4.0F, 4.5F - (float)layer / 4.0F, 1.0F);
                RenderSystem.mulTextureByProjModelView();
                RenderSystem.matrixMode(5888);
                RenderSystem.setupEndPortalTexGen();
            }, () -> {
                RenderSystem.matrixMode(5890);
                RenderSystem.popMatrix();
                RenderSystem.matrixMode(5888);
                RenderSystem.clearTexGen();
            });
            this.layer = layer;
        }
    }
}
