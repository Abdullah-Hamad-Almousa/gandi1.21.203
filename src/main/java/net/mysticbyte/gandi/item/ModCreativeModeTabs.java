package net.mysticbyte.gandi.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.mysticbyte.gandi.GandI;
import net.mysticbyte.gandi.block.ModBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GandI.MOD_ID);

    public static final Supplier<CreativeModeTab> GANDI_ITEMS_TAB = CREATIVE_MODE_TAB.register("gandi_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.UNSTOPPABLE_GEAR.get()))
                    .title(Component.translatable("creativetab.grindingandindustrialization.unstoppable_gear_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.UNSTOPPABLE_GEAR);
                        output.accept(ModItems.INACTIVE_GEAR);
                        output.accept(ModItems.UNIDENTIFIED_GEAR);
                        output.accept(ModItems.UNFORMED_DAWN_GEAR);
                        output.accept(ModItems.UNFORMED_HARMONY_GEAR);
                        output.accept(ModItems.UNFORMED_RADIANCE_GEAR);
                        output.accept(ModItems.UNFORMED_STORM_GEAR);
                        output.accept(ModItems.UNFORMED_RADIANCE_LENS);
                        output.accept(ModItems.UNFORMED_HARMONY_LENS);
                        output.accept(ModItems.UNFORMED_STORM_LENS);
                        output.accept(ModItems.UNFORMED_DAWN_LENS);

                        output.accept(ModItems.DAWN_WAND);
                        output.accept(ModItems.STORM_WAND);
                        output.accept(ModItems.HARMONY_WAND);
                        output.accept(ModItems.RADIANCE_WAND);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> GANDI_BLOCKS_TAB = CREATIVE_MODE_TAB.register("gandi_blcoks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.UNSTOPPABLE_GEAR_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(GandI.MOD_ID, "gandi_items_tab"))
                    .title(Component.translatable("creativetab.grindingandindustrialization.unstoppable_gear_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.INACTIVE_GEAR_BLOCK);
                        output.accept(ModBlocks.UNSTOPPABLE_GEAR_BLOCK);
                        output.accept(ModBlocks.UNIDENTIFIED_GEAR_BLOCK);
                        output.accept(ModBlocks.UNFORMED_DAWN_GEAR_BLOCK);
                        output.accept(ModBlocks.UNFORMED_HARMONY_GEAR_BLOCK);
                        output.accept(ModBlocks.UNFORMED_STORM_GEAR_BLOCK);
                        output.accept(ModBlocks.UNFORMED_RADIANCE_GEAR_BLOCK);
                        output.accept(ModBlocks.CORRUPTED_BLOCK_A);
                        output.accept(ModBlocks.CORRUPTED_BLOCK_B);
                        output.accept(ModBlocks.CORRUPTED_BLOCK_C);
                        output.accept(ModBlocks.CORRUPTED_BLOCK_D);
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
