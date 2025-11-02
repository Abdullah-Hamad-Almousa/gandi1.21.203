package net.mysticbyte.gandi.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.mysticbyte.gandi.item.ModItems;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {

    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider){
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.UNFORMED_DAWN_GEAR.getId(), new FurnaceFuel(20000), false);
    }

}
