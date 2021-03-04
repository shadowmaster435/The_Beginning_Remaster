package shadowmaster435.the_beginning.registry;

import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import shadowmaster435.the_beginning.models.modelresource.CTTestResource;
import shadowmaster435.the_beginning.objloader.ItemObjLoader;
import shadowmaster435.the_beginning.objloader.OBJLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TBModels {
    public static Logger LOGGER = LogManager.getLogger("The Beginning");
    public static void init() {
        ModelLoadingRegistry.INSTANCE.registerResourceProvider(OBJLoader.INSTANCE);
        ModelLoadingRegistry.INSTANCE.registerVariantProvider(ItemObjLoader.INSTANCE);
    }
    public static void initClient() {
        ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> new CTTestResource());
    }
}
