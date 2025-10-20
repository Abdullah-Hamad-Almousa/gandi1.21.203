package net.mysticbyte.gandi.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.mysticbyte.gandi.GandI;
import net.mysticbyte.gandi.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GandI.MOD_ID);

    public static final DeferredBlock<Block> UNFORMED_HARMONY_GEAR_BLOCK = registerBlock(
            "unformed_harmony_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(10f, 20f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> UNFORMED_RADIANCE_GEAR_BLOCK = registerBlock(
            "unformed_radiance_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(10f, 20f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> UNFORMED_DAWN_GEAR_BLOCK = registerBlock(
            "unformed_dawn_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(10f, 20f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> UNFORMED_STORM_GEAR_BLOCK = registerBlock(
            "unformed_storm_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(10f, 20f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> UNIDENTIFIED_GEAR_BLOCK = registerBlock(
            "unidentified_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(20f, 36000000f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> INACTIVE_GEAR_BLOCK = registerBlock(
            "inactive_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(20f, 36000000f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> UNSTOPPABLE_GEAR_BLOCK = registerBlock(
            "unstoppable_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(50f, 36000000f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){

        BLOCKS.register(eventBus);

    }

}
