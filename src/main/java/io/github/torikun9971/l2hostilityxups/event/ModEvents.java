package io.github.torikun9971.l2hostilityxups.event;

import io.github.torikun9971.l2hostilityxups.L2HostilityXups;
import io.github.torikun9971.l2hostilityxups.capability.DeathCountCapability;
import io.github.torikun9971.l2hostilityxups.config.ModConfig;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;

public class ModEvents {

    @SubscribeEvent
    public void onAttachCapabilitiesEntity(AttachCapabilitiesEvent<Entity> event) {

        if (event.getObject() instanceof LivingEntity entity)  {
            event.addCapability(
                    L2HostilityXups.id("death_count"), DeathCountCapability.createProvider()
            );
        }
    }

    @SubscribeEvent
    public void onConfigReloading(ModConfigEvent.Reloading event) {
        ModConfig.CONFIG_SPEC.afterReload();
    }
}
