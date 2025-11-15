package io.github.torikun9971.l2hostilityxups;

import io.github.torikun9971.l2hostilityxups.config.ModConfig;
import io.github.torikun9971.l2hostilityxups.event.ModEvents;
import io.github.torikun9971.l2hostilityxups.init.ModAttachmentTypes;
import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforgespi.Environment;
import org.slf4j.Logger;

@Mod(L2HostilityXups.MOD_ID)
public class L2HostilityXups {
    public static final String MOD_ID = "l2hostilityxups";
    public static final Logger LOGGER = LogUtils.getLogger();

    public L2HostilityXups(IEventBus modEventBus, ModContainer modContainer) {
        ModAttachmentTypes.ATTACHMENT_TYPES.register(modEventBus);
        modEventBus.register(new ModEvents());

        modContainer.registerConfig(Type.SERVER, ModConfig.CONFIG_SPEC);

        if (Environment.get().getDist() == Dist.CLIENT) {
            modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        }

        LOGGER.info("[L2 Hostility Xups] has been loaded!");
    }
}
