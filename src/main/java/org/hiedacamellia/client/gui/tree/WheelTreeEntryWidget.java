package org.hiedacamellia.client.gui.tree;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.hiedacamellia.client.gui.wheel.action.ActionData;
import org.hiedacamellia.client.gui.wheel.action.WheelActionRegistries;
import org.hiedacamellia.immersiveui.client.graphic.gui.IUIGuiUtils;
import org.hiedacamellia.immersiveui.client.gui.component.widget.tree.TreeEntryWidget;

public class WheelTreeEntryWidget extends TreeEntryWidget<ActionData> {

    protected float startAngle = 0;
    protected float endAngle = 0;
    protected float innerRadius = 0;
    protected float outerRadius = 0;

    protected int centerX = 0;
    protected int centerY = 0;

    protected int layer = 0;

    public void resize(){
        this.centerX = Minecraft.getInstance().getWindow().getGuiScaledWidth()/2;
        this.centerY = Minecraft.getInstance().getWindow().getGuiScaledHeight()/2;
    }

    public void setLayer(int layer){
        this.layer = layer;
    }

    public void setAngle(float startAngle, float endAngle){
        this.startAngle = startAngle;
        this.endAngle = endAngle;
    }

    public void setRadius(float innerRadius, float outerRadius){
        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
    }

    public WheelTreeEntryWidget(Component message, Font font) {
        super(message, font);
        resize();
    }

    public static WheelTreeEntryWidget create(ActionData data, Component component, Font font){
        WheelTreeEntryWidget widget = new WheelTreeEntryWidget(component, font);
        widget.setData(data);
        return widget;
    }

    @Override
    public TreeEntryWidget<ActionData> getWidgetAt(double mouseX, double mouseY) {
        for(TreeEntryWidget<ActionData> child : this.children) {
            if (child.isHovered(mouseX, mouseY)) {
                return child;
            }
        }
        return null;
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float v) {
        IUIGuiUtils.drawRing(guiGraphics,centerX,centerY,innerRadius,outerRadius,startAngle,endAngle,0x40FFFFFF);

        if(fold) return;
        renderChildren(guiGraphics, mouseX, mouseY, v);
    }

    @Override
    public boolean shouldAccept(double mouseX, double mouseY){
        return false;
    }

    @Override
    public void updateWidget() {
        int i=0;int size = children.size();
        for(TreeEntryWidget<ActionData> child : children){
            if(child instanceof WheelTreeEntryWidget widget){
                widget.setAngle((float) (i * 360) /size, (float) ((i + 1) * 360) /size);
                widget.setRadius(outerRadius+15-layer*5, outerRadius+50-layer*15);
                widget.setLayer(layer+1);
            }
            i++;
        }
    }

    @Override
    public boolean isHovered(double mouseX, double mouseY) {
        //这里将鼠标坐标转换为相对于中心的坐标
        double x = mouseX - centerX;
        double y = mouseY - centerY;
        //转换为极坐标
        double r = Math.sqrt(x*x + y*y);
        double angle = Math.toDegrees(Math.atan2(y, x));
        return r >= innerRadius && r <= outerRadius && angle >= startAngle && angle <= endAngle;
    }


    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (this.hasChild()) {
            if (isHovered(mouseX,mouseY) && button == 0) {
                if (this.fold) {
                    this.unfold();
                } else {
                    this.fold();
                }
                return true;
            }
            TreeEntryWidget<ActionData> child = this.getWidgetAt(mouseX, mouseY);
            if (child != null) {
                boolean v = child.mouseClicked(mouseX, mouseY, button);
                this.updateWidget();
                return v;
            }
        } else if (button == 0&&getData()!=null) {
            WheelActionRegistries.get(getData().resourceLocation()).run(getData().compoundTag());
            return false;
        }

        return true;
    }
}
