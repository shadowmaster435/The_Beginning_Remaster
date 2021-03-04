package shadowmaster435.the_beginning.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class voidsplotch extends SpriteBillboardParticle {
    private static ClientWorld world;
    public float Sinefunc() {
        return (float) ((float) ((float) (Math.sin(this.age) / 8.0) / 8.0) + (Math.random() * 2) - 1);
    }
    public voidsplotch(ClientWorld world, double x, double y, double z, double Xv, double Yv, double Zv, SpriteProvider sprites) {
        super(world, x, y, z, Xv, Yv, Zv);
        this.velocityX *= 0;
        this.velocityY = 0;
        this.velocityZ *= 0;
        this.setBoundingBoxSpacing(0.01F, 0.01F);
        this.gravityStrength = 0.06F;
        this.maxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
        setSprite(sprites.getSprite(world.random));

    }

    public static float tickdelta = 0;
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;

        tickdelta += 1;
        if (this.age++ >= 200) {
            this.markDead();
           /* this.scale = 0;
            this.colorAlpha = 0;*/
        } else {
            this.velocityY = (Sinefunc() / 4) + 0.025f;
            if (this.age >= 150) {
                if (this.scale > 0) {
                    this.scale = ((Sinefunc() / 4 + 0.25f)) - 0.025f;
                }
            } else {
                this.scale = (Sinefunc() / 4) + 0.5f;
            }
           /* if (tickdelta >= 3) {
                this.velocityX = (Sinefunc() / 16) * 2;
                this.velocityY = (Sinefunc() / 16) * 2;
                this.velocityZ = (Sinefunc() / 16) * 2;
                tickdelta = 0;
            }*/
        }
        /*if (this.age >= 100) {
            if (scale > 0) {
                this.scale -= 0.002f;
            }

            if (this.colorAlpha <= 0) {
                this.scale = 0;
                this.colorAlpha = 0;
            } else {
                this.colorAlpha -= 0.01f;

            }
        }*/

        this.move(this.velocityX, this.velocityY , this.velocityZ);

    }
    public ParticleTextureSheet getType() { return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT; }

    @Environment(EnvType.CLIENT)
    public static class voidsplotchfactory implements ParticleFactory<DefaultParticleType> {

        private final FabricSpriteProvider sprites;

        public voidsplotchfactory(FabricSpriteProvider sprites) {
            this.sprites = sprites;
        }
        @Override
        public Particle createParticle(DefaultParticleType type, ClientWorld world, double x, double y, double z,  double Xv, double Yv, double Zv) {
            return new voidsplotch(world, x, y, z,Xv, Yv, Zv , sprites);

        }
    }
}
