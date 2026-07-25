package io.github.torikun9971.l2hostilityxups.init;

import io.github.torikun9971.l2hostilityxups.capability.IDeathCounter;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class ModCapabilities {
    public static final Capability<IDeathCounter> DEATH_COUNT = CapabilityManager.get(new CapabilityToken<>() {

    });
}
