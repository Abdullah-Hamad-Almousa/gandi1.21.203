package net.mysticbyte.gandi.block;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.mysticbyte.gandi.GandI;
import net.mysticbyte.gandi.block.custom.MutatorBlock;
import net.mysticbyte.gandi.item.ModItems;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks{

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GandI.MOD_ID);

    public static final DeferredBlock<Block> UNFORMED_HARMONY_GEAR_BLOCK = registerBlock(
            "unformed_harmony_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f, 20f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> UNFORMED_RADIANCE_GEAR_BLOCK = registerBlock(
            "unformed_radiance_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f, 20f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> UNFORMED_DAWN_GEAR_BLOCK = registerBlock(
            "unformed_dawn_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f, 20f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> UNFORMED_STORM_GEAR_BLOCK = registerBlock(
            "unformed_storm_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f, 20f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> UNIDENTIFIED_GEAR_BLOCK = registerBlock(
            "unidentified_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f, 36000000f).requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.unidentified_gear_block_shift"));
                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.unidentified_gear_block"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredBlock<Block> INACTIVE_GEAR_BLOCK = registerBlock(
            "inactive_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f, 36000000f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> UNSTOPPABLE_GEAR_BLOCK = registerBlock(
            "unstoppable_gear_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f, 36000000f).requiresCorrectToolForDrops().sound(SoundType.METAL)));



    public static final DeferredBlock<Block> CORRUPTED_BLOCK_A = registerBlock(
            "corrupted_block_a", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f, 36000000f).requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.corrupted_a_block_shift"));
                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.corrupted_a_block"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredBlock<Block> CORRUPTED_BLOCK_B = registerBlock(
            "corrupted_block_b", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f, 36000000f).requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.corrupted_b_block_shift"));
                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.corrupted_b_block"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredBlock<Block> CORRUPTED_BLOCK_C = registerBlock(
            "corrupted_block_c", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f, 36000000f).requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.corrupted_c_block_shift"));
                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.corrupted_c_block"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredBlock<Block> CORRUPTED_BLOCK_D = registerBlock(
            "corrupted_block_d", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f, 36000000f).requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.corrupted_d_block_shift"));
                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.corrupted_d_block"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });



    public static final DeferredBlock<Block> MUTATOR_BLOCK = registerBlock("mutator_block",
            () -> new MutatorBlock(BlockBehaviour.Properties.of()
                    .strength(4f, 36000000f).noLootTable()
                    .sound(SoundType.ANCIENT_DEBRIS)){

                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.mutator_block_shift"));
                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.mutator_block"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredBlock<Block> MUTATOR_BLOCK_EVO = registerBlock("mutator_block_evo",
            () -> new MutatorBlock(BlockBehaviour.Properties.of()
                    .strength(4f, 36000000f).noLootTable()
                    .sound(SoundType.ANCIENT_DEBRIS)){

                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.mutator_block_evo_shift"));
                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.mutator_block_evo"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });


/*

    public static final DeferredBlock<StairBlock> INACTIVE_STAIRS = registerBlock("inactive_stairs",
            () -> new StairBlock(ModBlocks.INACTIVE_GEAR_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(4f, 36000000f)
                            .requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> INACTIVE_SLABS = registerBlock("inactive_slabs",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(4f, 36000000f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> INACTIVE_PRESSURE_PLATE = registerBlock("inactive_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(4f, 36000000f)
                            .requiresCorrectToolForDrops()));
    public static final DeferredBlock<ButtonBlock> INACTIVE_BUTTON = registerBlock("inactive_button",
            () -> new ButtonBlock(BlockSetType.IRON, 5,
                    BlockBehaviour.Properties.of().strength(4f, 36000000f)
                            .requiresCorrectToolForDrops().noCollission()));


    public static final DeferredBlock<FenceBlock> INACTIVE_FENCE = registerBlock("inactive_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(4f, 36000000f)
                            .requiresCorrectToolForDrops()));
    public static final DeferredBlock<FenceGateBlock> INACTIVE_FENCE_GATE = registerBlock("inactive_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(4f, 36000000f)
                            .requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> INACTIVE_WALL = registerBlock("inactive_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(4f, 36000000f)
                            .requiresCorrectToolForDrops()));

    public static final DeferredBlock<DoorBlock> INACTIVE_DOOR = registerBlock("inactive_door",
            () -> new DoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(4f, 36000000f)
                            .requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> INACTIVE_TRAPDOOR = registerBlock("inactive_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(4f, 36000000f)
                            .requiresCorrectToolForDrops().noOcclusion()));

*/

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
