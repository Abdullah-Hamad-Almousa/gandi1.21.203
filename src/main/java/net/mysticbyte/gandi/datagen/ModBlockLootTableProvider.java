package net.mysticbyte.gandi.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import net.mysticbyte.gandi.block.ModBlocks;
import net.mysticbyte.gandi.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {


    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.INACTIVE_GEAR_BLOCK.get());
        dropSelf(ModBlocks.UNSTOPPABLE_GEAR_BLOCK.get());

        dropSelf(ModBlocks.UNFORMED_HARMONY_GEAR_BLOCK.get());
        dropSelf(ModBlocks.UNFORMED_RADIANCE_GEAR_BLOCK.get());
        dropSelf(ModBlocks.UNFORMED_DAWN_GEAR_BLOCK.get());
        dropSelf(ModBlocks.UNFORMED_STORM_GEAR_BLOCK.get());

        dropSelf(ModBlocks.CORRUPTED_BLOCK_A.get());
        dropSelf(ModBlocks.CORRUPTED_BLOCK_B.get());
        dropSelf(ModBlocks.CORRUPTED_BLOCK_C.get());

        dropSelf(ModBlocks.UNIDENTIFIED_GEAR_BLOCK.get());

        add(ModBlocks.CORRUPTED_BLOCK_D.get(),
                block -> createMultipleOreDrops(ModBlocks.CORRUPTED_BLOCK_D.get(), ModItems.UNIDENTIFIED_GEAR.get()
                        , 1, 6));

        dropSelf(ModBlocks.INACTIVE_STAIRS.get());
        add(ModBlocks.INACTIVE_SLABS.get(),
                block -> createSlabItemTable(ModBlocks.INACTIVE_SLABS.get()));

        dropSelf(ModBlocks.INACTIVE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.INACTIVE_BUTTON.get());

        dropSelf(ModBlocks.INACTIVE_FENCE.get());
        dropSelf(ModBlocks.INACTIVE_FENCE_GATE.get());
        dropSelf(ModBlocks.INACTIVE_WALL.get());
        dropSelf(ModBlocks.INACTIVE_TRAPDOOR.get());

        add(ModBlocks.INACTIVE_DOOR.get(),
                block -> createDoorTable(ModBlocks.INACTIVE_DOOR.get()));

    }

    // To drop items like copper when it mine
    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
