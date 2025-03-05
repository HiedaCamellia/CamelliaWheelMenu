package org.hiedacamellia.client.gui.wheel.action;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class WheelActionRegistries {

    private static final Map<ResourceLocation, WheelAction> REGISTRY = new HashMap<>();

    public static WheelAction register(ResourceLocation id, Consumer<CompoundTag> consumer){
        WheelAction wheelAction = new WheelAction(id, consumer);
        REGISTRY.put(id, wheelAction);
        return wheelAction;
    }

    public static WheelAction get(ResourceLocation id){
        return REGISTRY.get(id);
    }

}
