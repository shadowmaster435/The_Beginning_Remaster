package shadowmaster435.the_beginning.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

public class BlazingHills {
    public static final Biome BLAZING_HILLS = createBlazingHills();

    public static Biome createBlazingHills() {

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        GenerationSettings.Builder builder = (new GenerationSettings.Builder());
       // builder.surfaceBuilder();

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.NONE)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x0000ff)
                        .waterFogColor(0x0000ff)
                        .fogColor(0xd96900)
                        .skyColor(0xd92400)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

}
