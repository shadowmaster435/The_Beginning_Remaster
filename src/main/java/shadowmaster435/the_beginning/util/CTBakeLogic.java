package shadowmaster435.the_beginning.util;


import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.mesh.MeshBuilder;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.minecraft.util.math.Direction;
import shadowmaster435.the_beginning.blockentity.ConnectingTexture;

public class CTBakeLogic {
    public static Direction dir;
    public static void bottomleftnormal() {
        Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();
        emitter.square(dir, 0.0f, 0.0f, 0.5f, 0.5f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[0], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    public static void bottomlefth() {
        Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.0f, 0.0f, 0.5f, 0.5f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[1], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    public static void bottomleftv() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.0f, 0.0f, 0.5f, 0.5f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[2], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }    public static void bottomleftcross() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.0f, 0.0f, 0.5f, 0.5f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[3], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    public static void bottomleftfull() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.0f, 0.0f, 0.5f, 0.5f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[4], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    //
    public static void bottomrightnormal() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.5f, 0.0f, 1.0f, 0.5f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[0], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    public static void bottomrighth() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.5f, 0.0f, 1.0f, 0.5f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[1], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    public static void bottomrightv() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.5f, 0.0f, 1.0f, 0.5f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[2], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }    public static void bottomrightcross() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.5f, 0.0f, 1.0f, 0.5f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[3], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    public static void bottomrightfull() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.5f, 0.0f, 1.0f, 0.5f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[4], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    //
    public static void topleftnormal() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.0f, 0.5f, 0.5f, 1.0f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[0], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    public static void toplefth() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.0f, 0.5f, 0.5f, 1.0f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[1], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    public static void topleftv() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.0f, 0.5f, 0.5f, 1.0f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[2], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }    public static void topleftcross() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.0f, 0.5f, 0.5f, 1.0f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[3], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    public static void topleftfull() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.0f, 0.5f, 0.5f, 1.0f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[4], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    //
    public static void toprightnormal() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.5f, 0.5f, 1.0f, 1.0f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[0], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    public static void toprighth() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.5f, 0.5f, 1.0f, 1.0f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[1], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    public static void toprightv() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.5f, 0.5f, 1.0f, 1.0f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[2], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }    public static void toprightcross() {
                Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.5f, 0.5f, 1.0f, 1.0f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[3], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
    public static void toprightfull() {
        
        Renderer renderContext = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderContext.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        emitter.square(dir, 0.5f, 0.5f, 1.0f, 1.0f, 0.0f);
        emitter.spriteBake(0, ConnectingTexture.SPRITES[4], MutableQuadView.BAKE_LOCK_UV);
        emitter.spriteColor(0, -1, -1, -1, -1);
        emitter.emit();
    }
}
