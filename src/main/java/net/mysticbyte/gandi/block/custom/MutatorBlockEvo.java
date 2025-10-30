package net.mysticbyte.gandi.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import net.mysticbyte.gandi.block.ModBlocks;
import net.mysticbyte.gandi.item.ModItems;

public class MutatorBlockEvo extends Block{

    public MutatorBlockEvo(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {

        level.playSound(player, pos, SoundEvents.ENDER_EYE_DEATH,
                SoundSource.BLOCKS, 1f, 1f);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {

        if (entity instanceof ItemEntity itemEntity){

            ItemStack stack = itemEntity.getItem();
            Item inputItem = stack.getItem();

            if (itemEntity.getItem().getItem() == ModBlocks.UNIDENTIFIED_GEAR_BLOCK.get().asItem()){
                itemEntity.setItem(new ItemStack(ModBlocks.INACTIVE_GEAR_BLOCK.get().asItem(), itemEntity
                        .getItem().getCount()));
            }

            if (itemEntity.getItem().getItem() == ModItems.UNIDENTIFIED_GEAR.get()){
                itemEntity.setItem(new ItemStack(ModItems.INACTIVE_GEAR.get(), itemEntity
                        .getItem().getCount()));
            }

        }

        super.stepOn(level, pos, state, entity);
    }
}
