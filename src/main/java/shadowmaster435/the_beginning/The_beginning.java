package shadowmaster435.the_beginning;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import shadowmaster435.the_beginning.registry.*;

public class The_beginning implements ModInitializer {

    public static final String MOD_ID = "the_beginning_remaster";

    @Override
    public void onInitialize() {
        TBBlocks.init();
        TBParticles.init();
        TBItems.init();
        TBModels.init();

        TBGuis.init();

    }
    public static Identifier id(String id) {
        return new Identifier(MOD_ID, id);
    }
}
