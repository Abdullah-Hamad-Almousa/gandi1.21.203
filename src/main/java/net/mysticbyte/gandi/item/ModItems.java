package net.mysticbyte.gandi.item;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.mysticbyte.gandi.GandI;
import net.mysticbyte.gandi.item.custom.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GandI.MOD_ID);

    public static final DeferredItem<Item> UNSTOPPABLE_GEAR = ITEMS.register("unstoppable_gear",
            () -> new Item(new Item.Properties()) );
    public static final DeferredItem<Item> INACTIVE_GEAR = ITEMS.register("inactive_gear",
            () -> new Item(new Item.Properties()) );
    public static final DeferredItem<Item> UNIDENTIFIED_GEAR = ITEMS.register("unidentified_gear",
            () -> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){

                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.unidentified_gear_shift"));

                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.unidentified_gear"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            } );

    public static final DeferredItem<Item> UNFORMED_STORM_GEAR = ITEMS.register("unformed_storm_gear",
            () -> new Item(new Item.Properties()) );
    public static final DeferredItem<Item> UNFORMED_DAWN_GEAR = ITEMS.register("unformed_dawn_gear",
            () -> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){

                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.unformed_dawn_gear_shift"));

                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.unformed_dawn_gear"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            } );
    public static final DeferredItem<Item> UNFORMED_RADIANCE_GEAR = ITEMS.register("unformed_radiance_gear",
            () -> new Item(new Item.Properties()) );
    public static final DeferredItem<Item> UNFORMED_HARMONY_GEAR = ITEMS.register("unformed_harmony_gear",
            () -> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> UNFORMED_HARMONY_LENS = ITEMS.register("unformed_harmony_lens",
            () -> new Item(new Item.Properties()) );
    public static final DeferredItem<Item> UNFORMED_STORM_LENS = ITEMS.register("unformed_storm_lens",
            () -> new Item(new Item.Properties()) );
    public static final DeferredItem<Item> UNFORMED_DAWN_LENS = ITEMS.register("unformed_dawn_lens",
            () -> new Item(new Item.Properties()) );
    public static final DeferredItem<Item> UNFORMED_RADIANCE_LENS = ITEMS.register("unformed_radiance_lens",
            () -> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> DAWN_WAND = ITEMS.register("dawn_wand",
            () -> new DawnWand(new Item.Properties().durability(2)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){

                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.dawn_wand_shift"));

                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.dawn_wand"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> STORM_WAND = ITEMS.register("storm_wand",
            () -> new StormWand(new Item.Properties().durability(2)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){

                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.storm_wand_shift"));

                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.storm_wand"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> HARMONY_WAND = ITEMS.register("harmony_wand",
            () -> new HarmonyWand(new Item.Properties().durability(2)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){

                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.harmony_wand_shift"));

                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.harmony_wand"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> RADIANCE_WAND = ITEMS.register("radiance_wand",
            () -> new RadianceWand(new Item.Properties().durability(2)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){

                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.radiance_wand_shift"));

                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.radiance_wand"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<SwordItem> INACTIVE_SWORD = ITEMS.register("inactive_sword",
            () -> new SwordItem(ModToolTier.INACTIVE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTier.INACTIVE, 13, -1.3f))));
    public static final DeferredItem<PickaxeItem> INACTIVE_PICKAXE = ITEMS.register("inactive_pickaxe",
            () -> new PickaxeItem(ModToolTier.INACTIVE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTier.INACTIVE, 7, -3f))));
    public static final DeferredItem<ShovelItem> INACTIVE_SHOVEL = ITEMS.register("inactive_shovel",
            () -> new ShovelItem(ModToolTier.INACTIVE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTier.INACTIVE, 7, -1.3f))));
    public static final DeferredItem<AxeItem> INACTIVE_AXE = ITEMS.register("inactive_axe",
            () -> new AxeItem(ModToolTier.INACTIVE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTier.INACTIVE, 17, -3f))));
    public static final DeferredItem<HoeItem> INACTIVE_HOE = ITEMS.register("inactive_hoe",
            () -> new HoeItem(ModToolTier.INACTIVE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTier.INACTIVE, 7, -0.3f))));

    public static final DeferredItem<HoeItem> UNSTOPPABLE_HOE = ITEMS.register("unstoppable_hoe",
            () -> new HoeItem(ModToolTier.UNSTOPPABLE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTier.UNSTOPPABLE, 7, -0.3f))));
    public static final DeferredItem<SwordItem> UNSTOPPABLE_SWORD = ITEMS.register("unstoppable_sword",
            () -> new SwordItem(ModToolTier.UNSTOPPABLE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTier.UNSTOPPABLE, 13, -1.3f))));
    public static final DeferredItem<PickaxeItem> UNSTOPPABLE_PICKAXE = ITEMS.register("unstoppable_pickaxe",
            () -> new PickaxeItem(ModToolTier.UNSTOPPABLE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTier.UNSTOPPABLE, 7, -3f))));
    public static final DeferredItem<ShovelItem> UNSTOPPABLE_SHOVEL = ITEMS.register("unstoppable_shovel",
            () -> new ShovelItem(ModToolTier.UNSTOPPABLE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTier.UNSTOPPABLE, 7, -1.3f))));
    public static final DeferredItem<AxeItem> UNSTOPPABLE_AXE = ITEMS.register("unstoppable_axe",
            () -> new AxeItem(ModToolTier.UNSTOPPABLE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTier.UNSTOPPABLE, 17, -3f))));

    public static final DeferredItem<Item> INACTIVE_PAXEL = ITEMS.register("inactive_paxel",
            () -> new ModPaxelItem(ModToolTier.INACTIVE, new Item.Properties()
                    .durability(ModToolTier.INACTIVE.getUses())));
    public static final DeferredItem<Item> UNSTOPPABLE_PAXEL = ITEMS.register("unstoppable_paxel",
            () -> new ModPaxelItem(ModToolTier.UNSTOPPABLE, new Item.Properties()
                    .durability(ModToolTier.UNSTOPPABLE.getUses())));


    public static final DeferredItem<Item> BREAD_UNSTOPPABLE = ITEMS.register("bread_unstoppable",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BREAD_UNSTOPPABLE))
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    if (Screen.hasShiftDown()){

                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.bread_unstoppable_shift"));

                    }else {
                        tooltipComponents.add(Component.translatable(
                                "tooltip.grindingandindustrialization.bread_unstoppable"));
                    }

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);

    }

}
