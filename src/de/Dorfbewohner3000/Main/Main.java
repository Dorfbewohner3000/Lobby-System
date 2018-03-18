package de.Dorfbewohner3000.Main;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

import java.io.File;
import java.util.HashMap;

public class Main extends JavaPlugin{
    public static HashMap<Player, String> prefix_map = new HashMap<>();
    File file = new File(getDataFolder(), "config.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    public static String ServerName;
    public static Boolean playerhideitem;
    public static String servername = "null";
    public static int playerhideitemslot;
    public static Boolean Teleporter;
    public static String Teleportername;
    public static int Teleporterslot;
    public static Boolean Friends;
    public static String Friendsname;
    public static int Friendsslot;
    public static Boolean Border;
    public static String Bordermessage;
    public static int Borderradius;
    public static String buildmodeenabled;
    public static String buildmodedisabled;
    public static String setspawnmessage;
    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        System.out.println("Plugin Enabled");
        pm.registerEvents(new MoveEvent(), this);
        pm.registerEvents(new invclickevent(), this);
        pm.registerEvents(new drop(), this);
        pm.registerEvents(new damageevent(), this);
        pm.registerEvents(new blockbreakevent(), this);
        pm.registerEvents(new MoveEvent(), this);
        pm.registerEvents(new blockbreakevent(), this);
        pm.registerEvents(new interactevent(), this);
        pm.registerEvents(new joinevent(), this);
        pm.registerEvents(new leaveevent(), this);
        pm.registerEvents(new toggleflightev(), this);
        pm.registerEvents(new foodlost(), this);
        pm.registerEvents(new damageevent(), this);
        pm.registerEvents(new weatherchange(), this);


        getCommand("setspawn").setExecutor(new cmd_setspawn());
        getCommand("build").setExecutor(new cmd_build());
        createConfig();
    }
    public void createConfig(){
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            FileConfiguration cfg = getConfig();
            if (!file.exists()) {
                getLogger().info("Config not found! Creating config...");
                file.createNewFile();
                cfg.set("Server-Name", "Server");
                cfg.set("Player-Hide-Item.Enable", "true");
                cfg.set("Player-Hide-Item.Slot", "5");
                cfg.set("Teleporter.Enable", "true");
                cfg.set("Teleporter.Slot", "1");
                cfg.set("Teleporter.Name", "&6Teleporter");
                cfg.set("Friends.Enable", "true");
                cfg.set("Friends.Name", "&6Friends");
                cfg.set("Friends.Slot", "9");
                cfg.set("Border.Enable", "true");
                cfg.set("Border.Radius", "50");
                cfg.set("Border.Message", "&4You cant leave the Lobby");
                cfg.set("Build.msg.Enabled", "&6You are now in Build-Mode");
                cfg.set("Build.msg.Disabled", "&cYou disabled Build-Mode");
                cfg.save(file);
            } else {
                getLogger().info("Loading config!");
            }
            servername = getConfig().getString("Server-Name");
            playerhideitem = Boolean.valueOf(getConfig().getString("Player-Hide-Item.Enable"));
            playerhideitemslot = Integer.parseInt(getConfig().getString("Player-Hide-Item.Slot"));
            Teleporter = Boolean.valueOf(getConfig().getString("Teleporter.Enable"));
            Teleportername = getConfig().getString("Teleporter.Name").replaceAll("&", "§");
            Teleporterslot = Integer.parseInt(getConfig().getString("Teleporter.Slot"));
            ServerName = getConfig().getString("Server-Name").replaceAll("&", "§");
            Friends = Boolean.valueOf(getConfig().getString("Friends.Enable"));
            Friendsname = getConfig().getString("Friends.Name").replaceAll("&", "§");
            Friendsslot = Integer.parseInt(getConfig().getString("Friends.Slot"));
            Border = Boolean.valueOf(getConfig().getString("Border.Enable"));
            Bordermessage = getConfig().getString("Border.Message").replaceAll("&", "§");
            Borderradius = Integer.parseInt(getConfig().getString("Border.Radius"));
            buildmodeenabled = getConfig().getString("Build.msg.Enabled").replaceAll("&", "§");
            buildmodedisabled = getConfig().getString("Build.msg.Disabled").replaceAll("&", "§");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public static void Scoreboard(Player p){
        ScoreboardManager sm = Bukkit.getScoreboardManager();
        Scoreboard board = sm.getNewScoreboard();
        Objective score = board.registerNewObjective("aaa", "bbb");
        score.setDisplayName("§8⇒ "+ServerName);
        score.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score r_u = score.getScore("§6§lRang:");
        Score r = score.getScore("§6"+Main.prefix_map.get(p));
        //-----
        Score c_u = score.getScore("§6§lCoins:");
        Score c = score.getScore("§70");



        r_u.setScore(4);
        r.setScore(3);
        c_u.setScore(2);
        c.setScore(1);
        p.setScoreboard(board);
    }
}
