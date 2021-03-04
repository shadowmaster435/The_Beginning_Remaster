package shadowmaster435.the_beginning.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import shadowmaster435.the_beginning.gravity.PlayerGravity;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Inject(method = "tickMovement", at = @At("TAIL"))
    public void gravity(CallbackInfo ci) {
        PlayerGravity.GravUtil();
    }
}
