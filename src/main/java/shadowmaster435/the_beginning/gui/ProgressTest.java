package shadowmaster435.the_beginning.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import shadowmaster435.the_beginning.gui.handler.ProgressTestScreen;

public class ProgressTest extends HandledScreen<ProgressTestScreen> {
    private final Identifier TEXTURE = new Identifier("the_beginning_remaster", "textures/gui/test/furnace.png");

    public Identifier background;
    public ProgressTest(ProgressTestScreen handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.background = TEXTURE;
    }

    @Override
    public void init() {
        super.init();
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
    }
    public void tick() {
        super.tick();
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        assert this.client != null;
        this.client.getTextureManager().bindTexture(this.TEXTURE);
        int i = this.x;
        int j = this.y;
        this.drawTexture(matrices, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        int l;


        l = this.handler.getCookProgress();

        this.drawTexture(matrices, i + 79, j + 34, 176, 14, l + 1, 16);
    }

}
