package net.jaydizzle.enchantedvale.item;

import net.jaydizzle.enchantedvale.EnchantedVale;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EnchantedVale.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
