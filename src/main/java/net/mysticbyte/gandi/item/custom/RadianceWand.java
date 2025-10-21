package net.mysticbyte.gandi.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.mysticbyte.gandi.block.ModBlocks;

import java.util.Map;

public class RadianceWand extends Item {

    private static final Map<Block, Block> RADIANCE_MAP =
            Map.of(
                    ModBlocks.CORRUPTED_BLOCK_C.get(), ModBlocks.CORRUPTED_BLOCK_D.get(),
                    ModBlocks.CORRUPTED_BLOCK_D.get(), ModBlocks.CORRUPTED_BLOCK_C.get()
            );

    public RadianceWand(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if (RADIANCE_MAP.containsKey(clickedBlock)){

            if (!level.isClientSide()){

                level.setBlockAndUpdate(context.getClickedPos(), RADIANCE_MAP.get(clickedBlock)
                        .defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.ENCHANTMENT_TABLE_USE,
                        SoundSource.BLOCKS);
            }

        }

        return InteractionResult.SUCCESS;
    }
}
