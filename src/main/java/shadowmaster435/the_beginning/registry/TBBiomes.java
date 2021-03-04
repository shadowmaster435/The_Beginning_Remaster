package shadowmaster435.the_beginning.registry;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import shadowmaster435.the_beginning.The_beginning;
import shadowmaster435.the_beginning.biomes.BlazingHills;
import shadowmaster435.the_beginning.dimension.BeginningDim;

import java.util.HashMap;
import java.util.Map;

public class TBBiomes {
    public static final Map<Identifier, TernarySurfaceConfig> CONFIGURED_SURFACE_BUILDERS = new HashMap<>();
    public static final Map<Identifier, SurfaceBuilder<? extends SurfaceConfig>> SURFACE_BUILDERS = new HashMap<>();
    public static final TernarySurfaceConfig LEVEL_BUILDER_CONFIG = new TernarySurfaceConfig(TBBlocks.BLAZING_ROCK.getDefaultState(), TBBlocks.MELTY_ROCK.getDefaultState(), TBBlocks.MELTY_ROCK.getDefaultState());

 //   public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CONFIGURED_LEVEL_BUILDER = add("configured_level_builder", LEVEL_BUILDER_CONFIG);
 public static final RegistryKey<Biome> BLAZING_HILLS = add("level_0_blank", BlazingHills.createBlazingHills());

    private static <SC extends SurfaceConfig> ConfiguredSurfaceBuilder<SC> add(String name, ConfiguredSurfaceBuilder<SC> s) {
        CONFIGURED_SURFACE_BUILDERS.put(The_beginning.id("configured_level_builder"), LEVEL_BUILDER_CONFIG);
        return s;
    }

    private static void addBlazingHills(RegistryKey<Biome> biome, Biome.MixedNoisePoint noise, int weight, boolean temperature, boolean humidity, boolean altitude, boolean weirdness) {
        for (int i = 0; i < weight; i++) {
            BeginningDim.addBlazingHills(biome, new Biome.MixedNoisePoint(BlazingHills.BLAZING_HILLS.getTemperature(), 0f, 64, 0.1f, 1f));
        }
    }
    public static void init() {
        addBlazingHills(BLAZING_HILLS, new Biome.MixedNoisePoint(0.0F, 0.0F, 0.0F, 0.0F, 0.0F), 30, false, false, true, false);

        // Registers all of the surface builders within The Backrooms local registry
        // with the greater surface builder registry
        for (Identifier id : SURFACE_BUILDERS.keySet()) {
            Registry.register(Registry.SURFACE_BUILDER, id, SURFACE_BUILDERS.get(id));
        }
    }
    private static RegistryKey<Biome> add(String s, Biome b) {
        Identifier id = The_beginning.id(s);
        Registry.register(BuiltinRegistries.BIOME, id, b);
        RegistryKey<Biome> key = RegistryKey.of(Registry.BIOME_KEY, id);
        return key;
    }
}
