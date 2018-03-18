package de.Dorfbewohner3000.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class opencompass {
    public static Inventory com(Player p){
        Inventory inv = p.getServer().createInventory(null, 27, Main.Teleportername);

        for(int i = 1; i < 27;i++){

        }

        return inv;
    }
}
