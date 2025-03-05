package org.hiedacamellia.client.gui.wheel;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.client.gui.tree.WheelTreeEntryWidget;
import org.hiedacamellia.client.gui.wheel.action.ActionData;
import org.hiedacamellia.client.gui.wheel.action.BuiltInWheelActions;

public class BuiltInWheelMenuRoots {

    public static void registerRoots(){
        WheelMenuRootRegistries.registerRoot(WheelTreeEntryWidget.create(
                new ActionData(BuiltInWheelActions.CLOSE_SCREEN.getKey(),new CompoundTag()),
                Component.literal("Close Screen"), Minecraft.getInstance().font));
        WheelTreeEntryWidget keyInput = WheelTreeEntryWidget.create(null,
                Component.literal("KeyInput"), Minecraft.getInstance().font);
        {
            CompoundTag compoundTag = new CompoundTag();compoundTag.putString("key","key.keyboard.0");
            keyInput.addChild(WheelTreeEntryWidget.create(
                    new ActionData(BuiltInWheelActions.KEY_INPUT.getKey(), compoundTag),
                    Component.literal("Key 0"), Minecraft.getInstance().font));
        }
        {
            CompoundTag compoundTag = new CompoundTag();compoundTag.putString("key","key.keyboard.1");
            keyInput.addChild(WheelTreeEntryWidget.create(
                    new ActionData(BuiltInWheelActions.KEY_INPUT.getKey(), compoundTag),
                    Component.literal("Key 1"), Minecraft.getInstance().font));
        }
        {
            CompoundTag compoundTag = new CompoundTag();compoundTag.putString("key","key.keyboard.2");
            keyInput.addChild(WheelTreeEntryWidget.create(
                    new ActionData(BuiltInWheelActions.KEY_INPUT.getKey(), compoundTag),
                    Component.literal("Key 2"), Minecraft.getInstance().font));
        }
        {
            CompoundTag compoundTag = new CompoundTag();compoundTag.putString("key","key.keyboard.3");
            keyInput.addChild(WheelTreeEntryWidget.create(
                    new ActionData(BuiltInWheelActions.KEY_INPUT.getKey(), compoundTag),
                    Component.literal("Key 3"), Minecraft.getInstance().font));
        }
        WheelMenuRootRegistries.registerRoot(keyInput);
    }
}
