package net.mysticbyte.gandi.item.custom;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.mysticbyte.gandi.item.helper.ModPaxelHelper;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

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

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility ability) {
        return ItemAbilities.DEFAULT_AXE_ACTIONS.contains(ability) || ItemAbilities
                .DEFAULT_SHOVEL_ACTIONS.contains(ability);
    }

    @Override
    public InteractionResult useOn(UseOnContext context){

        InteractionResult stripResult = ModPaxelHelper.applyAxe(context);
        InteractionResult flattenResult = ModPaxelHelper.applyShovel(context);

        if (stripResult.consumesAction())
            return stripResult;


        if (flattenResult.consumesAction())
            return flattenResult;

        return super.useOn(context);

    }

    @Override
    public float getAttackDamageBonus(Entity target, float damage, DamageSource damageSource) {
        return 37f;
    }

}
