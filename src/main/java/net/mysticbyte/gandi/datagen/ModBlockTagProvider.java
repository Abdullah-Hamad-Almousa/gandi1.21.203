package net.mysticbyte.gandi.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.mysticbyte.gandi.GandI;
import net.mysticbyte.gandi.block.ModBlocks;
import net.mysticbyte.gandi.util.ModTags;
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

        //pickaxe tags
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.INACTIVE_GEAR_BLOCK.get())
                .add(ModBlocks.UNSTOPPABLE_GEAR_BLOCK.get())
                .add(ModBlocks.UNIDENTIFIED_GEAR_BLOCK.get())

                .add(ModBlocks.UNFORMED_HARMONY_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_RADIANCE_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_STORM_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_DAWN_GEAR_BLOCK.get())

                .add(ModBlocks.INACTIVE_DOOR.get())
                .add(ModBlocks.INACTIVE_STAIRS.get())
                .add(ModBlocks.INACTIVE_BUTTON.get())
                .add(ModBlocks.INACTIVE_SLABS.get())
                .add(ModBlocks.INACTIVE_TRAPDOOR.get())
                .add(ModBlocks.INACTIVE_PRESSURE_PLATE.get())
                .add(ModBlocks.INACTIVE_FENCE.get())

                .add(ModBlocks.CORRUPTED_BLOCK_A.get())
                .add(ModBlocks.CORRUPTED_BLOCK_B.get())
                .add(ModBlocks.CORRUPTED_BLOCK_C.get())
                .add(ModBlocks.CORRUPTED_BLOCK_D.get());


        tag(BlockTags.NEEDS_DIAMOND_TOOL)

                .add(ModBlocks.INACTIVE_GEAR_BLOCK.get())
                .add(ModBlocks.UNSTOPPABLE_GEAR_BLOCK.get())
                .add(ModBlocks.UNIDENTIFIED_GEAR_BLOCK.get())

                .add(ModBlocks.MUTATOR_BLOCK_EVO.get())
                .add(ModBlocks.MUTATOR_BLOCK.get())

                .add(ModBlocks.CORRUPTED_BLOCK_A.get())
                .add(ModBlocks.CORRUPTED_BLOCK_B.get())
                .add(ModBlocks.CORRUPTED_BLOCK_C.get())
                .add(ModBlocks.CORRUPTED_BLOCK_D.get());

        tag(BlockTags.NEEDS_IRON_TOOL)

                .add(ModBlocks.UNFORMED_HARMONY_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_RADIANCE_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_STORM_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_DAWN_GEAR_BLOCK.get());
        //pickaxe tags

        tag(ModTags.Blocks.GEAR_BLOCKS)
                .add(ModBlocks.UNSTOPPABLE_GEAR_BLOCK.get())
                .add(ModBlocks.INACTIVE_GEAR_BLOCK.get())
                .add(ModBlocks.UNIDENTIFIED_GEAR_BLOCK.get())

                .add(ModBlocks.UNFORMED_DAWN_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_RADIANCE_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_HARMONY_GEAR_BLOCK.get())
                .add(ModBlocks.UNFORMED_STORM_GEAR_BLOCK.get());

        tag(ModTags.Blocks.MUTATOR_BLOCKS)
                .add(ModBlocks.MUTATOR_BLOCK.get())
                .add(ModBlocks.MUTATOR_BLOCK_EVO.get());

        tag(BlockTags.FENCE_GATES).add(ModBlocks.INACTIVE_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.INACTIVE_WALL.get());
        tag(BlockTags.FENCES).add(ModBlocks.INACTIVE_FENCE.get());

    }
}
