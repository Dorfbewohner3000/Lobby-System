package de.Dorfbewohner3000.Main;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;


public class toggleflightev implements Listener{
    @EventHandler
    public void tooglefly(PlayerToggleFlightEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode().equals(GameMode.CREATIVE)){
            return;
        }
        if(!(p.getLocation().subtract(0,2,0).getBlock().getType() == Material.AIR)) {
            org.bukkit.util.Vector v = p.getLocation().getDirection();
            v.setY(1);
            p.setVelocity(v);
        }
        e.setCancelled(true);
    }
}
