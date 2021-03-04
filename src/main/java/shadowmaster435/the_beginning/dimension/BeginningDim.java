package shadowmaster435.the_beginning.dimension;

import com.mojang.datafixers.util.Pair;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.MultiNoiseBiomeSource;
import net.minecraft.world.biome.source.VoronoiBiomeAccessType;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import shadowmaster435.the_beginning.The_beginning;
import shadowmaster435.the_beginning.mixin.DimensionInvoker;
import shadowmaster435.the_beginning.mixin.MultinoiseAccessor;
import shadowmaster435.the_beginning.util.DimUtil;

import java.util.*;
import java.util.function.Supplier;

public class BeginningDim {
    public static final RegistryKey<World> TB_WORLD = DimUtil.getWorld(The_beginning.id("the_beginning"));
    public static final RegistryKey<DimensionType> TB_REG_KEY = DimUtil.getDimensionType(The_beginning.id("the_beginning"));
    public static final RegistryKey<DimensionOptions> TB_OPTIONS = DimUtil.getDimensionOptions(The_beginning.id("the_beginning"));
    public static final DimensionType TB_DIM = DimensionInvoker.createDimensionType(OptionalLong.empty(), true, false, false, false, 2.0D, false, false, false, false, false, 256, VoronoiBiomeAccessType.INSTANCE, BlockTags.INFINIBURN_OVERWORLD.getId(), DimensionType.OVERWORLD_ID, 0.0F);

    private static final Map<RegistryKey<Biome>, Biome.MixedNoisePoint> BLAZING_HILLS_NOISE_POINTS = new HashMap<>();

    public static Map<RegistryKey<Biome>, Biome.MixedNoisePoint> getBlazingHillsNoisePoints() {
        return BLAZING_HILLS_NOISE_POINTS;
    }
    public static void addBlazingHills(RegistryKey<Biome> biome, Biome.MixedNoisePoint noise) {
        BLAZING_HILLS_NOISE_POINTS.put(biome, noise);
    }
    public static final MultiNoiseBiomeSource.Preset BLAZING_HILLS_SOURCE = new MultiNoiseBiomeSource.Preset(The_beginning.id("blazing_hills"), (preset, registry, long_) -> {

        List<Pair<Biome.MixedNoisePoint, Supplier<Biome>>> biomes = new ArrayList<>();

        getBlazingHillsNoisePoints().forEach((biomeKey, noisePoint) -> {
            Biome biome = registry.getOrThrow(biomeKey);
            biomes.add(Pair.of(noisePoint, () -> biome));
        });

        return MultinoiseAccessor.createMultiNoiseBiomeSource(long_, biomes, Optional.of(Pair.of(registry, preset)));
    });

    public static ChunkGenerator createTBGenerator(Registry<Biome> biomeRegistry, Registry<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry, long seed) {
        return new NoiseChunkGenerator(BLAZING_HILLS_SOURCE.getBiomeSource(biomeRegistry, seed), seed, () -> chunkGeneratorSettingsRegistry.getOrThrow(ChunkGeneratorSettings.OVERWORLD));
    }
}
