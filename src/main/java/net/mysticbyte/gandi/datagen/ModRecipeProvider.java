package net.mysticbyte.gandi.datagen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.mysticbyte.gandi.block.ModBlocks;
import net.mysticbyte.gandi.item.ModItems;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.regex.Pattern;

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

        List<Pair<Supplier<? extends Item>, Supplier<? extends Item>>> RECIPES_PICKAXE = List.of(
                Pair.of(ModItems.INACTIVE_GEAR, ModItems.INACTIVE_PICKAXE),
                Pair.of(ModItems.UNSTOPPABLE_GEAR, ModItems.UNSTOPPABLE_PICKAXE)
        );

        for (var i: RECIPES_PICKAXE){

            var itema = i.getFirst().get();
            var itemb = i.getSecond().get();

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemb)
                    .pattern("CDC")
                    .pattern(" B ")
                    .pattern(" B ")
                    .define('B', Items.LIGHTNING_ROD)
                    .define('C', Items.COPPER_INGOT)
                    .define('D', itema)
                    .unlockedBy("has_" + itema.toString().toLowerCase(), has(itema)).save(recipeOutput);

        }

        List<Pair<Supplier<? extends Item>, Supplier<? extends Item>>> RECIPES_HOE = List.of(
                Pair.of(ModItems.INACTIVE_GEAR, ModItems.INACTIVE_HOE),
                Pair.of(ModItems.UNSTOPPABLE_GEAR, ModItems.UNSTOPPABLE_HOE)
        );

        for (var i: RECIPES_HOE){

            var itema = i.getFirst().get();
            var itemb = i.getSecond().get();

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemb)
                    .pattern("CD ")
                    .pattern(" B ")
                    .pattern(" B ")
                    .define('B', Items.LIGHTNING_ROD)
                    .define('C', Items.COPPER_INGOT)
                    .define('D', itema)
                    .unlockedBy("has_" + itema.toString().toLowerCase(), has(itema)).save(recipeOutput);

        }

        List<Pair<Supplier<? extends Item>, Supplier<? extends Item>>> RECIPES_AXE = List.of(
                Pair.of(ModItems.INACTIVE_GEAR, ModItems.INACTIVE_AXE),
                Pair.of(ModItems.UNSTOPPABLE_GEAR, ModItems.UNSTOPPABLE_AXE)
        );

        for (var i: RECIPES_AXE){

            var itema = i.getFirst().get();
            var itemb = i.getSecond().get();

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemb)
                    .pattern("CD ")
                    .pattern("CB ")
                    .pattern(" B ")
                    .define('B', Items.LIGHTNING_ROD)
                    .define('C', Items.COPPER_INGOT)
                    .define('D', itema)
                    .unlockedBy("has_" + itema.toString().toLowerCase(), has(itema)).save(recipeOutput);

        }

        List<Pair<Supplier<? extends Item>, Supplier<? extends Item>>> RECIPES_SHOVEL = List.of(
                Pair.of(ModItems.INACTIVE_GEAR, ModItems.INACTIVE_SHOVEL),
                Pair.of(ModItems.UNSTOPPABLE_GEAR, ModItems.UNSTOPPABLE_SHOVEL)
        );

        for (var i: RECIPES_SHOVEL){

            var itema = i.getFirst().get();
            var itemb = i.getSecond().get();

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemb)
                    .pattern(" C ")
                    .pattern(" B ")
                    .pattern(" B ")
                    .define('B', Items.LIGHTNING_ROD)
                    .define('C', itema)
                    .unlockedBy("has_" + itema.toString().toLowerCase(), has(itema)).save(recipeOutput);

        }

        List<Pair<Supplier<? extends Item>, Supplier<? extends Item>>> RECIPES_SWORD = List.of(
                Pair.of(ModItems.INACTIVE_GEAR, ModItems.INACTIVE_SWORD),
                Pair.of(ModItems.UNSTOPPABLE_GEAR, ModItems.UNSTOPPABLE_SWORD)
        );

        for (var i: RECIPES_SWORD){

            var itema = i.getFirst().get();
            var itemb = i.getSecond().get();

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemb)
                    .pattern(" C ")
                    .pattern(" D ")
                    .pattern(" B ")
                    .define('B', Items.LIGHTNING_ROD)
                    .define('C', Items.COPPER_INGOT)
                    .define('D', itema)
                    .unlockedBy("has_" + itema.toString().toLowerCase(), has(itema)).save(recipeOutput);

        }

        List<ItemLike> ORE_SMELTING = List.of(ModItems.INACTIVE_GEAR);

        oreSmelting(recipeOutput, ORE_SMELTING, RecipeCategory.MISC, ModItems.UNSTOPPABLE_GEAR, 0.75f,
                20000, "unstoppable_gear");
        oreBlasting(recipeOutput, ORE_SMELTING, RecipeCategory.MISC, ModItems.UNSTOPPABLE_GEAR, 0.75f,
                10000, "unstoppable_gear");

        stairBuilder(ModBlocks.INACTIVE_STAIRS.get(), Ingredient.of(ModBlocks.INACTIVE_GEAR_BLOCK)).group("inactive")
                .unlockedBy("has_inactive_gear_block", has(ModBlocks.INACTIVE_GEAR_BLOCK)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.INACTIVE_SLABS.get(),
                ModBlocks.INACTIVE_GEAR_BLOCK.get());

        buttonBuilder(ModBlocks.INACTIVE_BUTTON.get(), Ingredient.of(ModBlocks.INACTIVE_GEAR_BLOCK.get())).group("inactive")
                .unlockedBy("has_inactive_gear_block", has(ModBlocks.INACTIVE_GEAR_BLOCK)).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.INACTIVE_PRESSURE_PLATE.get(), ModBlocks.INACTIVE_GEAR_BLOCK.get());

        fenceBuilder(ModBlocks.INACTIVE_FENCE.get(), Ingredient.of(ModBlocks.INACTIVE_GEAR_BLOCK.get())).group("inactive")
                .unlockedBy("has_inactive_gear_block", has(ModBlocks.INACTIVE_GEAR_BLOCK)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.INACTIVE_FENCE_GATE.get(), Ingredient.of(ModBlocks.INACTIVE_GEAR_BLOCK.get())).group("inactive")
                .unlockedBy("has_inactive_gear_block", has(ModBlocks.INACTIVE_GEAR_BLOCK)).save(recipeOutput);

        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.INACTIVE_WALL.get(), ModBlocks.INACTIVE_GEAR_BLOCK.get());
        doorBuilder(ModBlocks.INACTIVE_DOOR.get(), Ingredient.of(ModBlocks.INACTIVE_GEAR_BLOCK.get())).group("inactive")
                .unlockedBy("has_inactive_gear_block", has(ModBlocks.INACTIVE_GEAR_BLOCK)).save(recipeOutput);

        trapdoorBuilder(ModBlocks.INACTIVE_TRAPDOOR.get(), Ingredient.of(ModBlocks.INACTIVE_GEAR_BLOCK.get())).group("inactive")
                .unlockedBy("has_inactive_gear_block", has(ModBlocks.INACTIVE_GEAR_BLOCK)).save(recipeOutput);

        paxelRecipeHelper(ModItems.INACTIVE_AXE.get(), ModItems.INACTIVE_PICKAXE.get(),
                ModItems.INACTIVE_SHOVEL.get(), ModItems.INACTIVE_PAXEL.get()).save(recipeOutput);
        paxelRecipeHelper(ModItems.UNSTOPPABLE_AXE.get(), ModItems.UNSTOPPABLE_PICKAXE.get(),
                ModItems.UNSTOPPABLE_SHOVEL.get(), ModItems.UNSTOPPABLE_PAXEL.get()).save(recipeOutput);

    }

    private String stripNamespace(String itemString){
        Pattern pattern = Pattern.compile("(.+):(.+)");
        var matchs = pattern.matcher(itemString);
        if (matchs.find()){
            return matchs.group(2);
        }
        return "";
    }

    private Criterion<InventoryChangeTrigger.TriggerInstance> hasInInventory(ItemLike item){
        return inventoryTrigger(ItemPredicate.Builder.item().of(item).build());
    }

    private String hasInInventoryCriterionName(ItemLike item){
        String itemName = item.asItem().toString();
        return "has_".concat(stripNamespace(itemName));
    }

    private ShapedRecipeBuilder paxelRecipeHelper(Item axe, Item pickaxe, Item shovel, Item output){
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output)
                .pattern("BCD")
                .pattern(" E ")
                .pattern(" E ")
                .define('B', axe)
                .define('C', pickaxe)
                .define('D', shovel)
                .define('E', Items.LIGHTNING_ROD)
                .unlockedBy(hasInInventoryCriterionName(axe), hasInInventory(axe))
                .unlockedBy(hasInInventoryCriterionName(shovel), hasInInventory(shovel))
                .unlockedBy(hasInInventoryCriterionName(pickaxe), hasInInventory(pickaxe));
    }

}
