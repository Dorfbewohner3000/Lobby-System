package de.Dorfbewohner3000.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class blockbreakevent implements Listener{
    @EventHandler
    public void blockbreakevent(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(!utils.build.contains(p)){
            e.setCancelled(true);
        }
    }
}
