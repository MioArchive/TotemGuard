package com.deathmotion.totemguard.util;

import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientClickWindow;
import org.bukkit.event.inventory.ClickType;

public class ClickTypeUtil {

    // still needs to be completed
    public static ClickType mapWindowClickType(WrapperPlayClientClickWindow.WindowClickType type, int button) {
        return switch (type) {
            case PICKUP -> (button == 0 ? ClickType.LEFT : ClickType.RIGHT);
            case QUICK_MOVE -> (button == 0 ? ClickType.SHIFT_LEFT : ClickType.SHIFT_RIGHT);
            case SWAP -> ClickType.NUMBER_KEY;
            case CLONE -> ClickType.MIDDLE;
            case THROW -> (button == 0 ? ClickType.DROP : ClickType.CONTROL_DROP);
            case QUICK_CRAFT -> ClickType.UNKNOWN;
            case PICKUP_ALL -> ClickType.DOUBLE_CLICK;
            default -> ClickType.UNKNOWN;
        };
    }
}
