package de.Dorfbewohner3000.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class foodlost implements Listener{
    @EventHandler
    public void foodlost (FoodLevelChangeEvent e){
        if(!utils.build.contains((Player) e.getEntity())){
            e.setCancelled(true);
        }
    }
}
