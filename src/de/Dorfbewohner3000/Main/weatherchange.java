package de.Dorfbewohner3000.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class weatherchange implements Listener{
    @EventHandler
    public void weatherch(WeatherChangeEvent e){
        e.setCancelled(true);
    }
}
