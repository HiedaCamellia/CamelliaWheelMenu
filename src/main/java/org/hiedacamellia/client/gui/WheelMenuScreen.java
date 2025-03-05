package org.hiedacamellia.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.client.gui.tree.WheelTreeWidget;
import org.hiedacamellia.client.gui.wheel.WheelMenuRootRegistries;

public class WheelMenuScreen extends Screen {

    private WheelTreeWidget wheelTreeWidget;

    public WheelTreeWidget getTree(){
        return wheelTreeWidget;
    }

    public WheelMenuScreen(Component title) {
        super(title);
    }

    @Override
    public void init(){
        wheelTreeWidget = WheelTreeWidget.create(WheelMenuRootRegistries.getRoots(),0,0, Component.literal("Wheel Menu"), font);


        addRenderableOnly(wheelTreeWidget);
    }


    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

    }
}
