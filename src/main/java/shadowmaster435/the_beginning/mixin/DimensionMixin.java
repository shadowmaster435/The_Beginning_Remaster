package shadowmaster435.the_beginning.mixin;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.Lifecycle;
import net.minecraft.util.registry.*;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import shadowmaster435.the_beginning.dimension.BeginningDim;

import java.util.Optional;

@Mixin(DimensionType.class)
public class DimensionMixin {
    @Inject(method = "addRegistryDefaults", at = @At("TAIL"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private static void TB_addRegistryDefaults(DynamicRegistryManager.Impl registryManager, CallbackInfoReturnable<DynamicRegistryManager.Impl> ci, MutableRegistry<DimensionType> mutableRegistry) {
        mutableRegistry.add(BeginningDim.TB_REG_KEY, BeginningDim.TB_DIM, Lifecycle.stable());

    }

    @Inject(method = "createDefaultDimensionOptions", at = @At("TAIL"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private static void TB_createDefaultDimensionOptions(Registry<DimensionType> dimensionRegistry, Registry<Biome> biomeRegistry, Registry<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry, long seed, CallbackInfoReturnable<SimpleRegistry<DimensionOptions>> ci, SimpleRegistry<DimensionOptions> simpleRegistry) {
        simpleRegistry.add(BeginningDim.TB_OPTIONS, new DimensionOptions(() -> dimensionRegistry.getOrThrow(BeginningDim.TB_REG_KEY), BeginningDim.createTBGenerator(biomeRegistry, chunkGeneratorSettingsRegistry, seed)), Lifecycle.stable());
    }
    @Inject(method = "method_28521", at = @At("TAIL"), cancellable = true)
    private static void TB_method_28521(Dynamic<?> dynamic, CallbackInfoReturnable<DataResult<RegistryKey<World>>> ci) {
        Optional<Number> optional = dynamic.asNumber().result();
        if (optional.isPresent()) {
            int i = optional.get().intValue();
            if (i == 122) {
                ci.setReturnValue(DataResult.success(BeginningDim.TB_WORLD));
            }
        }
    }
}
