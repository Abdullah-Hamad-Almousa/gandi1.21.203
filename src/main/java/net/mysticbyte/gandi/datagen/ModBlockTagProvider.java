package net.mysticbyte.gandi.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.mysticbyte.gandi.GandI;
import net.mysticbyte.gandi.block.ModBlocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GandI.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.INACTIVE_GEAR_BLOCK.get())
                .add(ModBlocks.UNSTOPPABLE_GEAR_BLOCK.get())
                .add(ModBlocks.UNIDENTIFIED_GEAR_BLOCK.get())

                .add(ModBlocks.UNFORMED_HARMONY_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_RADIANCE_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_STORM_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_DAWN_GEAR_BLOCK.get())

                .add(ModBlocks.CORRUPTED_BLOCK_A.get())
                .add(ModBlocks.CORRUPTED_BLOCK_B.get())
                .add(ModBlocks.CORRUPTED_BLOCK_C.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)

                .add(ModBlocks.INACTIVE_GEAR_BLOCK.get())
                .add(ModBlocks.UNSTOPPABLE_GEAR_BLOCK.get())
                .add(ModBlocks.UNIDENTIFIED_GEAR_BLOCK.get())

                .add(ModBlocks.MUTATOR_BLOCK_EVO.get())
                .add(ModBlocks.MUTATOR_BLOCK.get())

                .add(ModBlocks.CORRUPTED_BLOCK_A.get())
                .add(ModBlocks.CORRUPTED_BLOCK_B.get())
                .add(ModBlocks.CORRUPTED_BLOCK_C.get());

        tag(BlockTags.NEEDS_IRON_TOOL)

                .add(ModBlocks.UNFORMED_HARMONY_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_RADIANCE_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_STORM_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_DAWN_GEAR_BLOCK.get());
    }
}
