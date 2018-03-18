package de.Dorfbewohner3000.Main;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.LinkedList;
import java.util.List;

public class joinevent implements Listener{
    @EventHandler
    public void joinevent(PlayerJoinEvent e){
        e.setJoinMessage("");
        Player p = e.getPlayer();
        //Main.prefix_map.put(p, "§7"+CloudAPI.getInstance().getOnlinePlayer(p.getUniqueId()).getPermissionEntity().getHighestPermissionGroup(CloudAPI.getInstance().getPermissionPool()).getName().replaceAll("&", "§"));
        Inventory inv = p.getInventory();
        inv.clear();
        p.setGameMode(GameMode.ADVENTURE);
        p.teleport(p.getWorld().getSpawnLocation());
        p.setCompassTarget(p.getWorld().getSpawnLocation());
        p.setPlayerTime(0L, true);
        p.setAllowFlight(true);
        p.setHealth(20);
        p.setFoodLevel(20);

        if(Main.Teleporter) {
            inv.setItem(Main.Teleporterslot-1, item(Main.Teleportername, "§8", Material.COMPASS, 1, (short) 0));
        }

        if(Main.playerhideitem) {
            inv.setItem((Main.playerhideitemslot-1), item("§aPlayer ⤇ Enabled", "§8", Material.GLOWSTONE_DUST, 1, (short) 0));
        }
        if(Main.Friends) {
            ItemStack i1 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta i1m = (SkullMeta) i1.getItemMeta();
            i1m.setDisplayName(Main.Friendsname);
            i1m.setOwner(p.getPlayer().getName());
            List<String> i1ml = new LinkedList<>();
            i1ml.add("§8");
            i1m.setLore(i1ml);
            i1.setItemMeta(i1m);
            inv.setItem(Main.Friendsslot-1, i1);
        }
        //Main.Scoreboard(p);
    }
    public static ItemStack item(String name, String lore, Material item, int menge, short itemshort){
        ItemStack is = new ItemStack(item, menge, itemshort);
        ItemMeta im = is.getItemMeta();
        List<String> l = new LinkedList<>();
        l.add(lore);
        im.setLore(l);
        im.setDisplayName(name);
        is.setItemMeta(im);
        return is;
    }
}
