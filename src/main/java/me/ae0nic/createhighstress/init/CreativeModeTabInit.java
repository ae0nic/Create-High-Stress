package me.ae0nic.createhighstress.init;

import me.ae0nic.createhighstress.CreateHighStress;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class CreativeModeTabInit {
    public static final List<RegistryObject<? extends ItemLike>> tabItems = new ArrayList<>();
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateHighStress.MODID);
    public static final RegistryObject<CreativeModeTab> TAB = TABS.register("create_high_stress", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("item_group.create_high_stress"))
                    .icon(() -> new ItemStack(BlockInit.LOTRUM.get().asItem()))
                    .displayItems((params, output) -> {
                        for (RegistryObject<? extends ItemLike> item : tabItems) {
                            output.accept(item.get());
                        }
                    })
                    .build()
    );
}
