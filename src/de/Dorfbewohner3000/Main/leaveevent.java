package de.Dorfbewohner3000.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class leaveevent implements Listener{
    @EventHandler
    public void leaveev(PlayerQuitEvent e){
        e.setQuitMessage("");

    }
}
