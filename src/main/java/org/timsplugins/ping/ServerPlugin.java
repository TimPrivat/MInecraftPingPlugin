package org.timsplugins.ping;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public final class ServerPlugin extends JavaPlugin {
    ChatCommands chatCommands = new ChatCommands();
    public static final String defaultDirectory = System.getProperty("user.dir");

    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();
        Bukkit.getLogger().info("Starte Plugin");
        new EventListener(this);





    }


    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Stoppe Plugin");
    }


    public static ArrayList<Player> getOnlinePlayers() {
        Collection<? extends Player> playercollection = Bukkit.getOnlinePlayers();
        ArrayList<Player> players = new ArrayList(playercollection);
        return players;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // TODO Auto-generated method stub

        switch (command.getName()) {

            case "ping":
                chatCommands.ping(sender);
                return true;
            case "firework":
                if(args.length ==0)
                    chatCommands.firework(sender,Color.PURPLE, null,null,null);
                else
                chatCommands.firework(sender,Color.PURPLE, Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
                return true;
            case "setWayPoint":
                chatCommands.setWayPoint(sender);
                return true;


        }

        return false;


    }
}

