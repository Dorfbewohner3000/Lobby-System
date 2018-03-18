package de.Dorfbewohner3000.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class invclickevent implements Listener{
    @EventHandler
    public void invclickevent(InventoryClickEvent e){
            if(!utils.build.contains((Player) e.getWhoClicked())){
                if(e.getInventory().getName().equalsIgnoreCase(Main.Teleportername)){
                    if(e.getCurrentItem().getType() == Material.MAGMA_CREAM){
                        e.getWhoClicked().teleport(e.getWhoClicked().getWorld().getSpawnLocation());
                    }
                }
                e.setCancelled(true);
            }
    }
}
