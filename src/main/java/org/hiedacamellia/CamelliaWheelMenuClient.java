package org.hiedacamellia;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.hiedacamellia.client.config.CWMClientConfig;
import org.slf4j.Logger;


@Mod(value = CamelliaWheelMenu.MODID,dist = Dist.CLIENT)
public class CamelliaWheelMenuClient
{


    public CamelliaWheelMenuClient(IEventBus modEventBus, ModContainer modContainer)
    {
        modContainer.registerConfig(ModConfig.Type.CLIENT, CWMClientConfig.SPEC);
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

}
