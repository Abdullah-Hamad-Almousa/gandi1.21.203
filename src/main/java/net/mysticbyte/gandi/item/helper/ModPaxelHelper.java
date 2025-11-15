package net.mysticbyte.gandi.item.helper;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;

import java.util.Optional;

public class ModPaxelHelper{

    public static InteractionResult applyAxe(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState state = level.getBlockState(pos);

        // -------- STRIP --------
        Optional<BlockState> strip =
                Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.AXE_STRIP, false));

        if (strip.isPresent()) {
            return applyChangeAxe(level, pos, player, context, strip.get(),
                    SoundEvents.AXE_STRIP, -1);
        }

        // -------- SCRAPE (copper oxidation) --------
        Optional<BlockState> scrape =
                Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.AXE_SCRAPE, false));

        if (scrape.isPresent()) {
            return applyChangeAxe(level, pos, player, context, scrape.get(),
                    SoundEvents.AXE_SCRAPE, 3005); // copper scrape particles
        }

        // -------- WAX OFF (remove wax from copper) --------
        Optional<BlockState> waxOff =
                Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.AXE_WAX_OFF, false));

        if (waxOff.isPresent()) {
            return applyChangeAxe(level, pos, player, context, waxOff.get(),
                    SoundEvents.AXE_WAX_OFF, 3004); // wax-off particles
        }

        return InteractionResult.PASS;
    }

    private static InteractionResult applyChangeAxe(
            Level level,
            BlockPos pos,
            Player player,
            UseOnContext context,
            BlockState newState,
            net.minecraft.sounds.SoundEvent sound,
            int levelEventId
    ) {

        // Update block
        level.setBlock(pos, newState, 11);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));

        // Play sound
        level.playSound(player, pos, sound, SoundSource.BLOCKS, 1.0F, 1.0F);

        // Play copper events
        if (player != null && levelEventId >= 0) {
            level.levelEvent(player, levelEventId, pos, 0);
        }

        // Damage tool
        if (player != null) {
            ItemStack tool = context.getItemInHand();
            tool.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    public static InteractionResult applyShovel(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState state = level.getBlockState(pos);

        // Try flattening (dirt → path)
        Optional<BlockState> flatten =
                Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.SHOVEL_FLATTEN, false));

        if (flatten.isPresent()) {
            return applyChangeShovel(level, pos, player, context, flatten.get(), SoundEvents.SHOVEL_FLATTEN, -1);
        }

        return InteractionResult.PASS;
    }

    private static InteractionResult applyChangeShovel(
            Level level,
            BlockPos pos,
            Player player,
            UseOnContext context,
            BlockState newState,
            net.minecraft.sounds.SoundEvent sound,
            int levelEventId
    ) {
        // Update block
        level.setBlock(pos, newState, 11);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));

        // Play sound
        level.playSound(player, pos, sound, SoundSource.BLOCKS, 1.0F, 1.0F);

        // Play particles / events (if needed)
        if (player != null && levelEventId >= 0) {
            level.levelEvent(player, levelEventId, pos, 0);
        }

        // Damage tool
        if (player != null) {
            ItemStack tool = context.getItemInHand();
            tool.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

}
