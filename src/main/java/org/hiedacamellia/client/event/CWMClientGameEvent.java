package org.hiedacamellia.client.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import org.hiedacamellia.CamelliaWheelMenu;

@EventBusSubscriber(modid = CamelliaWheelMenu.MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class CWMClientGameEvent {


    public static void onClientSetup(final FMLClientSetupEvent event){

    }


    @SubscribeEvent
    public static void onKey(final InputEvent.Key event) {

    }
}
