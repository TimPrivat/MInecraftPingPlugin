package org.timsplugins.ping;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerPlugin extends JavaPlugin {
ChatCommands chatCommands = new ChatCommands();
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


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // TODO Auto-generated method stub

        switch (command.getName()){

            case "ping":
                chatCommands.ping(sender);
                return true;


        }

        return false;


    }
}

