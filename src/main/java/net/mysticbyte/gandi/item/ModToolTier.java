package net.mysticbyte.gandi.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.mysticbyte.gandi.util.ModTags;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTier {

    public static final Tier INACTIVE = new SimpleTier(ModTags.Blocks.INCORRECT_INACTIVE_TOOL,
            3737, 7f, 13f, 37, () -> Ingredient.of(ModItems.INACTIVE_GEAR.asItem()));

    public static final Tier UNSTOPPABLE = new SimpleTier(ModTags.Blocks.INCORRECT_UNSTOPPABLE_TOOL,
            3737, 7f, 13f, 37, () -> Ingredient.of(ModItems.UNSTOPPABLE_GEAR.asItem()));

}
