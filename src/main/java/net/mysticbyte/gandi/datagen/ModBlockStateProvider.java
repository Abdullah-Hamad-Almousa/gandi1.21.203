package net.mysticbyte.gandi.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.mysticbyte.gandi.GandI;
import net.mysticbyte.gandi.block.ModBlocks;
import net.mysticbyte.gandi.block.custom.InactiveLampBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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

        stairsBlock(ModBlocks.INACTIVE_STAIRS.get(), modLoc("block/inactive_gear_ii"));
        slabBlock(ModBlocks.INACTIVE_SLABS.get(), blockTexture(ModBlocks.INACTIVE_GEAR_BLOCK.get()),
                blockTexture(ModBlocks.INACTIVE_GEAR_BLOCK.get()));

        buttonBlock(ModBlocks.INACTIVE_BUTTON.get(), modLoc("block/inactive_gear_ii"));
        pressurePlateBlock(ModBlocks.INACTIVE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.INACTIVE_GEAR_BLOCK.get()));

        fenceBlock(ModBlocks.INACTIVE_FENCE.get(), modLoc("block/inactive_gear_ii"));
        fenceGateBlock(ModBlocks.INACTIVE_FENCE_GATE.get(), modLoc("block/inactive_gear_ii"));
        wallBlock(ModBlocks.INACTIVE_WALL.get(), modLoc("block/inactive_gear_ii"));

        doorBlockWithRenderType(ModBlocks.INACTIVE_DOOR.get(), modLoc("block/inactive_door_bottom"),
                modLoc("block/inactive_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.INACTIVE_TRAPDOOR.get(), modLoc("block/inactive_trapdoor"),
                true, "cutout");

        blockItem(ModBlocks.INACTIVE_STAIRS);
        blockItem(ModBlocks.INACTIVE_SLABS);
        blockItem(ModBlocks.INACTIVE_FENCE_GATE);
        blockItem(ModBlocks.INACTIVE_PRESSURE_PLATE);
        blockItem(ModBlocks.INACTIVE_TRAPDOOR, "_bottom");

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.INACTIVE_LAMP.get()).forAllStates(state -> {
            if (state.getValue(InactiveLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("inactive_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(GandI.MOD_ID, "block/" + "inactive_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("inactive_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(GandI.MOD_ID, "block/" + "inactive_lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.INACTIVE_LAMP.get(), models().cubeAll("inactive_lamp_on",
                ResourceLocation.fromNamespaceAndPath(GandI.MOD_ID, "block/" + "inactive_lamp_on")));

    }
    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock){
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(
                "grindingandindustrialization:block/"+ deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix){
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(
                "grindingandindustrialization:block/"+ deferredBlock.getId().getPath() + appendix));
    }

}
