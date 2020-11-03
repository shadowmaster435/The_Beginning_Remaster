package the_beginning_remaster.the_beginning.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import the_beginning_remaster.the_beginning.util.TBDefaultParticleTypes;

@Environment(EnvType.CLIENT)
public class bounceparticle extends SpriteBillboardParticle {
    public bounceparticle(ClientWorld clientWorld, double d, double e, double f) {
        super(clientWorld, d, e, f, 0.0D, 0.0D, 0.0D);
        this.velocityX *= 0.30000001192092896D;
        this.velocityY = Math.random() * 0.20000000298023224D + 0.10000000149011612D;
        this.velocityZ *= 0.30000001192092896D;
        this.setBoundingBoxSpacing(0.01F, 0.01F);
        this.gravityStrength = 0.06F;
        this.maxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;

        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.velocityY -= 0.03D;
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            if (this.onGround) {
                this.velocityY *= -1.0;
                this.velocityX *= 0.0;
                this.velocityZ *= 0.0;
            }

        }
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<TBDefaultParticleTypes> {
        public final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }


        public Particle createParticle(TBDefaultParticleTypes defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            bounceparticle bounce = new bounceparticle(clientWorld, d, e, f);
            bounce.setSprite(this.spriteProvider);
            return bounce;
        }
    }
}
