package me.ae0nic.createhighstress;

import com.mojang.logging.LogUtils;
import me.ae0nic.createhighstress.init.BlockInit;
import me.ae0nic.createhighstress.init.CreativeModeTabInit;
import me.ae0nic.createhighstress.init.ItemInit;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IPlatformFluidHelper;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IJeiRuntime;
import mezz.jei.api.runtime.config.IJeiConfigManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CreateHighStress.MODID)
public class CreateHighStress{

    public static final String MODID = "create_high_stress";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreateHighStress() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockInit.register(modEventBus);
        ItemInit.register(modEventBus);
        CreativeModeTabInit.TABS.register(modEventBus);
    }


}
