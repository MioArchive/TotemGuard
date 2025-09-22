package com.deathmotion.totemguard.models.impl;

import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientClickWindow;
import org.bukkit.inventory.ItemStack;

public record ClickData(
        int windowID,
        int slot,
        ItemStack clickedItem,
        WrapperPlayClientClickWindow.WindowClickType windowClickType,
        long timestamp
){}
