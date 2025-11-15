package net.mysticbyte.gandi.item.custom;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.state.BlockState;

public class ModPaxelItem extends DiggerItem {

    private final Tier tier;

    public ModPaxelItem(Tier tier, Properties properties) {

        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);

        this.tier = tier;
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {

        return state.is(BlockTags.MINEABLE_WITH_PICKAXE)||state.is(BlockTags.MINEABLE_WITH_AXE)
                ||state.is(BlockTags.MINEABLE_WITH_SHOVEL);

    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {

        if (isCorrectToolForDrops(stack, state)){
            return  tier.getSpeed();
        }

        return 1f;

    }
    
}
