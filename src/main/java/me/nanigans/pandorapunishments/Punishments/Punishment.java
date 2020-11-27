package me.nanigans.pandorapunishments.Punishments;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public abstract class Punishment implements Listener {

    private long duration;
    private String reason;
    private PunishmentTypes punishment;
    private Player punished;

    abstract void punishPlayer();

    @EventHandler
    abstract void inventoryClick(InventoryClickEvent event);

    abstract void createInventory();

}
