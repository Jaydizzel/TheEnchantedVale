package net.jaydizzle.enchantedvale.datagen;

import net.jaydizzle.enchantedvale.EnchantedVale;
import net.jaydizzle.enchantedvale.block.BlockInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeProviderInit extends RecipeProvider implements IConditionBuilder {
    public RecipeProviderInit(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> ENCHANTED_COBBLESTONE_SMELTABLES = List.of(BlockInit.ENCHANTED_COBBLESTONE);
        List<ItemLike> ENCHANTED_STONE_SMELTABLES = List.of(BlockInit.ENCHANTED_STONE);
        List<ItemLike> ENCHANTED_LOG_SMELTABLES = List.of(BlockInit.ENCHANTED_LOG, BlockInit.STRIPPED_ENCHANTED_LOG, BlockInit.ENCHANTED_WOOD, BlockInit.STRIPPED_ENCHANTED_WOOD);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockInit.ENCHANTED_WOOD.get(), 3)
                .pattern("BB")
                .pattern("BB")
                .define('B', BlockInit.ENCHANTED_LOG.get())
                .unlockedBy("has_enchanted_log", has(BlockInit.ENCHANTED_LOG.get())).save(pRecipeOutput, "enchantedvale:enchanted_log1");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockInit.STRIPPED_ENCHANTED_WOOD.get(), 3)
                .pattern("BB")
                .pattern("BB")
                .define('B', BlockInit.STRIPPED_ENCHANTED_LOG.get())
                .unlockedBy("has_enchanted_log", has(BlockInit.ENCHANTED_LOG.get())).save(pRecipeOutput, "enchantedvale:enchanted_log2");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 16)
                .pattern("B")
                .pattern("B")
                .define('B', BlockInit.ENCHANTED_LOG.get())
                .unlockedBy("has_enchanted_log", has(BlockInit.ENCHANTED_LOG.get())).save(pRecipeOutput, "enchantedvale:enchanted_log3");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 16)
                .pattern("L")
                .pattern("L")
                .define('L', BlockInit.STRIPPED_ENCHANTED_LOG.get())
                .unlockedBy("has_enchanted_log", has(BlockInit.ENCHANTED_LOG.get())).save(pRecipeOutput, "enchantedvale:enchanted_log4");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
                .pattern("L")
                .pattern("L")
                .define('L', BlockInit.ENCHANTED_PLANKS.get())
                .unlockedBy("has_enchanted_log", has(BlockInit.ENCHANTED_LOG.get())).save(pRecipeOutput, "enchantedvale:enchanted_log5");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlockInit.ENCHANTED_PLANKS.get(), 4)
                .requires(BlockInit.ENCHANTED_LOG.get())
                .unlockedBy("has_enchanted_log", has(BlockInit.ENCHANTED_LOG.get())).save(pRecipeOutput, "enchantedvale:enchanted_log6");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlockInit.ENCHANTED_PLANKS.get(), 4)
                .requires(BlockInit.STRIPPED_ENCHANTED_LOG.get())
                .unlockedBy("has_enchanted_log", has(BlockInit.ENCHANTED_LOG.get())).save(pRecipeOutput, "enchantedvale:enchanted_log7");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlockInit.ENCHANTED_PLANKS.get(), 4)
                .requires(BlockInit.ENCHANTED_WOOD.get())
                .unlockedBy("has_enchanted_log", has(BlockInit.ENCHANTED_LOG.get())).save(pRecipeOutput, "enchantedvale:enchanted_log8");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlockInit.ENCHANTED_PLANKS.get(), 4)
                .requires(BlockInit.STRIPPED_ENCHANTED_WOOD.get())
                .unlockedBy("has_enchanted_log", has(BlockInit.ENCHANTED_LOG.get())).save(pRecipeOutput, "enchantedvale:enchanted_log9");

        oreSmelting(pRecipeOutput, ENCHANTED_LOG_SMELTABLES, RecipeCategory.MISC, Items.CHARCOAL, 0.25f, 200, "enchanted_log_smelt");
        oreSmelting(pRecipeOutput, ENCHANTED_COBBLESTONE_SMELTABLES, RecipeCategory.MISC, BlockInit.ENCHANTED_STONE.get(), 0.25f, 200, "enchanted_stone");
        oreSmelting(pRecipeOutput, ENCHANTED_STONE_SMELTABLES, RecipeCategory.MISC, BlockInit.ENCHANTED_SMOOTH_STONE.get(), 0.25f, 200, "enchanted_smooth_stone");

    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, EnchantedVale.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}