package me.nanigans.pandorapunishments.Punishments;

import me.nanigans.pandorapunishments.JsonUtils;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Map;

public class PunishmentList extends Punishment implements Listener {

    Inventory inv;

    public PunishmentList(OfflinePlayer punished, Player staff) {
        super(punished, staff);
    }

    @Override
    protected void punishPlayer() {
    }

    @EventHandler
    @Override
    protected void inventoryClick(InventoryClickEvent event) {

    }

    @Override
    protected Inventory createInventory() {
        try {
            final Map<String, Object> data = (Map<String, Object>) JsonUtils.getData("");
            System.out.println("data = " + data);

        }catch(IOException | ParseException err){
            err.printStackTrace();
        }

        return null;
    }
}
