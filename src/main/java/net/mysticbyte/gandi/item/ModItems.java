package net.mysticbyte.gandi.item;

import net.minecraft.world.item.Item;
import net.mysticbyte.gandi.GandI;
import net.mysticbyte.gandi.item.custom.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GandI.MOD_ID);

    public static final DeferredItem<Item> UNSTOPPABLE_GEAR = ITEMS.register("unstoppable_gear",
            () -> new Item(new Item.Properties()) );
    public static final DeferredItem<Item> INACTIVE_GEAR = ITEMS.register("inactive_gear",
            () -> new Item(new Item.Properties()) );
    public static final DeferredItem<Item> UNIDENTIFIED_GEAR = ITEMS.register("unidentified_gear",
            () -> new Item(new Item.Properties()) );
    public static final DeferredItem<Item> UNFORMED_STORM_GEAR = ITEMS.register("unformed_storm_gear",
            () -> new Item(new Item.Properties()) );
    public static final DeferredItem<Item> UNFORMED_DAWN_GEAR = ITEMS.register("unformed_dawn_gear",
            () -> new Item(new Item.Properties()) );
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
            () -> new DawnWand(new Item.Properties().durability(2)));
    public static final DeferredItem<Item> STORM_WAND = ITEMS.register("storm_wand",
            () -> new StormWand(new Item.Properties().durability(2)));
    public static final DeferredItem<Item> HARMONY_WAND = ITEMS.register("harmony_wand",
            () -> new HarmonyWand(new Item.Properties().durability(2)));
    public static final DeferredItem<Item> RADIANCE_WAND = ITEMS.register("radiance_wand",
            () -> new RadianceWand(new Item.Properties().durability(2)));

    public static final DeferredItem<Item> BREAD_UNSTOPPABLE = ITEMS.register("bread_unstoppable",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BREAD_UNSTOPPABLE)));

    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);

    }

}
