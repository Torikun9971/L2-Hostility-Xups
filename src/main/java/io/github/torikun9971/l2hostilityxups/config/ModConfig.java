package io.github.torikun9971.l2hostilityxups.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfig {
    public static final ModConfig CONFIG;
    public static final ForgeConfigSpec CONFIG_SPEC;

    public final ForgeConfigSpec.ConfigValue<Integer> reviveLimit;

    static {
        var pair = new ForgeConfigSpec.Builder().configure(ModConfig::new);

        CONFIG = pair.getLeft();
        CONFIG_SPEC = pair.getRight();
    }

    private ModConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("The number of times a mob with the Undying trait can revive.");
        builder.comment("Set to -1 to disable this feature.");

        reviveLimit = builder.define("reviveLimit", 3);
    }
}
