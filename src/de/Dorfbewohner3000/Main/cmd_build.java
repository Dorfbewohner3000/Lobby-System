package de.Dorfbewohner3000.Main;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmd_build implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if(cmd.getName().equalsIgnoreCase("build")){
            if(sender.hasPermission("lobby.build")){
            Player p = (Player) sender;
            if(utils.build.contains(p)){
                utils.build.remove(p);
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(Main.buildmodedisabled);
            }else {
                p.setGameMode(GameMode.CREATIVE);
                utils.build.add(p);
                p.sendMessage("Das Build-Modus wurde aktiviert!");
            }
            }
        }
        return true;
    }
}
