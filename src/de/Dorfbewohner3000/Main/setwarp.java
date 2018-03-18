package de.Dorfbewohner3000.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class setwarp implements CommandExecutor{
    File file = new File("plugins/Lobby-System/", "config.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("Lobby.setwarp")){
                if(args.length != 3){
                    p.sendMessage("§cUse: /setwarp (slot) (item-id) (Command)");
                }else{
                    String slot = args[0];
                    String id = args[1];
                    String Command = args[2];
                    cfg.set("Teleporter.Item."+slot+".id", id);
                    cfg.set("Teleporter-Item."+slot+".cmd", Command);
                    p.sendMessage("§c$lSuccess");
                }
            }
        }
        return true;
    }
}
