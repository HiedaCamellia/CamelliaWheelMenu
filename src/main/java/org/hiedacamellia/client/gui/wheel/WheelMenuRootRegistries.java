package org.hiedacamellia.client.gui.wheel;

import org.hiedacamellia.client.gui.tree.WheelTreeEntryWidget;

import java.util.ArrayList;
import java.util.List;

public class WheelMenuRootRegistries {

    private static final List<WheelTreeEntryWidget> roots = new ArrayList<>();

    public static void registerRoot(WheelTreeEntryWidget root){
        roots.add(root);
    }

    public static List<WheelTreeEntryWidget> getRoots(){
        return roots;
    }
}
