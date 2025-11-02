package net.mysticbyte.gandi.datagen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.mysticbyte.gandi.block.ModBlocks;
import net.mysticbyte.gandi.item.ModItems;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        //Recipe work take 1 unusual item and give a block. left is the output right is the input
        //for pattern 6.3
        List<Pair<Supplier<? extends Block>, Supplier<? extends Item>>> RECIPES_GEAR_BLOCKS = List.of(
                Pair.of(ModBlocks.INACTIVE_GEAR_BLOCK, ModItems.INACTIVE_GEAR),
                Pair.of(ModBlocks.UNSTOPPABLE_GEAR_BLOCK, ModItems.UNSTOPPABLE_GEAR),
                Pair.of(ModBlocks.UNIDENTIFIED_GEAR_BLOCK, ModItems.UNIDENTIFIED_GEAR),

                Pair.of(ModBlocks.UNFORMED_DAWN_GEAR_BLOCK, ModItems.UNFORMED_DAWN_GEAR),
                Pair.of(ModBlocks.UNFORMED_STORM_GEAR_BLOCK, ModItems.UNFORMED_STORM_GEAR),
                Pair.of(ModBlocks.UNFORMED_HARMONY_GEAR_BLOCK, ModItems.UNFORMED_HARMONY_GEAR),
                Pair.of(ModBlocks.UNFORMED_RADIANCE_GEAR_BLOCK, ModItems.UNFORMED_RADIANCE_GEAR)
        );

        for (var i: RECIPES_GEAR_BLOCKS){

            var block = i.getFirst().get();
            var item = i.getSecond().get();

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block)
                    .pattern("BCB")
                    .pattern("BCB")
                    .pattern("BCB")
                    .define('B', item)
                    .define('C', Blocks.LIGHTNING_ROD)
                    .unlockedBy("has_" + item.toString().toLowerCase(), has(item)).save(recipeOutput);

        }

        List<Pair<Supplier<? extends Block>, Supplier<? extends Item>>> UNDO_BLOCKS = List.of(
                Pair.of(ModBlocks.INACTIVE_GEAR_BLOCK, ModItems.INACTIVE_GEAR),
                Pair.of(ModBlocks.UNSTOPPABLE_GEAR_BLOCK, ModItems.UNSTOPPABLE_GEAR),
                Pair.of(ModBlocks.UNIDENTIFIED_GEAR_BLOCK, ModItems.UNIDENTIFIED_GEAR),

                Pair.of(ModBlocks.UNFORMED_DAWN_GEAR_BLOCK, ModItems.UNFORMED_DAWN_GEAR),
                Pair.of(ModBlocks.UNFORMED_STORM_GEAR_BLOCK, ModItems.UNFORMED_STORM_GEAR),
                Pair.of(ModBlocks.UNFORMED_HARMONY_GEAR_BLOCK, ModItems.UNFORMED_HARMONY_GEAR),
                Pair.of(ModBlocks.UNFORMED_RADIANCE_GEAR_BLOCK, ModItems.UNFORMED_RADIANCE_GEAR)
        );

        for (var i: UNDO_BLOCKS){

            var block = i.getFirst().get();
            var item = i.getSecond().get();

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, item, 6)

                    .requires(block)
                    .unlockedBy("has_" + block.toString().toLowerCase(),
                            has(block)).save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                                    "grindingandindustrialization", getItemName(item) +
                            "_from_" + getItemName(block)));

        }

        //Recipe work take 1 unusual item and give item. left is the input right is the output
        //for pattern 4.4.1
        List<Pair<Supplier<? extends Item>, Supplier<? extends Item>>> RECIPES_GEAR_ITEMS = List.of(
                Pair.of(() -> Items.EMERALD, ModItems.UNFORMED_HARMONY_GEAR),
                Pair.of(() -> Items.LAPIS_LAZULI, ModItems.UNFORMED_STORM_GEAR),
                Pair.of(() -> Items.ROTTEN_FLESH, ModItems.UNFORMED_DAWN_GEAR),
                Pair.of(() -> Items.GOLD_INGOT, ModItems.UNFORMED_RADIANCE_GEAR)
        );

        for (var i: RECIPES_GEAR_ITEMS){

            var itema = i.getFirst().get();
            var itemb = i.getSecond().get();

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemb)
                    .pattern("BCB")
                    .pattern("CDC")
                    .pattern("BCB")
                    .define('B', itema)
                    .define('C', Items.REDSTONE)
                    .define('D', Items.COPPER_BLOCK)
                    .unlockedBy("has_"+ itema.toString().toLowerCase(), has(itema)).save(recipeOutput);

        }

        //Recipe work take 1 unusual item and give item. left is the input right is the output
        //for pattern 2.1
        List<Pair<Supplier<? extends Item>, Supplier<? extends Item>>> RECIPES_LENS_ITEMS = List.of(
                Pair.of(ModItems.UNFORMED_DAWN_GEAR, ModItems.UNFORMED_DAWN_LENS),
                Pair.of(ModItems.UNFORMED_STORM_GEAR, ModItems.UNFORMED_STORM_LENS),
                Pair.of(ModItems.UNFORMED_RADIANCE_GEAR, ModItems.UNFORMED_RADIANCE_LENS),
                Pair.of(ModItems.UNFORMED_HARMONY_GEAR, ModItems.UNFORMED_HARMONY_LENS)
        );

        for (var i: RECIPES_LENS_ITEMS){

            var itema = i.getFirst().get();
            var itemb = i.getSecond().get();

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemb)
                    .pattern("   ")
                    .pattern("BCB")
                    .pattern("   ")
                    .define('B', Items.GLASS_PANE)
                    .define('C', itema)
                    .unlockedBy("has_" + itema.toString().toLowerCase(), has(itema)).save(recipeOutput);

        }

        List<Pair<Supplier<? extends Item>, Supplier<? extends Item>>> RECIPES_WAND_ITEMS = List.of(
                Pair.of(ModItems.UNFORMED_DAWN_LENS, ModItems.DAWN_WAND),
                Pair.of(ModItems.UNFORMED_STORM_LENS, ModItems.STORM_WAND),
                Pair.of(ModItems.UNFORMED_RADIANCE_LENS, ModItems.RADIANCE_WAND),
                Pair.of(ModItems.UNFORMED_HARMONY_LENS, ModItems.HARMONY_WAND)
        );

        for (var i: RECIPES_WAND_ITEMS){

            var itema = i.getFirst().get();
            var itemb = i.getSecond().get();

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemb)
                    .pattern("   ")
                    .pattern("BC ")
                    .pattern("   ")
                    .define('B', Items.SPYGLASS)
                    .define('C', itema)
                    .unlockedBy("has_" + itema.toString().toLowerCase(), has(itema)).save(recipeOutput);

        }

        List<ItemLike> ORE_SMELTING = List.of(ModItems.INACTIVE_GEAR);

        oreSmelting(recipeOutput, ORE_SMELTING, RecipeCategory.MISC, ModItems.UNSTOPPABLE_GEAR, 0.75f,
                20000, "unstoppable_gear");
        oreBlasting(recipeOutput, ORE_SMELTING, RecipeCategory.MISC, ModItems.UNSTOPPABLE_GEAR, 0.75f,
                10000, "unstoppable_gear");

    }

}
