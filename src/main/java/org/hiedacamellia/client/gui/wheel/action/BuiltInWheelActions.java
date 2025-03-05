package org.hiedacamellia.client.gui.wheel.action;

import org.hiedacamellia.CamelliaWheelMenu;

public class BuiltInWheelActions {

    public static final WheelAction KEY_INPUT = WheelActionRegistries.register(CamelliaWheelMenu.rl("key_input"), KeyInputAction::execute);
    public static final WheelAction CLOSE_SCREEN = WheelActionRegistries.register(CamelliaWheelMenu.rl("close_screen"), CloseScreenAction::execute);


    public static void init() {
    }
}
