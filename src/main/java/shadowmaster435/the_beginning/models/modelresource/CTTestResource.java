package shadowmaster435.the_beginning.models.modelresource;

import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelProviderException;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import shadowmaster435.the_beginning.blockentity.ConnectingTexture;
import shadowmaster435.the_beginning.models.CTTestModel;

public class CTTestResource implements ModelResourceProvider {
    public static final Identifier CTMODEL = new Identifier("the_beginning_remaster:block/cttest");
    public static final Identifier BASE = new Identifier("the_beginning_remaster:block/cttestbase");
    public static BakedModel bakedModel;
    public static Sprite[] sprite;
    public static World pos;

    @Override
    public UnbakedModel loadModelResource(Identifier identifier, ModelProviderContext modelProviderContext) throws ModelProviderException {
        if(identifier.equals(CTMODEL)) {
            return new CTTestModel();
        } else if (identifier.equals(BASE)) {
            return new ConnectingTexture((UnbakedModel) bakedModel, sprite);
        } else {
                return null;
            }
        }
    }
