package net.jaydizzle.enchantedvale.datagen;

import net.jaydizzle.enchantedvale.block.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class LootTableProviderInit extends BlockLootSubProvider {
    protected LootTableProviderInit(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        dropSelf(BlockInit.ENCHANTED_COBBLESTONE.get());
        dropSelf(BlockInit.ENCHANTED_SMOOTH_STONE.get());
        dropSelf(BlockInit.ENCHANTED_STONE.get());
        dropSelf(BlockInit.ENCHANTED_DIRT.get());
        dropSelf(BlockInit.ENCHANTED_PLANKS.get());
        dropSelf(BlockInit.ENCHANTED_LOG.get());

        this.add(BlockInit.ENCHANTED_GRASS.get(), block -> this.createSingleItemTableWithSilkTouch(block, BlockInit.ENCHANTED_DIRT.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
