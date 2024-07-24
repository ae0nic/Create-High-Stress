package me.ae0nic.createhighstress.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

public class CobbleGenRecipeCategory implements IRecipeCategory<CobbleGenRecipeWrapper> {

    private final IGuiHelper guiHelper;

    public CobbleGenRecipeCategory(IGuiHelper helper) {
        this.guiHelper = helper;
    }


    @Override
    public @NotNull RecipeType<CobbleGenRecipeWrapper> getRecipeType() {
        return new RecipeType<>(new ResourceLocation("create_high_stress", "cobblestone_generation_category"),
                CobbleGenRecipeWrapper.class);
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("create_high_stress.recipe.cobblestone");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return guiHelper.createBlankDrawable(66, 36);
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, Items.COBBLESTONE.getDefaultInstance());
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull CobbleGenRecipeWrapper cobbleGenRecipeWrapper, @NotNull IFocusGroup iFocusGroup) {
        ItemStack output = cobbleGenRecipeWrapper.generatedBlock.getBlock().asItem().getDefaultInstance();
        Fluid fluid1 = cobbleGenRecipeWrapper.fluid1;
        Fluid fluid2 = cobbleGenRecipeWrapper.fluid2;

        builder.addSlot(RecipeIngredientRole.INPUT, 8, 10).addFluidStack(fluid1, 1000);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 25, 10).addItemStack(output);
        builder.addSlot(RecipeIngredientRole.INPUT, 42, 10).addFluidStack(fluid2, 1000);

    }
}
