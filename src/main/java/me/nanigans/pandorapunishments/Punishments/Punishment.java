package me.nanigans.pandorapunishments.Punishments;

import me.nanigans.pandorapunishments.PandoraPunishments;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public abstract class Punishment implements Listener {

    protected long duration;
    protected String reason;
    protected PunishmentTypes punishment;
    protected OfflinePlayer punished;
    protected Player staff;
    protected Inventory inventory;
    protected PandoraPunishments plugin = PandoraPunishments.getPlugin(PandoraPunishments.class);

    public Punishment(OfflinePlayer punished, Player staff) {
        this.punished = punished;
        this.staff = staff;
        this.inventory = createInventory();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    protected abstract void punishPlayer();

    @EventHandler
    protected abstract void inventoryClick(InventoryClickEvent event);

    protected abstract Inventory createInventory();

}
