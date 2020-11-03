package the_beginning_remaster.the_beginning.util;

import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.registry.Registry;

public class TBParticleTypes extends ParticleTypes {
    public static final TBDefaultParticleTypes BOUNCE;

    private static TBDefaultParticleTypes register(String name, boolean alwaysShow) {
        return (TBDefaultParticleTypes) Registry.register(Registry.PARTICLE_TYPE, (String)name, new TBDefaultParticleTypes(alwaysShow));
    }

    static {
        BOUNCE = register("the_beginning_remaster:bounce", false);
    }
}
