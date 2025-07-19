package org.hiedacamellia.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.immersiveui.client.gui.component.w2s.World2ScreenScreen;
import org.hiedacamellia.immersiveui.client.gui.layer.World2ScreenWidgetLayer;

import java.util.UUID;

public class CreateIngameScreen extends Screen {
    public CreateIngameScreen(Component title) {
        super(title);
    }

    public void init(){
        if(Minecraft.getInstance().level==null){
            onClose();
        }else {
            onClose();
            UUID uuid = UUID.randomUUID();
            WheelMenuScreen screen = new WheelMenuScreen(Component.literal("Ingame Wheel Menu"));
            screen.renderBackground = false;
            World2ScreenScreen ingameWheelMenu = new World2ScreenScreen(uuid, screen, Minecraft.getInstance().player);
            World2ScreenWidgetLayer.INSTANCE.addWorldPositionObject(uuid, ingameWheelMenu);
            World2ScreenWidgetLayer.INSTANCE.setActiveScreen(ingameWheelMenu);
        }
    }
}
