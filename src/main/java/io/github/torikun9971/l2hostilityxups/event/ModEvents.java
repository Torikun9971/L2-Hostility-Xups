package io.github.torikun9971.l2hostilityxups.event;

import io.github.torikun9971.l2hostilityxups.config.ModConfig;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.config.ModConfigEvent;

public class ModEvents {

    @SubscribeEvent
    private void onConfigReloading(ModConfigEvent.Reloading event) {
        ModConfig.CONFIG_SPEC.afterReload();
    }
}
