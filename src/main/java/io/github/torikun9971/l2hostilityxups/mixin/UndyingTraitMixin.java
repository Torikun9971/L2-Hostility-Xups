package io.github.torikun9971.l2hostilityxups.mixin;

import io.github.torikun9971.l2hostilityxups.config.ModConfig;
import io.github.torikun9971.l2hostilityxups.init.ModAttachmentTypes;
import dev.xkmc.l2hostility.content.traits.legendary.UndyingTrait;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(UndyingTrait.class)
public class UndyingTraitMixin {

    @Inject(method = "onDeath", at = @At("HEAD"), cancellable = true)
    private void l2hostilityxups$onDeath(int level, LivingEntity entity, LivingDeathEvent event, CallbackInfo ci) {
        if (entity.level().isClientSide()) {
            return;
        }

        int deathCount = entity.getData(ModAttachmentTypes.DEATH_COUNT);
        int reviveLimit = ModConfig.CONFIG.reviveLimit.get();

        if (reviveLimit >= 0) {
            if (deathCount >= reviveLimit) {
                ci.cancel();
            }
        }

        entity.setData(ModAttachmentTypes.DEATH_COUNT, deathCount + 1);
    }
}
