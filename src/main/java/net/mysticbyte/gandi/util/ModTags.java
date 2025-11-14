package net.mysticbyte.gandi.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.mysticbyte.gandi.GandI;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> GEAR_BLOCKS = createTag("gear_blocks");

        public static final TagKey<Block> MUTATOR_BLOCKS = createTag("mutator_blocks");

        public static final TagKey<Block> NEEDS_INACTIVE_TOOL = createTag("needs_inactive_tool");
        public static final TagKey<Block> INCORRECT_INACTIVE_TOOL = createTag("incorrect_inactive_tool");

        public static final TagKey<Block> NEEDS_UNSTOPPABLE_TOOL = createTag("needs_unstoppable_tool");
        public static final TagKey<Block> INCORRECT_UNSTOPPABLE_TOOL = createTag("incorrect_unstoppable_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(GandI.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> GEARS = createTag("gears");
        public static final TagKey<Item> LENS = createTag("lens");
        public static final TagKey<Item> WANDS = createTag("wands");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(GandI.MOD_ID, name));
        }

    }

}
