package io.github.torikun9971.l2hostilityxups.mixin;

import io.github.torikun9971.l2hostilityxups.config.ModConfig;
import io.github.torikun9971.l2hostilityxups.init.ModCapabilities;
import dev.xkmc.l2hostility.content.traits.legendary.UndyingTrait;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(UndyingTrait.class)
public abstract class UndyingTraitMixin {

    @Inject(method = "onDeath", at = @At("HEAD"), cancellable = true, remap = false)
    public void l2hostilityxups$onDeath(int level, LivingEntity entity, LivingDeathEvent event, CallbackInfo ci) {
        if (entity.level().isClientSide()) return;

        entity.getCapability(ModCapabilities.DEATH_COUNT).ifPresent(counter -> {
            int deathCount = counter.getDeathCount();
            int reviveLimit = ModConfig.CONFIG.reviveLimit.get();

            if (reviveLimit >= 0) {
                if (deathCount >= reviveLimit) {
                    ci.cancel();
                }
            }

            counter.setDeathCount(deathCount + 1);
        });
    }
}
