package org.hiedacamellia.test;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.fml.ModList;
import org.hiedacamellia.CamelliaWheelMenu;
import org.hiedacamellia.camellialib.client.debug.DebugEntry;
import org.hiedacamellia.camellialib.client.debug.DebugRegistries;
import org.hiedacamellia.camellialib.client.gui.tree.DebugTreeEntryWidget;
import org.hiedacamellia.client.gui.WheelMenuScreen;

public class TestEvent {



    public static void registerTestScreen(){
        if(ModList.get().isLoaded("camellialib")) {
            DebugTreeEntryWidget testScreen = DebugTreeEntryWidget.create(new DebugEntry(CamelliaWheelMenu.MODID, new WheelMenuScreen(Component.literal("Wheel Menu"))), Component.literal("Test Screen"), Minecraft.getInstance().font);
            DebugTreeEntryWidget parent = DebugTreeEntryWidget.create(null, Component.literal(CamelliaWheelMenu.MODID), Minecraft.getInstance().font);
            parent.addChild(testScreen);
            DebugRegistries.registerRoot(parent);
        }
    }
}
