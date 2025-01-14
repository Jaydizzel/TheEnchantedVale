package net.jaydizzle.enchantedvale.block;

import net.jaydizzle.enchantedvale.EnchantedVale;
import net.jaydizzle.enchantedvale.item.ItemInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EnchantedVale.MODID);

    public static final DeferredBlock<Block> ENCHANTED_COBBLESTONE = registerBlock("enchanted_cobblestone", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ENCHANTED_STONE = registerBlock("enchanted_stone", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ENCHANTED_SMOOTH_STONE = registerBlock("enchanted_smooth_stone", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ENCHANTED_DIRT = registerBlock("enchanted_dirt", () -> new Block(BlockBehaviour.Properties.of().strength(4f)));
    public static final DeferredBlock<Block> ENCHANTED_GRASS = registerBlock("enchanted_grass", () -> new Block(BlockBehaviour.Properties.of().strength(4f)));
    public static final DeferredBlock<Block> ENCHANTED_PLANKS = registerBlock("enchanted_planks", () -> new Block(BlockBehaviour.Properties.of().strength(4f)));
    public static final DeferredBlock<Block> ENCHANTED_LOG = registerBlock("enchanted_log", () -> new Block(BlockBehaviour.Properties.of().strength(4f)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
