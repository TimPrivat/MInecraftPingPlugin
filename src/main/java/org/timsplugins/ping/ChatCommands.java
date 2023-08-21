package org.timsplugins.ping;

import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
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
            String command = "ping " + inet.toString().replaceAll("/", "") + " -c 1";
            Bukkit.getLogger().info("Command: " + command);
            String pingString = execCmd(command);
            Bukkit.getLogger().info("PingString: " + pingString);

            int begin = pingString.indexOf("time=") + 5;
            int end = pingString.indexOf("ms");


            Double finalpingDouble = Double.parseDouble(pingString.substring(begin, end));

            //rundet immer auf weil Pessimismus
            long finalping = Math.round(finalpingDouble + 0.5);
            p.sendMessage("Dein Ping beträgt: " + org.bukkit.ChatColor.GREEN + finalping + "ms");

        } catch (Exception e) {

            Bukkit.getLogger().info(e.getMessage());


        }


    }

    public void firework(CommandSender sender, Color c, @Nullable Integer x, @Nullable Integer y, @Nullable Integer z) {

        Player p = (Player) sender;
        Location loc = p.getLocation();
        Vector v1;

        Location offsetLocation;
        if (x == null) {

            //Zündet die Rakete in Blickrichtung
            v1 = p.getEyeLocation().getDirection();
            v1.normalize();
            v1.setX((v1.getX() * 25) + loc.getX());
            v1.setZ((v1.getZ() * 25) + loc.getZ());

        } else {

            //Zündet die Rakete in Richtung des übergebenen Punktes
            v1 = new Vector(x - loc.getX(), y - loc.getY(), z - loc.getZ());
            p.sendMessage("Entfernung " + v1.length());
            if (v1.length() < 25) {
                offsetLocation = new Location(p.getWorld(), x, y, z);
            } else {
                v1.normalize();
                v1.setX((v1.getX() * 25) + loc.getX());
                v1.setZ((v1.getZ() * 25) + loc.getZ());

            }


        }
        // Spawnt die Rakete immer in einem Luftblock, damit sie nicht hängen bleibt
        double yWertFree = loc.getY();

        while (p.getWorld().getBlockAt((int) v1.getX(), (int) yWertFree, (int) v1.getZ()).getType() != Material.AIR) {

            yWertFree++;
        }


        offsetLocation = new Location(p.getWorld(), v1.getX(), yWertFree, v1.getZ());

        // p.sendMessage("Spawned at " + offsetLocation.toString());


        Firework f = (Firework) p.getWorld().spawnEntity(offsetLocation, EntityType.FIREWORK);
        FireworkMeta fwm = f.getFireworkMeta();
        fwm.setPower(2);
        f.detonate();
        f.setMaxLife(30);
        fwm.addEffect(FireworkEffect.builder().withColor(c).flicker(true).build());
        f.setFireworkMeta(fwm);


    }

    public void setWayPoint(CommandSender sender) {

        Player p = (Player) sender;
        p.sendMessage(ServerPlugin.defaultDirectory);

    }

    public static String execCmd(String cmd) throws java.io.IOException {
        Bukkit.getLogger().info("Command " + cmd);

        java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
        String ergebnis = "";
        while (s.hasNext())
            ergebnis = ergebnis + s.next();

        return ergebnis;
    }

}
