package me.ae0nic.createhighstress.init;
import com.Apothic0n.MoltenVents.core.objects.ActiveMoltenBlock;
import com.Apothic0n.MoltenVents.core.objects.DormantMoltenBlock;
import com.Apothic0n.MoltenVents.core.objects.MoltenBlocks;
import me.ae0nic.createhighstress.CreateHighStress;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CreateHighStress.MODID);
    public static final RegistryObject<Block> LOTRUM = registerWithBlockItem("lotrum", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> OSPUM = registerWithBlockItem("ospum", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> OCILIUM = registerWithBlockItem("ocilium", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static <T extends Block> RegistryObject<T> registerWithBlockItem(String name, Supplier<T> supplier) {
        RegistryObject<T> toReturn = BLOCKS.register(name, supplier);
        ItemInit.registerBlockItem(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    public static void register(IEventBus bus) {
        MoltenBlocks.moltenBlocks.add(MoltenBlocks.createMoltenBlocks("lotrum"));
        MoltenBlocks.moltenBlocks.add(MoltenBlocks.createMoltenBlocks("ospum"));
        MoltenBlocks.moltenBlocks.add(MoltenBlocks.createMoltenBlocks("ocilium"));


        BLOCKS.register(bus);
    }
}
