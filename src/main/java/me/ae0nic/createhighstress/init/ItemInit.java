package me.ae0nic.createhighstress.init;

import me.ae0nic.createhighstress.CreateHighStress;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemInit {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateHighStress.MODID);


    public static void registerBlockItem(String name, Supplier<BlockItem> block) {
        ITEMS.register(name, block);
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
