package shadowmaster435.the_beginning.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class bounceparticle extends SpriteBillboardParticle {
    private static ClientWorld world;
    public float Sinefunc() {
        return (float) ((float) ((float) (Math.sin(this.age) / 8.0) / 8.0) + (Math.random() * 2) - 1);
    }
    public bounceparticle(ClientWorld world, double x, double y, double z, double Xv, double Yv, double Zv, SpriteProvider sprites) {
        super(world, x, y, z, Xv, Yv, Zv);
        this.velocityX *= 0.30000001192092896D;
        this.velocityY = 0.5;
        this.velocityZ *= 0.30000001192092896D;
        this.setBoundingBoxSpacing(0.01F, 0.01F);
        this.gravityStrength = 0.06F;
        this.maxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
        setSprite(sprites.getSprite(world.random));

    }


    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;

        if (this.age++ >= 200) {
            this.markDead();
        } else {
            if (this.onGround) {
                this.velocityY = -velocityY - 0.1 ;
            } else {
                this.velocityY = velocityY - 0.04;
            }


        }
        this.move(this.velocityX, this.velocityY , this.velocityZ);

    }
    public ParticleTextureSheet getType() { return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE; }

    @Environment(EnvType.CLIENT)
    public static class BounceFactory implements ParticleFactory<DefaultParticleType> {

        private final FabricSpriteProvider sprites;

        public BounceFactory(FabricSpriteProvider sprites) {
            this.sprites = sprites;
        }
        @Override
        public Particle createParticle(DefaultParticleType type, ClientWorld world, double x, double y, double z,  double Xv, double Yv, double Zv) {
            return new bounceparticle(world, x, y, z,Xv, Yv, Zv , sprites);

        }
    }
}
