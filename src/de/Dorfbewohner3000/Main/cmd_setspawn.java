package de.Dorfbewohner3000.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmd_setspawn implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if(sender.hasPermission("Lobby.setspawn")) {
            Player p = (Player) sender;
            p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
            p.sendMessage("&c&lSuccess");
        }
        return true;
    }
}
