package shadowmaster435.the_beginning.mixin;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemRenderer.class)
public class ItemRenderMixin {
    @Shadow
    private void renderBakedItemModel(BakedModel model, ItemStack stack, int light, int overlay, MatrixStack matrices, VertexConsumer vertices) {
    }

  /*  @Inject(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At("TAIL"))
    public void renderItem(ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel model, CallbackInfo ci) {
        if (!stack.isEmpty()) {

            matrices.push();
            shadowmaster435.the_beginning.util.ItemStackGlints item = new shadowmaster435.the_beginning.util.ItemStackGlints();
            Item itemStack = ItemStack.EMPTY.getItem();
            VertexConsumer vertexConsumer4 = null;
            boolean bl64;
            if (renderMode != ModelTransformation.Mode.GUI && !renderMode.isFirstPerson() && stack.getItem() instanceof BlockItem) {
                Block block = ((BlockItem) stack.getItem()).getBlock();
                bl64 = !(block instanceof TransparentBlock) && !(block instanceof StainedGlassPaneBlock);
            } else {
                bl64 = true;
            }
            RenderLayer renderLayer = RenderLayers.getItemLayer(stack, bl64);
       
            if (bl64) {
                if (stack.getItem() == TBItems.GLINT_TEST) {
                    vertexConsumer4 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, renderLayer, true, true);
                }
            } else {
                if (stack.getItem() == TBItems.GLINT_TEST) {
                    vertexConsumer4 = ItemRenderer.getItemGlintConsumer(vertexConsumers, renderLayer, true,true);
                }
            }

            this.renderBakedItemModel(model, stack, light, overlay, matrices, vertexConsumer4);

            matrices.pop();
        }
    }

   */

}
