package org.hiedacamellia.client.gui.wheel.action;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;

public class CloseScreenAction {

    public static void execute(CompoundTag tag) {
        Minecraft.getInstance().screen.onClose();
    }
}
