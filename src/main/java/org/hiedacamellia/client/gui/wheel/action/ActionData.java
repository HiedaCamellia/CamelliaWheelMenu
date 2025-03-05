package org.hiedacamellia.client.gui.wheel.action;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

public record ActionData(ResourceLocation resourceLocation, CompoundTag compoundTag) {
}
