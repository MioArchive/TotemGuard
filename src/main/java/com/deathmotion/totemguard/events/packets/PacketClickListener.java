package com.deathmotion.totemguard.events.packets;

import com.deathmotion.totemguard.TotemGuard;
import com.deathmotion.totemguard.models.TotemPlayer;
import com.deathmotion.totemguard.models.impl.ClickData;
import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientClickWindow;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class PacketClickListener extends PacketListenerAbstract {

    // Using a list, might be expanded in the future (will be)
    private final List<PacketType.Play.Client> clickPackets = List.of(
            PacketType.Play.Client.CLICK_WINDOW);

    @Override
    public void onPacketReceive(PacketReceiveEvent event)  {
        if (!clickPackets.contains(event.getPacketType())) return;

        Bukkit.getLogger().info(event.getPacketType().getName());

        Player player = event.getPlayer();

        // Adding the click data to our totem player data
        TotemPlayer totemPlayer = TotemGuard.getInstance().getPlayerDataManager().getPlayer(player);
        if (totemPlayer == null) return;

        WrapperPlayClientClickWindow wrapper = new WrapperPlayClientClickWindow(event);

        totemPlayer.clickData = new ClickData(
                wrapper.getWindowId(),
                wrapper.getSlot(),
                // converting to bukkit item stack to make it easier to use later
                SpigotConversionUtil.toBukkitItemStack(wrapper.getCarriedItemStack()),
                wrapper.getWindowClickType(),
                event.getTimestamp()
        );
    }
}
