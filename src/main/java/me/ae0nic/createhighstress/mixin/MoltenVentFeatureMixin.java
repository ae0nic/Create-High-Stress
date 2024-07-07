package me.ae0nic.createhighstress.mixin;

import com.Apothic0n.MoltenVents.api.biome.features.configurations.MoltenVentConfiguration;
import com.Apothic0n.MoltenVents.api.biome.features.types.MoltenVentFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MoltenVentFeature.class)
public abstract class MoltenVentFeatureMixin {
    @Inject(method = "place", at = @At(value = "HEAD"), cancellable = true)
    private void createHighStress$place(FeaturePlaceContext<MoltenVentConfiguration> pContext, CallbackInfoReturnable<Boolean> cir) {
        MoltenVentConfiguration configuration = (MoltenVentConfiguration) pContext.config();
        BlockPos origin = pContext.origin();
        RandomSource random = pContext.random();
        BlockStateProvider type = pContext.config().getInnerBlock();

    }
}
