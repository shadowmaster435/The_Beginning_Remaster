package shadowmaster435.the_beginning.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class woodchip extends SpriteBillboardParticle {
    private static ClientWorld world;
    private final float field_3809;

    public float Sinefunc() {
        return (float) ((float) (Math.sin(this.age) / 8.0) / 16.0);
    }
    public woodchip(ClientWorld world, double x, double y, double z, double Xv, double Yv, double Zv, SpriteProvider sprites) {
        super(world, x, y, z, Xv, Yv, Zv);
        this.velocityX = 0.0D;
        this.velocityY = (Math.random() * 0.1D) + 0.05D;
        this.velocityZ = 0.0D;
        this.gravityStrength = 0f;
        this.field_3809 = ((float)Math.random() - 0.5F) * 0.1F;

        this.setBoundingBoxSpacing(0.01F, 0.01F);
        this.maxAge = (int) (Math.random() * 20) + 50;
        if (Math.random() > 0.5) {
            this.angle += (int) (Math.random() * 20 + 10) * this.age;
        } else {
            this.angle += (int) (Math.random() * -20 - 10) * this.age;
        }
        if (this.age - 50 >= 0) {
            this.colorAlpha = this.age + (this.age * -1);
        }
        setSprite(sprites.getSprite(world.random));
    }


    public void tick() {
            this.prevPosX = this.x;
            this.prevPosY = this.y;
            this.prevPosZ = this.z;
            this.prevAngle = this.angle;
            this.angle += 3.1415927F * this.field_3809 * 2.0F;
            this.scale = 0.15F;

            if (this.age >= 50) {
                this.markDead();
            }
            if (this.onGround) {
                this.markDead();

            } else {
                this.velocityX = 0.3;
                this.velocityZ = 0.3;
                this.velocityY = (this.velocityY - 0.01) + Sinefunc();
            }
                this.move(this.velocityX, this.velocityY, this.velocityZ);
    }
    public ParticleTextureSheet getType() { return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE; }

    @Environment(EnvType.CLIENT)
    public static class woodchipfactory implements ParticleFactory<DefaultParticleType> {

        private final FabricSpriteProvider sprites;

        public woodchipfactory(FabricSpriteProvider sprites) {
            this.sprites = sprites;
        }
        @Override
        public Particle createParticle(DefaultParticleType type, ClientWorld world, double x, double y, double z,  double Xv, double Yv, double Zv) {
            return new woodchip(world, x, y, z,Xv, Yv, Zv , sprites);

        }
    }
}
