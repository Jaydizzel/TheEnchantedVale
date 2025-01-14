package net.jaydizzle.enchantedvale.datagen;

import net.jaydizzle.enchantedvale.EnchantedVale;
import net.jaydizzle.enchantedvale.block.BlockInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemTagProviderInit extends ItemTagsProvider {
    public ItemTagProviderInit(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                               CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, EnchantedVale.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ItemTags.LOGS_THAT_BURN)
                .add(BlockInit.ENCHANTED_WOOD.get().asItem())
                .add(BlockInit.STRIPPED_ENCHANTED_LOG.get().asItem())
                .add(BlockInit.STRIPPED_ENCHANTED_WOOD.get().asItem())
                .add(BlockInit.ENCHANTED_LOG.get().asItem());

        tag(ItemTags.LOGS)
                .add(BlockInit.ENCHANTED_WOOD.get().asItem())
                .add(BlockInit.STRIPPED_ENCHANTED_LOG.get().asItem())
                .add(BlockInit.STRIPPED_ENCHANTED_WOOD.get().asItem())
                .add(BlockInit.ENCHANTED_LOG.get().asItem());

        tag(ItemTags.PLANKS)
                .add(BlockInit.ENCHANTED_PLANKS.get().asItem());
    }
}