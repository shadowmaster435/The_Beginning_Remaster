package the_beginning_remaster.the_beginning.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.minecraft.util.registry.Registry;
import the_beginning_remaster.the_beginning.The_beginning;
import the_beginning_remaster.the_beginning.blockentity.renderers.animationtestrender;
import the_beginning_remaster.the_beginning.blockentity.renderers.portalrender;
import the_beginning_remaster.the_beginning.util.TBDefaultParticleTypes;

@Environment(EnvType.CLIENT)
public class The_beginningClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(The_beginning.DEMO_BLOCK_ENTITY, animationtestrender::new);
        BlockEntityRendererRegistry.INSTANCE.register(The_beginning.PORTAL_ENTITY, portalrender::new);
    }
}
