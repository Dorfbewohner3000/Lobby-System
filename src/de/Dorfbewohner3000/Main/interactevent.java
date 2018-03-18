package de.Dorfbewohner3000.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class interactevent implements Listener{
    @EventHandler
    public void interact (PlayerInteractEvent e){
        Player p = (Player) e.getPlayer();
        if(!utils.build.contains(p)) {
            if ((e.getAction() == Action.LEFT_CLICK_AIR) | (e.getAction() == Action.LEFT_CLICK_BLOCK) | (e.getAction() == Action.RIGHT_CLICK_AIR) | (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {

                if(e.getMaterial().equals(Material.GLOWSTONE_DUST)){
                    for(Player t : Bukkit.getOnlinePlayers()){
                        p.hidePlayer(t);
                    }
                    p.getInventory().setItem(4, joinevent.item("§cPlayer ⤇ Disabled", "§8", Material.SULPHUR, 1, (short)0));
                }

                if(e.getMaterial().equals(Material.SULPHUR)){
                    for(Player t : Bukkit.getOnlinePlayers()){
                        p.showPlayer(t);
                    }
                    p.getInventory().setItem(4, joinevent.item("§6Player ⤇ Enabled", "§8", Material.GLOWSTONE_DUST, 1, (short)0));
                }

                if(e.getMaterial().equals(Material.COMPASS)){
                    p.updateInventory();
                    p.openInventory(opencompass.com(p));
                }
                e.setCancelled(true);
            }
        }
    }
}
