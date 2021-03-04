package shadowmaster435.the_beginning.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class smileparticle extends AnimatedParticle {
    private static ClientWorld world;
    public float Sinefunc() {
        return (float) ((float) ((float) (Math.sin(this.age) / 8.0) / 8.0) + (Math.random() * 2) - 1);
    }
    public smileparticle(ClientWorld world, double x, double y, double z, double Xv, double Yv, double Zv, SpriteProvider sprites) {
        super(world, x, y, z, sprites, 0);
        this.velocityX *= 0.30000001192092896D;
        this.velocityY = Math.random() * 0.20000000298023224D + 0.10000000149011612D;
        this.velocityZ *= 0.30000001192092896D;
        this.setBoundingBoxSpacing(0.01F, 0.01F);
        this.gravityStrength = 0.06F;
        this.maxAge = 50;
        this.setTargetColor(15916745);

        this.setSprite(spriteProvider.getSprite((int) Math.floor(this.age / 4f), (int) Math.floor(this.maxAge / 4f)));
        this.setSpriteForAge(spriteProvider);

    }


    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;

        if (this.age++ >= 200) {
            this.markDead();
        }
        if (age >= 160) {
            this.setColorAlpha((age - 160f) / 40f);
        }
    }
    public ParticleTextureSheet getType() { return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT; }

    @Environment(EnvType.CLIENT)
    public static class smilefactory implements ParticleFactory<DefaultParticleType> {

        private final FabricSpriteProvider sprites;

        public smilefactory(FabricSpriteProvider sprites) {
            this.sprites = sprites;
        }
        @Override
        public Particle createParticle(DefaultParticleType type, ClientWorld world, double x, double y, double z,  double Xv, double Yv, double Zv) {
            return new smileparticle(world, x, y, z,Xv, Yv, Zv , sprites);

        }
    }
}
