package shadowmaster435.the_beginning.registry;

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import shadowmaster435.the_beginning.gui.ProgressTest;
import shadowmaster435.the_beginning.gui.handler.ProgressTestScreen;

public class TBGuis {
    public static ScreenHandlerType<ProgressTestScreen> PROGRESS_TEST_SCREEN_SCREEN_HANDLER_TYPE;
    public static final Identifier progress = new Identifier("the_beginning_remaster", "progress");

    public static void init() {
        PROGRESS_TEST_SCREEN_SCREEN_HANDLER_TYPE = ScreenHandlerRegistry.registerExtended(progress, ProgressTestScreen::new);
    }
    public static void initClient() {
        ScreenRegistry.register(PROGRESS_TEST_SCREEN_SCREEN_HANDLER_TYPE, ProgressTest::new);

    }
}
