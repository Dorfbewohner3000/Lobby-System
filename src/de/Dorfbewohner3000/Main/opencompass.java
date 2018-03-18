package de.Dorfbewohner3000.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class opencompass {
    public static Inventory com(Player p){
        Inventory inv = p.getServer().createInventory(null, 27, Main.Teleportername);

        inv.setItem(4, joinevent.item("§6Spawn", "§7", Material.MAGMA_CREAM,1, (short)0 ));


        return inv;
    }
}
