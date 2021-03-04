package shadowmaster435.the_beginning.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import shadowmaster435.the_beginning.particle.*;

public class TBParticles {
    public static final DefaultParticleType BOUNCE = FabricParticleTypes.simple(true);
    public static final DefaultParticleType SPORE = FabricParticleTypes.simple(true);
    public static final DefaultParticleType WOODCHIP = FabricParticleTypes.simple(true);
    public static final DefaultParticleType SMILE = FabricParticleTypes.simple(true);
    public static final DefaultParticleType VOIDSPOTCH = FabricParticleTypes.simple(true);

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        ParticleFactoryRegistry.getInstance().register(BOUNCE, bounceparticle.BounceFactory::new);
        ParticleFactoryRegistry.getInstance().register(SPORE, SporeParticle.SporeFactory::new);
        ParticleFactoryRegistry.getInstance().register(WOODCHIP, woodchip.woodchipfactory::new);
        ParticleFactoryRegistry.getInstance().register(SMILE, smileparticle.smilefactory::new);
        ParticleFactoryRegistry.getInstance().register(VOIDSPOTCH, voidsplotch.voidsplotchfactory::new);

    }

    public static void init(){
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("the_beginning_remaster", "bounce"), BOUNCE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("the_beginning_remaster", "spore"), SPORE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("the_beginning_remaster", "woodchip"), WOODCHIP);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("the_beginning_remaster", "smile"), SMILE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("the_beginning_remaster", "voidsplotch"), VOIDSPOTCH);

    }
}
