package org.timsplugins.ping;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.net.*;
import java.util.Date;

public class ChatCommands {

    public void ping(CommandSender sender) {

        Player p = (Player) sender;
        InetAddress inet = p.getAddress().getAddress();
        Date start = new Date();
        long ping = 0;
        try {
            inet.isReachable(5000);
            Date stop = new Date();
            ping = stop.getTime() - start.getTime();


        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        p.sendMessage("Dein Ping beträgt: " + org.bukkit.ChatColor.GREEN + ping + "ms");


    }

}
