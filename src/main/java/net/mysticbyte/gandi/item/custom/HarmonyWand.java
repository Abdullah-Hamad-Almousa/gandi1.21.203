package net.mysticbyte.gandi.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.mysticbyte.gandi.block.ModBlocks;
import net.mysticbyte.gandi.component.ModDataComponents;

import java.util.List;
import java.util.Map;

public class HarmonyWand extends Item {

    private static final Map<Block, Block> HARMONY_MAP =
            Map.of(
                    ModBlocks.CORRUPTED_BLOCK_B.get(), ModBlocks.CORRUPTED_BLOCK_C.get(),
                    ModBlocks.CORRUPTED_BLOCK_C.get(), ModBlocks.CORRUPTED_BLOCK_B.get()
            );

    public HarmonyWand(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if (HARMONY_MAP.containsKey(clickedBlock)){

            if (!level.isClientSide()){

                level.setBlockAndUpdate(context.getClickedPos(), HARMONY_MAP.get(clickedBlock)
                        .defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.ENCHANTMENT_TABLE_USE,
                        SoundSource.BLOCKS);

                context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());
            }

        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        if (stack.get(ModDataComponents.COORDINATES) != null){

            tooltipComponents.add(Component.literal("Last block change at §6" + stack.get(
                    ModDataComponents.COORDINATES) + "§r"));

        }else {

        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
