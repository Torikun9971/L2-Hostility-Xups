package io.github.torikun9971.l2hostilityxups;

import io.github.torikun9971.l2hostilityxups.config.ModConfig;
import io.github.torikun9971.l2hostilityxups.event.ModEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(L2HostilityXups.MOD_ID)
public class L2HostilityXups {
    public static final String MOD_ID = "l2hostilityxups";
    public static final String MOD_NAME = "L2 Hostility Xups";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public L2HostilityXups(FMLJavaModLoadingContext context) {
        MinecraftForge.EVENT_BUS.register(new ModEvents());

        context.registerConfig(Type.SERVER, ModConfig.CONFIG_SPEC);

        // forge doesn't have screen class for config :(

        LOGGER.info("has been loaded!");
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}