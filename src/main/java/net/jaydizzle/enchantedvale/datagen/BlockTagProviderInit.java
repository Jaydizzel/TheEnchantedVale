package net.jaydizzle.enchantedvale.datagen;

import net.jaydizzle.enchantedvale.EnchantedVale;
import net.jaydizzle.enchantedvale.block.BlockInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BlockTagProviderInit extends BlockTagsProvider {
    public BlockTagProviderInit(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EnchantedVale.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockInit.ENCHANTED_STONE.get())
                .add(BlockInit.ENCHANTED_SMOOTH_STONE.get())
                .add(BlockInit.ENCHANTED_COBBLESTONE.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(BlockInit.ENCHANTED_DIRT.get())
                .add(BlockInit.ENCHANTED_GRASS.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BlockInit.ENCHANTED_LOG.get())
                .add(BlockInit.ENCHANTED_PLANKS.get());
    }
}