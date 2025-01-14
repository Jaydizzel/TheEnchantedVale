package net.jaydizzle.enchantedvale.datagen;

import net.jaydizzle.enchantedvale.EnchantedVale;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelProvderInit extends ItemModelProvider {
    public ItemModelProvderInit(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EnchantedVale.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }
}