package me.nanigans.pandorapunishments.Commands;

import me.nanigans.pandorapunishments.PandoraPunishments;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Punish implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equals("punish")){

            if(sender instanceof Player){

                Player player = ((Player) sender);
                if(PandoraPunishments.hasPerms(player, "PUNISH.PUNISH")){



                }else{
                    player.sendMessage(ChatColor.RED+"Invalid Permissions");
                }

            }else{
                sender.sendMessage(ChatColor.RED+"Only players may use this command");
            }

        }

        return false;
    }
}
