package org.hiedacamellia.test;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.hiedacamellia.CamelliaWheelMenu;
import org.hiedacamellia.client.gui.CreateIngameScreen;
import org.hiedacamellia.client.gui.WheelMenuScreen;
import org.hiedacamellia.immersiveui.api.event.CollectDebugTreeRootEvent;
import org.hiedacamellia.immersiveui.client.debug.DebugEntry;
import org.hiedacamellia.immersiveui.client.gui.component.widget.tree.debug.DebugTreeEntryWidget;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(value = Dist.CLIENT)
public class IUIDebugTreeRootRegister {

    @SubscribeEvent
    public static void registerTestScreen(CollectDebugTreeRootEvent event) {

        DebugTreeEntryWidget testScreen = DebugTreeEntryWidget.create(new DebugEntry(CamelliaWheelMenu.MODID, new WheelMenuScreen(Component.literal("Wheel Menu"))), Component.literal("Test Screen"), Minecraft.getInstance().font);
        DebugTreeEntryWidget igtestScreen = DebugTreeEntryWidget.create(new DebugEntry(CamelliaWheelMenu.MODID, new CreateIngameScreen(Component.literal("Ingame Wheel Menu"))), Component.literal("Ingame Test Screen"), Minecraft.getInstance().font);
        DebugTreeEntryWidget parent = DebugTreeEntryWidget.create(null, Component.literal(CamelliaWheelMenu.MODID), Minecraft.getInstance().font);
        parent.addChild(testScreen);
        parent.addChild(igtestScreen);
        event.registerRoot(parent);

    }
}
