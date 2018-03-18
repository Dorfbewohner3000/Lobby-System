package de.Dorfbewohner3000.Main;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class MoveEvent implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location loc = p.getLocation();
        if ((loc.subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.GOLD_BLOCK)) {
            Vector v = p.getLocation().getDirection().multiply(3).setY(1.0D);
            e.getPlayer().setVelocity(v);
            e.getPlayer().playEffect(e.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 5);
            e.getPlayer().playSound(e.getPlayer().getLocation(), org.bukkit.Sound.ENDERDRAGON_WINGS, 5.0F, 2.0F);
        }
        if(Main.Border){
            if(loc.distance(p.getWorld().getSpawnLocation()) > Main.Borderradius & (!utils.build.contains(p))){
                p.teleport(p.getWorld().getSpawnLocation());
                p.sendMessage(Main.Bordermessage);
            }
        }
    }
}