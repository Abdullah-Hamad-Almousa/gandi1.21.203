package net.mysticbyte.gandi.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties BREAD_UNSTOPPABLE = new FoodProperties.Builder().nutrition(3)
            .saturationModifier(0.25f).alwaysEdible().fast()
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 1600), 1.0f) //red
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2200), 1.0f) //Yel
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 1600), 1.0f)       //green
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3200), 1.0f) //blue
            .build();

}
