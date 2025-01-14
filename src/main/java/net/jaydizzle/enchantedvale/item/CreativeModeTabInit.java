package net.jaydizzle.enchantedvale.item;

import net.jaydizzle.enchantedvale.EnchantedVale;
import net.jaydizzle.enchantedvale.block.BlockInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeModeTabInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnchantedVale.MODID);
    public static final Supplier<CreativeModeTab> VALE_TAB =
            CREATIVE_MODE_TABS.register("vale_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.enchantedvale.vale_tab"))
                    .icon(() -> new ItemStack(BlockInit.ENCHANTED_COBBLESTONE))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(EnchantedVale.MODID, "vale_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(BlockInit.ENCHANTED_COBBLESTONE);
                        pOutput.accept(BlockInit.ENCHANTED_STONE);
                        pOutput.accept(BlockInit.ENCHANTED_SMOOTH_STONE);
                        pOutput.accept(BlockInit.ENCHANTED_DIRT);
                        pOutput.accept(BlockInit.ENCHANTED_GRASS);
                        pOutput.accept(BlockInit.ENCHANTED_LOG);
                        pOutput.accept(BlockInit.ENCHANTED_PLANKS);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
