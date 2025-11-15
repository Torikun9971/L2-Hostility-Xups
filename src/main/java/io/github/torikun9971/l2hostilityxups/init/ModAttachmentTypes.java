package io.github.torikun9971.l2hostilityxups.init;

import io.github.torikun9971.l2hostilityxups.L2HostilityXups;
import com.mojang.serialization.Codec;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModAttachmentTypes {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(
            NeoForgeRegistries.ATTACHMENT_TYPES, L2HostilityXups.MOD_ID
    );

    public static final Supplier<AttachmentType<Integer>> DEATH_COUNT = ATTACHMENT_TYPES.register(
            "death_count", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );
}
