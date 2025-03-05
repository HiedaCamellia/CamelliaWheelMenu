package org.hiedacamellia.client.gui.wheel.action;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.common.NeoForge;

public class KeyInputAction {

    public static void execute(CompoundTag tag) {
        InputConstants.Key key = InputConstants.getKey(tag.getString("key"));
        NeoForge.EVENT_BUS.post(new InputEvent.Key(key.getValue(), key.getValue(), InputConstants.PRESS, key.getValue()));
        NeoForge.EVENT_BUS.post(new InputEvent.Key(key.getValue(), key.getValue(), InputConstants.RELEASE, key.getValue()));
    }
}
