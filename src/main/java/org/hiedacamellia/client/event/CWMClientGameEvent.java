package org.hiedacamellia.client.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import org.hiedacamellia.CamelliaWheelMenu;
import org.hiedacamellia.client.gui.wheel.BuiltInWheelMenuRoots;
import org.hiedacamellia.client.gui.wheel.action.BuiltInWheelActions;

@EventBusSubscriber(modid = CamelliaWheelMenu.MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class CWMClientGameEvent {


    public static void onClientSetup(final FMLClientSetupEvent event){
        BuiltInWheelActions.init();
        BuiltInWheelMenuRoots.registerRoots();
    }


    @SubscribeEvent
    public static void onKey(final InputEvent.Key event) {

    }
}
