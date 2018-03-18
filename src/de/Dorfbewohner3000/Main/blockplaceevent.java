package de.Dorfbewohner3000.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class blockplaceevent implements Listener{
    @EventHandler
    public void blockplace(BlockPlaceEvent e){
        if(!utils.build.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
}
