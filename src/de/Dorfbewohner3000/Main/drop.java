package de.Dorfbewohner3000.Main;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class drop implements Listener{
    @EventHandler
    public void dropevent(PlayerDropItemEvent e){
        if(!utils.build.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
}
