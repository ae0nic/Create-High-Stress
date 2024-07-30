package me.ae0nic.createhighstress.init;

import com.sun.jna.platform.win32.NTSecApi;
import me.ae0nic.createhighstress.CreateHighStress;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.RandomSequence;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Random;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT, modid = CreateHighStress.MODID)
public class ColorResolverInit {
    @SubscribeEvent
    public static void registerColorResolver(RegisterColorHandlersEvent.Block event) {
        CreateHighStress.LOGGER.info("Registering block colors");
        event.getBlockColors().register(new RandomBlockColor(), BlockInit.LOTRUM.get(), BlockInit.OSPUM.get(), BlockInit.OCILIUM.get());
    }

    private static class RandomBlockColor implements BlockColor {
        private final PerlinNoise random = PerlinNoise.create(RandomSource.create(), 1, 1);
        @Override
        public int getColor(BlockState pState, @Nullable BlockAndTintGetter pLevel, @Nullable BlockPos pPos, int pTintIndex) {
            int r = 255 - ((int) ((random.getValue(pPos.getX() / 2.0, pPos.getY() / 2.0, pPos.getZ() / 2.0) + 1) * 40));
            int g = 255 - ((int) ((random.getValue(pPos.getX() / 2.0, pPos.getY() / 2.0, pPos.getZ() / 2.0) + 1) * 40));
            int b = 255 - ((int) ((random.getValue(pPos.getX() / 2.0, pPos.getY() / 2.0, pPos.getZ() / 2.0) + 1) * 40));
            int color = Integer.rotateLeft(r, 16) + Integer.rotateLeft(g, 8) + b;
            return color;
        }
    }
}
