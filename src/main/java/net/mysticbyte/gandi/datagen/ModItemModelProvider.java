package net.mysticbyte.gandi.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.mysticbyte.gandi.GandI;
import net.mysticbyte.gandi.block.ModBlocks;
import net.mysticbyte.gandi.item.ModItems;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GandI.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        //Level 2 gears
        basicItem(ModItems.UNIDENTIFIED_GEAR.get());
        basicItem(ModItems.INACTIVE_GEAR.get());
        basicItem(ModItems.UNSTOPPABLE_GEAR.get());

        //Level 1 gears
        basicItem(ModItems.UNFORMED_DAWN_GEAR.get());
        basicItem(ModItems.UNFORMED_STORM_GEAR.get());
        basicItem(ModItems.UNFORMED_HARMONY_GEAR.get());
        basicItem(ModItems.UNFORMED_RADIANCE_GEAR.get());

        //Food
        basicItem(ModItems.BREAD_UNSTOPPABLE.get());

        //Lens
        basicItem(ModItems.UNFORMED_DAWN_LENS.get());
        basicItem(ModItems.UNFORMED_STORM_LENS.get());
        basicItem(ModItems.UNFORMED_HARMONY_LENS.get());
        basicItem(ModItems.UNFORMED_RADIANCE_LENS.get());

        //WANDS
        basicItem(ModItems.DAWN_WAND.get());
        basicItem(ModItems.STORM_WAND.get());
        basicItem(ModItems.HARMONY_WAND.get());
        basicItem(ModItems.RADIANCE_WAND.get());

        buttonItem(ModBlocks.INACTIVE_BUTTON, ModBlocks.INACTIVE_GEAR_BLOCK);
        fenceItem(ModBlocks.INACTIVE_FENCE, ModBlocks.INACTIVE_GEAR_BLOCK);
        wallItem(ModBlocks.INACTIVE_WALL, ModBlocks.INACTIVE_GEAR_BLOCK);

        basicItem(ModBlocks.INACTIVE_DOOR.asItem());

        handheldItem(ModItems.INACTIVE_SWORD.asItem());
        handheldItem(ModItems.INACTIVE_HOE.asItem());
        handheldItem(ModItems.INACTIVE_AXE.asItem());
        handheldItem(ModItems.INACTIVE_PICKAXE.asItem());
        handheldItem(ModItems.INACTIVE_SHOVEL.asItem());
        handheldItem(ModItems.INACTIVE_PAXEL.asItem());
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(GandI.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(GandI.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(GandI.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
