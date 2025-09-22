package com.deathmotion.totemguard.api.events;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;


/**
 * Represents a precise inventory click event based directly on packet data.
 *
 * Unlike Bukkit's {@link org.bukkit.event.inventory.InventoryClickEvent}, this event
 * records the exact timestamp of the click from the client packet, bypassing bukkit's
 * 50ms tick limitation.
 *
 * The event is still fired alongside Bukkit's event for compatibility, but
 * contains the true click time for latency-sensitive checks.
 *
 * The corresponding Bukkit {@code InventoryClickEvent} is included in the event.
 */

@Getter
public class PreciseInventoryClickEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final long timestamp;
    private final InventoryClickEvent bukkitEvent;

    /**
     * Constructs a new {@code PreciseInventoryClickEvent}
     *
     * @param player
     * @param timestamp
     * @param bukkitEvent
     */
    public PreciseInventoryClickEvent(Player player, long timestamp, InventoryClickEvent bukkitEvent) {
        this.player = player;
        this.timestamp = timestamp;
        this.bukkitEvent = bukkitEvent;
    }

    /**
     * Gets the static handler list for this event type.
     *
     * @return the static handler list
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Gets the list of handlers for this event instance.
     *
     * @return the handler list
     */
    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
