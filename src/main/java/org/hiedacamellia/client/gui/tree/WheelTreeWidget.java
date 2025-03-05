package org.hiedacamellia.client.gui.tree;

import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.client.gui.wheel.action.ActionData;
import org.hiedacamellia.immersiveui.client.gui.component.widget.tree.TreeEntryWidget;
import org.hiedacamellia.immersiveui.client.gui.component.widget.tree.TreeWidget;

import java.util.List;

public class WheelTreeWidget extends TreeWidget<ActionData,WheelTreeEntryWidget> {
    public WheelTreeWidget(List<WheelTreeEntryWidget> root, int x, int y, Component component, Font font) {
        super(root, x, y, component, font);
    }

    public static WheelTreeWidget create(List<WheelTreeEntryWidget> root, int x, int y, Component component, Font font){
        return new WheelTreeWidget(root,x, y, component, font);
    }

    @Override
    public void updateWidget() {
        int i=0;int size = root.size();
        for(TreeEntryWidget<ActionData> child : root){
            if(child instanceof WheelTreeEntryWidget widget){
                widget.setAngle((float) (i * 360) /size, (float) ((i + 1) * 360) /size);
                widget.setRadius(60, 100);
                widget.setLayer(0);
            }
            i++;
        }
    }
}
