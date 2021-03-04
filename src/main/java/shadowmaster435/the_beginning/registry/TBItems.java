package shadowmaster435.the_beginning.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import shadowmaster435.the_beginning.item.GlintTest;
import shadowmaster435.the_beginning.item.rclicktest;

public class TBItems {
    public static final rclicktest FABRIC_ITEM = new rclicktest(new FabricItemSettings().group(ItemGroup.MISC));
    public static final GlintTest GLINT_TEST = new GlintTest(new FabricItemSettings().group(ItemGroup.MISC));

    public static void init(){
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "fabric_item"), FABRIC_ITEM);
        Registry.register(Registry.ITEM, new Identifier("the_beginning_remaster", "glinttest"), GLINT_TEST);
    }
}
