package de.Dorfbewohner3000.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class damageevent implements Listener{
    @EventHandler
    public void damageevent (EntityDamageEvent e){
        if(e.getEntity() instanceof Player) {
            if (!utils.build.contains((Player) e.getEntity())) {
                e.setCancelled(true);
            }
        }
    }
}
