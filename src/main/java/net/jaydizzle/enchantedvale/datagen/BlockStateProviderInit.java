package net.jaydizzle.enchantedvale.datagen;

import net.jaydizzle.enchantedvale.EnchantedVale;
import net.jaydizzle.enchantedvale.block.BlockInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BlockStateProviderInit extends BlockStateProvider {
    public BlockStateProviderInit(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EnchantedVale.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlockInit.ENCHANTED_STONE);
        blockWithItem(BlockInit.ENCHANTED_PLANKS);

        axisBlock(((RotatedPillarBlock) BlockInit.ENCHANTED_WOOD.get()), blockTexture(BlockInit.ENCHANTED_LOG.get()), blockTexture(BlockInit.ENCHANTED_LOG.get()));
        blockItem(BlockInit.ENCHANTED_WOOD);

        logBlock(((RotatedPillarBlock) BlockInit.ENCHANTED_LOG.get()));
        blockItem(BlockInit.ENCHANTED_LOG);

        axisBlock(((RotatedPillarBlock) BlockInit.STRIPPED_ENCHANTED_WOOD.get()), blockTexture(BlockInit.STRIPPED_ENCHANTED_LOG.get()), blockTexture(BlockInit.STRIPPED_ENCHANTED_LOG.get()));
        blockItem(BlockInit.STRIPPED_ENCHANTED_WOOD);

        logBlock(((RotatedPillarBlock) BlockInit.STRIPPED_ENCHANTED_LOG.get()));
        blockItem(BlockInit.STRIPPED_ENCHANTED_LOG);

        blockWithItem(BlockInit.ENCHANTED_COBBLESTONE);

        blockWithItem(BlockInit.ENCHANTED_GRASS);

        blockWithItem(BlockInit.ENCHANTED_DIRT);
        blockWithItem(BlockInit.ENCHANTED_SMOOTH_STONE);
    }

    private void leavesBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(deferredBlock.get())).renderType("cutout"));
    }

    private void saplingBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlock(deferredBlock.get(), models().cross(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), blockTexture(deferredBlock.get())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("enchantedvale:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("enchantedvale:block/" + deferredBlock.getId().getPath() + appendix));
    }

}