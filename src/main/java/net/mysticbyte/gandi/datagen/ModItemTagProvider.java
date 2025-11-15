package net.mysticbyte.gandi.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.mysticbyte.gandi.GandI;
import net.mysticbyte.gandi.item.ModItems;
import net.mysticbyte.gandi.util.ModTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTags, GandI.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModTags.Items.GEARS)
                .add(ModItems.UNSTOPPABLE_GEAR.get())
                .add(ModItems.INACTIVE_GEAR.get())
                .add(ModItems.UNIDENTIFIED_GEAR.get())

                .add(ModItems.UNFORMED_STORM_GEAR.get())
                .add(ModItems.UNFORMED_HARMONY_GEAR.get())
                .add(ModItems.UNFORMED_RADIANCE_GEAR.get())
                .add(ModItems.UNFORMED_DAWN_GEAR.get());

        tag(ModTags.Items.LENS)
                .add(ModItems.UNFORMED_DAWN_LENS.get())
                .add(ModItems.UNFORMED_STORM_LENS.get())
                .add(ModItems.UNFORMED_HARMONY_LENS.get())
                .add(ModItems.UNFORMED_RADIANCE_LENS.get());

        tag(ModTags.Items.WANDS)
                .add(ModItems.HARMONY_WAND.get())
                .add(ModItems.DAWN_WAND.get())
                .add(ModItems.STORM_WAND.get())
                .add(ModItems.RADIANCE_WAND.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.INACTIVE_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.INACTIVE_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.INACTIVE_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.INACTIVE_HOE.get());
        tag(ItemTags.AXES)
                .add(ModItems.INACTIVE_AXE.get());

        tag(ItemTags.AXES)
                .add(ModItems.INACTIVE_PAXEL.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.INACTIVE_PAXEL.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.INACTIVE_PAXEL.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.UNSTOPPABLE_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.UNSTOPPABLE_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.UNSTOPPABLE_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.UNSTOPPABLE_HOE.get());
        tag(ItemTags.AXES)
                .add(ModItems.UNSTOPPABLE_AXE.get());

        tag(ItemTags.AXES)
                .add(ModItems.UNSTOPPABLE_PAXEL.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.UNSTOPPABLE_PAXEL.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.UNSTOPPABLE_PAXEL.get());

    }
}
