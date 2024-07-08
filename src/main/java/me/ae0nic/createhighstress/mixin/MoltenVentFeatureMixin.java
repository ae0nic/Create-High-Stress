package me.ae0nic.createhighstress.mixin;

import com.Apothic0n.MoltenVents.api.biome.features.configurations.MoltenVentConfiguration;
import com.Apothic0n.MoltenVents.api.biome.features.types.MoltenVentFeature;
import me.ae0nic.createhighstress.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MoltenVentFeature.class)
public abstract class MoltenVentFeatureMixin {

    @Inject(method = "place(Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;)Z", at = @At(value = "HEAD"), cancellable = true, remap = false)
    private void createHighStress$place(FeaturePlaceContext<MoltenVentConfiguration> pContext, CallbackInfoReturnable<Boolean> cir) {
        MoltenVentConfiguration configuration = pContext.config();
        BlockPos origin = pContext.origin();
        RandomSource random = pContext.random();
        BlockStateProvider typeProvider = pContext.config().getOuterBlock();
        BlockState type = typeProvider.getState(random, origin);
        if (type.equals(BlockInit.LOTRUM.get().defaultBlockState())) {
            if ( !(((Math.cos(Math.toRadians(120)) * origin.getX() - Math.sin(Math.toRadians(120)) * origin.getZ()) < -500) &&
                    (Math.cos(Math.toRadians(240)) * origin.getX() - Math.sin(Math.toRadians(240)) * origin.getZ()) > 500)) { // Silly goofy math stuff
                cir.setReturnValue(false);
            }
        } else if (type.equals(BlockInit.OSPUM.get().defaultBlockState())) {
            if ( !(((Math.cos(Math.toRadians(240)) * origin.getX() - Math.sin(Math.toRadians(240)) * origin.getZ()) < -500) &&
                    (Math.cos(Math.toRadians(360)) * origin.getX() - Math.sin(Math.toRadians(360)) * origin.getZ()) > 500)) {
                cir.setReturnValue(false);
            }
        } else if (type.equals(BlockInit.OCILIUM.get().defaultBlockState())) {
            if ( !(((Math.cos(Math.toRadians(360)) * origin.getX() - Math.sin(Math.toRadians(360)) * origin.getZ()) < -500) &&
                    (Math.cos(Math.toRadians(120)) * origin.getX() - Math.sin(Math.toRadians(120)) * origin.getZ()) > 500)) {
                cir.setReturnValue(false);
            }
        }
    }

}
