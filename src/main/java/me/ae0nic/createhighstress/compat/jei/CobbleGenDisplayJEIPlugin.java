package me.ae0nic.createhighstress.compat.jei;

import com.simibubi.create.AllFluids;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import me.ae0nic.createhighstress.CreateHighStress;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

@JeiPlugin
public class CobbleGenDisplayJEIPlugin implements IModPlugin {
    private static final ResourceLocation UID = new ResourceLocation(CreateHighStress.MODID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CobbleGenRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        List<CobbleGenRecipeWrapper> recipes = List.of(
                new CobbleGenRecipeWrapper(Blocks.COBBLESTONE.defaultBlockState(), Fluids.WATER, Fluids.LAVA),
                new CobbleGenRecipeWrapper(AllPaletteStoneTypes.LIMESTONE.getBaseBlock().get().defaultBlockState(), AllFluids.HONEY.getSource(), Fluids.LAVA),
                new CobbleGenRecipeWrapper(AllPaletteStoneTypes.SCORIA.getBaseBlock().get().defaultBlockState(), AllFluids.CHOCOLATE.getSource(), Fluids.LAVA),
                new CobbleGenRecipeWrapper(Blocks.ANDESITE.defaultBlockState(), AllFluids.CHOCOLATE.getSource(), AllFluids.HONEY.getSource()));
        registration.addRecipes(new RecipeType<>(new ResourceLocation(CreateHighStress.MODID, "cobblestone_generation_category"), CobbleGenRecipeWrapper.class), recipes);
    }
}
