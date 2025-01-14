package net.jaydizzle.enchantedvale.block;

import net.jaydizzle.enchantedvale.EnchantedVale;
import net.jaydizzle.enchantedvale.item.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EnchantedVale.MODID);

    public static final DeferredBlock<Block> ENCHANTED_COBBLESTONE = registerBlock("enchanted_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ENCHANTED_STONE = registerBlock("enchanted_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ENCHANTED_SMOOTH_STONE = registerBlock("enchanted_smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE).strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ENCHANTED_DIRT = registerBlock("enchanted_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).strength(4f)));
    public static final DeferredBlock<Block> ENCHANTED_GRASS = registerBlock("enchanted_grass", () -> new GrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK).strength(4f)));
    public static final DeferredBlock<Block> ENCHANTED_PLANKS = registerBlock("enchanted_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<Block> ENCHANTED_LOG = registerBlock("enchanted_log", () -> new FlammableRotatedPillarBlockInit(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(4f)));
    public static final DeferredBlock<Block> ENCHANTED_WOOD = registerBlock("enchanted_wood", () -> new FlammableRotatedPillarBlockInit(BlockBehaviour.Properties.of().strength(4f).noLootTable()));
    public static final DeferredBlock<Block> STRIPPED_ENCHANTED_LOG = registerBlock("stripped_enchanted_log", () -> new FlammableRotatedPillarBlockInit(BlockBehaviour.Properties.of().strength(4f).noLootTable()));
    public static final DeferredBlock<Block> STRIPPED_ENCHANTED_WOOD = registerBlock("stripped_enchanted_wood", () -> new FlammableRotatedPillarBlockInit(BlockBehaviour.Properties.of().strength(4f).noLootTable()));

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
