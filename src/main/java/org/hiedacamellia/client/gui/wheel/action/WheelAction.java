package org.hiedacamellia.client.gui.wheel.action;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public record WheelAction(ResourceLocation resourceLocation, Consumer<CompoundTag> consumer) {

    public void run(CompoundTag data) {
        consumer.accept(data);
    }
    public ResourceLocation getKey() {
        return resourceLocation;
    }
}
