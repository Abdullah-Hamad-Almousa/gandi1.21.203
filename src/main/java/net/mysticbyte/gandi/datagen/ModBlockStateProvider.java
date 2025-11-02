package net.mysticbyte.gandi.datagen;

import net.minecraft.data.PackOutput;
import net.mysticbyte.gandi.GandI;
import net.mysticbyte.gandi.block.ModBlocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GandI.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.CORRUPTED_BLOCK_A);
        blockWithItem(ModBlocks.CORRUPTED_BLOCK_B);
        blockWithItem(ModBlocks.CORRUPTED_BLOCK_C);
        blockWithItem(ModBlocks.CORRUPTED_BLOCK_D);

        blockWithItem(ModBlocks.MUTATOR_BLOCK);
        blockWithItem(ModBlocks.MUTATOR_BLOCK_EVO);

        blockWithItem(ModBlocks.INACTIVE_GEAR_BLOCK);
        blockWithItem(ModBlocks.UNSTOPPABLE_GEAR_BLOCK);
        blockWithItem(ModBlocks.UNIDENTIFIED_GEAR_BLOCK);

        blockWithItem(ModBlocks.UNFORMED_DAWN_GEAR_BLOCK);
        blockWithItem(ModBlocks.UNFORMED_STORM_GEAR_BLOCK);
        blockWithItem(ModBlocks.UNFORMED_HARMONY_GEAR_BLOCK);
        blockWithItem(ModBlocks.UNFORMED_RADIANCE_GEAR_BLOCK);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

}
