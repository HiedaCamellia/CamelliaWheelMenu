package org.hiedacamellia.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.CamelliaWheelMenu;
import org.hiedacamellia.client.gui.tree.WheelTreeWidget;
import org.hiedacamellia.client.gui.wheel.WheelMenuRootRegistries;
import org.hiedacamellia.immersiveui.client.graphic.gui.IUIGuiUtils;
import org.hiedacamellia.immersiveui.client.graphic.target.ScreenTempTarget;

public class WheelMenuScreen extends Screen {

    private WheelTreeWidget wheelTreeWidget;

    public WheelTreeWidget getTree(){
        return wheelTreeWidget;
    }

    public boolean renderBackground = true;

    public WheelMenuScreen(Component title) {
        super(title);
    }

    @Override
    public void init(){
        wheelTreeWidget = WheelTreeWidget.create(WheelMenuRootRegistries.getRoots(),0,0, Component.literal("Wheel Menu"), font);
        CamelliaWheelMenu.LOGGER.info("create wheel menu screen");
        CamelliaWheelMenu.LOGGER.info("children size: "+wheelTreeWidget.children().size());

        addRenderableWidget(wheelTreeWidget);
    }


    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        if(renderBackground) super.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        else {
            ScreenTempTarget.BLUR_INSTANCE.unbindWrite();
            ScreenTempTarget.SCREEN_INSTANCE.bindWrite(false);
        }
    }
}
