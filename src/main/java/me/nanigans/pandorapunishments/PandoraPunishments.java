package me.nanigans.pandorapunishments;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import me.TechsCode.UltraPermissions.UltraPermissions;
import me.nanigans.pandorapunishments.Commands.Punish;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class PandoraPunishments extends JavaPlugin {
    GsonBuilder gsonBuilder = new GsonBuilder()
            .registerTypeAdapter(new TypeToken<Map<String, Object>>(){}.getType(),  new CustomizedObjectTypeAdapter());
    public Map<String, Object> map = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("punish").setExecutor(new Punish());

        File configFile = new File(getDataFolder(), "Punishments.json");

        if (!configFile.exists()) {

            saveResource(configFile.getName(), false);
            try {
                Gson gson = gsonBuilder.create();

                map = gson.fromJson(new FileReader(configFile), HashMap.class);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static boolean hasPerms(Player player, String permission){

        return UltraPermissions.getAPI().getUsers().uuid(player.getUniqueId()).getGroups().stream().flatMap(j -> j.getAdditionalPermissions().stream()).anyMatch(j -> j.getName().equals(permission))
                || UltraPermissions.getAPI().getUsers().uuid(player.getUniqueId()).getGroups().stream().flatMap(j -> j.getPermissions().stream()).anyMatch(j -> j.getName().equals(permission))
                || UltraPermissions.getAPI().getUsers().uuid(player.getUniqueId()).getAllPermissions().stream().anyMatch(j -> j.getName().equals(permission));

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
