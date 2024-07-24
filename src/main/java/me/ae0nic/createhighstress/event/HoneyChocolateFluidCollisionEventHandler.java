package me.ae0nic.createhighstress.event;

import com.simibubi.create.AllFluids;
import com.simibubi.create.api.event.PipeCollisionEvent;
import com.simibubi.create.foundation.fluid.FluidHelper;
import com.simibubi.create.foundation.utility.Iterate;
import com.sun.jna.platform.win32.WinNT;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.EmptyFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class HoneyChocolateFluidCollisionEventHandler {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void handlePipeFlowCollision(PipeCollisionEvent.Flow event) {
        Fluid f1 = event.getFirstFluid();
        Fluid f2 = event.getSecondFluid();
        if (f1.getFluidType().equals(AllFluids.HONEY.get().getFluidType()) && f2.getFluidType().equals(AllFluids.CHOCOLATE.get().getFluidType())
                || f1.getFluidType().equals(AllFluids.CHOCOLATE.get().getFluidType()) && f2.getFluidType().equals(AllFluids.HONEY.get().getFluidType())) {
            event.setState(Blocks.ANDESITE.defaultBlockState());
        }
    }

    @SubscribeEvent
    public static void fluidMeetEvent(BlockEvent event) {
        if (event.getLevel().isClientSide())
            return;

        BlockPos pos = event.getPos();
        if (!(event.getState().getFluidState().getType() instanceof EmptyFluid)) {
            FluidState fluid = event.getState().getFluidState();
            for (Direction d : Iterate.directions) {
                FluidState neighborFluid = event.getLevel().getFluidState(pos.relative(d));
                if (fluid.getType().getFluidType().equals(AllFluids.HONEY.get().getFluidType())
                        && neighborFluid.getType().getFluidType().equals(AllFluids.CHOCOLATE.get().getFluidType())
                        || fluid.getType().getFluidType().equals(AllFluids.CHOCOLATE.get().getFluidType())
                        && neighborFluid.getType().getFluidType().equals(AllFluids.HONEY.get().getFluidType())) {
                    event.getLevel().setBlock(pos, Blocks.ANDESITE.defaultBlockState(), 0);
                    event.getLevel().playSound(null, pos, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 0.25f, 1.8f);

                }
            }
        }
    }

}
