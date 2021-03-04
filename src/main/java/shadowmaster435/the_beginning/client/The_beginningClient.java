package shadowmaster435.the_beginning.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import shadowmaster435.the_beginning.registry.TBBlocks;
import shadowmaster435.the_beginning.registry.TBGuis;
import shadowmaster435.the_beginning.registry.TBModels;
import shadowmaster435.the_beginning.registry.TBParticles;

@Environment(EnvType.CLIENT)
public class The_beginningClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        TBBlocks.initClient();
        TBParticles.initClient();
        TBModels.initClient();
        TBGuis.initClient();
    }
}
