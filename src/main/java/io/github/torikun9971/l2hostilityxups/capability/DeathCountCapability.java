package io.github.torikun9971.l2hostilityxups.capability;

import io.github.torikun9971.l2hostilityxups.init.ModCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

public class DeathCountCapability {

    public static ICapabilityProvider createProvider() {
        return new Provider();
    }

    public static class DeathCountNBT implements IDeathCounter {
        private int count = 0;

        @Override
        public int getDeathCount() {
            return count;
        }

        @Override
        public void setDeathCount(int count) {
            this.count = count;
        }

        public IntTag save() {
            return IntTag.valueOf(count);
        }

        public void load(IntTag tag) {
            this.count = tag.getAsInt();
        }
    }

    public static class Provider implements ICapabilitySerializable<Tag> {
        private final DeathCountNBT counter;
        private final LazyOptional<IDeathCounter> optional;

        Provider() {
            this.counter = new DeathCountNBT();
            this.optional = LazyOptional.of(() -> this.counter);
        }

        @Override
        @NotNull
        public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
            return ModCapabilities.DEATH_COUNT.orEmpty(cap, optional);
        }

        @Override
        public Tag serializeNBT() {
            return this.counter.save();
        }

        @Override
        public void deserializeNBT(Tag nbt) {
            this.counter.load((IntTag) nbt);
        }
    }
}
